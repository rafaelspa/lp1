package entities;

public class Ave extends Animal {
	private String tipoBico;
	
	public Ave(String nome, int idade, String especie, Boolean alimentado, String tipoBico) {
		super(nome, idade, especie, alimentado);
		this.tipoBico = tipoBico;
	}

	public void emitirSom() {
		// TODO Auto-generated method stub
		System.out.println("Som emitido de ave");
	}

	public String getTipoBico() {
		return tipoBico;
	}

	public void setTipoBico(String tipoBico) {
		this.tipoBico = tipoBico;
	}

	public void alimentar() {
		this.setAlimentado(true);
		System.out.println(getNome() + " está alimentado");
		emitirSom();
	}

	@Override
	public String toString() {
		return "Ave [" + super.toString() + "tipoBico=" + tipoBico +  "]";
	}
	
	@Override
	protected void desalimentar() {
		// TODO Auto-generated method stub
		setAlimentado(false);
		System.out.println(getNome() + " está com fome");
	}
}
