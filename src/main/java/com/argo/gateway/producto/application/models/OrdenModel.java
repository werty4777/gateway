package com.argo.gateway.producto.application.models;

import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;

import java.util.Date;

public interface OrdenModel {


    String getCodigo();
    Date getFechaOrden();
    EstadoRequerimiento getEstadoOrden();
    String getProveedor();


}
