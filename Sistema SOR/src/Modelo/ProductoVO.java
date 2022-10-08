/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author bboteo
 */
public class ProductoVO {
    private int idProducto;
    private String nombreProducto;
    private float precioProducto;
    private String descripcionProducto;
    private Integer codImagenProducto;

    public ProductoVO() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Integer getCodImagenProducto() {
        return codImagenProducto;
    }

    public void setCodImagenProducto(Integer codImagenProducto) {
        this.codImagenProducto = codImagenProducto;
    }
    
    
}
