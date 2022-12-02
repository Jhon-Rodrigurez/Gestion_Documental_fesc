/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.RenderImgJTable;

import com.mycompany.gestiondocumentalfesc.controladores.ControladorDetalles;
import com.mycompany.gestiondocumentalfesc.modelos.*;
import com.mycompany.gestiondocumentalfesc.vistas.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aula 103
 */
public class ControladorTabla implements MouseListener{

    JFrameConsultar jframeC;
    Datos dt;
    DefaultTableModel tableModelConsultar;

    public ControladorTabla(JFrameConsultar jframeC, Datos dt) {
        this.jframeC = jframeC;
        this.dt = dt;
        this.jframeC.jTablaC.addMouseListener(this);
        this.tableModelConsultar = new DefaultTableModel();
    }
    
    public static String getCarrera(int c) {
        
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
    
//    public Image getImagen(String ruta) {
//        try {
//            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
//            Image mainIcon = icon.getImage();
//            return mainIcon;
//        } catch (Exception e) {
//            System.err.println("Error al cargar imagenes: " + e.getMessage());
//        }
//        return null;
//    }
    
    public void setColumnsJTableC(boolean e) {
        
        jframeC.jTablaC.setDefaultRenderer(Object.class, new RenderImg());
        tableModelConsultar = new DefaultTableModel() {
            
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        if (e) {
            tableModelConsultar.addColumn("Nombres Estudiante");
            tableModelConsultar.addColumn("Apellidos Estudiante");
            tableModelConsultar.addColumn("carrera Estudiante");
        } else {
            tableModelConsultar.addColumn("Nombres Empleado");
            tableModelConsultar.addColumn("Apellidos Empleado");
            tableModelConsultar.addColumn("nombre Empresa");
        }
        
        tableModelConsultar.addColumn("Nombres Destinatario");
        tableModelConsultar.addColumn("Cargo Destinatario");
        tableModelConsultar.addColumn("Area Destinatario");
        
        tableModelConsultar.addColumn("id Documento");
        tableModelConsultar.addColumn("nombre documento");
        tableModelConsultar.addColumn("Num Radicado");
        tableModelConsultar.addColumn("Respuesta");
        
        tableModelConsultar.addColumn("Detalles");
        
    }
    
    public static String getTpDoc(int tipoDocumento) {
        
        String tpDoc = "";
        
        switch (tipoDocumento) {
            
            case 1:
                tpDoc = "Carta";
                break;
            case 2:
                tpDoc = "Solicitud";
                break;
            case 3:
                tpDoc = "Derecho de peticion";
                break;
            case 4:
                tpDoc = "Citacion";
                break;
            case 5:
                tpDoc = "Memorando";
                break;
            case 6:
                tpDoc = "Caja";
                break;
            case 7:
                tpDoc = "Factura";
                break;
            case 8:
                tpDoc = "Remision";
                break;
            case 9:
                tpDoc = "Paquete";
                break;
        }
        return tpDoc;
    }
    
    public void mostrarConsulta(boolean e) {
        setColumnsJTableC(e);
        
//        ImageIcon iconPdf = null;
//        ImageIcon iconVs = null;
//        ImageIcon iconEl = null;
//        
//        if (getImagen("/imagen/32pdf.png") != null && getImagen("/imagen/visualizar.png") != null && getImagen("/imagen/eliminar.png") != null) {
//            iconPdf = new ImageIcon(getImagen("/imagen/32pdf.png"));
//            iconVs = new ImageIcon(getImagen("/imagen/visualizar.png"));
//            iconEl = new ImageIcon(getImagen("/imagen/eliminar.png"));
//        }
        
        if (dt.getArrayListDocumentos().size() > 0 && dt != null) {
            for (int i = 0; i < dt.getArrayListDocumentos().size(); i++) {

                Object[] fila = new Object[11];
                    
                Documento doc = dt.getArrayListDocumentos().get(i);
                Destinatario des = dt.getArrayListDestinatarios().get(i);

                if (e) {
                    EstudianteRemitente est = dt.getArrayListEstudianteRemitentes().get(i);

                    fila[0] = est.getNombres();
                    fila[1] = est.getApellidos();
                    fila[2] = getCarrera(est.getCarrera());

                } else {
                    EmpresaRemitente emp = dt.getArrayListEmpresaRemitentes().get(i);

                    fila[0] = emp.getNombres();
                    fila[1] = emp.getApellidos();
                    fila[2] = emp.getNombreEmpresa();

                }

                fila[3] = des.getNombres();
                fila[4] = des.getCargo();
                fila[5] = des.getArea();

                fila[6] = doc.getId();
                fila[7] = doc.getNombreArchivo();
                fila[8] = doc.getNumRadicado();
                fila[9] = doc.getRespuestaId() > 0? doc.getRespuestaId() : "Sin Respuesta";

                File pdf = new File(doc.getRutaArchivo());

                if (pdf.exists()) {
                    fila[10] = new JButton("Detalles");
                } else {
                    fila[10] = new JButton("Vacio");
                }
                tableModelConsultar.addRow(fila);
            }
            
            jframeC.jTablaC.setModel(tableModelConsultar);
            jframeC.jTablaC.setRowHeight(32);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int col = jframeC.jTablaC.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / jframeC.jTablaC.getRowHeight();
        
        if (row < jframeC.jTablaC.getRowCount() && row >= 0 && col < jframeC.jTablaC.getColumnCount() && col >= 0) {
            
            int id = (int) jframeC.jTablaC.getValueAt(row, 6);
            Object value = jframeC.jTablaC.getValueAt(row, col);
            String vCol = jframeC.jTablaC.getColumnName(0);
            
            if (value instanceof JButton) {
                
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                
                if (btn.getText().equals("Detalles")) {
                    
                    JFrameDetalles jframeDetalles = new JFrameDetalles();
                    
                    ControladorDetalles ctD = new ControladorDetalles(jframeDetalles);
                    ctD.iniciar(id, vCol, dt);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el archivo");
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");
    }
    
}
