package com.example.gestorcitas2;

import java.time.LocalDate;

public class Citas {
    private int idCita;
    private LocalDate fechaCita;
    private int idEspecialidad;
    private String dniPaciente;

    // Constructor vacío
    public Citas() {
    }

    // Constructor completo con ID
    public Citas(int idCita, LocalDate fechaCita, int idEspecialidad, String dniPaciente) {
        this.idCita = idCita;
        this.fechaCita = fechaCita;
        this.idEspecialidad = idEspecialidad;
        this.dniPaciente = dniPaciente;
    }

    // Constructor sin ID (ideal para nuevas inserciones)
    public Citas(LocalDate fechaCita, int idEspecialidad, String dniPaciente) {
        this.fechaCita = fechaCita;
        this.idEspecialidad = idEspecialidad;
        this.dniPaciente = dniPaciente;
    }

    // Constructor corto (si solo manejas fecha e ID)
    public Citas(LocalDate fechaCita, int idEspecialidad) {
        this.fechaCita = fechaCita;
        this.idEspecialidad = idEspecialidad;
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public LocalDate getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDate fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDniPaciente() {
        return dniPaciente;
    }

    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "idCita=" + idCita +
                ", fechaCita=" + fechaCita +
                ", idEspecialidad=" + idEspecialidad +
                ", dniPaciente='" + dniPaciente + '\'' +
                '}';
    }
}