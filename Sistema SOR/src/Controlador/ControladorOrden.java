/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.DetalleOrdenDAO;
import Modelo.DetalleOrdenVO;
import Modelo.Extras;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Vista.FrmMesas;
import Vista.FrmRegistroOrden;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class ControladorOrden implements ActionListener, WindowListener{
    
    FrmMesas vMesa = new FrmMesas();
    OrdenDAO ordenDAO = new OrdenDAO();
    OrdenVO ordenVO = new OrdenVO();
    Extras extra = new Extras();
    
    DetalleOrdenDAO dodao = new DetalleOrdenDAO();
    DetalleOrdenVO doVO = new DetalleOrdenVO();
    
    FrmRegistroOrden vRegOrd = new FrmRegistroOrden();
    
    String[] estadoMesa = new String[10];
    Integer[] numeroOrden = new Integer[10];
    String usuario;
    
    //TIMER
//    int hor = 0;
//    int min = 0;
//    int seg = 0;
//    
//    int segM1 = 0;
    

    public ControladorOrden(FrmMesas vMesa, OrdenDAO ordenDAO, OrdenVO ordenVO, FrmRegistroOrden vRegOrd) {
        this.vMesa = vMesa;
        this.ordenDAO = ordenDAO;
        this.ordenVO = ordenVO;
        this.vRegOrd = vRegOrd;
        
        
        vMesa.btnMesa3.addActionListener(this);
        vMesa.btnMesa1.addActionListener(this);
        vMesa.btnMesa2.addActionListener(this);
        vMesa.btnMesa4.addActionListener(this);
        vMesa.btnMesa5.addActionListener(this);
        vMesa.btnMesa6.addActionListener(this);
        vMesa.btnMesa7.addActionListener(this);
        vMesa.btnMesa8.addActionListener(this);
        vMesa.btnMesa9.addActionListener(this);
        vMesa.btnActualizar.addActionListener(this);
        
        vMesa.addWindowListener(this);
        
    }

    //TIMER
//    Timer timerM1 = new Timer(1000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                ++seg;
//                if((seg != 0)&&(seg%60 == 0)){
//                    ++min;
//                    seg = 0;
//                    if(min%60 == 0){
//                        min=0;
//                        ++hor;
//                        if(hor%60 == 0){
//                            hor = 0;
//                        }
//                    }
//                }
//                
//                vMesa.jLabel4.setText((hor<10? ("0"+hor):(hor))+ ":"+(min<10? ("0"+min):(min))+ ":"+ (seg<10 ? ("0"+ seg): (seg)) ); 
//                
//            }
//    });
    
    
    // TIMER ESCANEAR ORDENES
//        Timer timerM2 = new Timer(20000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               
//            }
//    });
    
    
        public void dibujarMesa(){
            System.out.println("dibujar mesa"); //temporal
            
            for(int i=1 ; i<9; i++){    

               switch(i){
                   case 1: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa1.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else { 
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa1.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa1.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa1.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       
                      break;
                   }
                   case 2: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa2.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa2.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa2.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa2.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                   }
                   
                   case 3: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa3.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa3.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa3.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa3.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                   }
                   case 4: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa4.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa4.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa4.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa4.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                   }
                   
                   case 5: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa5.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa5.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa5.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa5.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                       
                   }
                   
                   case 6: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa6.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa6.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa6.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa6.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                       
                   }
                   
                   case 7: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa7.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa7.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa7.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa7.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                       
                   }
                   
                   case 8: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa8.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa8.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa8.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa8.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                       
                   }
                   
                   case 9: {
                       if(this.estadoMesa[i].equals("libre")){  vMesa.btnMesa9.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_gris200.png")));  
                       }else {    
                        if(this.estadoMesa[i].equals("orden")){  vMesa.btnMesa9.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png"))); 
                        }else {
                            if(this.estadoMesa[i].equals("servida")){  vMesa.btnMesa9.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_azul200.png")));  
                            }else{
                                  vMesa.btnMesa9.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_verde200.png")));  
                            }
                        }
                       }
                       break;
                       
                   }
               }
        }
    }
        
        
//        timerM1.start();
//        timerM2.start();





/////////////////////
        
         private void estadoMesas(){


                //ESTADO INICIAL
       for(int i=1 ; i<=9; i++){
            for(OrdenVO ovo: ordenDAO.consultarJoin(i)){
                this.estadoMesa[i] = ovo.getJoinEstadoOrden();//
                this.numeroOrden[i] =ovo.getIdOrden();
                
                //System.out.println(ovo.getIdOrden());
                
            }
       }
     
       dibujarMesa();
       this.usuario = vMesa.jlbNombre.getText();
       //String fe = extra.fechaHoy();
       vMesa.jlbFecha.setText(extra.fechaHoy());



    }
        
        
    private void leerPedido(int x) {
        System.out.println("llerPedido"); //TEMPORAL
                    this.vRegOrd.lbUsuario.setText(usuario);
                    this.vRegOrd.lbMesa.setText(String.valueOf(x));
                    this.vRegOrd.lbFecha.setText(extra.fechaHoy());
                    this.vRegOrd.lbEstadoMesa.setText(this.estadoMesa[x]);
                    
            if(estadoMesa[x].equals("libre")){
                    this.vRegOrd.setVisible(true);
                    System.out.println(this.numeroOrden[x]);
                    //Nueva Orden
                    Integer nuevaOrden = this.numeroOrden[x] +1;                    
                    this.vRegOrd.txtNumOrden.setText(String.valueOf(nuevaOrden));
                    this.vRegOrd.setLocationRelativeTo(vMesa);
                //  this.vRegOrd.lbMenu1.setText("PRUEBA");
                //    this.vRegOrd.txtDetalle.append("HDLJASLFJALJADSLFAD;DKFAJALKJADS;LF \n");
                    
                
            }else{
                    this.vRegOrd.setVisible(true);
                    this.vRegOrd.setLocationRelativeTo(vMesa);                    
                    
                   // vRegOrd.txtDetalle.append(String.valueOf());
                    for(OrdenVO ovo: ordenDAO.consultar(numeroOrden[x])){
                        vRegOrd.txtNumOrden.setText(String.valueOf(ovo.getIdOrden()));
                        //System.out.println(ovo.getJoinIdRegistro());
                        vRegOrd.lbMesa.setText(String.valueOf(ovo.getNumMesa()));
                        vRegOrd.txtDetalle.append("MONTO TOTAL: " + String.valueOf(ovo.getSubTotal()) + " \n");
                    }
                    
                    for(DetalleOrdenVO dovo : dodao.consultar(numeroOrden[2])){
                        
                        // vRegOrd.txtDetalle.append( "ORDEN: " + String.valueOf(dovo.getFkIDOrden())+ "\n");
                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getCantidad())+ " DE: ");
                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getFkIdProducto())+ " SUBTOTAL: ");
                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getSubTotal()) + "\n");  ///POSIBLE ERROR
                    
                    }
                
            }
    }
        
        //YA
    @Override
    public void actionPerformed(ActionEvent e) {
        //MESA 1
        if (e.getSource().equals(vMesa.btnMesa1)){
            leerPedido(1);
        }
        
        //MESA 2
        if (e.getSource().equals(vMesa.btnMesa2)){
            leerPedido(2);
           
        }
        
        if (e.getSource().equals(vMesa.btnMesa3)){
            leerPedido(3);
        }
        
        if (e.getSource().equals(vMesa.btnMesa4)){
           leerPedido(4);
        }
        
        if (e.getSource().equals(vMesa.btnMesa5)){
          leerPedido(5);
        }
        
        if (e.getSource().equals(vMesa.btnMesa6)){
             leerPedido(6);
        }
        
        if (e.getSource().equals(vMesa.btnMesa7)){
            leerPedido(7);
        }
        
        if (e.getSource().equals(vMesa.btnMesa8)){
              leerPedido(8);
        }
        
        if (e.getSource().equals(vMesa.btnMesa9)){
             leerPedido(9);
        }
        
        //ACTUALIZAR
        if(e.getSource().equals(vMesa.btnActualizar)){
            estadoMesas();
        }

    }
    
   
    

    @Override
    public void windowOpened(WindowEvent e) {
     estadoMesas();


    }

    @Override
    public void windowClosing(WindowEvent e) {
        
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
