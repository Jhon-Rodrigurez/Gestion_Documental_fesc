
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class Datos {
    
    private ArrayList<EstudianteRemitente> arrayListEstudianteRemitentes;
    private ArrayList<EmpresaRemitente> arrayListEmpresaRemitentes;
    private ArrayList<Destinatario> arrayListDestinatarios;
    private ArrayList<Documento> arrayListDocumentos;

    public Datos() {
    }

    public Datos(ArrayList<EstudianteRemitente> arrayListEstudianteRemitentes, ArrayList<EmpresaRemitente> arrayListEmpresaRemitentes, ArrayList<Destinatario> arrayListDestinatarios, ArrayList<Documento> arrayListDocumentos) {
        this.arrayListEstudianteRemitentes = arrayListEstudianteRemitentes;
        this.arrayListEmpresaRemitentes = arrayListEmpresaRemitentes;
        this.arrayListDestinatarios = arrayListDestinatarios;
        this.arrayListDocumentos = arrayListDocumentos;
    }

    /**
     * @return the arrayListEstudianteRemitentes
     */
    public ArrayList<EstudianteRemitente> getArrayListEstudianteRemitentes() {
        return arrayListEstudianteRemitentes;
    }

    /**
     * @param arrayListEstudianteRemitentes the arrayListEstudianteRemitentes to set
     */
    public void setArrayListEstudianteRemitentes(ArrayList<EstudianteRemitente> arrayListEstudianteRemitentes) {
        this.arrayListEstudianteRemitentes = arrayListEstudianteRemitentes;
    }

    /**
     * @return the arrayListEmpresaRemitentes
     */
    public ArrayList<EmpresaRemitente> getArrayListEmpresaRemitentes() {
        return arrayListEmpresaRemitentes;
    }

    /**
     * @param arrayListEmpresaRemitentes the arrayListEmpresaRemitentes to set
     */
    public void setArrayListEmpresaRemitentes(ArrayList<EmpresaRemitente> arrayListEmpresaRemitentes) {
        this.arrayListEmpresaRemitentes = arrayListEmpresaRemitentes;
    }

    /**
     * @return the arrayListDestinatarios
     */
    public ArrayList<Destinatario> getArrayListDestinatarios() {
        return arrayListDestinatarios;
    }

    /**
     * @param arrayListDestinatarios the arrayListDestinatarios to set
     */
    public void setArrayListDestinatarios(ArrayList<Destinatario> arrayListDestinatarios) {
        this.arrayListDestinatarios = arrayListDestinatarios;
    }

    /**
     * @return the arrayListDocumentos
     */
    public ArrayList<Documento> getArrayListDocumentos() {
        return arrayListDocumentos;
    }

    /**
     * @param arrayListDocumentos the arrayListDocumentos to set
     */
    public void setArrayListDocumentos(ArrayList<Documento> arrayListDocumentos) {
        this.arrayListDocumentos = arrayListDocumentos;
    }
    
    
}
