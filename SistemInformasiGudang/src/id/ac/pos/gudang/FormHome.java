/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang;

import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.tablemodel.ProdukTM;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Oyoy
 */
public final class FormHome extends javax.swing.JFrame {

    /**
     * Creates new form FormHome
     */
    private Produk produk;
    private ProdukDAO dao;
    ArrayList<Produk> arrayProduk;

    public FormHome() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        autoincrementPrangko();
        autoincrementMS_SS();
        autoincrementSHP_SHPSS();
        autoincrementKemasan();
        autoincrementMerchandise();
        autoincrementPrisma();
        autoincrementDokumenFilateli();
        getDataPrangko();
        getDataMS_SS();
        getDataSHP_SHPSS();
        getDataKemasan();
        getDataMerchandise();
        getDataPrisma();
        getDataDokumenFilateli();
        fieldNamaProdukPenerimaan.addKeyListener(new keyTextField(fieldNamaProdukPenerimaan));
    }

    private void autoincrementPrangko() {
        String kosong = null;
        dao = new ProdukDAOImpl();
        String jenisProduk = "PR";

        String kode_prangko = dao.getIdProduk(jenisProduk);
        if (kode_prangko == null) {
            kode_prangko = "PR000";
        }
        String sub_nomor_string = kode_prangko.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kode_prangko = "PR" + kosong + sub_nomor_string;
        fieldKodeProdukPrangko.setText(kode_prangko);
    }

    private void autoincrementMS_SS() {
        Object jenisMS_SS = ComboJenisMS_SS.getSelectedItem();
        String kosong = null;
        String jenisProduk = null;

        dao = new ProdukDAOImpl();
        if (jenisMS_SS == "MS") {
            jenisProduk = "MS";
            //Tambahkan pilihan item untuk buah

        } else if (jenisMS_SS == "SS") {
            jenisProduk = "SS";
        }

        String kodeMS_SS = dao.getIdProduk(jenisProduk);
        if (kodeMS_SS == null) {
            kodeMS_SS = "" + jenisProduk + "000";
        }
        String sub_nomor_string = kodeMS_SS.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kodeMS_SS = jenisProduk + kosong + sub_nomor_string;
        fieldKodeProdukMS_SS.setText(kodeMS_SS);
    }

    private void autoincrementKemasan() {
        String kosong = null;
        dao = new ProdukDAOImpl();
        String jenisProduk = "KM";

        String kode_prangko = dao.getIdProduk(jenisProduk);
        if (kode_prangko == null) {
            kode_prangko = "KM000";
        }
        String sub_nomor_string = kode_prangko.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kode_prangko = "KM" + kosong + sub_nomor_string;
        fieldKodeProdukKemasan.setText(kode_prangko);
    }

    private void autoincrementMerchandise() {
        String kosong = null;
        dao = new ProdukDAOImpl();
        String jenisProduk = "MC";

        String kode_merchandise = dao.getIdProduk(jenisProduk);
        if (kode_merchandise == null) {
            kode_merchandise = "MC000";
        }
        String sub_nomor_string = kode_merchandise.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kode_merchandise = "MC" + kosong + sub_nomor_string;
        fieldKodeProdukMerchandise.setText(kode_merchandise);
    }

    private void autoincrementPrisma() {
        String kosong = null;
        dao = new ProdukDAOImpl();
        String jenisProduk = "PS";

        String kode_prisma = dao.getIdProduk(jenisProduk);
        if (kode_prisma == null) {
            kode_prisma = "PS000";
        }
        String sub_nomor_string = kode_prisma.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kode_prisma = "PS" + kosong + sub_nomor_string;
        fieldKodeProdukPrisma.setText(kode_prisma);
    }

    private void autoincrementDokumenFilateli() {
        String kosong = null;
        dao = new ProdukDAOImpl();
        String jenisProduk = "DF";

        String kode_dokumen_filateli = dao.getIdProduk(jenisProduk);
        if (kode_dokumen_filateli == null) {
            kode_dokumen_filateli = "DF000";
        }
        String sub_nomor_string = kode_dokumen_filateli.substring(2, 5);
        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kode_dokumen_filateli = "DF" + kosong + sub_nomor_string;
        fieldKodeProdukDokumenFilateli.setText(kode_dokumen_filateli);
    }

    private void hanyaAngka() {
        /*char karakter = evt.getKeyChar();
         if(!(((karakter >= '0') && (karakter <= '9') || (karakter == KeyEvent.VK_BACK_SPACE) || (karakter == KeyEvent.VK_DELETE)))){
         getToolkit().beep();
         evt.consume();
         }*/
    }

    private void autoincrementSHP_SHPSS() {
        Object jenisSHP_SHPSS = ComboJenisSHP_SHPSS.getSelectedItem();
        String kosong = null;
        String jenisProduk = null;
        String sub_nomor_string = null;

        dao = new ProdukDAOImpl();
        if (jenisSHP_SHPSS == "SHP") {
            jenisProduk = "SHP";
            //Tambahkan pilihan item untuk buah

        } else if (jenisSHP_SHPSS == "SHPSS") {
            jenisProduk = "SHPSS";
        }

        String kodeSHP_SHPSS = dao.getIdProduk(jenisProduk);
        if (kodeSHP_SHPSS == null) {
            kodeSHP_SHPSS = jenisProduk + "000";
        }

        if (jenisSHP_SHPSS == "SHP") {
            sub_nomor_string = kodeSHP_SHPSS.substring(3, 6);
            //Tambahkan pilihan item untuk buah

        } else if (jenisSHP_SHPSS == "SHPSS") {
            sub_nomor_string = kodeSHP_SHPSS.substring(5, 8);
        }

        int sub_nomor_int = Integer.parseInt(sub_nomor_string);
        sub_nomor_string = String.valueOf(sub_nomor_int);
        int panjang = sub_nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "00";
                break;
            case 2:
                kosong = "0";
                break;
            case 3:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        sub_nomor_string = String.valueOf(sub_nomor_int);
        kodeSHP_SHPSS = jenisProduk + kosong + sub_nomor_string;
        fieldKodeProdukSHP_SHPSS.setText(kodeSHP_SHPSS);
    }

    private void getDataPrangko() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrangko();

        ProdukTM produkPrangkoTableModel = new ProdukTM();
        produkPrangkoTableModel.setDataProduk(arrayProduk);

        tablePrangko.setModel(produkPrangkoTableModel);
    }

    private void getDataMS_SS() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMS_SS();

        ProdukTM produkMS_SSTableModel = new ProdukTM();
        produkMS_SSTableModel.setDataProduk(arrayProduk);

        tableMSSS.setModel(produkMS_SSTableModel);
    }

    private void getDataSHP_SHPSS() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukSHP_SHPSS();

        ProdukTM produkSHP_SHPSSTableModel = new ProdukTM();
        produkSHP_SHPSSTableModel.setDataProduk(arrayProduk);

        tableSHPSHPSS.setModel(produkSHP_SHPSSTableModel);
    }

    private void getDataKemasan() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukKemasan();

        ProdukTM produkKemasanTableModel = new ProdukTM();
        produkKemasanTableModel.setDataProduk(arrayProduk);

        tableKemasan.setModel(produkKemasanTableModel);
    }

    private void getDataMerchandise() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMerchandise();

        ProdukTM produkMerchandiseTableModel = new ProdukTM();
        produkMerchandiseTableModel.setDataProduk(arrayProduk);

        tableMerchandise.setModel(produkMerchandiseTableModel);
    }

    private void getDataPrisma() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrisma();

        ProdukTM produkPrismaTableModel = new ProdukTM();
        produkPrismaTableModel.setDataProduk(arrayProduk);

        tablePrisma.setModel(produkPrismaTableModel);
    }

    private void getDataDokumenFilateli() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukDokumenFilateli();

        ProdukTM produkDokumenFilateliTableModel = new ProdukTM();
        produkDokumenFilateliTableModel.setDataProduk(arrayProduk);

        tableDokumenFilateli.setModel(produkDokumenFilateliTableModel);
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
        jPanel2 = new javax.swing.JPanel();
        buttonKelolaProduk = new javax.swing.JButton();
        buttonTransaksi = new javax.swing.JButton();
        labelKelolaProduk = new javax.swing.JLabel();
        labelTransaksi = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tabKelolaProduk = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Prangko = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        fieldKodeProdukPrangko = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldNamaProdukPrangko = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldNominalPrangko = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldTahunPrangko = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldBiayaCetakPrangko = new javax.swing.JTextField();
        buttonSimpanPrangko = new javax.swing.JButton();
        buttonUbahPrangko = new javax.swing.JButton();
        buttonHapusPrangko = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrangko = new javax.swing.JTable();
        buttonCariPrangko = new javax.swing.JButton();
        fieldCariPrangko = new javax.swing.JTextField();
        comboCariPrangko = new javax.swing.JComboBox<String>();
        MS_SS = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        fieldKodeProdukMS_SS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        fieldNamaProdukMSSS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        fieldNominalProdukMSSS = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fieldTahunProdukMSSS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldBiayaCetakProdukMSSS = new javax.swing.JTextField();
        buttonSimpanMSSS = new javax.swing.JButton();
        buttonUbahMSSS = new javax.swing.JButton();
        buttonHapusMSSS = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        ComboJenisMS_SS = new javax.swing.JComboBox<String>();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMSSS = new javax.swing.JTable();
        buttonCariMS_SS = new javax.swing.JButton();
        fieldCariMS_SS = new javax.swing.JTextField();
        comboMS_SS = new javax.swing.JComboBox<String>();
        SHP_SHPSS = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        fieldKodeProdukSHP_SHPSS = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        fieldNamaProdukSHPSHPSS = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        fieldNominalProdukSHPSHPSS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fieldTahunProdukSHPSHPSS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fieldBiayaCetakSHPSHPSS = new javax.swing.JTextField();
        buttonSimpanSHPSHPSS = new javax.swing.JButton();
        buttonUbahSHPSHPSS = new javax.swing.JButton();
        buttonHapusSHPSHPSS = new javax.swing.JButton();
        ComboJenisSHP_SHPSS = new javax.swing.JComboBox<String>();
        jLabel10 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSHPSHPSS = new javax.swing.JTable();
        buttonCariSHP_SHPSS = new javax.swing.JButton();
        fieldCariSHP_SHPSS = new javax.swing.JTextField();
        comboSHP_SHPSS = new javax.swing.JComboBox<String>();
        Kemasan = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        fieldKodeProdukKemasan = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        fieldNamaProdukKemasan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        fieldNominalProdukKemasan = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fieldTahunProdukKemasan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        fieldBiayaCetakProdukKemasan = new javax.swing.JTextField();
        buttonSImpanKemasan = new javax.swing.JButton();
        buttonUbahKemasan = new javax.swing.JButton();
        buttonHapusKemasan = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKemasan = new javax.swing.JTable();
        buttonCariKemasan = new javax.swing.JButton();
        fieldCariKemasan = new javax.swing.JTextField();
        comboJenisKemasan = new javax.swing.JComboBox<String>();
        Merchandise = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        fieldKodeProdukMerchandise = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        fieldNamaProdukMerchandise = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        fieldNominalProdukMerchandise = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        fieldTahunProdukMerchandise = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        fieldBiayaCetakProdukMerchandise = new javax.swing.JTextField();
        buttonSImpanMerchandise = new javax.swing.JButton();
        buttonUbahMerchandise = new javax.swing.JButton();
        buttonHapusMerchandise = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableMerchandise = new javax.swing.JTable();
        buttonCariMerchandise = new javax.swing.JButton();
        fieldCariMerchandise = new javax.swing.JTextField();
        comboMerchandise = new javax.swing.JComboBox<String>();
        Prisma = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        fieldKodeProdukPrisma = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        fieldNamaProdukPrisma = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        fieldNominalProdukPrisma = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        fieldTahunProdukPrisma = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        fieldBiayaCetakProdukPrisma = new javax.swing.JTextField();
        buttonSimpanPrisma = new javax.swing.JButton();
        buttonUbahPrisma = new javax.swing.JButton();
        buttonHapusPrisma = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePrisma = new javax.swing.JTable();
        buttonCariPrisma = new javax.swing.JButton();
        fieldCariPrisma = new javax.swing.JTextField();
        comboPrisma = new javax.swing.JComboBox<String>();
        DokumenFilateli = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        fieldKodeProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        fieldNamaProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        fieldNominalProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        fieldTahunProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        fieldBiayaCetakDokumenFilateli = new javax.swing.JTextField();
        buttonSimpanDokumenFIlateli = new javax.swing.JButton();
        buttonUbahDokumenFilateli = new javax.swing.JButton();
        buttonHapusDokumenFilateli = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableDokumenFilateli = new javax.swing.JTable();
        buttonCariDokumenFilateli = new javax.swing.JButton();
        fieldCariDokumenFIlateli = new javax.swing.JTextField();
        comboDokumenFIlateli = new javax.swing.JComboBox<String>();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        fieldNamaProdukPenerimaan = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-kecil.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        buttonKelolaProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Untitled-1.png"))); // NOI18N
        buttonKelolaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelolaProdukActionPerformed(evt);
            }
        });

        buttonTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Untitled-2.png"))); // NOI18N
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });

        labelKelolaProduk.setText("Kelola Produk");

        labelTransaksi.setText("Transaksi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buttonKelolaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(labelKelolaProduk))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(labelTransaksi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(buttonKelolaProduk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelKelolaProduk)
                .addGap(13, 13, 13)
                .addComponent(buttonTransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTransaksi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel2.setText("Kode Produk");

        fieldKodeProdukPrangko.setEditable(false);
        fieldKodeProdukPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeProdukPrangkoActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Produk");

        fieldNamaProdukPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPrangkoKeyPressed(evt);
            }
        });

        jLabel4.setText("Nominal");

        fieldNominalPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalPrangkoKeyPressed(evt);
            }
        });

        jLabel5.setText("Biaya Cetak  ");

        fieldTahunPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunPrangkoKeyPressed(evt);
            }
        });

        jLabel6.setText("Tahun");

        fieldBiayaCetakPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakPrangkoKeyPressed(evt);
            }
        });

        buttonSimpanPrangko.setText("Simpan");
        buttonSimpanPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPrangkoActionPerformed(evt);
            }
        });

        buttonUbahPrangko.setText("Ubah");
        buttonUbahPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahPrangkoActionPerformed(evt);
            }
        });

        buttonHapusPrangko.setText("Hapus");
        buttonHapusPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalPrangko)
                    .addComponent(fieldBiayaCetakPrangko)
                    .addComponent(fieldTahunPrangko, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukPrangko))
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSimpanPrangko, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahPrangko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusPrangko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldKodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpanPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNamaProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldNominalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldBiayaCetakPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldTahunPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrangkoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePrangko);

        buttonCariPrangko.setText("Cari");

        comboCariPrangko.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko)
                    .addComponent(fieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PrangkoLayout = new javax.swing.GroupLayout(Prangko);
        Prangko.setLayout(PrangkoLayout);
        PrangkoLayout.setHorizontalGroup(
            PrangkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrangkoLayout.setVerticalGroup(
            PrangkoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrangkoLayout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prangko", Prangko);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel12.setText("Kode Produk");

        fieldKodeProdukMS_SS.setEditable(false);

        jLabel13.setText("Nama Produk");

        fieldNamaProdukMSSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukMSSSKeyPressed(evt);
            }
        });

        jLabel14.setText("Nominal");

        fieldNominalProdukMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNominalProdukMSSSActionPerformed(evt);
            }
        });
        fieldNominalProdukMSSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukMSSSKeyPressed(evt);
            }
        });

        jLabel15.setText("Biaya Cetak  ");

        fieldTahunProdukMSSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMSSSKeyPressed(evt);
            }
        });

        jLabel16.setText("Tahun");

        fieldBiayaCetakProdukMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBiayaCetakProdukMSSSActionPerformed(evt);
            }
        });
        fieldBiayaCetakProdukMSSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukMSSSKeyPressed(evt);
            }
        });

        buttonSimpanMSSS.setText("Simpan");
        buttonSimpanMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanMSSSActionPerformed(evt);
            }
        });

        buttonUbahMSSS.setText("Ubah");
        buttonUbahMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahMSSSActionPerformed(evt);
            }
        });

        buttonHapusMSSS.setText("Hapus");
        buttonHapusMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusMSSSActionPerformed(evt);
            }
        });

        jLabel8.setText("Jenis");

        ComboJenisMS_SS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MS", "SS" }));
        ComboJenisMS_SS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboJenisMS_SSMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ComboJenisMS_SSMousePressed(evt);
            }
        });
        ComboJenisMS_SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJenisMS_SSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(ComboJenisMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNominalProdukMSSS)
                    .addComponent(fieldBiayaCetakProdukMSSS)
                    .addComponent(fieldTahunProdukMSSS, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldNamaProdukMSSS))
                .addGap(18, 18, 18)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSimpanMSSS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahMSSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusMSSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpanMSSS)
                    .addComponent(jLabel8)
                    .addComponent(ComboJenisMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fieldNamaProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahMSSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fieldNominalProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusMSSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fieldBiayaCetakProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fieldTahunProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tableMSSS.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMSSSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMSSS);

        buttonCariMS_SS.setText("Cari");

        comboMS_SS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariMS_SS))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariMS_SS)
                    .addComponent(fieldCariMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SSLayout = new javax.swing.GroupLayout(MS_SS);
        MS_SS.setLayout(MS_SSLayout);
        MS_SSLayout.setHorizontalGroup(
            MS_SSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MS_SSLayout.setVerticalGroup(
            MS_SSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MS_SSLayout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("MS & SS", MS_SS);

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel17.setText("Kode Produk");

        fieldKodeProdukSHP_SHPSS.setEditable(false);

        jLabel18.setText("Nama Produk");

        fieldNamaProdukSHPSHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukSHPSHPSSKeyPressed(evt);
            }
        });

        jLabel19.setText("Nominal");

        fieldNominalProdukSHPSHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukSHPSHPSSKeyPressed(evt);
            }
        });

        jLabel20.setText("Biaya Cetak  ");

        jLabel21.setText("Tahun");

        fieldBiayaCetakSHPSHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakSHPSHPSSKeyPressed(evt);
            }
        });

        buttonSimpanSHPSHPSS.setText("Simpan");
        buttonSimpanSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanSHPSHPSSActionPerformed(evt);
            }
        });

        buttonUbahSHPSHPSS.setText("Ubah");
        buttonUbahSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahSHPSHPSSActionPerformed(evt);
            }
        });

        buttonHapusSHPSHPSS.setText("Hapus");
        buttonHapusSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusSHPSHPSSActionPerformed(evt);
            }
        });

        ComboJenisSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SHP", "SHPSS" }));
        ComboJenisSHP_SHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboJenisSHP_SHPSSMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ComboJenisSHP_SHPSSMousePressed(evt);
            }
        });
        ComboJenisSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboJenisSHP_SHPSSActionPerformed(evt);
            }
        });

        jLabel10.setText("Jenis");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNominalProdukSHPSHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                            .addComponent(fieldBiayaCetakSHPSHPSS)
                            .addComponent(fieldTahunProdukSHPSHPSS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldNamaProdukSHPSHPSS))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(ComboJenisSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSimpanSHPSHPSS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahSHPSHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusSHPSHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(ComboJenisSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonSimpanSHPSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fieldNamaProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahSHPSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fieldNominalProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusSHPSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fieldBiayaCetakSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(fieldTahunProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tableSHPSHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSHPSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSHPSHPSSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSHPSHPSS);

        buttonCariSHP_SHPSS.setText("Cari");

        comboSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariSHP_SHPSS))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariSHP_SHPSS)
                    .addComponent(fieldCariSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSSLayout = new javax.swing.GroupLayout(SHP_SHPSS);
        SHP_SHPSS.setLayout(SHP_SHPSSLayout);
        SHP_SHPSSLayout.setHorizontalGroup(
            SHP_SHPSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SHP_SHPSSLayout.setVerticalGroup(
            SHP_SHPSSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SHP_SHPSSLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("SHP & SHPSS", SHP_SHPSS);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel22.setText("Kode Produk");

        fieldKodeProdukKemasan.setEditable(false);

        jLabel23.setText("Nama Produk");

        fieldNamaProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukKemasanKeyPressed(evt);
            }
        });

        jLabel24.setText("Nominal");

        fieldNominalProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukKemasanKeyPressed(evt);
            }
        });

        jLabel25.setText("Biaya Cetak  ");

        fieldTahunProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukKemasanKeyPressed(evt);
            }
        });

        jLabel26.setText("Tahun");

        fieldBiayaCetakProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukKemasanKeyPressed(evt);
            }
        });

        buttonSImpanKemasan.setText("Simpan");
        buttonSImpanKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSImpanKemasanActionPerformed(evt);
            }
        });

        buttonUbahKemasan.setText("Ubah");
        buttonUbahKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahKemasanActionPerformed(evt);
            }
        });

        buttonHapusKemasan.setText("Hapus");
        buttonHapusKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22)
                    .addComponent(jLabel24)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalProdukKemasan)
                    .addComponent(fieldBiayaCetakProdukKemasan)
                    .addComponent(fieldTahunProdukKemasan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukKemasan))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSImpanKemasan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahKemasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusKemasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSImpanKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(fieldNamaProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(fieldNominalProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(fieldBiayaCetakProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(fieldTahunProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tableKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        tableKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKemasanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableKemasan);

        buttonCariKemasan.setText("Cari");

        comboJenisKemasan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboJenisKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariKemasan))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariKemasan)
                    .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJenisKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout KemasanLayout = new javax.swing.GroupLayout(Kemasan);
        Kemasan.setLayout(KemasanLayout);
        KemasanLayout.setHorizontalGroup(
            KemasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        KemasanLayout.setVerticalGroup(
            KemasanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KemasanLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kemasan", Kemasan);

        jPanel22.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel27.setText("Kode Produk");

        fieldKodeProdukMerchandise.setEditable(false);

        jLabel28.setText("Nama Produk");

        fieldNamaProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukMerchandiseKeyPressed(evt);
            }
        });

        jLabel29.setText("Nominal");

        fieldNominalProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukMerchandiseKeyPressed(evt);
            }
        });

        jLabel30.setText("Biaya Cetak  ");

        fieldTahunProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMerchandiseKeyPressed(evt);
            }
        });

        jLabel31.setText("Tahun");

        fieldBiayaCetakProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukMerchandiseKeyPressed(evt);
            }
        });

        buttonSImpanMerchandise.setText("Simpan");
        buttonSImpanMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSImpanMerchandiseActionPerformed(evt);
            }
        });

        buttonUbahMerchandise.setText("Ubah");
        buttonUbahMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahMerchandiseActionPerformed(evt);
            }
        });

        buttonHapusMerchandise.setText("Hapus");
        buttonHapusMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(jLabel27)
                    .addComponent(jLabel29)
                    .addComponent(jLabel30)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalProdukMerchandise)
                    .addComponent(fieldBiayaCetakProdukMerchandise)
                    .addComponent(fieldTahunProdukMerchandise, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukMerchandise))
                .addGap(18, 18, 18)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSImpanMerchandise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSImpanMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(fieldNamaProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(fieldNominalProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(fieldBiayaCetakProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(fieldTahunProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tableMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        tableMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableMerchandise);

        buttonCariMerchandise.setText("Cari");

        comboMerchandise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariMerchandise))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariMerchandise)
                    .addComponent(fieldCariMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MerchandiseLayout = new javax.swing.GroupLayout(Merchandise);
        Merchandise.setLayout(MerchandiseLayout);
        MerchandiseLayout.setHorizontalGroup(
            MerchandiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MerchandiseLayout.setVerticalGroup(
            MerchandiseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MerchandiseLayout.createSequentialGroup()
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Merchandise", Merchandise);

        jPanel24.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel32.setText("Kode Produk");

        fieldKodeProdukPrisma.setEditable(false);

        jLabel33.setText("Nama Produk");

        fieldNamaProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPrismaKeyPressed(evt);
            }
        });

        jLabel34.setText("Nominal");

        fieldNominalProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukPrismaKeyPressed(evt);
            }
        });

        jLabel35.setText("Biaya Cetak  ");

        fieldTahunProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukPrismaKeyPressed(evt);
            }
        });

        jLabel36.setText("Tahun");

        fieldBiayaCetakProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukPrismaKeyPressed(evt);
            }
        });

        buttonSimpanPrisma.setText("Simpan");
        buttonSimpanPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPrismaActionPerformed(evt);
            }
        });

        buttonUbahPrisma.setText("Ubah");
        buttonUbahPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahPrismaActionPerformed(evt);
            }
        });

        buttonHapusPrisma.setText("Hapus");
        buttonHapusPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusPrismaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addComponent(jLabel32)
                    .addComponent(jLabel34)
                    .addComponent(jLabel35)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalProdukPrisma)
                    .addComponent(fieldBiayaCetakProdukPrisma)
                    .addComponent(fieldTahunProdukPrisma, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukPrisma))
                .addGap(18, 18, 18)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSimpanPrisma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpanPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(fieldNamaProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(fieldNominalProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(fieldBiayaCetakProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(fieldTahunProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel25.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrismaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablePrisma);

        buttonCariPrisma.setText("Cari");

        comboPrisma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrisma))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrisma)
                    .addComponent(fieldCariPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PrismaLayout = new javax.swing.GroupLayout(Prisma);
        Prisma.setLayout(PrismaLayout);
        PrismaLayout.setHorizontalGroup(
            PrismaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrismaLayout.setVerticalGroup(
            PrismaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrismaLayout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prisma", Prisma);

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));

        jLabel37.setText("Kode Produk");

        fieldKodeProdukDokumenFilateli.setEditable(false);

        jLabel38.setText("Nama Produk");

        fieldNamaProdukDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukDokumenFilateliKeyPressed(evt);
            }
        });

        jLabel39.setText("Nominal");

        fieldNominalProdukDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalProdukDokumenFilateliKeyPressed(evt);
            }
        });

        jLabel40.setText("Biaya Cetak  ");

        fieldTahunProdukDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukDokumenFilateliKeyPressed(evt);
            }
        });

        jLabel41.setText("Tahun");

        fieldBiayaCetakDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakDokumenFilateliKeyPressed(evt);
            }
        });

        buttonSimpanDokumenFIlateli.setText("Simpan");
        buttonSimpanDokumenFIlateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDokumenFIlateliActionPerformed(evt);
            }
        });

        buttonUbahDokumenFilateli.setText("Ubah");
        buttonUbahDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahDokumenFilateliActionPerformed(evt);
            }
        });

        buttonHapusDokumenFilateli.setText("Hapus");
        buttonHapusDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDokumenFilateliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(jLabel37)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalProdukDokumenFilateli)
                    .addComponent(fieldBiayaCetakDokumenFilateli)
                    .addComponent(fieldTahunProdukDokumenFilateli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukDokumenFilateli))
                .addGap(18, 18, 18)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonSimpanDokumenFIlateli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonUbahDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonHapusDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSimpanDokumenFIlateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(fieldNamaProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbahDokumenFilateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(fieldNominalProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapusDokumenFilateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(fieldBiayaCetakDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(fieldTahunProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel27.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tableDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        tableDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableDokumenFilateli);

        buttonCariDokumenFilateli.setText("Cari");

        comboDokumenFIlateli.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariDokumenFilateli))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariDokumenFilateli)
                    .addComponent(fieldCariDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateliLayout = new javax.swing.GroupLayout(DokumenFilateli);
        DokumenFilateli.setLayout(DokumenFilateliLayout);
        DokumenFilateliLayout.setHorizontalGroup(
            DokumenFilateliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DokumenFilateliLayout.setVerticalGroup(
            DokumenFilateliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DokumenFilateliLayout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dokumen Filateli", DokumenFilateli);

        javax.swing.GroupLayout tabKelolaProdukLayout = new javax.swing.GroupLayout(tabKelolaProduk);
        tabKelolaProduk.setLayout(tabKelolaProdukLayout);
        tabKelolaProdukLayout.setHorizontalGroup(
            tabKelolaProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        tabKelolaProdukLayout.setVerticalGroup(
            tabKelolaProdukLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Penerimaan"));

        jLabel7.setText("Jenis Produk");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Nama Produk");

        fieldNamaProdukPenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNamaProdukPenerimaanActionPerformed(evt);
            }
        });

        jButton7.setText("Cari");

        jLabel42.setText("Nama Suplier");

        jButton8.setText("Cari");

        jButton9.setText("Simpan");

        jButton34.setText("Ubah");

        jButton35.setText("Hapus");

        jLabel44.setText("Tanggal Penerimaan");

        jLabel9.setText("Jumlah");

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel44)
                            .addComponent(jLabel9))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNamaProdukPenerimaan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                                        .addComponent(jButton9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton8)
                                    .addComponent(jButton7))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fieldNamaProdukPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(7, 7, 7)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel44)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton34)
                    .addComponent(jButton35)))
        );

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Penerimaan"));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Penerimaan", jPanel15);

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Pengembalian", jPanel28);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 672, Short.MAX_VALUE)
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Pengeluaran", jPanel29);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel32.setBackground(new java.awt.Color(0, 102, 51));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabKelolaProduk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();

        jPanel3.add(jPanel5);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_buttonTransaksiActionPerformed

    private void buttonKelolaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKelolaProdukActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();

        jPanel3.add(tabKelolaProduk);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_buttonKelolaProdukActionPerformed

    private void fieldNamaProdukPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNamaProdukPenerimaanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaProdukPenerimaanActionPerformed

    private void buttonSimpanPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanPrangkoActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukPrangko.getText();
        String namaProduk = fieldNamaProdukPrangko.getText();
        int nominal = Integer.parseInt(fieldNominalPrangko.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakPrangko.getText());
        String tahun = fieldTahunPrangko.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        String jenisProduk = "PR";

        //insert produk
        ProdukDAO dao = new ProdukDAOImpl();
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataPrangko();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }

    }//GEN-LAST:event_buttonSimpanPrangkoActionPerformed

    private void buttonHapusPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusPrangkoActionPerformed
        // TODO add your handling code here:
        int baris = tablePrangko.getSelectedRow();
        String kodeProduk = tablePrangko.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataPrangko();
        }
    }//GEN-LAST:event_buttonHapusPrangkoActionPerformed

    private void buttonUbahPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahPrangkoActionPerformed
        // TODO add your handling code here:
        int baris = tablePrangko.getSelectedRow();
        String kodeProduk = tablePrangko.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukPrangko.getText();
            String namaProduk = fieldNamaProdukPrangko.getText();
            int nominal = Integer.parseInt(fieldNominalPrangko.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakPrangko.getText());
            String tahun = fieldTahunPrangko.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukPrangko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukPrangko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalPrangko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakPrangko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunPrangko.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataPrangko();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataPrangko();
            }
            getDataPrangko();
        }
    }//GEN-LAST:event_buttonUbahPrangkoActionPerformed

    private void tablePrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrangkoMouseClicked
        // TODO add your handling code here:
        int baris = tablePrangko.getSelectedRow();
        String kodeProduk = tablePrangko.getValueAt(baris, 0).toString();
        String namaProduk = tablePrangko.getValueAt(baris, 1).toString();
        String nominal = tablePrangko.getValueAt(baris, 2).toString();
        String biayaCetak = tablePrangko.getValueAt(baris, 3).toString();
        String tahun = tablePrangko.getValueAt(baris, 5).toString();

        fieldKodeProdukPrangko.setText(kodeProduk);
        fieldNamaProdukPrangko.setText(namaProduk);
        fieldNominalPrangko.setText(nominal);
        fieldBiayaCetakPrangko.setText(biayaCetak);
        fieldTahunPrangko.setText(tahun);
    }//GEN-LAST:event_tablePrangkoMouseClicked

    private void ComboJenisMS_SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJenisMS_SSActionPerformed
        // TODO add your handling code here:
        autoincrementMS_SS();
    }//GEN-LAST:event_ComboJenisMS_SSActionPerformed

    private void ComboJenisMS_SSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboJenisMS_SSMouseClicked

    }//GEN-LAST:event_ComboJenisMS_SSMouseClicked

    private void ComboJenisMS_SSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboJenisMS_SSMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboJenisMS_SSMousePressed

    private void ComboJenisSHP_SHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboJenisSHP_SHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboJenisSHP_SHPSSMouseClicked

    private void ComboJenisSHP_SHPSSMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboJenisSHP_SHPSSMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboJenisSHP_SHPSSMousePressed

    private void ComboJenisSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboJenisSHP_SHPSSActionPerformed
        // TODO add your handling code here:
        autoincrementSHP_SHPSS();
    }//GEN-LAST:event_ComboJenisSHP_SHPSSActionPerformed

    private void fieldNominalProdukSHPSHPSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukSHPSHPSSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakSHPSHPSS.requestFocus();
        }

    }//GEN-LAST:event_fieldNominalProdukSHPSHPSSKeyPressed

    private void fieldKodeProdukPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeProdukPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeProdukPrangkoActionPerformed

    private void tableMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMSSSMouseClicked
        // TODO add your handling code here:
        int baris = tableMSSS.getSelectedRow();
        String kodeProduk = tableMSSS.getValueAt(baris, 0).toString();
        String namaProduk = tableMSSS.getValueAt(baris, 1).toString();
        String nominal = tableMSSS.getValueAt(baris, 2).toString();
        String biayaCetak = tableMSSS.getValueAt(baris, 3).toString();
        String tahun = tableMSSS.getValueAt(baris, 5).toString();

        fieldKodeProdukMS_SS.setText(kodeProduk);
        fieldNamaProdukMSSS.setText(namaProduk);
        fieldNominalProdukMSSS.setText(nominal);
        fieldBiayaCetakProdukMSSS.setText(biayaCetak);
        fieldTahunProdukMSSS.setText(tahun);
    }//GEN-LAST:event_tableMSSSMouseClicked

    private void tableSHPSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSHPSHPSSMouseClicked
        // TODO add your handling code here:
        int baris = tableSHPSHPSS.getSelectedRow();
        String kodeProduk = tableSHPSHPSS.getValueAt(baris, 0).toString();
        String namaProduk = tableSHPSHPSS.getValueAt(baris, 1).toString();
        String nominal = tableSHPSHPSS.getValueAt(baris, 2).toString();
        String biayaCetak = tableSHPSHPSS.getValueAt(baris, 3).toString();
        String tahun = tableSHPSHPSS.getValueAt(baris, 5).toString();

        fieldKodeProdukSHP_SHPSS.setText(kodeProduk);
        fieldNamaProdukSHPSHPSS.setText(namaProduk);
        fieldNominalProdukSHPSHPSS.setText(nominal);
        fieldBiayaCetakSHPSHPSS.setText(biayaCetak);
        fieldTahunProdukSHPSHPSS.setText(tahun);

    }//GEN-LAST:event_tableSHPSHPSSMouseClicked

    private void tableKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKemasanMouseClicked
        // TODO add your handling code here:
        int baris = tableKemasan.getSelectedRow();
        String kodeProduk = tableKemasan.getValueAt(baris, 0).toString();
        String namaProduk = tableKemasan.getValueAt(baris, 1).toString();
        String nominal = tableKemasan.getValueAt(baris, 2).toString();
        String biayaCetak = tableKemasan.getValueAt(baris, 3).toString();
        String tahun = tableKemasan.getValueAt(baris, 5).toString();

        fieldKodeProdukKemasan.setText(kodeProduk);
        fieldNamaProdukKemasan.setText(namaProduk);
        fieldNominalProdukKemasan.setText(nominal);
        fieldBiayaCetakProdukKemasan.setText(biayaCetak);
        fieldTahunProdukKemasan.setText(tahun);
    }//GEN-LAST:event_tableKemasanMouseClicked

    private void tableMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMerchandiseMouseClicked
        // TODO add your handling code here:
        int baris = tableMerchandise.getSelectedRow();
        String kodeProduk = tableMerchandise.getValueAt(baris, 0).toString();
        String namaProduk = tableMerchandise.getValueAt(baris, 1).toString();
        String nominal = tableMerchandise.getValueAt(baris, 2).toString();
        String biayaCetak = tableMerchandise.getValueAt(baris, 3).toString();
        String tahun = tableMerchandise.getValueAt(baris, 5).toString();

        fieldKodeProdukMerchandise.setText(kodeProduk);
        fieldNamaProdukMerchandise.setText(namaProduk);
        fieldNominalProdukMerchandise.setText(nominal);
        fieldBiayaCetakProdukMerchandise.setText(biayaCetak);
        fieldTahunProdukMerchandise.setText(tahun);
    }//GEN-LAST:event_tableMerchandiseMouseClicked

    private void tablePrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrismaMouseClicked
        // TODO add your handling code here:
        int baris = tablePrisma.getSelectedRow();
        String kodeProduk = tablePrisma.getValueAt(baris, 0).toString();
        String namaProduk = tablePrisma.getValueAt(baris, 1).toString();
        String nominal = tablePrisma.getValueAt(baris, 2).toString();
        String biayaCetak = tablePrisma.getValueAt(baris, 3).toString();
        String tahun = tablePrisma.getValueAt(baris, 5).toString();

        fieldKodeProdukPrisma.setText(kodeProduk);
        fieldNamaProdukPrisma.setText(namaProduk);
        fieldNominalProdukPrisma.setText(nominal);
        fieldBiayaCetakProdukPrisma.setText(biayaCetak);
        fieldTahunProdukPrisma.setText(tahun);
    }//GEN-LAST:event_tablePrismaMouseClicked

    private void tableDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDokumenFilateliMouseClicked
        // TODO add your handling code here:
        int baris = tableDokumenFilateli.getSelectedRow();
        String kodeProduk = tableDokumenFilateli.getValueAt(baris, 0).toString();
        String namaProduk = tableDokumenFilateli.getValueAt(baris, 1).toString();
        String nominal = tableDokumenFilateli.getValueAt(baris, 2).toString();
        String biayaCetak = tableDokumenFilateli.getValueAt(baris, 3).toString();
        String tahun = tableDokumenFilateli.getValueAt(baris, 5).toString();

        fieldKodeProdukDokumenFilateli.setText(kodeProduk);
        fieldNamaProdukDokumenFilateli.setText(namaProduk);
        fieldNominalProdukDokumenFilateli.setText(nominal);
        fieldBiayaCetakDokumenFilateli.setText(biayaCetak);
        fieldTahunProdukDokumenFilateli.setText(tahun);
    }//GEN-LAST:event_tableDokumenFilateliMouseClicked

    private void buttonSimpanMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanMSSSActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukMS_SS.getText();
        String namaProduk = fieldNamaProdukMSSS.getText();
        int nominal = Integer.parseInt(fieldNominalProdukMSSS.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukMSSS.getText());
        String tahun = fieldTahunProdukMSSS.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukMS_SS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        Object jenisMS_SS = ComboJenisMS_SS.getSelectedItem();
        String kosong = null;
        String jenisProduk = null;

        //insert produk
        ProdukDAO dao = new ProdukDAOImpl();
        if (jenisMS_SS == "MS") {
            jenisProduk = "MS";
            //Tambahkan pilihan item untuk buah

        } else if (jenisMS_SS == "SS") {
            jenisProduk = "SS";
        }
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataMS_SS();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }

    }//GEN-LAST:event_buttonSimpanMSSSActionPerformed

    private void fieldNamaProdukMSSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukMSSSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukMSSS.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukMSSSKeyPressed

    private void fieldNominalProdukMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNominalProdukMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNominalProdukMSSSActionPerformed

    private void fieldNominalProdukMSSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukMSSSKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakProdukMSSS.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalProdukMSSSKeyPressed

    private void fieldTahunProdukMSSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukMSSSKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_fieldTahunProdukMSSSKeyPressed

    private void buttonHapusMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusMSSSActionPerformed
        // TODO add your handling code here:
        int baris = tableMSSS.getSelectedRow();
        String kodeProduk = tableMSSS.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataMS_SS();
        }
    }//GEN-LAST:event_buttonHapusMSSSActionPerformed

    private void buttonUbahMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahMSSSActionPerformed
        // TODO add your handling code here:
        int baris = tableMSSS.getSelectedRow();
        String kodeProduk = tableMSSS.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukMS_SS.getText();
            String namaProduk = fieldNamaProdukMSSS.getText();
            int nominal = Integer.parseInt(fieldNominalProdukMSSS.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukMSSS.getText());
            String tahun = fieldTahunProdukMSSS.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukMS_SS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukMSSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukMSSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakProdukMSSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukMSSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataMS_SS();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataMS_SS();
            }
            getDataMS_SS();
        }
    }//GEN-LAST:event_buttonUbahMSSSActionPerformed

    private void fieldBiayaCetakProdukMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBiayaCetakProdukMSSSActionPerformed

    private void fieldBiayaCetakProdukMSSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukMSSSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukMSSS.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukMSSSKeyPressed

    private void fieldNamaProdukSHPSHPSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukSHPSHPSSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukSHPSHPSS.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukSHPSHPSSKeyPressed

    private void fieldBiayaCetakSHPSHPSSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakSHPSHPSSKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukSHPSHPSS.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakSHPSHPSSKeyPressed

    private void buttonSimpanSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanSHPSHPSSActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukSHP_SHPSS.getText();
        String namaProduk = fieldNamaProdukSHPSHPSS.getText();
        int nominal = Integer.parseInt(fieldNominalProdukSHPSHPSS.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakSHPSHPSS.getText());
        String tahun = fieldTahunProdukSHPSHPSS.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukSHP_SHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        Object jenisSHP_SHPSS = ComboJenisMS_SS.getSelectedItem();
        String kosong = null;
        String jenisProduk = null;

        //insert produk
        ProdukDAO dao = new ProdukDAOImpl();
        if (jenisSHP_SHPSS == "SHP") {
            jenisProduk = "SHP";
            //Tambahkan pilihan item untuk buah

        } else if (jenisSHP_SHPSS == "SHPSS") {
            jenisProduk = "SHPSS";
        }
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataSHP_SHPSS();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }

    }//GEN-LAST:event_buttonSimpanSHPSHPSSActionPerformed

    private void buttonUbahSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahSHPSHPSSActionPerformed
        // TODO add your handling code here:
        int baris = tableSHPSHPSS.getSelectedRow();
        String kodeProduk = tableSHPSHPSS.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukSHP_SHPSS.getText();
            String namaProduk = fieldNamaProdukSHPSHPSS.getText();
            int nominal = Integer.parseInt(fieldNominalProdukSHPSHPSS.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakSHPSHPSS.getText());
            String tahun = fieldTahunProdukSHPSHPSS.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukSHP_SHPSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukSHPSHPSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukSHPSHPSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakSHPSHPSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukSHPSHPSS.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataSHP_SHPSS();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataSHP_SHPSS();
            }
            getDataSHP_SHPSS();
        }
    }//GEN-LAST:event_buttonUbahSHPSHPSSActionPerformed

    private void buttonHapusSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusSHPSHPSSActionPerformed
        // TODO add your handling code here:
        int baris = tableSHPSHPSS.getSelectedRow();
        String kodeProduk = tableSHPSHPSS.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataSHP_SHPSS();
        }
    }//GEN-LAST:event_buttonHapusSHPSHPSSActionPerformed

    private void fieldNamaProdukKemasanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukKemasanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukKemasan.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukKemasanKeyPressed

    private void fieldNominalProdukKemasanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukKemasanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakProdukKemasan.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalProdukKemasanKeyPressed

    private void fieldBiayaCetakProdukKemasanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukKemasanKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukKemasan.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukKemasanKeyPressed

    private void fieldTahunProdukKemasanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukKemasanKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunProdukKemasanKeyPressed

    private void buttonSImpanKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSImpanKemasanActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukKemasan.getText();
        String namaProduk = fieldNamaProdukKemasan.getText();
        int nominal = Integer.parseInt(fieldNominalProdukKemasan.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukKemasan.getText());
        String tahun = fieldTahunProdukKemasan.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        String jenisProduk = "KM";

        ProdukDAO dao = new ProdukDAOImpl();
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataKemasan();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }
    }//GEN-LAST:event_buttonSImpanKemasanActionPerformed

    private void buttonUbahKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahKemasanActionPerformed
        // TODO add your handling code here:
        int baris = tableKemasan.getSelectedRow();
        String kodeProduk = tableKemasan.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukKemasan.getText();
            String namaProduk = fieldNamaProdukKemasan.getText();
            int nominal = Integer.parseInt(fieldNominalProdukKemasan.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukKemasan.getText());
            String tahun = fieldTahunProdukKemasan.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukKemasan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukKemasan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukKemasan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakProdukKemasan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukKemasan.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataKemasan();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataKemasan();
            }
            getDataKemasan();
        }
    }//GEN-LAST:event_buttonUbahKemasanActionPerformed

    private void buttonHapusKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusKemasanActionPerformed
        // TODO add your handling code here:
        int baris = tableKemasan.getSelectedRow();
        String kodeProduk = tableKemasan.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataKemasan();
        }
    }//GEN-LAST:event_buttonHapusKemasanActionPerformed

    private void fieldNamaProdukMerchandiseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukMerchandiseKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukMerchandise.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukMerchandiseKeyPressed

    private void fieldNominalProdukMerchandiseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukMerchandiseKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakProdukMerchandise.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalProdukMerchandiseKeyPressed

    private void fieldBiayaCetakProdukMerchandiseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukMerchandiseKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukMerchandise.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukMerchandiseKeyPressed

    private void fieldTahunProdukMerchandiseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukMerchandiseKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunProdukMerchandiseKeyPressed

    private void buttonSImpanMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSImpanMerchandiseActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukMerchandise.getText();
        String namaProduk = fieldNamaProdukMerchandise.getText();
        int nominal = Integer.parseInt(fieldNominalProdukMerchandise.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukMerchandise.getText());
        String tahun = fieldTahunProdukMerchandise.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        String jenisProduk = "MC";

        ProdukDAO dao = new ProdukDAOImpl();
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataMerchandise();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }
    }//GEN-LAST:event_buttonSImpanMerchandiseActionPerformed

    private void buttonUbahMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahMerchandiseActionPerformed
        // TODO add your handling code here:
        int baris = tableMerchandise.getSelectedRow();
        String kodeProduk = tableMerchandise.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukMerchandise.getText();
            String namaProduk = fieldNamaProdukMerchandise.getText();
            int nominal = Integer.parseInt(fieldNominalProdukMerchandise.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukMerchandise.getText());
            String tahun = fieldTahunProdukMerchandise.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukMerchandise.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukMerchandise.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukMerchandise.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakProdukMerchandise.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukMerchandise.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataMerchandise();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataMerchandise();
            }
            getDataMerchandise();
        }
    }//GEN-LAST:event_buttonUbahMerchandiseActionPerformed

    private void buttonHapusMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusMerchandiseActionPerformed
        // TODO add your handling code here:
        int baris = tableMerchandise.getSelectedRow();
        String kodeProduk = tableMerchandise.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataMerchandise();
        }

    }//GEN-LAST:event_buttonHapusMerchandiseActionPerformed

    private void fieldNamaProdukPrismaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukPrismaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukPrisma.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukPrismaKeyPressed

    private void fieldNominalProdukPrismaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukPrismaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakProdukPrisma.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalProdukPrismaKeyPressed

    private void fieldBiayaCetakProdukPrismaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukPrismaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukPrisma.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukPrismaKeyPressed

    private void fieldTahunProdukPrismaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukPrismaKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_fieldTahunProdukPrismaKeyPressed

    private void buttonSimpanPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanPrismaActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukPrisma.getText();
        String namaProduk = fieldNamaProdukPrisma.getText();
        int nominal = Integer.parseInt(fieldNominalProdukPrisma.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukPrisma.getText());
        String tahun = fieldTahunProdukPrisma.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        String jenisProduk = "PS";

        ProdukDAO dao = new ProdukDAOImpl();
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataPrisma();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }
    }//GEN-LAST:event_buttonSimpanPrismaActionPerformed

    private void buttonUbahPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahPrismaActionPerformed
        // TODO add your handling code here:
        int baris = tablePrisma.getSelectedRow();
        String kodeProduk = tablePrisma.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukPrisma.getText();
            String namaProduk = fieldNamaProdukPrisma.getText();
            int nominal = Integer.parseInt(fieldNominalProdukPrisma.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakProdukPrisma.getText());
            String tahun = fieldTahunProdukPrisma.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukPrisma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukPrisma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukPrisma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakProdukPrisma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukPrisma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataPrisma();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataPrisma();
            }
            getDataPrisma();
        }
    }//GEN-LAST:event_buttonUbahPrismaActionPerformed

    private void buttonHapusPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusPrismaActionPerformed
        // TODO add your handling code here:
        int baris = tablePrisma.getSelectedRow();
        String kodeProduk = tablePrisma.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataPrisma();
        }
    }//GEN-LAST:event_buttonHapusPrismaActionPerformed

    private void fieldNamaProdukDokumenFilateliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukDokumenFilateliKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldNominalProdukDokumenFilateli.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukDokumenFilateliKeyPressed

    private void fieldNominalProdukDokumenFilateliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukDokumenFilateliKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakDokumenFilateli.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalProdukDokumenFilateliKeyPressed

    private void fieldBiayaCetakDokumenFilateliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakDokumenFilateliKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldTahunProdukDokumenFilateli.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakDokumenFilateliKeyPressed

    private void fieldTahunProdukDokumenFilateliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukDokumenFilateliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunProdukDokumenFilateliKeyPressed

    private void buttonSimpanDokumenFIlateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanDokumenFIlateliActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukDokumenFilateli.getText();
        String namaProduk = fieldNamaProdukDokumenFilateli.getText();
        int nominal = Integer.parseInt(fieldNominalProdukDokumenFilateli.getText());
        float biayaCetak = Float.parseFloat(fieldBiayaCetakDokumenFilateli.getText());
        String tahun = fieldTahunProdukDokumenFilateli.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
        } else if (fieldNamaProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
        } else if (fieldNominalProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
        } else if (fieldBiayaCetakDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
        } else if (fieldTahunProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
        } else {
            JOptionPane.showMessageDialog(null, "Simpan Data");
        }

        //buat objek pegawai
        Produk produk = new Produk();
        produk.setIdProduk(idProduk);
        produk.setNamaProduk(namaProduk);
        produk.setNominal(nominal);
        produk.setBiayaCetak(biayaCetak);
        produk.setTahun(tahun);

        //inisialisasi
        String jenisProduk = "DF";

        ProdukDAO dao = new ProdukDAOImpl();
        boolean sukses = dao.tambahProduk(produk, jenisProduk);

        //cek sukses atau tidak
        if (sukses) {
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            getDataDokumenFilateli();
        } else {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
        }
    }//GEN-LAST:event_buttonSimpanDokumenFIlateliActionPerformed

    private void buttonUbahDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahDokumenFilateliActionPerformed
        // TODO add your handling code here:
        int baris = tableDokumenFilateli.getSelectedRow();
        String kodeProduk = tableDokumenFilateli.getValueAt(baris, 0).toString();

        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin Mengubah Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String idProduk = fieldKodeProdukDokumenFilateli.getText();
            String namaProduk = fieldNamaProdukDokumenFilateli.getText();
            int nominal = Integer.parseInt(fieldNominalProdukDokumenFilateli.getText());
            float biayaCetak = Float.parseFloat(fieldBiayaCetakDokumenFilateli.getText());
            String tahun = fieldTahunProdukDokumenFilateli.getText();

            //validasi apakah filed 
            //sudah diisi atau belum
            if (fieldKodeProdukDokumenFilateli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            } else if (fieldNamaProdukDokumenFilateli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            } else if (fieldNominalProdukDokumenFilateli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            } else if (fieldBiayaCetakDokumenFilateli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            } else if (fieldTahunProdukDokumenFilateli.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            } else {
                JOptionPane.showMessageDialog(null, "Simpan Data");
            }

            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(nominal);
            produk.setBiayaCetak(biayaCetak);
            produk.setTahun(tahun);

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.ubahProduk(produk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                getDataDokumenFilateli();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal diubah");
                getDataDokumenFilateli();
            }
            getDataDokumenFilateli();
        }
    }//GEN-LAST:event_buttonUbahDokumenFilateliActionPerformed

    private void buttonHapusDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDokumenFilateliActionPerformed
        // TODO add your handling code here:
        int baris = tableDokumenFilateli.getSelectedRow();
        String kodeProduk = tableDokumenFilateli.getValueAt(baris, 0).toString();
        int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus Produk dengan kode : " + kodeProduk + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {

            dao = new ProdukDAOImpl();
            dao.hapusProduk(kodeProduk);
            //panggil method koneksi
            JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
            getDataDokumenFilateli();
        }
    }//GEN-LAST:event_buttonHapusDokumenFilateliActionPerformed

    private void fieldNamaProdukPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukPrangkoKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             fieldNominalPrangko.requestFocus();
        }
    }//GEN-LAST:event_fieldNamaProdukPrangkoKeyPressed

    private void fieldNominalPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalPrangkoKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            fieldBiayaCetakPrangko.requestFocus();
        }
    }//GEN-LAST:event_fieldNominalPrangkoKeyPressed

    private void fieldBiayaCetakPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakPrangkoKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
             fieldTahunPrangko.requestFocus();
        }
    }//GEN-LAST:event_fieldBiayaCetakPrangkoKeyPressed

    private void fieldTahunPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunPrangkoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunPrangkoKeyPressed

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
            java.util.logging.Logger.getLogger(FormHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            com.jtattoo.plaf.noire.NoireLookAndFeel.setTheme("Large-Font", "Java Swing", "");
            UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
            new FormHome();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormHome fh = new FormHome();
                //fh.setLocationRelativeTo(null);
                fh.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboJenisMS_SS;
    private javax.swing.JComboBox<String> ComboJenisSHP_SHPSS;
    private javax.swing.JPanel DokumenFilateli;
    private javax.swing.JPanel Kemasan;
    private javax.swing.JPanel MS_SS;
    private javax.swing.JPanel Merchandise;
    private javax.swing.JPanel Prangko;
    private javax.swing.JPanel Prisma;
    private javax.swing.JPanel SHP_SHPSS;
    private javax.swing.JButton buttonCariDokumenFilateli;
    private javax.swing.JButton buttonCariKemasan;
    private javax.swing.JButton buttonCariMS_SS;
    private javax.swing.JButton buttonCariMerchandise;
    private javax.swing.JButton buttonCariPrangko;
    private javax.swing.JButton buttonCariPrisma;
    private javax.swing.JButton buttonCariSHP_SHPSS;
    private javax.swing.JButton buttonHapusDokumenFilateli;
    private javax.swing.JButton buttonHapusKemasan;
    private javax.swing.JButton buttonHapusMSSS;
    private javax.swing.JButton buttonHapusMerchandise;
    private javax.swing.JButton buttonHapusPrangko;
    private javax.swing.JButton buttonHapusPrisma;
    private javax.swing.JButton buttonHapusSHPSHPSS;
    private javax.swing.JButton buttonKelolaProduk;
    private javax.swing.JButton buttonSImpanKemasan;
    private javax.swing.JButton buttonSImpanMerchandise;
    private javax.swing.JButton buttonSimpanDokumenFIlateli;
    private javax.swing.JButton buttonSimpanMSSS;
    private javax.swing.JButton buttonSimpanPrangko;
    private javax.swing.JButton buttonSimpanPrisma;
    private javax.swing.JButton buttonSimpanSHPSHPSS;
    private javax.swing.JButton buttonTransaksi;
    private javax.swing.JButton buttonUbahDokumenFilateli;
    private javax.swing.JButton buttonUbahKemasan;
    private javax.swing.JButton buttonUbahMSSS;
    private javax.swing.JButton buttonUbahMerchandise;
    private javax.swing.JButton buttonUbahPrangko;
    private javax.swing.JButton buttonUbahPrisma;
    private javax.swing.JButton buttonUbahSHPSHPSS;
    private javax.swing.JComboBox<String> comboCariPrangko;
    private javax.swing.JComboBox<String> comboDokumenFIlateli;
    private javax.swing.JComboBox<String> comboJenisKemasan;
    private javax.swing.JComboBox<String> comboMS_SS;
    private javax.swing.JComboBox<String> comboMerchandise;
    private javax.swing.JComboBox<String> comboPrisma;
    private javax.swing.JComboBox<String> comboSHP_SHPSS;
    private javax.swing.JTextField fieldBiayaCetakDokumenFilateli;
    private javax.swing.JTextField fieldBiayaCetakPrangko;
    private javax.swing.JTextField fieldBiayaCetakProdukKemasan;
    private javax.swing.JTextField fieldBiayaCetakProdukMSSS;
    private javax.swing.JTextField fieldBiayaCetakProdukMerchandise;
    private javax.swing.JTextField fieldBiayaCetakProdukPrisma;
    private javax.swing.JTextField fieldBiayaCetakSHPSHPSS;
    private javax.swing.JTextField fieldCariDokumenFIlateli;
    private javax.swing.JTextField fieldCariKemasan;
    private javax.swing.JTextField fieldCariMS_SS;
    private javax.swing.JTextField fieldCariMerchandise;
    private javax.swing.JTextField fieldCariPrangko;
    private javax.swing.JTextField fieldCariPrisma;
    private javax.swing.JTextField fieldCariSHP_SHPSS;
    private javax.swing.JTextField fieldKodeProdukDokumenFilateli;
    private javax.swing.JTextField fieldKodeProdukKemasan;
    private javax.swing.JTextField fieldKodeProdukMS_SS;
    private javax.swing.JTextField fieldKodeProdukMerchandise;
    private javax.swing.JTextField fieldKodeProdukPrangko;
    private javax.swing.JTextField fieldKodeProdukPrisma;
    private javax.swing.JTextField fieldKodeProdukSHP_SHPSS;
    private javax.swing.JTextField fieldNamaProdukDokumenFilateli;
    private javax.swing.JTextField fieldNamaProdukKemasan;
    private javax.swing.JTextField fieldNamaProdukMSSS;
    private javax.swing.JTextField fieldNamaProdukMerchandise;
    private javax.swing.JTextField fieldNamaProdukPenerimaan;
    private javax.swing.JTextField fieldNamaProdukPrangko;
    private javax.swing.JTextField fieldNamaProdukPrisma;
    private javax.swing.JTextField fieldNamaProdukSHPSHPSS;
    private javax.swing.JTextField fieldNominalPrangko;
    private javax.swing.JTextField fieldNominalProdukDokumenFilateli;
    private javax.swing.JTextField fieldNominalProdukKemasan;
    private javax.swing.JTextField fieldNominalProdukMSSS;
    private javax.swing.JTextField fieldNominalProdukMerchandise;
    private javax.swing.JTextField fieldNominalProdukPrisma;
    private javax.swing.JTextField fieldNominalProdukSHPSHPSS;
    private javax.swing.JTextField fieldTahunPrangko;
    private javax.swing.JTextField fieldTahunProdukDokumenFilateli;
    private javax.swing.JTextField fieldTahunProdukKemasan;
    private javax.swing.JTextField fieldTahunProdukMSSS;
    private javax.swing.JTextField fieldTahunProdukMerchandise;
    private javax.swing.JTextField fieldTahunProdukPrisma;
    private javax.swing.JTextField fieldTahunProdukSHPSHPSS;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox8;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable8;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel labelKelolaProduk;
    private javax.swing.JLabel labelTransaksi;
    private javax.swing.JPanel tabKelolaProduk;
    private javax.swing.JTable tableDokumenFilateli;
    private javax.swing.JTable tableKemasan;
    private javax.swing.JTable tableMSSS;
    private javax.swing.JTable tableMerchandise;
    private javax.swing.JTable tablePrangko;
    private javax.swing.JTable tablePrisma;
    private javax.swing.JTable tableSHPSHPSS;
    // End of variables declaration//GEN-END:variables

}
