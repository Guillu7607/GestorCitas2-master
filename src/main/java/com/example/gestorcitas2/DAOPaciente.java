package com.example.gestorcitas2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOPaciente {

    public Paciente obtenerPacientePorDni(String dni) {
        Paciente paciente = null;
        String sql = "SELECT idPaciente, dni, nombre, direccion, telefono, email, password FROM pacientes WHERE dni = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    paciente = new Paciente(
                            rs.getInt("idPaciente"),
                            rs.getString("dni"),
                            rs.getString("nombre"),
                            rs.getString("direccion"),
                            rs.getString("telefono"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el paciente por DNI: " + e.getMessage());
        }

        return paciente;
    }
}