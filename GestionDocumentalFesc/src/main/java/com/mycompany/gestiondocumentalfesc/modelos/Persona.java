
package com.mycompany.gestiondocumentalfesc.modelos;


public class Persona {
    
    protected int id;
    protected String documento;
    protected String nombres;
    protected String apellidos;
    protected String correo;
    protected String telefono;
    
    public Persona() {
    }
    
    public Persona(String documento, String nombres, String apellidos, String correo, String telefono) {
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Persona(int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        this.id = id;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
