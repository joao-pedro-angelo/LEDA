package binarySearchAndVariations;

public class IteractiveBinarySearch {
	
	public static int iteractiveBinarySearch(int[] array, int n) {
		
		if (array != null && array.length > 0) {
			int left = 0;
			int right = array.length - 1;
		
			while (left <= right) {
				int middle = (left + right) / 2;
				if (array[middle] == n) {
					return middle;
				}
				else if (array[middle] > n) {
					right = middle - 1;
				}
				else {
					left = middle + 1;
				}
			}
			
			return -1;
		}
		
		else {
			return -1;
		}
	
	}

	public static void main(String[] args) {
		int arrayOrdenadoCrescente[] = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ,10};
		int arrayTamanhoPar[] = new int[] {0, 1, 2, 3};
		int arrayTamanhoImpar[] = new int[] {0, 1, 2};
		int arrayNegativos[] = new int[] {-3, -2, -1};
		int arrayNegativosPositivosZero[] = new int[] {-2, -1, 0, 1, 2};
		int arrayVazio[] = new int[] {};
		
		System.out.println(iteractiveBinarySearch(arrayOrdenadoCrescente, 0)); //0
		System.out.println(iteractiveBinarySearch(arrayOrdenadoCrescente, 10)); //10
		System.out.println(iteractiveBinarySearch(arrayTamanhoPar, 0)); //0
		System.out.println(iteractiveBinarySearch(arrayTamanhoPar, 3)); //3
		System.out.println(iteractiveBinarySearch(arrayTamanhoImpar, 0)); //0
		System.out.println(iteractiveBinarySearch(arrayTamanhoImpar, 2)); //2
		System.out.println(iteractiveBinarySearch(arrayNegativos, -3)); //0
		System.out.println(iteractiveBinarySearch(arrayNegativos, -1)); //2
		System.out.println(iteractiveBinarySearch(arrayNegativosPositivosZero, -2)); //0
		System.out.println(iteractiveBinarySearch(arrayNegativosPositivosZero, 2)); //4
		System.out.println(iteractiveBinarySearch(arrayVazio, 0)); //-1
	}
	
}
