package com.argo.gateway.requerimiento.domain;

import com.argo.gateway.producto.domain.CodigoProducto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "detalles_requerimiento")
public class DetallesRequerimiento implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalle;

    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn()
    private  CodigoProducto codigo;

    @JsonIgnore
    @ManyToOne(targetEntity = Requerimiento.class)
    @JoinColumn()
    private  Requerimiento idRequerimiento;


    @Column
    private  int cantidad;

    public DetallesRequerimiento(CodigoProducto codigo, Requerimiento idRequerimiento, int cantidad) {
        this.codigo = codigo;
        this.idRequerimiento = idRequerimiento;
        this.cantidad = cantidad;
    }

    public DetallesRequerimiento() {

    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public CodigoProducto getCodigo() {
        return codigo;
    }

    public Requerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public int getCantidad() {
        return cantidad;
    }
}
