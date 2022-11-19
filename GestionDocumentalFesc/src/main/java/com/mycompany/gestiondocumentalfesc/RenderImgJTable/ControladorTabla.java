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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aula 103
 */
public class ControladorTabla implements MouseListener{

    JTable tabla;
    Datos dt;
    DefaultTableModel tableModelConsultar;

    public ControladorTabla(JTable tabla, Datos dt) {
        this.tabla = tabla;
        this.tabla.addMouseListener(this);
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
        
        tabla.setDefaultRenderer(Object.class, new RenderImg());
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
        
        tableModelConsultar.addColumn("id Documento");
        tableModelConsultar.addColumn("nombre documento");
        tableModelConsultar.addColumn("ver");
        tableModelConsultar.addColumn("descargar");
        
        tabla.setModel(tableModelConsultar);
        tabla.setRowHeight(32);
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
        
        if (dt.getArrayListDocumentos().size() > 0) {
            for (int i = 0; i < dt.getArrayListDocumentos().size(); i++) {
                Object[] fila = new Object[9];
                Documento doc = dt.getArrayListDocumentos().get(i);
                Destinatario des = dt.getArrayListDestinatarios().get(i);
                
                if (e) {
                    EstudianteRemitente est = dt.getArrayListEstudianteRemitentes().get(i);
                    
                    fila[0] = getCarrera(est.getCarrera());
                    fila[1] = est.getSemestre();
                    
                } else {
                    EmpresaRemitente emp = dt.getArrayListEmpresaRemitentes().get(i);
                    
                    fila[0] = emp.getNombres();
                    fila[1] = emp.getCorreo();
                }
                
                fila[2] = des.getNombres();
                fila[3] = des.getCorreo();
                fila[4] = des.getTelefono();
                
                fila[5] = doc.getId();
                fila[6] = doc.getNombreArchivo();
                
                File pdf = new File(doc.getRutaArchivo());
                
                if (pdf.exists()) {
                    fila[7] = new JButton("ver");
                    fila[8] = new JButton("des");
                } else {
                    fila[7] = new JButton("Vacio");
                    fila[8] = new JButton("Vacio");
                }
                tableModelConsultar.addRow(fila);
            }
            tabla.setModel(tableModelConsultar);
        }
    }
    
    public static void copyFile(File pdf, File pdfDes) throws IOException {
        Files.copy(pdf.toPath(), pdfDes.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        int col = tabla.getColumnModel().getColumnIndexAtX(e.getX());
        int row = e.getY() / tabla.getRowHeight();
        System.out.println("click");
        if (row < tabla.getRowCount() && row >= 0 && col < tabla.getColumnCount() && col >= 0) {
            
            int id = (int) tabla.getValueAt(row, 5);
            Object value = tabla.getValueAt(row, col);
            
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
