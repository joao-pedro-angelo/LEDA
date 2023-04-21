package produto;

import java.util.ArrayList;

/**
 * Classe que representa um repositório de produtos usando ArrayList como
 * estrutura sobrejacente. Alguns métodos (atualizar, remover e procurar) ou
 * executam com sucesso ou retornam um erro. Para o caso desde exercício, o erro
 * será representado por uma RuntimeException que não precisa ser declarada na
 * clausula "throws" dos metodos.
 *
 * @author Adalberto
 */
public class RepositorioProdutoArrayList {

	/**
	 * A estrutura onde os produtos sao mantidos. Voce nao precisa se preocupar
	 * por enquanto com o uso de generics em ArrayList.
	 */
	@SuppressWarnings("rawtypes")
	private ArrayList produtos;

	/**
	 * A posicao do ultimo elemento inserido no array de produtos. o valor
	 * inicial é -1 para indicar que nenhum produto foi ainda guardado no array.
	 */
	@SuppressWarnings("unused")
	private int index;

	@SuppressWarnings("rawtypes")
	public RepositorioProdutoArrayList() {
		super();
		this.produtos = new ArrayList();
		this.index = -1;
	}

	/**
	 * Recebe o codigo do produto e devolve o indice desse produto no array ou
	 * -1 caso ele nao se encontre no array. Esse método é util apenas na
	 * implementacao com arrays por questoes de localizacao. Outras classes que
	 * utilizam outras estruturas internas podem nao precisar desse método.
	 * 
	 * @param codigo
	 * @return
	 */
	protected int procurarIndice(int codigo) {
		for (int i = 0; i<produtos.size(); i++) {
			Produto produto = (Produto) produtos.get(i);
			if (produto.getCodigo() == codigo) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Recebe o codigo e diz se tem produto com esse codigo armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public boolean existe(int codigo) {
		for (int i = 0; i<produtos.size(); i++) {
			Produto produto = (Produto) produtos.get(i);
			if (produto.getCodigo() == codigo) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Insere um novo produto (sem se preocupar com duplicatas)
	 */
	@SuppressWarnings("unchecked")
	public void inserir(Produto produto) {
		this.produtos.add(produto);
		this.index += 1;
	}

	/**
	 * Atualiza um produto armazenado ou retorna um erro caso o produto nao
	 * esteja no array. Note que, para localizacao, o código do produto será
	 * utilizado.
	 */
	@SuppressWarnings("unchecked")
	public void atualizar(Produto produto) {
		int index = this.procurarIndice(produto.getCodigo());
		if (index == -1) {
			throw new RuntimeException();
		}
		else {
			this.produtos.set(index, produto);
		}
	}

	/**
	 * Remove produto com determinado codigo, se existir, ou entao retorna um
	 * erro, caso contrário. Note que a remoção NÃO pode deixar "buracos" no
	 * array.
	 * 
	 * @param codigo
	 */
	public void remover(int codigo) {
		int index = this.procurarIndice(codigo);
		if (index == -1) {
			throw new RuntimeException();
		}
		else {
			this.produtos.remove(index);
		}
	}

	/**
	 * Retorna um produto com determinado codigo ou entao um erro, caso o
	 * produto nao esteja armazenado
	 * 
	 * @param codigo
	 * @return
	 */
	public Produto procurar(int codigo) {
		int index = this.procurarIndice(codigo);
		if (index == -1) {
			throw new RuntimeException();
		}
		else {
			return (Produto) this.produtos.get(index);
		}
	}
}
