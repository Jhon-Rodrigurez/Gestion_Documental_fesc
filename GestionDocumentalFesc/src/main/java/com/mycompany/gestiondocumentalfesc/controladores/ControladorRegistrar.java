/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Familia
 */
public class ControladorRegistrar implements ActionListener {
    
    ControladorDocumento ctDoc;
    JFrameRegistrar jFrameRegistrar;
    
    public ControladorRegistrar(JFrameRegistrar jFrameRegistrar) {
        this.ctDoc = new ControladorDocumento();
        this.jFrameRegistrar = new JFrameRegistrar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JFrameRegistrar.jtbGuardarDatos) {
            
            //FORMULARIOS DE DATOS DEL DOCUMENTO
            String asunto = JFrameRegistrar.txtAsunto.getText();
            String numRadicado = JFrameRegistrar.txtNumRadicado.getText();
            String tipoRadicado = JFrameRegistrar.jComboBoxTipoRadicado.toString();
            Date fecha = JFrameRegistrar.jDateFecha.getDate();
            String numAnexo = JFrameRegistrar.txtNumAnexos.getText();
            String tipoDocumento = JFrameRegistrar.jComboBoxTipoDocumento.toString();
            
            //FORMULARIOS DE INGRESAR DATOS DE REMITENTE
            String docEstudianteRemitente = JFrameRegistrar.txtDocRemitente.getText();
            String nombreEstudianteRemitente = JFrameRegistrar.txtNombreRemitente.getText();
            String carrera = JFrameRegistrar.txtCarrera.getText();
            String semestre = JFrameRegistrar.txtSemestre.getText();
            String correoRemitente = JFrameRegistrar.txtCorreoEstudianteRemitente.getText();
            String telefonoRemitente = JFrameRegistrar.txtTelefonoRemitente.getText();
            
            String docCompaniaRemitente = JFrameRegistrar.txtDocRemitente1.getText();
            String nombreCompaniaRemitente = JFrameRegistrar.jTextFieldNombreCompania.getText();
            String nit = JFrameRegistrar.jTextFieldNIT.getText();
            String nombreEmpleadoRemitente = JFrameRegistrar.txtNombreEmpleadoRemitente.getText();
            String correoCompaniaRemitente = JFrameRegistrar.txtCorreoCompaniaRemitente.getText();
            String telefonoCompaniaRemitente = JFrameRegistrar.txtTelefonoCompaniaRemitente.getText();
            
            //FORMULARIOS DE DESTINATARIO
            String docDestinatario = JFrameRegistrar.txtDocDestinatario.getText();
            String cargo = JFrameRegistrar.txtCargo.getText();
            String correoDestinatario = JFrameRegistrar.txtCorreoDestinatario.getText();
            String area = JFrameRegistrar.txtArea.getText();
            String nombres = JFrameRegistrar.txtNombresDestinatario.getText();
            String telefonoDestinatario = JFrameRegistrar.txtTelefonoDestinatario.getText();
            boolean reqRespuesta = JFrameRegistrar.jCheckBoxRequiereRespuesta.isSelected();
            
        }
    }
    
    public void inicio() {
        ArrayList<Documento> arrayListDocumentos = ctDoc.getDocumentos();
        
        for(Documento documento : arrayListDocumentos) {
            System.out.println(documento.getNombreArchivo());
            System.out.println(documento.getRutaArchivo());
        }
        
        File pdf = new File(arrayListDocumentos.get(1).getRutaArchivo());
        // ctDoc.visualizarDocumento(pdf);
        
    }
    
    //public void 
}
