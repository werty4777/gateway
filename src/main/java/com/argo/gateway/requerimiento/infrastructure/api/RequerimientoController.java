package com.argo.gateway.requerimiento.infrastructure.api;

import com.argo.gateway.requerimiento.application.RequerimientoService;
import com.argo.gateway.requerimiento.application.models.RequerimientoModel;
import com.argo.gateway.requerimiento.application.models.RequerimientoModelTraslado;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping({"/inventario/requerimiento","/api/inventario/requerimiento"})
public class RequerimientoController {


    private final RequerimientoService requerimientoService;





    @Autowired
    public RequerimientoController(RequerimientoService requerimientoService) {
        this.requerimientoService = requerimientoService;

    }


    @PostMapping("")
    public ResponseEntity<?> crearRequerimientoGeneral(HttpServletRequest request, @RequestBody RequerimientoModel modelo) {

        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.crearRequerimientoGeneral(modelo, token);




        return new ResponseEntity<>(HttpStatus.OK);

    }


    @GetMapping("/confirmar/{id}")
    public ResponseEntity<?> confirmarRequerimiento(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.confirmarRequerimiento(token, codigoreq);



        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/confirmar/traslado/{id}")
    public ResponseEntity<?> confirmarRequerimientoTraslado(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.confirmarTraslado(token, codigoreq);


        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/traslado")
    public ResponseEntity<?> crearRequerimientoTraslado(HttpServletRequest request, @RequestBody RequerimientoModelTraslado modelo) {

        String token = request.getHeader("Authorization");

        Requerimiento requerimiento = this.requerimientoService.crearRequermientoTraslado(modelo, token);


        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/me")
    public List misRquerimientos(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        return this.requerimientoService.misRequermientos(token);


    }

    @GetMapping("/todo")
    public Map peticionesRequerimientoYo(HttpServletRequest request) {

        String token = request.getHeader("Authorization");


        return this.requerimientoService.misPeticiones(token);


    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detallesRequerimiento(HttpServletRequest request, @PathVariable("id") String codigoreq) {
        String token = request.getHeader("Authorization");


        Requerimiento requerimiento = this.requerimientoService.detallesRequerimiento(token, codigoreq);

        return new ResponseEntity<>(requerimiento, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> recharzaRequerimiento(@PathVariable("id") String codigo) {

        boolean b = this.requerimientoService.rechazarRequerimiento(codigo);
        if (!b) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @DeleteMapping("/traslado/{id}")
    public ResponseEntity<?> rechazarRequerimientoTraslado(@PathVariable("id") String codigo) {
        boolean b = this.requerimientoService.rechazarRequerimientoTraslado(codigo);
        if (!b) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
