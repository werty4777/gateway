package com.argo.gateway.movimientos.infrastructure.api;

import com.argo.gateway.movimientos.application.EntradaService;
import com.argo.gateway.movimientos.application.SalidaService;
import com.argo.gateway.movimientos.application.models.detallesEntradaModel;
import com.argo.gateway.movimientos.application.models.entradaModel;
import com.argo.gateway.movimientos.application.models.salidaModel;
import com.argo.gateway.movimientos.domain.Entrada;
import com.argo.gateway.movimientos.domain.Salida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping({"/inventario/movimiento","/api/inventario/movimiento"})
public class MovimientoController {


    @Autowired
    public EntradaService entradaService;

    @Autowired
    public SalidaService salidaService;

    @PostMapping("/confirmar/entrada/{id}")
    public void confirmarEntrada(HttpServletRequest request, @RequestBody entradaModel modelo, @PathVariable("id") int codigo) {

        String token = request.getHeader("Authorization");


        this.entradaService.confirmarEntrada(codigo, modelo, token);


    }




    @PostMapping("/confirmar/salida/{id}")
    public void confirmarSalida(HttpServletRequest request, @RequestBody salidaModel modelo, @PathVariable("id") int codigo) {

        String token = request.getHeader("Authorization");


        this.salidaService.confirmarSalida(modelo, codigo, token);


    }


    @GetMapping("/salida/me")
    public List misSalidas(HttpServletRequest request) {
        String token = request.getHeader("Authorization");


        return this.salidaService.misSalidas(token);

    }

    @GetMapping("/entrada/me")
    public List misEntradas(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        return this.entradaService.misEntradas(token);

    }

    @GetMapping("/salida/{id}")
    public Salida misSalida(HttpServletRequest request, @PathVariable("id") int id) {
        String token = request.getHeader("Authorization");


        return this.salidaService.detalleSalida(token, id);

    }

    @GetMapping("/entrada/{id}")
    public detallesEntradaModel miEntrada(HttpServletRequest request, @PathVariable("id") int id) {
        String token = request.getHeader("Authorization");

        return this.entradaService.detalleEntrada(token, id);

    }


}
