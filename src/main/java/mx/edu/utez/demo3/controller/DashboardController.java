package mx.edu.utez.demo3.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class DashboardController {
    @FXML
    private void onAlumnos(ActionEvent event){
    //Cargar la view de alumnos (CRUD)
    FXMLLoader loader= new FXMLLoader(
     getClass().getResource("/mx/edu/utez/demo3/view/alumno_list.fxml")
    );
    try {
    Scene scene=new Scene(loader.load());
    Stage stage= (Stage) ((Node) event.getSource() ).getScene().getWindow();
    stage.setScene(scene);
    } catch (Exception e) {
    e.printStackTrace();
    throw new RuntimeException(e);
    }
      }


      @FXML
      private void botonCarrera(ActionEvent event) {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/utez/demo3/view/carrera_list.fxml"));
      try {
      Scene scene = new Scene(loader.load());
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setScene(scene);
      }catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
      }
       }


}
