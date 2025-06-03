module mx.edu.utez {
    requires javafx.controls;
    requires javafx.fxml;
    

    opens mx.edu.utez to javafx.fxml;
    exports mx.edu.utez;
}
