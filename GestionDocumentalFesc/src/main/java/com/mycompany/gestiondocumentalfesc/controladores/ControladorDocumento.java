/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.controladores;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import java.util.ArrayList;

/**
 *
 * @author Familia
 */
public class ControladorDocumento {

    public ControladorDocumento() {
    }
    
    public ArrayList<Documento> getDocumentos() {
        return Documento.getDocumentos();
    }
    
}
