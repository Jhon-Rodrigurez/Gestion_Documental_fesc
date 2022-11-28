/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.RenderImgJTable.ControladorTabla;
import com.mycompany.gestiondocumentalfesc.modelos.*;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameDetalles;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Familia
 */
public class ControladorDetalles implements ActionListener {
    
    JFrameDetalles jfraDetalles;
    Documento doc;
    Destinatario des;
    EstudianteRemitente est;
    EmpresaRemitente emp;

    public ControladorDetalles(JFrameDetalles jfraDetalles) {
        this.jfraDetalles = jfraDetalles;
        doc = new Documento();
        des = new Destinatario();
        est = new EstudianteRemitente();
        emp = new EmpresaRemitente();
    }
    
    public void iniciar(int id, String vCol, Datos d) {
        jfraDetalles.setVisible(true);
        jfraDetalles.setLocationRelativeTo(null);
        jfraDetalles.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        getDetalles(id, vCol, d);
        
        jfraDetalles.jBVisualizarDocD.addActionListener(this);
        jfraDetalles.jBDescargarDocD.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        File pdf = new File(doc.getRutaArchivo());
        
        if (e.getSource() == jfraDetalles.jBVisualizarDocD) {
            
            try {
                Desktop.getDesktop().open(pdf);
            } catch (IOException ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (e.getSource() == jfraDetalles.jBDescargarDocD) {
            
            File pdfDes = new File("C:\\Users\\Familia\\Downloads\\"+ doc.getNombreArchivo());
            
            try {
                copyFile(pdf, pdfDes);
                JOptionPane.showMessageDialog(null, "El arcvhivo se descargó con exito en la ruta " + pdfDes.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al descargar archivo");
            }
        }
    }

    public void getDetalles(int id, String vCol, Datos d) {
        
        String docRes = "";
        getInfo(id, vCol, d);
        
        if (vCol.equals("Nombres Estudiante")) {
            
            jfraDetalles.jLNombresRemD.setText(est.getNombres());
            jfraDetalles.jLApellidosRemD.setText(est.getApellidos());
            jfraDetalles.jLCorreoRemD.setText(est.getCorreo());
            jfraDetalles.jLTelefonoRemD.setText(est.getTelefono());
            jfraDetalles.jLCNRemD.setText("Carrera");
            jfraDetalles.jLCarreraNomEmpresaRemD.setText(ControladorTabla.getCarrera(est.getCarrera()));
            jfraDetalles.jLSNRemD.setText("Semestre");
            jfraDetalles.jLSemNitRemD.setText("" + est.getSemestre());
        } else {
            
            jfraDetalles.jLNombresRemD.setText(emp.getNombres());
            jfraDetalles.jLApellidosRemD.setText(emp.getApellidos());
            jfraDetalles.jLCorreoRemD.setText(emp.getCorreo());
            jfraDetalles.jLTelefonoRemD.setText(emp.getTelefono());
            jfraDetalles.jLCNRemD.setText("Nombre Empresa");
            jfraDetalles.jLCarreraNomEmpresaRemD.setText(emp.getNombreEmpresa());
            jfraDetalles.jLSNRemD.setText("Nit");
            jfraDetalles.jLSemNitRemD.setText(emp.getNit());
        }
        
        jfraDetalles.jLNombresDesD.setText(des.getNombres());
        jfraDetalles.jLApellidosDesD.setText(des.getApellidos());
        jfraDetalles.jLCorreoDesD.setText(des.getCorreo());
        jfraDetalles.jLTelefonoDesD.setText(des.getTelefono());
        jfraDetalles.jLCargoDesD.setText(des.getCargo());
        jfraDetalles.jLAreaDesD.setText(des.getArea());
        
        jfraDetalles.jLNombreDocD.setText(doc.getNombreArchivo());
        jfraDetalles.jLFechaDocD.setText("" + doc.getFecha());
        jfraDetalles.jLNumRadDocD.setText(doc.getNumRadicado());
        jfraDetalles.jLTpRadDocD.setText(doc.isTipoRadicado() ? "Respuesta" : "Entrega");
        jfraDetalles.jLAsuntoDocD.setText(doc.getAsunto());
        jfraDetalles.jLAnexosDocD.setText(doc.getAnexos());
        jfraDetalles.jLReqResDocD.setText(doc.isReqRespuesta() ? "Si" : "NO");
        jfraDetalles.jLTpDocD.setText(ControladorTabla.getTpDoc(doc.getTipoDocumento()));
        
        docRes = getDocRes(doc.getRespuestaId(), d);
        jfraDetalles.jLRespuestaDocD.setText(docRes);
        
    }

    public void getInfo(int id, String vCol, Datos d) {
        for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
            
            if (d.getArrayListDocumentos().get(i).getId() == id) {
                doc = d.getArrayListDocumentos().get(i);
            }
            
            if (vCol.equals("Nombres Estudiante") && d.getArrayListEstudianteRemitentes().get(i).getId() == doc.getRemitenteId()) {
                
                est = d.getArrayListEstudianteRemitentes().get(i);
                
            } else if (vCol.equals("Nombres Empleado") && d.getArrayListEmpresaRemitentes().get(i).getId() == doc.getRemitenteId()) {
                
                emp = d.getArrayListEmpresaRemitentes().get(i);
                
            }
            
            if (d.getArrayListDestinatarios().get(i).getId() == doc.getDestinatarioId()) {
                des = d.getArrayListDestinatarios().get(i);
            }
        }
    }

    private String getDocRes(int respuestaId, Datos d) {
        String res = "";
        for (int i = 0; i < d.getArrayListDocumentos().size(); i++) {
            
            if (respuestaId == d.getArrayListDocumentos().get(i).getId()) {
                res = d.getArrayListDocumentos().get(i).getNumRadicado();
            }
        }
        return res;
    }
    
    public static void copyFile(File pdf, File pdfDes) throws IOException {
        Files.copy(pdf.toPath(), pdfDes.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
