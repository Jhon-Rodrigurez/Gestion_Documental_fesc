
package com.mycompany.gestiondocumentalfesc.modelos;


public class EstudianteRemitente extends Persona {
    
    private String carrera;
    private String semestre;

    public EstudianteRemitente() {
    }

    public EstudianteRemitente(String carrera, String semestre) {
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public EstudianteRemitente(String carrera, String semestre, int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(id, documento, nombres, apellidos, correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
