/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.dao.RegionalDAO;
import id.ac.pos.gudang.daoimpl.RegionalDAOImpl;
import id.ac.pos.gudang.entity.Regional;
import java.awt.Dialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Oyoy
 */
public class DialogUbahRegional extends javax.swing.JDialog {

    /**
     * Creates new form DialogTambahRegional
     */
    public DialogUbahRegional(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    private String idRegional;
    
    DialogUbahRegional(java.awt.Dialog parent, boolean modal, Regional regional) {
        initComponents();
        idRegional = regional.getIdRegional();
        fieldIdRegional.setText(regional.getIdRegional());
        fieldNamaRegional.setText(regional.getNamaRegional());
        fieldKodePos.setText(regional.getKodePos());
        fieldNoTelp.setText(regional.getNoTelp());
        fieldAlamat.setText(regional.getAlamat());
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
        fieldIdRegional = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldNamaRegional = new javax.swing.JTextField();
        buttonUbah = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldKodePos = new javax.swing.JTextField();
        fieldNoTelp = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Id Regional");

        fieldIdRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldIdRegionalActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Regional");

        fieldNamaRegional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaRegionalActionPerformed(evt);
            }
        });

        buttonUbah.setText("Ubah");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode Pos");

        fieldKodePos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodePosActionPerformed(evt);
            }
        });

        fieldNoTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoTelpActionPerformed(evt);
            }
        });

        jLabel4.setText("No. Telepon");

        fieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldAlamatActionPerformed(evt);
            }
        });

        jLabel5.setText("Alamat");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 123, Short.MAX_VALUE)
                        .addComponent(buttonUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(fieldNoTelp)
                            .addComponent(fieldKodePos, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldIdRegional, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldNamaRegional, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldIdRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNamaRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldKodePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUbah)
                    .addComponent(buttonCancel))
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldIdRegionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldIdRegionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdRegionalActionPerformed

    private void fieldNamaRegionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaRegionalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaRegionalActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
        Regional regional = new Regional();
        String idRegional = fieldIdRegional.getText();
        String namaRegional = fieldNamaRegional.getText();
        String kodePos = fieldKodePos.getText();
        String noTelp = fieldNoTelp.getText();
        String alamat = fieldAlamat.getText();

        //validasi
        //validasi field
        if (fieldIdRegional.getText().isEmpty() && fieldIdRegional.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Id Regional tidak boleh Kosong");
        } else if (fieldNamaRegional.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama Regional Tidak boleh Kosong");
        } else if (fieldKodePos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Pos Tidak boleh Kosong");
        } else if (fieldNoTelp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nomor Telepon Tidak boleh Kosong");
        } else if (fieldAlamat.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Alamat Tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        regional.setIdRegional(idRegional);
        regional.setNamaRegional(namaRegional);
        regional.setKodePos(kodePos);
        regional.setNoTelp(noTelp);
        regional.setAlamat(alamat);

        //insert regional 
        RegionalDAO dao = new RegionalDAOImpl();
        boolean sukses = dao.ubahRegional(regional);

        //cek sukses atau tidak 
        // cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil diubah");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal diubah");
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void fieldKodePosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodePosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodePosActionPerformed

    private void fieldNoTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoTelpActionPerformed

    private void fieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldAlamatActionPerformed

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
            java.util.logging.Logger.getLogger(DialogUbahRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogUbahRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogUbahRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogUbahRegional.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogUbahRegional dialog = new DialogUbahRegional(new javax.swing.JDialog(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JTextField fieldAlamat;
    private javax.swing.JTextField fieldIdRegional;
    private javax.swing.JTextField fieldKodePos;
    private javax.swing.JTextField fieldNamaRegional;
    private javax.swing.JTextField fieldNoTelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
