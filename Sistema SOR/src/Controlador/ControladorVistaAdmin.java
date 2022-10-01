/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.FrmUsuariosAdmin;
import Vista.FrmVistaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author bboteo
 */
public class ControladorVistaAdmin implements ActionListener{
    
    FrmVistaAdmin vAd = new FrmVistaAdmin();
    FrmUsuariosAdmin vUd = new FrmUsuariosAdmin();

    public ControladorVistaAdmin(FrmVistaAdmin vAd,FrmUsuariosAdmin vUd) {
        this.vAd = vAd;
        this.vUd = vUd;
        
        this.vAd.btnVistaAdminIngresarU.addActionListener(this);
        this.vAd.btnVistaAdminIngresarM.addActionListener(this);
        this.vAd.btnVistaAdminVerMesas.addActionListener(this);
        this.vAd.btnVistaAdminSalir.addActionListener(this);
        this.vAd.btnVistaAdminHistorial.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Para ingresar usuarios
        if(e.getSource()==vAd.btnVistaAdminIngresarU){
            vAd.dispose();
            vUd.setVisible(true);
            vUd.setLocationRelativeTo(vAd);
            vUd.setResizable(false);
        }
        //Para ingresar productos
        if(e.getSource()==vAd.btnVistaAdminIngresarM){
            
        }
        //Para ver el historial
        if(e.getSource()==vAd.btnVistaAdminHistorial){
            
        }
        //Para ver mesas
        if(e.getSource()==vAd.btnVistaAdminVerMesas){
            
        }
        //Para salir y volver al login
        if(e.getSource()==vAd.btnVistaAdminSalir){
            vAd.dispose();
        }
    }
    
    
}
