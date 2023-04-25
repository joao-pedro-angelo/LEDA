package binarySearchAndVariations;

public class RecursiveCeil {

	//Método para encontrar o primeiro elemento maior ou igual a um elemento N
	public static int recursiveCeil(int[] array, int left, int right, int N) {
		
		//Verificações
		if (array != null && array.length > 0 && left >= 0 && right < array.length && left <= right) {
			
			//Se o primeiro elemento é maior ou igual ao elemento N, então já retorna o left
			if (array[left] >= N) {
				return left;
			}
			
			/**
			 * Como o array está ordenado (busca binária e variações funcionam com arrays de inteiros
			   ordenado. Então, caso o último elemento seja menor que N, não um elemento maior ou igual
			   a N. Logo, retorna -1. 
			 */	
			else if (array[right] < N) {
				return -1;
			}
			
			int middle = (left + right) / 2;
			if (array[middle] > N) {
				return recursiveCeil(array, left, middle - 1, N);
			}
			else if (array[middle] < N) {
				return recursiveCeil(array, middle + 1, right, N);
			}
			else {
				return middle;
			}
		
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 8, 10, 10, 12, 19};
		System.out.println(recursiveCeil(array, 0, 6, 1)); //0
		System.out.println(recursiveCeil(array, 0, 6, 2)); //1
		System.out.println(recursiveCeil(array, 0, 6, 3)); //2
		System.out.println(recursiveCeil(array, 0, 6, 8)); //2
		System.out.println(recursiveCeil(array, 0, 6, 19)); //6
		System.out.println(recursiveCeil(array, 0, 6, 0)); //0
		System.out.println(recursiveCeil(array, 0, 6, 100)); //-1 
	}
	
}
