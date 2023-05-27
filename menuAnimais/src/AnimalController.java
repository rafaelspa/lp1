import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {
    Animal animal1 = new Animal(1, "Loro", 2);
    Animal animal2 = new Animal(2, "Bobi", 31);
    Animal animal3 = new Animal(3, "Donald", 5);
    Map<Integer,Animal> animais = new HashMap<Integer,Animal>(){{
        this.put(1, animal1);
        this.put(2, animal2);
        this.put(3, animal3);
    }};

    @FXML
    private ComboBox<String> cbAnimais;

    @FXML
    private TextArea textareaAnimal;

    @FXML
    void onClique() {
        Animal animal = getAnimalByName(cbAnimais.getValue());
        if (animal != null) {
            textareaAnimal.setText(animal.toString());
        } else {
            textareaAnimal.setText("Escolha um animal");
        }
    }

    private Animal getAnimalByName(String nome) {
        for (int i = 1; i < animais.size() + 1; i++) {
            if (animais.get(i).getNome().equals(nome)) {
                return animais.get(i);
            }
        }
        return null;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbAnimais.getItems().add("Animais");
        cbAnimais.getItems().add(animal1.getNome());
        cbAnimais.getItems().add(animal2.getNome());
        cbAnimais.getItems().add(animal3.getNome());
    }
}
