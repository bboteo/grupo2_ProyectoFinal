/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Estuardo Salay
 */
public class FrmVistaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form vistaAdmin
     */
    public FrmVistaAdmin() {
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

        btnVistaAdminIngresarU = new javax.swing.JButton();
        btnVistaAdminIngresarM = new javax.swing.JButton();
        btnVistaAdminVerMesas = new javax.swing.JButton();
        btnVistaAdminSalir = new javax.swing.JButton();
        lblNombreUsuario = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        lblVistaAdminId = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD ADMIN");

        btnVistaAdminIngresarU.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVistaAdminIngresarU.setText("Gestionar Usuarios");
        btnVistaAdminIngresarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVistaAdminIngresarUActionPerformed(evt);
            }
        });

        btnVistaAdminIngresarM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVistaAdminIngresarM.setText("Gestionar Menu");

        btnVistaAdminVerMesas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVistaAdminVerMesas.setText("Ver Mesas");

        btnVistaAdminSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVistaAdminSalir.setText("Salir");

        lblNombreUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombreUsuario.setText("NombreUsuario");

        lblVistaAdminId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblVistaAdminId.setText("Id");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Ingreso como:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnVistaAdminSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVistaAdminIngresarU, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                    .addComponent(btnVistaAdminIngresarM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVistaAdminVerMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblVistaAdminId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(lblVistaAdminId)
                            .addComponent(jLabel3)))
                    .addComponent(lblid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVistaAdminIngresarU)
                .addGap(18, 18, 18)
                .addComponent(btnVistaAdminIngresarM)
                .addGap(18, 18, 18)
                .addComponent(btnVistaAdminVerMesas)
                .addGap(18, 18, 18)
                .addComponent(btnVistaAdminSalir)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVistaAdminIngresarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVistaAdminIngresarUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVistaAdminIngresarUActionPerformed

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
            java.util.logging.Logger.getLogger(FrmVistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmVistaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnVistaAdminIngresarM;
    public javax.swing.JButton btnVistaAdminIngresarU;
    public javax.swing.JButton btnVistaAdminSalir;
    public javax.swing.JButton btnVistaAdminVerMesas;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel lblNombreUsuario;
    public javax.swing.JLabel lblVistaAdminId;
    public javax.swing.JLabel lblid;
    // End of variables declaration//GEN-END:variables
}
