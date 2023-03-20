package application;

import entities.Produto;
import entities.Venda;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Produto produto1 = new Produto("Produto 1", 1.99);
		Produto produto2 = new Produto("Produto 2", 10.99);
		Produto produto3 = new Produto("Produto 3", 15.99);
		Produto produto4 = new Produto("Produto 4", 22.99);
		
		Venda venda = new Venda(0.0);
		
		venda.adicionarProduto(produto1);
		venda.adicionarProduto(produto2);
		venda.adicionarProduto(produto3);
		
		venda.venderProduto(produto4.getNome(), 22.99);
		venda.venderProduto(produto1.getNome(), 0.0);
		venda.venderProduto(produto2.getNome(), 10.99);
		venda.venderProduto(produto1.getNome(), 1.99);
		venda.venderProduto(produto3.getNome(), 15.99);
		venda.venderProduto(produto3.getNome(), 15.99);
		
		System.out.println();
		
		venda.adicionarProduto(produto1);
		venda.adicionarProduto(produto2);
		venda.adicionarProduto(produto3);
		
		System.out.println("Lista de produtos");
		
		venda.listarProdutos();
	}
}
