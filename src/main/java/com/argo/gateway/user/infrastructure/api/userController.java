package com.argo.gateway.user.infrastructure.api;

import com.argo.gateway.almacen.domain.repository.IAlmacen;
import com.argo.gateway.oauth.GoogleTokenServices;
import com.argo.gateway.rol.domain.repositroy.IRol;
import com.argo.gateway.user.domain.repository.IUser;
import com.commons.user.models.entity.area.domain.Almacen;
import com.commons.user.models.entity.area.domain.Area;
import com.commons.user.models.entity.rol.domain.Rol;
import com.commons.user.models.entity.rol.domain.enm.rolType;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class userController {
    private final IRol iRol;
    private final IUser iUser;
    private final IAlmacen iAlmacen;
    @Autowired
    private GoogleTokenServices getServices;

    @Autowired
    public userController(IRol iRol, @Qualifier("userRepo") IUser iUser, IAlmacen iAlmacen) {
        this.iRol = iRol;
        this.iUser = iUser;
        this.iAlmacen = iAlmacen;
    }

    @GetMapping("")
    public User getUser(@RequestHeader("Authorization") String token) {

        String email = this.getServices.getEmail(token.split(" ")[1]);

        //GooglePrincipal cuenta = (GooglePrincipal) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        System.out.println("mi correo es "+email);



        User one = this.iUser.findByEmail(email).get();

        System.out.println(one);

        Almacen idAlmacen = one.getIdAlmacen();
        System.out.println("mi almacen es "+idAlmacen.getAlmacen());
        System.out.println("id almacen" + idAlmacen.getIdAlmacen());

        return one;


    }

    @GetMapping("/jefe/{id}")
    public User getJefe(@PathVariable("id") int idAlmacen) {


        Rol byRol = this.iRol.findByRol(rolType.ENCARGADO_ALMACEN);
        Almacen almacen = this.iAlmacen.findById(idAlmacen).get();


        User byIdRolAndIdAlmacen = this.iUser.findByIdRolAndIdAlmacen(byRol, almacen);

        return byIdRolAndIdAlmacen;
    }

    @GetMapping("/empleado/{id}")
    public User getEmpleado(@PathVariable("id") String idEmpleado) {
        return this.iUser.findById(idEmpleado).get();

    }


    @GetMapping("/empleado")
    public List listaEmpleados(@RequestHeader("Authorization") String token) {
        String email = this.getServices.getEmail(token.split(" ")[1]);

        //GooglePrincipal cuenta = (GooglePrincipal) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        User one = this.iUser.findByEmail(email).get();
        Almacen idAlmacen = one.getIdAlmacen();


        return this.iUser.findByIdAlmacen(idAlmacen).stream().map(user -> {
            Map<String, Object> mapa = new HashMap<>();

            mapa.put("iduser", user.getIdUser());
            mapa.put("usuario", user.getEmail());

            return mapa;

        }).collect(Collectors.toList());


    }
    @GetMapping("/me")
    public Map getRol(@RequestHeader("Authorization") String token) {
        String email = this.getServices.getEmail(token.split(" ")[1]);

        //GooglePrincipal cuenta = (GooglePrincipal) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        User one = this.iUser.findByEmail(email).get();


        Map mapa = new HashMap();
        mapa.put("rol", one.getIdRol().getIdRol());
        mapa.put("idalmacen",one.getIdAlmacen().getIdAlmacen());
        mapa.put("cargo",one.getIdRol().getRol());
        mapa.put("almacen",one.getIdAlmacen().getAlmacen());
        mapa.put("sesionId",one.getIdUser());
        return mapa;

    }

}
