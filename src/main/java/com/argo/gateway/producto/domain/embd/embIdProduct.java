package com.argo.gateway.producto.domain.embd;


import com.argo.gateway.producto.domain.CodigoProducto;
import com.commons.user.models.entity.area.domain.Almacen;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class embIdProduct implements Serializable {

    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn(name = "id_almacen")
    private Almacen idAlmacen;

    @ManyToOne(targetEntity = CodigoProducto.class)
    @JoinColumn(name = "codigo")
    private CodigoProducto codigo;


    public embIdProduct() {
    }

    public embIdProduct(Almacen idAlmacen, CodigoProducto codigo) {
        this.idAlmacen = idAlmacen;
        this.codigo = codigo;
    }

    public String getIndex() {

        return this.codigo.getCodigo().split("-")[0];


    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public CodigoProducto getCodigo() {
        return codigo;
    }

    public void setCodigo(CodigoProducto codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        embIdProduct idProduct = (embIdProduct) o;
        return Objects.equals(idAlmacen, idProduct.idAlmacen) &&
                Objects.equals(codigo, idProduct.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlmacen, codigo);
    }

    @Override
    public String toString() {
        return "embIdProduct{" +
                "idAlmacen=" + idAlmacen +
                ", codigo=" + codigo +
                '}';
    }
}
