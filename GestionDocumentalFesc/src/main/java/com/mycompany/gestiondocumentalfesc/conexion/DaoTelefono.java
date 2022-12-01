/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bibliofesc
 */
public class DaoTelefono extends Conexion implements IDaoTelefono{

    @Override
    public boolean registrarTelefono(String numTelefono) {
        
        boolean res = false;
        String sql = "INSERT INTO `telefono`(`num_telefono`) VALUES (?)";
        
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            
            ps.setString(1, numTelefono);
            
            int insertados = ps.executeUpdate();
            
            if (insertados > 0) {
                res = true;
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e.getMessage());
            res = false;
        }finally{
            try {
                conectar().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e.getMessage());
            }
        }
        return res;
    }

    @Override
    public int getIdTelefono(String numTelefono) {
        int id = 0;
        
        String sql = "SELECT telefono.id FROM `telefono` WHERE telefono.num_telefono = '"+numTelefono+"'";
        
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                id = rs.getInt("id");
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e.getMessage());
        }finally{
            try {
                conectar().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e);
            }
        }
        
        return id;
    }
}
