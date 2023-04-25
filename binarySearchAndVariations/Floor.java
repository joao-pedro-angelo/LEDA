package binarySearchAndVariations;

public class Floor {

	//Método para encontrar o último elemento menor ou igual a um
	//elemento N que é passado como parâmetro. 
	public static int floor(int[] array, int N) {
		if (array != null && array.length > 0) {
			
			int left = 0;
			int right = array.length - 1;
			
			while (left <= right) {
				
				//N seja maior ou igual ao último elemento do array,
				//então retorna right
				if (array[right] <= N) {
					return right;
				}
				
				//Caso N seja menor que todos os elementos do array, 
				//então retorna -1, pois não há um elemento 
				//menor ou igual a N. 
				
				//Busca binária - com leve alteração
				int middle = (left + right) / 2;
				
				//Pequena alteração na busca bin. padrão:
				if (middle > 0 && array[middle - 1] <= N 
						&& N < array[middle])
			        return middle - 1;
				
				
				else if (array[middle] > N) {
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
		System.out.println(floor(array, 1)); //0
		System.out.println(floor(array, 2)); //1
		System.out.println(floor(array, 3)); //1
		System.out.println(floor(array, 8)); //2
		System.out.println(floor(array, 19)); //6
		System.out.println(floor(array, 0)); //-1
		System.out.println(floor(array, 100)); //6 
	}
	
}
