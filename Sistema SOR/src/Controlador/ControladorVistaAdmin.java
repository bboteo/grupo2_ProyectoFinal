/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.UsuarioVO;
import Vista.FrmLogin;
import Vista.FrmUsuariosAdmin;
import Vista.FrmVistaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class ControladorVistaAdmin implements ActionListener, WindowListener{
    FrmLogin vlog = new FrmLogin();
    FrmVistaAdmin vAd = new FrmVistaAdmin();
    FrmUsuariosAdmin vUd = new FrmUsuariosAdmin();
    LoginDAO ldao = new LoginDAO();

    public ControladorVistaAdmin(FrmVistaAdmin vAd,FrmUsuariosAdmin vUd,FrmLogin vlog,
            LoginDAO ldao) {
        this.vAd = vAd;
        this.vUd = vUd;
        this.vlog = vlog;
        this.ldao = ldao;
        
        this.vAd.btnVistaAdminIngresarU.addActionListener(this);
        this.vAd.btnVistaAdminIngresarM.addActionListener(this);
        this.vAd.btnVistaAdminVerMesas.addActionListener(this);
        this.vAd.btnVistaAdminSalir.addActionListener(this);
        this.vAd.btnVistaAdminHistorial.addActionListener(this);
        this.vAd.addWindowListener(this);
    }
    
    public void logout(){
       String usuario = this.vAd.lblNombreUsuario.getText();
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

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        
    }

    @Override
    public void windowClosed(WindowEvent e) {
        this.logout();
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
    
    
}
