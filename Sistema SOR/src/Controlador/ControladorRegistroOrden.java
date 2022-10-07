/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DetalleOrdenDAO;
import Modelo.DetalleOrdenVO;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Modelo.RegistroOrdenDAO;
import Modelo.RegistroOrdenVO;
import Vista.FrmFactura;
import Vista.FrmMesas;
import Vista.FrmRegistroOrden;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pc
 */
public class ControladorRegistroOrden implements ActionListener {
    
    FrmRegistroOrden vRegOrden = new FrmRegistroOrden();
    RegistroOrdenDAO rodao = new RegistroOrdenDAO();
    RegistroOrdenVO rovo = new RegistroOrdenVO();
    
    
    // PARA LA ORDEN
    OrdenDAO odao = new OrdenDAO();
    OrdenVO ovo = new OrdenVO();
    
    // PARA EL DETALLE
    DetalleOrdenDAO dodao = new DetalleOrdenDAO();
    DetalleOrdenVO dovo = new DetalleOrdenVO();
   
    FrmFactura fFa = new FrmFactura();

    public ControladorRegistroOrden(FrmRegistroOrden vRegOrden,  RegistroOrdenDAO rodao, RegistroOrdenVO rovo, FrmFactura fFa) {
        this.vRegOrden = vRegOrden;
        this.rodao = rodao;
        this.rovo = rovo;
        
       vRegOrden.btnAceptar.addActionListener(this);
       vRegOrden.btnCancelar.addActionListener(this);
       vRegOrden.btnFacturar.addActionListener(this);
       vRegOrden.btnCerrarMesa.addActionListener(this);
                    
    }
    
    private void leerDatos(){
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(vRegOrden.btnAceptar)){
            
            vRegOrden.txtDetalle.append( vRegOrden.spMenu1.getValue().toString());
            vRegOrden.txtDetalle.append("AAAAS \n");
            vRegOrden.txtDetalle.append("FFFF \n");
            vRegOrden.txtDetalle.append("JJJ \n");
            
        
        }
        
        if (e.getSource().equals(vRegOrden.btnCancelar)){
            vRegOrden.dispose();
        }
        
         if (e.getSource().equals(vRegOrden.btnFacturar)){
             fFa.lblFacutraOrden.setText("37");
             fFa.setVisible(true);
             fFa.setLocationRelativeTo(vRegOrden);
            
        }
         
         if (e.getSource().equals(vRegOrden.btnCerrarMesa)){
            
        }
        
        
        
    }
    
    
    
    
    
}
