
public class RecursiveFloor {
	
	//Método para achar o último elemento menor que um inteiro N que é passado como parâmetro
	public static int recursiveFloor(int[] array, int N, int left, int right) {
		if (array != null && array.length > 0 && left >= 0 && right < array.length && left <= right){
				
				//Como array está ordenado, o right é o maior elemento.
				//Se o N for maior ou igual ao right, então o último elemento menor que N é o próprio right.
				if (array[right] <= N) {
					return right;
				}
				
				//A partir daqui, é uma busca binária padrão.
				int middle = (left + right) / 2;
				
				
				if(array[middle] == N) {
					return middle;
				}
				//A única alteração em relação à busca binária padrão é essa condicional abaixo
				else if (middle > 0 && array[middle - 1] <= N && N < array[middle]) {
					return middle - 1;
				}
				else if (array[middle] > N) {
					return recursiveFloor(array, N, left, middle - 1);
				}
				else if (array[middle] < N) {
					return recursiveFloor(array, N, middle + 1, right);
				}
				else{
					return middle;
				}
			
		} return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[] {-10, 2, 8, 10, 10, 12, 19};
		System.out.println(recursiveFloor(array, -51, 0, 6)); //-1
		System.out.println(recursiveFloor(array, 2, 0, 6)); //1
		System.out.println(recursiveFloor(array, 3, 0, 6)); //1
		System.out.println(recursiveFloor(array, 8, 0, 6)); //2
		System.out.println(recursiveFloor(array, 19, 0, 6)); //6
		System.out.println(recursiveFloor(array, 0, 0, 6)); //-1
		System.out.println(recursiveFloor(array, 100, 0, 6)); //6 
	}
	
}
