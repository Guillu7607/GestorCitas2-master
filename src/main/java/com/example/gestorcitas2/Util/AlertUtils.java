package com.example.gestorcitas2.Util;

import javafx.scene.control.Alert;

public class AlertUtils {

    /*public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }*/
    public static void mostrarError (String tipoAlert, String tituloAlert, String headerText, String contentText){
        Alert alert = new Alert(Alert.AlertType.valueOf(tipoAlert.toUpperCase()));
        alert.setTitle(tituloAlert);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        alert.showAndWait();
    } // GENERAR ALERTA
}
