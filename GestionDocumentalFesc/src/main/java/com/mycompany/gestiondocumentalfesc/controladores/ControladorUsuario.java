
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.conexion.DaoLogin;
import com.mycompany.gestiondocumentalfesc.conexion.IDaoLogin;
import com.mycompany.gestiondocumentalfesc.modelos.Login;
import com.mycompany.gestiondocumentalfesc.modelos.Usuario;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorUsuario implements ActionListener{
    
    private Usuario usuario;
    private Login login;
    private JFrameRegistroUsuario jFrameRegistroUsuario;
    private IDaoLogin iDaoLogin;

    public ControladorUsuario(Usuario usuario, Login login, JFrameRegistroUsuario jFrameRegistroUsuario, IDaoLogin iDaoLogin) {
        this.usuario = new Usuario();
        this.login = new Login();
        this.jFrameRegistroUsuario = jFrameRegistroUsuario;
        this.iDaoLogin = new DaoLogin();
        this.jFrameRegistroUsuario.jbRegistrar.addActionListener(this);
        this.jFrameRegistroUsuario.jbLimpiar.addActionListener(this);
        this.jFrameRegistroUsuario.jchbMostrarContrasenas.addActionListener(this);
    }
    
    public void inicio() {
        jFrameRegistroUsuario.setLocationRelativeTo(jFrameRegistroUsuario);
        jFrameRegistroUsuario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            
        if(e.getSource() == jFrameRegistroUsuario.jbRegistrar) {
            String nombre = jFrameRegistroUsuario.txtNombreRegistro.getText();
            String apellido = jFrameRegistroUsuario.txtApellidoRegistro.getText();
            String correo = jFrameRegistroUsuario.txtCorreoRegistro.getText();
            String cargo = getJcbxCargo();
            String password = String.valueOf(jFrameRegistroUsuario.txtContrasenaRegistro.getPassword());
            String confirmarPassword = String.valueOf(jFrameRegistroUsuario.txtConfirContrasena.getPassword());
            
            if(correo.equals("")) {
            JOptionPane.showMessageDialog(null, "El correo es vacio.");
            }
            else if(password.equals("")) {
            JOptionPane.showMessageDialog(null, "Contraseña no guardada, por favor agregue una.");
            }
            else if(!password.equals(confirmarPassword)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            }
            
            if(!nombre.equals("") && !apellido.equals("") && !correo.equals("") && !cargo.equals("")) {
                while(true) {
                    if(iDaoLogin.registrarUsuario(login)) {
                        JOptionPane.showMessageDialog(null, "Usuario registrado");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No se permiten campos vacios");
                    }
                }
            }
            if(e.getSource() == jFrameRegistroUsuario.jbLimpiar) {
                limpiar();
            }
            if(e.getSource() == jFrameRegistroUsuario.jchbMostrarContrasenas) {
                mostrarContrasenas();
            }
        }
    }

    public String getJcbxCargo() {
        if(jFrameRegistroUsuario.jcbxCargo.getSelectedItem().equals("Usuario")) {
            return "1";
        }
        else if(jFrameRegistroUsuario.jcbxCargo.getSelectedItem().equals("Administrador")) {
            return "2";
        }
        else {
            JOptionPane.showMessageDialog(null, "Seleccione el rol");
        }
        return null;
    }

    private void limpiar() {
        jFrameRegistroUsuario.txtNombreRegistro.setText(null);
        jFrameRegistroUsuario.txtApellidoRegistro.setText(null);
        jFrameRegistroUsuario.txtCorreoRegistro.setText(null);
        jFrameRegistroUsuario.txtContrasenaRegistro.setText(null);
        jFrameRegistroUsuario.txtConfirContrasena.setText(null);
    }

    private void mostrarContrasenas() {
        if(jFrameRegistroUsuario.jchbMostrarContrasenas.isSelected()) {
            jFrameRegistroUsuario.txtContrasenaRegistro.setEchoChar((char) 0);
            jFrameRegistroUsuario.txtConfirContrasena.setEchoChar((char) 0);
        }
        else {
            jFrameRegistroUsuario.txtContrasenaRegistro.setEchoChar('•');
            jFrameRegistroUsuario.txtConfirContrasena.setEchoChar('•');
        }
    }
    
    
    
}
