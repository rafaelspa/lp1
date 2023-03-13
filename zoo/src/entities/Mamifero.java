package entities;

public class Mamifero extends Animal {
	private int tempoDeGestacao;
	
	public Mamifero(String nome, int idade, String especie, Boolean alimentado, int tempoDeGestacao) {
		super(nome, idade, especie, alimentado);
		this.tempoDeGestacao = tempoDeGestacao;
	}

	public void emitirSom() {
		// TODO Auto-generated method stub
		System.out.println("Som emitido de mamifero");
	}

	public int getTempoDeGestacao() {
		return tempoDeGestacao;
	}

	public void setTempoDeGestacao(int tempoDeGestacao) {
		this.tempoDeGestacao = tempoDeGestacao;
	}

	public void alimentar() {
		// TODO Auto-generated method stub
		this.setAlimentado(true);
		System.out.println(getNome() + " está alimentado");
		emitirSom();
	}
	
	@Override
	public String toString() {
		return "Mamifero [" + super.toString() + "tempoDeGestação=" + tempoDeGestacao +  "]";
	}

	@Override
	protected void desalimentar() {
		// TODO Auto-generated method stub
		setAlimentado(false);
		System.out.println(getNome() + " está com fome");
	}
}