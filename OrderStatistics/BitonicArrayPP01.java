package OrderStatistics;

/**
 * Um array Bitônico é um array podendo conter duas partições: uma ordenada
 * de forma crescente (sempre vem primeiro) e outra ordenada de forma decrescente.
 * O ponto bitônico desse array é o maior valor que divide essas duas partições.
 * 
 * Por exemplo:
 * O ponto bitônico do array [7,12,16, 20, 7,4,2,1] é o 20, pois do início até ele
 * tem-se os elementos em ordem crescente e apos ele tem-se os elementos em ordem
 * decrescente.
 * 
 * Pode acontecer de uma das partições (crescente ou decrescente) não exista no array
 * mas o ponto bitônico sempre será o elemento de maior valor.
 * 
 */
public class BitonicArrayPP01 {
	
	/**
	 *  
     * Método para encontrar o ponto bitônico de um array usando a estratégia 
     * de busca binária.
     * 
     * Restrições:
     * - Seu algoritmo teve ser O(log n)
     * - Você não pode usar memória extra (a não ser variáveis simples). Arrays
     *   auxiliares ou qualquer tipo de coleção são proibidos
     * - Voce deve usar a estratégia de busca binária e RECURSÃO
     * 
     * @param array um array bitônico
     * @return o ponto bitônico do array. Caso o array não tenha elementos, retorna -1
     */
	 
	 
	 public static int bitonicPoint(int[] array) {
		 if (array.length <= 0) {
			 return -1;
		 } return bitonicPointRecursive(array, 0, array.length - 1);
	 }
	 
	 private static int bitonicPointRecursive(int[] array, int left, int right){
		 int result = -1;
		 if (left <= right) {
			 int middle = (left + right) / 2;
			 
			 if(middle < right && array[middle + 1] > array[middle]) {
				 return bitonicPointRecursive(array, middle + 1, right);
			 }
			 else if(middle > 0 && array[middle - 1] > array[middle]) {
				 return bitonicPointRecursive(array, left, middle - 1);
			 }
			 else {
				 return array[middle];
			 }
		 }
		 return result;
	 }
	 
	 public static void main(String[] args) {
		 
		 int[] array = new int[] {1, 7, 3};
		 System.out.println(bitonicPoint(array)); //7
		 
		 int[] array2 = new int[] {7, 3, 2};
		 System.out.println(bitonicPoint(array2)); //7
		 
		 int[] array3 = new int[] {2, 3, 7};
		 System.out.println(bitonicPoint(array3)); //7
		 
		 int[] arrayVazio = new int[] {};
		 System.out.println(bitonicPoint(arrayVazio)); //-1
	 }
	
}
