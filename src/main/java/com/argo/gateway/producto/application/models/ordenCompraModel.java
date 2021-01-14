package com.argo.gateway.producto.application.models;

import com.argo.gateway.producto.domain.enm.moneda;

import java.util.Date;
import java.util.List;

public class ordenCompraModel {



    private String numeroComprobante;
    private detallesProveedorModel proveedor;
    private List<ordenCompraDetallesModel> detalles;
    private Date fechaEntrega;
    private String direccionEntrega;
    private moneda monedas;
    private String condicionPago;
    private String formaPago;
    private String observaciones;





    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public detallesProveedorModel getProveedor() {
        return proveedor;
    }

    public void setProveedor(detallesProveedorModel proveedor) {
        this.proveedor = proveedor;
    }

    public List<ordenCompraDetallesModel> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ordenCompraDetallesModel> detalles) {
        this.detalles = detalles;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public moneda getMonedas() {
        return monedas;
    }

    public void setMonedas(moneda monedas) {
        this.monedas = monedas;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}
