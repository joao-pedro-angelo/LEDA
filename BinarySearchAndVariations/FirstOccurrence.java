package binarySearchAndVariations;

public class FirstOccurrence {
	
	 // RETORNA ÍNDICE DA PRIMEIRA OCORRÊNCIA DE UM NÚMERO
    public static int firstOccurrence(int[] array, int key) {
        int result = -1;
    	if (array != null && array.length > 0) {
    	   
    	   int left = 0;
    	   int right = array.length - 1;
    	   
    	   while (left <= right) {
    		   int middle = (left + right) / 2;
    		   
    		   if (array[middle] < key) {
    			   left = middle + 1;
    		   } 
    		   else if (array[middle] > key) {
    			   right = middle - 1;
    		   }
    		   else {
    			   result = middle;
    			   right = middle - 1;
    		   }
    	   }
       } return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 1, 1, 1, 2, 3, 4 };

        int res = firstOccurrence(array, 1);
        System.out.println(res); // 1

        res = firstOccurrence(array, 4);
        System.out.println(res); // 7

        res = firstOccurrence(array, 3);
        System.out.println(res); // 6

        res = firstOccurrence(array, 0);
        System.out.println(res); // 0

        res = firstOccurrence(array, 50);
        System.out.println(res); // -1

        res = firstOccurrence(array, -50);
        System.out.println(res); // -1
    }
}
