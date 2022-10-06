/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Toshiba
 */
public class Extras {
    
    public static String fechaHoy(){
        String fechaHoy;
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        fechaHoy = sdf.format(fecha.getTime());    
        return fechaHoy;
    }
    
    
}
