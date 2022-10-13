/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LoginDAO;
import Modelo.ProductoDAO;
import Modelo.ProductoVO;
import Vista.FrmProductosAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboteo
 */
public class ControladorProductosAdmin implements ActionListener, WindowListener, MouseListener{

    LoginDAO ldao = new LoginDAO();
    FrmProductosAdmin vPa = new FrmProductosAdmin();
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO pvo = new ProductoVO();

    public ControladorProductosAdmin(FrmProductosAdmin vPa, ProductoDAO pdao,
            ProductoVO pvo,LoginDAO ldao ) {
    
        this.vPa = vPa;
        this.pdao = pdao;
        this.pvo = pvo;
        this.ldao = ldao;
        
        this.vPa.btnProductosAdminCreate.addActionListener(this);
        this.vPa.btnProductosAdminRead.addActionListener(this);
        this.vPa.btnProductosAdminUpdate.addActionListener(this);
        this.vPa.btnProductosAdminDelete.addActionListener(this);
        this.vPa.btnProductosAdminLimpiar.addActionListener(this);
        this.vPa.btnProductosAdminCancelar.addActionListener(this);
        this.vPa.addWindowListener(this);
        this.vPa.tblProductosAdminTable.addMouseListener(this);
    }
    
    private void seleccionarId(){
        int r = vPa.tblProductosAdminTable.getSelectedRow();
        int idTable = (int) vPa.tblProductosAdminTable.getValueAt(r, 0);
        pvo.setIdProducto(idTable);
        
        //Para llenar los datos
        pvo.setNombreProducto(vPa.tblProductosAdminTable.getValueAt(r, 1).toString());
        pvo.setPrecioProducto(Float.parseFloat(vPa.tblProductosAdminTable.getValueAt(r, 2).toString()));
        pvo.setDescripcionProducto(vPa.tblProductosAdminTable.getValueAt(r, 3).toString());
        //Falta agregar el codigo de imagen
        
        vPa.txtProductosAdminNombre.setText(pvo.getNombreProducto());
        vPa.txtProductosAdminPrecio.setText(String.valueOf(pvo.getPrecioProducto()));
        vPa.txtProductosAdminDescripcion.setText(pvo.getDescripcionProducto());
        //Falta agregar el codigo de imagen
        
    }
    
    private void inicializarF(){
        //Inicializar botones
        vPa.btnProductosAdminCreate.setEnabled(true);
        vPa.btnProductosAdminRead.setEnabled(true);
        //Limpiar Texto
        vPa.txtProductosAdminNombre.setText("");
        vPa.txtProductosAdminPrecio.setText("");
        vPa.txtProductosAdminDescripcion.setText("");
        //Hacer los textos editables
        vPa.txtProductosAdminNombre.setEditable(true);
        vPa.txtProductosAdminPrecio.setEditable(true);
        vPa.txtProductosAdminDescripcion.setEditable(true);
        //Oculatar tabla
        vPa.tblProductosAdminTable.setVisible(false);
    }
    
    private boolean crearP(){
        pvo.setNombreProducto(vPa.txtProductosAdminNombre.getText().toString());
        pvo.setPrecioProducto(Float.parseFloat(vPa.txtProductosAdminPrecio.getText().toString()));
        pvo.setDescripcionProducto(vPa.txtProductosAdminDescripcion.getText().toString());
        pvo.setCodImagenProducto(0000);
        return pdao.insertarP(pvo);
    }
    
    private void mostrarP(){
        //Modificaciones para la tabla
        DefaultTableModel m = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m.setColumnCount(0);
        m.addColumn("Id");
        m.addColumn("Nombre");
        m.addColumn("Precio(Q)");
        m.addColumn("Descripcion");
        m.addColumn("Cod Img");
        
        for (ProductoVO pvo1:pdao.consultarP()){
            m.addRow(new Object[] {pvo1.getIdProducto(),pvo1.getNombreProducto(),
                pvo1.getPrecioProducto(),pvo1.getDescripcionProducto(),
                pvo1.getCodImagenProducto()});
        }
        
        //Parametros para la tabla
        vPa.tblProductosAdminTable.setModel(m);
        
        //Deshabilitar el ingreso de datos
        vPa.txtProductosAdminNombre.setEditable(false);
        vPa.txtProductosAdminPrecio.setEditable(false);
        vPa.txtProductosAdminDescripcion.setEditable(false);
        vPa.lblProductosAdminImg.setEnabled(false);
        
        //Deshabilitar botones
        vPa.btnProductosAdminCreate.setEnabled(false);
        vPa.btnProductosAdminRead.setEnabled(false);
        
        vPa.tblProductosAdminTable.setVisible(true);
    }
    
    private boolean eliminarP(){
        return pdao.eliminarP(pvo);
    }
    
    private boolean modicarP(){
        return pdao.actualizarP(pvo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==vPa.btnProductosAdminCreate){
            if(vPa.txtProductosAdminNombre.getText().isEmpty() || 
                    vPa.txtProductosAdminPrecio.getText().isEmpty() || 
                    vPa.txtProductosAdminDescripcion.getText().isEmpty()){
                    vPa.jopProductosAdmin.showMessageDialog(vPa, "Debe completar todas las casillas");
            }else{
                if(crearP()){
                    vPa.jopProductosAdmin.showMessageDialog(vPa, "Producto creado de forma correcta");
                    inicializarF();
                }else{
                    vPa.jopProductosAdmin.showMessageDialog(vPa, "Error al crear Producto");
                }
            }
        }
        if(e.getSource()==vPa.btnProductosAdminRead){
            mostrarP();
        }
        if(e.getSource()==vPa.btnProductosAdminUpdate){
            if(vPa.txtProductosAdminNombre.getText().isEmpty() || 
                    vPa.txtProductosAdminPrecio.getText().isEmpty() || 
                    vPa.txtProductosAdminDescripcion.getText().isEmpty()){
                
                vPa.jopProductosAdmin.showMessageDialog(vPa, "Debes completar todos los datos");
            }
            else{
                //Llenar los campos nuevos
                pvo.setNombreProducto(vPa.txtProductosAdminNombre.getText().toString());
                pvo.setPrecioProducto(Float.parseFloat(vPa.txtProductosAdminPrecio.getText().toString()));
                pvo.setDescripcionProducto(vPa.txtProductosAdminDescripcion.getText().toString());
                pvo.setCodImagenProducto(0000);
                
                if(modicarP()){
                    vPa.jopProductosAdmin.showMessageDialog(vPa, "Usuario modificado correctamente");
                    mostrarP();
                }
                else{
                    vPa.jopProductosAdmin.showMessageDialog(vPa, "Error al modificar el producto");
                    mostrarP();
                }
            }
        }
        if(e.getSource()==vPa.btnProductosAdminDelete){
            if(eliminarP()){
                vPa.jopProductosAdmin.showMessageDialog(vPa, "Producto eliminadod Correctamente");
            }else{
                vPa.jopProductosAdmin.showMessageDialog(vPa,"Error al eliminar el producto");
            }
            vPa.txtProductosAdminNombre.setText("");
            vPa.txtProductosAdminPrecio.setText("");
            vPa.txtProductosAdminDescripcion.setText("");
            mostrarP();
        }
        if(e.getSource()==vPa.btnProductosAdminCancelar){
            vPa.dispose();
        }
        if(e.getSource()==vPa.btnProductosAdminLimpiar){
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

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getClickCount()==1){
            vPa.txtProductosAdminNombre.setEditable(true);
            vPa.txtProductosAdminPrecio.setEditable(true);
            vPa.txtProductosAdminDescripcion.setEditable(true);
            
            vPa.btnProductosAdminCreate.setEnabled(false);
            vPa.btnProductosAdminRead.setEnabled(false);
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
