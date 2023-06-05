package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
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
