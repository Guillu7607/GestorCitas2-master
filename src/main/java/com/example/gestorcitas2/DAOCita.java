package com.example.gestorcitas2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCita {

    // 1. OBTENER TODAS LAS CITAS DE UN PACIENTE (Para cargar la tabla / DataView)
    public List<Citas> obtenerCitasPorPaciente(int idPaciente) {
        List<Citas> listaCitas = new ArrayList<>();
        String sql = "SELECT idCitas, nombreEspec, Fecha, idPaciente FROM citas WHERE idPaciente = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPaciente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Citas cita = new Citas();
                    cita.setIdCitas(rs.getInt("idCitas"));
                    cita.setNombreEspec(rs.getString("nombreEspec"));

                    // Convertir java.sql.Date a java.time.LocalDate
                    Date fechaSql = rs.getDate("Fecha");
                    if (fechaSql != null) {
                        cita.setFecha(fechaSql.toLocalDate());
                    }

                    cita.setIdPaciente(rs.getInt("idPaciente"));
                    listaCitas.add(cita);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las citas del paciente: " + e.getMessage());
        }

        return listaCitas;
    }

    // 2. INSERTAR NUEVA CITA (Alta de cita)
    public boolean insertarCita(Citas cita) {
        String sql = "INSERT INTO citas (nombreEspec, Fecha, idPaciente) VALUES (?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cita.getNombreEspec());
            stmt.setDate(2, Date.valueOf(cita.getFecha()));
            stmt.setInt(3, cita.getIdPaciente());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al insertar nueva cita: " + e.getMessage());
            return false;
        }
    }

    // 3. MODIFICAR CITA (Actualizar fecha o especialidad)
    public boolean modificarCita(Citas cita) {
        String sql = "UPDATE citas SET nombreEspec = ?, Fecha = ? WHERE idCitas = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cita.getNombreEspec());
            stmt.setDate(2, Date.valueOf(cita.getFecha()));
            stmt.setInt(3, cita.getIdCitas());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al modificar la cita: " + e.getMessage());
            return false;
        }
    }

    // 4. BORRAR CITA (Eliminar cita por ID)
    public boolean borrarCita(int idCitas) {
        String sql = "DELETE FROM citas WHERE idCitas = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCitas);

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("Error al borrar la cita: " + e.getMessage());
            return false;
        }
    }
}