package com.example.gestorcitas2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Button bttlog;

    @FXML
    private TextField txtnom;

    @FXML
    private TextField txtpss;

    @FXML
    private void OnClick(ActionEvent event) {
        String nom = txtnom.getText() != null ? txtnom.getText().trim() : "";
        String pss = txtpss.getText() != null ? txtpss.getText().trim() : "";

        // 1. Validar que los campos no estén vacíos
        if (nom.isEmpty() || pss.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Campos incompletos", "Por favor, introduce el usuario y la contraseña.");
            return;
        }

        // 2. Comprobar credenciales (Sustituir por consulta a Base de Datos o DAO)
        if (autenticar(nom, pss)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/gestorcitas2/main-view.fxml"));
                Parent root = fxmlLoader.load();

                Scene scene = new Scene(root, 700, 600);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setTitle("Gestión de Citas \"Clínica San Mateo\"");
                stage.setScene(scene);
                stage.centerOnScreen(); // Recentra la ventana tras cambiar el tamaño
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlerta(Alert.AlertType.ERROR, "Error de sistema", "No se pudo cargar la interfaz principal.");
            }
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Acceso denegado", "Usuario o contraseña incorrectos.");
        }
    }

    /**
     * Lógica provisional para validar el usuario.
     */
    private boolean autenticar(String usuario, String password) {
        // Cambia estos valores según tus credenciales de prueba
        return "root".equalsIgnoreCase(usuario) && "toor".equals(password);
    }

    /**
     * Reutilizable para mostrar mensajes al usuario.
     */
    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

