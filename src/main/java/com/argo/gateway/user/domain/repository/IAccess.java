package com.argo.gateway.user.domain.repository;

import com.commons.user.models.entity.accessUser.domain.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAccess  extends JpaRepository<Access,Integer> {


        Optional<Access> findByToken(String token);


    List<Access> findBySub(String codigo);
}
