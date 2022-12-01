/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarEntidades;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Aula 104
 */
public class DaoDestinatario extends Conexion implements IDaoDestinatario {

    JFrameRegistrarEntidades jfre = new JFrameRegistrarEntidades();

    @Override
    public boolean registrarDestinatario(Destinatario destinatario) {

        String sql;
        String docDestinatario = jfre.txtDocDestinatario.getText();
        String nombresDestinatario = jfre.txtNombresDestinatario.getText();
        String apellidosDestinatario = jfre.txtApellidosDestinatario.getText();
        String correoDestinatario = jfre.txtCorreoDestinatario.getText();
        String cargo = jfre.txtCargo.getText();
        String area = jfre.txtArea.getText();

        sql = "INSERT INTO `destinatario`(`documento`, `nombres`, `apellidos`, `correo`, `cargo`, `area`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, docDestinatario);
            ps.setString(2, nombresDestinatario);
            ps.setString(3, apellidosDestinatario);
            ps.setString(4, correoDestinatario);
            ps.setString(5, cargo);
            ps.setString(6, area);
            int consulta3 = ps.executeUpdate();

            if (consulta3 > 0) {
                JOptionPane.showMessageDialog(null, "Datos del destinatario subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getIdDestinatario(String documento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean asignarTelefonoDestinatario(int destinatarioId, int telefonoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
