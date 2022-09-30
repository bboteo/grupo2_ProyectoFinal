/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import conexion.Conexion;
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
            String query =" ";
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
        ArrayList<UsuarioVO> cu = new ArrayList<>();
        
        return cu;
    }

    @Override
    public boolean eliminarU(UsuarioVO u) {
        return false;
    }

    @Override
    public boolean actualizarU(UsuarioVO u) {
        return false;
    }
    
}
