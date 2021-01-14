package com.argo.gateway.producto.domain.repository;

import com.argo.gateway.producto.domain.DetallesOrden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenDetalles extends JpaRepository<DetallesOrden, Integer> {
}
