package mx.edu.utez;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
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

        Label label new Label ("");

        Button btnAceptar = new Button("Aceptar");
        Button btnCancelar = new Button("Cancelar");

        btnAceptar.setOnAction(e -> {
            lblResultado.setText("Aceptado!");

        })

        btnCancelar.setOnAction(e -> {
            lblResultado.setText("Rechazado!");

        })

        Label lblNombre = new Label("Nombre");
        TextField tfNombre = new TextField();

        Label lblComentario = new Label("Comentario");
        TextField tfComentario = new TextField();

        Label lblOpciones = new Label ("Opciones");
        ObservableList<String> opciones = FXCollections.observableArrayList("A", "B", "C");
        ComboBox cmbOpciones = new ComboBox(opciones);
        Button btnAceptar = new Button("Aceptar");
        Label lblResultado = new Label();

        btnAceptar.setOnAction(e -> {
            String nombre = tfNombre.getText();}
            String comentario = tfComentario.getText();
            String seleccion = cmbOpciones.getSelectionModel().getSelectedItem().toString();
            if(nombre.isEmpty() || comentario.isEmpty() || seleccion==null()){
                     System.out.println("Debes de llenar todos los campos");
                     lblResultado.setText("Debes de llenar todos los campos");
            }else{
                lblResultado.setText("Nombre: " + nombre + "\nComentario: " + comentario +"\nOpciones:" + seleccion);
            }


        )};



        GridPane form = new GridPane ();
        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(10);

        form.add(lblNombre, 0  0);



    
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 500, 700);

    }
    public static void main(String[] args){
        
        launch();
    }


    

   