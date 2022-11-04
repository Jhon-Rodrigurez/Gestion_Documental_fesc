
package com.mycompany.gestiondocumentalfesc.modelos;


public class EmpresaRemitente extends Persona {
    
    private String nombreEmpresa;
    private String nit;

    public EmpresaRemitente() {
    }

    public EmpresaRemitente(String nombreEmpresa, String nit) {
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
}
