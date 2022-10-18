package com.jr.jmproytest.complementos;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Extras {

    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = sdf.format(fecha.getTime());
        //System.out.println(fechaHoy);
        return fechaHoy;

    }
}
