
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class Destinatario extends Persona{
    
    private String cargo;
    private String area;

    public Destinatario() {
    }
    
    public Destinatario(String cargo, String area, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(documento, nombres, apellidos, correo, telefono);
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

    public static ArrayList<Destinatario> getDestinatariosRemitentes() {
        
        ArrayList<Destinatario> arrayListDestinatarios = new ArrayList<>();
        
        String cargo = "oficinista";
        String area = "caja";
        int id = 1;
        String doc = "309823234";
        String nombres = "jimena";
        String apellidos = "aguilar";
        String correo = "jimena@gmail.com";
        String telefono = "30008752234";
        
        Destinatario d1 = new Destinatario(cargo, area, id, doc, nombres, apellidos, correo, telefono);
        
        cargo = "vicente";
        area = "rectoria";
        id = 2;
        doc = "23098423";
        nombres = "luis";
        apellidos = "Velasques";
        correo = "luisV@gmail.com";
        telefono = "324987334";
        
        Destinatario d2 = new Destinatario(cargo, area, id, doc, nombres, apellidos, correo, telefono);
        
        arrayListDestinatarios.add(d1);
        arrayListDestinatarios.add(d2);
        
        return arrayListDestinatarios;
    }
}
