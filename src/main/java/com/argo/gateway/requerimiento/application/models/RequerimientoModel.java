package com.argo.gateway.requerimiento.application.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class RequerimientoModel {


    private Date fechaEntrega;
    private String observaciones;


    private List<DetallesRequerimientoModel> detalles;


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

    public RequerimientoModel() {
    }

    public RequerimientoModel(Date fechaEntrega, String observaciones, List<DetallesRequerimientoModel> detalles) {
        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.detalles = detalles;
    }
}
