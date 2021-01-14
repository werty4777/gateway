package com.argo.gateway.movimientos.domain;

import com.argo.gateway.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "salida_detalles")
public class SalidaDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;

    @Column
    private int cantidad;


    private BigDecimal precioUnitario;

    @JsonIgnore
    @ManyToOne(targetEntity = Salida.class)
    @JoinColumn(name = "id_salida")
    private Salida idSalida;


    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn(name = "id_producto")
    private CodigoProducto idProducto;

    @Column
    private BigDecimal total;

    public BigDecimal getTotal() {
        return this.getIdProducto().getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()));
    }



    public SalidaDetalles() {



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

    public Salida getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(Salida idSalida) {
        this.idSalida = idSalida;
    }

    public CodigoProducto getIdProducto() {
        return idProducto;
    }



    public void setIdProducto(CodigoProducto idProducto) {
        this.idProducto = idProducto;
    }

    public SalidaDetalles(int cantidad, Salida idSalida, CodigoProducto idProducto,BigDecimal precioUnitario) {
        this.cantidad = cantidad;
        this.idSalida = idSalida;
        this.idProducto = idProducto;
        this.precioUnitario = precioUnitario;
        this.total = this.idProducto.getPrecioUnitario().multiply(new BigDecimal(this.cantidad));
    }

    @Override
    public String toString() {
        return "SalidaDetalles{" +
                "idDetalles=" + idDetalles +
                ", cantidad=" + cantidad +
                ", idSalida=" + idSalida +
                ", idProducto=" + idProducto +
                '}';
    }
}
