/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Documento;

/**
 *
 * @author Aula 104
 */
public interface IDaoDocumento {
    
    public boolean registrarDocumento(Documento documento);
    public int getIdDocumento(String nombreArchivo);
    public boolean asignarDocumento(int propietarioId, int documentoId, String nombreTabla);
}
