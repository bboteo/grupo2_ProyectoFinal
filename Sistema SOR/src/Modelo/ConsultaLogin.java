/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Toshiba
 */
public interface ConsultaLogin {
    
    public ArrayList<UsuarioVO> login(String usr, String contra);
    
}
