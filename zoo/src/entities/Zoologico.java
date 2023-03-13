package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Zoologico {
	private List<Animal> animais = new ArrayList<>();

	public void adicionarAnimal(Animal animal) {
		animais.add(animal);
	}

	public void listarAnimais() {
		System.out.println("Lista de animais do zoologico:");
		IntStream.range(0, animais.size())
			.forEach( idx -> System.out.println(idx + 1 + " " + getAnimais().get(idx).toString()));
	}

	public void alimentarAnimais() {
		getAnimais().forEach((animal) -> animal.alimentar());
	}

	public List<Animal> getAnimais() {
		return animais;
	}
}
