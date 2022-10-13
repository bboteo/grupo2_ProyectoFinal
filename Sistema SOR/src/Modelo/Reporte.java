/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import conexion.Conexion;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author bboteo
 */
public class Reporte {
    public JasperViewer jv;
    
    public void reporteFactura(OrdenVO ovo){
        Conexion c = new Conexion();
        try {
            c.conectar();
            Map parametro = new HashMap();
            parametro.put("parameter1", (int)ovo.getIdOrden());
            JasperReport reporteFactura;
            //String ruta = "C:\\Users\\bboteo\\Documents\\gitHubRepositorio\\grupo2_ProyectoFinal\\Sistema SOR\\src\\Reporte\\facturaMaestro.jasper";
            String ruta = "C:\\facturaMaestro.jasper";
            reporteFactura = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            
            JasperPrint jp = JasperFillManager.fillReport(ruta, parametro,c.connection);
            JasperViewer jv = new JasperViewer(jp,false);
            this.jv = jv;
        } catch (Exception e) {
            System.err.println("Error al generar FActura"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }
    
    public void reporteUsuarios(UsuarioVO uvo){
        Conexion c = new Conexion();
        try {
            c.conectar();
            Map parametro = new HashMap();
            //parametro.put("parameter1", (int)ovo.getIdOrden());
            JasperReport reporteFactura;
            //String ruta = "C:\\Users\\bboteo\\Documents\\gitHubRepositorio\\grupo2_ProyectoFinal\\Sistema SOR\\src\\Reporte\\facturaMaestro.jasper";
            String ruta = "C:\\UsuariosMaestro.jasper";
            reporteFactura = (JasperReport) JRLoader.loadObjectFromFile(ruta);
            
            JasperPrint jp = JasperFillManager.fillReport(ruta, parametro,c.connection);
            JasperViewer jv = new JasperViewer(jp,false);
            this.jv = jv;
        } catch (Exception e) {
            System.err.println("Error al generar FActura"+e.getMessage());
            c.desconectar();
        }
        c.desconectar();
    }
    
}
