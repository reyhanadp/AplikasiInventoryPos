/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Form;

/**
 *
 * @author reyha
 */
public class FormAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FormAdmin
     */
    public FormAdmin() {
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

        jLabel1 = new javax.swing.JLabel();
        buttonKelolaProduk = new javax.swing.JButton();
        buttonKelolaProduk1 = new javax.swing.JButton();
        buttonKelolaProduk2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemRegional = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemRecycleBin = new javax.swing.JMenuItem();
        itemHistoryUpdate = new javax.swing.JMenuItem();
        itemHistoryDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-kecil.png"))); // NOI18N

        buttonKelolaProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/kelola_produk1.png"))); // NOI18N
        buttonKelolaProduk.setText("KELOLA PRODUK");
        buttonKelolaProduk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonKelolaProduk.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelolaProdukActionPerformed(evt);
            }
        });

        buttonKelolaProduk1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/kelola_produk1.png"))); // NOI18N
        buttonKelolaProduk1.setText("KELOLA PRODUK");
        buttonKelolaProduk1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonKelolaProduk1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelolaProduk1ActionPerformed(evt);
            }
        });

        buttonKelolaProduk2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/kelola_produk1.png"))); // NOI18N
        buttonKelolaProduk2.setText("KELOLA PRODUK");
        buttonKelolaProduk2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonKelolaProduk2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelolaProduk2ActionPerformed(evt);
            }
        });

        itemRegional.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Regional");
        itemRegional.add(jMenuItem1);

        jMenuBar1.add(itemRegional);

        jMenu2.setText("Help");

        itemRecycleBin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        itemRecycleBin.setText("Recycle Bin");
        itemRecycleBin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRecycleBinActionPerformed(evt);
            }
        });
        jMenu2.add(itemRecycleBin);

        itemHistoryUpdate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        itemHistoryUpdate.setText("History Update");
        itemHistoryUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistoryUpdateActionPerformed(evt);
            }
        });
        jMenu2.add(itemHistoryUpdate);

        itemHistoryDelete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        itemHistoryDelete.setText("History Delete");
        itemHistoryDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemHistoryDeleteActionPerformed(evt);
            }
        });
        jMenu2.add(itemHistoryDelete);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(buttonKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(buttonKelolaProduk1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonKelolaProduk2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonKelolaProduk2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(buttonKelolaProduk1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addComponent(buttonKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemRecycleBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRecycleBinActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itemRecycleBinActionPerformed

    private void itemHistoryUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoryUpdateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itemHistoryUpdateActionPerformed

    private void itemHistoryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoryDeleteActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_itemHistoryDeleteActionPerformed

    private void buttonKelolaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKelolaProdukActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_buttonKelolaProdukActionPerformed

    private void buttonKelolaProduk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKelolaProduk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKelolaProduk1ActionPerformed

    private void buttonKelolaProduk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKelolaProduk2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonKelolaProduk2ActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonKelolaProduk;
    private javax.swing.JButton buttonKelolaProduk1;
    private javax.swing.JButton buttonKelolaProduk2;
    private javax.swing.JMenuItem itemHistoryDelete;
    private javax.swing.JMenuItem itemHistoryUpdate;
    private javax.swing.JMenuItem itemRecycleBin;
    private javax.swing.JMenu itemRegional;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
