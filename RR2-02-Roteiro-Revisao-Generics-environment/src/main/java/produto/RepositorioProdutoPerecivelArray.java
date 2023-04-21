package produto;

public class RepositorioProdutoPerecivelArray extends
		RepositorioProdutosArray<ProdutoNaoPerecivel> {

	public RepositorioProdutoPerecivelArray(int size) {
		super(size);
	}

	@Override
	public void inserir(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.inserir(produto);
		}
	}

	@Override
	public void atualizar(ProdutoNaoPerecivel produto) {
		if (produto instanceof ProdutoNaoPerecivel) {
			super.atualizar(produto);
		}
	}

}
