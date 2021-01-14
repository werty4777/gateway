package com.argo.gateway.producto.application.models.detalles;

import com.argo.gateway.producto.domain.enm.moneda;
import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;

import java.util.Date;
import java.util.List;

public class ordenCompramodeloDetalles {


        String codigo;
        String condicionPago;
        String correo;
        String direccionEntrega;
    EstadoRequerimiento estadoOrden;
        Date fechaEntrega;
        Date fechaOrden;
        moneda moneda;
        String proveedor;
        String numeroComprobante;
        String observaciones;
        String  telefono;
        String ruc;
        String almacen;
        String codigoRequerimiento;
        String usuarioEmite;
        String direccion;
        String formaPago;
        List<detallesordenmodelo> detalles;

    public ordenCompramodeloDetalles(String codigo, String condicionPago, String correo, String direccionEntrega, EstadoRequerimiento estadoOrden, Date fechaEntrega, Date fechaOrden, com.argo.gateway.producto.domain.enm.moneda moneda, String proveedor, String numeroComprobante, String observaciones, String telefono, String ruc, String almacen, String codigoRequerimiento, String usuarioEmite, String direccion, String formaPago) {
        this.codigo = codigo;
        this.condicionPago = condicionPago;
        this.correo = correo;
        this.direccionEntrega = direccionEntrega;
        this.estadoOrden = estadoOrden;
        this.fechaEntrega = fechaEntrega;
        this.fechaOrden = fechaOrden;
        this.moneda = moneda;
        this.proveedor = proveedor;
        this.numeroComprobante = numeroComprobante;
        this.observaciones = observaciones;
        this.telefono = telefono;
        this.ruc = ruc;
        this.almacen = almacen;
        this.codigoRequerimiento = codigoRequerimiento;
        this.usuarioEmite = usuarioEmite;
        this.direccion = direccion;
        this.formaPago = formaPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCondicionPago() {
        return condicionPago;
    }

    public void setCondicionPago(String condicionPago) {
        this.condicionPago = condicionPago;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoRequerimiento getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoRequerimiento estadoOrden) {
        this.estadoOrden = estadoOrden;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public com.argo.gateway.producto.domain.enm.moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(com.argo.gateway.producto.domain.enm.moneda moneda) {
        this.moneda = moneda;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }

    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    public String getUsuarioEmite() {
        return usuarioEmite;
    }

    public void setUsuarioEmite(String usuarioEmite) {
        this.usuarioEmite = usuarioEmite;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<detallesordenmodelo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<detallesordenmodelo> detalles) {
        this.detalles = detalles;
    }
}
