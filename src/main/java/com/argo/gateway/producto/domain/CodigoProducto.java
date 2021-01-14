package com.argo.gateway.producto.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "lista_productos")
public class CodigoProducto {


    @Id
    private String codigo;


    @Column
    private String descripcion;

    @Column
    private String modelo;

    @Column
    private String marca;

    @Column
    private String color;

    @Column
    private String talla;

    @ManyToOne(targetEntity = TipoProducto.class)
    @JoinColumn(name = "id_tipo")
    private TipoProducto tipo;


    @Column
    private BigDecimal precioUnitario;

    @Column
    private String unidadMedida;

    public CodigoProducto(String codigo, String descripcion, String modelo, String marca, String color, String talla, TipoProducto tipo, BigDecimal precioUnitario, String unidadMedida) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.unidadMedida = unidadMedida;
    }

    public CodigoProducto() {

    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto idTipo) {
        this.tipo = idTipo;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "CodigoProducto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", modelo='" + modelo + '\'' +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", talla='" + talla + '\'' +
                ", tipo=" + tipo +
                ", precioUnitario=" + precioUnitario +
                ", unidadMedida='" + unidadMedida + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodigoProducto that = (CodigoProducto) o;
        return Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(modelo, that.modelo) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(color, that.color) &&
                Objects.equals(talla, that.talla) &&
                Objects.equals(tipo, that.tipo) &&

                Objects.equals(unidadMedida, that.unidadMedida);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descripcion, modelo, marca, color, talla, tipo, precioUnitario, unidadMedida);
    }
}
