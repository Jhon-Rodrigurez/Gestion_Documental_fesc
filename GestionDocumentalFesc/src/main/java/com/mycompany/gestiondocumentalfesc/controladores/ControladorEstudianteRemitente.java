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
public class ControladorEstudianteRemitente {
    
    Datos datos;

    public ControladorEstudianteRemitente() {
        this.datos = new Datos();
    }
    
    

    public Datos getInfoDocumentos(String identificacion, String filtro, String filtroFecha) {
        
        ArrayList<EstudianteRemitente> e = EstudianteRemitente.getEstudianteRemitentes();
        ArrayList<Documento> doc = Documento.getDocumentos();
        ArrayList<Destinatario> dt = Destinatario.getEstudianteRemitentes();
        
        datos.setArrayListEstudianteRemitentes(e);
        datos.setArrayListDocumentos(doc);
        datos.setArrayListDestinatarios(dt);
        
        return datos;
    }
    
}
