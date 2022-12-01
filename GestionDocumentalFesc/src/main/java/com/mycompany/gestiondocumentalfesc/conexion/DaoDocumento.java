/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarDocumento;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.swing.JTextField;

/**
 *
 * @author Aula 104
 */
public class DaoDocumento extends Conexion implements IDaoDocumento {

    JFrameRegistrarDocumento jrd = new JFrameRegistrarDocumento();

    @Override
    public boolean registrarDocumento(Documento documento) {

        String sql;
        String nombreArchivo = jrd.txtNombreArchivo.getText();
        String rutaArchivo = jrd.txtRutaArchivo.getText();
        String fecha = ((JTextField) jrd.jDateFecha.getDateEditor().getUiComponent()).getText();
        String numRadicado = jrd.txtNumeroRadicado.getText();
        String tipoRadicado = jrd.jcbxTipoRadicado.getSelectedItem().toString();
        String tipoDocumento = jrd.jcbxTipoDocumento.getSelectedItem().toString();
        String asunto = jrd.txtAsunto.getText();
        String numAnexo = jrd.txtNumeroAnexos.getText();
        boolean reqRespuesta = jrd.jcbRequiereRespuesta.isSelected();

        sql = "INSERT INTO `documento`(`nombre_archivo`, `ruta_archivo`, `fecha`, `num_radicado`, `tipo_radicado`, `tipo_documento`, `asunto`, `anexos`, `req_respuesta`) VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conectar().prepareStatement(sql);
            ps.setString(1, nombreArchivo);
            ps.setString(2, rutaArchivo);
            ps.setDate(3, (Date) Date.valueOf(fecha));
            ps.setString(4, numRadicado);
            ps.setString(5, tipoRadicado);
            ps.setString(6, tipoDocumento);
            ps.setString(7, asunto);
            ps.setString(8, numAnexo);
            ps.setBoolean(9, reqRespuesta);
            int consulta4 = ps.executeUpdate();

            if (consulta4 > 0) {
                System.out.println("Datos del documento subidos con exito");
            }
        } catch (SQLException e) {
            System.out.println("Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getIdDocumento(String nombreArchivo) {
        int id = 0;
        
        String sql = "SELECT documento.id FROM `documento` WHERE documento.nombre_archivo = '"+nombreArchivo+"'";
        
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

    @Override
    public boolean relacionar(int propietarioId, int destinoId, String nombreTabla) {
        
        boolean res = false;
        String sql = "INSERT INTO `?`(`id_telefono`, `id_?`) VALUES (?,?)";
        
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            
            ps.setString(1, nombreTabla);
            ps.setString(2, nombreTabla);
            ps.setString(3, ""+propietarioId);
            ps.setString(4, ""+destinoId);
            
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

}
