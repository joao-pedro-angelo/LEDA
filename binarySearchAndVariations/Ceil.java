package binarySearchAndVariations;

public class Ceil {
	
	//Método para encontrar o primeiro elemento (presente no array),
	//maior ou igual a um elemento N que é passado como parâmetro
	public static int ceil(int[] array, int N) {
		if (array != null && array.length > 0) {
			
			int left = 0;
			int right = array.length - 1;
			
			while (left <= right) {
				
				//Se o primeiro elemento for maior ou igual ao N,
				//então já retorna left. Pois o array está ordenado,
				//logo, todos os outros serão maior que N. Retornamos
				// o primeiro que for maior. 
				if (array[left] >= N) {
					return left;
				}
				
				//Se o último elemento for menor que o N, então
				//retorna -1. Lembre: o array está ordenado, logo, nesse
				//caso, ninguém é maior ou igual a N.
				else if (array[right] < N) {
					return -1;
				}
				
				//Busca binária padrão - iterativa
				int middle = (left + right) / 2;
				if (array[middle] > N) {
					right = middle - 1;
				}
				else if (array[middle] < N) {
					left = middle + 1;
				}
				else {
					return middle;
				}
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {1, 2, 8, 10, 10, 12, 19};
		System.out.println(ceil(array, 1)); //0
		System.out.println(ceil(array, 2)); //1
		System.out.println(ceil(array, 3)); //2
		System.out.println(ceil(array, 8)); //2
		System.out.println(ceil(array, 19)); //6
		System.out.println(ceil(array, 0)); //0
		System.out.println(ceil(array, 100)); //-1 
	}
	
}
