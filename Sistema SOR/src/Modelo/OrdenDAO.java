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
public class OrdenDAO implements ConsultaOrden {

    @Override
    public boolean insertar(OrdenVO ovo) {
        Conexion c = new Conexion();
        try {
           c.conectar();
           String query = "INSERT INTO dbogrupo2.orden(num_mesa, total_venta, FK_id_usuario, FK_id_restaurante, FK_id_cliente) "
                   + "VALUES (" + ovo.getNumMesa() +", "+ ovo.getSubTotal() + ", " + ovo.getFkIdUsuario() +", "+ ovo.getFkIdRestaurante() + ", " + ovo.getFkIdCliente() + ")";
     
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
    public ArrayList<OrdenVO> consultar(int n) { 
    Conexion c = new Conexion();
          ArrayList<OrdenVO> consultaOrden = new ArrayList<>();
        
        try{
             c.conectar();
            String query = 
                    "SELECT id_orden, num_mesa, total_venta, FK_id_usuario, FK_id_restaurante, FK_id_cliente FROM dbogrupo2.orden WHERE id_orden = " + n;
                    
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                OrdenVO ovo = new OrdenVO();
                ovo.setIdOrden(rs.getInt(1));
                ovo.setNumMesa(rs.getInt(2));
                ovo.setSubTotal(rs.getDouble(3));
                ovo.setFkIdUsuario(rs.getInt(4));
                ovo.setFkIdRestaurante(rs.getInt(5));
                ovo.setFkIdCliente(rs.getInt(6));
                consultaOrden.add(ovo);
            }
            c.desconectar();
             } catch (Exception e) {
             System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
              return consultaOrden;
    }   
    
    
    @Override
    public ArrayList<OrdenVO> consultarJoin(int mesa) {        
        Conexion c = new Conexion();
          ArrayList<OrdenVO> consultaOrden = new ArrayList<>();
        
        try{
             c.conectar();
            String query = 
                    "SELECT id_registro, estado_orden, id_orden, num_mesa "
                    + "FROM dbogrupo2.Registro_orden "
                    + "INNER JOIN dbogrupo2.orden "
                    + "ON dbogrupo2.Registro_orden.FK_id_orden = dbogrupo2.orden.id_orden "
                    + "WHERE dbogrupo2.orden.num_mesa = "+ mesa +" "
                    + "ORDER BY id_registro DESC LIMIT 1";
                        
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                OrdenVO ovo = new OrdenVO();
                ovo.setJoinIdRegistro(rs.getInt(1));
                ovo.setJoinEstadoOrden(rs.getString(2));
                ovo.setIdOrden(rs.getInt(3));
                ovo.setNumMesa(rs.getInt(4));
//                ovo.setFkIdRestaurante(rs.getInt(5));
//                ovo.setFkIdCliente(rs.getInt(6));
                consultaOrden.add(ovo);
            }
            c.desconectar();
        } catch (Exception e) {
             System.err.println("Error[MMostrar]: " + e.getMessage());
            c.desconectar();
        }
        
        
        
        
        return consultaOrden;
        
    }
    
    
    
    

    @Override
    public void eliminiar(int ordVOElim) {
        
    }

    @Override
    public ArrayList<OrdenVO> actualizar(OrdenVO ordenVO) {
        
       ArrayList<OrdenVO> test = new ArrayList<>();
       return test;
        
    }

    @Override
    public OrdenVO consultaUltimaOrd() {
        Conexion c = new Conexion();
          OrdenVO consultaOrden = new OrdenVO();
        
        try{
             c.conectar();
            String query = 
                    // PARA OBTENER EL ULTIMO VALOR DE LA TABLA
                    "SELECT id_orden, num_mesa, total_venta, FK_id_usuario, FK_id_restaurante, FK_id_cliente FROM dbogrupo2.orden ORDER BY  id_orden DESC LIMIT 1";     
            ResultSet rs = c.consultaDatos(query);
            while(rs.next()){
                OrdenVO ovo = new OrdenVO();
                ovo.setIdOrden(rs.getInt(1));
                ovo.setNumMesa(rs.getInt(2));
                ovo.setSubTotal(rs.getDouble(3));
                ovo.setFkIdUsuario(rs.getInt(4));
                ovo.setFkIdRestaurante(rs.getInt(5));
                ovo.setFkIdCliente(rs.getInt(6));
                //consultaOrden.add(ovo);
                consultaOrden = ovo;
            }
            c.desconectar();
             } catch (Exception e) {
             System.err.println("Error[MMostrar CUO]: " + e.getMessage());
            c.desconectar();
        }
              return consultaOrden;
               
    }
    
}
