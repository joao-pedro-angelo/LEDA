package problem;

import linkedList.SingleLinkedListNode;

public class MySolution<T> implements LinkedListRemoveDuplicates<T> {

    @Override
    public void removeDuplicates(SingleLinkedListNode<T> node) {
	if (node != null && !node.isNIL()) {
     	   
      	   while(!node.getNext().isNIL()) {
      		 SingleLinkedListNode<T> aux = node.getNext();
      		 while(!aux.isNIL()) {
      			 if (aux.getData().equals(node.getData()) && aux.getNext().isNIL()) {
      				 aux.setData(null);
      			 }
      			 else if (aux.getData().equals(node.getData())) {
      				 aux.setData(aux.getNext().getData());
      				 aux.setNext(aux.getNext().getNext());
      			 }
      			 else {
      				 aux = aux.getNext();
      			 }
      		 }
      	         node = node.getNext();
	   }  	   
	}
    }
	
}
