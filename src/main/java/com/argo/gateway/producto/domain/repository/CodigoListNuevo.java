package com.argo.gateway.producto.domain.repository;

import java.math.BigDecimal;

public interface CodigoListNuevo {

    String getCodigo();


    String getDescripcion();


    String getModelo();


    String getMarca();


    String getColor();


    String getTalla();


    String getTipo();

    BigDecimal getPrecio();
    int getCantidad();
}
