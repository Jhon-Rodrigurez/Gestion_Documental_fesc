

package com.mycompany.gestiondocumentalfesc;

import com.mycompany.gestiondocumentalfesc.controladores.ControladorConsultar;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;


public class GestionDocumentalFesc {

    public static void main(String[] args) {
        
        JFrameConsultar jfc = new JFrameConsultar();
        
        ControladorConsultar ctC = new ControladorConsultar(jfc);
        ctC.iniciar();
        
        jfc.setVisible(true);
        jfc.setLocationRelativeTo(null);
    }
}
