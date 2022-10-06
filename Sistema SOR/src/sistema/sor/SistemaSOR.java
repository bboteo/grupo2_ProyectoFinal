/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.sor;

import Controlador.ControladorLogin;
import Controlador.ControladorOrden;
import Controlador.ControladorRegistroOrden;
import Controlador.ControladorUsuriosAdmin;
import Controlador.ControladorVistaAdmin;
import Modelo.LoginDAO;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Modelo.RegistroOrdenDAO;
import Modelo.RegistroOrdenVO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmLogin;
import Vista.FrmMesas;
import Vista.FrmRegistroOrden;
import Vista.FrmUsuariosAdmin;
import Vista.FrmVistaAdmin;
import conexion.Conexion;

public class SistemaSOR {

    public static void main(String[] args) {
        //Vista
        FrmLogin fvlog = new FrmLogin();
        FrmVistaAdmin fVa = new FrmVistaAdmin();
        FrmUsuariosAdmin fUa = new FrmUsuariosAdmin();
        FrmMesas fMesa = new FrmMesas();
        FrmRegistroOrden fRegOrden = new FrmRegistroOrden();
        
        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        LoginDAO ldao = new LoginDAO();
        OrdenDAO odao = new OrdenDAO();
        OrdenVO ovo = new OrdenVO();
        RegistroOrdenDAO rodao = new RegistroOrdenDAO();
        RegistroOrdenVO rovo = new RegistroOrdenVO();
        
        //Controlador
        ControladorLogin cLog = new ControladorLogin(fVa, fvlog, ldao, uvo,fMesa);
        ControladorVistaAdmin cVa = new ControladorVistaAdmin(fVa,fUa,fvlog,ldao,fMesa);
        ControladorUsuriosAdmin cUa = new ControladorUsuriosAdmin(fUa,udao,uvo,ldao);
        ControladorOrden cOrd = new ControladorOrden(fMesa, odao, ovo, fRegOrden);
        ControladorRegistroOrden cRegOrden = new ControladorRegistroOrden(fRegOrden, rodao, rovo);
        
        
        //Pruebas Bau
        fvlog.setVisible(true);
        fvlog.setLocationRelativeTo(null);
        fvlog.setResizable(false);
        
        
        Conexion con = new Conexion();
        con.conectar();
        
        
        

    }
    
}
