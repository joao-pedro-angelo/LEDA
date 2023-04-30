package binarySearchAndVariations;

public class LastOccurrence {
	
	public static int lastOccurrence(int[] array, int n) {
		int result = -1;
		if (array != null && array.length > 0) {
			
			int left = 0;
			int right = array.length - 1;
			
			while (left <= right) {
				int middle = (left + right) / 2;
				
				if (array[middle] < n) {
					left = middle + 1;
				}
				else if (array[middle] > n) {
					right = middle - 1;
				}
				else{
					result = middle;
					left = middle + 1;
				}
			}
		} return result;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {0, 1, 1, 1, 2, 2, 3, 3, 10, 10, 10, 12};
		int[] arrayVazio = new int[] {};
		
		System.out.println(lastOccurrence(array, 0)); //0
		System.out.println(lastOccurrence(array, 1)); //3
		System.out.println(lastOccurrence(array, 2)); //5
		System.out.println(lastOccurrence(array, 3)); //7
		System.out.println(lastOccurrence(array, 10)); //10
		System.out.println(lastOccurrence(array, 12)); //11
		System.out.println(lastOccurrence(arrayVazio, 10)); //-1 
	}
	
}
