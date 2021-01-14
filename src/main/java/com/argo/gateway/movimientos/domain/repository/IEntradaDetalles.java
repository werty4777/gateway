package com.argo.gateway.movimientos.domain.repository;

import com.argo.gateway.movimientos.domain.Entrada;
import com.argo.gateway.movimientos.domain.EntradaDetalles;
import com.argo.gateway.producto.domain.CodigoProducto;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IEntradaDetalles extends JpaRepository<EntradaDetalles, Integer> {


    List<EntradaDetalles> findByIdEntrada(Entrada entrada);


    @Query("select count(entd) from entrada_detalles  entd inner join entd.idEntrada entrada where entrada.idAlmacenRecibe=?1  ")
    long misEntradas(Almacen almacen);


    long countByIdProductAndIdEntrada(CodigoProducto codigoProducto, Entrada entrada);


    @Query("select sum(entd.total) from entrada_detalles  entd inner join entd.idEntrada entrada where entrada.idAlmacenRecibe.idAlmacen=?1 and  entd.idProduct.codigo=?2")
    BigDecimal sumaTotales(int idlmacen, String codigoProducto);


    @Query("select sum(ent.cantidad) from entrada_detalles  ent inner join ent.idEntrada entrada where entrada.idAlmacenRecibe=?1 and ent.idProduct=?2")
    BigDecimal misEntradasDetalles(Almacen almacen,CodigoProducto codigoProducto);







}
