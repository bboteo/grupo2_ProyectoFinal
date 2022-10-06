/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.UsuarioDAO;
import Modelo.UsuarioVO;
import Vista.FrmUsuariosAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboteo
 */
public class ControladorUsuriosAdmin implements ActionListener, WindowListener, MouseListener{
    LoginDAO ldao = new LoginDAO();
    FrmUsuariosAdmin vUa = new FrmUsuariosAdmin();
    UsuarioDAO udao = new UsuarioDAO();
    UsuarioVO uvo = new UsuarioVO();

    public ControladorUsuriosAdmin(FrmUsuariosAdmin vUa, UsuarioDAO udao, UsuarioVO uvo,LoginDAO ldao) {
        this.vUa = vUa;
        this.udao = udao;
        this.uvo = uvo;
        this.ldao = ldao;
        
        this.vUa.btnUsuarioAdminCreate.addActionListener(this);
        this.vUa.btnUsuarioAdminRead.addActionListener(this);
        this.vUa.btnUsuarioAdminUpdate.addActionListener(this);
        this.vUa.btnUsuarioAdminDelete.addActionListener(this);
        this.vUa.btnUsuarioAdminCancelar.addActionListener(this);
        this.vUa.btnUsuariosAdminLimpiar.addActionListener(this);
        this.vUa.addWindowListener(this);
        this.vUa.tblUsuariosAdminMostrar.addMouseListener(this);
    }
    
    private void seleccionarId(){
        int r = vUa.tblUsuariosAdminMostrar.getSelectedRow();
        int idTable = (int) vUa.tblUsuariosAdminMostrar.getValueAt(r, 0);
        uvo.setId_usuario(idTable);
        
        //Para llenar los datos
        uvo.setUsername(vUa.tblUsuariosAdminMostrar.getValueAt(r, 1).toString());
        uvo.setNombre(vUa.tblUsuariosAdminMostrar.getValueAt(r, 2).toString());
        uvo.setApellido(vUa.tblUsuariosAdminMostrar.getValueAt(r, 3).toString());
        uvo.setContrasena(vUa.tblUsuariosAdminMostrar.getValueAt(r, 4).toString());
        
        
        vUa.txtUsuarioAdminUsuario.setText(uvo.getUsername());
        vUa.txtUsuarioAdminNombre.setText(uvo.getNombre());
        vUa.txtUsuarioAdminApellido.setText(uvo.getApellido());
        vUa.txtUsuarioAdminContrasena.setText(uvo.getContrasena());
        
        //Traer info del jcomboBox
        switch(vUa.tblUsuariosAdminMostrar.getValueAt(r, 5).toString()){
            case "admin":
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(0);
                uvo.setTipo_usuario("admin");
                break;
            case "mesero":
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(1);
                uvo.setTipo_usuario("mesero");
                break;
            case "host":
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(2);
                uvo.setTipo_usuario("host");
                break;
            case "cocina":
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(3);
                uvo.setTipo_usuario("cocina");
                break;
            case "bar":
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(4);
                uvo.setTipo_usuario("bar");
                break;
            default:
                break;
        }
    }
    
    private void inicializarF(){
        //Inicializar botones
        vUa.btnUsuarioAdminCreate.setEnabled(true);
        vUa.btnUsuarioAdminRead.setEnabled(true);

        //Limpia texto
        vUa.txtUsuarioAdminUsuario.setText("");
        vUa.txtUsuarioAdminNombre.setText("");
        vUa.txtUsuarioAdminApellido.setText("");
        vUa.txtUsuarioAdminContrasena.setText("");
        vUa.jcbUsuarioAdminTipo.setSelectedIndex(5);
        //Los hace editables
        vUa.txtUsuarioAdminUsuario.setEditable(true);
        vUa.txtUsuarioAdminNombre.setEditable(true);
        vUa.txtUsuarioAdminApellido.setEditable(true);
        vUa.txtUsuarioAdminContrasena.setEditable(true);
        vUa.jcbUsuarioAdminTipo.setEnabled(true);
        vUa.jcbUsuarioAdminTipo.setEditable(true);
        //Oculta tabla
        vUa.jpUsuarioAdminListar.setVisible(false);
    }
    
    private String jcbTipoUsuario(){
        String tipoUsuario = " ";
        int item = vUa.jcbUsuarioAdminTipo.getSelectedIndex();
        switch (vUa.jcbUsuarioAdminTipo.getSelectedIndex()){
            case 0://Tipo Admin
                tipoUsuario = "admin";
                break;
            case 1://Tipo Mesero
                tipoUsuario = "mesero";
                break;
            case 2://Tipo Host
                tipoUsuario = "host";
                break;
            case 3://Tipo cocina
                tipoUsuario = "cocina";
                break;
            case 4://Tipo Bar
                tipoUsuario = "bar";
                break;
            default:
                break;
        }
        return tipoUsuario;
    }
    
    private boolean crearU(){
        //Si la informacion esta completa
        uvo.setUsername(vUa.txtUsuarioAdminUsuario.getText().toString());
        uvo.setNombre(vUa.txtUsuarioAdminNombre.getText().toString());
        uvo.setApellido(vUa.txtUsuarioAdminApellido.getText().toString());
        uvo.setContrasena(vUa.txtUsuarioAdminContrasena.getText().toString());
        uvo.setTipo_usuario(jcbTipoUsuario());
        return udao.insertarU(uvo);
    }

    private void mostrarU(){
        //Modificaciones para la tabla
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Usuario");
        m.addColumn("Nombre");
        m.addColumn("Apellido");
        m.addColumn("Contrasena");
        m.addColumn("Tipo Usuario");
        m.addColumn("Cod Imagen");
        
        for (UsuarioVO uvo1 : udao.consultarU()){
            m.addRow(new Object[] {uvo1.getId_usuario(),uvo1.getUsername(), uvo1.getNombre(),
                uvo1.getApellido(),uvo1.getContrasena(),uvo1.getTipo_usuario(),
                uvo1.getCod_img_usuario()});
        }
        
        //Parametros Tabla
        vUa.tblUsuariosAdminMostrar.setModel(m);
        vUa.jpUsuarioAdminListar.setVisible(true);
        
        //Ingreso de datos deshabilitado
        vUa.txtUsuarioAdminUsuario.setEditable(false);
        vUa.txtUsuarioAdminNombre.setEditable(false);
        vUa.txtUsuarioAdminApellido.setEditable(false);
        vUa.txtUsuarioAdminContrasena.setEditable(false);
        vUa.jcbUsuarioAdminTipo.setEditable(false);
        vUa.jcbUsuarioAdminTipo.setEnabled(false);
        vUa.jpUsuarioAdminListar.setVisible(true);
        
        //Botones deshabilitados
        vUa.btnUsuarioAdminCreate.setEnabled(false);
        vUa.btnUsuarioAdminRead.setEnabled(false);
    
    }
    
    private boolean eliminarU(){
        return udao.eliminarU(uvo);
    }
    
    private boolean modificarU(){
        
        return udao.actualizarU(uvo);
//        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vUa.btnUsuarioAdminCreate){
            if(vUa.txtUsuarioAdminUsuario.getText().isEmpty() ||
                vUa.txtUsuarioAdminNombre.getText().isEmpty()||
                vUa.txtUsuarioAdminApellido.getText().isEmpty()||
                vUa.txtUsuarioAdminContrasena.getText().isEmpty()||
                vUa.jcbUsuarioAdminTipo.getSelectedIndex()==5){
                
                vUa.jopUsuarioAdmin.showMessageDialog(vUa, "Debe completar todos los datos");
            }
            else{
                if(crearU()){
                    vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Usuario creado de forma correcta");
                    inicializarF();
                }
                else{
                    vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Error al crear Usuario");
                }
            }
        }
        if(e.getSource()==vUa.btnUsuarioAdminRead){
            mostrarU();
        }
        if(e.getSource()==vUa.btnUsuarioAdminUpdate){
            if(vUa.txtUsuarioAdminUsuario.getText().isEmpty() ||
                vUa.txtUsuarioAdminNombre.getText().isEmpty()||
                vUa.txtUsuarioAdminApellido.getText().isEmpty()||
                vUa.txtUsuarioAdminContrasena.getText().isEmpty()||
                vUa.jcbUsuarioAdminTipo.getSelectedIndex()==5){
                
                vUa.jopUsuarioAdmin.showMessageDialog(vUa, "Debe completar todos los datos");
            }
            else{
                //llenar con los campos nuevos
                uvo.setUsername(vUa.txtUsuarioAdminUsuario.getText().toString());
                uvo.setNombre(vUa.txtUsuarioAdminNombre.getText().toString());
                uvo.setApellido(vUa.txtUsuarioAdminApellido.getText().toString());
                uvo.setContrasena(vUa.txtUsuarioAdminContrasena.getText().toString());
                uvo.setTipo_usuario(jcbTipoUsuario());           
                
                if(modificarU()){
                    vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Usuario modificado correctamente");                    
                    mostrarU();
                }
                else{
                    vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Error al modificar usuario");                    
                    mostrarU();
                }
                
            }            
        }
        if(e.getSource()==vUa.btnUsuarioAdminDelete){
            if(eliminarU()){
                vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Usuario eliminado correctamente");
                vUa.txtUsuarioAdminUsuario.setText("");
                vUa.txtUsuarioAdminNombre.setText("");
                vUa.txtUsuarioAdminApellido.setText("");
                vUa.txtUsuarioAdminContrasena.setText("");
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(5);
                mostrarU();
            }
            else{
                vUa.jopUsuarioAdmin.showMessageDialog(vUa,"Error al eliminar usuario");
                vUa.txtUsuarioAdminUsuario.setText("");
                vUa.txtUsuarioAdminNombre.setText("");
                vUa.txtUsuarioAdminApellido.setText("");
                vUa.txtUsuarioAdminContrasena.setText("");
                vUa.jcbUsuarioAdminTipo.setSelectedIndex(5);
                mostrarU();
            }
        }
        if(e.getSource()==vUa.btnUsuarioAdminCancelar){
            vUa.dispose();
        }
        if(e.getSource()==vUa.btnUsuariosAdminLimpiar){
            inicializarF();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        inicializarF();
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
        //inicializarF();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==2){
            vUa.txtUsuarioAdminUsuario.setEditable(true);
            vUa.txtUsuarioAdminNombre.setEditable(true);
            vUa.txtUsuarioAdminApellido.setEditable(true);
            vUa.txtUsuarioAdminContrasena.setEditable(true);
            vUa.jcbUsuarioAdminTipo.setEditable(true);
            vUa.jcbUsuarioAdminTipo.setEnabled(true);
            
            vUa.btnUsuarioAdminCreate.setEnabled(false);
            vUa.btnUsuarioAdminRead.setEnabled(false);
            seleccionarId();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
    
    
}
