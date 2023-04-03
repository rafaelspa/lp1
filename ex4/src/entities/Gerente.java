package entities;

public class Gerente extends Funcionario {

	public Gerente(Integer id, String nome, Double salario, int horaDeEntrada, int horaDeSaida) {
		super(id, nome, salario, horaDeEntrada, horaDeSaida);
	}

	@Override
	public String toString() {
		return "Gerente [getId()=" + getId() + ", getNome()=" + getNome() + ", getSalario()=" + getSalario()
				+ ", getHoraDeEntrada()=" + getHoraDeEntrada() + ", getHoraDeSaida()=" + getHoraDeSaida()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}
}
