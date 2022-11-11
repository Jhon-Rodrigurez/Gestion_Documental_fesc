

package com.mycompany.gestiondocumentalfesc;

import com.mycompany.gestiondocumentalfesc.controladores.ControladorConsultar;
import com.mycompany.gestiondocumentalfesc.vistas.JFrameConsultar;


public class GestionDocumentalFesc {

    public static void main(String[] args) {
        JFrameConsultar jfConsultar = new JFrameConsultar();
        ControladorConsultar ctConsultar = new ControladorConsultar(jfConsultar);
        ctConsultar.inicio();
        jfConsultar.setVisible(true);
    }
}
