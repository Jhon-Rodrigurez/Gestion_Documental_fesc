/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.*;
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
        int id = 0;
        
        String sql = "SELECT empresa.id FROM `empresa` WHERE empresa.nombre_empresa = '"+nombreEmpresa+"'";
        
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
    public Datos getDocumentoEmpresa(String nombreEmpresa) {
        Datos d = null;
        
        ArrayList<EmpresaRemitente> arrayListEmp = new ArrayList<>();
        ArrayList<Documento> arrayListDoc = new ArrayList<>();
        ArrayList<Destinatario> arrayListDes = new ArrayList<>();
        
        EmpresaRemitente emp = new EmpresaRemitente();
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
                "WHERE estudiante.documento = '"+nombreEmpresa+"'";
        
        try {
            PreparedStatement ps= conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                emp.setId(rs.getInt(0));
                emp.setDocumento(rs.getString(1));
                emp.setNombres(rs.getString(2));
                emp.setApellidos(rs.getString(3));
                emp.setCorreo(rs.getString(4));
                emp.setNombreEmpresa(rs.getString(5));
                emp.setNit(rs.getString(6));
                emp.setTelefono(rs.getString(7));
                
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
                
                arrayListEmp.add(emp);
                arrayListDoc.add(doc);
                arrayListDes.add(des);
            }
            
            d.setArrayListEmpresaRemitentes(arrayListEmp);
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
