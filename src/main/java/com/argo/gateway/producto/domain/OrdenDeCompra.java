package com.argo.gateway.producto.domain;

import com.argo.gateway.producto.domain.enm.moneda;
import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class OrdenDeCompra implements Serializable {


    @OneToMany(mappedBy = "idOrden")
    List<DetallesOrden> detallesOrden;
    //numero comprobante
    @Column(name = "numero_comprobante", length = 50, columnDefinition = "varchar(50) default 'KARDEX DE DIFERENCIA'")
    private String numeroComprobante;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user_realizado")
    private User idUser;


    @Id
    @Column(name = "id_orden", nullable = false, unique = true)
    private String numeroOrden;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_orden")
    private Date fechaOrden;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fechaEntrega;

    @Column(nullable = false, length = 100)
    private String direccionEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private moneda monedas;

    @Column(nullable = false, length = 100)
    private String condicionPago;


    //datos del proveedor
    @Column(nullable = false, length = 70)
    private String formaPago;

    @Column(nullable = false, length = 11)
    private String ruc;

    @Column(nullable = false, length = 255)
    private String nombreProveedor;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = true, columnDefinition = "varchar(80) default 'no tiene'")
    private String correo;

    @Column(nullable = true, columnDefinition = "char(9) default 'no tiene'")
    private String phone;


    //total orden
    @Transient
    private BigDecimal subTotal;

    @Transient
    private BigDecimal descuento;

    @Transient
    private BigDecimal igv;
    @Transient
    private BigDecimal total;

    //observaciones
    @Size(max = 4000)
    private String observaciones;


    @Enumerated(EnumType.STRING)
    @Column
    private EstadoRequerimiento estadoOrden;



    @ManyToOne(targetEntity = Almacen.class)
    private Almacen idAlmacen;


    public OrdenDeCompra(String numeroComprobante, User idUser, String numeroOrden, Date fechaOrden, Date fechaEntrega, String direccionEntrega, moneda monedas, String condicionPago, String formaPago, String ruc, String nombreProveedor, String direccion, String correo, String phone, @Size(max = 4000) String observaciones, Almacen idAlmacen) {
        this.numeroComprobante = numeroComprobante;
        this.idUser = idUser;
        this.numeroOrden = numeroOrden;
        this.fechaOrden = fechaOrden;
        this.fechaEntrega = fechaEntrega;
        this.direccionEntrega = direccionEntrega;
        this.monedas = monedas;
        this.condicionPago = condicionPago;
        this.formaPago = formaPago;
        this.ruc = ruc;
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.correo = correo;
        this.phone = phone;
        this.observaciones = observaciones;
        this.idAlmacen = idAlmacen;
        this.estadoOrden=EstadoRequerimiento.ESPERA;
    }

    public OrdenDeCompra() {

    }


    public BigDecimal getSubTotal() {

        List<DetallesOrden> detallesOrden = this.getDetallesOrden();

        BigDecimal subTotal = new BigDecimal(0);


        for (DetallesOrden det : detallesOrden) {
            subTotal = det.getSubTotal().add(subTotal);


        }


        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getDescuento() {
        BigDecimal descuento = new BigDecimal(0);
        for (DetallesOrden det : detallesOrden) {
            descuento = det.getDescuento().add(descuento);


        }


        return descuento;
    }

    public BigDecimal getIgv() {

        return this.getSubTotal().multiply(new BigDecimal("0.18"));


    }

    public String getNumeroComprobante() {
        return numeroComprobante;
    }

    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    public List<DetallesOrden> getDetallesOrden() {
        return detallesOrden;
    }

    public void setDetallesOrden(List<DetallesOrden> detallesOrden) {
        this.detallesOrden = detallesOrden;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public String getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(String numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public Date getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(Date fechaOrden) {
        this.fechaOrden = fechaOrden;
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

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Almacen getIdAlmacen() {
        return idAlmacen;
    }

    public void setIdAlmacen(Almacen idAlmacen) {
        this.idAlmacen = idAlmacen;
    }

    public EstadoRequerimiento getEstadoOrden() {
        return estadoOrden;
    }

    public void setEstadoOrden(EstadoRequerimiento estadoOrden) {
        this.estadoOrden = estadoOrden;
    }
}
