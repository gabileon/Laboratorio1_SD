package vistas;

import clientebb.*;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VistaMenuCliente extends javax.swing.JFrame {
    int idCliente;
    ConexionRMI conexion = new ConexionRMI();
    
    public VistaMenuCliente() {
        initComponents();
              this.setLocationRelativeTo(null);
    }
    
    public VistaMenuCliente(int id, ConexionRMI obj) {
        initComponents();
        this.idCliente = id;
        this.conexion = obj;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelEstado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonArriendo = new javax.swing.JButton();
        jButtonChat = new javax.swing.JButton();
        jButtonPerfil = new javax.swing.JButton();
        jLabelEstado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú del cliente");

        jButtonArriendo.setText("Arriendos");
        jButtonArriendo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonArriendoMouseClicked(evt);
            }
        });

        jButtonChat.setText("Chat");

        jButtonPerfil.setText("Perfil");
        jButtonPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonPerfilMouseClicked(evt);
            }
        });
        jButtonPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPerfilActionPerformed(evt);
            }
        });

        jLabelEstado.setText("Estado del servidor");

        javax.swing.GroupLayout jPanelEstadoLayout = new javax.swing.GroupLayout(jPanelEstado);
        jPanelEstado.setLayout(jPanelEstadoLayout);
        jPanelEstadoLayout.setHorizontalGroup(
            jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEstadoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonPerfil)
                .addGap(94, 94, 94))
            .addGroup(jPanelEstadoLayout.createSequentialGroup()
                .addGroup(jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEstadoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanelEstadoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabelEstado))
                    .addGroup(jPanelEstadoLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jButtonArriendo))
                    .addGroup(jPanelEstadoLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jButtonChat)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanelEstadoLayout.setVerticalGroup(
            jPanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jButtonPerfil)
                .addGap(18, 18, 18)
                .addComponent(jButtonArriendo)
                .addGap(18, 18, 18)
                .addComponent(jButtonChat)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabelEstado)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButtonPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonPerfilActionPerformed

    private void jButtonPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonPerfilMouseClicked
        VistaPerfilCliente vista2 = new VistaPerfilCliente(this.idCliente, conexion);
        vista2.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonPerfilMouseClicked

    private void jButtonArriendoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonArriendoMouseClicked

            VistaArriendoCliente vista2 = new VistaArriendoCliente(this.idCliente, conexion);
            vista2.setVisible(true);
            dispose();
    }//GEN-LAST:event_jButtonArriendoMouseClicked

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
            java.util.logging.Logger.getLogger(VistaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenuCliente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArriendo;
    private javax.swing.JButton jButtonChat;
    private javax.swing.JButton jButtonPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JPanel jPanelEstado;
    // End of variables declaration//GEN-END:variables
}
