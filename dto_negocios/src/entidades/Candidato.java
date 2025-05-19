/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author paula
 */
public class Candidato {
    private int id;
    private String nombre, apellidoPaterno, apellidoMaterno, telefono, correo, puesto, rutaPDF;
    private float nomina;
    boolean estado;

    /**
     * Constructor que recibe solo la ruta del PDF(CV).
     *
     */
    public Candidato() {
        
    }
    
   

    /**
     * @param id es el id dentro de MySQL
     * @param nombre el nombre del candidato
     * @param apellidoPaterno apellido paterno del candidato
     * @param apellidoMaterno apellido materno del candidato
     * @param telefono el numero de telefono del candidato
     * @param correo el correo del candidato
     * @param puesto el puesto de trabajo que tiene o tuvo el candidato
     * @param estado es el estado de rechazo o aprobación en la empresa
     * @param rutaPDF Ubicación del archivo PDF.
     */
    public Candidato(String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, String puesto, String rutaPDF, boolean estado) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.rutaPDF = rutaPDF;
        this.estado = estado;
    }

    /**
     * @param id es el id dentro de MySQL
     * @param nombre el nombre del candidato
     * @param apellidoPaterno apellido paterno del candidato
     * @param apellidoMaterno apellido materno del candidato
     * @param telefono el numero de telefono del candidato
     * @param correo el correo del candidato
     * @param puesto el puesto de trabajo que tiene o tuvo el candidato
     * @param estado es el estado de rechazo o aprobación en la empresa
     * @param rutaPDF Ubicación del archivo PDF.
     */
    public Candidato(int id, String nombre, String apellidoPaterno, String apellidoMaterno, String telefono, String correo, String puesto, boolean estado, String rutaPDF) {
        this.nombre = nombre;
        this.apellidoPaterno= apellidoPaterno;
        this.apellidoMaterno=apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.estado = estado;
        this.rutaPDF = rutaPDF;
        this.id=id;
    }
    
    public Candidato(int id,String nombre, String apellidoPaterno, String apellidoMaterno, String puesto, float nomina) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.nomina = nomina;
        this.id = id;
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
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getNomina() {
        return nomina;
    }

    public void setNomina(float nomina) {
        this.nomina = nomina;
    }

    @Override
    public String toString() {
        return "Candidato{" + "id=" + id + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", telefono=" + telefono + ", correo=" + correo + ", puesto=" + puesto + ", rutaPDF=" + rutaPDF + ", estado=" + estado + '}';
    }
    
    



}
