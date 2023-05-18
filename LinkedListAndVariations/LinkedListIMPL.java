package estudosLeda;

public class LinkedListIMPL<T extends Comparable<T>> implements LinkedListMerge<T>{
    
	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2){
		
		SingleLinkedListNode<T> encadeamento = new SingleLinkedListNode<T>();
		SingleLinkedListNode<T> firstNode = new SingleLinkedListNode<T>();
		
		if (node1.isNIL() && node2.isNIL()) {
			return null;
		}
		else if (node1.isNIL()) {
			firstNode.setData(node2.getData());
			node2 = node2.next;
		}
		else if (node2.isNIL()) {
			firstNode.setData(node1.getData());
			node1 = node1.next;
		}
		else if (node1.getData().compareTo(node2.getData()) <= 0) {
			firstNode.setData(node1.getData());
			node1 = node1.next;
		}
		else {
			firstNode.setData(node2.getData());
			node2 = node2.next;
		}
		
		firstNode.setNext(encadeamento);
		
		while (node1 != null && node2 != null && !node1.isNIL() && !node2.isNIL()) {
			
			if (node1.getData().compareTo(node2.getData()) <= 0) {
				encadeamento.setData(node1.getData());
				if (node1.next != null) {
					node1 = node1.next;
				}
				else {
					node1.setNext(new SingleLinkedListNode<T>());
				}
			}
			else {
				encadeamento.setData(node2.getData());
				if (node2.next != null) {
					node2 = node2.next;
				}
				else {
					node2.setNext(new SingleLinkedListNode<T>());
				}
			}
			
			encadeamento.setNext(new SingleLinkedListNode<T>());
			encadeamento = encadeamento.getNext();
		}
    
		while (node1.getData() != null) {
			encadeamento.setData(node1.getData());
			node1 = node1.next;
			
			if (node1.getData() != null && node1.next != null) {
				encadeamento.setNext(new SingleLinkedListNode<T>());
				encadeamento = encadeamento.getNext();
			}
		}
		
		while (node2.getData() != null) {
			encadeamento.setData(node2.getData());
			node2 = node2.next;
			
			if (node2.getData() != null && node2.next != null) {
				encadeamento.setNext(new SingleLinkedListNode<T>());
				encadeamento = encadeamento.getNext();
			}
		}
		
		return firstNode;
	}
	
	public static void main(String[] args) {
		SingleLinkedListNode<Integer> l1 = new SingleLinkedListNode<>();
		SingleLinkedListNode<Integer> l2 = new SingleLinkedListNode<>();
		
		l1.add(1);
		l1.add(3);
		l1.add(5);
		
		l2.add(2);
		l2.add(4);
		l2.add(6);
		
		LinkedListIMPL<Integer> teste = new LinkedListIMPL<>();
		
		SingleLinkedListNode<Integer> result = teste.merge(l1, l2);
		System.out.println("RETORNO: " + result.getData());
		while (result != null && !result.isNIL()) {
			System.out.println(result.getData());
			result = result.next;
		}
	}
	
}