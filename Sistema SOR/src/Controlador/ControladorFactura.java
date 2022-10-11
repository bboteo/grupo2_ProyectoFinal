/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClienteDAO;
import Modelo.ClienteVO;
import Modelo.DetalleOrdenDAO;
import Modelo.DetalleOrdenVO;
import Modelo.OrdenDAO;
import Modelo.OrdenVO;
import Modelo.Reporte;
import Vista.FrmFactura;
import Vista.FrmRegistroOrden;
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
    OrdenDAO odao = new OrdenDAO();
    OrdenVO ovo = new OrdenVO();
    DetalleOrdenDAO ddao = new DetalleOrdenDAO();
    DetalleOrdenVO dvo = new DetalleOrdenVO();
    Reporte rep = new Reporte();
    //Para validar si el cliente es nuevo
    private boolean clienteNuevo = false;
    private String nitFactura = "";
    //JP
    FrmRegistroOrden vRo = new FrmRegistroOrden();
    
    
    public ControladorFactura(FrmFactura vFa, ClienteDAO cdao, ClienteVO cvo,
            FrmRegistroOrden vRo,OrdenDAO odao, OrdenVO ovo, DetalleOrdenDAO ddao, DetalleOrdenVO dvo,  
            Reporte rep) {
        this.vFa = vFa;
        this.cdao = cdao;
        this.cvo = cvo;
        this.vRo = vRo;
        this.odao = odao;
        this.ovo = ovo;
        this.ddao = ddao;
        this.dvo = dvo;
        this.rep = rep;
        
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
        nitFactura = "";
       vFa.lblFacutraOrden.setText("18");
    }
    
    private boolean buscarcliente(){
        ArrayList<ClienteVO> info = new ArrayList<>();
                
        info = cdao.consultarCxNit(cvo);
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
    
    private Double totalFactura(){
        Double total = 0.0;
        ArrayList<DetalleOrdenVO> info = new ArrayList<>();
        info = ddao.consultar(Integer.parseInt(vFa.lblFacutraOrden.getText().toString()));
        //int i = info.size();
        for(int i=0; i<info.size(); i++){
            total = total + info.get(i).getSubTotal();
        }
        return total;
    }
    
    private boolean agregarClienteOrden(){
        ArrayList<ClienteVO> info = new ArrayList<>();
        cvo.setNitCliente(nitFactura);
        info = cdao.consultarCxNit(cvo);
        ovo.setFkIdCliente(info.get(0).getIdCliente());
        ovo.setIdOrden(Integer.parseInt(vFa.lblFacutraOrden.getText().toString()));
        ovo.setSubTotal(totalFactura());
        odao.actualizarXfac(ovo);
        return true;
    }
    
    private void factura(){
        ovo.setIdOrden(Integer.parseInt(vFa.lblFacutraOrden.getText().toString()));
        rep.reporteFactura(ovo);
        rep.jv.setDefaultCloseOperation(vFa.DISPOSE_ON_CLOSE);
        rep.jv.setVisible(true);
    }
    
    private void prepararFactura(){
        if(clienteNuevo){ //Si el cliente es nuevo
            if(vFa.txtFacturaNit.getText().isEmpty()||
                vFa.txtFacturaNombre.getText().isEmpty()){
                vFa.jopFactura.showMessageDialog(vFa, "Debe ingresar como minimo el NIT y Nombre");
            }else{
                if(ingresarcliente()){
                    if(nitFactura.equals(vFa.txtFacturaNit.getText().toString())){
                        //buscar el id del cliente
                        agregarClienteOrden();                        
                        factura();
                    }else{
                        vFa.jopFactura.showMessageDialog(vFa, "Debe buscar nuevamente");
                    }
                }else{
                    //Error al ingresar al cliente
                    vFa.jopFactura.showMessageDialog(vFa, "Error al ingresar al cliente");
                }
            }                        
        }else{ //Si el cliente YA existe
            if(nitFactura.equals(vFa.txtFacturaNit.getText().toString())){
                agregarClienteOrden();
                factura();
            }else{
                vFa.jopFactura.showMessageDialog(vFa, "Debe buscar nuevamente");
            }
        }
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
                nitFactura = vFa.txtFacturaNit.getText().toString();
            }
            else{
                //Debo poner un nit
                vFa.jopFactura.showMessageDialog(vFa, "Debe ingresar un numero de NIT");
            }
        }
        if(e.getSource()==vFa.btnFacturaFactura){
            prepararFactura();
        }
        if(e.getSource()==vFa.btnFacturaCf){
            //Seleccionar al id=1 de la base de datos Cliente
            cvo.setNitCliente("CF");
            vFa.txtFacturaNit.setText("CF");
            buscarcliente();
            nitFactura = vFa.txtFacturaNit.getText().toString();
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
