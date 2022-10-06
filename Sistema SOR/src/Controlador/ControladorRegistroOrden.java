/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroOrdenDAO;
import Modelo.RegistroOrdenVO;
import Vista.FrmRegistroOrden;

/**
 *
 * @author pc
 */
public class ControladorRegistroOrden {
    
    FrmRegistroOrden vRegOrden = new FrmRegistroOrden();
    RegistroOrdenDAO rodao = new RegistroOrdenDAO();
    RegistroOrdenVO rovo = new RegistroOrdenVO();
    
    

    public ControladorRegistroOrden(FrmRegistroOrden vRegOrden,  RegistroOrdenDAO rodao, RegistroOrdenVO rovo) {
        this.vRegOrden = vRegOrden;
        this.rodao = rodao;
        this.rovo = rovo;
        
        vRegOrden.txtDetalle.append("AAAAS \n");
        vRegOrden.txtDetalle.append("FFFF \n");
        vRegOrden.txtDetalle.append("JJJ \n");
        
        
       
    }
    
    
    
    
    
    
    
}
