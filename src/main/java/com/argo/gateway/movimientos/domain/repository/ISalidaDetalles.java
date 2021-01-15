package com.argo.gateway.movimientos.domain.repository;

import com.argo.gateway.movimientos.domain.Salida;
import com.argo.gateway.movimientos.domain.SalidaDetalles;
import com.argo.gateway.movimientos.domain.enm.estadoMovimiento;
import com.argo.gateway.producto.domain.CodigoProducto;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ISalidaDetalles extends JpaRepository<SalidaDetalles, Integer> {


    List<SalidaDetalles> findByIdSalida(Salida salida);


    @Query("select  count(salidadet) from salida_detalles salidadet inner join salidadet.idSalida salida where salida.almacenOrigen=?1")
    long misSalidas(Almacen almacen);


    @Query("select sum(saldt.cantidad) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2 and salida.movimiento<>?3 ")
    BigDecimal misSalidas(Almacen almacen, CodigoProducto codigoProducto, estadoMovimiento estadoMovimiento);


    @Query("select sum(saldt.total) from salida_detalles saldt inner join saldt.idSalida salida where salida.almacenOrigen=?1 and saldt.idProducto=?2  and salida.movimiento<>?3 ")
    BigDecimal sumaSalida(Almacen almacen,CodigoProducto codigoProducto ,estadoMovimiento estadoMovimiento);

}
