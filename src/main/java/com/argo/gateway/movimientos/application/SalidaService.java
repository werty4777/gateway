package com.argo.gateway.movimientos.application;


import com.argo.gateway.almacen.domain.repository.IAlmacen;
import com.argo.gateway.movimientos.application.models.salidaModel;
import com.argo.gateway.movimientos.domain.Entrada;
import com.argo.gateway.movimientos.domain.EntradaDetalles;
import com.argo.gateway.movimientos.domain.Salida;
import com.argo.gateway.movimientos.domain.SalidaDetalles;
import com.argo.gateway.movimientos.domain.enm.TipoEntrada;
import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;
import com.argo.gateway.movimientos.domain.repository.IEntrada;
import com.argo.gateway.movimientos.domain.repository.IEntradaDetalles;
import com.argo.gateway.movimientos.domain.repository.ISalida;
import com.argo.gateway.movimientos.domain.repository.ISalidaDetalles;
import com.argo.gateway.producto.domain.ProductoAlmacen;
import com.argo.gateway.producto.domain.embd.embIdProduct;
import com.argo.gateway.producto.domain.repository.ICodigoProducto;
import com.argo.gateway.producto.domain.repository.IProduct;
import com.argo.gateway.requerimiento.domain.repository.IDetallesRequerimiento;
import com.argo.gateway.requerimiento.domain.repository.IRequerimiento;
import com.argo.gateway.util.obtenerusuario;
import com.argo.gateway.util.transformarFecha;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalidaService {
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

    @Autowired
    public SalidaService(IEntradaDetalles iEntradaDetalles, IEntrada iEntrada, IProduct iProduct, IRequerimiento iRequerimiento, IDetallesRequerimiento iDetallesRequerimiento, transformarFecha fecha, ICodigoProducto iCodigoProducto, IAlmacen iAlmacen, ISalida iSalida, ISalidaDetalles iSalidaDetalles) {
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


    @Transactional(rollbackFor = Exception.class)
    public void confirmarSalida(salidaModel modelo, int idSalida,String token) {

        User empleado = this.getUser.getEmpleado(modelo.getIdUserEntrega(), token);
        try {
            Salida salida = this.iSalida.findById(idSalida).orElseThrow(RuntimeException::new);
            salida.setMovimiento(estadoMovimiento.EN_CAMINO);
            salida.setCombustible(modelo.getCombustible());
            salida.setEmpresa(modelo.getEmpresa());
            salida.setEquipo(modelo.getEequipo());
            salida.setPlaca(modelo.getPlaca());
            salida.setModelo(modelo.getModelo());
            salida.setValeSalida(modelo.getValeIngreso());
            salida.setUsuarioEntrega(empleado);
            salida.setFechaSalida(new Date());
            this.iSalida.save(salida);
            List detallesEntrada = new ArrayList<>();
            Almacen almacenOrigen = salida.getAlmacenOrigen();
            List<SalidaDetalles> byIdSalida = this.iSalidaDetalles.findByIdSalida(salida);
            byIdSalida.forEach(salidaDetalles -> {

                int cantidad = salidaDetalles.getCantidad();

                embIdProduct id = new embIdProduct(almacenOrigen, salidaDetalles.getIdProducto());

                ProductoAlmacen productoAlmacen = this.iProduct.findById(id).orElseThrow(RuntimeException::new);
                if (productoAlmacen.getStock() < cantidad) {
                    throw  new RuntimeException("error en el stock");

                }
                productoAlmacen.setStock(productoAlmacen.getStock() - cantidad);

                ProductoAlmacen save = this.iProduct.save(productoAlmacen);
                System.out.println(save);


            });
            //se genera una entrada
            Entrada entrada = new Entrada(

                    estadoMovimiento.EN_CAMINO, null, null, null, salida.getRequerimiento(), salida.getAlmacenDestino(), salida.getAlmacenOrigen(), null, TipoEntrada.TRASLADO,null);
            Entrada save = this.iEntrada.save(entrada);

            List<EntradaDetalles> listaEntrada = byIdSalida.stream().map(salidaDetalles -> {

                EntradaDetalles entradaDetalles = new EntradaDetalles(salidaDetalles.getIdProducto(), salidaDetalles.getCantidad(), save,salidaDetalles.getIdProducto().getPrecioUnitario());
                return entradaDetalles;
            }).collect(Collectors.toList());
            List<EntradaDetalles> entradaDetalles = this.iEntradaDetalles.saveAll(listaEntrada);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error salida");


        }


    }


    public List misSalidas(String token) {

        User user = this.getUser.getUser(token);
        Almacen idAlmacen = user.getIdAlmacen();

        return this.iSalida.findByAlmacenOrigen(idAlmacen);


    }

    public Salida detalleSalida(String token,int idsalida){

        return this.iSalida.findById(idsalida).get();

    }

}
