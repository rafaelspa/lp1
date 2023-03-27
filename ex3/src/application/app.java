package application;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import exception.ExisteNumeroNaStringException;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Criando 3 listas

		List<String> lista1 = new ArrayList<>();
		List<String> lista2 = new ArrayList<>();
		List<String> lista3 = new LinkedList<>();

		Scanner scanner = new Scanner(System.in);

		// Adicionando duas strings em cada lista

		try {
			System.out.print("Escreva a primeira string da lista 1: ");
			String str1 = scanner.nextLine();
			adicionaNaLista(lista1, str1);

			System.out.print("Escreva a segunda string da lista 1: ");
			String str2 = scanner.nextLine();
			adicionaNaLista(lista1, str2);

			System.out.print("Escreva a primeira string da lista 2: ");
			String str3 = scanner.nextLine();
			adicionaNaLista(lista2, str3);

			System.out.print("Escreva a segunda string da lista 2: ");
			String str4 = scanner.nextLine();
			adicionaNaLista(lista2, str4);

			System.out.print("Escreva a primeira string da lista 3: ");
			String str5 = scanner.nextLine();
			adicionaNaLista(lista3, str5);

			System.out.print("Escreva a segunda string da lista 3: ");
			String str6 = scanner.nextLine();
			adicionaNaLista(lista3, str6);

		} catch (ExisteNumeroNaStringException e) {
			System.out.println(e.getMessage());
		}

		// Adicione todos os elementos da lista 2 e 3 para a lista 1.
		lista1.addAll(lista2);
		lista1.addAll(lista3);

		// Verifique se um elemento da lista 2 contém na lista 1.
		if (existeElementoDaListaANaListaB(lista2, lista1)) {
			System.out.println("Um elemento da lista 2 está contido na lista 1");			
		} else {
			System.out.println("Não existe elemento da lista 2 na lista 1");			
		}
		
		// Verifique se todos os elementos da lista 3 estão na lista 1.
		if (lista1.containsAll(lista3)) {
			System.out.println("A lista 1 contem todos os elementos da lista 3");
		} else {
			System.out.println("A lista 1 não contem todos os elementos da lista 3");			
		}
		
		// Verifique se a lista 1 é igual a lista 2.
		if (lista1.equals(lista2)) {
			System.out.println("A lista 1 é igual a lista 2");
		} else {
			System.out.println("A lista 1 não é igual a lista 2");			
		}
		
		// Mostre o elemento 2 de cada lista.
		System.out.println("O elemento 2 da lista 1 é " + lista1.get(1));
		System.out.println("O elemento 2 da lista 2 é " + lista2.get(1));
		System.out.println("O elemento 2 da lista 3 é " + lista3.get(1));

		// Remova um elemento da lista 3.
		System.out.println("O elemento '" + lista3.remove(0) + "' foi removido da lista 3");
		
		
		// Remova os elementos da lista 3 da lista 1.
		lista1.removeAll(lista3);
		System.out.println("Os elementos da lista 3 que estão na lista 1 foram removidos.");
		
		// Verifique o tamanho da lista 1.
		System.out.println("A lista 1 tem tamanho " + lista1.size());
		
		// Limpe a lista 3.
		lista3.clear();
		System.out.println("A lista 3 foi limpa.");
		
		// Verifique se a lista 3 está vazia.
		if (lista3.isEmpty()) { 
			System.out.println("A lista 3 está vazia.");
		} else {
			System.out.println("A lista 3 não está vazia.");
		}
		
		// Mostre cada elemento da lista 1.
		System.out.print("Elementos da lista 1: '" + lista1.get(0) + "'");
		IntStream.range(1, lista1.size() - 1).forEach((elemento) -> {
			System.out.print(", '" + elemento + "'");
		});
		System.out.println(" e '" + lista1.get(lista1.size() - 1) + "'.");
		
		scanner.close();
	}

	public static void adicionaNaLista(List<String> lista, String str) {
		if (existeNumeroNaString(str)) {
			throw new ExisteNumeroNaStringException("Excecao: A string '" + str + "' possui numeros");
		}
		lista.add(str);
	}

	public static Boolean existeNumeroNaString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	public static Boolean existeElementoDaListaANaListaB(List<String> lista_a, List<String> lista_b) {
		for (String s : lista_a) {
			if (lista_b.contains(s)) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
}
