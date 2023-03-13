package entities;

public abstract class Animal implements Alimentavel {
	private String nome;
	private int idade;
	private String especie;
	private Boolean alimentado;
	
	public Animal(String nome, int idade, String especie, Boolean alimentado) {
		this.nome = nome;
		this.idade = idade;
		this.especie = especie;
		this.alimentado = alimentado;
	}

	public abstract void emitirSom();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Boolean getAlimentado() {
		return alimentado;
	}

	public void setAlimentado(Boolean alimentado) {
		this.alimentado = alimentado;
	}

	@Override
	public String toString() {
		return "nome=" + nome + ", idade=" + idade + ", especie=" + especie + ", alimentado=" + alimentado + ", ";
	}

	protected abstract void desalimentar();
}
