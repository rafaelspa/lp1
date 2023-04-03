package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.Ponto;

public class Departamento<T extends Funcionario & Ponto> {
	private List<T> listaFuncionario = new ArrayList<>();
	private final Class<T> type;

	public Departamento(Class<T> type) {
		  this.type = type;
	}
	
    public Class<T> getMyType() {
        return this.type;
    }

	public void adicionarFuncionario(T funcionario) {
		listaFuncionario.add(funcionario);
	}

	public void listarFuncionarios() {
		System.out.println();
		System.out.println("Lista de Funcionário " + this.getMyType().getSimpleName() + ":");

		listaFuncionario.forEach((funcionario) -> {
			System.out.println(funcionario);
		});
	}

	public void listarAtrasados(int hora) {
		System.out.println();
		System.out.println("Lista de Atrasados " + this.getMyType().getSimpleName() + ":");

		listaFuncionario.forEach((funcionario) -> {
			if (funcionario.getHoraDeEntrada() > hora) {
				System.out.println(funcionario);
			}
		});
	}
}
