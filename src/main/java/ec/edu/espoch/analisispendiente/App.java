package ec.edu.espoch.analisispendiente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/ec/edu/espoch/analisispendiente/view/Primary.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Análisis de Pendiente");
        stage.setScene(scene);
        stage.show();
    }

    public static void cambiarVista(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("/ec/edu/espoch/analisispendiente/view/" + fxml + ".fxml"));

        Scene scene = new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}


























