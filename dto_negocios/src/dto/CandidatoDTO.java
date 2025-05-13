/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author Adrián
 */
public class CandidatoDTO {

    private String nombre, apellidoPaterno, apellidoMaterno, telefono, correo, puesto, rutaPDF;
    boolean estado;

    /**
     * Constructor que recibe solo la ruta del PDF(CV).
     *
     * @param rutaPDF
     */
    public CandidatoDTO(String rutaPDF) {
        this.rutaPDF = rutaPDF;
    }

    /**
     *
     * @param nombre el nombre del candidato
     * @param apellidos son los apellidos del candidato
     * @param telefono el numero de telefono del candidato
     * @param correo el correo del candidato
     * @param puesto el puesto de trabajo que tiene o tuvo el candidato
     * @param estado es el estado de rechazo o aprobación en la empresa
     * @param rutaPDF Ubicación del archivo PDF.
     */
    public CandidatoDTO(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, String puesto, boolean estado, String rutaPDF) {
        this.nombre = nombre;
        this.apellidoPaterno= apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.estado = estado;
        this.rutaPDF = rutaPDF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getRutaPDF() {
        return rutaPDF;
    }

    public void setRutaPDF(String rutaPDF) {
        this.rutaPDF = rutaPDF;
    }

    @Override
    public String toString() {
        return "CandidatoDTO{" + "nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", correo=" + correo + ", puesto=" + puesto + ", rutaPDF=" + rutaPDF + ", estado=" + estado + '}';
    }



}
