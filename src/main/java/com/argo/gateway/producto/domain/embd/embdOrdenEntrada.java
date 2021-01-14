package com.argo.gateway.producto.domain.embd;

import com.argo.gateway.movimientos.domain.Entrada;
import com.argo.gateway.producto.domain.OrdenDeCompra;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "orden_entrada")
public class embdOrdenEntrada implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToOne(targetEntity = OrdenDeCompra.class)
    @JoinColumn
    private OrdenDeCompra idOrden;

    @OneToOne(targetEntity = Entrada.class)
    @JoinColumn
    private Entrada idEntrada;


    public embdOrdenEntrada(OrdenDeCompra idOrden, Entrada idEntrada) {
        this.idOrden = idOrden;
        this.idEntrada = idEntrada;
    }

    public embdOrdenEntrada() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrdenDeCompra getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDeCompra idOrden) {
        this.idOrden = idOrden;
    }

    public Entrada getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Entrada idEntrada) {
        this.idEntrada = idEntrada;
    }
}
