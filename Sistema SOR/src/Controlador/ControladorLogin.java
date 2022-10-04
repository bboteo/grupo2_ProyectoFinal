/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.UsuarioVO;
import Vista.FrmLogin;
import Vista.FrmVistaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Toshiba
 */
public class ControladorLogin implements ActionListener {

    FrmVistaAdmin vadm = new FrmVistaAdmin();
    FrmLogin vlog = new FrmLogin();
    LoginDAO ldao = new LoginDAO();
    UsuarioVO uvo = new UsuarioVO();

    public ControladorLogin(FrmVistaAdmin vadm, FrmLogin vlog, LoginDAO ldao,
            UsuarioVO uvo) {

        this.vadm = vadm;
        this.vlog = vlog;
        this.ldao = ldao;
        this.uvo = uvo;

        this.vlog.btnIngresoSistema.addActionListener(this);
    }

    private void login() {
        String usuario = vlog.txtUsuarioLog.getText();
        String contra = String.valueOf(vlog.txtPassLog.getPassword());// el metodo getpasword regresa char
        //porque está encriptada pero con el value of lo paso a string y listo.
        
        ArrayList<UsuarioVO> datos;
        datos = ldao.login(usuario, contra);

        if (!usuario.isEmpty() && !contra.isEmpty()) {
            if (!datos.isEmpty()) {
                for (UsuarioVO cre : datos) {
                    if (usuario.equals(cre.getUsername()) && contra.equals(cre.getContrasena())) {
                        if (cre.getTipo_usuario().equals("admin")) {
                            this.vadm.setVisible(true);
                            vadm.setLocationRelativeTo(null);
                            vlog.dispose();
                        }
                    }
                }

            }else{
                vlog.jopCredenciales.showMessageDialog(vadm, "Usuario o contraseña erroneos. Intenta de nuevo");
            }
        }else{
            vlog.jopCredenciales.showMessageDialog(vadm, "Porfavor ingresa tus datos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vlog.btnIngresoSistema){
            this.login();
        }
    }

}
