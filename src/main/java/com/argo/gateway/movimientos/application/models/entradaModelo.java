package com.argo.gateway.movimientos.application.models;

import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;

import java.util.Date;

public interface entradaModelo {

    int getIdEntrada();
    Date getFechaEntrada();
    String getEstadoMovimiento();
    String getTipoComprobante();
    String getTipoEntrada();
}
