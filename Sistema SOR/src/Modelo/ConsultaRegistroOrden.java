/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author pc
 */
public interface ConsultaRegistroOrden {
    
    public boolean insertar (RegistroOrdenVO regOrdenVO);
    public ArrayList<RegistroOrdenVO> consultar();
    public void eliminiar (int regOrdElim);
    public ArrayList<RegistroOrdenVO> actualizar(RegistroOrdenVO ordenVO);
    
}
