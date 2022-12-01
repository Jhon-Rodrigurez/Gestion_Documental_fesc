/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.modelos.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Familia
 */
public class ControladorEmpresaRemitente {
    

    public ControladorEmpresaRemitente() {
        
    }

    public Datos getInfoDocumentos(String identificacion, String filtro, String filtroFecha) {
        Datos d = null;
        
        if (!identificacion.equals("")) {
            d = new Datos();
            d = getInfoEmpresa(identificacion, d);
            
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
    
    private Datos getInfoEmpresa(String identificacion, Datos d) {
        
        ArrayList<EmpresaRemitente> arrEmp = EmpresaRemitente.getEmpresasRemitentes();
        ArrayList<Documento> arrDoc = Documento.getDocumentos();
        ArrayList<Destinatario> arrDes = Destinatario.getDestinatarios();
        
        ArrayList<EmpresaRemitente> arrEmpR = new ArrayList<>();
        ArrayList<Documento> arrDocR = new ArrayList<>();
        ArrayList<Destinatario> arrDesR = new ArrayList<>();
        
        if (identificacion.equals("exito")) {
            
            arrEmpR.add(arrEmp.get(0));
            arrDocR.add(arrDoc.get(3));
            arrDesR.add(arrDes.get(2));
            
        } else if (identificacion.equals("caracol")) {
            
            arrEmpR.add(arrEmp.get(1));
            arrDocR.add(arrDoc.get(4));
            arrDesR.add(arrDes.get(2));
            
        }
        
        d.setArrayListEmpresaRemitentes(arrEmpR);
        d.setArrayListDocumentos(arrDocR);
        d.setArrayListDestinatarios(arrDesR);
        
        return d;
    }

    private Datos filtro(String filtro, Datos d) {
        
        ArrayList<EmpresaRemitente> arrEmpR = new ArrayList<>();
        ArrayList<Documento> arrDocR = new ArrayList<>();
        ArrayList<Destinatario> arrDesR = new ArrayList<>();
        
        switch (filtro) {
            
            case "Todos los radicados":
                break;
            case "Radicados que tienen respuesta":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    for (int j = 0; j < d.getArrayListDocumentos().size(); j++) {
                        
                        if (d.getArrayListDocumentos().get(i).getId() == d.getArrayListDocumentos().get(j).getRespuestaId()) {
                            
                            arrEmpR.add(d.getArrayListEmpresaRemitentes().get(i));
                            arrDocR.add(d.getArrayListDocumentos().get(i));
                            arrDesR.add(d.getArrayListDestinatarios().get(i));
                            
                            arrEmpR.add(d.getArrayListEmpresaRemitentes().get(j));
                            arrDocR.add(d.getArrayListDocumentos().get(j));
                            arrDesR.add(d.getArrayListDestinatarios().get(j));
                        }
                    }
                }
                
                d.setArrayListEmpresaRemitentes(arrEmpR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
            case "Solo radicados de entrega":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    if (d.getArrayListDocumentos().get(i).isTipoRadicado()) {
                        arrEmpR.add(d.getArrayListEmpresaRemitentes().get(i));
                        arrDocR.add(d.getArrayListDocumentos().get(i));
                        arrDesR.add(d.getArrayListDestinatarios().get(i));
                    }
                }
                
                d.setArrayListEmpresaRemitentes(arrEmpR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
            case "Solo radicados de respuesta":
                
                for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
                    if (!d.getArrayListDocumentos().get(i).isTipoRadicado()) {
                        arrEmpR.add(d.getArrayListEmpresaRemitentes().get(i));
                        arrDocR.add(d.getArrayListDocumentos().get(i));
                        arrDesR.add(d.getArrayListDestinatarios().get(i));
                    }
                }
                
                d.setArrayListEmpresaRemitentes(arrEmpR);
                d.setArrayListDocumentos(arrDocR);
                d.setArrayListDestinatarios(arrDesR);
                
                break;
        }
        return d;
    }

    private Datos filtroFecha(String filtroFecha, Datos d) {
        
        ArrayList<EmpresaRemitente> arrEmpR = new ArrayList<>();
        ArrayList<Documento> arrDocR = new ArrayList<>();
        ArrayList<Destinatario> arrDesR = new ArrayList<>();
        
        int a = Integer.parseInt(filtroFecha);
        a -= 1900;
        Timestamp fInicio = new Timestamp(a, 0, 1, 0, 0, 0, 0);
        Timestamp fFin = new Timestamp(a, 11, 31, 23, 59, 59, 0);
        
        for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
                    
            if (d.getArrayListDocumentos().get(i).getFecha().after(fInicio) && d.getArrayListDocumentos().get(i).getFecha().before(fFin)) {
                arrEmpR.add(d.getArrayListEmpresaRemitentes().get(i));
                arrDocR.add(d.getArrayListDocumentos().get(i));
                arrDesR.add(d.getArrayListDestinatarios().get(i));
            }
        }
                
        d.setArrayListEmpresaRemitentes(arrEmpR);
        d.setArrayListDocumentos(arrDocR);
        d.setArrayListDestinatarios(arrDesR);
        
        return d;
    }
    
}
