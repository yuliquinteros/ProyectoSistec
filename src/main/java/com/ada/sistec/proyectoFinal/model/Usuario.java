package com.ada.sistec.proyectoFinal.model;

import javax.persistence.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private int id;
    private String nom_y_ap;
    private int dni;

    @OneToOne(cascade = CascadeType.ALL) //un usuario tiene un solo rol, si es supervisor no es vendedor
    @JoinColumn(name = "id_rol", referencedColumnName = "id") // en el 'name' va como se llama
    // la columna de mi tabla que se relaciona con la otra tabla a la q hacemos referencia
    private Rol rol;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_y_ap() {
        return nom_y_ap;
    }

    public void setNom_y_ap(String nom_y_ap) {
        this.nom_y_ap = nom_y_ap;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
