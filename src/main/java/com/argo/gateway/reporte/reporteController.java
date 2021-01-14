package com.argo.gateway.reporte;

import com.argo.gateway.reporte.models.ReporteModelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/reporte")
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

    @GetMapping("/{token}")
    public ResponseEntity<?> generarPdf(@PathVariable("token")String token) {

        //String token = request.getHeader("Authorization");

        HttpHeaders headers = new HttpHeaders();
        Date date=new Date();

        String fecha=String.valueOf(date.getTime());
        headers.add("Content-Disposition", "inline; filename=reporte"+fecha+".pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(this.reporteService.generarPdf("Bearer "+token));


    }


}
