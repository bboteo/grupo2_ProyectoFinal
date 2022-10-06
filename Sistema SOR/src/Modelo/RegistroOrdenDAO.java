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
public class RegistroOrdenDAO implements ConsultaRegistroOrden {




    @Override
    public boolean insertar(RegistroOrdenVO rovo) {
        Conexion c = new Conexion();
        try {
           c.conectar();
           String query = "INSERT INTO dbogrupo2.Registro_orden(fecha, estado_orden, FK_id_orden) "
                   + "VALUES ('"+ rovo.getFecha()+"', '"+rovo.getEstado_orden()+"', "+rovo.getFkIdOrden()+")";
     
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
    public ArrayList<RegistroOrdenVO> consultar() {
            
         Conexion c = new Conexion();
        ArrayList<RegistroOrdenVO> consultaRegOrden = new ArrayList<>();
        
        try{
             c.conectar();
            String query = "SELECT * FROM dbogrupo2.Registro_orden";
                    
                    
                    
//                    "SELECT id_registro, estado_orden, id_orden, num_mesa "
//                    + "FROM dbogrupo2.Registro_orden "
//                    + "INNER JOIN dbogrupo2.orden "
//                    + "ON dbogrupo2.Registro_orden.FK_id_orden = dbogrupo2.orden.id_orden "
//                    + "WHERE dbogrupo2.orden.num_mesa = 3 "
//                    + "ORDER BY id_registro DESC LIMIT 1";
//            
                        
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                RegistroOrdenVO rovo = new RegistroOrdenVO();
                rovo.setIdRegistro(rs.getInt(1));
                rovo.setFecha(rs.getString(2));
                rovo.setEstado_orden(rs.getString(3));
                rovo.setFkIdOrden(rs.getInt(4));
                consultaRegOrden.add(rovo);
            }
            c.desconectar();
        } catch (Exception e) {
             System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
        
        
        
        
        return consultaRegOrden;
    
        
        
        
        
        
        
       
    }

    @Override
    public void eliminiar(int regOrdElim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<RegistroOrdenVO> actualizar(RegistroOrdenVO ordenVO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  

    
       

    
    
}
