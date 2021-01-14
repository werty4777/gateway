package com.argo.gateway.requerimiento.domain;

import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.gateway.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Requerimiento implements Serializable {

    @OneToMany(mappedBy = "idRequerimiento")
    List<DetallesRequerimiento> detallesRequerimientoList;
    @Id
    @Column(name = "codigo_requerimiento")
    private String codigoRequerimiento;
    @Enumerated(EnumType.STRING)
    @Column
    private EstadoRequerimiento estadoRequerimiento;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenPide;
    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenRecibe;


    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_requerimiento")
    private TipoRequerimiento tipoRequerimiento;


    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision ;


    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_entrega")
    private Date fechaEntrega;


    @Column
    private String observaciones;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "requerido_por", nullable = false)
    private User requeridoPor;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "atentido_por", nullable = false)
    private User atendidoPor;



    public Requerimiento(String codigoRequerimiento, Almacen almacenPide, Almacen almacenRecibe, TipoRequerimiento tipoRequerimiento,  Date fechaEntrega, String observaciones, User requeridoPor, User atendidoPor) {
        this.codigoRequerimiento = codigoRequerimiento;
        this.almacenPide = almacenPide;
        this.almacenRecibe = almacenRecibe;
        this.tipoRequerimiento = tipoRequerimiento;

        this.fechaEntrega = fechaEntrega;
        this.observaciones = observaciones;
        this.requeridoPor = requeridoPor;
        this.atendidoPor = atendidoPor;
        this.estadoRequerimiento = EstadoRequerimiento.ESPERA;
    }


    public Requerimiento() {

    }

    public String getCodigoRequerimiento() {
        return codigoRequerimiento;
    }

    public void setCodigoRequerimiento(String codigoRequerimiento) {
        this.codigoRequerimiento = codigoRequerimiento;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntregan) {
        this.fechaEntrega = fechaEntregan;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public User getRequeridoPor() {
        return requeridoPor;
    }

    public void setRequeridoPor(User requeridoPor) {
        this.requeridoPor = requeridoPor;
    }

    public User getAtendidoPor() {
        return atendidoPor;
    }

    public void setAtendidoPor(User atentidoPor) {
        this.atendidoPor = atentidoPor;
    }

    public Almacen getAlmacenPide() {
        return almacenPide;
    }

    public void setAlmacenPide(Almacen almacenPide) {
        this.almacenPide = almacenPide;
    }

    public Almacen getAlmacenRecibe() {
        return almacenRecibe;
    }

    public void setAlmacenRecibe(Almacen almacenRecibe) {
        this.almacenRecibe = almacenRecibe;
    }

    public TipoRequerimiento getTipoRequerimiento() {
        return tipoRequerimiento;
    }

    public void setTipoRequerimiento(TipoRequerimiento tipoRequerimiento) {
        this.tipoRequerimiento = tipoRequerimiento;
    }

    public EstadoRequerimiento getEstadoRequerimiento() {
        return estadoRequerimiento;
    }

    public void setEstadoRequerimiento(EstadoRequerimiento estadoRequerimiento) {
        this.estadoRequerimiento = estadoRequerimiento;
    }

    public List<DetallesRequerimiento> getDetallesRequerimientoList() {
        return detallesRequerimientoList;
    }

    public void setDetallesRequerimientoList(List<DetallesRequerimiento> detallesRequerimientoList) {
        this.detallesRequerimientoList = detallesRequerimientoList;
    }
}
