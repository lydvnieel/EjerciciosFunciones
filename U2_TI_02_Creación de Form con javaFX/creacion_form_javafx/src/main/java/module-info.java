module utez.edu.mx.com.example {
    
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens utez.edu.mx.com.example to javafx.fxml;
    exports utez.edu.mx.com.example;
}
