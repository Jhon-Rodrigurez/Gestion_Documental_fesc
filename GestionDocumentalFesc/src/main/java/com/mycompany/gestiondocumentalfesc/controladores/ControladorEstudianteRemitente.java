/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.conexion.*;
import com.mycompany.gestiondocumentalfesc.modelos.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class ControladorEstudianteRemitente {
    
    IDaoEstudianteRemitente daoEst;
    
    public ControladorEstudianteRemitente() {
        this.daoEst = new DaoEstudianteRemitente();
    }
    
    public Datos getInfoDocumentos(String identificacion, String filtro, String filtroFecha) {
        
        Datos d = null;
        
        if (!identificacion.equals("")) {
            d = daoEst.getDocumentoEstudiante(identificacion);
            
            if (!filtro.equals("Selecionar")) {
                d = filtro(filtro, d);
            }
            
            if (!filtroFecha.equals("")) {
                d = filtroFecha(filtroFecha, d);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, diligencie el remitente");
        }
        
        return d;
    }

    private Datos filtro(String filtro, Datos d) {
        
        ArrayList<EstudianteRemitente> arrEstR = new ArrayList<>();
        ArrayList<Documento> arrDocR = new ArrayList<>();
        ArrayList<Destinatario> arrDesR = new ArrayList<>();
        
        switch (filtro) {
            
            case "Todos los radicados":
                break;
            case "Radicados que tienen respuesta":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    for (int j = 0; j < d.getArrayListDocumentos().size(); j++) {
                        
                        if (d.getArrayListDocumentos().get(i).getId() == d.getArrayListDocumentos().get(j).getRespuestaId()) {
                            
                            arrEstR.add(d.getArrayListEstudianteRemitentes().get(i));
                            arrDocR.add(d.getArrayListDocumentos().get(i));
                            arrDesR.add(d.getArrayListDestinatarios().get(i));
                            
                            arrEstR.add(d.getArrayListEstudianteRemitentes().get(j));
                            arrDocR.add(d.getArrayListDocumentos().get(j));
                            arrDesR.add(d.getArrayListDestinatarios().get(j));
                        }
                    }
                }
                
                d.setArrayListEstudianteRemitentes(arrEstR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
            case "Solo radicados de entrega":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    if (d.getArrayListDocumentos().get(i).isTipoRadicado()) {
                        arrEstR.add(d.getArrayListEstudianteRemitentes().get(i));
                        arrDocR.add(d.getArrayListDocumentos().get(i));
                        arrDesR.add(d.getArrayListDestinatarios().get(i));
                    }
                }
                
                d.setArrayListEstudianteRemitentes(arrEstR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
            case "Solo radicados de respuesta":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    if (!d.getArrayListDocumentos().get(i).isTipoRadicado()) {
                        arrEstR.add(d.getArrayListEstudianteRemitentes().get(i));
                        arrDocR.add(d.getArrayListDocumentos().get(i));
                        arrDesR.add(d.getArrayListDestinatarios().get(i));
                    }
                }
                
                d.setArrayListEstudianteRemitentes(arrEstR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
        }
        return d;
    }

    private Datos filtroFecha(String filtroFecha, Datos d) {
        
        ArrayList<EstudianteRemitente> arrEstR = new ArrayList<>();
        ArrayList<Documento> arrDocR = new ArrayList<>();
        ArrayList<Destinatario> arrDesR = new ArrayList<>();
        
        int a = Integer.parseInt(filtroFecha);
        a -= 1900;
        Timestamp fInicio = new Timestamp(a, 0, 1, 0, 0, 0, 0);
        Timestamp fFin = new Timestamp(a, 11, 31, 23, 59, 59, 0);
        
        for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
            if (d.getArrayListDocumentos().get(i).getFecha().after(fInicio) && d.getArrayListDocumentos().get(i).getFecha().before(fFin)) {
                arrEstR.add(d.getArrayListEstudianteRemitentes().get(i));
                arrDocR.add(d.getArrayListDocumentos().get(i));
                arrDesR.add(d.getArrayListDestinatarios().get(i));
            }
        }
                
        d.setArrayListEstudianteRemitentes(arrEstR);
        d.setArrayListDocumentos(arrDocR);
        d.setArrayListDestinatarios(arrDesR);
        
        return d;
    }
    
}
