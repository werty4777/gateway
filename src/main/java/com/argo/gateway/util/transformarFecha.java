package com.argo.gateway.util;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class transformarFecha {
    public Date convertirFecha(String fecha) {

        DateFormat dateTimeFormatter = new SimpleDateFormat("YYYY/MM/DD");
        try {
            return dateTimeFormatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Date obtenerFecha(Date fecha) {

        SimpleDateFormat formato = new SimpleDateFormat("YYYY/MM/DD");
        String format = formato.format(fecha);
        try {
            return formato.parse(format);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

}
