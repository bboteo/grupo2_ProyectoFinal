/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public interface TablaProducto {
    //CRUD BASICO
    public boolean insertarP (ProductoVO pvo);
    public ArrayList<ProductoVO> consultarP();
    public boolean eliminarP(ProductoVO pvo);
    public boolean actualizarP(ProductoVO pvo);
}
