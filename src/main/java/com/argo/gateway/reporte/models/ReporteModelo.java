package com.argo.gateway.reporte.models;

import java.math.BigDecimal;
import java.util.List;

public class ReporteModelo {

    private List<DetallesReporteModelo> detalles;
    private BigDecimal totalExistenciasSalidas;
    private BigDecimal totaExistencias;

    public List<DetallesReporteModelo> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallesReporteModelo> detalles) {
        this.detalles = detalles;
    }


    public BigDecimal getTotalExistenciasSalidas() {
        List<DetallesReporteModelo> detalles = this.getDetalles();

        BigDecimal total = new BigDecimal(0);

        for (DetallesReporteModelo detalle : detalles) {
            total = total.add(detalle.getExistenciasSalidas());
        }

        return total;


    }

    public ReporteModelo(List<DetallesReporteModelo> detalles) {
        this.detalles = detalles;
    }

    public ReporteModelo() {
    }

    public BigDecimal getTotaExistencias() {
        List<DetallesReporteModelo> detalles = this.getDetalles();
        BigDecimal total = new BigDecimal(0);


        for (DetallesReporteModelo detalle : detalles) {
            total = total.add(detalle.totalExistencias);
        }
        return total;   

    }
}
