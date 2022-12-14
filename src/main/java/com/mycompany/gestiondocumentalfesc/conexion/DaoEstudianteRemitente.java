/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarEntidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aula 104
 */
public class DaoEstudianteRemitente extends Conexion implements IDaoEstudianteRemitente {

    JFrameRegistrarEntidades jfre = new JFrameRegistrarEntidades();

    @Override
    public boolean registrarEstudianteRemitente(EstudianteRemitente estudianteRemitente) {

        String sql;
        String docEstudianteRemitente = jfre.txtDocEstudiante.getText();
        String nombreEstudianteRemitente = jfre.txtNombreEstudiante.getText();
        String apellidoEstudianteRemitente = jfre.txtApellidosEstudiante.getText();
        String correoEstudianteRemitente = jfre.txtCorreoEstudiante.getText();
        String carrera = jfre.jComboBoxCarrera.getSelectedItem().toString();
        String semestre = jfre.txtSemestre.getText();
//        String telefonoEstudianteRemitente = txtTelefonoEstudiante.getText();

        sql = "INSERT INTO `estudiante`(`documento`, `nombres`, `apellidos`, `correo`, `carrera`, `semestre`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, docEstudianteRemitente);
            ps.setString(2, nombreEstudianteRemitente);
            ps.setString(3, apellidoEstudianteRemitente);
            ps.setString(4, correoEstudianteRemitente);
            ps.setString(5, carrera);
            ps.setString(6, semestre);
//            ps.setString(6, telefonoEstudianteRemitente);
            int consulta1 = ps.executeUpdate();

            if (consulta1 > 0) {
                System.out.println("Datos del estudiante subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getIdEstudianteRemitente(String documento) {
        String query;
        ResultSet rs;
        String docEstudiante = jfre.txtDocEstudiante.getText();
        
        query="SELECT estudiante.id FROM estudiante INNER JOIN estudiante_doc WHERE estudiante.documento=?";
        
        try {
            PreparedStatement ps = conectar().prepareStatement(query);
            ps.setString(1, docEstudiante);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            System.out.println("Error al subir el documento " + ex.getLocalizedMessage());
        }
        return 0;
    }

    @Override
    public boolean asignarTelefonoEstudianteRemitente(int estudianteId, int telefonoId) {
        String sql;
        String telefonoEstudiante = jfre.txtTelefonoEstudiante.getText();
        
        sql = "INSERT INTO `telefono`(`num_telefono`) VALUES (?)";
        
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, telefonoEstudiante);
            int consulta1 = ps.executeUpdate();
            
            if(consulta1 > 0) {
                System.out.println("Telefono estudiante subido");
            }
        } catch (SQLException ex) {
        }
        return false;
    }

}
