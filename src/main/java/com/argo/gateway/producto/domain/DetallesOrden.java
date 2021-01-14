package com.argo.gateway.producto.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class DetallesOrden implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalles;

    @Column()
    private String codigo_producto;
    @Column()
    private String color;

    @Column()
    private String marca;
    @Column()
    private String modelo;
    @Column()
    private String nombre;

    @Column()
    private String talla;

    @ManyToOne(targetEntity = TipoProducto.class)
    @JoinColumn(name = "tipo_producto")
    private TipoProducto tipoProducto;


    @ManyToOne(targetEntity = OrdenDeCompra.class)
    @JoinColumn
    private OrdenDeCompra idOrden;

    @Column
    private BigDecimal descuento;

    @Column()
    private BigDecimal precioUnitario;

    @Column
    private int cantidad;


    @Column
    private String unidadMedida;

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Transient
    private BigDecimal subTotal;

    public DetallesOrden() {

    }

    public int getIdDetalles() {
        return idDetalles;
    }

    public void setIdDetalles(int idDetalles) {
        this.idDetalles = idDetalles;
    }

    public OrdenDeCompra getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDeCompra idOrden) {
        this.idOrden = idOrden;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getSubTotal() {
        return (this.getPrecioUnitario().multiply(new BigDecimal(this.getCantidad()))).subtract(this.getDescuento());
    }


    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto;
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

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public DetallesOrden(String codigo_producto, String color, String marca, String modelo, String nombre, String talla, OrdenDeCompra idOrden, BigDecimal descuento, BigDecimal precioUnitario, int cantidad,TipoProducto tipo
        ,String unidadMedida


    ) {
        this.codigo_producto = codigo_producto;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.nombre = nombre;
        this.talla = talla;
        this.idOrden = idOrden;
        this.descuento = descuento;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.tipoProducto=tipo;
        this.unidadMedida=unidadMedida;
    }


    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


}
