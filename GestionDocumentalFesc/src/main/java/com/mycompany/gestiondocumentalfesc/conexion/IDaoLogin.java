
package com.mycompany.gestiondocumentalfesc.conexion;

import com.mycompany.gestiondocumentalfesc.modelos.Login;


public interface IDaoLogin {
    
    public boolean registrarUsuario(Login login);
    
    public boolean loguearse(Login login);
    
}
