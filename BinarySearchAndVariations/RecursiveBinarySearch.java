package binarySearchAndVariations;

public class RecursiveBinarySearch {
	
	public static int recursiveBinarySearch(int[] array, int left, int right, int n) {
		if (array != null && left >= 0 && right <= array.length && left <= right && array.length > 0) {
			int middle = (left + right) / 2;
			if (array[middle] == n) {
				return middle;
			}
			else if (array[middle] > n) {
				return recursiveBinarySearch(array, left, middle - 1, n);
			}
			else {
				return recursiveBinarySearch(array, middle + 1, right, n);
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int arrayOrdenadoCrescente[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		int arrayTamanhoPar[] = new int[] {0, 1, 2, 3};
		int arrayTamanhoImpar[] = new int[] {0, 1, 2};
		int arrayNegativos[] = new int[] {-3, -2, -1};
		int arrayNegativosPositivosZero[] = new int[] {-2, -1, 0, 1, 2};
		int arrayVazio[] = new int[] {};
		
		System.out.println(recursiveBinarySearch(arrayOrdenadoCrescente, 0, 10, 0)); //0
		System.out.println(recursiveBinarySearch(arrayOrdenadoCrescente, 0, 10, 10)); //10
		System.out.println(recursiveBinarySearch(arrayTamanhoPar, 0, 3, 0)); //0
		System.out.println(recursiveBinarySearch(arrayTamanhoPar, 0, 3, 3)); //3
		System.out.println(recursiveBinarySearch(arrayTamanhoImpar, 0, 2, 0)); //0
		System.out.println(recursiveBinarySearch(arrayTamanhoImpar, 0, 2, 2)); //2
		System.out.println(recursiveBinarySearch(arrayNegativos, 0, 2, -3)); //0
		System.out.println(recursiveBinarySearch(arrayNegativos, 0, 2, -1)); //2
		System.out.println(recursiveBinarySearch(arrayNegativosPositivosZero, 0, 4, -2)); //0
		System.out.println(recursiveBinarySearch(arrayNegativosPositivosZero, 0, 4, 2)); //4
		System.out.println(recursiveBinarySearch(arrayVazio, 0, 0, 0)); //-1
	}
	
}
