/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboteo
 */
public class FrmUsuariosAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrmUsuariosAdmin
     */
    public FrmUsuariosAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jopUsuarioAdmin = new javax.swing.JOptionPane();
        txtUsuarioAdminNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbUsuarioAdminTipo = new javax.swing.JComboBox<>();
        txtUsuarioAdminApellido = new javax.swing.JTextField();
        jpUsuarioAdminListar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DefaultTableModel dtm = new DefaultTableModel();
        tblUsuariosAdminMostrar = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtUsuarioAdminContrasena = new javax.swing.JTextField();
        btnUsuarioAdminCreate = new javax.swing.JButton();
        btnUsuarioAdminRead = new javax.swing.JButton();
        btnUsuarioAdminUpdate = new javax.swing.JButton();
        btnUsuarioAdminDelete = new javax.swing.JButton();
        btnUsuarioAdminCancelar = new javax.swing.JButton();
        btnUsuariosAdminLimpiar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtUsuarioAdminUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblUsuarioAdminId = new javax.swing.JLabel();
        lblUsuarioAdmin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD USUARIO ADMIN");

        txtUsuarioAdminNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Apellido");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Tipo Usuario");

        jcbUsuarioAdminTipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbUsuarioAdminTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "admin", "mesero", "host", "cocina", "bar", "" }));

        txtUsuarioAdminApellido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tblUsuariosAdminMostrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(tblUsuariosAdminMostrar);

        javax.swing.GroupLayout jpUsuarioAdminListarLayout = new javax.swing.GroupLayout(jpUsuarioAdminListar);
        jpUsuarioAdminListar.setLayout(jpUsuarioAdminListarLayout);
        jpUsuarioAdminListarLayout.setHorizontalGroup(
            jpUsuarioAdminListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioAdminListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jpUsuarioAdminListarLayout.setVerticalGroup(
            jpUsuarioAdminListarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuarioAdminListarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Contrasena");

        txtUsuarioAdminContrasena.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnUsuarioAdminCreate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioAdminCreate.setText("CREATE");

        btnUsuarioAdminRead.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioAdminRead.setText("READ");

        btnUsuarioAdminUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioAdminUpdate.setText("UPDATE");

        btnUsuarioAdminDelete.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioAdminDelete.setText("DELETE");

        btnUsuarioAdminCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuarioAdminCancelar.setText("Salir");

        btnUsuariosAdminLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUsuariosAdminLimpiar.setText("Limpiar Pantalla");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Usuario");

        txtUsuarioAdminUsuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Ingreso como:");

        lblUsuarioAdminId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuarioAdminId.setText("Id");

        lblUsuarioAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUsuarioAdmin.setText("usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpUsuarioAdminListar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUsuarioAdminCancelar)
                .addGap(14, 14, 14))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuarioAdminId)
                        .addGap(18, 18, 18)
                        .addComponent(lblUsuarioAdmin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(20, 20, 20)
                                .addComponent(jcbUsuarioAdminTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnUsuariosAdminLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(54, 54, 54)
                                        .addComponent(txtUsuarioAdminApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(txtUsuarioAdminContrasena))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(54, 54, 54))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(31, 31, 31)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtUsuarioAdminUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                            .addComponent(txtUsuarioAdminNombre))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnUsuarioAdminCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsuarioAdminRead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsuarioAdminUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUsuarioAdminDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblUsuarioAdminId)
                    .addComponent(lblUsuarioAdmin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUsuarioAdminUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuarioAdminNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtUsuarioAdminApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtUsuarioAdminContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUsuarioAdminCreate)
                        .addGap(19, 19, 19)
                        .addComponent(btnUsuarioAdminRead)
                        .addGap(19, 19, 19)
                        .addComponent(btnUsuarioAdminUpdate)
                        .addGap(19, 19, 19)
                        .addComponent(btnUsuarioAdminDelete)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbUsuarioAdminTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUsuariosAdminLimpiar)))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpUsuarioAdminListar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUsuarioAdminCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUsuariosAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUsuariosAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnUsuarioAdminCancelar;
    public javax.swing.JButton btnUsuarioAdminCreate;
    public javax.swing.JButton btnUsuarioAdminDelete;
    public javax.swing.JButton btnUsuarioAdminRead;
    public javax.swing.JButton btnUsuarioAdminUpdate;
    public javax.swing.JButton btnUsuariosAdminLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JComboBox<String> jcbUsuarioAdminTipo;
    public javax.swing.JOptionPane jopUsuarioAdmin;
    public javax.swing.JPanel jpUsuarioAdminListar;
    public javax.swing.JLabel lblUsuarioAdmin;
    public javax.swing.JLabel lblUsuarioAdminId;
    public javax.swing.JTable tblUsuariosAdminMostrar;
    public javax.swing.JTextField txtUsuarioAdminApellido;
    public javax.swing.JTextField txtUsuarioAdminContrasena;
    public javax.swing.JTextField txtUsuarioAdminNombre;
    public javax.swing.JTextField txtUsuarioAdminUsuario;
    // End of variables declaration//GEN-END:variables
}
