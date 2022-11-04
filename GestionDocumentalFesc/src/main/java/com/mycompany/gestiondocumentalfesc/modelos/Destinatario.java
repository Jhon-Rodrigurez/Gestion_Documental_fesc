
package com.mycompany.gestiondocumentalfesc.modelos;


public class Destinatario extends Persona{
    
    private String cargo;
    private String area;

    public Destinatario() {
    }

    public Destinatario(String cargo, String area) {
        this.cargo = cargo;
        this.area = area;
    }

    public Destinatario(String cargo, String area, int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(id, documento, nombres, apellidos, correo, telefono);
        this.cargo = cargo;
        this.area = area;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    
}
