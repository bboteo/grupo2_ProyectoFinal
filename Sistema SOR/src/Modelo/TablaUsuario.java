/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public interface TablaUsuario {
    //CRUD Basico
    public boolean insertarU(UsuarioVO u);
    public ArrayList<UsuarioVO> consultarU();
    public boolean eliminarU(UsuarioVO u);
    public boolean actualizarU(UsuarioVO u);
    
}
