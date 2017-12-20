/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog.Admin;

import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.tablemodel.RecycleBinTM;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author Oyoy
 */
public class DialogRecycleBin extends javax.swing.JDialog {

    private Produk produk;
    private ProdukDAO dao;
    private ArrayList<Produk> arrayProduk;

    /**
     * Creates new form DialogRecycleBin
     */
    public DialogRecycleBin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        refresh();
    }

    public void restore(int baris, String idJenisProduk, JTable jenisTabel) {
        String kodeProduk = jenisTabel.getValueAt(baris, 0).toString();
        String namaProduk = jenisTabel.getValueAt(baris, 1).toString();
        String nominal = jenisTabel.getValueAt(baris, 2).toString();
        String biayaCetak = jenisTabel.getValueAt(baris, 3).toString();
        String stok = jenisTabel.getValueAt(baris, 4).toString();
        String tahun = jenisTabel.getValueAt(baris, 5).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                + "mengembalikan Produk dengan kode : " + kodeProduk
                + " dengan Nama Produk " + namaProduk
                + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            Produk produk = new Produk();
            produk.setIdProduk(kodeProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setStok(Integer.parseInt(stok));
            produk.setTahun(tahun);
            produk.setIdJenisProduk(idJenisProduk);

            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.restoreProduk(produk, idJenisProduk);

            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil direstore");
                dao.hapusPermanent(kodeProduk);
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal direstore");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan direstore !");
        }
        refresh();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRecycleBinPrangko = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRecycleBinMSSS = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRecycleBinSHPSHPSS = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableRecycleBinKemasan = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableRecycleBinMerchandise = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableRecycleBinPrisma = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableRecycleBinDokumenFilateli = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        buttonRestore = new javax.swing.JButton();
        buttonRefresh = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        tableRecycleBinPrangko.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinPrangko.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableRecycleBinPrangko);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Prangko", jPanel7);

        tableRecycleBinMSSS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinMSSS.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableRecycleBinMSSS);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("MSS & SS", jPanel8);

        tableRecycleBinSHPSHPSS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinSHPSHPSS.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableRecycleBinSHPSHPSS);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("SHP & SHPSS", jPanel3);

        tableRecycleBinKemasan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinKemasan.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableRecycleBinKemasan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Kemasan", jPanel4);

        tableRecycleBinMerchandise.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinMerchandise.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(tableRecycleBinMerchandise);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Merchandise", jPanel9);

        tableRecycleBinPrisma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinPrisma.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tableRecycleBinPrisma);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Prisma", jPanel10);

        tableRecycleBinDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableRecycleBinDokumenFilateli.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tableRecycleBinDokumenFilateli);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 771, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Dokumen Filateli", jPanel11);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(384, 384, 384))
        );

        buttonRestore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/restore.png"))); // NOI18N
        buttonRestore.setText("Restore");
        buttonRestore.setMargin(new java.awt.Insets(5, 8, 5, 14));
        buttonRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRestoreActionPerformed(evt);
            }
        });

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.setIconTextGap(5);
        buttonRefresh.setMargin(new java.awt.Insets(4, 0, 4, 14));
        buttonRefresh.setPreferredSize(new java.awt.Dimension(92, 34));
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRestore, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECYCLE BIN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(336, 336, 336))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refresh() {
        getDataPrangkoDeleted();
        getDataMSSSDeleted();
        getDataSHPSHPSSDeleted();
        getDataKemasanDeleted();
        getDataMerchandiseDeleted();
        getDataPrismaDeleted();
        getDataDokumenFilateliDeleted();
    }

    private void buttonRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRestoreActionPerformed
        // TODO add your handling code here:

        int baris1 = tableRecycleBinPrangko.getSelectedRow();
        if (baris1 >= 0) {
            String jenisProduk = "PR";
            JTable jenisTabel = tableRecycleBinPrangko;
            restore(baris1, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris2 = tableRecycleBinDokumenFilateli.getSelectedRow();
        if (baris2 >= 0) {
            String jenisProduk = "DF";
            JTable jenisTabel = tableRecycleBinDokumenFilateli;
            restore(baris2, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris3 = tableRecycleBinKemasan.getSelectedRow();
        if (baris3 >= 0) {
            String kodeProduk = tableRecycleBinKemasan.getValueAt(baris3, 0).toString();
            String namaProduk = tableRecycleBinKemasan.getValueAt(baris3, 1).toString();
            String jenisProduk = "KM";
            JTable jenisTabel = tableRecycleBinKemasan;
            restore(baris3, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris4 = tableRecycleBinMSSS.getSelectedRow();
        if (baris4 >= 0) {
            String jenisProduk = tableRecycleBinMSSS.getValueAt(baris4, 0).toString();
            jenisProduk = jenisProduk.substring(0, 2);
            JTable jenisTabel = tableRecycleBinMSSS;
            restore(baris4, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris5 = tableRecycleBinMerchandise.getSelectedRow();
        if (baris5 >= 0) {
            String jenisProduk = "MC";
            JTable jenisTabel = tableRecycleBinMerchandise;
            restore(baris5, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris6 = tableRecycleBinPrisma.getSelectedRow();
        if (baris6 >= 0) {
            String jenisProduk = "PS";
            JTable jenisTabel = tableRecycleBinPrisma;
            restore(baris6, jenisProduk, jenisTabel);
            refresh();
        }
        
        int baris7 = tableRecycleBinSHPSHPSS.getSelectedRow();
        if (baris7 >= 0) {
            String jenisProduk = tableRecycleBinSHPSHPSS.getValueAt(baris7, 0).toString();
            if ("SHPSS".equals(jenisProduk.substring(0, 5))) {
                jenisProduk = "SHPSS";

            } else if ("SHP".equals(jenisProduk.substring(0, 3))) {
                jenisProduk = "SHP";
            }
            JTable jenisTabel = tableRecycleBinSHPSHPSS;
            restore(baris7, jenisProduk, jenisTabel);
            refresh();
        }
    }//GEN-LAST:event_buttonRestoreActionPerformed


    private void buttonRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        int baris1 = tableRecycleBinPrangko.getSelectedRow();
        if (baris1 >= 0) {
            tableRecycleBinPrangko.removeRowSelectionInterval(baris1, baris1);
        }
        int baris2 = tableRecycleBinDokumenFilateli.getSelectedRow();
        if (baris2 >= 0) {
            tableRecycleBinDokumenFilateli.removeRowSelectionInterval(baris2, baris2);
        }
        int baris3 = tableRecycleBinKemasan.getSelectedRow();
        if (baris3 >= 0) {
            tableRecycleBinKemasan.removeRowSelectionInterval(baris3, baris3);
        }
        int baris4 = tableRecycleBinMSSS.getSelectedRow();
        if (baris4 >= 0) {
            tableRecycleBinMSSS.removeRowSelectionInterval(baris4, baris4);
        }
        int baris5 = tableRecycleBinMerchandise.getSelectedRow();
        if (baris5 >= 0) {
            tableRecycleBinMerchandise.removeRowSelectionInterval(baris5, baris5);
        }
        int baris6 = tableRecycleBinPrisma.getSelectedRow();
        if (baris6 >= 0) {
            tableRecycleBinPrisma.removeRowSelectionInterval(baris6, baris6);
        }
        int baris7 = tableRecycleBinSHPSHPSS.getSelectedRow();
        if (baris7 >= 0) {
            tableRecycleBinSHPSHPSS.removeRowSelectionInterval(baris7, baris7);
        }
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void getDataPrangkoDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrangkoDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinPrangko.setModel(recycleBinTableModel);
    }

    private void getDataMSSSDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMSSSDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinMSSS.setModel(recycleBinTableModel);
    }

    private void getDataSHPSHPSSDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukSHPSHPSSDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinSHPSHPSS.setModel(recycleBinTableModel);
    }

    private void getDataKemasanDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukKemasanDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinKemasan.setModel(recycleBinTableModel);
    }

    private void getDataMerchandiseDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMerchandiseDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinMerchandise.setModel(recycleBinTableModel);
    }

    private void getDataPrismaDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrismaDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinPrisma.setModel(recycleBinTableModel);
    }

    private void getDataDokumenFilateliDeleted() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukDokumenFilateliDeleted();

        RecycleBinTM recycleBinTableModel = new RecycleBinTM();
        recycleBinTableModel.setDataProduk(arrayProduk);

        tableRecycleBinDokumenFilateli.setModel(recycleBinTableModel);
    }

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
            java.util.logging.Logger.getLogger(DialogRecycleBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogRecycleBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogRecycleBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogRecycleBin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogRecycleBin dialog = new DialogRecycleBin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonRestore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableRecycleBinDokumenFilateli;
    private javax.swing.JTable tableRecycleBinKemasan;
    private javax.swing.JTable tableRecycleBinMSSS;
    private javax.swing.JTable tableRecycleBinMerchandise;
    private javax.swing.JTable tableRecycleBinPrangko;
    private javax.swing.JTable tableRecycleBinPrisma;
    private javax.swing.JTable tableRecycleBinSHPSHPSS;
    // End of variables declaration//GEN-END:variables
}
