package application;

import entities.Analista;
import entities.Departamento;
import entities.Gerente;
import entities.Programador;

public class app {

	public static void main(String[] args) {
		Gerente gerenteProgramadores = new Gerente(1, "Gerente programadores", 5000.00, 9, 15);
		Gerente gerenteAnalistas = new Gerente(2, "Gerente analistas", 5000.00, 9, 15);
		Programador programador1 = new Programador(1, "Programador 1", 1001.00, 8, 17);
		Programador programador2 = new Programador(2, "Programador 2", 1002.00, 8, 17);
		Programador programador3 = new Programador(3, "Programador 3", 1003.00, 8, 17);
		Analista analista1 = new Analista(1, "Analista 1", 2001.00, 8, 16);
		Analista analista2 = new Analista(2, "Analista 2", 2002.00, 8, 16);
		Analista analista3 = new Analista(3, "Analista 3", 2003.00, 8, 16);
		
		Departamento<Programador> departamentoProgramadores = new Departamento<>(Programador.class);
		
		departamentoProgramadores.adicionarFuncionario(programador1);
		departamentoProgramadores.adicionarFuncionario(programador2);
		departamentoProgramadores.adicionarFuncionario(programador3);
		
		departamentoProgramadores.listarFuncionarios();
		System.out.println("Gerente dos programadores: " + gerenteProgramadores);
		
		Departamento<Analista> departamentoAnalistas = new Departamento<>(Analista.class);
		
		departamentoAnalistas.adicionarFuncionario(analista1);
		departamentoAnalistas.adicionarFuncionario(analista2);
		departamentoAnalistas.adicionarFuncionario(analista3);
		
		departamentoAnalistas.listarFuncionarios();
		System.out.println("Gerente dos analistas: " + gerenteAnalistas);
		
		programador1.marcarHoraEntrada(7);
		programador2.marcarHoraEntrada(8);
		programador3.marcarHoraEntrada(9);
		
		departamentoProgramadores.listarAtrasados(8);
		
		analista1.marcarHoraEntrada(7);
		analista2.marcarHoraEntrada(9);
		analista3.marcarHoraEntrada(10);
		
		departamentoAnalistas.listarAtrasados(8);
	}
}
