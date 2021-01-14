package com.argo.gateway.producto.domain.repository;

import com.argo.gateway.producto.application.models.CodigoList;
import com.argo.gateway.producto.application.models.CodigoListMovil;
import com.argo.gateway.producto.domain.CodigoProducto;
import com.argo.gateway.producto.domain.ProductoAlmacen;
import com.argo.gateway.producto.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICodigoProducto extends JpaRepository<CodigoProducto, String> {


    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion  from lista_productos p inner join p.tipo tp")
    List<CodigoList> listaCodigoProductos();

    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion  from producto_almacen pt inner join pt.id.codigo p inner join p.tipo tp inner join pt.id.idAlmacen al where al.idAlmacen=?1")
    List<CodigoListMovil> listaCodigoProductosMovil(int idAlmacen);


    Optional<CodigoProducto> findByCodigoStartingWith(String s);

    @Query("select p.codigo as codigo,tp.tipo as tipo,p.color as color,p.marca as marca,p.modelo as modelo,p.talla as talla,p.descripcion as descripcion,p.precioUnitario as precio  from lista_productos p inner join p.tipo tp ")
    List<CodigoListNuevo> listaCodigoProductosNevo();

    @Query("select pro from producto_almacen pro")
    List<ProductoAlmacen> buscarPorNombre();


    @Query("select cd from lista_productos cd where cd.tipo.tipo=?1 and cd.descripcion=?2 and cd.talla=?3 and cd.modelo=?4 and cd.marca=?5 and cd.color=?6 and cd.precioUnitario=?7 and cd.unidadMedida=?8")
    Optional<CodigoProducto> findByData(String tipo, String descripcion, String talla, String modelo, String marca, String color, BigDecimal preciounitario, String unidadMedida);


    @Query("select cd.codigo from lista_productos  cd where cd.descripcion=?1")
    List<String> todoLista(String descripcion);

    @Query("select DISTINCT  cd.descripcion from lista_productos cd ")
    List<String> findNombres();


    @Query("select DISTINCT  cd.modelo from lista_productos cd ")
    List<String> listaModelo();


    @Query("select DISTINCT  cd.marca from lista_productos cd ")
    List<String> listaMarca();


    @Query("select DISTINCT  tp from tipo_producto tp")
    List<TipoProducto> listaTipo();



    @Query("select DISTINCT  cd.color from lista_productos cd ")
    List<String> listaColor();

    @Query("select DISTINCT  cd.talla from lista_productos cd")
    List<String> listaTalla();



    @Query("select DISTINCT  cd.precioUnitario from lista_productos cd ")
    List<BigDecimal> listaPrecio();

    @Query("select DISTINCT  cd.unidadMedida from lista_productos cd")
    List<String> listaUnidadMedida();






}
