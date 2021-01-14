package com.argo.gateway.movimientos.application.models;

import com.argo.gateway.movimientos.domain.enm.TipoEntrada;
import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;

import java.math.BigDecimal;
import java.util.List;

public class detallesEntradaModel {

    private estadoMovimiento movimiento;
private String tipoComprobante;
private String valeIngreso;
private String almacen;
private String observaciones;
private List<data> detalles;
private TipoEntrada tipoMovimiento;
private String empleadoIngreso;


    public detallesEntradaModel(estadoMovimiento movimiento, String tipoComprobante, String valeIngreso, String almacen, String observaciones, TipoEntrada tipoMovimiento, String empleadoIngreso) {
        this.movimiento = movimiento;
        this.tipoComprobante = tipoComprobante;
        this.valeIngreso = valeIngreso;
        this.almacen = almacen;
        this.observaciones = observaciones;
        this.tipoMovimiento=tipoMovimiento;
        this.empleadoIngreso=empleadoIngreso;
    }

    public estadoMovimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(estadoMovimiento movimiento) {
        this.movimiento = movimiento;
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

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<data> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<data> detalles) {
        this.detalles = detalles;
    }

    public TipoEntrada getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoEntrada tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getEmpleadoIngreso() {
        return empleadoIngreso;
    }

    public void setEmpleadoIngreso(String empleadoIngreso) {
        this.empleadoIngreso = empleadoIngreso;
    }
}
