/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.modelos.*;
import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class ControladorEmpresaRemitente {
    
    Datos datos;

    public ControladorEmpresaRemitente() {
        this.datos = new Datos();
    }

    public Datos getInfoDocumentos(String identificacion, String filtro, String filtroFecha) {
        ArrayList<EmpresaRemitente> e = EmpresaRemitente.getEstudianteRemitentes();
        ArrayList<Documento> doc = Documento.getDocumentos();
        ArrayList<Destinatario> dt = Destinatario.getDestinatarios();
        
        datos.setArrayListEmpresaRemitentes(e);
        datos.setArrayListDocumentos(doc);
        datos.setArrayListDestinatarios(dt);
        
        return datos;
    }
    
}
