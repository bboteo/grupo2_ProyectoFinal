/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import conexion.Conexion;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class ProductoDAO implements TablaProducto{

    @Override
    public boolean insertarP(ProductoVO pvo) {
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query="INSERT INTO dbogrupo2.producto (producto.nombre, producto.precio, producto.descripcion, producto.cod_img_producto) "
                    + "VALUES ('"
                    + pvo.getNombreProducto()+"',"
                    + pvo.getPrecioProducto()+",'"
                    + pvo.getDescripcionProducto()+"',"
                    + pvo.getCodImagenProducto()+")";
            c.consultasMultiples(query);
        } catch (Exception e) {
            System.err.println("Error al insertar Producto"+e);
            c.desconectar();
            return false;
        }
        return true;
    }

    @Override
    public ArrayList<ProductoVO> consultarP() {
        ArrayList<ProductoVO> info = new ArrayList<>();
        
        return info;
    }

    @Override
    public boolean eliminarP(ProductoVO pvo) {
        return false;
    }

    @Override
    public boolean actualizarP(ProductoVO pvo) {
        return false;
    }
    
}
