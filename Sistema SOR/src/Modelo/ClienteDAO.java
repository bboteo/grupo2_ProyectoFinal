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
 * @author bboteo
 */
public class ClienteDAO implements TablaCliente{

    @Override
    public boolean insertarC(ClienteVO cl) {
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="INSERT INTO dbogrupo2.cliente (cliente.nit_cliente,cliente.nombre_cliente, cliente.apellido_cliente, cliente.telefono_cliente) "
                    +"VALUES ('"
                    +cl.getNitCliente()+"','"
                    +cl.getNombreCliente()+"','"
                    +cl.getApellidoCliente()+"','"
                    +cl.getTelefonoCliente()+"')";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error al insertar Cliente"+e.getMessage());
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<ClienteVO> consultarCxNit(ClienteVO cl) {
        ArrayList<ClienteVO> info = new ArrayList<>();
        ResultSet result = null;
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="SELECT * FROM dbogrupo2.cliente\n" +
                          "WHERE cliente.nit_cliente= '"+cl.getNitCliente()+"'";
            result = c.consultaDatos(query);
            while(result.next()){
                ClienteVO clv = new ClienteVO();
                clv.setIdCliente(result.getInt(1));
                clv.setNitCliente(result.getString(2));
                clv.setNombreCliente(result.getString(3));
                clv.setApellidoCliente(result.getString(4));
                clv.setTelefonoCliente(result.getString(5));
                info.add(clv);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta de Cliente"+e.getMessage());
            c.desconectar();
        }
        return info;
    }

    @Override
    public ArrayList<ClienteVO> consutarCxId(ClienteVO cl) {
        ArrayList<ClienteVO> info = new ArrayList<>();
        ResultSet result = null;
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="SELECT * FROM dbogrupo2.cliente\n" +
                          "WHERE cliente.id_cliente= '"+cl.getIdCliente()+"'";
            result = c.consultaDatos(query);
            while(result.next()){
                ClienteVO clv = new ClienteVO();
                clv.setIdCliente(result.getInt(1));
                clv.setNitCliente(result.getString(2));
                clv.setNombreCliente(result.getString(3));
                clv.setApellidoCliente(result.getString(4));
                clv.setTelefonoCliente(result.getString(5));
                info.add(clv);
            }
        } catch (Exception e) {
            System.err.println("Error en consulta de Cliente"+e.getMessage());
            c.desconectar();
        }
        return info;
    }
    
}
