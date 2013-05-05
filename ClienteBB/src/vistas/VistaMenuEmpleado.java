package vistas;

import clientebb.*;

public class VistaMenuEmpleado extends javax.swing.JFrame {
    int idCliente;
    ConexionRMI conexion = new ConexionRMI();
    
    public VistaMenuEmpleado() {
        initComponents();
    }
    
    public VistaMenuEmpleado (int id, ConexionRMI obj) {
        initComponents();
        this.idCliente = id;
        this.conexion = obj;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButtonArriendos = new javax.swing.JButton();
        jButtonRegistro = new javax.swing.JButton();
        jButtonClientes = new javax.swing.JButton();
        jLabelEstado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jToggleButtonPerfil = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setText("Menú del empleado");

        jButtonArriendos.setText("Arriendos");
        jButtonArriendos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonArriendosMouseClicked(evt);
            }
        });
        jButtonArriendos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArriendosActionPerformed(evt);
            }
        });

        jButtonRegistro.setText("Registrar");
        jButtonRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistroMouseClicked(evt);
            }
        });

        jButtonClientes.setText("Clientes");

        jLabelEstado.setText("Estado de conexión");

        jButton1.setText("Chat");

        jToggleButtonPerfil.setText("Perfil");
        jToggleButtonPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButtonPerfilMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRegistro)
                    .addComponent(jButtonClientes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonArriendos)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(13, 13, 13)))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabelEstado)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jToggleButtonPerfil)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistro)
                    .addComponent(jButtonArriendos))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClientes)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jToggleButtonPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabelEstado)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonArriendosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArriendosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonArriendosActionPerformed

    private void jButtonRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistroMouseClicked
        VistaRegistrarEmpleado vista = new VistaRegistrarEmpleado(this.idCliente, conexion);
        vista.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonRegistroMouseClicked

    private void jToggleButtonPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButtonPerfilMouseClicked
        VistaPerfilEmpleado vista = new VistaPerfilEmpleado(this.idCliente, conexion);
        vista.setVisible(true);
        dispose();
    }//GEN-LAST:event_jToggleButtonPerfilMouseClicked

    private void jButtonArriendosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonArriendosMouseClicked
        VistaClienteEmpleado vista = new VistaClienteEmpleado(this.idCliente, conexion);
        vista.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonArriendosMouseClicked

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
            java.util.logging.Logger.getLogger(VistaMenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenuEmpleado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonArriendos;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonRegistro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButtonPerfil;
    // End of variables declaration//GEN-END:variables
}
