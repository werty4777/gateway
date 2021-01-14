package com.argo.gateway.requerimiento.application.models;

import java.util.Date;
import java.util.List;

public class RequerimientoModelTraslado {


    private int idAlmacenEnvia;
    private Date fechaEntrega;
    private String observaciones;


    private List<DetallesRequerimientoModel> detalles;


    public int getIdAlmacenEnvia() {
        return idAlmacenEnvia;
    }

    public void setIdAlmacenEnvia(int idAlmacenEnvia) {
        this.idAlmacenEnvia = idAlmacenEnvia;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<DetallesRequerimientoModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesRequerimientoModel> detalles) {
        this.detalles = detalles;
    }


    public RequerimientoModelTraslado(int idAlmacenEnvia, Date fechaEntrega, String observaciones, List<DetallesRequerimientoModel> detalles) {
        this.idAlmacenEnvia = idAlmacenEnvia;
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.detalles = detalles;
    }
}
