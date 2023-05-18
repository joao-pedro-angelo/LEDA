 /**
4    * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
5    * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.
6   
7   Return an array of size 2, such that first element = starting position of B in A and second element = ending position of B in A, if B is not found in A return [-1, -1].
8   
9    * Restricoes: 
10   * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
11   * - O tempo de seu algoritmo deve ser O(log n).
12   * - Retornar um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
13   *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
14   *   da ultima ocorrencia de x em A
15   * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
16   *
17   */
18  public class StartEndPositionImpl implements StartEndPosition{
19  
20  
21  	@Override
22  	public int[] startEndPosition(Integer[] array, Integer x){
23  		int[] result = new int[] {-1, -1};
24  		if (array != null && array.length > 0) {
25  			result[0] = primeiraOcorrencia(array, x, 0, array.length - 1);
26  			result[1] = ultimaOcorrencia(array, x, 0, array.length - 1);
27  		}
28  		return result;
29  	}
30  	
31  	public int primeiraOcorrencia(Integer[] array, int x, int left, int right) {
32  		int primeiraOcorrencia = -1;
33  		if (left <= right) {
34  			
35  			if (array[left] == x) {
36  				return left;
37  			}
38  			
39  			int middle = (left + right) / 2;
40  			
41  			if (array[middle] == x && array[middle - 1] < x) {
42  				primeiraOcorrencia = middle;
43  			}
44  			else if (array[middle] > x) {
45  				primeiraOcorrencia = primeiraOcorrencia(array, x, left, middle - 1);
46  			}
47  			else if (array[middle] < x) {
48  				primeiraOcorrencia = primeiraOcorrencia(array, x, middle + 1, right);
49  			}
50  			else {
51  				primeiraOcorrencia = middle;
52  				primeiraOcorrencia = primeiraOcorrencia(array, x, left, middle - 1);
53  			}
54  		}
55  		return primeiraOcorrencia;
56  	}
57  	
58  	public int ultimaOcorrencia(Integer[] array, int x, int left, int right) {
59  		int ultimaOcorrencia = -1;
60  		if (left <= right) {
61  			
62  			if (array[right] == x) {
63  				return right;
64  			}
65  			
66  			int middle = (left + right) / 2;
67  			
68  			if (array[middle] == x && array[middle + 1] > x) {
69  				ultimaOcorrencia = middle;
70  			}
71  			else if(array[middle] > x) {
72  				ultimaOcorrencia = ultimaOcorrencia(array, x, left, middle - 1);
73  			}
74  			else if(array[middle] < x) {
75  				ultimaOcorrencia = ultimaOcorrencia(array, x, middle + 1, right);
76  			}
77  			else {
78  				ultimaOcorrencia = middle;
79  				ultimaOcorrencia = ultimaOcorrencia(array, x, middle + 1, right);
80  			}
81  		}
82  		return ultimaOcorrencia;
83  	}
84  
85  }
