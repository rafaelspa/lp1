package entities;

import interfaces.Ponto;

public class Programador extends Funcionario implements Ponto {

	public Programador(Integer id, String nome, Double salario, int horaDeEntrada, int horaDeSaida) {
		super(id, nome, salario, horaDeEntrada, horaDeSaida);
	}

	@Override
	public void marcarHoraEntrada(int horaDeEntrada) {
		this.setHoraDeEntrada(horaDeEntrada);
	}

	@Override
	public void marcarHoraSaida(int horaDeSaida) {
		this.setHoraDeSaida(horaDeSaida);
	}

	@Override
	public String toString() {
		return "Programador [getId()=" + getId() + ", getNome()=" + getNome() + ", getSalario()=" + getSalario()
				+ ", getHoraDeEntrada()=" + getHoraDeEntrada() + ", getHoraDeSaida()=" + getHoraDeSaida()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
}
