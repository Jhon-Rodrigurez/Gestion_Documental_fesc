/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Datos;
import com.mycompany.gestiondocumentalfesc.modelos.EmpresaRemitente;

/**
 *
 * @author Aula 104
 */
public interface IDaoEmpresaRemitente {
    
    public boolean registrarEmpresaRemitente(EmpresaRemitente empresaRemitente);
    public int getIdEmpresaRemitente(String nombreEmpresa);
    public Datos getDocumentoEmpresa(String nombreEmpresa);
}
