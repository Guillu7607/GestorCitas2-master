package com.example.gestorcitas2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class DAOCita {

    public static boolean insertarCita(String dniPaciente, LocalDate fecha, int idEspecialidad) {
        String sql = "INSERT INTO citas (dniPaciente, fechaCita, idEspecialidad) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dniPaciente);
            stmt.setDate(2, Date.valueOf(fecha));
            stmt.setInt(3, idEspecialidad);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar nueva cita: " + e.getMessage());
            return false;
        }
    }
}