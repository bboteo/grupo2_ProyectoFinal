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
import Modelo.ProductoDAO;
import Modelo.ProductoVO;
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
    
    // DETALLE ORDEN
    DetalleOrdenDAO dodao = new DetalleOrdenDAO();
    DetalleOrdenVO doVO = new DetalleOrdenVO();
    
    FrmRegistroOrden vRegOrd = new FrmRegistroOrden();
    
    String[] estadoMesa = new String[10];
    Integer[] numeroOrden = new Integer[10];
    String usuario;
    
    // PRODUCTO
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO pvo = new ProductoVO();
    
    //TIMER
    Integer[] tM1 = {0,0,0}, tM2 = {0,0,0}, tM3 = {0,0,0}, tM4 = {0,0,0};
    Integer[] tM5 = {0,0,0}, tM6 = {0,0,0}, tM7 = {0,0,0}, tM8 = {0,0,0}, tM9 = {0,0,0};
 

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
  
    
    public Integer[] cronometro(Integer hor, Integer min, Integer seg){
        Integer timeCronometro[] = new Integer[3];
        
                        seg +=1;
                if((seg != 0)&&(seg%60 == 0)){
                    ++min;
                    seg = 0;
                    if(min%60 == 0){
                        min=0;
                        ++hor;
                        if(hor%60 == 0){
                            hor = 0;
                        }
                    }
                }
                timeCronometro[0] = seg;
                timeCronometro[1] = min;
                timeCronometro[2] = hor;
                
                
        return timeCronometro;
    }
        
            Timer timerM1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(estadoMesa[1].equals("orden")){
                    tM1 = cronometro(tM1[2], tM1[1], tM1[0]);
                    
                }else{
                    tM1[0] = 0;
                    tM1[1] = 0;
                    tM1[2] = 0;
                }
                if(estadoMesa[2].equals("orden") ){
                    tM2 = cronometro(tM2[2], tM2[1], tM2[0]);
                } else {
                    tM2[0] = 0;
                    tM2[1] = 0;
                    tM2[2] = 0;
                }
                
                if(estadoMesa[3].equals("orden")){
                    tM3 = cronometro(tM3[2], tM3[1], tM3[0]);
                } else {
                    tM3[0] = 0;
                    tM3[1] = 0;
                    tM3[2] = 0;
                }
                
                if(estadoMesa[4].equals("orden")){
                    tM4 = cronometro(tM4[2], tM4[1], tM4[0]);

                } else {
                    tM4[0] = 0;
                    tM4[1] = 0;
                    tM4[2] = 0;
                }
                
                if(estadoMesa[5].equals("orden")){
                    tM5 = cronometro(tM5[2], tM5[1], tM5[0]);
                } else {
                    tM5[0] = 0;
                    tM5[1] = 0;
                    tM5[2] = 0;
                }
                
                if(estadoMesa[6].equals("orden")){
                    tM6 = cronometro(tM6[2], tM6[1], tM6[0]);
                } else {
                    tM6[0] = 0;
                    tM6[1] = 0;
                    tM6[2] = 0;
                }
                
                if(estadoMesa[7].equals("orden")){
                    tM7 = cronometro(tM7[2], tM7[1], tM7[0]);
                } else {
                    tM7[0] = 0;
                    tM7[1] = 0;
                    tM7[2] = 0;
                }
                
                if(estadoMesa[8].equals("orden")){
                    tM8 = cronometro(tM8[2], tM8[1], tM8[0]);
                } else {
                    tM8[0] = 0;
                    tM8[1] = 0;
                    tM8[2] = 0;
                }
                
                if(estadoMesa[9].equals("orden")){
                    tM9 = cronometro(tM9[2], tM9[1], tM9[0]);
                } else {
                    tM9[0] = 0;
                    tM9[1] = 0;
                    tM9[2] = 0;
                }

                vMesa.txtTimeM1.setText((tM1[2]<10? ("0"+tM1[2]):(tM1[2]))+ ":"+(tM1[1]<10? ("0"+tM1[1]):(tM1[1]))+ ":"+ (tM1[0]<10 ? ("0"+ tM1[0]): (tM1[0])) );
                vMesa.txtTimeM2.setText((tM2[2]<10? ("0"+tM2[2]):(tM2[2]))+ ":"+(tM2[1]<10? ("0"+tM2[1]):(tM2[1]))+ ":"+ (tM2[0]<10 ? ("0"+ tM2[0]): (tM2[0])) );
                vMesa.txtTimeM3.setText((tM3[2]<10? ("0"+tM3[2]):(tM3[2]))+ ":"+(tM3[1]<10? ("0"+tM3[1]):(tM3[1]))+ ":"+ (tM3[0]<10 ? ("0"+ tM3[0]): (tM3[0])) );
                vMesa.txtTimeM4.setText((tM4[2]<10? ("0"+tM4[2]):(tM4[2]))+ ":"+(tM4[1]<10? ("0"+tM4[1]):(tM4[1]))+ ":"+ (tM4[0]<10 ? ("0"+ tM4[0]): (tM4[0])) );
                vMesa.txtTimeM5.setText((tM5[2]<10? ("0"+tM5[2]):(tM5[2]))+ ":"+(tM5[1]<10? ("0"+tM5[1]):(tM5[1]))+ ":"+ (tM5[0]<10 ? ("0"+ tM5[0]): (tM5[0])) );
                vMesa.txtTimeM6.setText((tM6[2]<10? ("0"+tM6[2]):(tM6[2]))+ ":"+(tM6[1]<10? ("0"+tM6[1]):(tM6[1]))+ ":"+ (tM6[0]<10 ? ("0"+ tM6[0]): (tM6[0])) );
                vMesa.txtTimeM7.setText((tM7[2]<10? ("0"+tM7[2]):(tM7[2]))+ ":"+(tM7[1]<10? ("0"+tM7[1]):(tM7[1]))+ ":"+ (tM7[0]<10 ? ("0"+ tM7[0]): (tM7[0])) );
                vMesa.txtTimeM8.setText((tM8[2]<10? ("0"+tM8[2]):(tM8[2]))+ ":"+(tM8[1]<10? ("0"+tM8[1]):(tM8[1]))+ ":"+ (tM8[0]<10 ? ("0"+ tM8[0]): (tM8[0])) );
                vMesa.txtTimeM9.setText((tM9[2]<10? ("0"+tM9[2]):(tM9[2]))+ ":"+(tM9[1]<10? ("0"+tM9[1]):(tM9[1]))+ ":"+ (tM9[0]<10 ? ("0"+ tM9[0]): (tM9[0])) );
                
            }

    });

    
    // TIMER ESCANEAR ORDENES
//        Timer timerM2 = new Timer(20000, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//               
//            }
//    });
    
    
        public void dibujarMesa(){
            
            
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
        
      
//        timerM2.start();

        
         private void estadoMesas(){


                //ESTADO INICIAL
       for(int i=1 ; i<=9; i++){
            for(OrdenVO ovo: ordenDAO.consultarJoin(i)){
                this.estadoMesa[i] = ovo.getJoinEstadoOrden();//
                this.numeroOrden[i] =ovo.getIdOrden();

            }
       }
     
       dibujarMesa();
       this.usuario = vMesa.jlbNombre.getText();
       //String fe = extra.fechaHoy();
       vMesa.jlbFecha.setText(extra.fechaHoy());



    }
        
        
    private void leerPedido(int x) {
        
                    this.vRegOrd.lbUsuario.setText(usuario);
                    this.vRegOrd.lbMesa.setText(String.valueOf(x));
                    this.vRegOrd.lbFecha.setText(extra.fechaHoy());
                    this.vRegOrd.lbEstadoMesa.setText(this.estadoMesa[x]);
                    
                    
                    
                    // MESA LIBRE
                    
            if(estadoMesa[x].equals("libre")){
                    this.vRegOrd.setVisible(true);
                    
                    //Nueva Orden
                    ordenVO = ordenDAO.consultaUltimaOrd();
                    Integer nuevaOrden = ordenVO.getIdOrden() +1;                    
                    this.vRegOrd.txtNumOrden.setText(String.valueOf(nuevaOrden));
                    this.vRegOrd.setLocationRelativeTo(vMesa);
                
                    
                
                // MESA CON ORDEN DE PEDIDO EN CUALQUIER ESTADO
            }else{
                    this.vRegOrd.setVisible(true);
                    this.vRegOrd.setLocationRelativeTo(vMesa);                    
                    
                   // vRegOrd.txtDetalle.append(String.valueOf());
                    for(OrdenVO ovo: ordenDAO.consultar(numeroOrden[x])){   // de aca
                        vRegOrd.txtNumOrden.setText(String.valueOf(ovo.getIdOrden()));
                        //System.out.println(ovo.getJoinIdRegistro());
                        vRegOrd.lbMesa.setText(String.valueOf(ovo.getNumMesa()));
                        vRegOrd.txtDetalle.append("MONTO TOTAL: " + String.valueOf(ovo.getSubTotal()) + " \n");
                    }
                    
                    for(DetalleOrdenVO dovo : dodao.consultar(numeroOrden[x])){
                        
                        // vRegOrd.txtDetalle.append( "ORDEN: " + String.valueOf(dovo.getFkIDOrden())+ "\n");
                        vRegOrd.txtDetalle.append(String.valueOf(dovo.getCantidad())+ " DE: ");
                        pvo.setIdProducto(dovo.getFkIdProducto());
                        vRegOrd.txtDetalle.append(pdao.consultaExactaP(pvo).get(0).getNombreProducto());///
                        //vRegOrd.txtDetalle.append("daldf");///
                        
                        vRegOrd.txtDetalle.append(" SUBTOTAL: " +String.valueOf(dovo.getSubTotal()) + "\n");
                    
                    }   //hasta aca
                
            }
    }
        
      
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
     timerM1.start();


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
