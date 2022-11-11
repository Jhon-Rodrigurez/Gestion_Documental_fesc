/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.RenderImgJTable.RenderImg;
import com.mycompany.gestiondocumentalfesc.modelos.*;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Familia
 */
public class ControladorConsultar implements ActionListener{

    JFrameConsultar jFrameConsultar;
    Datos datos;
    ControladorEstudianteRemitente ctEstudiante;
    ControladorEmpresaRemitente ctEmpresa;
    DefaultTableModel tableModelConsultar;
    
    public ControladorConsultar(JFrameConsultar jFrameConsultar) {
        this.jFrameConsultar = jFrameConsultar;
        this.datos = new Datos();
        this.ctEstudiante = new ControladorEstudianteRemitente();
        this.ctEmpresa = new ControladorEmpresaRemitente();
        this.tableModelConsultar = new DefaultTableModel();
    }
    
    public void inicio() {
        setCbFiltro();
        setCbTpEntidad();
        jFrameConsultar.jTbConsultar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == jFrameConsultar.jTbConsultar) {
            
            String tpEntidad = jFrameConsultar.jCbTipoEntidadC.getSelectedItem().toString();
            String identificacion = jFrameConsultar.jTfIdentificacionC.getText();
            String filtro = jFrameConsultar.jCbFiltoC.getSelectedItem().toString();
            String filtroFecha = jFrameConsultar.jTfFiltroFechaC.getText();
            
            if (tpEntidad.equals("Estudiante")) {
                datos = ctEstudiante.getInfoDocumentos(identificacion, filtro, filtroFecha);
                mostrarConsulta(true);
            } else {
                datos = ctEmpresa.getInfoDocumentos(identificacion, filtro, filtroFecha);
                mostrarConsulta(false);
            }
        }
    }

    public void mostrarConsulta(boolean e) {
        setColumnsJTableC(e);
        limpiarjTablaC();
        
        ImageIcon iconPdf = null;
        ImageIcon iconVs = null;
        ImageIcon iconEl = null;
        
        if (getImagen("/imagen/32pdf.png") != null && getImagen("/imagen/visualizar.png") != null && getImagen("/imagen/eliminar.png") != null) {
            iconPdf = new ImageIcon(getImagen("/imagen/32pdf.png"));
            iconVs = new ImageIcon(getImagen("/imagen/visualizar.png"));
            iconEl = new ImageIcon(getImagen("/imagen/eliminar.png"));
        }
        
        if (datos.getArrayListDocumentos().size() > 0) {
            for (int i = 0; i < datos.getArrayListDocumentos().size(); i++) {
                Object[] fila = new Object[9];
                Documento doc = datos.getArrayListDocumentos().get(i);
                Destinatario des = datos.getArrayListDestinatarios().get(i);
                
                if (e) {
                    EstudianteRemitente est = datos.getArrayListEstudianteRemitentes().get(i);
                    
                    fila[0] = getCarrera(est.getCarrera());
                    fila[1] = est.getSemestre();
                    
                } else {
                    EmpresaRemitente emp = datos.getArrayListEmpresaRemitentes().get(i);
                    
                    fila[0] = emp.getNombres();
                    fila[1] = emp.getCorreo();
                }
                
                fila[2] = des.getNombres();
                fila[3] = des.getCorreo();
                fila[4] = des.getTelefono();
                
                fila[5] = doc.getFecha();
                fila[6] = doc.getNombreArchivo();
                
                File pdf = new File(doc.getRutaArchivo());
                
                if (pdf.exists()) {
                    fila[7] = new JButton(iconPdf);
                    fila[8] = new JButton(iconVs);
                } else {
                    fila[7] = new JButton(iconEl);
                    fila[8] = new JButton(iconEl);
                }
                tableModelConsultar.addRow(fila);
            }
            jFrameConsultar.jTablaC.setModel(tableModelConsultar);
        }
    }
    
    public void setColumnsJTableC(boolean e) {
        
        jFrameConsultar.jTablaC.setDefaultRenderer(Object.class, new RenderImg());
        tableModelConsultar = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        if (e) {
            tableModelConsultar.addColumn("carrera");
            tableModelConsultar.addColumn("semestre");
        } else {
            tableModelConsultar.addColumn("nombre empleado");
            tableModelConsultar.addColumn("correo");
        }
        
        tableModelConsultar.addColumn("nombre destinatario");
        tableModelConsultar.addColumn("correo destinatario");
        tableModelConsultar.addColumn("telefono destinatario");
        
        tableModelConsultar.addColumn("fecha");
        tableModelConsultar.addColumn("nombre documento");
        tableModelConsultar.addColumn("ver");
        tableModelConsultar.addColumn("descargar");
        
        jFrameConsultar.jTablaC.setModel(tableModelConsultar);
        jFrameConsultar.jTablaC.setRowHeight(32);
    }
    
    public Image getImagen(String ruta) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(ruta));
            Image mainIcon = icon.getImage();
            return mainIcon;
        } catch (Exception e) {
            System.err.println("Error al cargar imagenes: " + e.getMessage());
        }
        return null;
    }
    
    public String getCarrera(int c) {
        
        String carrera;
        
        switch(c) {
            case 1:
                carrera = "Diseño grafico";
                break;
            case 2:
                carrera = "Diseño de modas";
                break;
            case 3:
                carrera = "Hoteleria y turismo";
                break;
            case 4:
                carrera = "Ingenieria de software";
                break;
            case 5:
                carrera = "Negocios internacionales";
                break;
            case 6:
                carrera = "Administracion financiera";
                break;
            case 7:
                carrera = "Logistica empresarial";
                break;
            default:
                carrera = "N/A";
                break;
        }
        return carrera;
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
    
    public void limpiarjTablaC() {
        
        if (tableModelConsultar.getRowCount() > 0) {
            for (int i = tableModelConsultar.getRowCount() - 1; i > -1; i--) {
                tableModelConsultar.removeRow(i);
            }
        }
    }
}
