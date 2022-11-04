
package com.mycompany.gestiondocumentalfesc.modelos;


public class Usuario extends Persona {
    
    private int cargo;

    public Usuario() {
    }

    public Usuario(int cargo) {
        this.cargo = cargo;
    }

    public Usuario(int cargo, int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(id, documento, nombres, apellidos, correo, telefono);
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
