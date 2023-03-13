package entities;

import java.util.Timer;
import java.util.TimerTask;

public class Lembrete {

	
	Timer timer;

	public Lembrete(Animal animal, int segundos) {
		timer = new Timer();
		timer.schedule(new TarefaLembrete(animal), segundos * 1000);
	}
	
	class TarefaLembrete extends TimerTask {
		
		private Animal animal;
		
		public TarefaLembrete(Animal animal) {
			this.animal = animal;
		}
		
		public void run() {
			animal.desalimentar();
			timer.cancel();
		}

		public Animal getAnimal() {
			return animal;
		}
	}
	
}
