package entities;

import interfaces.Ponto;

public class Analista extends Funcionario implements Ponto {
	public Analista(Integer id, String nome, Double salario, int horaDeEntrada, int horaDeSaida) {
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
		return "Analista [getId()=" + getId() + ", getNome()=" + getNome() + ", getSalario()=" + getSalario()
				+ ", getHoraDeEntrada()=" + getHoraDeEntrada() + ", getHoraDeSaida()=" + getHoraDeSaida()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
}
