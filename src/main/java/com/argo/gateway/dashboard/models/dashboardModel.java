package com.argo.gateway.dashboard.models;

import com.argo.gateway.producto.application.models.productoModels;

import java.util.List;

public class dashboardModel {


    private int reqespera;
    private int entradaProductos;
    private int salidaProductos;
    private int cantidadProductos;

    List<requerimientoModelDashboard> listaRequerimientosEspera;
    List<requerimientoModelDashboard> listaRequerimientosAceptado;
    List<requerimientoModelDashboard> listaRequerimientosRechazado;
    List<entradasSemanales> listaEntradasSemanales;
    List<SalidasSemanales> listaSalidasSemanales;
    List<TotalExistenciasMensuales> listaTotalExistenciasMensuales;


    public List<requerimientoModelDashboard> getListaRequerimientosEspera() {
        return listaRequerimientosEspera;
    }

    public void setListaRequerimientosEspera(List<requerimientoModelDashboard> listaRequerimientosEspera) {
        this.listaRequerimientosEspera = listaRequerimientosEspera;
    }

    public List<requerimientoModelDashboard> getListaRequerimientosAceptado() {
        return listaRequerimientosAceptado;
    }

    public void setListaRequerimientosAceptado(List<requerimientoModelDashboard> listaRequerimientosAceptado) {
        this.listaRequerimientosAceptado = listaRequerimientosAceptado;
    }

    public List<requerimientoModelDashboard> getListaRequerimientosRechazado() {
        return listaRequerimientosRechazado;
    }

    public void setListaRequerimientosRechazado(List<requerimientoModelDashboard> listaRequerimientosRechazado) {
        this.listaRequerimientosRechazado = listaRequerimientosRechazado;
    }

    List<productoModels>  listaProductos;


    public int getReqespera() {
        return reqespera;
    }

    public void setReqespera(int reqespera) {
        this.reqespera = reqespera;
    }

    public int getEntradaProductos() {
        return entradaProductos;
    }

    public void setEntradaProductos(int entradaProductos) {
        this.entradaProductos = entradaProductos;
    }

    public int getSalidaProductos() {
        return salidaProductos;
    }

    public void setSalidaProductos(int salidaProductos) {
        this.salidaProductos = salidaProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public List<productoModels> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<productoModels> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<entradasSemanales> getListaEntradasSemanales() {
        return listaEntradasSemanales;
    }

    public void setListaEntradasSemanales(List<entradasSemanales> listaEntradasSemanales) {
        this.listaEntradasSemanales = listaEntradasSemanales;
    }

    public List<SalidasSemanales> getListaSalidasSemanales() {
        return listaSalidasSemanales;
    }

    public void setListaSalidasSemanales(List<SalidasSemanales> listaSalidasSemanales) {
        this.listaSalidasSemanales = listaSalidasSemanales;
    }

    public List<TotalExistenciasMensuales> getListaTotalExistenciasMensuales() {
        return listaTotalExistenciasMensuales;
    }

    public void setListaTotalExistenciasMensuales(List<TotalExistenciasMensuales> listaTotalExistenciasMensuales) {
        this.listaTotalExistenciasMensuales = listaTotalExistenciasMensuales;
    }
}
