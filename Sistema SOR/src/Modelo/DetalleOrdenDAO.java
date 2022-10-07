/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class DetalleOrdenDAO implements ConsultaDetalleOrden{

    @Override
    public boolean insertar(DetalleOrdenVO dovo) {
        Conexion c = new Conexion();
        try {
           c.conectar();
           String query = "INSERT INTO dbogrupo2.Detalle_orden(cantidad, sub_total, FK_id_orden, FK_id_producto) ";
                 //  + "VALUES ('"+ dovo.+"', '"+dovo.getFkIDOrden()+"', "+dovo.getFkIdProducto()+")";
     
           c.consultasMultiples(query);
           
        } catch (Exception e) {
            System.err.println("Error[MInsertar]: " + e.getMessage());
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public ArrayList<DetalleOrdenVO> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminiar(int detOrden) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<DetalleOrdenVO> actualizar(DetalleOrdenVO dovo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    
    
    
    
    
}
