package adt.bst;

/**
 * - Esta eh a unica classe que pode ser modificada 
 * @author adalbertocajueiro
 *
 * @param <T>
 */
public class SimpleBSTManipulationImpl<T extends Comparable<T>> implements SimpleBSTManipulation<T> {

	@Override
	public boolean equals(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = equals((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}
	

	private boolean equals(BSTNode<T> root1, BSTNode<T> root2) {
		boolean result = false;
		if (root1.isEmpty() && root2.isEmpty()) {
			result = true;
		}
		else if (!root1.isEmpty() && !root2.isEmpty()) {
			if (root1.equals(root2)) {
				result = equals((BSTNode<T>) root1.getLeft(), (BSTNode<T>) root2.getLeft())
						&& equals((BSTNode<T>) root1.getRight(), (BSTNode<T>) root2.getRight());
			}
		}
		
		return result;
	}


	@Override
	public boolean isSimilar(BST<T> tree1, BST<T> tree2) {
		boolean result = false;
		if (tree1 != null && tree2 != null) {
			result = isSimilar((BSTNode<T>) tree1.getRoot(), (BSTNode<T>) tree2.getRoot());
		}
		return result;
	}

	private boolean isSimilar(BSTNode<T> node1, BSTNode<T> node2) {
		boolean status = false;

		if (node1.isEmpty() && node2.isEmpty()) {
			status = true;
		} else if (!node1.isEmpty() && !node2.isEmpty()) {
			status = isSimilar((BSTNode<T>) node1.getLeft(), (BSTNode<T>) node2.getLeft())
					&& isSimilar((BSTNode<T>) node1.getRight(), (BSTNode<T>) node2.getRight());
		}

		return status;
	}

	@Override
	public T orderStatistic(BST<T> tree, int k) {
		T orderStatistic = null;
		if (tree != null) {
			int size = tree.size();
			if (k >= 1 && k <= size) {
				if (k == 1) {
					orderStatistic = tree.minimum().getData();
				} else if (k == size) {
					orderStatistic = tree.maximum().getData();
				} else {
					orderStatistic = this.orderStatistic(tree, tree.minimum(), k);
				}
			}
		}

		return orderStatistic;
	}

	private T orderStatistic(BST<T> tree, BSTNode<T> node, int k) {
		T orderStatistic = null;
		if (k == 1) {
			orderStatistic = node.getData();
		} else {
			k -= 1;
			orderStatistic = this.orderStatistic(tree, tree.sucessor(node.getData()), k);
		}
		return orderStatistic;
	}

}
