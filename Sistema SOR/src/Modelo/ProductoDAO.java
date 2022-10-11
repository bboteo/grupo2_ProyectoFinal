/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import conexion.Conexion;
import java.sql.ResultSet;
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
        ResultSet result = null;
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query = "SELECT p.id_producto, p.nombre, p.precio, p.descripcion, p.cod_img_producto "
                    + "FROM producto AS p";
            result = c.consultaDatos(query);
            while(result.next()){
                ProductoVO p = new ProductoVO();
                p.setIdProducto(result.getInt(1));
                p.setNombreProducto(result.getString(2));
                p.setPrecioProducto(result.getFloat(3));
                p.setDescripcionProducto(result.getString(4));
                p.setCodImagenProducto(result.getInt(5));
                info.add(p);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error al consultar Producto"+e);
            c.desconectar();
        }
        return info;
    }

    @Override
    public ArrayList<ProductoVO> consultaExactaP(ProductoVO pvo) {
        ArrayList<ProductoVO> info = new ArrayList<>();
        ResultSet result = null;
        Conexion c = new Conexion();
        try {
            c.conectar();
            String query = "SELECT p.id_producto, p.nombre, p.precio, p.descripcion, p.cod_img_producto "
                    + "FROM producto AS p "
                    + "WHERE p.id_producto = "+pvo.getIdProducto();
            result = c.consultaDatos(query);
            while(result.next()){
                ProductoVO p = new ProductoVO();
                p.setIdProducto(result.getInt(1));
                p.setNombreProducto(result.getString(2));
                p.setPrecioProducto(result.getFloat(3));
                p.setDescripcionProducto(result.getString(4));
                p.setCodImagenProducto(result.getInt(5));
                info.add(p);
            }
            c.desconectar();
        } catch (Exception e) {
            System.err.println("Error al consultar Producto"+e);
            c.desconectar();
        }
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
