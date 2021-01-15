package com.argo.gateway.notificaciones.application;


import com.argo.gateway.notificaciones.application.dto.Push;
import com.argo.gateway.notificaciones.application.dto.RequerimientoDTO;
import com.argo.gateway.notificaciones.domain.INotificaciones;
import com.argo.gateway.notificaciones.domain.Notificaciones;
import com.argo.gateway.notificaciones.domain.enm.estadoNotificacion;
import com.argo.gateway.notificaciones.infrastructure.api.dto.mensaje;
import com.argo.gateway.requerimiento.domain.Requerimiento;
import com.argo.gateway.requerimiento.domain.enm.TipoRequerimiento;
import com.argo.gateway.user.domain.repository.IAccess;
import com.commons.user.models.entity.accessUser.domain.Access;
import com.commons.user.models.entity.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class NotificacionesService {

    private final IAccess iAccess;
    private final String GENERAL = "/secured/user/queue/specific-user/nuevo/";
    private final String TRASLADO = "/secured/user/queue/specific-user/";
    private final INotificaciones iNotificaciones;
    private final RestTemplate restTemplate;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public NotificacionesService(IAccess iAccess, INotificaciones iNotificaciones, RestTemplate restTemplate) {
        this.iAccess = iAccess;

        this.iNotificaciones = iNotificaciones;

        this.restTemplate = restTemplate;
    }

    @Transactional
    public void agregarNotificacionTraslado(RequerimientoDTO requerimientoDTO) {


        Notificaciones notificaciones = new Notificaciones();
        notificaciones.setIdRequerimiento(requerimientoDTO.getCodigoRequerimiento());
        notificaciones.setTipoRequerimiento(requerimientoDTO.getTipoRequerimiento());
        System.out.println(requerimientoDTO.getTipoRequerimiento());
        notificaciones.setIdAlmacen(requerimientoDTO.getAlmacenRecibe());

        Notificaciones save = this.iNotificaciones.save(notificaciones);


    }

    public List<Notificaciones> misNotificaciones(int id) {


        System.out.println("entre aca");
        return this.iNotificaciones.findByIdAlmacen(id);


    }

    @Transactional
    public void removerNotificacion(String idRequerimiento) {


        this.iNotificaciones.deleteById(idRequerimiento);
        System.out.println("borrado con exito");

    }

    @Transactional
    public void verNotificaciones(int idalmacen) {


        this.iNotificaciones.findByIdAlmacen(idalmacen).stream().forEach(notificaciones -> {

            notificaciones.setEstado(estadoNotificacion.REVISADO);
            Notificaciones save = this.iNotificaciones.save(notificaciones);

        });


    }

    private void enviarNotificacionGeneral(RequerimientoDTO idAlmacen) {

        this.agregarNotificacionTraslado(idAlmacen);
        List<Notificaciones> notificaciones = this.misNotificaciones(idAlmacen.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(idAlmacen.getAlmacenRecibe());

        this.simpMessagingTemplate.convertAndSend(GENERAL + s, collect);
    }

    private void enviarNotificacionConfirmacion(RequerimientoDTO requerimiento,Requerimiento requerimientos) {
        String url = "";
        if (requerimiento.getTipoRequerimiento() == TipoRequerimiento.NECESIDAD) {
            url = TRASLADO;
            this.removerNotificacion(requerimiento.getCodigoRequerimiento());

            List<Access> accesses = this.buscarUsuariosPorRequerimiento(requerimiento.getCodigoRequerimiento(),requerimientos);

            for (Access access : accesses) {

                Map<String, Object> body = new HashMap<>();

                Map<String, Object> notification = new HashMap<>();
                notification.put("body", "  ");
                notification.put("title", "Solicitud de requerimiento");
                body.put("notification", notification);
                body.put("priority", "high");
                Push push = new Push();
                push.setMensaje("Tu requerimiento fue confirmado");
                push.setCodigoRequerimiento(requerimiento.getCodigoRequerimiento());
                body.put("data", push);


                body.put("to", access.getSessionId());
                String urls = "https://fcm.googleapis.com/fcm/send";

                HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization ", "Bearer AAAAh9jU3jo:APA91bF-f1Sq97C1FHgFVxLaiy3GAprO_jy61HWGWRWUGbHY644GG08LjPPd1-ARyTj2ggNNXZ0TJB3JWz77_w9TYS-oLcbZe02b34E5Aa2mPDWSxuZKGl2LnrjJIYhXgY8hThT6rko7");
                headers.add("Content-Type", "application/json");


                HttpEntity<?> requestEntity =
                        new HttpEntity<>(body, headers);


                System.out.println("cacaaa");
                ResponseEntity<Map> exchange = this.restTemplate.exchange(urls, HttpMethod.POST, requestEntity,
                        Map.class);
                exchange.getBody().forEach((o, o2) -> {
                    System.out.println(o);
                    System.out.println(o2);
                });
            }


        }
        if (requerimiento.getTipoRequerimiento() == TipoRequerimiento.NOSTOCK) {
            url = GENERAL;
            this.agregarNotificacionTraslado(requerimiento);
        }


        List<Notificaciones> notificaciones = this.misNotificaciones(requerimiento.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(requerimiento.getAlmacenRecibe());
        System.out.println("este es mi 3 almacen " + s);

        this.simpMessagingTemplate.convertAndSend(url + s, collect);
    }

    private void enviarNotificacionTraslado(RequerimientoDTO requerimiento) {


        this.removerNotificacion(requerimiento.getCodigoRequerimiento());
        List<Notificaciones> notificaciones = this.misNotificaciones(requerimiento.getAlmacenRecibe());
        List<mensaje> collect = notificaciones.stream().map(notificaciones1 -> {

            mensaje m = new mensaje();
            m.setMensaje("Tiene un nuevo requerimiento de " + notificaciones1.getTipoRequerimiento().toString());
            m.setIdRequerimiento(notificaciones1.getIdRequerimiento());
            m.setEstadoNotificacion(notificaciones1.getEstado());
            m.setTipoRequerimiento(notificaciones1.getTipoRequerimiento());
            return m;
        }).collect(Collectors.toList());
        String s = String.valueOf(requerimiento.getAlmacenRecibe());
        System.out.println("este es mi 2 almacen " + s);
        this.simpMessagingTemplate.convertAndSend(TRASLADO + s, collect);

    }


    public void sendNotification(int id, RequerimientoDTO requerimientoDTO,Requerimiento requerimiento) {

        switch (id) {

            case 1:
                this.enviarNotificacionGeneral(requerimientoDTO);
                break;


            case 2:
                this.enviarNotificacionConfirmacion(requerimientoDTO,requerimiento);
                break;

            case 3:
            this.enviarNotificacionTraslado(requerimientoDTO);
                break;


            default:
                throw new RuntimeException("error opcion invalido");



        }

    }


    public List<Access> buscarUsuariosPorRequerimiento(String codigo,Requerimiento requerimiento) {




        User requeridoPor = requerimiento.getRequeridoPor();

        return this.iAccess.findBySub(requeridoPor.getIdUser());





    }
}
