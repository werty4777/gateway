package com.argo.gateway.producto.domain.repository;

import com.argo.gateway.producto.domain.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IType extends JpaRepository<TipoProducto,Integer> {
}
