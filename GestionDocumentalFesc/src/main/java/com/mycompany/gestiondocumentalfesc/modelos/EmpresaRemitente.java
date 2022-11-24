
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class EmpresaRemitente extends Persona {
    
    private String nombreEmpresa;
    private String nit;

    public EmpresaRemitente() {
    }
    
    public EmpresaRemitente(String nombreEmpresa, String nit, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(documento, nombres, apellidos, correo, telefono);
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
    }

    public EmpresaRemitente(String nombreEmpresa, String nit, int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(id, documento, nombres, apellidos, correo, telefono);
        this.nombreEmpresa = nombreEmpresa;
        this.nit = nit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
    
    
    public static ArrayList<EmpresaRemitente> getEmpresaRemitentes() {
        
        ArrayList<EmpresaRemitente> arrayListEmpresas = new ArrayList<>();
        
        String nomEmpresa = "exito";
        String nit = "345345";
        int id = 1;
        String doc = "309823409";
        String nombres = "veronica";
        String apellidos = "aguilar";
        String correo = "verovero@gmail.com";
        String telefono = "3000899555";
        
        EmpresaRemitente e1 = new EmpresaRemitente(nomEmpresa, nit, id, doc, nombres, apellidos, correo, telefono);
        
        nomEmpresa = "caracol";
        nit = "234234";
        id = 2;
        doc = "23049u823";
        nombres = "mariano";
        apellidos = "Velasques";
        correo = "marianoV@gmail.com";
        telefono = "4092098567";
        
        EmpresaRemitente e2 = new EmpresaRemitente(nomEmpresa, nit, id, doc, nombres, apellidos, correo, telefono);
        
        arrayListEmpresas.add(e1);
        arrayListEmpresas.add(e2);
        
        return arrayListEmpresas;
    }
}
