package utez.edu.mx.com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Label lblNombre = new Label("Nombre");
        TextField tfNombre = new TextField();

        Label lblEdad = new Label("Edad");
        TextField tfEdad = new TextField();

        Label lblOpciones = new Label("Opciones");
        ObservableList<String> opciones = FXCollections.observableArrayList("Estudiante", "Profesor", "Admin");
        ComboBox<String> cmbOpciones = new ComboBox<>(opciones);

        Button btnCrear = new Button("Crear");
        Label lblResultado = new Label();

        GridPane form = new GridPane();
        form.setVgap(10);
        form.setHgap(10);

        form.add(lblNombre, 0, 0);
        form.add(tfNombre, 1, 0);
        form.add(lblEdad, 0, 1);
        form.add(tfEdad, 1, 1);
        form.add(lblOpciones, 0, 2);
        form.add(cmbOpciones, 1, 2);
        form.add(btnCrear, 0, 3);
        form.add(lblResultado, 1, 3);

        btnCrear.setOnAction(e -> {
            String nombre = tfNombre.getText();
            String edadEscrita = tfEdad.getText();
            String opcion = cmbOpciones.getSelectionModel().getSelectedItem();

            boolean esNumero = true;
            for (int i = 0; i < edadEscrita.length(); i++) {
                char c = edadEscrita.charAt(i);
                if (c < '0' || c > '9') {
                    esNumero = false;
                    break;
                }
            }

            if (nombre.isEmpty() || edadEscrita.isEmpty() || opcion == null) {
                lblResultado.setText("Todos los campos son obligatorios");
                lblResultado.setTextFill(Color.RED);
                form.setStyle("-fx-background-color: transparent;");
            } else if (!esNumero) {
                lblResultado.setText("Ingresa tu edad como número");
                lblResultado.setTextFill(Color.LIGHTBLUE);
                form.setStyle("-fx-background-color: transparent;");
            } else {
                int edad = Integer.parseInt(edadEscrita);
                lblResultado.setText("Nombre " + nombre + "\nEdad " + edad);
                lblResultado.setTextFill(Color.GREEN);
                form.setStyle("-fx-background-color: lightgreen;");
            }
        });

        scene = new Scene(form, 750, 450);
        stage.setScene(scene);
        stage.setTitle("Formulario");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
