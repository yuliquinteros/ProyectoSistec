package com.ada.sistec.proyectoFinal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String nombreProd;

    private int cantidad;

    @OneToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id")
    private Proveedor proveedor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tipo_p", referencedColumnName = "id")
    private TipoProd id_tipo_p;

    public int getId() { return id;   }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProd() {
        return nombreProd;
    }

    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public TipoProd getId_tipo_p() {
        return id_tipo_p;
    }

    public void setId_tipo_p(TipoProd id_tipo_p) {
        this.id_tipo_p = id_tipo_p;
    }
}