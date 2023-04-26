package OrderStatistics;

public class KLargestBitonic {
	
	public static int kLargestBitonic(int[] array, int k) {
		if (array.length > 0 && k > 0 && k <= array.length) {
			int left = 0;
			int right = array.length - 1;
			
			int meio = (left + right) / 2;
			merge(array, left, meio, right);
			
			return array[k - 1];
		} return -1;
	}
	
	public static void merge(int[] array, int left, int meio, int right) {
		
		int[] helper = new int[array.length];
		for (int i = left; i<=right; i++) {
			helper[i] = array[i];
		}
		
		int i = left;
		int j = right;
		int k = left;
		
		while (i <= meio && j > meio) {
			if (helper[i] <= helper[j]) {
				array[k] = helper[i];
				i++;
			}
			else {
				array[k] = helper[j];
				j--;
			}
			k++;
		}
		
		while (i <= meio) {
			array[k] = helper[i];
			i++;
			k++;
		}
		
		while (j > meio) {
			array[k] = helper[j];
			j--;
			k++;
		}
	}
	
}
