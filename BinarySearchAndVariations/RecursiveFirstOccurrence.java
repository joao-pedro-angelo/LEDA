package binarySearchAndVariations;

public class RecursiveFirstOccurrence {

	public static int recursiveFirstOccurrence(int[] array, int left, int right, int n) {
		if (array != null && array.length > 0 && left >= 0 && right < array.length && left <= right) {
			
			int middle = (left + right) / 2;
			if (array[middle] > n) {
				return recursiveFirstOccurrence(array, left, middle -1, n);
			} 
			else if (array[middle] < n) {
				return recursiveFirstOccurrence(array, middle + 1, right, n);
			}
			else if (left != middle) {
				return recursiveFirstOccurrence(array, left, middle, n);
			}
			else {
				return middle;
			}
			
		} return -1;
	}
	
	public static void main(String[] args) {
        int[] array = new int[] { 0, 1, 1, 1, 1, 2, 3, 4 };

        int res = recursiveFirstOccurrence(array, 0, 7, 1);
        System.out.println(res); // 1

        res = recursiveFirstOccurrence(array, 0, 7, 4);
        System.out.println(res); // 7

        res = recursiveFirstOccurrence(array, 0, 7, 3);
        System.out.println(res); // 6

        res = recursiveFirstOccurrence(array, 0, 7, 0);
        System.out.println(res); // 0

        res = recursiveFirstOccurrence(array, 0, 7, 50);
        System.out.println(res); // -1

        res = recursiveFirstOccurrence(array, 0, 7, -50);
        System.out.println(res); // -1
    }
	
}
