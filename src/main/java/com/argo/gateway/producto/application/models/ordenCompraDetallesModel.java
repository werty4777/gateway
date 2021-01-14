package com.argo.gateway.producto.application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ordenCompraDetallesModel {

    @JsonProperty(required = false)
    private String codigo;


    @JsonProperty(required = false)
    private int tipo;

    private String color;
    private String marca;
    private String modelo;
    private String descripcion;
    private String talla;
    private String unidadMedida;
    private BigDecimal precioUnitario;
    private BigDecimal descuento;
    private int cantidad;
    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @JsonProperty(required = false)
    public int getTipo() {
        return tipo;
    }

    @JsonProperty(required = false)
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @JsonProperty(required = false)
    public String getCodigo() {
        return codigo;
    }

    @JsonProperty(required = false)
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }



    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
}
