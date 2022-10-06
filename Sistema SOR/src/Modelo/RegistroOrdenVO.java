/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author pc
 */
public class RegistroOrdenVO {
    
    //TABLA REGISTRO_ORDENES
    private int idRegistro, fkIdOrden;
    private String fecha;
    private String estado_orden;

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public int getFkIdOrden() {
        return fkIdOrden;
    }

    public void setFkIdOrden(int fkIdOrden) {
        this.fkIdOrden = fkIdOrden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado_orden() {
        return estado_orden;
    }

    public void setEstado_orden(String estado_orden) {
        this.estado_orden = estado_orden;
    }
    

    
}
