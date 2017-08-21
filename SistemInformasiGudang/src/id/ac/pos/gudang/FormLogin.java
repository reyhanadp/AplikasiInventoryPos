/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang;

import id.ac.pos.gudang.utility.koneksi;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Oyoy
 */
public class FormLogin extends javax.swing.JFrame {

    /**
     * Creates new form FormLogin
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;

    public FormLogin() {
        initComponents();
        //pemanggilan fungsi koneksi database yang sudah kita buat pada class koneksi.java
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        labelUsername = new javax.swing.JLabel();
        fieldPassword = new javax.swing.JPasswordField();
        fieldUsername = new javax.swing.JTextField();
        labelPassword = new javax.swing.JLabel();
        buttonReset = new javax.swing.JButton();
        buttonLogin1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextField3.setText("jTextField3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsername.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelUsername.setText("Username ");
        getContentPane().add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, 70, 30));

        fieldPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldPasswordKeyPressed(evt);
            }
        });
        getContentPane().add(fieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 160, 30));

        fieldUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldUsernameKeyPressed(evt);
            }
        });
        getContentPane().add(fieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, 160, 30));

        labelPassword.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelPassword.setText("Password");
        getContentPane().add(labelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 70, 30));

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });
        getContentPane().add(buttonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 177, 80, -1));

        buttonLogin1.setText("Login");
        buttonLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(buttonLogin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 177, 80, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_buttonResetActionPerformed

    private void buttonLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLogin1ActionPerformed
        // TODO add your handling code here:
        try {
            sql = "SELECT * FROM tb_user WHERE username='" + fieldUsername.getText() 
                    + "' AND password='" + fieldPassword.getText()+"'";
            rs = stat.executeQuery(sql);
            if (rs.next()) {
                if (fieldPassword.getText().equals(rs.getString("password")) 
                        && fieldUsername.getText().equals(rs.getString("username"))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses !");
                    FormHome fh = new FormHome();
                    fh.setVisible(true);
                    this.setVisible(false); //form login akan tertutup
                }
            } else {
                JOptionPane.showMessageDialog(null, "Login Gagal", "", 1);
                JOptionPane.showMessageDialog(null, "Username dan Password Invalid", "", 1);
                fieldUsername.setText(null);//set nilai txtUser menjadi kosong
                fieldPassword.setText(null);//set nilai txtPass menjadi kosong
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_buttonLogin1ActionPerformed

    private void fieldUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldPassword.requestFocus();
        }
    }//GEN-LAST:event_fieldUsernameKeyPressed

    private void fieldPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldPasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonLogin1.requestFocus();
            fieldUsername.setText(null);//set nilai txtUser menjadi kosong
            fieldPassword.setText(null);//set nilai txtPass menjadi kosongFF
        }
    }//GEN-LAST:event_fieldPasswordKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try
            {
                com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme("Large-Font", "Java Swing", "");
                UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
                FormLogin fl = new FormLogin();
                fl.setLocationRelativeTo(null);
                fl.setVisible(true);
                fl.dispose();
            } 
          catch (Exception ex) 
            {
                ex.printStackTrace();
            }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormLogin fl = new FormLogin();
                fl.setLocationRelativeTo(null);
                fl.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton buttonLogin1;
    private javax.swing.JButton buttonReset;
    private javax.swing.JPasswordField fieldPassword;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables

}
