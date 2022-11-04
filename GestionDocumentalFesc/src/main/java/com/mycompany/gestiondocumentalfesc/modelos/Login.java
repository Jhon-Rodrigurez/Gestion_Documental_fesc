
package com.mycompany.gestiondocumentalfesc.modelos;


public class Login {
    
    private int id;
    private String nombreUsuario;
    private String contraseña;
    private int idUsuario;

    public Login() {
    }

    public Login(int id, String nombreUsuario, String contraseña, int idUsuario) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
