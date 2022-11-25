/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.RenderImgJTable;

import com.mycompany.gestiondocumentalfesc.modelos.Datos;
import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
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
        this.jframeC.jTablaC.addMouseListener(this);
        this.dt = dt;
        this.tableModelConsultar = new DefaultTableModel();
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
    
    public Image getImagen(String ruta) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = icon.getImage();
            return mainIcon;
        } catch (Exception e) {
            System.err.println("Error al cargar imagenes: " + e.getMessage());
        }
        return null;
    }
    
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
            tableModelConsultar.addColumn("correo Estudiante");
            tableModelConsultar.addColumn("Telefono Estudiante");
            tableModelConsultar.addColumn("carrera Estudiante");
            tableModelConsultar.addColumn("semestre Estudiante");
        } else {
            tableModelConsultar.addColumn("Nombres Empleado");
            tableModelConsultar.addColumn("Apellidos Empleado");
            tableModelConsultar.addColumn("correo Empresa");
            tableModelConsultar.addColumn("Telefono Empresa");
            tableModelConsultar.addColumn("nombre Empresa");
            tableModelConsultar.addColumn("Nit Empresa");
        }
        
        tableModelConsultar.addColumn("Nombres Destinatario");
        tableModelConsultar.addColumn("Apellidos Destinatario");
        tableModelConsultar.addColumn("correo Destinatario");
        tableModelConsultar.addColumn("Telefono Destinatario");
        tableModelConsultar.addColumn("Cargo Destinatario");
        tableModelConsultar.addColumn("Area Destinatario");
        
        tableModelConsultar.addColumn("id Documento");
        tableModelConsultar.addColumn("nombre documento");
        tableModelConsultar.addColumn("Fecha");
        tableModelConsultar.addColumn("Num Radicado");
        tableModelConsultar.addColumn("Tp Radicado");
        tableModelConsultar.addColumn("Asunto");
        tableModelConsultar.addColumn("Anexos");
        tableModelConsultar.addColumn("Req Respuesta");
        tableModelConsultar.addColumn("Tp Documento");
        tableModelConsultar.addColumn("Respuesta");
        
        tableModelConsultar.addColumn("ver");
        tableModelConsultar.addColumn("descargar");
        
        jframeC.jTablaC.setModel(tableModelConsultar);
        jframeC.jTablaC.setRowHeight(32);
    }
    
    private Object getTpDoc(int tipoDocumento) {
        
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
        
        ImageIcon iconPdf = null;
        ImageIcon iconVs = null;
        ImageIcon iconEl = null;
        
        if (getImagen("/imagen/32pdf.png") != null && getImagen("/imagen/visualizar.png") != null && getImagen("/imagen/eliminar.png") != null) {
            iconPdf = new ImageIcon(getImagen("/imagen/32pdf.png"));
            iconVs = new ImageIcon(getImagen("/imagen/visualizar.png"));
            iconEl = new ImageIcon(getImagen("/imagen/eliminar.png"));
        }
        
        if (dt != null) {
            
            if (dt.getArrayListDocumentos().size() > 0) {
            for (int i = 0; i < dt.getArrayListDocumentos().size(); i++) {
                
                try {
                Object[] fila = new Object[24];
                Documento doc = dt.getArrayListDocumentos().get(i);
                Destinatario des = dt.getArrayListDestinatarios().get(i);
                
                if (e) {
                    EstudianteRemitente est = dt.getArrayListEstudianteRemitentes().get(i);
                    
                    fila[0] = est.getNombres();
                    fila[1] = est.getApellidos();
                    fila[2] = est.getCorreo();
                    fila[3] = est.getTelefono();
                    fila[4] = getCarrera(est.getCarrera());
                    fila[5] = est.getSemestre();
                    
                } else {
                    EmpresaRemitente emp = dt.getArrayListEmpresaRemitentes().get(i);
                    
                    fila[0] = emp.getNombres();
                    fila[1] = emp.getApellidos();
                    fila[2] = emp.getCorreo();
                    fila[3] = emp.getTelefono();
                    fila[4] = emp.getNombreEmpresa();
                    fila[5] = emp.getNit();
                    
                }
                
                fila[6] = des.getNombres();
                fila[7] = des.getApellidos();
                fila[8] = des.getCorreo();
                fila[9] = des.getTelefono();
                fila[10] = des.getCargo();
                fila[11] = des.getArea();
                
                fila[12] = doc.getId();
                fila[13] = doc.getNombreArchivo();
                fila[14] = doc.getFecha();
                fila[15] = doc.getNumRadicado();
                fila[16] = doc.isTipoRadicado()? "Entrega": "Respuesta";
                fila[17] = doc.getAsunto();
                fila[18] = doc.getAnexos();
                fila[19] = doc.isReqRespuesta()? "Si": "No";
                fila[20] = getTpDoc(doc.getTipoDocumento());
                fila[21] = doc.getRespuestaId() > 0? doc.getRespuestaId() : "Sin Respuesta";
                
                File pdf = new File(doc.getRutaArchivo());
                
                if (pdf.exists()) {
                    fila[22] = new JButton("ver");
                    fila[23] = new JButton("des");
                } else {
                    fila[22] = new JButton("Vacio");
                    fila[23] = new JButton("Vacio");
                }
                tableModelConsultar.addRow(fila);
                } catch (Exception ex) {
                    System.out.println("i");
                }
            }
            jframeC.jTablaC.setModel(tableModelConsultar);
            }
        }
    }
    
    public static void copyFile(File pdf, File pdfDes) throws IOException {
        Files.copy(pdf.toPath(), pdfDes.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int col = jframeC.jTablaC.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / jframeC.jTablaC.getRowHeight();
        System.out.println("click");
        if (row < jframeC.jTablaC.getRowCount() && row >= 0 && col < jframeC.jTablaC.getColumnCount() && col >= 0) {
            
            int id = (int) jframeC.jTablaC.getValueAt(row, 12);
            Object value = jframeC.jTablaC.getValueAt(row, col);
            
            if (value instanceof JButton) {
                
                ((JButton) value).doClick();
                JButton btn = (JButton) value;
                Documento doc = new Documento();
                
                for (int i = 0; i < dt.getArrayListDocumentos().size(); i++) {
                        
                    if (dt.getArrayListDocumentos().get(i).getId() == id) {
                        
                        doc = dt.getArrayListDocumentos().get(i);
                    }
                }
                File pdf = new File(doc.getRutaArchivo());
                
                if (btn.getText().equalsIgnoreCase("ver")) {
                    
                    try {
                        Desktop.getDesktop().open(pdf);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    
                } else if(btn.getText().equalsIgnoreCase("des")) {
                    
                    File pdfDes = new File("C:\\Users\\Familia\\Downloads\\"+ doc.getNombreArchivo());
                    
                    try {
                        copyFile(pdf, pdfDes);
                        JOptionPane.showMessageDialog(null, "El arcvhivo se descargó con exito en la ruta " + pdfDes.getAbsolutePath());
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Error al descargar archivo");
                    }
                    
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el archivo");
                }
            } else {
                
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
