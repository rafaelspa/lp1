package entities;

import java.util.Objects;

public class Funcionario {
	private Integer id;
	private String nome;
	private Double salario;
	private int horaDeEntrada;
	private int horaDeSaida;
	
	public Funcionario(Integer id, String nome, Double salario, int horaDeEntrada, int horaDeSaida) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.horaDeEntrada = horaDeEntrada;
		this.horaDeSaida = horaDeSaida;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getSalario() {
		return salario;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public int getHoraDeEntrada() {
		return horaDeEntrada;
	}
	
	public void setHoraDeEntrada(int horaDeEntrada) {
		this.horaDeEntrada = horaDeEntrada;
	}
	
	public int getHoraDeSaida() {
		return horaDeSaida;
	}
	
	public void setHoraDeSaida(int horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(id, other.id);
	}
}
