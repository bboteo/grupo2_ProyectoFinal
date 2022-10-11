/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexion.Conexion;
import java.sql.ResultSet;
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
           String query = "INSERT INTO dbogrupo2.Detalle_orden(cantidad, sub_total, FK_id_orden, FK_id_producto) "
                   + "VALUES (" + dovo.getCantidad()+", "+ dovo.getSubTotal()+ ", " + dovo.getFkIDOrden()+", "+ dovo.getFkIdProducto()+ ")";
     
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
    public ArrayList<DetalleOrdenVO> consultar(int n) {
        Conexion c = new Conexion();
          ArrayList<DetalleOrdenVO> consultaDetalleOrden = new ArrayList<>();
        
        try{
             c.conectar();
            String query = 
                    "SELECT id_detalle, cantidad, sub_total, FK_id_orden, FK_id_producto FROM dbogrupo2.Detalle_orden WHERE FK_id_orden = " + n;
                        
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                DetalleOrdenVO dovo = new DetalleOrdenVO();
                dovo.setIdDetall(rs.getInt(1));
                dovo.setCantidad(rs.getInt(2));
                dovo.setSubTotal(rs.getDouble(3));
                dovo.setFkIDOrden(rs.getInt(4));
                dovo.setFkIdProducto(rs.getInt(5));
                consultaDetalleOrden.add(dovo);
            }
            c.desconectar();
             } catch (Exception e) {
             System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
              return consultaDetalleOrden;
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
