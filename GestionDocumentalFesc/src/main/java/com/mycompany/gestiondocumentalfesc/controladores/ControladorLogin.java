
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.conexion.DaoLogin;
import com.mycompany.gestiondocumentalfesc.conexion.IDaoLogin;
import com.mycompany.gestiondocumentalfesc.modelos.Login;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameLoginUsuario;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistroUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class ControladorLogin implements ActionListener{
    
    private JFrameLoginUsuario jFrameLoginUsuario;
    private IDaoLogin iDaoLogin;
    private Login login;

    public ControladorLogin(JFrameLoginUsuario jFrameLoginUsuario) {
        this.jFrameLoginUsuario = jFrameLoginUsuario;
        this.jFrameLoginUsuario.jbIngresar.addActionListener(this);
        this.iDaoLogin = new DaoLogin();
    }
    
    public void inicio() {
        jFrameLoginUsuario.setLocationRelativeTo(jFrameLoginUsuario);
        jFrameLoginUsuario.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == jFrameLoginUsuario.jbIngresar) {
            String correo = jFrameLoginUsuario.txtCorreoLogin.getText();
            
            if(!correo.equals("")) {
                while(true) {
                    if(iDaoLogin.loguearse(login)) {
                        JOptionPane.showMessageDialog(null, "Iniciaste sesion con el correo " + jFrameLoginUsuario.txtCorreoLogin);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Correo o clave incorrecta");
                        break;
                    }
                }
            }
        }
        
        
    }

    
}
