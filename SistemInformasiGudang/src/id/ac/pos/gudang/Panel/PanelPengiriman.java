/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPengiriman;
import id.ac.pos.gudang.Dialog.DialogViewDetailPengiriman;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengirimanDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengirimanDAOImpl;
import id.ac.pos.gudang.entity.Pengiriman;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengirimanTM;
import java.util.ArrayList;
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
    TableRowSorter sorter;
    private String jenis_produk;

    /**
     * Creates new form PanelPengiriman
     */
    public PanelPengiriman() {
        initComponents();
        jenis_produk = "PR";
        getDataPengiriman(jenis_produk);
        
        
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
    
    public String cariData(String tabCari) {
        Object pilihanCari = "";
        if (tabCari.compareTo("PR") == 0) {
            pilihanCari = comboCariPrangko.getSelectedItem();
        } else if (tabCari.compareTo("KM") == 0) {
            pilihanCari = comboCariKemasan.getSelectedItem();
        } else if (tabCari.compareTo("SHP") == 0) {
            pilihanCari = comboCariSHPSS.getSelectedItem();
        } else if (tabCari.compareTo("SS") == 0) {
            pilihanCari = comboCariMSSS.getSelectedItem();
        } else if (tabCari.compareTo("MC") == 0) {
            pilihanCari = comboCariMerchandise.getSelectedItem();
        } else if (tabCari.compareTo("PS") == 0) {
            pilihanCari = comboCariPrisma.getSelectedItem();
        } else if (tabCari.compareTo("DF") == 0) {
            pilihanCari = comboCariDokumenFilateli.getSelectedItem();
        }
              
        String jenisCari = null;
        

        if (pilihanCari == "Id Pengiriman") {
            jenisCari = "id_pengiriman";
        } else if (pilihanCari == "Nomor Order Pengiriman") {
            jenisCari = "no_order_pengiriman";
        } else if (pilihanCari == "Kode Produk") {
            jenisCari = "id_produk";
        } else if (pilihanCari == "Nama Produk") {
            jenisCari = "tb_produk.nama_produk";
        } else if (pilihanCari == "Kode Regional") {
            jenisCari = "id_regional";
        } else if (pilihanCari == "Jumlah Pengiriman") {
            jenisCari = "jml_pengiriman";
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

    public void getDataPengiriman(String jenis_produk) {
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.getPengiriman(jenis_produk);

        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        if (jenis_produk.compareTo("PR") == 0) {
            tabelPengirimanPrangko.setRowSorter(sorter);
            tabelPengirimanPrangko.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("MS") == 0){
            tabelPengirimanMSSS.setRowSorter(sorter);
            tabelPengirimanMSSS.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("SHP") == 0){
            tabelPengirimanSHPSS.setRowSorter(sorter);
            tabelPengirimanSHPSS.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("KM") == 0){
            tabelPengirimanKemasan.setRowSorter(sorter);
            tabelPengirimanKemasan.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("MC") == 0){
            tabelPengirimanMerchandise.setRowSorter(sorter);
            tabelPengirimanMerchandise.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("PS") == 0){
            tabelPengirimanPrisma.setRowSorter(sorter);
            tabelPengirimanPrisma.setModel(pengirimanTM);
        }else if (jenis_produk.compareTo("DF") == 0){
            tabelPengirimanDokumenFilateli.setRowSorter(sorter);
            tabelPengirimanDokumenFilateli.setModel(pengirimanTM);
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

        TabbedPanePengiriman = new javax.swing.JTabbedPane();
        Prangko3 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tabelPengirimanPrangko = new javax.swing.JTable();
        buttonCariPrangko = new javax.swing.JButton();
        fieldCariPrangko = new javax.swing.JTextField();
        comboCariPrangko = new javax.swing.JComboBox<>();
        TambahPrangko = new javax.swing.JButton();
        MS_SS3 = new javax.swing.JPanel();
        jPanel74 = new javax.swing.JPanel();
        jScrollPane42 = new javax.swing.JScrollPane();
        tabelPengirimanMSSS = new javax.swing.JTable();
        buttonCariMSSS = new javax.swing.JButton();
        fieldCariMSSS = new javax.swing.JTextField();
        comboCariMSSS = new javax.swing.JComboBox<>();
        TambahMSSS = new javax.swing.JButton();
        SHP_SHPSS3 = new javax.swing.JPanel();
        jPanel76 = new javax.swing.JPanel();
        jScrollPane44 = new javax.swing.JScrollPane();
        tabelPengirimanSHPSS = new javax.swing.JTable();
        buttonCariSHPSS = new javax.swing.JButton();
        fieldCariSHPSS = new javax.swing.JTextField();
        comboCariSHPSS = new javax.swing.JComboBox<>();
        TambahSHPSS = new javax.swing.JButton();
        Kemasan3 = new javax.swing.JPanel();
        jPanel78 = new javax.swing.JPanel();
        jScrollPane46 = new javax.swing.JScrollPane();
        tabelPengirimanKemasan = new javax.swing.JTable();
        buttonCariKemasan = new javax.swing.JButton();
        fieldCariKemasan = new javax.swing.JTextField();
        comboCariKemasan = new javax.swing.JComboBox<>();
        TambahKemasan = new javax.swing.JButton();
        Merchandise3 = new javax.swing.JPanel();
        jPanel80 = new javax.swing.JPanel();
        jScrollPane48 = new javax.swing.JScrollPane();
        tabelPengirimanMerchandise = new javax.swing.JTable();
        buttonCariMerchandise = new javax.swing.JButton();
        fieldCariMerchandise = new javax.swing.JTextField();
        comboCariMerchandise = new javax.swing.JComboBox<>();
        TambahMerchandise = new javax.swing.JButton();
        Prisma3 = new javax.swing.JPanel();
        jPanel82 = new javax.swing.JPanel();
        jScrollPane50 = new javax.swing.JScrollPane();
        tabelPengirimanPrisma = new javax.swing.JTable();
        buttonCariPrisma = new javax.swing.JButton();
        fieldCariPrisma = new javax.swing.JTextField();
        comboCariPrisma = new javax.swing.JComboBox<>();
        TambahPrisma = new javax.swing.JButton();
        DokumenFilateli3 = new javax.swing.JPanel();
        jPanel84 = new javax.swing.JPanel();
        jScrollPane52 = new javax.swing.JScrollPane();
        tabelPengirimanDokumenFilateli = new javax.swing.JTable();
        buttonCariDokumenFilateli = new javax.swing.JButton();
        fieldCariDokumenFilateli = new javax.swing.JTextField();
        comboCariDokumenFilateli = new javax.swing.JComboBox<>();
        TambahDokumenFilateli = new javax.swing.JButton();

        TabbedPanePengiriman.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabbedPanePengirimanMouseClicked(evt);
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

        buttonCariPrangko.setText("Cari");
        buttonCariPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangkoActionPerformed(evt);
            }
        });

        comboCariPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko))
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko)
                    .addComponent(fieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane42.setViewportView(tabelPengirimanMSSS);

        buttonCariMSSS.setText("Cari");
        buttonCariMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMSSSActionPerformed(evt);
            }
        });

        comboCariMSSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariMSSS))
        );
        jPanel74Layout.setVerticalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel74Layout.createSequentialGroup()
                .addGroup(jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariMSSS)
                    .addComponent(fieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane44.setViewportView(tabelPengirimanSHPSS);

        buttonCariSHPSS.setText("Cari");
        buttonCariSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariSHPSSActionPerformed(evt);
            }
        });

        comboCariSHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariSHPSS))
        );
        jPanel76Layout.setVerticalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel76Layout.createSequentialGroup()
                .addGroup(jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariSHPSS)
                    .addComponent(fieldCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane46.setViewportView(tabelPengirimanKemasan);

        buttonCariKemasan.setText("Cari");
        buttonCariKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariKemasanActionPerformed(evt);
            }
        });

        comboCariKemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariKemasan))
        );
        jPanel78Layout.setVerticalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel78Layout.createSequentialGroup()
                .addGroup(jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariKemasan)
                    .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane48.setViewportView(tabelPengirimanMerchandise);

        buttonCariMerchandise.setText("Cari");
        buttonCariMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMerchandiseActionPerformed(evt);
            }
        });

        comboCariMerchandise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariMerchandise))
        );
        jPanel80Layout.setVerticalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel80Layout.createSequentialGroup()
                .addGroup(jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariMerchandise)
                    .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane50.setViewportView(tabelPengirimanPrisma);

        buttonCariPrisma.setText("Cari");
        buttonCariPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrismaActionPerformed(evt);
            }
        });

        comboCariPrisma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrisma))
        );
        jPanel82Layout.setVerticalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel82Layout.createSequentialGroup()
                .addGroup(jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrisma)
                    .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        jScrollPane52.setViewportView(tabelPengirimanDokumenFilateli);

        buttonCariDokumenFilateli.setText("Cari");
        buttonCariDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariDokumenFilateliActionPerformed(evt);
            }
        });

        comboCariDokumenFilateli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id Pengiriman", "Nomor Order Pengiriman", "Kode Produk", "Nama Produk", "Kode Regional", "Jumlah Pengiriman" }));

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
                .addComponent(comboCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariDokumenFilateli))
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel84Layout.createSequentialGroup()
                .addGroup(jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariDokumenFilateli)
                    .addComponent(fieldCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            jenis_produk = "PR";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 1) {
            jenis_produk = "MS";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 2) {
            jenis_produk = "SHP";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 3) {
            jenis_produk = "KM";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 4) {
            jenis_produk = "MC";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 5) {
            jenis_produk = "PS";
            getDataPengiriman(jenis_produk);
        } else if (TabbedPanePengiriman.getSelectedIndex() == 6) {
            jenis_produk = "DF";
            getDataPengiriman(jenis_produk);
        }
    }//GEN-LAST:event_TabbedPanePengirimanMouseClicked

    private void TambahPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPrangkoActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "PR";
        getDataPengiriman(jenis_produk);

    }//GEN-LAST:event_TambahPrangkoActionPerformed

    private void TambahMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahMSSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "MS";
        getDataPengiriman(jenis_produk);

    }//GEN-LAST:event_TambahMSSSActionPerformed

    private void TambahSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahSHPSSActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "SHP";
        getDataPengiriman(jenis_produk);
    }//GEN-LAST:event_TambahSHPSSActionPerformed

    private void TambahKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahKemasanActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "KM";
        getDataPengiriman(jenis_produk);
    }//GEN-LAST:event_TambahKemasanActionPerformed

    private void TambahMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahMerchandiseActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "MC";
        getDataPengiriman(jenis_produk);
    }//GEN-LAST:event_TambahMerchandiseActionPerformed

    private void TambahPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPrismaActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "PS";
        getDataPengiriman(jenis_produk);
    }//GEN-LAST:event_TambahPrismaActionPerformed

    private void TambahDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahDokumenFilateliActionPerformed
        FormHome formHome = new FormHome();
        DialogTambahPengiriman dialogTambahPengiriman = new DialogTambahPengiriman(formHome, true);
        dialogTambahPengiriman.setVisible(true);
        jenis_produk = "DF";
        getDataPengiriman(jenis_produk);
    }//GEN-LAST:event_TambahDokumenFilateliActionPerformed

    private void buttonCariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangkoActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPrangko.getText();
        String status = "pr";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanPrangko.setRowSorter(sorter);
        tabelPengirimanPrangko.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariPrangkoActionPerformed

    private void buttonCariMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMSSSActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariMSSS.getText();
        String status = "ss";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanMSSS.setRowSorter(sorter);
        tabelPengirimanMSSS.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariMSSSActionPerformed

    private void buttonCariSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariSHPSSActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariSHPSS.getText();
        String status = "shp";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanSHPSS.setRowSorter(sorter);
        tabelPengirimanSHPSS.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariSHPSSActionPerformed

    private void buttonCariKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariKemasanActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariKemasan.getText();
        String status = "km";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanKemasan.setRowSorter(sorter);
        tabelPengirimanKemasan.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariKemasanActionPerformed

    private void buttonCariMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMerchandiseActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariMerchandise.getText();
        String status = "mc";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanMerchandise.setRowSorter(sorter);
        tabelPengirimanMerchandise.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariMerchandiseActionPerformed

    private void buttonCariPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrismaActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPrisma.getText();
        String status = "ps";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanPrisma.setRowSorter(sorter);
        tabelPengirimanPrisma.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariPrismaActionPerformed

    private void buttonCariDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariDokumenFilateliActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariDokumenFilateli.getText();
        String status = "df";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PengirimanDAOImpl();
        ArrayList<Pengiriman> arrayPengiriman = dao.cariProdukPengiriman(keyword, jenisCari, idJenis);
                
        PengirimanTM pengirimanTM = new PengirimanTM();
        pengirimanTM.setDataPengiriman(arrayPengiriman);
        sorter = new TableRowSorter(pengirimanTM);
        tabelPengirimanDokumenFilateli.setRowSorter(sorter);
        tabelPengirimanDokumenFilateli.setModel(pengirimanTM);
    }//GEN-LAST:event_buttonCariDokumenFilateliActionPerformed

    private void tabelPengirimanPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPengirimanPrangkoMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int baris = tabelPengirimanPrangko.getSelectedRow();
            String id_pengiriman = (String) tabelPengirimanPrangko.getValueAt(baris, 0);
            
            FormHome formHome = new FormHome();
            DialogViewDetailPengiriman detailPengiriman = new DialogViewDetailPengiriman(formHome, true,id_pengiriman);
            detailPengiriman.setVisible(true);
        }
    }//GEN-LAST:event_tabelPengirimanPrangkoMouseClicked


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
    private javax.swing.JButton buttonCariDokumenFilateli;
    private javax.swing.JButton buttonCariKemasan;
    private javax.swing.JButton buttonCariMSSS;
    private javax.swing.JButton buttonCariMerchandise;
    private javax.swing.JButton buttonCariPrangko;
    private javax.swing.JButton buttonCariPrisma;
    private javax.swing.JButton buttonCariSHPSS;
    private javax.swing.JComboBox<String> comboCariDokumenFilateli;
    private javax.swing.JComboBox<String> comboCariKemasan;
    private javax.swing.JComboBox<String> comboCariMSSS;
    private javax.swing.JComboBox<String> comboCariMerchandise;
    private javax.swing.JComboBox<String> comboCariPrangko;
    private javax.swing.JComboBox<String> comboCariPrisma;
    private javax.swing.JComboBox<String> comboCariSHPSS;
    private javax.swing.JTextField fieldCariDokumenFilateli;
    private javax.swing.JTextField fieldCariKemasan;
    private javax.swing.JTextField fieldCariMSSS;
    private javax.swing.JTextField fieldCariMerchandise;
    private javax.swing.JTextField fieldCariPrangko;
    private javax.swing.JTextField fieldCariPrisma;
    private javax.swing.JTextField fieldCariSHPSS;
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
