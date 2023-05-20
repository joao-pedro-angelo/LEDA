public class MergeSingleLinkedList<T extends Comparable<T>>{
    
	public SingleLinkedListNode<T> merge(SingleLinkedListNode<T> node1, SingleLinkedListNode<T> node2){
		
		
		SingleLinkedListNode<T> encadeamento = new SingleLinkedListNode<T>();
		SingleLinkedListNode<T> firstNode = new SingleLinkedListNode<T>();
		
		if (node1.isNIL() && node2.isNIL()) {
			return null;
		}
		else if (node1.isNIL()) {
			firstNode.setData(node2.getData());
			node2 = node2.getNext();
		}
		else if (node2.isNIL()) {
			firstNode.setData(node1.getData());
			node1 = node1.getNext();
		}
		else if (node1.getData().compareTo(node2.getData()) <= 0) {
			firstNode.setData(node1.getData());
			node1 = node1.getNext();
		}
		else {
			firstNode.setData(node2.getData());
			node2 = node2.getNext();
		}
		
		firstNode.setNext(encadeamento);
		
		while (!node1.isNIL() && !node2.isNIL()) {
			if (node1.getData().compareTo(node2.getData()) <= 0) {
				encadeamento.setData(node1.getData());
				node1 = node1.getNext();
			}
			else {
				encadeamento.setData(node2.getData());
				node2 = node2.getNext();
			}
			
			encadeamento.setNext(new SingleLinkedListNode<T>());
			encadeamento = encadeamento.getNext();
		}
		
		while (!node1.isNIL()) {
			encadeamento.setData(node1.getData());
			if ((node1.getNext() != null)) {
				encadeamento.setNext(new SingleLinkedListNode<T>());
				encadeamento = encadeamento.getNext();
			}
			node1 = node1.getNext();
		}
		
		while (!node2.isNIL()) {
			encadeamento.setData(node2.getData());
			if ((node2.getNext() != null)) {
				encadeamento.setNext(new SingleLinkedListNode<T>());
				encadeamento = encadeamento.getNext();
			}
			node2 = node2.getNext();
		}
		
		return firstNode;
	}
	
	public static void main(String[] args) {
		MergeSingleLinkedList<Integer> teste = new MergeSingleLinkedList<>();
		
		SingleLinkedListNode<Integer> node1 = new SingleLinkedListNode<>();
		node1.add(1);
		node1.add(3);
		node1.add(5);
		
		SingleLinkedListNode<Integer> node2 = new SingleLinkedListNode<>();
		node2.add(2);
		node2.add(4);
		node2.add(6);
		
		SingleLinkedListNode<Integer> nodeResult = teste.merge(node1, node2);
		
		System.out.println("RETORNO: " + nodeResult.getData());
		
		while (nodeResult != null && !nodeResult.isNIL()) {
			System.out.println(nodeResult.getData());
			nodeResult = nodeResult.getNext();
		}
		
	}
	
}
