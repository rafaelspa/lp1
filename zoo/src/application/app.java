package application;

import entities.Ave;
import entities.Lembrete;
import entities.Mamifero;
import entities.Reptil;
import entities.Zoologico;

public class app {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mamifero mamifero = new Mamifero("Animal Mamifero", 10, "Felix Catus", false, 2);
		Ave ave = new Ave("Animal ave", 2, "Eudyptes chrysolophus", false, "Bico fino");
		Reptil reptil = new Reptil("Animal reptil", 3, "Hydromedusa tectifera", false, 26.00);
		
		Zoologico zoologico = new Zoologico();
		
		zoologico.adicionarAnimal(mamifero);
		zoologico.adicionarAnimal(ave);
		zoologico.adicionarAnimal(reptil);
		
		zoologico.alimentarAnimais();
		
		zoologico.listarAnimais();
		
		new Lembrete(reptil, 5);
		new Lembrete(ave, 5);
		new Lembrete(mamifero, 5);
	}

}
