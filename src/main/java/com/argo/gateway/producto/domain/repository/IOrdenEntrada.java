package com.argo.gateway.producto.domain.repository;

import com.argo.gateway.producto.domain.embd.embdOrdenEntrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOrdenEntrada  extends JpaRepository<embdOrdenEntrada,Integer> {


    @Query("select ont from orden_entrada ont where ont.idEntrada.idEntrada=?1")
    Optional<embdOrdenEntrada> buscarEntrada(int id);


}
