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
public class ReclutadorDAO {

    private static ReclutadorDAO instancia;
    private IConnection conexion;
    List<ReclutadorDTO> listaReclutadores = new ArrayList<>();

    private ReclutadorDAO() {
        conexion = MySQLConnection.getInstance();
    }

    public static ReclutadorDAO getInstance() {
        if (instancia == null) {
            instancia = new ReclutadorDAO();
        }
        return instancia; // lml .-. lml rock

    }

    public void insertarReclutador(Reclutador r) throws SQLException {
        String sql = "INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        try {
            conn = (Connection) conexion.getConnection();
            stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1, r.getNombreCompleto());
            stmt.setString(2, r.getApellidoPaterno());
            stmt.setString(3, r.getApellidoMaterno());
            stmt.setString(4, r.getPuesto());
            stmt.setString(5, r.getUsuario());
            stmt.setString(6, r.getContrasena());
            stmt.setBoolean(7, r.isEstado());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGenerado = generatedKeys.getInt(1);
                    r.setId(idGenerado);  // **Asignas el id al objeto**
                }
                System.out.println("Reclutador insertado correctamente con ID: " + r.getId());
            } else {
                System.out.println("No se insertó el reclutador.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar reclutador: " + e.getMessage());
            throw new SQLException("Error al insertar el usuario", e);
        } finally {
            if (generatedKeys != null) try {
                generatedKeys.close();
            } catch (Exception e) {
            }
            if (stmt != null) try {
                stmt.close();
            } catch (Exception e) {
            }
            if (conn != null) {
                conexion.closeConnection(conn);
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
                r.setNomina(rs.getFloat("nomina"));
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

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Reclutador eliminado.");
            } else {
                System.out.println("No se encontró el reclutador.");
            }

        } catch (SQLException e) {
            System.err.println("Error al eliminar reclutador con ID " + id + ": " + e.getMessage());
        }
    }

    // UPDATE
    public void actualizarReclutador(Reclutador r) {
        String sql = "UPDATE reclutadores SET nombre = ?, apellidoPaterno = ?, apellidoMaterno = ?, puesto = ?, usuario = ?, estado = ? WHERE id = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

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

    public void actualizarNomina(Reclutador r) {
        String sql = "UPDATE reclutadores SET nomina = ? WHERE id = ?";

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, Float.toString(r.getNomina()));
            stmt.setInt(2, r.getId());

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
