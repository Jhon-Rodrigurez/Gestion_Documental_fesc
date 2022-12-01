/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

/**
 *
 * @author bibliofesc
 */
public interface IDaoTelefono {
    
    public boolean registrarTelefono(String numTelefono);
    public int getIdTelefono(String numTelefono);
}
