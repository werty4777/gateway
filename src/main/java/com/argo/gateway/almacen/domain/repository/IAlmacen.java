package com.argo.gateway.almacen.domain.repository;

import com.commons.user.models.entity.area.domain.Almacen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlmacen  extends JpaRepository<Almacen,Integer> {
    List<Almacen> findByIdAlmacenIsNot(int id);

}
