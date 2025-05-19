/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import DBConnection.IConnection;
import DBConnection.MySQLConnection;
import dto.CandidatoDTO;
import dto.ReclutadorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Adrián
 */
public class BusquedaON {

    private static CandidatoDTO instanciaC;
    List<CandidatoDTO> listaCandidato = new ArrayList<>();
    private IConnection conexion;
    private static ReclutadorDTO instanciaR;
    List<ReclutadorDTO> listaReclutador = new ArrayList<>();

    private BusquedaON() {
        conexion = MySQLConnection.getInstance();
    }

    public void BuscarPorNombre(String nombre) {
        String sql = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from candidatos where nombre LIKE ?";
        String sql2 = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from reclutadores where nombre LIKE ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt.executeQuery(sql2);
        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }

    }

    public void BuscarPorApellidoPaterno(String apellidoPaterno) {
        String sql = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from candidatos where apellidoPaterno LIKE ?";
        String sql2 = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from reclutadores where apellidoPaterno LIKE ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt.executeQuery(sql2);
        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }
    }

    public void BuscarPorApellidoMaterno(String apellidoPaterno) {
        String sql = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from candidatos where apellidoMaterno LIKE ?";
        String sql2 = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from reclutadores where apellidoMaterno LIKE ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt.executeQuery(sql2);

        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }
    }

    public void BuscarPorPuesto(String puesto) {
        String sql = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from candidatos where puesto LIKE ?";
        String sql2 = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from reclutadores where puesto LIKE ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt.executeQuery(sql2);

        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }
    }

    public void BuscarPorEstado(boolean estado) {
        String sql = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from candidatos where estado = ?";
        String sql2 = "Select nombre, apellidoPaterno,apellidoMaterno,puesto,estado from reclutadores where estado = ?";
        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery(sql);
            ResultSet rs2 = stmt.executeQuery(sql2);
        } catch (SQLException e) {
            System.out.println("Error al eliminar reclutador: " + e.getMessage());
        }
    }

}
