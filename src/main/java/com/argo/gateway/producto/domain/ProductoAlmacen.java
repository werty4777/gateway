package com.argo.gateway.producto.domain;

import com.argo.gateway.producto.domain.embd.embIdProduct;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "producto_almacen")
public class ProductoAlmacen {


    @EmbeddedId
    private embIdProduct id;

    @Column
    private int stock;


    public embIdProduct getId() {
        return id;
    }

    public void setId(embIdProduct id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ProductoAlmacen(embIdProduct id, int stock) {
        this.id = id;
        this.stock = stock;
    }

    public ProductoAlmacen() {
    }

    @Override
    public String toString() {
        return "ProductoAlmacen{" +
                "id=" + id +
                ", stock=" + stock +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoAlmacen that = (ProductoAlmacen) o;
        return stock == that.stock &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stock);
    }
}
