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
public interface TablaCliente {
    public boolean insertarC (ClienteVO cl);
    public ArrayList<ClienteVO> consultarC(ClienteVO cl);
}
