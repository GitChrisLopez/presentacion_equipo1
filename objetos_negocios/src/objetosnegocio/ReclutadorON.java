/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import DBConnection.IConnection;
import DBConnection.MySQLConnection;
import dto.ReclutadorDTO;
import entidades.Reclutador;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author paula
 */
public class ReclutadorON {

    private static ReclutadorON instancia;
    private IConnection conexion;
    List<ReclutadorDTO> listaReclutadores = new ArrayList<>();

    private ReclutadorON() {
        conexion = MySQLConnection.getInstance();
    }

    public static ReclutadorON getInstance() {
        if (instancia == null) {
            instancia = new ReclutadorON();
        }
        return instancia; // lml .-. lml rock

    }

    public void insertarReclutador(Reclutador r) throws SQLException {
        String sql = "INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = (Connection) conexion.getConnection(); // ← obtiene conexión
            stmt = conn.prepareStatement(sql); // ← prepara consulta

            stmt.setString(1, r.getNombreCompleto());
            stmt.setString(2, r.getApellidoPaterno());
            stmt.setString(3, r.getApellidoMaterno());
            stmt.setString(4, r.getPuesto());
            stmt.setString(5, r.getUsuario());
            stmt.setString(6, r.getContrasena());
            stmt.setBoolean(7, r.isEstado());

            int filas = stmt.executeUpdate(); // ← ejecuta inserción

            if (filas > 0) {
                System.out.println("Reclutador insertado correctamente.");
            } else {
                System.out.println("No se insertó el reclutador.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar reclutador: " + e.getMessage());
//            e.printStackTrace(); // ← muestra el error completo en consola
                throw new SQLException("Error al insertar el usuario", e);
                
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conexion.closeConnection(conn); // usa tu método personalizado
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }

    }

    // READ
    //importar resultset
    public List<Reclutador> obtenerTodos() {
        List<Reclutador> lista = new ArrayList<>();
        String sql = "SELECT * FROM reclutadores;";
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Reclutador r = new Reclutador();
                r.setId(rs.getInt("id"));
                r.setNombreCompleto(rs.getString("nombre")); // <- debe coincidir con columna real
                r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                r.setPuesto(rs.getString("puesto"));
                r.setUsuario(rs.getString("usuario"));
                r.setContrasena(rs.getString("contrasena"));
                r.setEstado(rs.getBoolean("estado"));
                lista.add(r);
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener reclutadores: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conexion.closeConnection(conn);
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }

        return lista;
    }
    
    // DELETE
    public void eliminarReclutador(int id) {
        String sql = "DELETE FROM reclutadores WHERE id = ?";

        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Reclutador eliminado.");
            } else {
                System.out.println("No se encontró el reclutador.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }
    }
    
     // UPDATE
    public void actualizarReclutador(Reclutador r) {
        String sql = "UPDATE reclutadores SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, puesto = ?, usuario = ?, estado = ? WHERE id = ?";

        try (Connection conn = conexion.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, r.getNombreCompleto());
            stmt.setString(2, r.getApellidoPaterno());
            stmt.setString(3, r.getApellidoMaterno());
            stmt.setString(4, r.getPuesto());
            stmt.setString(5, r.getUsuario());
            stmt.setBoolean(6, r.isEstado());
            stmt.setInt(7, r.getId());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Reclutador actualizado.");
            } else {
                System.out.println("No se encontró el reclutador.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar reclutador: " + e.getMessage());
        }
    }


}
