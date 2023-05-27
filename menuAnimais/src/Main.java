import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader paginaAnimais = new FXMLLoader(Main.class.getResource("animal.fxml"));
        Scene scene = new Scene(paginaAnimais.load(), 500, 500, Color.BEIGE);

        stage.setTitle("Exibir Animal");
        stage.setScene(scene);
        stage.show();
    }
}