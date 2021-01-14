package com.argo.gateway.movimientos.application.models;

public class entradaModel {
    private String observaciones;
    private String tipoComprobante;
    private String valeIngreso;
    private String idUsuarioRecibe;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getValeIngreso() {
        return valeIngreso;
    }

    public void setValeIngreso(String valeIngreso) {
        this.valeIngreso = valeIngreso;
    }

    public String getIdUsuarioRecibe() {
        return idUsuarioRecibe;
    }

    public void setIdUsuarioRecibe(String idUsuarioRecibe) {
        this.idUsuarioRecibe = idUsuarioRecibe;
    }
}
