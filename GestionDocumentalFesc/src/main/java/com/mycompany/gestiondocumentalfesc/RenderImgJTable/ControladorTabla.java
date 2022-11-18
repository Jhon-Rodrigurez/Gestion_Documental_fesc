/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.RenderImgJTable;

import com.mycompany.gestiondocumentalfesc.controladores.ControladorEstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.Datos;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;
import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author Aula 103
 */
public class ControladorTabla implements MouseListener{

    JTable tabla;
    Datos dt;

    public ControladorTabla(JTable tabla, Datos dt) {
        this.tabla = tabla;
        this.tabla.addMouseListener(this);
        this.dt = dt;
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
                
                if (btn.getText().equalsIgnoreCase("ver")) {
                    
                    for (int i = 0; i < dt.getArrayListDocumentos().size(); i++) {
                        
                        if (dt.getArrayListDocumentos().get(i).getId() == id) {
                            
                            doc = dt.getArrayListDocumentos().get(i);
                        }
                    }
                    
                    File pdf = new File(doc.getRutaArchivo());
                    
                    try {
                        Desktop.getDesktop().open(pdf);
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                    
                } else if(btn.getText().equalsIgnoreCase("des")) {
                    
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
