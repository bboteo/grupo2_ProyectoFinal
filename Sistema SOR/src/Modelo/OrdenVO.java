/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class OrdenVO {
    
    // TABLA ORDEN
    private int idOrden, numMesa, fkIdUsuario, fkIdRestaurante, fkIdCliente;
    private double subTotal;
    
    private String joinEstadoOrden;
    private int joinIdRegistro;
    
    

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public int getFkIdRestaurante() {
        return fkIdRestaurante;
    }

    public void setFkIdRestaurante(int fkIdRestaurante) {
        this.fkIdRestaurante = fkIdRestaurante;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    
    
    // para el join y ver los estados de las mesas
    public String getJoinEstadoOrden() {
        return joinEstadoOrden;
    }

    public void setJoinEstadoOrden(String joinEstadoOrden) {
        this.joinEstadoOrden = joinEstadoOrden;
    }

    public int getJoinIdRegistro() {
        return joinIdRegistro;
    }

    public void setJoinIdRegistro(int joinIdRegistro) {
        this.joinIdRegistro = joinIdRegistro;
    }
    

 
}
