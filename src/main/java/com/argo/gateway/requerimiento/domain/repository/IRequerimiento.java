package com.argo.gateway.requerimiento.domain.repository;


import com.argo.gateway.dashboard.models.requerimientoModelDashboard;
import com.argo.gateway.requerimiento.application.models.RequerimientoQuery;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import com.argo.gateway.requerimiento.domain.enm.EstadoRequerimiento;
import com.argo.gateway.requerimiento.domain.enm.TipoRequerimiento;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRequerimiento extends JpaRepository<Requerimiento, String> {


    long countByCodigoRequerimientoStartingWith(String codigo);

    @Query("select req.codigoRequerimiento as codigo,req.requeridoPor.email as empleado,req.fechaEmision as fechaEmision,req.tipoRequerimiento as tipoRequerimiento,req.estadoRequerimiento as estadoRequerimiento from  Requerimiento req where req.almacenPide=?1")
    List<RequerimientoQuery> misRequerimientos(Almacen almacen);




    @Query("select req.codigoRequerimiento as codigo,req.almacenPide.almacen as remitente,req.fechaEmision as fechaEmision,req.tipoRequerimiento as tipoRequerimiento,req.estadoRequerimiento as estadoRequerimiento from  Requerimiento req where req.almacenRecibe=?1 and req.tipoRequerimiento=?2")
    List<RequerimientoQuery> misPeticiones(Almacen almacen , TipoRequerimiento tipoRequerimiento);



    List<Requerimiento> findByRequeridoPor(User user);

    List<Requerimiento> findByAlmacenPide(Almacen user);

    @Query("select requerimiento.codigoRequerimiento as codigo,requerimiento.fechaEmision as fechaEmision,requerimiento.almacenPide.almacen as almacenRequiere from detalles_requerimiento  detreq inner join detreq.idRequerimiento requerimiento where requerimiento.almacenPide=?1  and requerimiento.estadoRequerimiento=?2")
    List<requerimientoModelDashboard> dashboardRequerimiento(Almacen a, EstadoRequerimiento estadoRequerimiento, Pageable pageable);

    long countByAlmacenPideAndEstadoRequerimiento(Almacen a,EstadoRequerimiento estadoRequerimiento);

}
