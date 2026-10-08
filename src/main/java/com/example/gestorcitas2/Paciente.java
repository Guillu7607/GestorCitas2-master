package com.example.gestorcitas2;

public class Paciente {
    private int idPaciente;
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String password;

    // 1. Constructor vacío (útil para instanciar en DAOs)
    public Paciente() {
    }

    // 2. Constructor reducido (ID y nombre)
    public Paciente(int idPaciente, String nombre) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
    }

    // 3. Constructor sin idPaciente (para inserciones/registro)
    public Paciente(String dni, String nombre, String direccion, String telefono, String email, String password) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    // 4. Constructor completo (para lecturas desde la BD)
    public Paciente(int idPaciente, String dni, String nombre, String direccion, String telefono, String email, String password) {
        this.idPaciente = idPaciente;
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    // Corregido: ahora recibe el parámetro String telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}