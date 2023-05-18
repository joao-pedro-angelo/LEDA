/**
4    * Dado um array A ordenado de inteiros de tamanho N e um valor x, possivelmente com mais de uma ocorrencia,
5    * usar busca binária para encontrar as posicoes da primeira e ultima ocorrencias de x em  A.
6    *
7    * Exemplo:
8    *   A = [5, 7, 7, 8, 8, 10]
9    *   x = 8
10   *   Saida:[3, 4] (primeira ocorrencia do 8 esta no indice 3, ultima ocorrencia do 8 esta no indice 4)
11   *
12   *   A = [5, 17, 100, 111]
13       x = 3
14   *   Saida: [-1, -1] (nao tem ocorrencia de 3 no array)
15   *
16   * Restricoes: 
17   * - Seu algoritmo NÃO pode usar memória extra (a nao ser variaveis simples locais e nao de colecao/estrutura) 
18   * - O tempo de seu algoritmo deve ser O(log n).
19   * - Retorna um array com dois elementos [primeiraPosicao,ultimaPosicao], onde primeiraPosicao
20   *   tem o valor do indice da primeira ocorrencia de x em A, e ultimaPosicao tem o valor do indice 
21   *   da ultima ocorrencia de x em A
22   * - Note que se x nao esta em A entao o retorno deve ser [-1,-1]
23   * - Voce NAO pode criar nenhuma classe extra
24   * - Implemente tudo que necessita na classe StartEndPositionImpl
25   * - Voce pode criar metodos auxiliares
26   */
27  public interface StartEndPosition {
28  
29  
30  	public int[] startEndPosition(Integer[] array, Integer x);
31  
32  }
