package orderStatistic;

public class OrderStatisticsSelectionImpl<T extends Comparable<T>> implements OrderStatistics<T> {

	/**
	 * Esta eh uma implementacao do calculo da estatistica de ordem seguindo a estrategia 
	 * de usar o selection sem modificar o array original. Note que seu algoritmo vai 
	 * apenas aplicar sucessivas vezes o selection ate encontrar a estatistica de ordem 
	 * desejada sem modificar o array original. 
	 * 
	 * Restricoes:
	 * - Preservar o array original, ou seja, nenhuma modificacao pode ser feita no 
	 *   array original
	 * - Nenhum array auxiliar deve ser criado e utilizado.
	 * - Voce nao pode encontrar a k-esima estatistica de ordem por contagem de
	 *   elementos maiores/menores, mas sim aplicando sucessivas selecoes (selecionar um elemento
	 *   como o selectionsort mas sem modificar nenhuma posicao do array).
	 * - Caso a estatistica de ordem nao exista no array, o algoritmo deve retornar null. 
	 * - Considerar que k varia de 1 a N 
	 * - Sugestao: o uso de recursao ajudara sua codificacao.
	 */
	@Override
	public T getOrderStatistics(T[] array, int k) {
		if (array.length > 0 && k > 0 && k <= array.length) {
			int minIndex = encontraIndiceDoMenor(array);
			int maxIndex = encontraIndiceDoMaior(array);
			
			return array[getOrderStatisticsSelection(array, k, 1, minIndex, maxIndex)];
		} return null;
	}
	
	private int getOrderStatisticsSelection(T[] array, int k, int cont, int minIndex, int maxIndex) {
		
		if (cont == k) {
			return minIndex;
		}
		
		int aux = maxIndex;
		for (int i = 0; i<array.length; i++) {
			
			if(array[i].compareTo(array[aux]) < 0) {
				if (array[i].compareTo(array[minIndex]) > 0) {
					aux = i;
				}
			}
		}
		return getOrderStatisticsSelection(array, k, cont + 1, aux, maxIndex);
	}
	
	private int encontraIndiceDoMenor(T[] array) {
		int minIndex = 0;
		for (int i = 1; i<array.length; i++) {
			if (array[i].compareTo(array[minIndex]) <= 0) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private int encontraIndiceDoMaior(T[] array) {
		int maxIndex = 0;
		for (int i = 1; i<array.length; i++) {
			if (array[i].compareTo(array[maxIndex]) >= 0) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
