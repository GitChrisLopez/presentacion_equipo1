/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

/**
 *
 * @author chris
 */
import DBConnection.IConnection;
import DBConnection.MySQLConnection;
import dto.CandidatoDTO;
import entidades.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.sql.ResultSet;


public class CandidatoON {

    private static CandidatoON instancia;
    List<CandidatoDTO> listaCandidatos = new ArrayList<>();
    private IConnection conexion;

    private CandidatoON() {
        conexion = MySQLConnection.getInstance();
    }

    public static synchronized CandidatoON getInstance() {
        if (instancia == null) {
            instancia = new CandidatoON();
        }
        return instancia;
    }

    public void agregarCandidato(Candidato c) throws SQLException {
        String sql = "INSERT INTO candidatos (nombre, apellidoPaterno, apellidoMaterno, puesto, estado, rutapdf, nomina) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellidoPaterno());
            stmt.setString(3, c.getApellidoMaterno());
            stmt.setString(4, c.getPuesto());
            stmt.setBoolean(5, c.isEstado());
            stmt.setString(6, c.getRutaPDF());
            stmt.setFloat(7, c.getNomina());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Candidato insertado correctamente.");
            } else {
                System.out.println("No se insertó el candidato.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al insertar el candidato", e);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conexion.closeConnection(conn);
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

    public void actualizarCandidato(Candidato c) throws SQLException {
        String sql = "UPDATE candidatos SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, puesto = ?, estado = ?, rutapdf = ?, nomina = ? WHERE id = ?";

        listaCandidatos.remove(c);

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getApellidoPaterno());
            stmt.setString(3, c.getApellidoMaterno());
            stmt.setString(4, c.getPuesto());
            stmt.setBoolean(5, c.isEstado());
            stmt.setString(6, c.getRutaPDF());
            stmt.setFloat(7, c.getNomina());
            stmt.setInt(8, c.getId());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Candidato actualizado correctamente.");
            } else {
                System.out.println("No se actualizó el candidato.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al realizar la operación:", e);
        }
    }

    public void eliminarCandidato(int id) {
        String sql = "DELETE FROM candidatos WHERE id = ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Candidato eliminado.");
            } else {
                System.out.println("No se logró encontrar al candidato.");
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la operación: " + e.getMessage());
        }
        listaCandidatos.removeIf(c -> c.hashCode() == id); // ajusta si usas hashCode como id
    }

    public List<Candidato> obtenerTodos() {
        List<Candidato> lista = new ArrayList<>();
        String sql = "SELECT * FROM candidatos;";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Candidato c = new Candidato();
                c.setId(rs.getInt("id"));
                c.setNombre(rs.getString("nombre"));
                c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                c.setPuesto(rs.getString("puesto"));
                c.setEstado(rs.getBoolean("estado"));
                c.setRutaPDF(rs.getString("rutapdf"));
                c.setNomina(rs.getFloat("nomina"));
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener candidatos: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conexion.closeConnection(conn);
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return lista;
    }

    public synchronized List<CandidatoDTO> obtenerCandidatos() {
        return listaCandidatos;
    }
}