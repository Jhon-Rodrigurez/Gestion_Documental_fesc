
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class ListadoEstudiantes {
    
    ArrayList<EstudianteRemitente> arrayListEstudianteRemitentes;
    
    public ListadoEstudiantes() {
        arrayListEstudianteRemitentes = new ArrayList<>();
    }
    
    public void agregarEstudiantes(EstudianteRemitente er) {
        arrayListEstudianteRemitentes.add(er);
    }
       
}
