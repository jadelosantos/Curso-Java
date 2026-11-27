package com.elcorteingles;

import jakarta.persistence.*;

@Entity
@Table(name="alumnos")
public class Alumno {
    @Id
    private int id;
    private String nombre;
    private int edad;

    public Alumno() {

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Alumno\n");
        sb.append("id: ").append(id);
        sb.append("nombre: ").append(nombre).append('\n');
        sb.append("edad: ").append(edad);
        return sb.toString();
    }
}
