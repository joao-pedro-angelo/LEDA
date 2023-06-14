package adt.bst;

import java.util.ArrayList;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return this.root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.getRoot());
	}
	
	private int height(BSTNode<T> node) {
		int height = -1;
		if (!node.isEmpty()) {
			height = 1 + Math.max(height((BSTNode<T>) node.getLeft()), height((BSTNode<T>) node.getRight()));
		}
		return height;
	}

	@Override
	public BSTNode<T> search(T element) {
		return this.search(this.getRoot(), element);
	}
	
	private BSTNode<T> search(BSTNode<T> node, T element){
		BSTNode<T> result = new BSTNode<>();
		if (element != null && !node.isEmpty()) {
			if (node.getData().compareTo(element) == 0) result = node;
			else if (node.getData().compareTo(element) > 0) result = this.search((BSTNode<T>) node.getLeft(), element);
			else result = this.search((BSTNode<T>) node.getRight(), element);
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null && search(element).isEmpty()) {
			this.insert(this.getRoot(), element);
		}
	}
	
	private void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.getRight().setParent(node);
		}
		else {
			if (node.getData().compareTo(element) > 0) this.insert((BSTNode<T>) node.getLeft(), element);
			else this.insert((BSTNode<T>) node.getRight(), element);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.maximum(this.getRoot());
		}
		return result;
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> result = node;
		if (!node.getRight().isEmpty()) {
			result = this.maximum((BSTNode<T>) node.getRight());
		}
		return result;
	}

	@Override
	public BSTNode<T> minimum() {
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.minimum(this.getRoot());
		}
		return result;
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = this.minimum((BSTNode<T>) node.getLeft());
		}
		return result;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) result = this.minimum((BSTNode<T>) node.getRight());
			else result = sucessor((BSTNode<T>) node.getParent(), element);
		}
		return result;
	}

	private BSTNode<T> sucessor(BSTNode<T> parent, T element) {
		BSTNode<T> result = null;
		if (parent == null || parent.isEmpty() || parent.getData().compareTo(element) > 0) {
			result = parent;
		} else {
			result = sucessor((BSTNode<T>) parent.getParent(), element);
		}
		return result;
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) {
				result = this.maximum((BSTNode<T>) node.getLeft());
			} else {
				result = this.predecessor((BSTNode<T>) node.getParent(), element);
			}
		}
		
		return result;
	}
	
	private BSTNode<T> predecessor(BSTNode<T> parent, T element){
		BSTNode<T> result = null;
		if (parent == null || parent.isEmpty() || parent.getData().compareTo(element) < 0) {
			result = parent;
		}
		else {
			result = this.predecessor((BSTNode<T>) parent.getParent(), element);
		}
		return result;
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = search(element);
		remove(node);
	}

	private boolean hasOnlyChild(BSTNode<T> node) {
		return (node.getLeft().isEmpty() && !node.getRight().isEmpty()) ||
				(!node.getLeft().isEmpty() && node.getRight().isEmpty());
	}

	private void remove(BSTNode<T> node) {
		if (node != null && !node.isEmpty()) {
			// Primeiro caso: nó é folha.
			if (node.isLeaf()) {
				node.setData(null);

				// Segundo caso: nó tem apenas um filho (esquerda ou direita)
			} else if (hasOnlyChild(node)) {
				if (node.getParent() != null) {
					if (node.getParent().getData().compareTo(node.getData()) > 0) {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setLeft(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setLeft(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					} else {
						if (!node.getLeft().isEmpty()) {
							node.getParent().setRight(node.getLeft());
							node.getLeft().setParent(node.getParent());
						} else {
							node.getParent().setRight(node.getRight());
							node.getRight().setParent(node.getParent());
						}
					}
				} else {
					if (node.getLeft().isEmpty()) {
						root = (BSTNode<T>) node.getRight();
						root.setParent(null);
					} else {
						root = (BSTNode<T>) node.getLeft();
						root.setParent(null);
					}
				}

				// Terceiro caso: Nó tem dois filhos
			} else {
				BSTNode<T> sucessor = sucessor(node.getData());
				node.setData(sucessor.getData());
				remove(sucessor);
			}
		}

	}
	@Override
	public T[] preOrder() {
		ArrayList<T> lista = new ArrayList<>();
		this.preOrder(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}
	
	private void preOrder(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			lista.add(node.getData());
			this.preOrder(lista, (BSTNode<T>) node.getLeft());
			this.preOrder(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] order() {
		ArrayList<T> lista = new ArrayList<>();
		this.order(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}
	
	private void order(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			this.order(lista, (BSTNode<T>) node.getLeft());
			lista.add(node.getData());
			this.order(lista, (BSTNode<T>) node.getRight());
		}
	}

	@Override
	public T[] postOrder() {
		ArrayList<T> lista = new ArrayList<>();
		this.postOrder(lista, this.getRoot());
		return (T[]) lista.toArray(new Comparable[lista.size()]);
	}
	
	private void postOrder(ArrayList<T> lista, BSTNode<T> node) {
		if (!node.isEmpty()) {
			this.postOrder(lista, (BSTNode<T>) node.getLeft());
			this.postOrder(lista, (BSTNode<T>) node.getRight());
			lista.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
