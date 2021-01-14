package com.argo.gateway.reporte;

import com.argo.gateway.reporte.models.ReporteModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/inventario/reporte")
public class reporteController {

    @Autowired
    pdfGenerator pdfGenerator;
    @Autowired
    private ReporteService reporteService;


    @GetMapping("")
    public ReporteModelo obtenerReporte(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        return this.reporteService.cargarReporte(token);


    }

    @PostMapping("")
    public ResponseEntity<?> generarPdf(HttpServletRequest request) {

        String token = request.getHeader("Authorization");

        HttpHeaders headers = new HttpHeaders();
        Date date=new Date();

        String fecha=String.valueOf(date.getTime());
        headers.add("Content-Disposition", "inline; filename=reporte"+fecha+".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(this.reporteService.generarPdf(token));


    }


}
