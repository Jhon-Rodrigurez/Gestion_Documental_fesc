
package com.mycompany.gestiondocumentalfesc.modelos;

import java.util.ArrayList;


public class EstudianteRemitente extends Persona {
    
    private int carrera;
    private int semestre;

    public EstudianteRemitente() {
    }
    
    public EstudianteRemitente(int id, String nombres, String documento) {
        this.id = id;
        this.nombres = nombres;
        this.documento = documento;
    }
    
    public EstudianteRemitente(int carrera, int semestre, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(documento, nombres, apellidos, correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public EstudianteRemitente(int carrera, int semestre, int id, String documento, String nombres, String apellidos, String correo, String telefono) {
        super(id, documento, nombres, apellidos, correo, telefono);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    
    public static ArrayList<EstudianteRemitente> getEstudianteRemitentes() {
        
        ArrayList<EstudianteRemitente> arrayListEstudiantes = new ArrayList<>();
        
        int carrera = 2;
        int semestre = 5;
        int id = 1;
        String doc = "234234234";
        String nombres = "lolita";
        String apellidos = "Perez";
        String correo = "lolPer@gmail.com";
        String telefono = "3000899306";
        
        EstudianteRemitente e1 = new EstudianteRemitente(carrera, semestre, id, doc, nombres, apellidos, correo, telefono);
        
        carrera = 5;
        semestre = 3;
        id = 2;
        doc = "49823423";
        nombres = "juan";
        apellidos = "Caballo";
        correo = "juan@gmail.com";
        telefono = "4092098234";
        
        EstudianteRemitente e2 = new EstudianteRemitente(carrera, semestre, id, doc, nombres, apellidos, correo, telefono);
        
        arrayListEstudiantes.add(e1);
        arrayListEstudiantes.add(e2);
        
        return arrayListEstudiantes;
    }
    
    
    @Override
    public String toString() {
        return nombres + " - " + documento;
    }
}
