/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.RenderImgJTable.ControladorTabla;
import com.mycompany.gestiondocumentalfesc.modelos.*;
import com.mycompany.gestiondocumentalfesc.vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Familia
 */
public class ControladorConsultar implements ActionListener{

    JFrameConsultar jFrameConsultar;
    Datos datos;
    ControladorEstudianteRemitente ctEstudiante;
    ControladorEmpresaRemitente ctEmpresa;
    ControladorTabla ctTb;
    
    public ControladorConsultar(JFrameConsultar jFrameConsultar) {
        this.jFrameConsultar = jFrameConsultar;
        this.datos = new Datos();
        this.ctEstudiante = new ControladorEstudianteRemitente();
        this.ctEmpresa = new ControladorEmpresaRemitente();
    }
    
    public void inicio() {
        setCbFiltro();
        setCbTpEntidad();
        jFrameConsultar.jTbConsultarC.addActionListener(this);
        jFrameConsultar.jTbRegistrarC.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == jFrameConsultar.jTbConsultarC) {
            
            String tpEntidad = jFrameConsultar.jCbTipoEntidadC.getSelectedItem().toString();
            String identificacion = jFrameConsultar.jTfIdentificacionC.getText();
            String filtro = jFrameConsultar.jCbFiltoC.getSelectedItem().toString();
            String filtroFecha = jFrameConsultar.jTfFiltroFechaC.getText();
            boolean b = false;
            
            if (tpEntidad.equals("Estudiante")) {
                datos = ctEstudiante.getInfoDocumentos(identificacion, filtro, filtroFecha);
                b = true;
            } else {
                datos = ctEmpresa.getInfoDocumentos(identificacion, filtro, filtroFecha);
            }
            
            ctTb = new ControladorTabla(jFrameConsultar.jTablaC, datos);
            ctTb.mostrarConsulta(b);
            
        } else if (e.getSource() == jFrameConsultar.jTbRegistrarC) {
            
            JFrameRegistrar jFReg = new JFrameRegistrar();
            ControladorRegistrar ctReg = new ControladorRegistrar(jFReg);
            jFReg.setVisible(true);
            jFrameConsultar.setVisible(false);
//            jFReg.pack();
//            jFReg.setLocationRelativeTo(null);
//            jFReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFReg.dispose();
        }
    }
    
    public void setCbFiltro() {
        jFrameConsultar.jCbFiltoC.removeAllItems();
        jFrameConsultar.jCbFiltoC.addItem("Selecionar");
        jFrameConsultar.jCbFiltoC.addItem("Todos los radicados");
        jFrameConsultar.jCbFiltoC.addItem("Radicados que tienen respuesta");
        jFrameConsultar.jCbFiltoC.addItem("Solo radicados de entrega");
        jFrameConsultar.jCbFiltoC.addItem("Solo radicados de respuesta");
    }

    public void setCbTpEntidad() {
        jFrameConsultar.jCbTipoEntidadC.removeAllItems();
        jFrameConsultar.jCbTipoEntidadC.addItem("Selecionar");
        jFrameConsultar.jCbTipoEntidadC.addItem("Estudiante");
        jFrameConsultar.jCbTipoEntidadC.addItem("Empresa");
    }
}
