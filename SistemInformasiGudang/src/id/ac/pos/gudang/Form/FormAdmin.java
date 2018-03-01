/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Form;

import id.ac.pos.gudang.Dialog.Admin.MItra.DialogMitra;
import id.ac.pos.gudang.Dialog.Admin.Regional.DialogRegional;
import id.ac.pos.gudang.Dialog.Admin.User.DialogUser;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author reyha
 */
public class FormAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FormAdmin
     */
    public FormAdmin() throws IOException {
        initComponents();
        Image i = ImageIO.read(getClass().getResource("/img/pos_indonesia.png"));
        setIconImage(i);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        buttonMitra = new javax.swing.JLabel();
        buttonUser = new javax.swing.JLabel();
        buttonReional = new javax.swing.JLabel();
        buttonLogout = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("ADMIN DASHBOARD");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        buttonMitra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonMitra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icon-mitra-1.png"))); // NOI18N
        buttonMitra.setText("MITRA");
        buttonMitra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonMitra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonMitra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonMitraMouseClicked(evt);
            }
        });

        buttonUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icon-user-1.png"))); // NOI18N
        buttonUser.setText("USER");
        buttonUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUserMouseClicked(evt);
            }
        });

        buttonReional.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        buttonReional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icon-regional-1.png"))); // NOI18N
        buttonReional.setText("REGIONAL");
        buttonReional.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonReional.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonReional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonReionalMouseClicked(evt);
            }
        });

        buttonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/icon-logout-1.png"))); // NOI18N
        buttonLogout.setText("Logout");
        buttonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonUser)
                .addGap(92, 92, 92)
                .addComponent(buttonMitra)
                .addGap(97, 97, 97)
                .addComponent(buttonReional)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1))
                .addGap(183, 183, 183)
                .addComponent(buttonLogout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonLogout))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonMitra)
                    .addComponent(buttonUser)
                    .addComponent(buttonReional))
                .addGap(50, 50, 50))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonReionalMouseClicked
        // TODO add your handling code here:
        DialogRegional dr = new DialogRegional(null, rootPaneCheckingEnabled);
        dr.setLocationRelativeTo(null);
        dr.setVisible(true);
    }//GEN-LAST:event_buttonReionalMouseClicked

    private void buttonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogoutActionPerformed
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Logout ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            FormLogin fl = null;
            try {
                fl = new FormLogin();
            } catch (IOException ex) {
                Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            fl.setLocationRelativeTo(null);
            fl.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_buttonLogoutActionPerformed

    private void buttonMitraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonMitraMouseClicked
        // TODO add your handling code here:
        DialogMitra dm = new DialogMitra(null, rootPaneCheckingEnabled);
        dm.setLocationRelativeTo(null);
        dm.setVisible(true);

    }//GEN-LAST:event_buttonMitraMouseClicked

    private void buttonUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUserMouseClicked
        // TODO add your handling code here:
        DialogUser du = new DialogUser(FormAdmin.this, true);
        du.setLocationRelativeTo(null);
        du.setVisible(true);
    }//GEN-LAST:event_buttonUserMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Logout ?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            
            try {
                String path = new File(".").getCanonicalPath();
                FileReader fr = new FileReader(path + "\\alamat_ip.txt");
                BufferedReader br = new BufferedReader(fr);
                String alamat_ip = br.readLine();

                if (alamat_ip.compareTo("localhost") == 0) {

                    Process runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysqldump -u root db_inventory_pos -r " + path + "\\db_inventory_pos.sql");

                    FormLogin fl = new FormLogin();
                    fl.setLocationRelativeTo(null);
                    fl.setVisible(true);
                    this.setVisible(false);
                } else {
                    FormLoginClient fl = new FormLoginClient();

                    fl.setLocationRelativeTo(null);
                    fl.setVisible(true);
                    this.setVisible(false);
                }
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme("Large-Font", "Java Swing", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
            new FormAdmin();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormAdmin().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonLogout;
    private javax.swing.JLabel buttonMitra;
    private javax.swing.JLabel buttonReional;
    private javax.swing.JLabel buttonUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
