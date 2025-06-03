package mx.edu.utez;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override

    public void start(Stage stage) throws IOException {

        Label label = new Label("Holaaaa");
        StackPane root = new StackPane(label);
        scene = new Scene(root, 200, 200);
    

        stage.setTitle("Mi primera app en javafX");

        Image image = new Image(getClass().getResourceAsStream("/mx/edu/utez/icons/loro.png"));

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }


    }

   