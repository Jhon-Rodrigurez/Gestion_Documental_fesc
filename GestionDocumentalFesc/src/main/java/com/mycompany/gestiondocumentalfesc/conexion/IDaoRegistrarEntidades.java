
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;
import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;
import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;


public interface IDaoRegistrarEntidades {
    
    public boolean registrarEstudianteRemitente(EstudianteRemitente estudianteRemitente);
    
    public boolean registrarEmpresaRemitente(EmpresaRemitente empresaRemitente);
    
    public boolean registrarDestinatario(Destinatario destinatario);
    
    public boolean registrarDocumento(Documento documento);
}
