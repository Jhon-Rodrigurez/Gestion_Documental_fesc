
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarDocumento;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarEntidades;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DaoRegistrarEntidades extends Conexion implements IDaoRegistrarEntidades {
    
    JFrameRegistrarEntidades jfre = new JFrameRegistrarEntidades();
    JFrameRegistrarDocumento jrd = new JFrameRegistrarDocumento();
    
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

            if(consulta1 > 0) {
                JOptionPane.showMessageDialog(null, "Datos del estudiante subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

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

            if(consulta2 > 0) {
                JOptionPane.showMessageDialog(null, "Datos de la empresa subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

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

            if(consulta3 > 0) {
                JOptionPane.showMessageDialog(null, "Datos del destinatario subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean registrarDocumento(Documento documento) {
        
            String sql;
            String nombreArchivo = jrd.txtNombreArchivo.getText();
            String rutaArchivo = jrd.txtRutaArchivo.getText();
            String fecha = ((JTextField)jrd.jDateFecha.getDateEditor().getUiComponent()).getText();
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
                
                if(consulta4 > 0) {
                    System.out.println("Datos del documento subidos con exito");
                }
            } catch (SQLException e) {
                System.out.println("Error al subir datos " + e.getMessage());
        }    
        return false;
    }
}
