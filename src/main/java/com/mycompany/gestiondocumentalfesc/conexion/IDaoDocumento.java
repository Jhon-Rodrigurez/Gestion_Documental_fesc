/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;
import java.sql.Timestamp;

/**
 *
 * @author Aula 104
 */
public interface IDaoDocumento {
    
    public boolean registrarDocumento(Documento documento);
    public int getIdDocumento(Timestamp fecha);
    public boolean asignarDocumentoEntrega(int entregaId, int respuestaId);
    
    public boolean asignarDocumentoEstudianteRemitente(int estudianteId, int documentoId);
    public boolean asignarDocumentoEmpresaRemitente(int empresaId, int documentoId);
    public boolean asignarDocumentoDestinatario(int destinatarioId, int documentoId);
}
