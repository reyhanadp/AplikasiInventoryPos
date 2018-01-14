/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPengiriman;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengirimanDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengirimanDAOImpl;
import id.ac.pos.gudang.entity.Pengiriman;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengirimanTM;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author reyha
 */
public final class PanelPengiriman extends javax.swing.JPanel {

    PengirimanDAO dao;
    ProdukDAO daoProduk;
    Pengiriman pengiriman;
    Regional regional;
    ArrayList<Regional> arrayRegional;
    ArrayList<Produk> arrayProduk;
    TableRowSorter sorter;

    /**
     * Creates new form PanelPengiriman
     */
    public PanelPengiriman() {
        initComponents();
        getDataPengirimanPrangko();
        
        
        tabelPengirimanMSSS.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
        tabelPengirimanDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
        tabelPengirimanKemasan.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
        tabelPengirimanMerchandise.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
        tabelPengirimanPrisma.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
        tabelPengirimanSHPSS.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengiriman", "No Order", "Tanggal", "Jumlah Pengiriman", "BSU", "Kode Regional","Kode Produk", "Nama Produk", "Stok Awal","Stok Akhir"
                }));
    }

    public void getDataPengirimanPrangko() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "PR";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanPrangko.setRowSorter(sorter);
        tabelPengirimanPrangko.setModel(pengirimanTM);
    }

    public void getDataPengirimanMSSS() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "MS";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanMSSS.setRowSorter(sorter);
        tabelPengirimanMSSS.setModel(pengirimanTM);
    }

    public void getDataPengirimanSHPSS() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "SHP";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanSHPSS.setRowSorter(sorter);
        tabelPengirimanSHPSS.setModel(pengirimanTM);
    }

    public void getDataPengirimanKemasan() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "KM";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanKemasan.setRowSorter(sorter);
        tabelPengirimanKemasan.setModel(pengirimanTM);
    }

    public void getDataPengirimanMerchandise() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "MC";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanMerchandise.setRowSorter(sorter);
        tabelPengirimanMerchandise.setModel(pengirimanTM);
    }

    public void getDataPengirimanPrisma() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "PS";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanPrisma.setRowSorter(sorter);
        tabelPengirimanPrisma.setModel(pengirimanTM);
    }

    public void getDataPengirimanDokumenFilateli() {
        dao = new PengirimanDAOImpl();
        String jenis_produk = "DF";
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanDokumenFilateli.setRowSorter(sorter);
        tabelPengirimanDokumenFilateli.setModel(pengirimanTM);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabbedPanePengiriman = new javax.swing.JTabbedPane();
        Prangko3 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabelPengirimanPrangko = new javax.swing.JTable();
        buttonCariPrangko15 = new javax.swing.JButton();
        fieldCariPrangko15 = new javax.swing.JTextField();
        comboCariPrangko15 = new javax.swing.JComboBox<>();
        TambahPrangko = new javax.swing.JButton();
        MS_SS3 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jScrollPane42 = new javax.swing.JScrollPane();
        tabelPengirimanMSSS = new javax.swing.JTable();
        buttonCariPrangko16 = new javax.swing.JButton();
        fieldCariPrangko16 = new javax.swing.JTextField();
        comboCariPrangko16 = new javax.swing.JComboBox<>();
        TambahMSSS = new javax.swing.JButton();
        SHP_SHPSS3 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jScrollPane44 = new javax.swing.JScrollPane();
        tabelPengirimanSHPSS = new javax.swing.JTable();
        buttonCariPrangko17 = new javax.swing.JButton();
        fieldCariPrangko17 = new javax.swing.JTextField();
        comboCariPrangko17 = new javax.swing.JComboBox<>();
        TambahSHPSS = new javax.swing.JButton();
        Kemasan3 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jScrollPane46 = new javax.swing.JScrollPane();
        tabelPengirimanKemasan = new javax.swing.JTable();
        buttonCariPrangko18 = new javax.swing.JButton();
        fieldCariPrangko18 = new javax.swing.JTextField();
        comboCariPrangko18 = new javax.swing.JComboBox<>();
        TambahKemasan = new javax.swing.JButton();
        Merchandise3 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jScrollPane48 = new javax.swing.JScrollPane();
        tabelPengirimanMerchandise = new javax.swing.JTable();
        buttonCariPrangko19 = new javax.swing.JButton();
        fieldCariPrangko19 = new javax.swing.JTextField();
        comboCariPrangko19 = new javax.swing.JComboBox<>();
        TambahMerchandise = new javax.swing.JButton();
        Prisma3 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jScrollPane50 = new javax.swing.JScrollPane();
        tabelPengirimanPrisma = new javax.swing.JTable();
        buttonCariPrangko20 = new javax.swing.JButton();
        fieldCariPrangko20 = new javax.swing.JTextField();
        comboCariPrangko20 = new javax.swing.JComboBox<>();
        TambahPrisma = new javax.swing.JButton();
        DokumenFilateli3 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jScrollPane52 = new javax.swing.JScrollPane();
        tabelPengirimanDokumenFilateli = new javax.swing.JTable();
        buttonCariPrangko21 = new javax.swing.JButton();
        fieldCariPrangko21 = new javax.swing.JTextField();
        comboCariPrangko21 = new javax.swing.JComboBox<>();
        TambahDokumenFilateli = new javax.swing.JButton();

        TabbedPanePengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabbedPanePengirimanMouseClicked(evt);
            }
        });

        Prangko3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prangko3MouseClicked(evt);
            }
        });

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanPrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanPrangkoMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tabelPengirimanPrangko);

        buttonCariPrangko15.setText("Cari");
        buttonCariPrangko15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko15ActionPerformed(evt);
            }
        });

        fieldCariPrangko15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko15MouseClicked(evt);
            }
        });

        comboCariPrangko15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahPrangko.setText("Tambah Pengiriman");
        TambahPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(TambahPrangko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 665, Short.MAX_VALUE)
                .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko15))
            .addComponent(jScrollPane13)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko15)
                    .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prangko3Layout = new javax.swing.GroupLayout(Prangko3);
        Prangko3.setLayout(Prangko3Layout);
        Prangko3Layout.setHorizontalGroup(
            Prangko3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prangko3Layout.setVerticalGroup(
            Prangko3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("Prangko", Prangko3);

        MS_SS3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS3MouseClicked(evt);
            }
        });

        jPanel74.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanMSSS.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanMSSSMouseClicked(evt);
            }
        });
        jScrollPane42.setViewportView(tabelPengirimanMSSS);

        buttonCariPrangko16.setText("Cari");
        buttonCariPrangko16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko16ActionPerformed(evt);
            }
        });

        fieldCariPrangko16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko16MouseClicked(evt);
            }
        });

        comboCariPrangko16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahMSSS.setText("Tambah Pengiriman");
        TambahMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahMSSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addComponent(TambahMSSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko16))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko16)
                    .addComponent(fieldCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SS3Layout = new javax.swing.GroupLayout(MS_SS3);
        MS_SS3.setLayout(MS_SS3Layout);
        MS_SS3Layout.setHorizontalGroup(
            MS_SS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MS_SS3Layout.setVerticalGroup(
            MS_SS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel74, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("MS & SS", MS_SS3);

        SHP_SHPSS3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS3MouseClicked(evt);
            }
        });

        jPanel76.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanSHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanSHPSSMouseClicked(evt);
            }
        });
        jScrollPane44.setViewportView(tabelPengirimanSHPSS);

        buttonCariPrangko17.setText("Cari");
        buttonCariPrangko17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko17ActionPerformed(evt);
            }
        });

        fieldCariPrangko17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko17MouseClicked(evt);
            }
        });

        comboCariPrangko17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahSHPSS.setText("Tambah Pengiriman");
        TambahSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahSHPSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane44, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addComponent(TambahSHPSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko17))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko17)
                    .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane44, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSS3Layout = new javax.swing.GroupLayout(SHP_SHPSS3);
        SHP_SHPSS3.setLayout(SHP_SHPSS3Layout);
        SHP_SHPSS3Layout.setHorizontalGroup(
            SHP_SHPSS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SHP_SHPSS3Layout.setVerticalGroup(
            SHP_SHPSS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("SHP & SHPSS", SHP_SHPSS3);

        Kemasan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kemasan3MouseClicked(evt);
            }
        });

        jPanel78.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanKemasanMouseClicked(evt);
            }
        });
        jScrollPane46.setViewportView(tabelPengirimanKemasan);

        buttonCariPrangko18.setText("Cari");
        buttonCariPrangko18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko18ActionPerformed(evt);
            }
        });

        fieldCariPrangko18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko18MouseClicked(evt);
            }
        });

        comboCariPrangko18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahKemasan.setText("Tambah Pengiriman");
        TambahKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addComponent(TambahKemasan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko18))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko18)
                    .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Kemasan3Layout = new javax.swing.GroupLayout(Kemasan3);
        Kemasan3.setLayout(Kemasan3Layout);
        Kemasan3Layout.setHorizontalGroup(
            Kemasan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Kemasan3Layout.setVerticalGroup(
            Kemasan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel78, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("Kemasan", Kemasan3);

        jPanel80.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane48.setViewportView(tabelPengirimanMerchandise);

        buttonCariPrangko19.setText("Cari");
        buttonCariPrangko19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko19ActionPerformed(evt);
            }
        });

        fieldCariPrangko19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko19MouseClicked(evt);
            }
        });

        comboCariPrangko19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahMerchandise.setText("Tambah Pengiriman");
        TambahMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addComponent(TambahMerchandise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko19))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko19)
                    .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Merchandise3Layout = new javax.swing.GroupLayout(Merchandise3);
        Merchandise3.setLayout(Merchandise3Layout);
        Merchandise3Layout.setHorizontalGroup(
            Merchandise3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Merchandise3Layout.setVerticalGroup(
            Merchandise3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel80, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("Merchandise", Merchandise3);

        jPanel82.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanPrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanPrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanPrismaMouseClicked(evt);
            }
        });
        jScrollPane50.setViewportView(tabelPengirimanPrisma);

        buttonCariPrangko20.setText("Cari");
        buttonCariPrangko20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko20ActionPerformed(evt);
            }
        });

        fieldCariPrangko20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko20MouseClicked(evt);
            }
        });

        comboCariPrangko20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahPrisma.setText("Tambah Pengiriman");
        TambahPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPrismaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addComponent(TambahPrisma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko20))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko20)
                    .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prisma3Layout = new javax.swing.GroupLayout(Prisma3);
        Prisma3.setLayout(Prisma3Layout);
        Prisma3Layout.setHorizontalGroup(
            Prisma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prisma3Layout.setVerticalGroup(
            Prisma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel82, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("Prisma", Prisma3);

        jPanel84.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengiriman"));

        tabelPengirimanDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPengirimanDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPengirimanDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane52.setViewportView(tabelPengirimanDokumenFilateli);

        buttonCariPrangko21.setText("Cari");
        buttonCariPrangko21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko21ActionPerformed(evt);
            }
        });

        fieldCariPrangko21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko21MouseClicked(evt);
            }
        });

        comboCariPrangko21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahDokumenFilateli.setText("Tambah Pengiriman");
        TambahDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahDokumenFilateliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane52, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addComponent(TambahDokumenFilateli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko21, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko21))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko21)
                    .addComponent(fieldCariPrangko21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane52, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateli3Layout = new javax.swing.GroupLayout(DokumenFilateli3);
        DokumenFilateli3.setLayout(DokumenFilateli3Layout);
        DokumenFilateli3Layout.setHorizontalGroup(
            DokumenFilateli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DokumenFilateli3Layout.setVerticalGroup(
            DokumenFilateli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel84, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabbedPanePengiriman.addTab("Dokumen Filateli", DokumenFilateli3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanePengiriman)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPanePengiriman)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TabbedPanePengirimanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabbedPanePengirimanMouseClicked
        // TODO add your handling code here:
        if (TabbedPanePengiriman.getSelectedIndex() == 0) {
            getDataPengirimanPrangko();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 1) {
            getDataPengirimanMSSS();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 2) {
            getDataPengirimanSHPSS();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 3) {
            getDataPengirimanKemasan();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 4) {
            getDataPengirimanMerchandise();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 5) {
            getDataPengirimanPrisma();
        } else if (TabbedPanePengiriman.getSelectedIndex() == 6) {
            getDataPengirimanDokumenFilateli();
        }
    }//GEN-LAST:event_TabbedPanePengirimanMouseClicked

    private void fieldCariPrangko21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko21MouseClicked

    private void buttonCariPrangko21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko21ActionPerformed

    private void tabelPengirimanDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanDokumenFilateliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanDokumenFilateliMouseClicked

    private void fieldCariPrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko20MouseClicked

    private void buttonCariPrangko20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko20ActionPerformed

    private void tabelPengirimanPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanPrismaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanPrismaMouseClicked

    private void fieldCariPrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko19MouseClicked

    private void buttonCariPrangko19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko19ActionPerformed

    private void tabelPengirimanMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanMerchandiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanMerchandiseMouseClicked

    private void Kemasan3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kemasan3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Kemasan3MouseClicked

    private void fieldCariPrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko18MouseClicked

    private void buttonCariPrangko18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko18ActionPerformed

    private void tabelPengirimanKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanKemasanMouseClicked

    private void SHP_SHPSS3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSS3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSS3MouseClicked

    private void fieldCariPrangko17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko17MouseClicked

    private void buttonCariPrangko17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko17ActionPerformed

    private void tabelPengirimanSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanSHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanSHPSSMouseClicked

    private void MS_SS3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SS3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SS3MouseClicked

    private void fieldCariPrangko16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko16MouseClicked

    private void buttonCariPrangko16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko16ActionPerformed

    private void tabelPengirimanMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanMSSSMouseClicked

    private void Prangko3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prangko3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Prangko3MouseClicked

    private void fieldCariPrangko15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko15MouseClicked

    private void buttonCariPrangko15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko15ActionPerformed

    private void tabelPengirimanPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPengirimanPrangkoMouseClicked

    private void TambahPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPrangkoActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);

        getDataPengirimanPrangko();

    }//GEN-LAST:event_TambahPrangkoActionPerformed

    private void TambahMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahMSSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanMSSS();

    }//GEN-LAST:event_TambahMSSSActionPerformed

    private void TambahSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahSHPSSActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanSHPSS();
    }//GEN-LAST:event_TambahSHPSSActionPerformed

    private void TambahKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahKemasanActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanKemasan();
    }//GEN-LAST:event_TambahKemasanActionPerformed

    private void TambahMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahMerchandiseActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanMerchandise();
    }//GEN-LAST:event_TambahMerchandiseActionPerformed

    private void TambahPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPrismaActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanPrisma();
    }//GEN-LAST:event_TambahPrismaActionPerformed

    private void TambahDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahDokumenFilateliActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        getDataPengirimanDokumenFilateli();
    }//GEN-LAST:event_TambahDokumenFilateliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DokumenFilateli3;
    private javax.swing.JPanel Kemasan3;
    private javax.swing.JPanel MS_SS3;
    private javax.swing.JPanel Merchandise3;
    private javax.swing.JPanel Prangko3;
    private javax.swing.JPanel Prisma3;
    private javax.swing.JPanel SHP_SHPSS3;
    private javax.swing.JTabbedPane TabbedPanePengiriman;
    private javax.swing.JButton TambahDokumenFilateli;
    private javax.swing.JButton TambahKemasan;
    private javax.swing.JButton TambahMSSS;
    private javax.swing.JButton TambahMerchandise;
    private javax.swing.JButton TambahPrangko;
    private javax.swing.JButton TambahPrisma;
    private javax.swing.JButton TambahSHPSS;
    private javax.swing.JButton buttonCariPrangko15;
    private javax.swing.JButton buttonCariPrangko16;
    private javax.swing.JButton buttonCariPrangko17;
    private javax.swing.JButton buttonCariPrangko18;
    private javax.swing.JButton buttonCariPrangko19;
    private javax.swing.JButton buttonCariPrangko20;
    private javax.swing.JButton buttonCariPrangko21;
    private javax.swing.JComboBox<String> comboCariPrangko15;
    private javax.swing.JComboBox<String> comboCariPrangko16;
    private javax.swing.JComboBox<String> comboCariPrangko17;
    private javax.swing.JComboBox<String> comboCariPrangko18;
    private javax.swing.JComboBox<String> comboCariPrangko19;
    private javax.swing.JComboBox<String> comboCariPrangko20;
    private javax.swing.JComboBox<String> comboCariPrangko21;
    private javax.swing.JTextField fieldCariPrangko15;
    private javax.swing.JTextField fieldCariPrangko16;
    private javax.swing.JTextField fieldCariPrangko17;
    private javax.swing.JTextField fieldCariPrangko18;
    private javax.swing.JTextField fieldCariPrangko19;
    private javax.swing.JTextField fieldCariPrangko20;
    private javax.swing.JTextField fieldCariPrangko21;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JTable tabelPengirimanDokumenFilateli;
    private javax.swing.JTable tabelPengirimanKemasan;
    private javax.swing.JTable tabelPengirimanMSSS;
    private javax.swing.JTable tabelPengirimanMerchandise;
    private javax.swing.JTable tabelPengirimanPrangko;
    private javax.swing.JTable tabelPengirimanPrisma;
    private javax.swing.JTable tabelPengirimanSHPSS;
    // End of variables declaration//GEN-END:variables
}
