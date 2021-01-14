package com.argo.gateway.movimientos.domain;

import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Salida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalida;
    @Column
    private String combustible;
    @Column
    private String empresa;
    @Column
    private String equipo;
    @Enumerated(EnumType.STRING)
    private estadoMovimiento movimiento;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column
    private String placa;
    @Column
    private String modelo;

    @Column(name = "vale_salida")
    private String valeSalida;


    @OneToMany(mappedBy = "idSalida")
    List<SalidaDetalles> detalles;


    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenDestino;

    @ManyToOne(targetEntity = Almacen.class)
    @JoinColumn
    private Almacen almacenOrigen;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User usuarioEntrega;


    @ManyToOne(targetEntity = User.class)
    @JoinColumn
    private User usuarioRecibe;



    @OneToOne
    @JoinColumn
    private Requerimiento requerimiento;


    public Salida(String combustible, String empresa, String equipo, estadoMovimiento movimiento, Date fechaSalida, String placa, String modelo, String valeSalida, Almacen almacenDestino, Almacen almacenOrigen, User usuarioEntrega, User usuarioRecibe) {
        this.combustible = combustible;
        this.empresa = empresa;
        this.equipo = equipo;
        this.movimiento = movimiento;
        this.fechaSalida = fechaSalida;
        this.placa = placa;
        this.modelo = modelo;
        this.valeSalida = valeSalida;
        this.almacenDestino = almacenDestino;
        this.almacenOrigen = almacenOrigen;
        this.usuarioEntrega = usuarioEntrega;
        this.usuarioRecibe = usuarioRecibe;
    }

    public Salida() {

    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public estadoMovimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(estadoMovimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
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

    public String getValeSalida() {
        return valeSalida;
    }

    public void setValeSalida(String valeIngreso) {
        this.valeSalida = valeIngreso;
    }

    public Almacen getAlmacenDestino() {
        return almacenDestino;
    }

    public void setAlmacenDestino(Almacen almacenDestino) {
        this.almacenDestino = almacenDestino;
    }

    public Almacen getAlmacenOrigen() {
        return almacenOrigen;
    }

    public void setAlmacenOrigen(Almacen almacenOrigen) {
        this.almacenOrigen = almacenOrigen;
    }

    public User getUsuarioEntrega() {
        return usuarioEntrega;
    }

    public void setUsuarioEntrega(User usuarioEntrega) {
        this.usuarioEntrega = usuarioEntrega;
    }

    public User getUsuarioRecibe() {
        return usuarioRecibe;
    }

    public void setUsuarioRecibe(User usuarioRecibe) {
        this.usuarioRecibe = usuarioRecibe;
    }

    public Requerimiento getRequerimiento() {
        return requerimiento;
    }

    public void setRequerimiento(Requerimiento requerimiento) {
        this.requerimiento = requerimiento;
    }

    public List<SalidaDetalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<SalidaDetalles> detalles) {
        this.detalles = detalles;
    }
}
