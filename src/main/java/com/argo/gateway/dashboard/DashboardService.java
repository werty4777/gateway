package com.argo.gateway.dashboard;


import com.argo.gateway.almacen.domain.repository.IAlmacen;
import com.argo.gateway.util.obtenerusuario;
import com.argo.gateway.dashboard.models.SalidasSemanales;
import com.argo.gateway.dashboard.models.dashboardModel;
import com.argo.gateway.dashboard.models.entradasSemanales;
import com.argo.gateway.dashboard.models.requerimientoModelDashboard;
import com.argo.gateway.movimientos.domain.repository.IEntrada;
import com.argo.gateway.movimientos.domain.repository.IEntradaDetalles;
import com.argo.gateway.movimientos.domain.repository.ISalida;
import com.argo.gateway.movimientos.domain.repository.ISalidaDetalles;
import com.argo.gateway.producto.application.models.productoModels;
import com.argo.gateway.producto.domain.repository.ICodigoProducto;
import com.argo.gateway.producto.domain.repository.IProduct;
import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.gateway.requerimiento.domain.repository.IDetallesRequerimiento;
import com.argo.gateway.requerimiento.domain.repository.IRequerimiento;

import com.argo.gateway.util.transformarFecha;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DashboardService {

    private final IEntradaDetalles iEntradaDetalles;
    private final IEntrada iEntrada;
    private final IProduct iProduct;
    private final IRequerimiento iRequerimiento;
    private final IDetallesRequerimiento iDetallesRequerimiento;
    private final transformarFecha fecha;
    private final ICodigoProducto iCodigoProducto;
    private final IAlmacen iAlmacen;
    private final ISalida iSalida;
    private final ISalidaDetalles iSalidaDetalles;
    @Autowired
    private obtenerusuario getUser;

    public DashboardService(IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles) {
        this.iEntradaDetalles = iEntradaDetalles;
        this.iEntrada = iEntrada;
        this.iProduct = iProduct;
        this.iRequerimiento = iRequerimiento;
        this.iDetallesRequerimiento = iDetallesRequerimiento;
        this.fecha = fecha;
        this.iCodigoProducto = iCodigoProducto;
        this.iAlmacen = iAlmacen;
        this.iSalida = iSalida;
        this.iSalidaDetalles = iSalidaDetalles;
    }


    public dashboardModel dashboardData(String token) {

        User user = this.getUser.getUser(token);
        Almacen almacen = user.getIdAlmacen();


        int espera = (int) this.iRequerimiento.countByAlmacenPideAndEstadoRequerimiento(almacen, EstadoRequerimiento.ESPERA);
        int entradas = (int) this.iEntradaDetalles.misEntradas(almacen);
        int salidas = (int) this.iSalidaDetalles.misSalidas(almacen);


        List<entradasSemanales> listaEntradaSemanales = new ArrayList<>();
        List<SalidasSemanales> listaSalidasSemanales = new ArrayList<>();
        LocalDate loc = LocalDate.now();
        LocalDate lunesDate = loc.with(WeekFields.of(Locale.FRANCE).getFirstDayOfWeek());
        for (int i = 1; i < 8; i++) {

            List entradas1 = this.iEntrada.entrasByDateOfWeek(lunesDate.toString(), almacen.getIdAlmacen());
            List salidas1 = this.iSalida.salidasByDateOfWeek(lunesDate.toString(), almacen.getIdAlmacen());
            entradasSemanales entradasSemanales = new entradasSemanales();
            entradasSemanales.setDay(i);
            entradasSemanales.setEntradas(entradas1.size());
            SalidasSemanales salidasSemanales = new SalidasSemanales();
            salidasSemanales.setDay(i);
            salidasSemanales.setSalidas(salidas1.size());
            listaEntradaSemanales.add(entradasSemanales);
            listaSalidasSemanales.add(salidasSemanales);


            lunesDate = lunesDate.withDayOfMonth(lunesDate.getDayOfMonth() + 1);


        }

        int cantidadProductos = (int) this.iProduct.cantidadProductos(almacen);


        List<requerimientoModelDashboard> aceptado = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.ACEPTADO, PageRequest.of(0, 4));
        List<requerimientoModelDashboard> esperalista = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.ESPERA, PageRequest.of(0, 4));
        List<requerimientoModelDashboard> rechazado = this.iRequerimiento.dashboardRequerimiento(almacen, EstadoRequerimiento.RECHAZADO, PageRequest.of(0, 4));
        List<productoModels> productoModels = this.iProduct.productosDashboard(almacen, PageRequest.of(0, 4));
        dashboardModel modelo = new dashboardModel();
        modelo.setEntradaProductos(entradas);
        modelo.setCantidadProductos(cantidadProductos);
        modelo.setReqespera(espera);
        modelo.setSalidaProductos(salidas);
        modelo.setListaRequerimientosAceptado(aceptado);
        modelo.setListaRequerimientosRechazado(rechazado);
        modelo.setListaRequerimientosEspera(esperalista);
        modelo.setListaProductos(productoModels);
        modelo.setListaEntradasSemanales(listaEntradaSemanales);
        modelo.setListaSalidasSemanales(listaSalidasSemanales);
        return modelo;

    }


}
