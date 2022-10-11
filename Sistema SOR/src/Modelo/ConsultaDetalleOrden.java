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
public interface ConsultaDetalleOrden {
    
     public boolean insertar (DetalleOrdenVO dovo);
    public ArrayList<DetalleOrdenVO> consultar(int n);
    public void eliminiar (int detOrden);
    public ArrayList<DetalleOrdenVO> actualizar(DetalleOrdenVO dovo);
    
}
