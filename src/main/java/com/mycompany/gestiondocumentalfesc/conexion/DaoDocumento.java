/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarDocumento;
import java.sql.Date;
import java.sql.PreparedStatement;
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
    public int getIdDocumento(Timestamp fecha) {
        return 0;
    }

    @Override
    public boolean asignarDocumentoEntrega(int entregaId, int respuestaId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean asignarDocumentoEstudianteRemitente(int estudianteId, int documentoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean asignarDocumentoEmpresaRemitente(int empresaId, int documentoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean asignarDocumentoDestinatario(int destinatarioId, int documentoId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
