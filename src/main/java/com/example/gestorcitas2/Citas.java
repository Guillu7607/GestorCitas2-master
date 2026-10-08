package com.example.gestorcitas2;

import java.time.LocalDate; // O java.util.Date si usas la librería tradicional

public class Citas {
    private int idCitas;
    private String nombreEspec;
    private LocalDate fecha; // Puedes usar String si guardas la fecha como texto
    private int idPaciente;

    // Constructor vacío
    public Citas() {
    }

    // Constructor completo
    public Citas(int idCitas, String nombreEspec, LocalDate fecha, int idPaciente) {
        this.idCitas = idCitas;
        this.nombreEspec = nombreEspec;
        this.fecha = fecha;
        this.idPaciente = idPaciente;
    }

    // Constructor sin el idCitas (útil para insertar nuevas citas donde el ID es autoincrementable)
    public Citas(String nombreEspec, LocalDate fecha, int idPaciente) {
        this.nombreEspec = nombreEspec;
        this.fecha = fecha;
        this.idPaciente = idPaciente;
    }

    // Getters y Setters
    public int getIdCitas() {
        return idCitas;
    }

    public void setIdCitas(int idCitas) {
        this.idCitas = idCitas;
    }

    public String getNombreEspec() {
        return nombreEspec;
    }

    public void setNombreEspec(String nombreEspec) {
        this.nombreEspec = nombreEspec;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCitas=" + idCitas +
                ", nombreEspec='" + nombreEspec + '\'' +
                ", fecha=" + fecha +
                ", idPaciente=" + idPaciente +
                '}';
    }
}