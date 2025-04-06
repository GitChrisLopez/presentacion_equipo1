/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto_negocios;

/**
 *
 * @author Adrián
 */
public class CVDTO {
    String nombre, apellidos, telefono, correo,puesto;
    boolean estado;
    /**
     * 
     * @param nombre el nombre del candidato
     * @param apellidos son los apellidos del candidato 
     * @param telefono el numero de telefono del candidato
     * @param correo el correo del candidato
     * @param puesto el puesto de trabajo que tiene o tuvo el candidato
     * @param estado es el estado de rechazo o aprobación en la empresa
     */
    public CVDTO(String nombre, String apellidos, String telefono, String correo,String puesto, boolean estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.estado = estado;
    }

   public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CVDTO{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo=" + correo + ", puesto=" + puesto + ", estado=" + estado + '}';
    }

    
    
}
