import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.*;

public class AnimalController implements Initializable {
    Animal animal1 = new Animal(1, "Loro", 2);
    Animal animal2 = new Animal(2, "Bobi", 31);
    Animal animal3 = new Animal(3, "Donald", 5);
    List<Animal> animais = new ArrayList<Animal>() {{
        this.add(animal1);
        this.add(animal2);
        this.add(animal3);
    }};

    @FXML
    private Button btnEnviar;

    @FXML
    private Button btnNovo;

    @FXML
    private ComboBox<String> cbAnimais;

    @FXML
    private TextArea textareaAnimal;

    @FXML
    void onChangeCB() {
        Animal animal = getAnimalByName(cbAnimais.getValue());
        if (animal != null) {
            textareaAnimal.setText(animal.toString());
        } else {
            textareaAnimal.setText("Escolha um animal");
        }
    }

    // onCliqueEnviar não funciona pq o onChangeCB já muda o texto
    @FXML
    void onCliqueEnviar() {
        Animal animal = getAnimalByName(cbAnimais.getValue());
        if (animal != null) {
            textareaAnimal.setText(animal.toString());
        } else {
            textareaAnimal.setText("Escolha um animal");
        }
    }

    @FXML
    void onCliqueNovo() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
    }



    private Animal getAnimalByName(String nome) {
        for (Animal animal : animais) {
            if (animal.getNome().equals(nome)) {
                return animal;
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
