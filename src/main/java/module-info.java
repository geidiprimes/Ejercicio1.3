module main.ejercicio1_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens main.ejercicio1_3 to javafx.fxml;
    exports main.ejercicio1_3;
}
