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
    
    public String cronometro(){
        String tiempo="";
        int min = 0;
        int seg = 0;
        for(min = 0; min<60;min++){
            for(seg=0; seg<60; seg++ ){
                tiempo = min+":"+ seg;
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    System.err.println("Error en: " + e);
                }
            }
                   
        }
        return tiempo;
    }
    
    
}
