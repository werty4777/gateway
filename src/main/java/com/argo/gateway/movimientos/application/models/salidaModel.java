package com.argo.gateway.movimientos.application.models;

public class salidaModel {


    public String idUserEntrega;

    private String combustible;
    private String empresa;

    private String eequipo;

    private String placa;
    private String modelo;
    private String valeIngreso;


    public String getIdUserEntrega() {
        return idUserEntrega;
    }

    public void setIdUserEntrega(String idUserEntrega) {
        this.idUserEntrega = idUserEntrega;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getEequipo() {
        return eequipo;
    }

    public void setEequipo(String eequipo) {
        this.eequipo = eequipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getValeIngreso() {
        return valeIngreso;
    }

    public void setValeIngreso(String valeIngreso) {
        this.valeIngreso = valeIngreso;
    }
}
