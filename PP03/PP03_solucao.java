package problems;
2   
3   import adt.bst.BST;
4   import adt.bst.BSTNode;
5   
6   public class BSTSumLeavesImpl implements BSTSumLeaves{
7       
8   	public int sumLeaves(BST<Integer> bst) {
9   		int result = 0;
10  		if (bst != null && !bst.isEmpty()) {
11  			result = sumLeaves((BSTNode<Integer>) bst.getRoot());
12  		}
13  		return result;
14  	}
15  	
16  	private int sumLeaves(BSTNode<Integer> node) {
17  		int soma = 0;
18  		if (!node.isEmpty()) {
19  			if (!node.isLeaf()) {
20  				soma += sumLeaves((BSTNode<Integer>) node.getRight());
21  				soma +=	sumLeaves((BSTNode<Integer>) node.getLeft());
22  			}else {
23  				soma += node.getData();
24  			}
25  		}
26  		return soma;
27  	}
28  
29  }


