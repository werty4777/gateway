package com.argo.gateway.reporte;


import com.argo.gateway.reporte.models.DetallesReporteModelo;
import com.argo.gateway.reporte.models.ReporteModelo;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRAbstractBeanDataSource;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class pdfGenerator {


    public InputStreamResource generarPdf(ReporteModelo reporteModelo) {


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        List<DetallesReporteModelo> detalles = reporteModelo.getDetalles();
        try {
            File file = ResourceUtils.getFile("classpath:reporte.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource tableDataset = new JRBeanCollectionDataSource(reporteModelo.getDetalles());


            Map<String, Object> par = new HashMap<>();
            par.put("createdBy", "sulluscocha");
            par.put("sal",reporteModelo.getTotalExistenciasSalidas());
            par.put("tol",reporteModelo.getTotaExistencias());

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, par, tableDataset);
           //  JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\asdrian\\Desktop\\reporte.pdf");
            byte[] bytes = JasperExportManager.exportReportToPdf(jasperPrint);
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
            return resource;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error");
        }


    }
}
