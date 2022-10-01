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
public class UsuarioDAO implements TablaUsuario{

    @Override
    public boolean insertarU(UsuarioVO u) { 
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="INSERT INTO dbogrupo2.usuario "
                    + "(usuario.nombre, usuario.apellido,usuario.contrasena ,usuario.tipo_usuario) "
                    + "VALUES ('"
                    + u.getNombre()+"','"
                    + u.getApellido()+"','"
                    + u.getContrasena()+"','"
                    + u.getTipo_usuario()+"')";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error al insertar Usuario: "+e);
            c.desconectar();
            return false;
        }
        
        return true;
    }

    @Override
    public ArrayList<UsuarioVO> consultarU() {
        ArrayList<UsuarioVO> info = new ArrayList<>();
        ResultSet result = null;
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="SELECT u.id_usuario, u.nombre, u.apellido, u.contrasena, u.tipo_usuario, u.cod_img_usuario "
                    + "FROM usuario AS u;";
            result = c.consultaDatos(query);
            while(result.next()){
                UsuarioVO u = new UsuarioVO();
                u.setId_usuario(result.getInt(1));
                u.setNombre(result.getString(2));
                u.setApellido(result.getString(3));
                u.setContrasena(result.getString(4));
                u.setTipo_usuario(result.getString(5));
                u.setCod_img_usuario(result.getInt(6));
                info.add(u);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error consulta Usuario"+e);
            c.desconectar();
        }
        return info;
    }

    @Override
    public boolean eliminarU(UsuarioVO u) {
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query = "DELETE FROM usuario WHERE usuario.id_usuario = "
                    +u.getId_usuario();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error eliminar Usuario"+e);
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query ="UPDATE usuario AS u SET "
                    + "u.nombre = '"+u.getNombre()+"',"
                    + "u.apellido = '"+u.getApellido()+"',"
                    + "u.contrasena = '"+u.getContrasena()+"',"
                    + "u.tipo_usuario = '"+u.getTipo_usuario()+"' "
                    + "WHERE u.id_usuario = "+u.getId_usuario();
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error Actualizar usuario"+e);
            c.desconectar();
            return false;
        }
        c.desconectar();
        return true;
    }
    
}
