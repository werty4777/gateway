package com.argo.gateway.producto.application.models.detalles;

import java.math.BigDecimal;

public class detallesordenmodelo {
    int idDetalles;
    String codigoProducto;
    String nombre;
    String talla;
    String  color;
    String modelo;
    String marca;
    String idTipo;
    int cantidad;
    String unidadMedida;
    BigDecimal precioUnitario;
    BigDecimal descuento;
    BigDecimal subTotal;

    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
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

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public detallesordenmodelo(int idDetalles, String codigoProducto, String nombre, String talla, String color, String modelo, String marca, String idTipo, int cantidad, String unidadMedida, BigDecimal precioUnitario, BigDecimal descuento, BigDecimal subTotal) {
        this.idDetalles = idDetalles;
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.talla = talla;
        this.color = color;
        this.modelo = modelo;
        this.marca = marca;
        this.idTipo = idTipo;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.precioUnitario = precioUnitario;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }
}
