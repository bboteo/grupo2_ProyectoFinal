/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmVistaAdmin;

/**
 *
 * @author bboteo
 */
public class ControladorVistaAdmin {
    
    FrmVistaAdmin vAd = new FrmVistaAdmin();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();

    public ControladorVistaAdmin(FrmVistaAdmin vAd, UsuarioDAO udao, UsuarioVO uvo) {
        this.vAd = vAd;
        this.udao = udao;
        this.uvo = uvo;
    }
    
    
}
