
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class ListadoDestinatarios {
    
    ArrayList<Destinatario> arrayListDestinatarios;
    
    public ListadoDestinatarios() {
        arrayListDestinatarios = new ArrayList<>();
    }
    
    public void agregarDestinatarios(Destinatario ds) {
        arrayListDestinatarios.add(ds);
    }
}
