/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import DBConnection.IConnection;
import DBConnection.MySQLConnection;
import entidades.Candidato;
import entidades.Reclutador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author chris
 */
public class NominaON {

    private static NominaON instancia;
    private IConnection conexion;
    private static final Logger LOGGER = Logger.getLogger(NominaON.class.getName());

    private NominaON() {
        conexion = MySQLConnection.getInstance();
    }

    /**
     * Obtiene la instancia única del servicio (Singleton)
     *
     * @return Instancia del servicio
     */
    public static synchronized NominaON getInstance() {
        if (instancia == null) {
            instancia = new NominaON();
        }
        return instancia;
    }

    /**
     * Actualiza la nómina de un reclutador en la base de datos
     *
     * @param reclutador Objeto Reclutador con el ID y nuevo valor de nómina
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarNominaReclutador(Reclutador reclutador) {
        String sql = "UPDATE reclutadores SET nomina = ? WHERE id = ?";
        boolean resultado = false;

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setFloat(1, reclutador.getNomina());
            stmt.setInt(2, reclutador.getId());

            int filasAfectadas = stmt.executeUpdate();
            resultado = (filasAfectadas > 0);

            if (resultado) {
                LOGGER.log(Level.INFO, "Nómina actualizada correctamente para el reclutador ID: {0}", reclutador.getId());
            } else {
                LOGGER.log(Level.WARNING, "No se encontró el reclutador con ID: {0}", reclutador.getId());
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar nómina del reclutador: {0}", e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar la nómina: " + e.getMessage(),
                    "Error de Base de Datos",
                    JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    /**
     * Actualiza la nómina de un candidato en la base de datos
     *
     * @param candidato Objeto Candidato con el ID y nuevo valor de nómina
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarNominaCandidato(Candidato candidato) {
        String sql = "UPDATE candidatos SET nomina = ? WHERE id = ?";
        boolean resultado = false;

        try (Connection conn = conexion.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setFloat(1, candidato.getNomina());
            stmt.setInt(2, candidato.getId());

            int filasAfectadas = stmt.executeUpdate();
            resultado = (filasAfectadas > 0);

            if (resultado) {
                LOGGER.log(Level.INFO, "Nómina actualizada correctamente para el candidato ID: {0}", candidato.getId());
            } else {
                LOGGER.log(Level.WARNING, "No se encontró el candidato con ID: {0}", candidato.getId());
            }

        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar nómina del candidato: {0}", e.getMessage());
            JOptionPane.showMessageDialog(null,
                    "Error al actualizar la nómina: " + e.getMessage(),
                    "Error de Base de Datos",
                    JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }

    /**
     * Actualiza la nómina de un empleado (reclutador o candidato)
     * automáticamente detectando el tipo basado en el registro de la tabla y su
     * ID
     *
     * @param id ID del empleado
     * @param nomina Nuevo valor de la nómina
     * @param tipoEmpleado Tipo de empleado ('R' para reclutador, 'C' para
     * candidato)
     * @return true si la actualización fue exitosa, false en caso contrario
     */
    public boolean actualizarNomina(int id, float nomina, char tipoEmpleado) {
        boolean resultado = false;

        switch (tipoEmpleado) {
            case 'R':
                Reclutador r = new Reclutador();
                r.setId(id);
                r.setNomina(nomina);
                resultado = actualizarNominaReclutador(r);
                break;

            case 'C':
                Candidato c = new Candidato();
                c.setId(id);
                c.setNomina(nomina);
                resultado = actualizarNominaCandidato(c);
                break;

            default:
                LOGGER.log(Level.WARNING, "Tipo de empleado no válido: {0}", tipoEmpleado);
                JOptionPane.showMessageDialog(null,
                        "Tipo de empleado no válido",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
        }

        return resultado;
    }
}
