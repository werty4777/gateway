package com.argo.gateway.movimientos.domain.repository;

import com.argo.gateway.movimientos.application.models.entradaModelo;
import com.argo.gateway.movimientos.domain.Entrada;
import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEntrada  extends JpaRepository<Entrada,Integer> {

    List<Entrada> findByIdAlmacenRecibe(Almacen almacen);


    @Query("select ent.idEntrada as idEntrada, ent.fechaEntrada as fechaEntrada, ent.movimiento as estadoMovimiento,ent.tipoComprobante as tipoComprobante,ent.tipoEntrada as tipoEntrada from Entrada ent where ent.idAlmacenRecibe=?1")
    List<entradaModelo> almacenRecibeEntrada(Almacen almacen);

    @Query(value = "SELECT * FROM entrada  ent inner join almacen alm on (alm.id_almacen=ent.id_almacen_recibe)WHERE ent.fecha_entrada =  :fecha  and alm.id_almacen=:id",nativeQuery = true)
    List entrasByDateOfWeek( String fecha,int id);
}
