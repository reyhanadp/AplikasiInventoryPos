/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPengembalian;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengembalianTM;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author reyha
 */
public final class PanelPengembalian extends javax.swing.JPanel {

    PengembalianDAO dao;
    ProdukDAO daoProduk;
    Pengembalian pengembalian;
    Regional regional;
    ArrayList<Regional> arrayRegional;
    ArrayList<Produk> arrayProduk;
    TableRowSorter sorter;

    /**
     * Creates new form PanelPengembalian
     */
    public PanelPengembalian() {
        initComponents();
        String jenis_produk = "PR";
        getDataPengembalian(jenis_produk);

        TablePengembalianDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));

        TablePengembalianKemasan.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));

        TablePengembalianMSSS.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));
        TablePengembalianMerchandise.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));

        TablePengembalianPrisma.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));

        TablePengembalianSHPSS.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "Id Pengembalian", "Tanggal", "Jumlah Pengembalian", "Nomor Dus", "Kode Regional", "Kode Produk", "Nama Produk", "Stok Awal", "Stok Akhir", "Keterangan"
                }));
    }

    public void getDataPengembalian(String jenis_produk) {
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        if (jenis_produk.compareTo("PR") == 0) {
            TablePengembalianPrangko.setRowSorter(sorter);
            TablePengembalianPrangko.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("MS") == 0){
            TablePengembalianMSSS.setRowSorter(sorter);
            TablePengembalianMSSS.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("SHP") == 0){
            TablePengembalianSHPSS.setRowSorter(sorter);
            TablePengembalianSHPSS.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("KM") == 0){
            TablePengembalianKemasan.setRowSorter(sorter);
            TablePengembalianKemasan.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("MC") == 0){
            TablePengembalianMerchandise.setRowSorter(sorter);
            TablePengembalianMerchandise.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("PS") == 0){
            TablePengembalianPrisma.setRowSorter(sorter);
            TablePengembalianPrisma.setModel(pengembalianTM);
        }else if (jenis_produk.compareTo("DF") == 0){
            TablePengembalianDokumenFilateli.setRowSorter(sorter);
            TablePengembalianDokumenFilateli.setModel(pengembalianTM);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPengembalian = new javax.swing.JTabbedPane();
        Prangko2 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablePengembalianPrangko = new javax.swing.JTable();
        CariPrangko = new javax.swing.JButton();
        FieldCariPrangko = new javax.swing.JTextField();
        ComboboxCariPrangko = new javax.swing.JComboBox<>();
        TambahPengembalianPrangko = new javax.swing.JButton();
        MS_SS2 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        TablePengembalianMSSS = new javax.swing.JTable();
        CariMSSS = new javax.swing.JButton();
        FieldCariMSSS = new javax.swing.JTextField();
        ComboboxCariMSSS = new javax.swing.JComboBox<>();
        TambahPengembalianMSSS = new javax.swing.JButton();
        SHP_SHPSS2 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        TablePengembalianSHPSS = new javax.swing.JTable();
        CariMSSS1 = new javax.swing.JButton();
        FieldCariMSSS1 = new javax.swing.JTextField();
        ComboboxCariMSSS1 = new javax.swing.JComboBox<>();
        TambahPengembalianSHPSS = new javax.swing.JButton();
        Kemasan2 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TablePengembalianKemasan = new javax.swing.JTable();
        buttonCariPrangko17 = new javax.swing.JButton();
        fieldCariPrangko17 = new javax.swing.JTextField();
        comboCariPrangko17 = new javax.swing.JComboBox<>();
        TambahPengembalianKemasan = new javax.swing.JButton();
        Merchandise2 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TablePengembalianMerchandise = new javax.swing.JTable();
        buttonCariPrangko18 = new javax.swing.JButton();
        fieldCariPrangko18 = new javax.swing.JTextField();
        comboCariPrangko18 = new javax.swing.JComboBox<>();
        TambahPengembalianMerchandise = new javax.swing.JButton();
        Prisma2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TablePengembalianPrisma = new javax.swing.JTable();
        buttonCariPrangko19 = new javax.swing.JButton();
        fieldCariPrangko19 = new javax.swing.JTextField();
        comboCariPrangko19 = new javax.swing.JComboBox<>();
        TambahPengembalianPrisma = new javax.swing.JButton();
        DokumenFilateli2 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TablePengembalianDokumenFilateli = new javax.swing.JTable();
        buttonCariPrangko20 = new javax.swing.JButton();
        fieldCariPrangko20 = new javax.swing.JTextField();
        comboCariPrangko20 = new javax.swing.JComboBox<>();
        TambahPengembalianDokumenFilateli = new javax.swing.JButton();

        TabPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPengembalianMouseClicked(evt);
            }
        });

        Prangko2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prangko2MouseClicked(evt);
            }
        });

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianPrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianPrangko.getTableHeader().setReorderingAllowed(false);
        TablePengembalianPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianPrangkoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(TablePengembalianPrangko);

        CariPrangko.setText("Cari");
        CariPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariPrangkoActionPerformed(evt);
            }
        });

        FieldCariPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariPrangkoMouseClicked(evt);
            }
        });

        ComboboxCariPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahPengembalianPrangko.setText("Tambah Pengembalian");
        TambahPengembalianPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(TambahPengembalianPrangko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariPrangko))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariPrangko)
                    .addComponent(FieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prangko2Layout = new javax.swing.GroupLayout(Prangko2);
        Prangko2.setLayout(Prangko2Layout);
        Prangko2Layout.setHorizontalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prangko2Layout.setVerticalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Prangko", Prangko2);

        MS_SS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS2MouseClicked(evt);
            }
        });

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianMSSS.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianMSSS.getTableHeader().setReorderingAllowed(false);
        TablePengembalianMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianMSSSMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(TablePengembalianMSSS);

        CariMSSS.setText("Cari");
        CariMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariMSSSActionPerformed(evt);
            }
        });

        FieldCariMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariMSSSMouseClicked(evt);
            }
        });

        ComboboxCariMSSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));
        ComboboxCariMSSS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxCariMSSSItemStateChanged(evt);
            }
        });

        TambahPengembalianMSSS.setText("Tambah Pengembalian");
        TambahPengembalianMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianMSSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(TambahPengembalianMSSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariMSSS))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariMSSS)
                    .addComponent(FieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SS2Layout = new javax.swing.GroupLayout(MS_SS2);
        MS_SS2.setLayout(MS_SS2Layout);
        MS_SS2Layout.setHorizontalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MS_SS2Layout.setVerticalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("MS & SS", MS_SS2);

        SHP_SHPSS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS2MouseClicked(evt);
            }
        });

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianSHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianSHPSS.getTableHeader().setReorderingAllowed(false);
        TablePengembalianSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianSHPSSMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(TablePengembalianSHPSS);

        CariMSSS1.setText("Cari");
        CariMSSS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariMSSS1ActionPerformed(evt);
            }
        });

        FieldCariMSSS1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariMSSS1MouseClicked(evt);
            }
        });

        ComboboxCariMSSS1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));
        ComboboxCariMSSS1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxCariMSSS1ItemStateChanged(evt);
            }
        });

        TambahPengembalianSHPSS.setText("Tambah Pengembalian");
        TambahPengembalianSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianSHPSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addComponent(TambahPengembalianSHPSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariMSSS1))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariMSSS1)
                    .addComponent(FieldCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSS2Layout = new javax.swing.GroupLayout(SHP_SHPSS2);
        SHP_SHPSS2.setLayout(SHP_SHPSS2Layout);
        SHP_SHPSS2Layout.setHorizontalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SHP_SHPSS2Layout.setVerticalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("SHP & SHPSS", SHP_SHPSS2);

        Kemasan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kemasan2MouseClicked(evt);
            }
        });

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianKemasanMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(TablePengembalianKemasan);

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

        TambahPengembalianKemasan.setText("Tambah Pengembalian");
        TambahPengembalianKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addComponent(TambahPengembalianKemasan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko17))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko17)
                    .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Kemasan2Layout = new javax.swing.GroupLayout(Kemasan2);
        Kemasan2.setLayout(Kemasan2Layout);
        Kemasan2Layout.setHorizontalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Kemasan2Layout.setVerticalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Kemasan", Kemasan2);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(TablePengembalianMerchandise);

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

        TambahPengembalianMerchandise.setText("Tambah Pengembalian");
        TambahPengembalianMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(TambahPengembalianMerchandise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko18))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko18)
                    .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Merchandise2Layout = new javax.swing.GroupLayout(Merchandise2);
        Merchandise2.setLayout(Merchandise2Layout);
        Merchandise2Layout.setHorizontalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Merchandise2Layout.setVerticalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Merchandise", Merchandise2);

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianPrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianPrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianPrismaMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(TablePengembalianPrisma);

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

        TambahPengembalianPrisma.setText("Tambah Pengembalian");
        TambahPengembalianPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianPrismaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addComponent(TambahPengembalianPrisma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko19))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko19)
                    .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prisma2Layout = new javax.swing.GroupLayout(Prisma2);
        Prisma2.setLayout(Prisma2Layout);
        Prisma2Layout.setHorizontalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prisma2Layout.setVerticalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Prisma", Prisma2);

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(TablePengembalianDokumenFilateli);

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

        TambahPengembalianDokumenFilateli.setText("Tambah Pengembalian");
        TambahPengembalianDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianDokumenFilateliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addComponent(TambahPengembalianDokumenFilateli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko20))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko20)
                    .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalianDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateli2Layout = new javax.swing.GroupLayout(DokumenFilateli2);
        DokumenFilateli2.setLayout(DokumenFilateli2Layout);
        DokumenFilateli2Layout.setHorizontalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DokumenFilateli2Layout.setVerticalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Dokumen Filateli", DokumenFilateli2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPengembalian)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPengembalian)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablePengembalianPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianPrangkoMouseClicked

    private void CariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariPrangkoActionPerformed

    private void FieldCariPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariPrangkoMouseClicked

    private void Prangko2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prangko2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Prangko2MouseClicked

    private void MS_SS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SS2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SS2MouseClicked

    private void SHP_SHPSS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSS2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSS2MouseClicked

    private void Kemasan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kemasan2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Kemasan2MouseClicked

    private void TabPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPengembalianMouseClicked
        // TODO add your handling code here:
        String jenis_produk;
        switch (TabPengembalian.getSelectedIndex()) {
            case 0:
                jenis_produk = "PR";
                getDataPengembalian(jenis_produk);
                break;
            case 1:
                jenis_produk = "MS";
                getDataPengembalian(jenis_produk);
                break;
            case 2:
                jenis_produk = "SHP";
                getDataPengembalian(jenis_produk);
                break;
            case 3:
                jenis_produk = "KM";
                getDataPengembalian(jenis_produk);
                break;
            case 4:
                jenis_produk = "MC";
                getDataPengembalian(jenis_produk);
                break;
            case 5:
                jenis_produk = "PS";
                getDataPengembalian(jenis_produk);
                break;
            case 6:
                jenis_produk = "DF";
                getDataPengembalian(jenis_produk);
                break;
            default:
                break;
        }

    }//GEN-LAST:event_TabPengembalianMouseClicked

    private void TablePengembalianKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianKemasanMouseClicked

    private void buttonCariPrangko17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko17ActionPerformed

    private void fieldCariPrangko17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko17MouseClicked

    private void TablePengembalianMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMerchandiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianMerchandiseMouseClicked

    private void buttonCariPrangko18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko18ActionPerformed

    private void fieldCariPrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko18MouseClicked

    private void TablePengembalianPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrismaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianPrismaMouseClicked

    private void buttonCariPrangko19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko19ActionPerformed

    private void fieldCariPrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko19MouseClicked

    private void TablePengembalianDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianDokumenFilateliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianDokumenFilateliMouseClicked

    private void buttonCariPrangko20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko20ActionPerformed

    private void fieldCariPrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko20MouseClicked

    private void TablePengembalianMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianMSSSMouseClicked

    private void CariMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariMSSSActionPerformed

    private void FieldCariMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariMSSSMouseClicked

    private void ComboboxCariMSSSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxCariMSSSItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxCariMSSSItemStateChanged

    private void TablePengembalianSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianSHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianSHPSSMouseClicked

    private void CariMSSS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariMSSS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariMSSS1ActionPerformed

    private void FieldCariMSSS1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariMSSS1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariMSSS1MouseClicked

    private void ComboboxCariMSSS1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxCariMSSS1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxCariMSSS1ItemStateChanged

    private void TambahPengembalianMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianMSSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "MS";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianMSSSActionPerformed

    private void TambahPengembalianPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianPrangkoActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "PR";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianPrangkoActionPerformed

    private void TambahPengembalianSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianSHPSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "SHP";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianSHPSSActionPerformed

    private void TambahPengembalianKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianKemasanActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "KM";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianKemasanActionPerformed

    private void TambahPengembalianMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianMerchandiseActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "MC";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianMerchandiseActionPerformed

    private void TambahPengembalianPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianPrismaActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "PS";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianPrismaActionPerformed

    private void TambahPengembalianDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianDokumenFilateliActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        String jenis_produk = "DF";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianDokumenFilateliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariMSSS;
    private javax.swing.JButton CariMSSS1;
    private javax.swing.JButton CariPrangko;
    private javax.swing.JComboBox<String> ComboboxCariMSSS;
    private javax.swing.JComboBox<String> ComboboxCariMSSS1;
    private javax.swing.JComboBox<String> ComboboxCariPrangko;
    private javax.swing.JPanel DokumenFilateli2;
    private javax.swing.JTextField FieldCariMSSS;
    private javax.swing.JTextField FieldCariMSSS1;
    private javax.swing.JTextField FieldCariPrangko;
    private javax.swing.JPanel Kemasan2;
    private javax.swing.JPanel MS_SS2;
    private javax.swing.JPanel Merchandise2;
    private javax.swing.JPanel Prangko2;
    private javax.swing.JPanel Prisma2;
    private javax.swing.JPanel SHP_SHPSS2;
    private javax.swing.JTabbedPane TabPengembalian;
    private javax.swing.JTable TablePengembalianDokumenFilateli;
    private javax.swing.JTable TablePengembalianKemasan;
    private javax.swing.JTable TablePengembalianMSSS;
    private javax.swing.JTable TablePengembalianMerchandise;
    private javax.swing.JTable TablePengembalianPrangko;
    private javax.swing.JTable TablePengembalianPrisma;
    private javax.swing.JTable TablePengembalianSHPSS;
    private javax.swing.JButton TambahPengembalianDokumenFilateli;
    private javax.swing.JButton TambahPengembalianKemasan;
    private javax.swing.JButton TambahPengembalianMSSS;
    private javax.swing.JButton TambahPengembalianMerchandise;
    private javax.swing.JButton TambahPengembalianPrangko;
    private javax.swing.JButton TambahPengembalianPrisma;
    private javax.swing.JButton TambahPengembalianSHPSS;
    private javax.swing.JButton buttonCariPrangko17;
    private javax.swing.JButton buttonCariPrangko18;
    private javax.swing.JButton buttonCariPrangko19;
    private javax.swing.JButton buttonCariPrangko20;
    private javax.swing.JComboBox<String> comboCariPrangko17;
    private javax.swing.JComboBox<String> comboCariPrangko18;
    private javax.swing.JComboBox<String> comboCariPrangko19;
    private javax.swing.JComboBox<String> comboCariPrangko20;
    private javax.swing.JTextField fieldCariPrangko17;
    private javax.swing.JTextField fieldCariPrangko18;
    private javax.swing.JTextField fieldCariPrangko19;
    private javax.swing.JTextField fieldCariPrangko20;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    // End of variables declaration//GEN-END:variables
}
