import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AnimalController implements Initializable {
    public List<Animal> animais;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfIdCadastro;

    @FXML
    private TextField tfNomeCadastro;

    @FXML
    private TextField tfIdadeCadastro;

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
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Escolha um animal\n");
            for (Animal a : animais) {
                stringBuilder.append(a.getNome() + "\n");
            }
            textareaAnimal.setText(stringBuilder.toString());
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
    void onCliqueNovo(ActionEvent event) throws IOException {
        mudarParaCadastrarAnimal(event);
    }

    @FXML
    void onCliqueCadastrar(ActionEvent event) throws IOException {
        if (!tfIdCadastro.getText().equals("") &&
                !tfNomeCadastro.getText().equals("") &&
                !tfIdadeCadastro.getText().equals("")
            ) {
            Animal novoAnimal = new Animal(
                    Integer.parseInt(tfIdCadastro.getText()),
                    tfNomeCadastro.getText(),
                    Integer.parseInt(tfIdadeCadastro.getText())
            );
            animais.add(novoAnimal);
            Main.atualizarAnimais(animais);
        }
        mudarParaMostrarAnimal(event);
    }

    public void mudarParaMostrarAnimal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mostrar-animal.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void mudarParaCadastrarAnimal(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("cadastrar-animal.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
        animais = Main.chamarListaAnimais();
        if (cbAnimais != null && animais != null) {
            cbAnimais.getItems().add("Animais");
            animais.forEach((animal) -> cbAnimais.getItems().add(animal.getNome()));
        }
    }
}
