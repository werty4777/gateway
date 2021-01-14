package com.argo.gateway.movimientos.domain;

import com.argo.gateway.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "entrada_detalles")
public class EntradaDetalles {

    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn(name = "id_product")
    CodigoProducto idProduct;

    private BigDecimal precioUnitario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;
    @Column
    private int cantidad;

    @JsonIgnore
    @ManyToOne(targetEntity = Entrada.class)
    @JoinColumn(name = "id_entrada")
    private Entrada idEntrada;


    @Column
    private BigDecimal total;

    public EntradaDetalles() {

    }

    public EntradaDetalles(CodigoProducto idProduct, int cantidad, Entrada idEntrada, BigDecimal precioUnitario) {
        this.idProduct = idProduct;
        this.cantidad = cantidad;
        this.idEntrada = idEntrada;
        this.precioUnitario = precioUnitario;
        this.total = this.idProduct.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
    }

    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }

    public CodigoProducto getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(CodigoProducto idProduct) {
        this.idProduct = idProduct;
    }

    public BigDecimal getTotal() {


        return this.getIdProduct().getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()));


    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
