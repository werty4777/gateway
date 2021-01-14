package com.argo.gateway.util;


import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.ws.rs.HeaderParam;
import java.util.List;


@FeignClient("gateway-service")
public interface obtenerusuario {

    @GetMapping("/user")
    User getUser(@RequestHeader("Authorization") String authtoken);

    @GetMapping("/user/jefe/{id}")
    User getJefe(@PathVariable("id") int idAlmacen, @RequestHeader("Authorization") String authtoken);

    @GetMapping("/user/empleado/{id}")
    User getEmpleado(@PathVariable("id") String idEmpleado, @RequestHeader("Authorization") String authtoken);

    @GetMapping("/user/empleado")
    List listaEmpleados(@RequestHeader("Authorization") String token);

}
