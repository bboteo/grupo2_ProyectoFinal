/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.UsuarioVO;
import Vista.FrmLogin;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Vista.FrmMesas;
import Vista.FrmProductosAdmin;
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
     FrmMesas vMesa = new FrmMesas();  //JM
    FrmVistaAdmin vAd = new FrmVistaAdmin();
    FrmUsuariosAdmin vUd = new FrmUsuariosAdmin();
    FrmProductosAdmin vPd = new FrmProductosAdmin();
    LoginDAO ldao = new LoginDAO();
    
    public ControladorVistaAdmin(FrmVistaAdmin vAd,FrmUsuariosAdmin vUd,FrmLogin vlog,
            LoginDAO ldao,FrmMesas vMesa, FrmProductosAdmin vPd) {
        this.vAd = vAd;
        this.vUd = vUd;
        this.vlog = vlog;
        this.ldao = ldao;
        this.vMesa = vMesa;
        this.vPd = vPd;
   
   // OrdenDAO ordenDAO = new OrdenDAO();
    //OrdenVO ordenVO = new OrdenVO();
   // ControladorOrden cOrden = new ControladorOrden(vMesa, ordenDAO, ordenVO);

    
        
        
        this.vAd.btnVistaAdminIngresarU.addActionListener(this);
        this.vAd.btnVistaAdminIngresarM.addActionListener(this);
        this.vAd.btnVistaAdminVerMesas.addActionListener(this);
        this.vAd.btnVistaAdminSalir.addActionListener(this);
        this.vAd.addWindowListener(this);
    }
    
    public void logout(){ //jg 0
       String usuario = this.vAd.lblVistaAdminId.getText();
       ldao.insertDatosLogin(Integer.parseInt(usuario), 0);
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
            vAd.dispose();
            vPd.setVisible(true);
            vPd.setLocationRelativeTo(vAd);
            vPd.setResizable(false);
        }
        //Para ver mesas
        if(e.getSource()==vAd.btnVistaAdminVerMesas){
            this.vMesa.jlbNombre.setText(this.vAd.lblNombreUsuario.getText());
            this.vMesa.setVisible(true   );  //JM
            
            this.vMesa.setLocationRelativeTo(null); //JM
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
        this.logout(); //jg 0
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //  this.logout();
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
