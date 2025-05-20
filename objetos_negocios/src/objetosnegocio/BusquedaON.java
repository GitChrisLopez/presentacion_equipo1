/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package objetosnegocio;

import DBConnection.IConnection;
import DBConnection.MySQLConnection;
import dto.CandidatoDTO;
import dto.ReclutadorDTO;
import entidades.Candidato;
import entidades.Reclutador;
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

    private static BusquedaON instancia;
    private IConnection conexion;
    private CandidatoON candidatoON;
    private ReclutadorDAO reclutadorON;

    private BusquedaON() {
        conexion = MySQLConnection.getInstance();
        candidatoON = CandidatoON.getInstance();
        reclutadorON = ReclutadorDAO.getInstance();
    }

    public static synchronized BusquedaON getInstance() {
        if (instancia == null) {
            instancia = new BusquedaON();
        }
        return instancia;
    }

    /**
     * Busca candidatos y reclutadores por nombre
     *
     * @param nombre Nombre o parte del nombre a buscar
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorNombre(String nombre) {
        List<Candidato> candidatos = new ArrayList<>();
        List<Reclutador> reclutadores = new ArrayList<>();
        List<Object> resultado = new ArrayList<>();

        if (nombre == null || nombre.trim().isEmpty()) {
            resultado.add(candidatoON.obtenerTodos());
            resultado.add(reclutadorON.obtenerTodos());
            return resultado;
        }

        String termino = "%" + nombre.trim() + "%";
        String sqlCandidatos = "SELECT * FROM candidatos WHERE nombre LIKE ?";
        String sqlReclutadores = "SELECT * FROM reclutadores WHERE nombre LIKE ?";

        try (Connection conn = conexion.getConnection()) {
            // Buscar candidatos
            try (PreparedStatement stmt = conn.prepareStatement(sqlCandidatos)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Candidato c = new Candidato();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPuesto(rs.getString("puesto"));
                    c.setEstado(rs.getBoolean("estado"));
                    c.setRutaPDF(rs.getString("rutapdf"));
                    c.setNomina(rs.getFloat("nomina"));
                    candidatos.add(c);
                }
            }

            // Buscar reclutadores
            try (PreparedStatement stmt = conn.prepareStatement(sqlReclutadores)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Reclutador r = new Reclutador();
                    r.setId(rs.getInt("id"));
                    r.setNombreCompleto(rs.getString("nombre"));
                    r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    r.setPuesto(rs.getString("puesto"));
                    r.setUsuario(rs.getString("usuario"));
                    r.setContrasena(rs.getString("contrasena"));
                    r.setEstado(rs.getBoolean("estado"));
                    r.setNomina(rs.getFloat("nomina"));
                    reclutadores.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
        }

        resultado.add(candidatos);
        resultado.add(reclutadores);
        return resultado;
    }

    /**
     * Busca candidatos y reclutadores por apellido paterno
     *
     * @param apellido Apellido o parte del apellido a buscar
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorApellidoPaterno(String apellido) {
        List<Candidato> candidatos = new ArrayList<>();
        List<Reclutador> reclutadores = new ArrayList<>();
        List<Object> resultado = new ArrayList<>();

        if (apellido == null || apellido.trim().isEmpty()) {
            resultado.add(candidatoON.obtenerTodos());
            resultado.add(reclutadorON.obtenerTodos());
            return resultado;
        }

        String termino = "%" + apellido.trim() + "%";
        String sqlCandidatos = "SELECT * FROM candidatos WHERE apellidoPaterno LIKE ?";
        String sqlReclutadores = "SELECT * FROM reclutadores WHERE apellidoPaterno LIKE ?";

        try (Connection conn = conexion.getConnection()) {
            // Buscar candidatos
            try (PreparedStatement stmt = conn.prepareStatement(sqlCandidatos)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Candidato c = new Candidato();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPuesto(rs.getString("puesto"));
                    c.setEstado(rs.getBoolean("estado"));
                    c.setRutaPDF(rs.getString("rutapdf"));
                    c.setNomina(rs.getFloat("nomina"));
                    candidatos.add(c);
                }
            }

            // Buscar reclutadores
            try (PreparedStatement stmt = conn.prepareStatement(sqlReclutadores)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Reclutador r = new Reclutador();
                    r.setId(rs.getInt("id"));
                    r.setNombreCompleto(rs.getString("nombre"));
                    r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    r.setPuesto(rs.getString("puesto"));
                    r.setUsuario(rs.getString("usuario"));
                    r.setContrasena(rs.getString("contrasena"));
                    r.setEstado(rs.getBoolean("estado"));
                    r.setNomina(rs.getFloat("nomina"));
                    reclutadores.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por apellido paterno: " + e.getMessage());
        }

        resultado.add(candidatos);
        resultado.add(reclutadores);
        return resultado;
    }

    /**
     * Busca candidatos y reclutadores por apellido materno
     *
     * @param apellido Apellido o parte del apellido a buscar
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorApellidoMaterno(String apellido) {
        List<Candidato> candidatos = new ArrayList<>();
        List<Reclutador> reclutadores = new ArrayList<>();
        List<Object> resultado = new ArrayList<>();

        if (apellido == null || apellido.trim().isEmpty()) {
            resultado.add(candidatoON.obtenerTodos());
            resultado.add(reclutadorON.obtenerTodos());
            return resultado;
        }

        String termino = "%" + apellido.trim() + "%";
        String sqlCandidatos = "SELECT * FROM candidatos WHERE apellidoMaterno LIKE ?";
        String sqlReclutadores = "SELECT * FROM reclutadores WHERE apellidoMaterno LIKE ?";

        try (Connection conn = conexion.getConnection()) {
            // Buscar candidatos
            try (PreparedStatement stmt = conn.prepareStatement(sqlCandidatos)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Candidato c = new Candidato();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPuesto(rs.getString("puesto"));
                    c.setEstado(rs.getBoolean("estado"));
                    c.setRutaPDF(rs.getString("rutapdf"));
                    c.setNomina(rs.getFloat("nomina"));
                    candidatos.add(c);
                }
            }

            // Buscar reclutadores
            try (PreparedStatement stmt = conn.prepareStatement(sqlReclutadores)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Reclutador r = new Reclutador();
                    r.setId(rs.getInt("id"));
                    r.setNombreCompleto(rs.getString("nombre"));
                    r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    r.setPuesto(rs.getString("puesto"));
                    r.setUsuario(rs.getString("usuario"));
                    r.setContrasena(rs.getString("contrasena"));
                    r.setEstado(rs.getBoolean("estado"));
                    r.setNomina(rs.getFloat("nomina"));
                    reclutadores.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por apellido materno: " + e.getMessage());
        }

        resultado.add(candidatos);
        resultado.add(reclutadores);
        return resultado;
    }

    /**
     * Busca candidatos y reclutadores por puesto
     *
     * @param puesto Puesto o parte del puesto a buscar
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorPuesto(String puesto) {
        List<Candidato> candidatos = new ArrayList<>();
        List<Reclutador> reclutadores = new ArrayList<>();
        List<Object> resultado = new ArrayList<>();

        if (puesto == null || puesto.trim().isEmpty()) {
            resultado.add(candidatoON.obtenerTodos());
            resultado.add(reclutadorON.obtenerTodos());
            return resultado;
        }

        String termino = "%" + puesto.trim() + "%";
        String sqlCandidatos = "SELECT * FROM candidatos WHERE puesto LIKE ?";
        String sqlReclutadores = "SELECT * FROM reclutadores WHERE puesto LIKE ?";

        try (Connection conn = conexion.getConnection()) {
            // Buscar candidatos
            try (PreparedStatement stmt = conn.prepareStatement(sqlCandidatos)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Candidato c = new Candidato();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPuesto(rs.getString("puesto"));
                    c.setEstado(rs.getBoolean("estado"));
                    c.setRutaPDF(rs.getString("rutapdf"));
                    c.setNomina(rs.getFloat("nomina"));
                    candidatos.add(c);
                }
            }

            // Buscar reclutadores
            try (PreparedStatement stmt = conn.prepareStatement(sqlReclutadores)) {
                stmt.setString(1, termino);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Reclutador r = new Reclutador();
                    r.setId(rs.getInt("id"));
                    r.setNombreCompleto(rs.getString("nombre"));
                    r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    r.setPuesto(rs.getString("puesto"));
                    r.setUsuario(rs.getString("usuario"));
                    r.setContrasena(rs.getString("contrasena"));
                    r.setEstado(rs.getBoolean("estado"));
                    r.setNomina(rs.getFloat("nomina"));
                    reclutadores.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por puesto: " + e.getMessage());
        }

        resultado.add(candidatos);
        resultado.add(reclutadores);
        return resultado;
    }

    /**
     * Busca candidatos y reclutadores por estado
     *
     * @param estado Estado a buscar (true = Aprobado, false = Rechazado)
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorEstado(boolean estado) {
        List<Candidato> candidatos = new ArrayList<>();
        List<Reclutador> reclutadores = new ArrayList<>();
        List<Object> resultado = new ArrayList<>();

        String sqlCandidatos = "SELECT * FROM candidatos WHERE estado = ?";
        String sqlReclutadores = "SELECT * FROM reclutadores WHERE estado = ?";

        try (Connection conn = conexion.getConnection()) {
            // Buscar candidatos
            try (PreparedStatement stmt = conn.prepareStatement(sqlCandidatos)) {
                stmt.setBoolean(1, estado);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Candidato c = new Candidato();
                    c.setId(rs.getInt("id"));
                    c.setNombre(rs.getString("nombre"));
                    c.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    c.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    c.setTelefono(rs.getString("telefono"));
                    c.setCorreo(rs.getString("correo"));
                    c.setPuesto(rs.getString("puesto"));
                    c.setEstado(rs.getBoolean("estado"));
                    c.setRutaPDF(rs.getString("rutapdf"));
                    c.setNomina(rs.getFloat("nomina"));
                    candidatos.add(c);
                }
            }

            // Buscar reclutadores
            try (PreparedStatement stmt = conn.prepareStatement(sqlReclutadores)) {
                stmt.setBoolean(1, estado);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Reclutador r = new Reclutador();
                    r.setId(rs.getInt("id"));
                    r.setNombreCompleto(rs.getString("nombre"));
                    r.setApellidoPaterno(rs.getString("apellidoPaterno"));
                    r.setApellidoMaterno(rs.getString("apellidoMaterno"));
                    r.setPuesto(rs.getString("puesto"));
                    r.setUsuario(rs.getString("usuario"));
                    r.setContrasena(rs.getString("contrasena"));
                    r.setEstado(rs.getBoolean("estado"));
                    r.setNomina(rs.getFloat("nomina"));
                    reclutadores.add(r);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por estado: " + e.getMessage());
        }

        resultado.add(candidatos);
        resultado.add(reclutadores);
        return resultado;
    }

    /**
     * Método para buscar candidatos y reclutadores basado en múltiples palabras
     * clave
     *
     * @param palabrasClave Lista de palabras clave para filtrar
     * @return Lista de resultados [Lista de candidatos, Lista de reclutadores]
     */
    public List<Object> buscarPorPalabrasClave(List<String> palabrasClave) {
        if (palabrasClave == null || palabrasClave.isEmpty()) {
            List<Object> resultado = new ArrayList<>();
            resultado.add(candidatoON.obtenerTodos());
            resultado.add(reclutadorON.obtenerTodos());
            return resultado;
        }

        // Obtenemos todos los candidatos y reclutadores
        List<Candidato> todosCandidatos = candidatoON.obtenerTodos();
        List<Reclutador> todosReclutadores = reclutadorON.obtenerTodos();

        List<Candidato> candidatosFiltrados = new ArrayList<>();
        List<Reclutador> reclutadoresFiltrados = new ArrayList<>();

        // Filtramos candidatos
        for (Candidato c : todosCandidatos) {
            boolean coincide = false;

            for (String palabra : palabrasClave) {
                palabra = palabra.toLowerCase().trim();

                // Verificamos coincidencia en cualquier campo relevante
                if (c.getNombre().toLowerCase().contains(palabra)
                        || c.getApellidoPaterno().toLowerCase().contains(palabra)
                        || c.getApellidoMaterno().toLowerCase().contains(palabra)
                        || c.getPuesto().toLowerCase().contains(palabra)
                        || c.getCorreo().toLowerCase().contains(palabra)) {
                    coincide = true;
                    break;
                }
            }

            if (coincide) {
                candidatosFiltrados.add(c);
            }
        }

        // Filtramos reclutadores
        for (Reclutador r : todosReclutadores) {
            boolean coincide = false;

            for (String palabra : palabrasClave) {
                palabra = palabra.toLowerCase().trim();

                // Verificamos coincidencia en cualquier campo relevante
                if (r.getNombreCompleto().toLowerCase().contains(palabra)
                        || r.getApellidoPaterno().toLowerCase().contains(palabra)
                        || r.getApellidoMaterno().toLowerCase().contains(palabra)
                        || r.getPuesto().toLowerCase().contains(palabra)
                        || r.getUsuario().toLowerCase().contains(palabra)) {
                    coincide = true;
                    break;
                }
            }

            if (coincide) {
                reclutadoresFiltrados.add(r);
            }
        }

        List<Object> resultado = new ArrayList<>();
        resultado.add(candidatosFiltrados);
        resultado.add(reclutadoresFiltrados);
        return resultado;
    }

}
