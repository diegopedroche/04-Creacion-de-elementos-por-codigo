package com.example.a04_creaciondeelementosporcdigo.modelos;

import java.io.Serializable;

public class Alumno implements Serializable {

    private String nombre;
    private String apellidos;
    private String ciclo;
    private char group;

    public Alumno(String nombre, String apellidos, String ciclo, char group) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciclo = ciclo;
        this.group = group;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", ciclo='" + ciclo + '\'' +
                ", group=" + group +
                '}';
    }
}
