import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static Stage stage;
    public static Scene mostrarAnimalScene;
    public static Scene cadastrarAnimalScene;
    public static List<Animal> animais;

    public static void main(String[] args) {
        launch(args);
        instanciarListaAnimais();
    }

    public static void instanciarListaAnimais() {
        Animal animal1 = new Animal(1, "Loro", 2);
        Animal animal2 = new Animal(2, "Bobi", 31);
        Animal animal3 = new Animal(3, "Donald", 5);
        animais = new ArrayList<Animal>() {{
            this.add(animal1);
            this.add(animal2);
            this.add(animal3);
        }};
    }

    public static void atualizarAnimais(List<Animal> animaisAtualizado) {
        animais = animaisAtualizado;
    }

    public static List<Animal> chamarListaAnimais() {
        return animais;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        instanciarListaAnimais();

        FXMLLoader paginaMostrarAnimal = new FXMLLoader(Main.class.getResource("mostrar-animal.fxml"));
        mostrarAnimalScene = new Scene(paginaMostrarAnimal.load(), 500, 500, Color.BEIGE);

        FXMLLoader paginaCadastroAnimal = new FXMLLoader(Main.class.getResource("cadastrar-animal.fxml"));
        cadastrarAnimalScene = new Scene(paginaCadastroAnimal.load(), 500, 500, Color.BEIGE);

        stage.setTitle("Exibir Animal");
        stage.setScene(mostrarAnimalScene);
        stage.show();
    }
}