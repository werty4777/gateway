package com.argo.gateway.requerimiento.application.models;

import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.gateway.requerimiento.domain.enm.TipoRequerimiento;

import java.util.Date;

public interface RequerimientoQuery {

    String getCodigo();
    String getRemitente();
    Date getFechaEmision();
    TipoRequerimiento getTipoRequerimiento();
    EstadoRequerimiento getEstadoRequerimiento();
    String getEmpleado();
}
