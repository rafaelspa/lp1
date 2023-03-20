package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Venda {

	private Double saldo;
	private List<Produto> produtos = new ArrayList<>();

	public Venda(Double saldo) {
		this.saldo = saldo;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	public void removerProduto(String nome) throws Exception {
		if (produtos.size() > 0) {
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equals(nome)) {
					produtos.remove(produtos.get(i));
					System.out.println("\nProduto '" + nome + "' removido");
					return;
				}
			}
			throw new Exception("O produto não se encotra para venda");
		} else {
			throw new Exception("Exceção: Lista vazia");
		}
	}

	public void venderProduto(String nome, Double precoSugerido) throws Exception{
		if (produtos.size() > 0) {
			for (int i = 0; i < produtos.size(); i++) {
				if (produtos.get(i).getNome().equals(nome)) {
					if (produtos.get(i).getPreco() <= precoSugerido) {
						setSaldo(getSaldo() + produtos.get(i).getPreco());
						System.out.println("\nVenda do produto '" + produtos.get(i).getNome()
								+ "' realizada com sucesso, saldo: " + getSaldo() + "\n");
						removerProduto(produtos.get(i).getNome());
						return;
					} else {
						throw new Exception("Exceção: Preco sugerido abaixo da tabela");
					}

				}
			}
			throw new Exception("Produto '" + nome + "' não está à venda.");
		} else {
			throw new Exception("Exceção: Não existem produtos à venda");
		}
	}

	public void listarProdutos() {
		try {
			if (produtos.size() > 0) {
				IntStream.range(0, produtos.size())
					.forEach((index) -> {
						System.out.println(index+1 + " - " + produtos.get(index).toString());
						}
					);
			} else {
				throw new Exception("Exceção: Não existem produtos à venda");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
