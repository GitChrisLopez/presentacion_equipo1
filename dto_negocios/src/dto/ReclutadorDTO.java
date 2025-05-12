/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;


/**
 *
 * @author chris,paula
 */

public class ReclutadorDTO {
    //nombre, apellido p, apellido m, puesto, usuario y contraseña
    
    private String nombreCompleto;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String puesto;
    private String usuario;
    private String contrasena;
    private boolean estado;
    
     public ReclutadorDTO() {
    }
     
    public ReclutadorDTO(String usuario, String contrasena){
        
    }

    public ReclutadorDTO(String nombreCompleto, String apellidoPaterno, String apellidoMaterno, String puesto, String usuario, String contrasena, boolean estado) {
        this.nombreCompleto = nombreCompleto;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    
}