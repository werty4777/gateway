package com.argo.gateway.producto.domain.repository;

import com.argo.gateway.producto.application.models.OrdenModel;
import com.argo.gateway.producto.domain.OrdenDeCompra;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrden  extends JpaRepository<OrdenDeCompra,String> {



    @Query("select  odn.numeroOrden as codigo,odn.fechaOrden as fechaOrden,odn.estadoOrden as estadoOrden, odn.nombreProveedor as proveedor from OrdenDeCompra odn where odn.idAlmacen=?1")
    List<OrdenModel> misOrdenes(Almacen almacen);

}
