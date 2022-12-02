/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Destinatario;

/**
 *
 * @author Aula 104
 */
public interface IDaoDestinatario {
    
    public boolean registrarDestinatario(Destinatario destinatario);
    public int getIdDestinatario(String documento);
    public boolean asignarTelefonoDestinatario(int destinatarioId, int telefonoId);
}
