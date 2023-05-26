package problem;

import linkedList.SingleLinkedListNode;

public class Main {

	public static void main(String[] args) {
		
		Solucao<Integer> teste = new Solucao<>();
		SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> node3 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> node4 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> node5 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> node6 = new SingleLinkedListNode<>();
		
		node1.setData(1);
		node2.setData(1);
		node3.setData(1);
		node4.setData(1);
		node5.setData(1);
		node6.setData(1);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(new SingleLinkedListNode<>());

		teste.removeDuplicates(node1);
		
		while (!node1.isNIL()) {
			System.out.println(node1.getData());
			node1 = node1.getNext();
		}
	}

}
