package com.argo.gateway.producto.application.models;

import java.math.BigDecimal;

public interface productoModels {


    String getCodigo();

    String getNombre();

    BigDecimal getPrecioUnitario();

    int getCantidad();
}
