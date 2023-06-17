package problems;
2   
3   import adt.bst.BST;
4   
5   /**
6    * Interface contendo método para somar todas as folhas de uma BST
7    **/
8   public interface BSTSumLeaves {
9       /**
10       * Metodo para somar todas as folhsa de uma BST de inteiros. 
11       * 
12       * Restricoes e informacoes:
13       * - A classe BSTInteger é fornecida para que voces nao implementem
14       *   nenhuma BST. Voces podem usa-la para testar a implementacao de seu metodo
15       * - Voce DEVE implementar o metodo USANDO RECURSAO. Voce pode usar metodo auxiliar
16       *   desde que implementado na classe BSTSumLeavesImpl. 
17       * - Voce NÃO pode editar nenhuma outra classe
18       * - Voce NAO pode implementar nenhuma outra classe nova
19       * - Para implementar o metodo sumLeaves voce DEVE, da classe BSTInteger,
20       *   USAR APENAS o metodo getRoot
21       * - Voce pode usar qualquer métod da classe BSTNode mas NÃO pode modifica-la
22       * - Voce DEVE implementar seu algoritmo com complexidade Theta(N)
23       * - Sua implementacao DEVE ter relacao de recorrencia T(N) = 2T(N) + O(1)
24       * - Voce NÃO PODE usar nenhuma outra estrutura auxiliar nem converter a BST 
25       *   em outra estrutura, string, etc.
26       **/
27      public int sumLeaves(BST<Integer> bst);
28  }
