package com.argo.gateway.notificaciones.infrastructure;

import com.argo.gateway.notificaciones.application.NotificacionesService;
import com.argo.gateway.notificaciones.application.dto.RequerimientoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notificaciones")
public class notificacionesController {

    @Autowired
    private NotificacionesService notificacionesService;


    @PostMapping("/{id}")
    public ResponseEntity<?> misNotificaciones(@RequestBody RequerimientoDTO requerimientoDTO, @PathVariable("id") int tipo) {


        this.notificacionesService.sendNotification(tipo, requerimientoDTO,null);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
