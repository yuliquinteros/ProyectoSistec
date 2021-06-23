package com.ada.sistec.proyectoFinal.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_prod")
public class TipoProd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;

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
}
