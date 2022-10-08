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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 *
 * @author pc
 */
public class ControladorRegistroOrden implements ActionListener, WindowListener {
    
    //REGISTRO DE ORDENES
    FrmRegistroOrden vRegOrd = new FrmRegistroOrden();
    RegistroOrdenDAO rodao = new RegistroOrdenDAO();
    RegistroOrdenVO rovo = new RegistroOrdenVO();
    
    // PARA LA ORDEN
    OrdenDAO odao = new OrdenDAO();
    OrdenVO ovo = new OrdenVO();
    
    // PARA EL DETALLE ORDEN
    DetalleOrdenDAO dodao = new DetalleOrdenDAO();
    DetalleOrdenVO dovo = new DetalleOrdenVO();
   
    //PRODUCTO
   // 
   //
    
    FrmFactura fFa = new FrmFactura();
    
   // String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu1.getText(),  vRegOrd.spMenu1.getValue().toString()};

    public ControladorRegistroOrden(FrmRegistroOrden vRegOrden,  RegistroOrdenDAO rodao, RegistroOrdenVO rovo, FrmFactura fFa) {
        this.vRegOrd = vRegOrden;
        this.rodao = rodao;
        this.rovo = rovo;
        this.fFa = fFa;
        
       vRegOrden.btnAceptar.addActionListener(this);
       vRegOrden.btnCancelar.addActionListener(this);
       vRegOrden.btnFacturar.addActionListener(this);
       vRegOrden.btnCerrarMesa.addActionListener(this);
       
       vRegOrden.addWindowListener(this);
                    
    }
    
    private ArrayList<String[]> leerDatos(){
        ArrayList<String[]> tomaOrden = new ArrayList<>();
        String mesa, nombreMenu1, cantMenu1;

        if(!(vRegOrd.spMenu1.getValue().toString()).equals("0")){
           String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu1.getText(),  vRegOrd.spMenu1.getValue().toString()};
            System.out.println(variable[0] + variable[1] + variable[2]);
           tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu2.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu2.getText(),  vRegOrd.spMenu2.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu3.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu3.getText(),  vRegOrd.spMenu3.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu4.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu4.getText(),  vRegOrd.spMenu4.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu5.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu5.getText(),  vRegOrd.spMenu5.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu6.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu6.getText(),  vRegOrd.spMenu6.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu7.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu7.getText(),  vRegOrd.spMenu7.getValue().toString()};
            tomaOrden.add(variable);
        }
        if(!(vRegOrd.spMenu8.getValue().toString()).equals("0")){
             String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu8.getText(),  vRegOrd.spMenu8.getValue().toString()};
            tomaOrden.add(variable);
        }
        
          
        
        return tomaOrden;
        
    }

          private void limpiar() {
        vRegOrd.txtDetalle.setText("");
        vRegOrd.spMenu1.setValue(0);
        vRegOrd.spMenu2.setValue(0);
        vRegOrd.spMenu3.setValue(0);
        vRegOrd.spMenu4.setValue(0);
        vRegOrd.spMenu5.setValue(0);
        vRegOrd.spMenu6.setValue(0);
        vRegOrd.spMenu7.setValue(0);
        vRegOrd.spMenu8.setValue(0);
    }
    
    private void cerrarMesa(int i) {
        ArrayList<RegistroOrdenVO> regOrdConsulta = new ArrayList<>();
        regOrdConsulta = rodao.consultar();
//        for (RegistroOrdenVO rovo : regOrdConsulta){
//        System.out.println(rovo.getIdRegistro());
//        System.out.println(rovo.getFecha());
//        System.out.println(rovo.getEstado_orden());
//        System.out.println(rovo.getFkIdOrden());
        
        rovo.setFecha(vRegOrd.lbFecha.getText());
        rovo.setEstado_orden("libre");
        rovo.setFkIdOrden(Integer.parseInt(vRegOrd.txtNumOrden.getText()));


        if (this.rodao.insertar(rovo)== true) {
            System.out.println("datos registrados correctamente");
        }
        else{
            System.err.println("PROBLEMA AL INSERTAR");;
        }
//        }

        

        
    }
          
    
    
      
      
          private void ingresarPedido(int x) {
              
              
//                    this.vRegOrd.lbUsuario.setText(usuario);
//                    this.vRegOrd.lbMesa.setText(String.valueOf(x));
//                    this.vRegOrd.lbFecha.setText(extra.fechaHoy());
//                    this.vRegOrd.lbEstadoMesa.setText(this.estadoMesa[x]);
//                    
//            if(estadoMesa[x].equals("libre")){
//                    this.vRegOrd.setVisible(true);
//                    System.out.println(this.numeroOrden[x]);
//                    //Nueva Orden
//                    Integer nuevaOrden = this.numeroOrden[x] +1;                    
//                    this.vRegOrd.txtNumOrden.setText(String.valueOf(nuevaOrden));
//                    this.vRegOrd.setLocationRelativeTo(vMesa);
//                //  this.vRegOrd.lbMenu1.setText("PRUEBA");
//                //    this.vRegOrd.txtDetalle.append("HDLJASLFJALJADSLFAD;DKFAJALKJADS;LF \n");
//                    
//                
//            }else{
//                    this.vRegOrd.setVisible(true);
//                    this.vRegOrd.setLocationRelativeTo(vMesa);                    
//                    
//                   // vRegOrd.txtDetalle.append(String.valueOf());
//                    for(OrdenVO ovo: ordenDAO.consultar(numeroOrden[x])){
//                        vRegOrd.txtNumOrden.setText(String.valueOf(ovo.getIdOrden()));
//                        //System.out.println(ovo.getJoinIdRegistro());
//                        vRegOrd.lbMesa.setText(String.valueOf(ovo.getNumMesa()));
//                        vRegOrd.txtDetalle.append("MONTO TOTAL: " + String.valueOf(ovo.getSubTotal()) + " \n");
//                    }
//                    
//                    for(DetalleOrdenVO dovo : dodao.consultar(numeroOrden[2])){
//                        
//                        // vRegOrd.txtDetalle.append( "ORDEN: " + String.valueOf(dovo.getFkIDOrden())+ "\n");
//                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getCantidad())+ " DE: ");
//                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getFkIdProducto())+ " SUBTOTAL: ");
//                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getSubTotal()) + "\n");  ///POSIBLE ERROR
//                    
//                    }
//                
//            }
    }
      
      
          
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource().equals(vRegOrd.btnAceptar)){
            //ESCRIBIR DATOS A CAJA TEXTO
                vRegOrd.txtDetalle.setText("");
                for(String[] valorPedido : leerDatos()){
                vRegOrd.txtDetalle.append("#" +valorPedido[2] + ". " + valorPedido[1] + " Para la Mesa: " + valorPedido[0] +"\n");
            
            }
            
            
        }
        
        if (e.getSource().equals(vRegOrd.btnCancelar)){
            vRegOrd.dispose();
            limpiar();
        }
        
         if (e.getSource().equals(vRegOrd.btnFacturar)){
             fFa.lblFacutraOrden.setText(vRegOrd.txtNumOrden.getText());
             fFa.setVisible(true);
             fFa.setLocationRelativeTo(vRegOrd);
            
        }
         
         if (e.getSource().equals(vRegOrd.btnCerrarMesa)){
             
            cerrarMesa(1);
            
        }
        
        
        
    }

    
      
    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
       // for(int i = 0; i<10; i++){
        limpiar();
        //}
    }

    @Override
    public void windowClosed(WindowEvent e) {
       
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
