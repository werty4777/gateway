package com.argo.gateway.movimientos.domain.repository;

import com.argo.gateway.movimientos.domain.Salida;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import org.checkerframework.checker.units.qual.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ISalida extends JpaRepository<Salida, Integer> {

    Optional<Salida> findByRequerimiento(Requerimiento req);


   // Optional<Salida> findByAlmacenOrigen(Almacen almacen);


    List<Salida> findByAlmacenOrigen(Almacen almacen);

    @Query(value = "SELECT * FROM salida  ent inner join almacen alm on (alm.id_almacen=ent.almacen_origen_id_almacen) WHERE ent.fecha_salida =  :toString  and alm.id_almacen= :idAlmacen",nativeQuery = true)
    List salidasByDateOfWeek( String toString,int idAlmacen);
}


