
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Login;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameLoginUsuario;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistroUsuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class DaoLogin extends Conexion implements IDaoLogin {
    
    JFrameRegistroUsuario jFrameRegistroUsuario = new JFrameRegistroUsuario();
    JFrameLoginUsuario jFrameLoginUsuario = new JFrameLoginUsuario();
    
    @Override
    public boolean registrarUsuario(Login login) {
        
        String nombre = jFrameRegistroUsuario.txtNombreRegistro.getText();
        String apellido = jFrameRegistroUsuario.txtApellidoRegistro.getText();
        String correo = jFrameRegistroUsuario.txtCorreoRegistro.getText();
        String cargo = jFrameRegistroUsuario.jcbxCargo.getSelectedItem().toString();
        String password = String.valueOf(jFrameRegistroUsuario.txtContrasenaRegistro.getPassword());
        String confirmarPassword = String.valueOf(jFrameRegistroUsuario.txtConfirContrasena.getPassword());
        
        PreparedStatement ps;
        String sql = "INSERT INTO `usuario`(`nombres`, `apellidos`, `correo`, `cargo`) VALUES (?,?,?,?)";
        
        try {
            ps = conectar().prepareStatement(sql);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, correo);
            ps.setString(4, cargo);
            
            if(ps.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Usuario registrado con exito.");
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario. " + e);
            } finally{
            try {
                conectar().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+ e.getMessage());
                }
            }
        
        return false;
        
    }

    @Override
    public boolean loguearse(Login login) {
        
        String correo = jFrameLoginUsuario.txtCorreoLogin.getText();
        PreparedStatement ps;
        ResultSet rs;
        
        String sql = "SELECT correo FROM usuario WHERE correo=?";
        
        try {
            ps = conectar().prepareStatement(sql);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            
            if(rs.next()) {
                JFrameConsultar rgf = new JFrameConsultar();
                rgf.setVisible(true);
                rgf.pack();
                rgf.setLocationRelativeTo(null);
                rgf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JOptionPane.showMessageDialog(null, "Iniciaste sesion con el correo " + jFrameLoginUsuario.txtCorreoLogin.getText());
                
            }
            else {
                JOptionPane.showMessageDialog(null, "Correo o clave incorrecta.");
            }
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al iniciar sesion " + e.getMessage());
        } finally {
            try {
                conectar().close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion "+ e.getMessage());
                }
            }
        return false;
    }   
}
