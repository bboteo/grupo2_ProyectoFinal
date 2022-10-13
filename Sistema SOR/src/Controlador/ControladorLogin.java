/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.UsuarioVO;
import Vista.FrmFactura;
import Vista.FrmLogin;
import Vista.FrmMesas;
import Vista.FrmProductosAdmin;
import Vista.FrmUsuariosAdmin;
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
    FrmMesas vmesa = new FrmMesas();
    FrmLogin vlog = new FrmLogin();
    LoginDAO ldao = new LoginDAO();
    UsuarioVO uvo = new UsuarioVO();
    //Agregado bboteo
    FrmFactura vFa = new FrmFactura();
    FrmUsuariosAdmin vua = new FrmUsuariosAdmin(); //jg
    public ControladorLogin(FrmVistaAdmin vadm, FrmLogin vlog, LoginDAO ldao,
            UsuarioVO uvo, FrmFactura vFa, FrmMesas vmesa,FrmUsuariosAdmin vua) {

        this.vadm = vadm;
        this.vlog = vlog;
        this.ldao = ldao;
        this.uvo = uvo;
        this.vFa = vFa;
        this.vmesa = vmesa;
        this.vua = vua;
        this.vlog.btnIngresoSistema.addActionListener(this);
    }

    private void login() {
        String usuario = vlog.txtUsuarioLog.getText();
        String contra = String.valueOf(vlog.txtPassLog.getPassword());// el metodo getpasword regresa char
        //porque está encriptada pero con el value of lo paso a string y listo.
        //hola
        ArrayList<UsuarioVO> datos;
        datos = ldao.login(usuario, contra);

        if (!usuario.isEmpty() && !contra.isEmpty()) {
            if (!datos.isEmpty()) {
                for (UsuarioVO cre : datos) {
                    if (usuario.equals(cre.getUsername()) && contra.equals(cre.getContrasena())) {

                        if (cre.getTipo_usuario().equals("admin")) {
                            this.vadm.lblNombreUsuario.setText(cre.getNombre());
                            this.vadm.lblVistaAdminId.setText(String.valueOf(cre.getId_usuario()));
                            this.vadm.lblVistaAdminId.setVisible(false);//jg 0
                            ldao.insertDatosLogin(cre.getId_usuario(), 1);
                            this.vadm.setVisible(true);
                            vadm.setLocationRelativeTo(null);
                            vlog.dispose();
                        }
                        if (cre.getTipo_usuario().equals("mesero") && contra.equals(cre.getContrasena())) {
                            this.vmesa.jlbNombre.setText(cre.getNombre());
                            ldao.insertDatosLogin(cre.getId_usuario(), 1);
                            this.vmesa.setVisible(true);
                            vmesa.setLocationRelativeTo(null);
                            vlog.dispose();
                        }
                        if (cre.getTipo_usuario().equals("host") && contra.equals(cre.getContrasena())) {
                            this.vmesa.jlbNombre.setText(cre.getNombre());
                            ldao.insertDatosLogin(cre.getId_usuario(), 1);
                            this.vmesa.setVisible(true);
                            vmesa.setLocationRelativeTo(null);
                            vlog.dispose();
                        }
                    }
                }

            } else {
                vlog.jopCredenciales.showMessageDialog(vadm, "Usuario o contraseña erroneos. Intenta de nuevo");
                //Codigo para ver factura            
                vFa.setVisible(true);
                vFa.setLocationRelativeTo(vlog);
                vFa.setResizable(false);
                vlog.dispose();
            }
        } else {
            vlog.jopCredenciales.showMessageDialog(vadm, "Porfavor ingresa tus datos");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vlog.btnIngresoSistema) {
            this.login();
        }
    }

}
