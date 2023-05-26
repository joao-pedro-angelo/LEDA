package problem;
import linkedList.SingleLinkedListNode;

/**
6    * Interface definindo um metodo para remover as duplicadas de uma lista
7    * possivelmente não ordenada, a partir de um determinado nó.
8    */
public interface LinkedListRemoveDuplicates<T> {
     /**
11       * Remove as duplicadas de uma lista a partir de determinado nó, passado como parâmetro.
12       * Restrições:
13       * - OBSERVE AS RESTRICOES EXTRAS NA CLASSE QUE IMPLEMENTA ESSA INTERFACE!
14       * - Você NÃO pode usar nenhuma estrutura auxiliar como memória extra. Ou seja,
15       *   sua solução deve usar espaco extra O(1)
16       * - voce NÃO pode alterar nada na classe SingleLinkedListNode
17       * - Você NÃO pode ordenar a lista
18       * - Você NÃO pode criar uma lista nova e retornar
19       * - Sua solução DEVE ir varrendo a lista da esquerda pra direita e ir resolvendo
20       *   o problema durante essa varredura.
21       * - Seu algoritmo deve ser da ordem exata (Theta) de n^2. 
22       */
    public void removeDuplicates(SingleLinkedListNode<T> node);
}
 
