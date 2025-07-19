package mx.edu.utez.demo3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.edu.utez.demo3.dao.impl.CarreraImplDao;
import mx.edu.utez.demo3.model.Carrera;

public class CarreraFormController {

    @FXML private TextField txtNombreCarrera;

    @FXML private Button btnCrear;

    @FXML private Button btnCancelar;

    private CarreraImplDao daoCarrera = new CarreraImplDao();

    @FXML
    private void initialize() {
    
    }

    @FXML
    private void onSubmit() {
        String nombre = txtNombreCarrera.getText().trim();

        if (nombre.isEmpty()) {
            showAlert("¡Error!", "El nombre de la carrera es obligatorio");
            return;
        }

        Carrera carrera = new Carrera();
        carrera.setNombre(nombre);

        try {
            daoCarrera.create(carrera);
            showAlert("¡Éxito!", "Carrera creada con éxito");
            closeWindow();
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("¡Error!", "No se pudo crear la carrera");
        }
    }

    @FXML
    private void onCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
}
