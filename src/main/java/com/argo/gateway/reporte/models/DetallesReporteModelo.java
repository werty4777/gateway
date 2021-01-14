package com.argo.gateway.reporte.models;

import java.math.BigDecimal;

public class DetallesReporteModelo {

    String codigo;
    String descripcion;
    String modelo;
    String marca;
    String color;
    String talla;
    String tipo;
    String unidadMedida;
    int entrada;
    int salidas;
    int stock;
    BigDecimal sumaTotales;

    BigDecimal precioUnitarioKardex;
    BigDecimal existenciasEntradas;
    BigDecimal existenciasSalidas;
    BigDecimal totalExistencias;

    public DetallesReporteModelo(String codigo, String descripcion, String modelo, String marca, String color, String talla, String tipo, String unidadMedida, int entrada, int salidas, int stock, BigDecimal sumaTotales, BigDecimal precioUnitarioKardex, BigDecimal existenciasEntradas, BigDecimal existenciasSalidas, BigDecimal totalExistencias) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.tipo = tipo;
        this.unidadMedida = unidadMedida;
        this.entrada = entrada;
        this.salidas = salidas;
        this.stock = stock;
        this.sumaTotales = sumaTotales;
        this.precioUnitarioKardex = precioUnitarioKardex;
        this.existenciasEntradas = existenciasEntradas;
        this.existenciasSalidas = existenciasSalidas;
        this.totalExistencias = totalExistencias;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalidas() {
        return salidas;
    }

    public void setSalidas(int salidas) {
        this.salidas = salidas;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getSumaTotales() {
        return sumaTotales;
    }

    public void setSumaTotales(BigDecimal sumaTotales) {
        this.sumaTotales = sumaTotales;
    }

    public BigDecimal getPrecioUnitarioKardex() {
        return precioUnitarioKardex;
    }

    public void setPrecioUnitarioKardex(BigDecimal precioUnitarioKardex) {
        this.precioUnitarioKardex = precioUnitarioKardex;
    }

    public BigDecimal getExistenciasEntradas() {
        return existenciasEntradas;
    }

    public void setExistenciasEntradas(BigDecimal existenciasEntradas) {
        this.existenciasEntradas = existenciasEntradas;
    }

    public BigDecimal getExistenciasSalidas() {
        return existenciasSalidas;
    }

    public void setExistenciasSalidas(BigDecimal existenciasSalidas) {
        this.existenciasSalidas = existenciasSalidas;
    }

    public BigDecimal getTotalExistencias() {
        return totalExistencias;
    }

    public void setTotalExistencias(BigDecimal totalExistencias) {
        this.totalExistencias = totalExistencias;
    }
}
