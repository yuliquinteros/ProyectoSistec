package com.ada.sistec.proyectoFinal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId_rol(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
