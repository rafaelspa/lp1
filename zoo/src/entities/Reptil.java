package entities;

public class Reptil extends Animal {
	private double temperaturaCorporal;

	public Reptil(String nome, int idade, String especie, Boolean alimentado, double temperaturaCorporal) {
		super(nome, idade, especie, alimentado);
		this.temperaturaCorporal = temperaturaCorporal;
	}

	public void emitirSom() {
		// TODO Auto-generated method stub
		System.out.println("Emitir som de reptil");
	}

	public double getTemperaturaCorporal() {
		return temperaturaCorporal;
	}

	public void setTemperaturaCorporal(double temperaturaCorporal) {
		this.temperaturaCorporal = temperaturaCorporal;
	}

	public void alimentar() {
		// TODO Auto-generated method stub
		this.setAlimentado(true);
		System.out.println(getNome() + " está alimentado");
		emitirSom();
	}
	
	@Override
	public String toString() {
		return "Reptil [" + super.toString() + "Temperatura Corporal=" + temperaturaCorporal +  "]";
	}
	
	@Override
	protected void desalimentar() {
		// TODO Auto-generated method stub
		setAlimentado(false);
		System.out.println(getNome() + " está com fome");
	}
}
