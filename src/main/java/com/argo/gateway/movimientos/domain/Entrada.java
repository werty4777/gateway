package com.argo.gateway.movimientos.domain;

import com.argo.gateway.movimientos.domain.enm.TipoEntrada;
import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import com.argo.gateway.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Entrada implements Serializable {



    @Temporal(TemporalType.DATE)
    private Date fechaEntrada;


    @OneToMany(mappedBy = "idEntrada")
    List<EntradaDetalles> detalles;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEntrada;
    @Enumerated(EnumType.STRING)
    private estadoMovimiento movimiento;
    @Column
    private String observaciones;
    @Column
    private String tipoComprobante;
    @Column
    private String valeIngreso;
    @OneToOne(targetEntity = Requerimiento.class)
    @JoinColumn(name = "id_requerimiento")
    private Requerimiento idRequerimiento;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn(name = "id_almacen_recibe")
    private Almacen idAlmacenRecibe;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn(name = "id_almacen_entrega")
    private Almacen idAlmacenEntrega;
    //usuario recibe
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_user_recibe")
    private User idUser;

    @Enumerated(EnumType.STRING)
    @Column
    private TipoEntrada tipoEntrada;


    public Entrada(estadoMovimiento movimiento, String observaciones, String tipoComprobante, String valeIngreso, Requerimiento idRequerimiento, Almacen idAlmacenRecibe, Almacen idAlmacenEntrega, User idUser,TipoEntrada tipoEntrada,Date fechaEntrada) {
        this.movimiento = movimiento;
        this.observaciones = observaciones;
        this.tipoComprobante = tipoComprobante;
        this.valeIngreso = valeIngreso;
        this.idRequerimiento = idRequerimiento;
        this.idAlmacenRecibe = idAlmacenRecibe;
        this.idAlmacenEntrega = idAlmacenEntrega;
        this.idUser = idUser;
        this.tipoEntrada=tipoEntrada;
        this.fechaEntrada=fechaEntrada;
    }

    public Entrada() {

    }


    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public estadoMovimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(estadoMovimiento movimiento) {
        this.movimiento = movimiento;
    }

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

    public Requerimiento getIdRequerimiento() {
        return idRequerimiento;
    }

    public void setIdRequerimiento(Requerimiento idRequerimiento) {
        this.idRequerimiento = idRequerimiento;
    }

    public Almacen getIdAlmacenRecibe() {
        return idAlmacenRecibe;
    }

    public void setIdAlmacenRecibe(Almacen idAlmacenRecibe) {
        this.idAlmacenRecibe = idAlmacenRecibe;
    }

    public Almacen getIdAlmacenEntrega() {
        return idAlmacenEntrega;
    }

    public void setIdAlmacenEntrega(Almacen idAlmacenEntrega) {
        this.idAlmacenEntrega = idAlmacenEntrega;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public List<EntradaDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<EntradaDetalles> detalles) {
        this.detalles = detalles;
    }

    public TipoEntrada getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(TipoEntrada tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
