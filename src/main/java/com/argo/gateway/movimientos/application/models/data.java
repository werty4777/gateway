package com.argo.gateway.movimientos.application.models;

import java.math.BigDecimal;

public class data{

    private String descripcion;
    private String talla;
    private String marca;
    private String color;
    private String modelo;
    private String unidadMedida;
    private int cantidad;
    private BigDecimal total;

    public data(String descripcion, String talla, String marca, String color, String modelo, String unidadMedida, int cantidad, BigDecimal total) {
        this.descripcion = descripcion;
        this.talla = talla;
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.total = total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
