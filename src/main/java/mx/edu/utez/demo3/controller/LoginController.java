package mx.edu.utez.demo3.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtCorreo;

    @FXML private PasswordField txtPass;

    @FXML
    private void onLogin() {

        String correo = txtCorreo.getText();
        String pass = txtPass.getText();

        if ("20243ds183".equals(correo) && "123".equals(pass)) {
            System.out.println("Usuario validado");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/utez/demo3/view/Dashboard.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setTitle("Dashboard");
                stage.setScene(new Scene(root));
                stage.show();

                // Cerrar la ventana de login
                Stage currentStage = (Stage) txtCorreo.getScene().getWindow();
                currentStage.close();

            } catch (IOException e) {
                e.printStackTrace();
                showAlert("Error", "No fue posible el inicio de sesion");
            }
        } else {
            showAlert("Error", "Credenciales incorrectas");
            System.out.println("Error");
        }
    }

    public void showAlert(String title, String msg){
        Alert alert=new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

}
