/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Datos;
import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrarEntidades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
                JOptionPane.showMessageDialog(null, "Datos del estudiante subidos con exito");
            }

        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(null, "Error al subir datos " + e.getMessage());
        }
        return false;
    }

    @Override
    public int getIdEstudianteRemitente(String documento) {
        int id = 0;
        
        String sql = "SELECT estudiante.id FROM `estudiante` WHERE estudiante.documento = '"+documento+"'";
        
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
    public Datos getDocumentoEstudiante(String documentoEstudiante) {
        Datos d = null;
        
        ArrayList<EstudianteRemitente> arrayListEst = new ArrayList<>();
        ArrayList<Documento> arrayListDoc = new ArrayList<>();
        ArrayList<Destinatario> arrayListDes = new ArrayList<>();
        
        EstudianteRemitente est = new EstudianteRemitente();
        Documento doc = new Documento();
        Destinatario des = new Destinatario();
        
        String sql = "SELECT * FROM (SELECT estudiante.id,estudiante.documento,estudiante.nombres,estudiante.apellidos,estudiante.correo,estudiante.carrera,estudiante.semestre,telefono.num_telefono FROM `estudiante`\n" +
                "INNER JOIN telefono_estudiante on telefono_estudiante.id_estudiante = estudiante.id\n" +
                "INNER JOIN telefono on telefono.id = telefono_estudiante.id_telefono) as estudiante\n" +
                "\n" +
                "INNER JOIN estudiante_doc on estudiante_doc.id_estudiante = estudiante.id\n" +
                "INNER JOIN documento on documento.id = estudiante_doc.id_documento\n" +
                "INNER JOIN destinatario_doc on destinatario_doc.id_documento = documento.id\n" +
                "\n" +
                "INNER JOIN (SELECT destinatario.id,destinatario.documento,destinatario.nombres,destinatario.apellidos,destinatario.correo,destinatario.cargo ,destinatario.area,telefono.num_telefono FROM `destinatario`\n" +
                "INNER JOIN telefono_destinatario on telefono_destinatario.id_destinatario = destinatario.id\n" +
                "INNER JOIN telefono on telefono.id = telefono_destinatario.id_destinatario) as destinatario \n" +
                "on destinatario.id = destinatario_doc.id_destinatario\n" +
                "WHERE estudiante.documento = '"+documentoEstudiante+"'";
        
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                est.setId(rs.getInt(0));
                est.setDocumento(rs.getString(1));
                est.setNombres(rs.getString(2));
                est.setApellidos(rs.getString(3));
                est.setCorreo(rs.getString(4));
                est.setCarrera(rs.getInt(5));
                est.setSemestre(rs.getInt(6));
                est.setTelefono(rs.getString(7));
                
                doc.setId(rs.getInt(10));
                doc.setNombreArchivo(rs.getString(11));
                doc.setRutaArchivo(rs.getString(12));
                Timestamp f = new Timestamp(rs.getDate(13).getTime());
                doc.setFecha(f);
                doc.setNumRadicado(rs.getString(14));
                doc.setTipoRadicado(rs.getBoolean(15));
                doc.setTipoDocumento(rs.getInt(16));
                doc.setAsunto(rs.getString(17));
                doc.setAnexos(rs.getString(18));
                doc.setReqRespuesta(rs.getBoolean(19));
                
                
                des.setId(rs.getInt(22));
                des.setDocumento(rs.getString(23));
                des.setNombres(rs.getString(24));
                des.setApellidos(rs.getString(25));
                des.setCorreo(rs.getString(26));
                des.setCargo(rs.getString(27));
                des.setArea(rs.getString(28));
                des.setTelefono(rs.getString(29));
                
                arrayListEst.add(est);
                arrayListDoc.add(doc);
                arrayListDes.add(des);
            }
            
            d.setArrayListEstudianteRemitentes(arrayListEst);
            d.setArrayListDocumentos(arrayListDoc);
            d.setArrayListDestinatarios(arrayListDes);
            
        } catch (SQLException e) {
            System.out.println("Error al leer los datos "+e.getMessage());
        }finally{
            try {
                conectar().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+e);
            }
        }
        
        return d;
    }

}
