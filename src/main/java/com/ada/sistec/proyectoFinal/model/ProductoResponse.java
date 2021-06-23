package com.ada.sistec.proyectoFinal.model;


public class ProductoResponse {
    private Producto producto;
    private String mensaje;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
