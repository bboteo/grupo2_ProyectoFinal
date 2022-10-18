package com.jr.jmproytest.basededatos;

public class ObjetosVO {

    // TABLA ORDEN
    private Integer idOrden, numMesa, fkIdUsuario, fkIdRestaurante, fkIdCliente, idUltimaOrden;
    private double subTotal;
// JOIN
    private String joinEstadoOrden;
    private int joinIdRegistro;

    // Registro orden
    private String fechaRegOrd, estadoRegOrden;
    private int fkIdOrden;

    // Detale Orden
    private int cantidadDetOrd, fkIdOrdenDetOrd, fkIdProductDetOrd;
    private Double subTotalDetOrd;

    // Producto
    private int idProducto;
    private Double precioProducto;
    private String nombreProducto, descripcProducto;

    // login
    private String usr;
    private String Contra;




    public ObjetosVO(){

    }

    public ObjetosVO(Integer idOrden){

    }

    public ObjetosVO(Integer idOrden, Integer numMesa, Integer fkIdUsuario, Integer fkIdRestaurante, Integer fkIdCliente, double subTotal) {
        this.idOrden = idOrden;
        this.numMesa = numMesa;
        this.fkIdUsuario = fkIdUsuario;
        this.fkIdRestaurante = fkIdRestaurante;
        this.fkIdCliente = fkIdCliente;
        this.subTotal = subTotal;
    }

    public ObjetosVO(int cantidadDetOrd, int fkIdOrdenDetOrd, int fkIdProductDetOrd, Double subTotalDetOrd) {
        this.cantidadDetOrd = cantidadDetOrd;
        this.fkIdOrdenDetOrd = fkIdOrdenDetOrd;
        this.fkIdProductDetOrd = fkIdProductDetOrd;
        this.subTotalDetOrd = subTotalDetOrd;
    }

    public ObjetosVO(int idProducto, Double precioProducto, String descripcProducto) {
        this.idProducto = idProducto;
        this.precioProducto = precioProducto;
        this.descripcProducto = descripcProducto;
    }

    public ObjetosVO(String usr, String contra) {
        this.usr = usr;
        Contra = contra;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getContra() {
        return Contra;
    }

    public void setContra(String contra) {
        Contra = contra;
    }




    // variables orden
    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }
    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public void setNumMesa(Integer numMesa) {
        this.numMesa = numMesa;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }


    public void setFkIdUsuario(Integer fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
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

    public void setFkIdRestaurante(Integer fkIdRestaurante) {
        this.fkIdRestaurante = fkIdRestaurante;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public void setFkIdCliente(Integer fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }

    public Integer getIdUltimaOrden() {
        return idUltimaOrden;
    }

    public void setIdUltimaOrden(Integer idUltimaOrden) {
        this.idUltimaOrden = idUltimaOrden;
    }

    // JOIN
    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

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


    // REGISTRO ORDEN


    public String getFechaRegOrd() {
        return fechaRegOrd;
    }

    public void setFechaRegOrd(String fechaRegOrd) {
        this.fechaRegOrd = fechaRegOrd;
    }

    public String getEstadoRegOrden() {
        return estadoRegOrden;
    }

    public void setEstadoRegOrden(String estadoRegOrden) {
        this.estadoRegOrden = estadoRegOrden;
    }

    public int getFkIdOrden() {
        return fkIdOrden;
    }

    public void setFkIdOrden(int fkIdOrden) {
        this.fkIdOrden = fkIdOrden;
    }



    // detalle de orden
    public int getCantidadDetOrd() {
        return cantidadDetOrd;
    }

    public void setCantidadDetOrd(int cantidadDetOrd) {
        this.cantidadDetOrd = cantidadDetOrd;
    }

    public int getFkIdOrdenDetOrd() {
        return fkIdOrdenDetOrd;
    }

    public void setFkIdOrdenDetOrd(int fkIdOrdenDetOrd) {
        this.fkIdOrdenDetOrd = fkIdOrdenDetOrd;
    }

    public int getFkIdProductDetOrd() {
        return fkIdProductDetOrd;
    }

    public void setFkIdProductDetOrd(int fkIdProductDetOrd) {
        this.fkIdProductDetOrd = fkIdProductDetOrd;
    }

    public Double getSubTotalDetOrd() {
        return subTotalDetOrd;
    }

    public void setSubTotalDetOrd(Double subTotalDetOrd) {
        this.subTotalDetOrd = subTotalDetOrd;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcProducto() {
        return descripcProducto;
    }

    public void setDescripcProducto(String descripcProducto) {
        this.descripcProducto = descripcProducto;
    }


    // DETALLE ORDEN


    // PRODUCTO




}
