package com.example.gestorcitas2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.Date;

public class HelloController {

    @FXML
    private Button bttins;

    @FXML
    private ComboBox<Especialidad> cmbesp;

    @FXML
    private DatePicker datefech;

    @FXML
    private TextField txtdni;

    @FXML
    void OnClick(ActionEvent event) {
        String dni = txtdni.getText().trim();
        LocalDate fecha = datefech.getValue();
        Especialidad especialidadSeleccionada = cmbesp.getValue();

        if (dni.isEmpty() || fecha == null || especialidadSeleccionada == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Faltan datos por rellenar.");
            alert.showAndWait();
        } else {
            int idEspecialidad = especialidadSeleccionada.getId();

            // 1. Creamos la cita correctamente con los nuevos constructores
            Citas cita = new Citas(fecha, idEspecialidad);

            // 2. Llamamos al DAO pasándole el DNI y el objeto Citas
            boolean insertado = DAOCita.insertarCita(dni, fecha, idEspecialidad);

            if (insertado) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "¡Cita insertada correctamente!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No se pudo insertar la cita.");
                alert.showAndWait();
            }
        }
    }

    public void initialize() {
        cmbesp.getItems().addAll(
                new Especialidad(1, "Cirugia"),
                new Especialidad(2, "Pediatria"),
                new Especialidad(3, "Oftalmología")
        );

    }
}
