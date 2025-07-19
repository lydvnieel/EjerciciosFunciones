package mx.edu.utez.demo3.controller;

import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mx.edu.utez.demo3.dao.impl.AlumnoImplDao;
import mx.edu.utez.demo3.dao.impl.CarreraImplDao;
import mx.edu.utez.demo3.model.Alumno;
import mx.edu.utez.demo3.model.Carrera;

public class AlumnoFormController {

    
   @FXML private TextField txtNombres;

   @FXML private TextField txtApellidos;

   @FXML private TextField txtCorreo;

   @FXML private DatePicker dpFechaNacimiento;

   @FXML private ComboBox<Carrera> cbCarrera;

   @FXML Button btnCrear;
   
   @FXML Button btnCancelar;

   AlumnoImplDao daoAlumno = new AlumnoImplDao();
   CarreraImplDao daoCarrera = new CarreraImplDao();

   @FXML

   private void initialize(){
    try {
        List<Carrera> carreras = daoCarrera.findAll();
        System.out.println("Carreras: " + carreras.size());
        cbCarrera.setItems(FXCollections.observableList(carreras));
        
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
   }

   @FXML
   
   private void onSubmit(){
     String nombres   = txtNombres.getText().trim();
     String apellidos = txtApellidos.getText().trim();
     String correo = txtCorreo.getText().trim();
     LocalDate fechaNacimiento = dpFechaNacimiento.getValue();
     Carrera carrera = cbCarrera.getSelectionModel().getSelectedItem();

     if(nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty() || fechaNacimiento == null || carrera == null){
        showAlert("¡Error!", "Todos los campos so obligatorios");
        System.err.println("Todos los campos son obligatorios");
        return;
     }
     Alumno alumno = new Alumno ();

     alumno.setNombre(nombres);
     alumno.setApellidos(apellidos);
     alumno.setCorreo(correo);
     alumno.setFechaNacimiento(fechaNacimiento);
     alumno.setIdCarrera(carrera.getId());

     try {
         daoAlumno.create(alumno);

          showAlert("¡Exito!'", "Alumno creado con exito");
         closeWindow();
     } catch (Exception e) {
        e.printStackTrace();
        showAlert("¡Error!", "No se pudo crear el alumno");
     }
   }

   public void closeWindow(){
    Stage stage = (Stage) btnCancelar.getScene().getWindow();
    stage.close();
   }

   @FXML

   private void onCancel(){
    closeWindow();
   }

   public void showAlert(String title, String msg){
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle(title);
       alert.setHeaderText(null);
       alert.setContentText(msg);
       alert.showAndWait();
   }

}
