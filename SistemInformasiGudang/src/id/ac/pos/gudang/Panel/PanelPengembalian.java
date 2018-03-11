/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPengembalian;
import id.ac.pos.gudang.Dialog.DialogViewDetailPengembalian;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengembalianTM;
import java.util.ArrayList;
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
    private String jenis_produk;

    /**
     * Creates new form PanelPengembalian
     */
    public PanelPengembalian() {
        initComponents();
        jenis_produk = "PR";
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
    
    public String cariData(String tabCari) {
        Object pilihanCari = "";
        if (tabCari.compareTo("PR") == 0) {
            pilihanCari = ComboboxCariPrangko.getSelectedItem();
        } else if (tabCari.compareTo("KM") == 0) {
            pilihanCari = comboCariKemasan.getSelectedItem();
        } else if (tabCari.compareTo("SHP") == 0) {
            pilihanCari = ComboboxCariSHPSS.getSelectedItem();
        } else if (tabCari.compareTo("SS") == 0) {
            pilihanCari = ComboboxCariMSSS.getSelectedItem();
        } else if (tabCari.compareTo("MC") == 0) {
            pilihanCari = comboCariMerchandise.getSelectedItem();
        } else if (tabCari.compareTo("PS") == 0) {
            pilihanCari = comboCariPrisma.getSelectedItem();
        } else if (tabCari.compareTo("DF") == 0) {
            pilihanCari = comboCariDokumenFilateli.getSelectedItem();
        }
              
        String jenisCari = null;

        if (pilihanCari == "Id Pengembalian") {
            jenisCari = "id_pengembalian";
        } else if (pilihanCari == "Kode Produk") {
            jenisCari = "tb_produk.id_produk";
        } else if (pilihanCari == "Nama Produk") {
            jenisCari = "nama_produk";
        } else if (pilihanCari == "Kode Regional") {
            jenisCari = "id_regional";
        } else if (pilihanCari == "Jumlah Pengembalian") {
            jenisCari = "jml_pengembalian";
        } else if (pilihanCari == "Nomor Dus") {
            jenisCari = "dus";
        }

        return jenisCari;

    }
    
    public String cariJenis(String tab) {
        String idJenis = "";

        if (tab.compareTo("pr") == 0) {
            idJenis = "PR";
        } else if (tab.compareTo("km") == 0) {
            idJenis = "KM";
        } else if (tab.compareTo("shp") == 0) {
            idJenis = "SHP";
        } else if (tab.compareTo("ss") == 0) {
            idJenis = "SS";
        } else if (tab.compareTo("mc") == 0) {
            idJenis = "MC";
        } else if (tab.compareTo("ps") == 0) {
            idJenis = "PS";
        } else if (tab.compareTo("df") == 0) {
            idJenis = "DF";
        }

        return idJenis;
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
        CariSHPSS = new javax.swing.JButton();
        FieldCariSHPSS = new javax.swing.JTextField();
        ComboboxCariSHPSS = new javax.swing.JComboBox<>();
        TambahPengembalianSHPSS = new javax.swing.JButton();
        Kemasan2 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TablePengembalianKemasan = new javax.swing.JTable();
        buttonCariKemasan = new javax.swing.JButton();
        fieldCariKemasan = new javax.swing.JTextField();
        comboCariKemasan = new javax.swing.JComboBox<>();
        TambahPengembalianKemasan = new javax.swing.JButton();
        Merchandise2 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TablePengembalianMerchandise = new javax.swing.JTable();
        buttonCariMerchandise = new javax.swing.JButton();
        fieldCariMerchandise = new javax.swing.JTextField();
        comboCariMerchandise = new javax.swing.JComboBox<>();
        TambahPengembalianMerchandise = new javax.swing.JButton();
        Prisma2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TablePengembalianPrisma = new javax.swing.JTable();
        buttonCariPrisma = new javax.swing.JButton();
        fieldCariPrisma = new javax.swing.JTextField();
        comboCariPrisma = new javax.swing.JComboBox<>();
        TambahPengembalianPrisma = new javax.swing.JButton();
        DokumenFilateli2 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TablePengembalianDokumenFilateli = new javax.swing.JTable();
        buttonCariDokumenFilateli = new javax.swing.JButton();
        fieldCariDokumenFilateli = new javax.swing.JTextField();
        comboCariDokumenFilateli = new javax.swing.JComboBox<>();
        TambahPengembalianDokumenFilateli = new javax.swing.JButton();

        TabPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPengembalianMouseClicked(evt);
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

        ComboboxCariPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(FieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        ComboboxCariMSSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(FieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        CariSHPSS.setText("Cari");
        CariSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariSHPSSActionPerformed(evt);
            }
        });

        ComboboxCariSHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(ComboboxCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariSHPSS))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariSHPSS)
                    .addComponent(FieldCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        buttonCariKemasan.setText("Cari");
        buttonCariKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariKemasanActionPerformed(evt);
            }
        });

        comboCariKemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(comboCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariKemasan))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariKemasan)
                    .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        buttonCariMerchandise.setText("Cari");
        buttonCariMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMerchandiseActionPerformed(evt);
            }
        });

        comboCariMerchandise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(comboCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariMerchandise))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariMerchandise)
                    .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        buttonCariPrisma.setText("Cari");
        buttonCariPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrismaActionPerformed(evt);
            }
        });

        comboCariPrisma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(comboCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrisma))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrisma)
                    .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        buttonCariDokumenFilateli.setText("Cari");
        buttonCariDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariDokumenFilateliActionPerformed(evt);
            }
        });

        comboCariDokumenFilateli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengembalian", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengembalian", "Nomor Dus" }));

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
                .addComponent(comboCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariDokumenFilateli))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariDokumenFilateli)
                    .addComponent(fieldCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void TabPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPengembalianMouseClicked
        // TODO add your handling code here:
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

    private void TambahPengembalianMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianMSSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        jenis_produk = "MS";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianMSSSActionPerformed

    private void TambahPengembalianPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianPrangkoActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        jenis_produk = "PR";
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
        jenis_produk = "KM";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianKemasanActionPerformed

    private void TambahPengembalianMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianMerchandiseActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        jenis_produk = "MC";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianMerchandiseActionPerformed

    private void TambahPengembalianPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianPrismaActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        jenis_produk = "PS";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianPrismaActionPerformed

    private void TambahPengembalianDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianDokumenFilateliActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        new DialogTambahPengembalian(formHome, true).setVisible(true);
        jenis_produk = "DF";
        getDataPengembalian(jenis_produk);
    }//GEN-LAST:event_TambahPengembalianDokumenFilateliActionPerformed

    private void CariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariPrangkoActionPerformed
        // TODO add your handling code here:
        String keyword = FieldCariPrangko.getText();
        String status = "pr";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianPrangko.setRowSorter(sorter);
        TablePengembalianPrangko.setModel(pengembalianTM);
    }//GEN-LAST:event_CariPrangkoActionPerformed

    private void CariMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariMSSSActionPerformed
        // TODO add your handling code here:
        String keyword = FieldCariMSSS.getText();
        String status = "ss";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianMSSS.setRowSorter(sorter);
        TablePengembalianMSSS.setModel(pengembalianTM);
    }//GEN-LAST:event_CariMSSSActionPerformed

    private void CariSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariSHPSSActionPerformed
        // TODO add your handling code here:
        String keyword = FieldCariSHPSS.getText();
        String status = "shp";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianSHPSS.setRowSorter(sorter);
        TablePengembalianSHPSS.setModel(pengembalianTM);
    }//GEN-LAST:event_CariSHPSSActionPerformed

    private void buttonCariKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariKemasanActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariKemasan.getText();
        String status = "km";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianKemasan.setRowSorter(sorter);
        TablePengembalianKemasan.setModel(pengembalianTM);
    }//GEN-LAST:event_buttonCariKemasanActionPerformed

    private void buttonCariMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMerchandiseActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariMerchandise.getText();
        String status = "mc";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianMerchandise.setRowSorter(sorter);
        TablePengembalianMerchandise.setModel(pengembalianTM);
    }//GEN-LAST:event_buttonCariMerchandiseActionPerformed

    private void buttonCariPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrismaActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPrisma.getText();
        String status = "ps";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianPrisma.setRowSorter(sorter);
        TablePengembalianPrisma.setModel(pengembalianTM);
    }//GEN-LAST:event_buttonCariPrismaActionPerformed

    private void buttonCariDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariDokumenFilateliActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariDokumenFilateli.getText();
        String status = "df";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.cariProdukPengembalian(keyword, jenisCari, idJenis);
                
        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianDokumenFilateli.setRowSorter(sorter);
        TablePengembalianDokumenFilateli.setModel(pengembalianTM);
    }//GEN-LAST:event_buttonCariDokumenFilateliActionPerformed

    private void TablePengembalianPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrangkoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianPrangko.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianPrangko.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianPrangkoMouseClicked

    private void TablePengembalianMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMSSSMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount()==2){
            int baris = TablePengembalianMSSS.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianMSSS.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianMSSSMouseClicked

    private void TablePengembalianSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianSHPSSMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianSHPSS.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianSHPSS.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianSHPSSMouseClicked

    private void TablePengembalianKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianKemasanMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianKemasan.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianKemasan.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianKemasanMouseClicked

    private void TablePengembalianMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMerchandiseMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianMerchandise.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianMerchandise.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianMerchandiseMouseClicked

    private void TablePengembalianPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrismaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianPrisma.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianPrisma.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianPrismaMouseClicked

    private void TablePengembalianDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianDokumenFilateliMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = TablePengembalianDokumenFilateli.getSelectedRow();
            String id_pengembalian = (String) TablePengembalianDokumenFilateli.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengembalian detailPengembalian = new DialogViewDetailPengembalian(formHome, true,id_pengembalian);
            detailPengembalian.setVisible(true);
        }
    }//GEN-LAST:event_TablePengembalianDokumenFilateliMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariMSSS;
    private javax.swing.JButton CariPrangko;
    private javax.swing.JButton CariSHPSS;
    private javax.swing.JComboBox<String> ComboboxCariMSSS;
    private javax.swing.JComboBox<String> ComboboxCariPrangko;
    private javax.swing.JComboBox<String> ComboboxCariSHPSS;
    private javax.swing.JPanel DokumenFilateli2;
    private javax.swing.JTextField FieldCariMSSS;
    private javax.swing.JTextField FieldCariPrangko;
    private javax.swing.JTextField FieldCariSHPSS;
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
    private javax.swing.JButton buttonCariDokumenFilateli;
    private javax.swing.JButton buttonCariKemasan;
    private javax.swing.JButton buttonCariMerchandise;
    private javax.swing.JButton buttonCariPrisma;
    private javax.swing.JComboBox<String> comboCariDokumenFilateli;
    private javax.swing.JComboBox<String> comboCariKemasan;
    private javax.swing.JComboBox<String> comboCariMerchandise;
    private javax.swing.JComboBox<String> comboCariPrisma;
    private javax.swing.JTextField fieldCariDokumenFilateli;
    private javax.swing.JTextField fieldCariKemasan;
    private javax.swing.JTextField fieldCariMerchandise;
    private javax.swing.JTextField fieldCariPrisma;
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
