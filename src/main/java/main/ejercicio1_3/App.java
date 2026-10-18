package main.ejercicio1_3;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class App extends Application {

    @FXML private TextField txtNumero, txtCantidad, txtImpares, txtPares, txtTotal, txtMayor, txtMenor;
    @FXML private TextArea txtDivisores;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage.setTitle("Cifras y Divisores de un Número");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void analizar() {
        int numero = Math.abs(Integer.parseInt(txtNumero.getText().trim()));

        int cantidad = 0;
        int sumaImpares = 0;
        int sumaPares = 0;
        int mayor = 0;
        int menor = 9;

        int resto = numero;
        do {
            int cifra = resto % 10;
            cantidad++;
            if (cifra % 2 == 0) {
                sumaPares += cifra;
            } else {
                sumaImpares += cifra;
            }
            if (cifra > mayor) {
                mayor = cifra;
            }
            if (cifra < menor) {
                menor = cifra;
            }
            resto = resto / 10;
        } while (resto > 0);

        StringBuilder divisores = new StringBuilder();
        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                divisores.append(i).append("\n");
            }
        }

        txtCantidad.setText(String.valueOf(cantidad));
        txtImpares.setText(String.valueOf(sumaImpares));
        txtPares.setText(String.valueOf(sumaPares));
        txtTotal.setText(String.valueOf(sumaImpares + sumaPares));
        txtMayor.setText(String.valueOf(mayor));
        txtMenor.setText(String.valueOf(menor));
        txtDivisores.setText(divisores.toString());
    }

    @FXML
    private void limpiar() {
        txtNumero.clear();
        txtCantidad.clear();
        txtImpares.clear();
        txtPares.clear();
        txtTotal.clear();
        txtMayor.clear();
        txtMenor.clear();
        txtDivisores.clear();
        txtNumero.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
