/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DetalleOrdenDAO;
import Modelo.DetalleOrdenVO;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Modelo.ProductoDAO;
import Modelo.ProductoVO;
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
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO pvo = new ProductoVO();
    
    //Vista Factura
    FrmFactura fFa = new FrmFactura();
    
   // String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu1.getText(),  vRegOrd.spMenu1.getValue().toString()};
    
    ArrayList<ProductoVO> prodConsulta = new ArrayList<>();
    
    //SUMATORIA
    Double totalOrden =0.0;   //// 

    public ControladorRegistroOrden(FrmRegistroOrden vRegOrden,  RegistroOrdenDAO rodao, RegistroOrdenVO rovo, FrmFactura fFa) {
        this.vRegOrd = vRegOrden;
        this.rodao = rodao;
        this.rovo = rovo;
        this.fFa = fFa;
        
       vRegOrden.btnAceptar.addActionListener(this);
       vRegOrden.btnCancelar.addActionListener(this);
       vRegOrden.btnServido.addActionListener(this);
       vRegOrden.btnFacturar.addActionListener(this);
       vRegOrden.btnCerrarMesa.addActionListener(this);
       
    
       
       vRegOrden.addWindowListener(this);
                    
    }
    
    
    private void consultarProducto() {
        

        prodConsulta = pdao.consultarP();

        //for (int i = 0; i < 8; i++) {

            this.vRegOrd.lbMenu1.setText(prodConsulta.get(0).getNombreProducto());
            this.vRegOrd.lbMenu2.setText(prodConsulta.get(1).getNombreProducto());
            this.vRegOrd.lbMenu3.setText(prodConsulta.get(2).getNombreProducto());
            this.vRegOrd.lbMenu4.setText(prodConsulta.get(3).getNombreProducto());
            this.vRegOrd.lbMenu5.setText(prodConsulta.get(4).getNombreProducto());
            this.vRegOrd.lbMenu6.setText(prodConsulta.get(5).getNombreProducto());
            this.vRegOrd.lbMenu7.setText(prodConsulta.get(6).getNombreProducto());
            this.vRegOrd.lbMenu8.setText(prodConsulta.get(7).getNombreProducto());
            //VER DONDE SE VAN A INGRESAR LAS IMAGENES.
            

    }

    private ArrayList<String[]> leerDatos(){
        ArrayList<String[]> tomaOrden = new ArrayList<>();
        
        // variable = codigo,  nombre, cantidad,  precio unitario, sub Total.
        if(!(vRegOrd.spMenu1.getValue().toString()).equals("0")){
            float total = Integer.valueOf(vRegOrd.spMenu1.getValue().toString()) * prodConsulta.get(0).getPrecioProducto();
            
           String[] variable = {String.valueOf(prodConsulta.get(0).getIdProducto()) , vRegOrd.lbMenu1.getText(),  vRegOrd.spMenu1.getValue().toString(), String.valueOf(prodConsulta.get(0).getPrecioProducto()), String.valueOf(total)};
           tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu2.getValue().toString()).equals("0")){
            float total = Integer.valueOf(vRegOrd.spMenu2.getValue().toString()) * prodConsulta.get(1).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(1).getIdProducto()) , vRegOrd.lbMenu2.getText(),  vRegOrd.spMenu2.getValue().toString(), String.valueOf(prodConsulta.get(1).getPrecioProducto()), String.valueOf(total)};
             //String[] variable = {vRegOrd.lbMesa.getText(), vRegOrd.lbMenu2.getText(),  vRegOrd.spMenu2.getValue().toString()};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu3.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu3.getValue().toString()) * prodConsulta.get(2).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(2).getIdProducto()) , vRegOrd.lbMenu3.getText(),  vRegOrd.spMenu3.getValue().toString(), String.valueOf(prodConsulta.get(2).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu4.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu4.getValue().toString()) * prodConsulta.get(3).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(3).getIdProducto()) , vRegOrd.lbMenu4.getText(),  vRegOrd.spMenu4.getValue().toString(), String.valueOf(prodConsulta.get(3).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu5.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu5.getValue().toString()) * prodConsulta.get(4).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(4).getIdProducto()) , vRegOrd.lbMenu5.getText(),  vRegOrd.spMenu5.getValue().toString(), String.valueOf(prodConsulta.get(4).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu6.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu6.getValue().toString()) * prodConsulta.get(5).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(5).getIdProducto()) , vRegOrd.lbMenu6.getText(),  vRegOrd.spMenu6.getValue().toString(), String.valueOf(prodConsulta.get(5).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }

        if(!(vRegOrd.spMenu7.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu7.getValue().toString()) * prodConsulta.get(6).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(6).getIdProducto()) , vRegOrd.lbMenu7.getText(),  vRegOrd.spMenu7.getValue().toString(), String.valueOf(prodConsulta.get(6).getPrecioProducto()), String.valueOf(total)};
            tomaOrden.add(variable);
        }
        if(!(vRegOrd.spMenu8.getValue().toString()).equals("0")){
             float total = Integer.valueOf(vRegOrd.spMenu8.getValue().toString()) * prodConsulta.get(7).getPrecioProducto();
            String[] variable = {String.valueOf(prodConsulta.get(7).getIdProducto()) , vRegOrd.lbMenu8.getText(),  vRegOrd.spMenu8.getValue().toString(), String.valueOf(prodConsulta.get(7).getPrecioProducto()), String.valueOf(total)};
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
        
        if (i == 1) {
            rovo.setEstado_orden("servida");
        }
        if (i == 2){
            rovo.setEstado_orden("libre");
        }
        
        rovo.setFkIdOrden(Integer.parseInt(vRegOrd.txtNumOrden.getText()));

        if (this.rodao.insertar(rovo)== true) {
            vRegOrd.jopInfo.showMessageDialog(vRegOrd, "Datos registrados correctamente");
        }
        else{
            System.err.println("PROBLEMA AL INSERTAR");;
        }
//        }

    }
    
    
    private void insertarTomaDatos(){

          //ORDEN
        ovo.setNumMesa(Integer.valueOf(vRegOrd.lbMesa.getText()));
        ovo.setSubTotal(totalOrden);
        ovo.setFkIdUsuario(2);                //PENDIENTE DE OBTENER
        ovo.setFkIdRestaurante(1);          //PENDIENTE DE OBTENER
        ovo.setFkIdCliente(1);                // PENDIENTE: COMO SE OBTENDRA, SI LA FACTURA ES DESPUES?
        if (this.odao.insertar(ovo)== true) {
              
               // REGISTRO ORDENES
        rovo.setFecha(vRegOrd.lbFecha.getText());
        rovo.setEstado_orden("orden");
        rovo.setFkIdOrden(Integer.parseInt(vRegOrd.txtNumOrden.getText()));


            if (this.rodao.insertar(rovo)== true) {
                 
                 //DETALLE ORDEN
                    for(String[] valorPedido : leerDatos()){
                        // dovo = cantidad, sub Total, no orden, id de producto  
                        dovo.setCantidad(Integer.valueOf(valorPedido[2]));
                        dovo.setSubTotal(Double.valueOf(valorPedido[4]));
                        dovo.setFkIDOrden(Integer.valueOf(vRegOrd.txtNumOrden.getText()));
                        dovo.setFkIdProducto(Integer.valueOf(valorPedido[0]));
                     
                        if (this.dodao.insertar(dovo) == false) {
                            vRegOrd.jopInfo.showMessageDialog(vRegOrd, "ERROR DETALLE ORDEN");
                    } else {
                        System.err.println("todo bien");;
                    }
                }

            }
            else{
                System.err.println("PROBLEMA AL INSERTAR REGISTRO ORDEN");;
            }
            //---
            }
        else{
            System.err.println("PROBLEMA AL INSERTAR ORDEN");;
        }
        
        
        
    }
     
    
    
             
    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if (e.getSource().equals(vRegOrd.btnAceptar)){
            
            
            //ESCRIBIR DATOS A CAJA TEXTO
            // variable = cantidad,  nombre,  precio unitario, sub Total.
                vRegOrd.txtDetalle.setText("");
                for(String[] valorPedido : leerDatos()){
                vRegOrd.txtDetalle.append(valorPedido[2] + "). " + valorPedido[1] + ".  " + " Q" + valorPedido[3] + "      SubTotal: " + valorPedido[4] + "\n");
                totalOrden += Double.valueOf(valorPedido[4]);
            }
                
                insertarTomaDatos();
            
             
        }
        
        if (e.getSource().equals(vRegOrd.btnCancelar)){
            vRegOrd.dispose();
            limpiar();
        }
        
        if (e.getSource().equals(vRegOrd.btnServido)){
            if ((vRegOrd.lbEstadoMesa.getText().equals("orden"))) {
                cerrarMesa(1);
                vRegOrd.jopInfo.showMessageDialog(vRegOrd, "Mesa Servida");
             }else{
                 vRegOrd.jopInfo.showMessageDialog(vRegOrd, "La mesa no tiene Orden");
             }
            limpiar();
        }
        
        
        
         if (e.getSource().equals(vRegOrd.btnFacturar)){
             fFa.lblFacutraOrden.setText(vRegOrd.txtNumOrden.getText());
             fFa.setVisible(true);
             fFa.setLocationRelativeTo(vRegOrd);
            
        }
         
         if (e.getSource().equals(vRegOrd.btnCerrarMesa)){
             if (!(vRegOrd.lbEstadoMesa.getText().equals("libre"))) {
                cerrarMesa(2);
                vRegOrd.jopInfo.showMessageDialog(vRegOrd, "Mesa cerrada");
             }else{
                 vRegOrd.jopInfo.showMessageDialog(vRegOrd, "La mesa No debe estar libre para cerrar la Mesa");
             }   
        }
    }

    
      
    @Override
    public void windowOpened(WindowEvent e) {
       consultarProducto();
       
//       // pureba desde aca
//        if (vRegOrd.lbEstadoMesa.getText().equals("orden") || vRegOrd.lbEstadoMesa.getText().equals("servida") || vRegOrd.lbEstadoMesa.getText().equals("facturada")) {
//                                for(OrdenVO ovo: odao.consultar(Integer.valueOf(vRegOrd.txtNumOrden.getText()))){
//                                    vRegOrd.txtNumOrden.setText(String.valueOf(ovo.getIdOrden()));
//                                            //System.out.println(ovo.getJoinIdRegistro());
//                                    vRegOrd.lbMesa.setText(String.valueOf(ovo.getNumMesa()));
//                                    vRegOrd.txtDetalle.append("MONTO TOTAL: " + String.valueOf(ovo.getSubTotal()) + " \n");
//                                }
//                                
//                                //detalle orden
//                                for(DetalleOrdenVO dovo : dodao.consultar(Integer.valueOf(vRegOrd.txtNumOrden.getText()))){
//
//                                    // vRegOrd.txtDetalle.append( "ORDEN: " + String.valueOf(dovo.getFkIDOrden())+ "\n");
//                                    vRegOrd.txtDetalle.append(String.valueOf(dovo.getCantidad())+ " DE: ");
//
//                                    vRegOrd.txtDetalle.append(pdao.consultaExactaP(pvo).get(0).getNombreProducto());/// nombre producto
//
//                                    vRegOrd.txtDetalle.append(" SUBTOTAL: " +String.valueOf(dovo.getSubTotal()) + "\n");
//
//                                }
//        }
       
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
