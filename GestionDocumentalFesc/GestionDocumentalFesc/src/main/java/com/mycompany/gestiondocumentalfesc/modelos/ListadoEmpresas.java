
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class ListadoEmpresas {
    
    ArrayList<EmpresaRemitente> arrayListEmpresaRemitentes;
    
    public ListadoEmpresas() {
        arrayListEmpresaRemitentes = new ArrayList<>();
    }
    
    public void agregarEmpresas(EmpresaRemitente emr) {
        arrayListEmpresaRemitentes.add(emr);
    }
}
