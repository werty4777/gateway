package com.argo.gateway.producto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "tipo_producto")
public class TipoProducto {

    @Id
    private int idTipo;

    private String tipo;

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
