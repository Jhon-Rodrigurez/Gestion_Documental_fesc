/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
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
public class DaoEmpresaRemitente extends Conexion implements IDaoEmpresaRemitente {

    JFrameRegistrarEntidades jfre = new JFrameRegistrarEntidades();

    @Override
    public boolean registrarEmpresaRemitente(EmpresaRemitente empresaRemitente) {

        String sql;
        String docEmpresaRemitente = jfre.txtDocEmpresa.getText();
        String nombreEmpleadoRemitente = jfre.txtNombreEmpleadoEmpresa.getText();
        String apellidoEmpleadoRemitente = jfre.txtApellidoEmpleadoEmpresa.getText();
        String correoEmpresaRemitente = jfre.txtCorreoEmpresa.getText();
        String nombreEmpresaRemitente = jfre.txtNombreEmpresa.getText();
        String nit = jfre.txtNit.getText();
//        String telefonoEmpresaRemitente = txtTelefonoEmpresa.getText();

        sql = "INSERT INTO `empresa`(`documento`, `nombres`, `apellidos`, `correo`, `nombre_empresa`, `nit`) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, docEmpresaRemitente);
            ps.setString(2, nombreEmpleadoRemitente);
            ps.setString(3, apellidoEmpleadoRemitente);
            ps.setString(4, correoEmpresaRemitente);
            ps.setString(5, nombreEmpresaRemitente);
            ps.setString(6, nit);
//            ps.setString(6, telefonoEmpresaRemitente);
            int consulta2 = ps.executeUpdate();

            if (consulta2 > 0) {
                JOptionPane.showMessageDialog(null, "Datos de la empresa subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getIdEmpresaRemitente(String nombreEmpresa) {
        String query;
        ResultSet rs;
        String nombre = jfre.txtNombreEmpresa.getText();
        query = "SELECT telefono.num_telefono FROM telefono INNER JOIN telefono_empresa on id_telefono = telefono.id";
        
        try {
            PreparedStatement ps = conectar().prepareStatement(query);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            
            
        } catch (SQLException ex) {
        }
        return 0;
    }

    @Override
    public boolean asignarTelefonoEmpresaRemitente(int empresaId, int telefonoId) {
        String sql;
        String telefono = jfre.txtTelefonoEmpresa.getText();
        
        sql = "INSERT INTO `telefono`(`num_telefono`) VALUES (?)";
        
        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(empresaId, telefono);
        } catch (SQLException ex) {
        }
        return false;
    }

}
