package ar.edu.unju.fi.model;

import java.util.List;

public class Alumno {
    private String nombre;
    private String apellido;
    private int dni;
    private List<String> carreras; 
    public Alumno() {
    }

    // Constructor con los parámetros necesarios
    public Alumno(String nombre, String apellido, int dni, List<String> carreras) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.carreras = carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<String> carreras) {
        this.carreras = carreras;
    }
}
