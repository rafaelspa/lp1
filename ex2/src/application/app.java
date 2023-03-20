package application;

import java.util.Scanner;

import entities.Produto;
import entities.Venda;

public class app {

	public static void main(String[] args) {

		Integer opcao = 1;
		
		Scanner scanner = new Scanner(System.in);
		
		Venda venda = new Venda(0.0);

		while (opcao != 0) {
			
			System.out.print("Escolha uma opção:\n"
					+ "1 - Adicionar produto\n"
					+ "2 - Remover produto\n"
					+ "3 - Listar produtos\n"
					+ "4 - Vender produto\n"
					+ "5 - Ver Saldo\n"
					+ "0 - Sair do programa\n\n"
					+ "opcao: ");

			opcao = scanner.nextInt();	
			
			System.out.println();	
			
			switch (opcao) {
				case 1: {
					Produto produto = new Produto();
					System.out.println("--- Adição de produto ---\n");
					System.out.print("Nome do produto: ");
					scanner.nextLine();
					produto.setNome(scanner.nextLine());
					System.out.print("Preco do produto: ");
					produto.setPreco(scanner.nextDouble());
					venda.adicionarProduto(produto);
					System.out.println("\n\n## Produto Adicionado ##\n\n(Aperte 'enter' para continuar)\n");
					scanner.nextLine();
					scanner.nextLine();
					break;
				}
				case 2: {
					System.out.println("--- Remoção de produto ---\n");
					if (venda.getProdutos().size() > 0) {
						System.out.println("Produtos disponíveis: ");
						venda.listarProdutos();
						System.out.println();
						System.out.print("Nome do produto: ");
						scanner.nextLine();
					}
					try {
						venda.removerProduto(scanner.nextLine());
						System.out.println("\n## Produto Removido ##\n\n(Aperte 'enter' para continuar)\n");
						scanner.nextLine();						
					}
					catch (Exception e) {
						System.out.println("\n" + e.getMessage() + "\n\n(Aperte 'enter' para continuar)\n");
						scanner.nextLine();
					}
					break;
				}
				case 3: {
					System.out.println("--- Listagem dos produto ---\n");
					venda.listarProdutos();
					System.out.println("\n(Aperte 'enter' para continuar)\n\n");
					scanner.nextLine();
					scanner.nextLine();
					break;
				}
				case 4: {
					System.out.println("--- Venda de produto ---\n");
					System.out.println("Produtos disponíveis: ");
					venda.listarProdutos();
					System.out.println();
					System.out.print("Nome do produto: ");
					scanner.nextLine();
					String nome = scanner.nextLine();
					System.out.print("Preco sugerido do produto: ");
					Double preco = scanner.nextDouble();
					try {
						venda.venderProduto(nome, preco);
						System.out.println("\n## Produto Vendido ##\n\n(Aperte 'enter' para continuar)\n");
						scanner.nextLine();
						scanner.nextLine();
					} catch (Exception e) {
						System.out.println("\n" + e.getMessage() + "\n\n(Aperte 'enter' para continuar)\n");
						scanner.nextLine();
						scanner.nextLine();
					}
					break;
				}
				case 5: {
					System.out.println("--- Saldo da venda ---\n");
					System.out.println("Saldo: " + venda.getSaldo() + "\n\n(Aperte 'enter' para continuar)\n");
					scanner.nextLine();
					scanner.nextLine();
					break;
				}
				case 0: {
					break;
				}
				default:
					scanner.close();
					throw new IllegalArgumentException("Valor inesperado: " + opcao);
			}
		}
		System.out.println("FIM DE PROGRAMA");
		scanner.close();
	}
}
