/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.EstudianteRemitente;

/**
 *
 * @author Aula 104
 */
public interface IDaoEstudianteRemitente {
    
    public boolean registrarEstudianteRemitente(EstudianteRemitente estudianteRemitente);
    public int getIdEstudianteRemitente(String documento);
    public boolean asignarTelefonoEstudianteRemitente(int estudianteId, int telefonoId);
}
