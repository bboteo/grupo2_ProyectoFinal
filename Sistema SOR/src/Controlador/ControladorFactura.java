/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import Vista.FrmFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 *
 * @author bboteo
 */
public class ControladorFactura implements ActionListener, WindowListener{

    FrmFactura vFa = new FrmFactura();
    ClienteDAO cdao = new ClienteDAO();
    ClienteVO cvo = new ClienteVO();
    //Para validar si el cliente es nuevo
    private boolean clienteNuevo = false;
    
    public ControladorFactura(FrmFactura vFa, ClienteDAO cdao, ClienteVO cvo) {
        this.vFa = vFa;
        this.cdao = cdao;
        this.cvo = cvo;
        
        vFa.btnFacturaBuscar.addActionListener(this);
        vFa.btnFacturaCf.addActionListener(this);
        vFa.btnFacturaCancelar.addActionListener(this);
        vFa.btnFacturaFactura.addActionListener(this);
        
        vFa.addWindowListener(this);
    }

    private void inicializar(){
        vFa.txtFacturaNit.setText("");
        vFa.txtFacturaNombre.setText("");
        vFa.txtFacturaNombre.setEditable(false);
        vFa.txtFacturaApellido.setText("");
        vFa.txtFacturaApellido.setEditable(false);
        vFa.txtFacturaTelefono.setText("");
        vFa.txtFacturaTelefono.setEditable(false);
        clienteNuevo = false;
       
    }
    
    private boolean buscarcliente(){
        ArrayList<ClienteVO> info = new ArrayList<>();
                
        info = cdao.consultarC(cvo);
        if(info.isEmpty()){
            //El cliente es nuevo
            clienteNuevo = true;
            return false;
        }
        else{
            //El cliente ya existe
            clienteNuevo = false;
            vFa.txtFacturaNombre.setText(info.get(0).getNombreCliente());
            vFa.txtFacturaApellido.setText(info.get(0).getApellidoCliente());
            vFa.txtFacturaTelefono.setText(info.get(0).getTelefonoCliente());
            //vFa.txtFacturaNit.setEnabled(false);
            return true;
        }
    }
    
    private boolean ingresarcliente(){
        cvo.setNitCliente(vFa.txtFacturaNit.getText().toString());
        cvo.setNombreCliente(vFa.txtFacturaNombre.getText().toString());
        cvo.setApellidoCliente(vFa.txtFacturaApellido.getText().toString());
        cvo.setTelefonoCliente(vFa.txtFacturaTelefono.getText().toString());
        return cdao.insertarC(cvo);
    }
    
    private void reporte(){
        System.out.println("Estoy haciendo el reporte");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vFa.btnFacturaBuscar){
            if(!vFa.txtFacturaNit.getText().isEmpty()){
                cvo.setNitCliente(vFa.txtFacturaNit.getText().toString());
                if(!buscarcliente()){
                    //Indicar que debe llenar los campos faltantes
                    vFa.jopFactura.showMessageDialog(vFa, "Este es un cliente nuevo, completa la informacion");
                    vFa.txtFacturaNombre.setText("");
                    vFa.txtFacturaNombre.setEditable(true);
                    vFa.txtFacturaApellido.setText("");
                    vFa.txtFacturaApellido.setEditable(true);
                    vFa.txtFacturaTelefono.setText("");
                    vFa.txtFacturaTelefono.setEditable(true);
                }
                else{
                   //Indicar que el cliente ya existe
                    vFa.jopFactura.showMessageDialog(vFa, "Este cliente ya existen en la base de datos");
                    vFa.txtFacturaNombre.setEditable(false);
                    vFa.txtFacturaApellido.setEditable(false);
                    vFa.txtFacturaTelefono.setEditable(false); 
                }
            }
            else{
                //Debo poner un nit
                vFa.jopFactura.showMessageDialog(vFa, "Debe ingresar un numero de NIT");
            }
        }
        if(e.getSource()==vFa.btnFacturaFactura){
            if(clienteNuevo){
                //Validar que todas las casillas esten llenas
                if(vFa.txtFacturaNit.getText().isEmpty()||
                        vFa.txtFacturaNombre.getText().isEmpty()){
                    vFa.jopFactura.showMessageDialog(vFa, "Debe ingresar como minimo el NIT y Nombre");
                }else{
                    if(ingresarcliente()){
                        //Hacer reporte
                        reporte();
                    }else{
                        //Error al ingresar al cliente
                        vFa.jopFactura.showMessageDialog(vFa, "Error al ingresar al cliente");
                    }
                }                        
            }else{
                //Hacer Reporte
                reporte();
            }
        }
        if(e.getSource()==vFa.btnFacturaCf){
            //Seleccionar al id=1 de la base de datos Cliente
            cvo.setNitCliente("CF");
            vFa.txtFacturaNit.setText("CF");
            buscarcliente();
        }
        if(e.getSource()==vFa.btnFacturaCancelar){
            vFa.dispose();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        inicializar();
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
