/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.sor;

import Controlador.ControladorFactura;
import Controlador.ControladorLogin;
import Controlador.ControladorOrden;
import Controlador.ControladorProductosAdmin;
import Controlador.ControladorRegistroOrden;
import Controlador.ControladorUsuriosAdmin;
import Controlador.ControladorVistaAdmin;
import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import Modelo.DetalleOrdenDAO;
import Modelo.DetalleOrdenVO;
import Modelo.LoginDAO;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Modelo.ProductoDAO;
import Modelo.ProductoVO;
import Modelo.RegistroOrdenDAO;
import Modelo.RegistroOrdenVO;
import Modelo.Reporte;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmFactura;
import Vista.FrmLogin;
import Vista.FrmMesas;
import Vista.FrmProductosAdmin;
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
        FrmProductosAdmin fPa = new FrmProductosAdmin();

        FrmFactura fFa = new FrmFactura();

        FrmMesas fMesa = new FrmMesas();
        FrmRegistroOrden fRegOrden = new FrmRegistroOrden();
        

        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        ClienteDAO cdao = new ClienteDAO();
        ClienteVO cvo = new ClienteVO();
        LoginDAO ldao = new LoginDAO();
        OrdenDAO odao = new OrdenDAO();
        OrdenVO ovo = new OrdenVO();
        RegistroOrdenDAO rodao = new RegistroOrdenDAO();
        RegistroOrdenVO rovo = new RegistroOrdenVO();
        Reporte rep = new Reporte();
        ProductoDAO pdao =new ProductoDAO();
        ProductoVO pvo = new ProductoVO();
        //Controlador

        //borrar en la actualizacion:
        DetalleOrdenDAO ddao = new DetalleOrdenDAO();
        DetalleOrdenVO dvo = new DetalleOrdenVO();
        ControladorFactura cFa = new ControladorFactura(fFa,cdao,cvo,fRegOrden,odao,ovo,ddao,dvo,rep);

        //ControladorFactura cFa = new ControladorFactura(fFa,cdao,cvo,fRegOrden,odao,ovo,rep);

        ControladorLogin cLog = new ControladorLogin(fVa, fvlog, ldao, uvo,fFa,fMesa,fUa);//jg
        ControladorVistaAdmin cVa = new ControladorVistaAdmin(fVa,fUa,fvlog,ldao,fMesa,fPa);
        ControladorUsuriosAdmin cUa = new ControladorUsuriosAdmin(fUa,udao,uvo,ldao);
        ControladorProductosAdmin cPa = new ControladorProductosAdmin(fPa, pdao, pvo, ldao);
        ControladorOrden cOrd = new ControladorOrden(fMesa, odao, ovo, fRegOrden);
        ControladorRegistroOrden cRegOrden = new ControladorRegistroOrden(fRegOrden, rodao, rovo, fFa);
        
        

        //Pruebas Bau
        fvlog.setVisible(true);
        fvlog.setLocationRelativeTo(null);
        fvlog.setResizable(false);
        
        
        Conexion con = new Conexion();
        con.conectar();
        
        
        

    }
    
}
