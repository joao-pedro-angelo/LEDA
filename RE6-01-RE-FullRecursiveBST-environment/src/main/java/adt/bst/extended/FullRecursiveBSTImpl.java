package adt.bst.extended;

import java.util.ArrayList;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FullRecursiveBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FullRecursiveBST<T> {

	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> maximum(){
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.maximum(this.getRoot());
		}
		return result;
	}
	
	private BSTNode<T> maximum(BSTNode<T> node){
		BSTNode<T> result = node;
		if (!node.getRight().isEmpty()) {
			result = maximum((BSTNode<T>) node.getRight());
		}
		return result;
	}
	
	/**
	 * Sobrescreva este metodo usando recursao.
	 */
	@Override
	public BSTNode<T> minimum(){
		BSTNode<T> result = null;
		if (!this.isEmpty()) {
			result = this.minimum(this.getRoot());
		}
		return result;
	}
	
	private BSTNode<T> minimum(BSTNode<T> node){
		BSTNode<T> result = node;
		if (!node.getLeft().isEmpty()) {
			result = minimum((BSTNode<T>) node.getLeft());
		}
		return result;
	}
	
	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a direita
	 * entao o sucessor sera o minimum do filho a direita. Caso contrario
	 * o sucessor sera o primeiro ascendente a ter um valor maior.
	 */
	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()) {
			if (!node.getRight().isEmpty()) result = this.minimum((BSTNode<T>) node.getRight());
			else result = this.sucessor((BSTNode<T>) node.getParent(), element);
		}
		
		return result;
	}
	
	private BSTNode<T> sucessor(BSTNode<T> node, T element){
		BSTNode<T> result = null;
		if (node == null || node.isEmpty() || node.getData().compareTo(element) > 0) {
			result = node;
		}
		else {
			result = this.sucessor((BSTNode<T>) node.getParent(), element);
		}
		return result;
	}

	/**
	 * Sobrescreva este metodo usando recursao. Quando um no tem filho a esquerda
	 * entao o predecessor sera o maximum do filho a esquerda. Caso contrario
	 * o predecessor sera o primeiro ascendente a ter um valor menor.
	 */
	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> result = null;
		BSTNode<T> node = search(element);
		
		if (!node.isEmpty()) {
			if (!node.getLeft().isEmpty()) result = this.maximum((BSTNode<T>) node.getLeft());
			else result = this.predecessor((BSTNode<T>) node.getParent(), element);
		}
		
		return result;
	}
	
	private BSTNode<T> predecessor(BSTNode<T> node, T element){
		BSTNode<T> result = null;
		if (node == null || node.isEmpty() || node.getData().compareTo(element) > 0) {
			result = node;
		} else {
			result = this.predecessor((BSTNode<T>) node.getParent(), element);
		}
		return result;
	}

	@Override
	public T[] elementsAtDistance(int k) {
		ArrayList<T> result = new ArrayList<>();
		if (!this.getRoot().isEmpty()) {
			buscaEmLarguraAdaptada(result, this.getRoot(), 0, k);
		}
		return (T[]) result.toArray(new Comparable[result.size()]);
	}

	private void buscaEmLarguraAdaptada(ArrayList<T> result, BSTNode<T> node, int level, int k) {
		if (!node.isEmpty()) {
			buscaEmLarguraAdaptada(result, (BSTNode<T>) node.getLeft(), level++, k);
			buscaEmLarguraAdaptada(result, (BSTNode<T>) node.getRight(), level++, k);
			
			if (k == level) {
				result.add(node.getData());
			}
		}
	}
	
	
}
