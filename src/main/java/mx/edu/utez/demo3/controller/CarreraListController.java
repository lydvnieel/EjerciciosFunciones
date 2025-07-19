package mx.edu.utez.demo3.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mx.edu.utez.demo3.dao.impl.CarreraImplDao;
import mx.edu.utez.demo3.model.Carrera;

public class CarreraListController {

    @FXML
    private TableView<Carrera> tableCarreras;

    @FXML
    private TableColumn<Carrera, Integer> colId;

    @FXML
    private TableColumn<Carrera, String> colNombre;

    @FXML
    private TableColumn<Carrera, Void> colAcciones;

    @FXML
    private Button btnCrear;

    CarreraImplDao dao = new CarreraImplDao();

    
    @FXML
    private void initialize() {
    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
    loadCarreras();
    }



    private void loadCarreras() {
        try {
            ObservableList<Carrera> lista = FXCollections.observableList(dao.findAll());
            tableCarreras.setItems(lista);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
private void onCrearCarrera(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/utez/demo3/view/carrera_form.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/mx/edu/utez/demo3/css/carrera_form.css").toExternalForm());
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.showAndWait();

        loadCarreras();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
    private void irADashboard(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/mx/edu/utez/demo3/view/dashboard.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
