/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class DetalleOrdenVO {
    
    
    //TABLA DETALLE ORDEN
    
    private int idDetalle, cantidad, fkIdOrden, fkIdProducto;
    private Double subTotal;

    public int getIdDetall() {
        return idDetalle;
    }

    public void setIdDetall(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getFkIDOrden() {
        return fkIdOrden;
    }

    public void setFkIDOrden(int fkIdOrden) {
        this.fkIdOrden = fkIdOrden;
    }

    public int getFkIdProducto() {
        return fkIdProducto;
    }

    public void setFkIdProducto(int fkIdProducto) {
        this.fkIdProducto = fkIdProducto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }
    
    
    
    
    
}
