/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


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

public class ControladorOrden implements ActionListener, WindowListener{
    
    FrmMesas vMesa = new FrmMesas();
    OrdenDAO ordenDAO = new OrdenDAO();
    OrdenVO ordenVO = new OrdenVO();
    Extras extra = new Extras();
    
    FrmRegistroOrden vRegOrd = new FrmRegistroOrden();
    
    String[] estadoMesa = new String[10];
    String usuario;

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
        
        vMesa.addWindowListener(this);
        
    }

 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(vMesa.btnMesa1)){
                    this.vRegOrd.lbUsuario.setText(usuario);
                    this.vRegOrd.lbMesa.setText("1");
                    this.vRegOrd.lbFecha.setText(extra.fechaHoy());
                    
            if(estadoMesa[1].equals("libre")){
                    this.vRegOrd.setVisible(true);
                    this.vRegOrd.setLocationRelativeTo(vMesa);
                //  this.vRegOrd.lbMenu1.setText("PRUEBA");
                //    this.vRegOrd.txtDetalle.append("HDLJASLFJALJADSLFAD;DKFAJALKJADS;LF \n");
                    
                
            }else{
                    this.vRegOrd.setVisible(true);
                    this.vRegOrd.setLocationRelativeTo(vMesa);
                
            }
            
            
            
            
        }
        
        if (e.getSource().equals(vMesa.btnMesa2)){
           
        }
        
        if (e.getSource().equals(vMesa.btnMesa3)){
      
        }
        
        if (e.getSource().equals(vMesa.btnMesa4)){
          
        }
        
        if (e.getSource().equals(vMesa.btnMesa5)){
         
        }
        
        if (e.getSource().equals(vMesa.btnMesa6)){
            
        }
        
        if (e.getSource().equals(vMesa.btnMesa7)){
           
        }
        
        if (e.getSource().equals(vMesa.btnMesa8)){
             
        }
        
        if (e.getSource().equals(vMesa.btnMesa9)){
            
        }



    
    }

    @Override
    public void windowOpened(WindowEvent e) {
                //  vMesa.btnMesa9.setIcon(new ImageIcon(getClass().getResource("/Img/ic_mesa_amar200.png")));
            
       for(int i=1 ; i<=9; i++){
            for(OrdenVO ovo: ordenDAO.consultarJoin(i)){
                this.estadoMesa[i] = ovo.getJoinEstadoOrden();//
            }
       }
     
       dibujarMesa();
       this.usuario = vMesa.jlbNombre.getText();
       //String fe = extra.fechaHoy();
       vMesa.jlbFecha.setText(extra.fechaHoy());
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
    
}
