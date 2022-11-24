

package com.mycompany.gestiondocumentalfesc;

import com.mycompany.gestiondocumentalfesc.controladores.ControladorRegistrar;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameRegistrar;


public class GestionDocumentalFesc {

    public static void main(String[] args) {
        
        JFrameRegistrar jFrameRegistrar = new JFrameRegistrar();
        
        ControladorRegistrar controladorRegistrar = new ControladorRegistrar(jFrameRegistrar);
        controladorRegistrar.iniciar();
        
        jFrameRegistrar.setVisible(true);
    }
}
