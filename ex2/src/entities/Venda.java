package entities;

import java.util.ArrayList;
import java.util.List;

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
	
	public String removerProduto(String nome) {
		try {
			if (produtos.size() > 0) {
				for (int i = 0; i < produtos.size(); i++) {
					if (produtos.get(i).getNome().equals(nome)) {
						produtos.remove(produtos.get(i));
						return "Produto removido";
					}
				}
				return "O produto não se encotra para venda";
			} else {
				throw new Exception("Exception: Lista vazia");
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public void venderProduto(String nome, Double precoSugerido) {
		try {
			if (produtos.size() > 0) {
				for (int i = 0; i < produtos.size(); i++) {
					if (produtos.get(i).getNome().equals(nome)) {
						if (produtos.get(i).getPreco() <= precoSugerido) {
							setSaldo(getSaldo() + produtos.get(i).getPreco());
							System.out.println("Venda do produto '" + produtos.get(i).getNome() + "' realizada com sucesso, saldo: " + getSaldo());
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void listarProdutos() {
		try {
			if (produtos.size() > 0) {
				for (Produto produto : produtos) {
					System.out.println(produto.toString());
				}
			} else {
				throw new Exception("Exceção: Não existem produtos à venda");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	

}
