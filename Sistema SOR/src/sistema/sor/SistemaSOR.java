/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.sor;

import Controlador.ControladorLogin;
import Controlador.ControladorUsuriosAdmin;
import Controlador.ControladorVistaAdmin;
import Modelo.LoginDAO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmLogin;
import Vista.FrmUsuariosAdmin;
import Vista.FrmVistaAdmin;
import conexion.Conexion;

public class SistemaSOR {

    public static void main(String[] args) {
        //Vista
        FrmLogin fvlog = new FrmLogin();
        FrmVistaAdmin fVa = new FrmVistaAdmin();
        FrmUsuariosAdmin fUa = new FrmUsuariosAdmin();
        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        LoginDAO ldao = new LoginDAO();
        //Controlador
        ControladorLogin cLog = new ControladorLogin(fVa, fvlog, ldao, uvo);
        ControladorVistaAdmin cVa = new ControladorVistaAdmin(fVa,fUa);
        ControladorUsuriosAdmin cUa = new ControladorUsuriosAdmin(fUa,udao,uvo);
        //Pruebas Bau
        fvlog.setVisible(true);
        fvlog.setLocationRelativeTo(null);
        fvlog.setResizable(false);
        
        
        Conexion con = new Conexion();
        con.conectar();
        
        
        

    }
    
}
