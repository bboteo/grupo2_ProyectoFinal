/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema.sor;

import Controlador.ControladorUsuriosAdmin;
import Controlador.ControladorVistaAdmin;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmUsuariosAdmin;
import Vista.FrmVistaAdmin;
import conexion.Conexion;

public class SistemaSOR {

    public static void main(String[] args) {
        //Vista
        FrmVistaAdmin fVa = new FrmVistaAdmin();
        FrmUsuariosAdmin fUa = new FrmUsuariosAdmin();
        //Modelo
        UsuarioDAO udao = new UsuarioDAO();
        UsuarioVO uvo = new UsuarioVO();
        //Controlador
        ControladorVistaAdmin cVa = new ControladorVistaAdmin(fVa,fUa);
        ControladorUsuriosAdmin cUa = new ControladorUsuriosAdmin(fUa,udao,uvo);
        //Pruebas Bau
        fVa.setVisible(true);
        fVa.setLocationRelativeTo(null);
        fVa.setResizable(false);
        
        
        Conexion con = new Conexion();
        con.conectar();
        
        
        

    }
    
}
