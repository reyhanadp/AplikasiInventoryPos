/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Form;

import id.ac.pos.gudang.Dialog.DialogHistoryDelete;
import id.ac.pos.gudang.Dialog.DialogRecycleBin;
import id.ac.pos.gudang.Dialog.DialogHistoryUpdate;
import id.ac.pos.gudang.Panel.PanelPemesanan;
import id.ac.pos.gudang.Panel.PanelPenerimaan;
import id.ac.pos.gudang.Panel.PanelPengembalian;
import id.ac.pos.gudang.Panel.PanelPengiriman;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.tablemodel.ProdukTM;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import javax.swing.table.TableRowSorter;

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
    TableRowSorter sorter;

    public FormHome() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        inisialisasiField();
        autoincrementPrangko();
        autoincrementMS_SS();
        autoincrementSHP_SHPSS();
        autoincrementKemasan();
        autoincrementMerchandise();
        autoincrementPrisma();
        autoincrementDokumenFilateli();
        refresh();
        //fieldNamaProdukPenerimaan.addKeyListener(new keyTextField(fieldNamaProdukPenerimaan));

    }

    private void refresh() {
        getDataPrangko();
        getDataMS_SS();
        getDataSHP_SHPSS();
        getDataKemasan();
        getDataMerchandise();
        getDataPrisma();
        getDataDokumenFilateli();
    }

    public void inisialisasiField() {
        fieldNominalPrangko.setText("0");
        fieldNominalProdukMSSS.setText("0");
        fieldNominalProdukSHPSHPSS.setText("0");
        fieldNominalProdukMerchandise.setText("0");
        fieldNominalProdukKemasan.setText("0");
        fieldNominalProdukDokumenFilateli.setText("0");
        fieldNominalProdukPrisma.setText("0");

        fieldBiayaCetakPrangko.setText("0");
        fieldBiayaCetakProdukMSSS.setText("0");
        fieldBiayaCetakSHPSHPSS.setText("0");
        fieldBiayaCetakProdukMerchandise.setText("0");
        fieldBiayaCetakProdukKemasan.setText("0");
        fieldBiayaCetakDokumenFilateli.setText("0");
        fieldBiayaCetakProdukPrisma.setText("0");
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

    public String cariData(String tabCari) {
        Object pilihanCari = "";
        if (tabCari.compareTo("PR") == 0) {
            pilihanCari = comboCariPrangko.getSelectedItem();
        } else if (tabCari.compareTo("kemasan") == 0) {
            pilihanCari = comboJenisKemasan.getSelectedItem();
        } else if (tabCari.compareTo("shp") == 0) {
            pilihanCari = comboSHP_SHPSS.getSelectedItem();
        } else if (tabCari.compareTo("ss") == 0) {
            pilihanCari = comboMS_SS.getSelectedItem();
        } else if (tabCari.compareTo("merchandise") == 0) {
            pilihanCari = comboMerchandise.getSelectedItem();
        } else if (tabCari.compareTo("prisma") == 0) {
            pilihanCari = comboPrisma.getSelectedItem();
        } else if (tabCari.compareTo("df") == 0) {
            pilihanCari = comboDokumenFIlateli.getSelectedItem();
        }

        String jenisCari = null;

        if (pilihanCari == "Id Produk") {
            jenisCari = "id_produk";
        } else if (pilihanCari == "Nama Produk") {
            jenisCari = "nama_produk";
        } else if (pilihanCari == "Nominal") {
            jenisCari = "nominal";
        } else if (pilihanCari == "Stok") {
            jenisCari = "stok";
        } else if (pilihanCari == "Biaya Cetak") {
            jenisCari = "biaya_cetak";
        } else if (pilihanCari == "Tahun") {
            jenisCari = "tahun";
        }

        return jenisCari;

    }

    public String cariPilihan(String tab) {
        String pilihanCari = "";

        if (tab.compareTo("prangko") == 0) {
            pilihanCari = "PR";
        } else if (tab.compareTo("kemasan") == 0) {
            pilihanCari = "KM";
        } else if (tab.compareTo("shp") == 0) {
            pilihanCari = "SHP";
        } else if (tab.compareTo("ss") == 0) {
            pilihanCari = "SS";
        } else if (tab.compareTo("merchandise") == 0) {
            pilihanCari = "MC";
        } else if (tab.compareTo("prisma") == 0) {
            pilihanCari = "PS";
        } else if (tab.compareTo("df") == 0) {
            pilihanCari = "DF";
        }

        return pilihanCari;
    }

    public String cariJenis(String tab) {
        String idJenis = "";

        if (tab.compareTo("prangko") == 0) {
            idJenis = "PR";
        } else if (tab.compareTo("kemasan") == 0) {
            idJenis = "KM";
        } else if (tab.compareTo("shp") == 0) {
            idJenis = "SHP";
        } else if (tab.compareTo("ss") == 0) {
            idJenis = "SS";
        } else if (tab.compareTo("merchandise") == 0) {
            idJenis = "MC";
        } else if (tab.compareTo("prisma") == 0) {
            idJenis = "PS";
        } else if (tab.compareTo("df") == 0) {
            idJenis = "DF";
        }

        return idJenis;
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

    private void resetField() {

        fieldNamaProdukPrangko.setText("");
        fieldNamaProdukMSSS.setText("");
        fieldNamaProdukSHPSHPSS.setText("");
        fieldNamaProdukMerchandise.setText("");
        fieldNamaProdukKemasan.setText("");
        fieldNamaProdukDokumenFilateli.setText("");
        fieldNamaProdukPrisma.setText("");

        fieldNominalPrangko.setText("0");
        fieldNominalProdukMSSS.setText("0");
        fieldNominalProdukSHPSHPSS.setText("0");
        fieldNominalProdukMerchandise.setText("0");
        fieldNominalProdukKemasan.setText("0");
        fieldNominalProdukDokumenFilateli.setText("0");
        fieldNominalProdukPrisma.setText("0");

        fieldBiayaCetakPrangko.setText("0");
        fieldBiayaCetakProdukMSSS.setText("0");
        fieldBiayaCetakSHPSHPSS.setText("0");
        fieldBiayaCetakProdukMerchandise.setText("0");
        fieldBiayaCetakProdukKemasan.setText("0");
        fieldBiayaCetakDokumenFilateli.setText("0");
        fieldBiayaCetakProdukPrisma.setText("0");

        fieldTahunPrangko.setText("");
        fieldTahunProdukMSSS.setText("");
        fieldTahunProdukSHPSHPSS.setText("");
        fieldTahunProdukMerchandise.setText("");
        fieldTahunProdukKemasan.setText("");
        fieldTahunProdukDokumenFilateli.setText("");
        fieldTahunProdukPrisma.setText("");

        autoincrementPrangko();
        autoincrementMS_SS();
        autoincrementSHP_SHPSS();
        autoincrementKemasan();
        autoincrementMerchandise();
        autoincrementPrisma();
        autoincrementDokumenFilateli();
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
            kodeSHP_SHPSS = "" + jenisProduk + "000";
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

    public void getDataPrangko() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrangko();

        ProdukTM produkPrangkoTableModel = new ProdukTM();
        produkPrangkoTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkPrangkoTableModel);
        tablePrangko.setRowSorter(sorter);
        tablePrangko.setModel(produkPrangkoTableModel);
    }

    public void getDataMS_SS() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMS_SS();

        ProdukTM produkMS_SSTableModel = new ProdukTM();
        produkMS_SSTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkMS_SSTableModel);
        tableMSSS.setRowSorter(sorter);
        tableMSSS.setModel(produkMS_SSTableModel);
    }

    public void getDataSHP_SHPSS() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukSHP_SHPSS();

        ProdukTM produkSHP_SHPSSTableModel = new ProdukTM();
        produkSHP_SHPSSTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkSHP_SHPSSTableModel);
        tableSHPSHPSS.setRowSorter(sorter);
        tableSHPSHPSS.setModel(produkSHP_SHPSSTableModel);
    }

    public void getDataKemasan() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukKemasan();

        ProdukTM produkKemasanTableModel = new ProdukTM();
        produkKemasanTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkKemasanTableModel);
        tableKemasan.setRowSorter(sorter);
        tableKemasan.setModel(produkKemasanTableModel);
    }

    public void getDataMerchandise() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukMerchandise();

        ProdukTM produkMerchandiseTableModel = new ProdukTM();
        produkMerchandiseTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkMerchandiseTableModel);
        tableMerchandise.setRowSorter(sorter);
        tableMerchandise.setModel(produkMerchandiseTableModel);
    }

    public void getDataPrisma() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukPrisma();

        ProdukTM produkPrismaTableModel = new ProdukTM();
        produkPrismaTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkPrismaTableModel);
        tablePrisma.setRowSorter(sorter);
        tablePrisma.setModel(produkPrismaTableModel);
    }

    public void getDataDokumenFilateli() {
        dao = new ProdukDAOImpl();
        arrayProduk = dao.getProdukDokumenFilateli();

        ProdukTM produkDokumenFilateliTableModel = new ProdukTM();
        produkDokumenFilateliTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkDokumenFilateliTableModel);
        tableDokumenFilateli.setRowSorter(sorter);
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
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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
        buttonResetPrangko = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePrangko = new javax.swing.JTable();
        buttonCariPrangko = new javax.swing.JButton();
        fieldCariPrangko = new javax.swing.JTextField();
        comboCariPrangko = new javax.swing.JComboBox<>();
        buttonRefresh = new javax.swing.JButton();
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
        ComboJenisMS_SS = new javax.swing.JComboBox<>();
        buttonResetMSSS = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMSSS = new javax.swing.JTable();
        buttonCariMS_SS = new javax.swing.JButton();
        fieldCariMS_SS = new javax.swing.JTextField();
        comboMS_SS = new javax.swing.JComboBox<>();
        buttonRefresh1 = new javax.swing.JButton();
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
        ComboJenisSHP_SHPSS = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        buttonResetSHPSHPSS = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSHPSHPSS = new javax.swing.JTable();
        buttonCariSHP_SHPSS = new javax.swing.JButton();
        fieldCariSHP_SHPSS = new javax.swing.JTextField();
        comboSHP_SHPSS = new javax.swing.JComboBox<>();
        buttonRefresh2 = new javax.swing.JButton();
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
        buttonResetKemasan = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableKemasan = new javax.swing.JTable();
        buttonCariKemasan = new javax.swing.JButton();
        fieldCariKemasan = new javax.swing.JTextField();
        comboJenisKemasan = new javax.swing.JComboBox<>();
        buttonRefresh4 = new javax.swing.JButton();
        buttonRefresh7 = new javax.swing.JButton();
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
        buttonResetMerchandise = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableMerchandise = new javax.swing.JTable();
        buttonCariMerchandise = new javax.swing.JButton();
        fieldCariMerchandise = new javax.swing.JTextField();
        comboMerchandise = new javax.swing.JComboBox<>();
        buttonRefresh3 = new javax.swing.JButton();
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
        buttonResetPrisma = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablePrisma = new javax.swing.JTable();
        buttonCariPrisma = new javax.swing.JButton();
        fieldCariPrisma = new javax.swing.JTextField();
        comboPrisma = new javax.swing.JComboBox<>();
        buttonRefresh5 = new javax.swing.JButton();
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
        buttonResetDokumenFIlateli = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tableDokumenFilateli = new javax.swing.JTable();
        buttonCariDokumenFilateli = new javax.swing.JButton();
        fieldCariDokumenFIlateli = new javax.swing.JTextField();
        comboDokumenFIlateli = new javax.swing.JComboBox<>();
        buttonRefresh6 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        itemRegional = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        itemRecycleBin = new javax.swing.JMenuItem();
        itemHistoryUpdate = new javax.swing.JMenuItem();
        itemHistoryDelete = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo-kecil.png"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        buttonKelolaProduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/kelola_produk.png"))); // NOI18N
        buttonKelolaProduk.setText("KELOLA PRODUK");
        buttonKelolaProduk.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonKelolaProduk.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonKelolaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKelolaProdukActionPerformed(evt);
            }
        });

        buttonTransaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/pemesanan.png"))); // NOI18N
        buttonTransaksi.setText("PEMESANAN");
        buttonTransaksi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonTransaksi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTransaksiActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/pengembalian.png"))); // NOI18N
        jButton3.setText("PENGEMBALIAN");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/penerimaan1.png"))); // NOI18N
        jButton4.setText("PENERIMAAN");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/pengiriman1.png"))); // NOI18N
        jButton5.setText("PENGIRIMAN");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/kelola_produk.png"))); // NOI18N
        jButton6.setText("LAPORAN");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(buttonKelolaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(buttonKelolaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanel3.setLayout(new java.awt.CardLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        Prangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PrangkoMouseClicked(evt);
            }
        });

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalPrangkoKeyTyped(evt);
            }
        });

        jLabel5.setText("Biaya Cetak  ");

        fieldTahunPrangko.setToolTipText("");
        fieldTahunPrangko.setAutoscrolls(false);
        fieldTahunPrangko.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldTahunPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTahunPrangkoActionPerformed(evt);
            }
        });
        fieldTahunPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunPrangkoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunPrangkoKeyTyped(evt);
            }
        });

        jLabel6.setText("Tahun");

        fieldBiayaCetakPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakPrangkoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakPrangkoKeyTyped(evt);
            }
        });

        buttonSimpanPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSimpanPrangko.setText("Simpan");
        buttonSimpanPrangko.setIconTextGap(8);
        buttonSimpanPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPrangkoActionPerformed(evt);
            }
        });

        buttonUbahPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahPrangko.setText("Ubah");
        buttonUbahPrangko.setIconTextGap(8);
        buttonUbahPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahPrangkoActionPerformed(evt);
            }
        });

        buttonHapusPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusPrangko.setText("Hapus");
        buttonHapusPrangko.setIconTextGap(8);
        buttonHapusPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusPrangkoActionPerformed(evt);
            }
        });

        buttonResetPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetPrangko.setText("Reset");
        buttonResetPrangko.setIconTextGap(8);
        buttonResetPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetPrangkoPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldTahunPrangko)
                    .addComponent(fieldNamaProdukPrangko, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldNominalPrangko)
                    .addComponent(fieldBiayaCetakPrangko)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addComponent(buttonSimpanPrangko)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbahPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapusPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonResetPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldKodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldKodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldNamaProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldNominalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldBiayaCetakPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldTahunPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanPrangko)
                    .addComponent(buttonUbahPrangko)
                    .addComponent(buttonHapusPrangko)
                    .addComponent(buttonResetPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tablePrangko.getTableHeader().setReorderingAllowed(false);
        tablePrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrangkoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePrangko);

        buttonCariPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariPrangko.setText("Cari");
        buttonCariPrangko.setIconTextGap(8);
        buttonCariPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangkoActionPerformed(evt);
            }
        });

        fieldCariPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangkoMouseClicked(evt);
            }
        });
        fieldCariPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariPrangkoActionPerformed(evt);
            }
        });
        fieldCariPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariPrangkoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCariPrangkoKeyTyped(evt);
            }
        });

        comboCariPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.setIconTextGap(8);
        buttonRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefreshPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(buttonRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Prangko", Prangko);

        MS_SS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SSMouseClicked(evt);
            }
        });

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukMSSSKeyTyped(evt);
            }
        });

        jLabel15.setText("Biaya Cetak  ");

        fieldTahunProdukMSSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMSSSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMSSSKeyTyped(evt);
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukMSSSKeyTyped(evt);
            }
        });

        buttonSimpanMSSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSimpanMSSS.setText("Simpan");
        buttonSimpanMSSS.setIconTextGap(8);
        buttonSimpanMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanMSSSActionPerformed(evt);
            }
        });

        buttonUbahMSSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahMSSS.setText("Ubah");
        buttonUbahMSSS.setIconTextGap(8);
        buttonUbahMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahMSSSActionPerformed(evt);
            }
        });

        buttonHapusMSSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusMSSS.setText("Hapus");
        buttonHapusMSSS.setIconTextGap(8);
        buttonHapusMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusMSSSActionPerformed(evt);
            }
        });

        jLabel8.setText("Jenis");

        ComboJenisMS_SS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MS", "SS" }));
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

        buttonResetMSSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetMSSS.setText("Reset");
        buttonResetMSSS.setIconTextGap(8);
        buttonResetMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetMSSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNamaProdukMSSS)
                    .addComponent(fieldNominalProdukMSSS)
                    .addComponent(fieldBiayaCetakProdukMSSS)
                    .addComponent(fieldTahunProdukMSSS)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(ComboJenisMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(buttonSimpanMSSS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbahMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapusMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonResetMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ComboJenisMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fieldNamaProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(fieldNominalProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(fieldBiayaCetakProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(fieldTahunProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanMSSS)
                    .addComponent(buttonUbahMSSS)
                    .addComponent(buttonHapusMSSS)
                    .addComponent(buttonResetMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tableMSSS.getTableHeader().setReorderingAllowed(false);
        tableMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMSSSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableMSSS);

        buttonCariMS_SS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariMS_SS.setText("Cari");
        buttonCariMS_SS.setIconTextGap(8);
        buttonCariMS_SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMS_SSActionPerformed(evt);
            }
        });
        buttonCariMS_SS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buttonCariMS_SSKeyReleased(evt);
            }
        });

        fieldCariMS_SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariMS_SSActionPerformed(evt);
            }
        });
        fieldCariMS_SS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariMS_SSKeyReleased(evt);
            }
        });

        comboMS_SS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh1.setText("Refresh");
        buttonRefresh1.setIconTextGap(8);
        buttonRefresh1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh1PrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(buttonRefresh1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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

        SHP_SHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSSMouseClicked(evt);
            }
        });

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukSHPSHPSSKeyTyped(evt);
            }
        });

        jLabel20.setText("Biaya Cetak  ");

        fieldTahunProdukSHPSHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukSHPSHPSSKeyTyped(evt);
            }
        });

        jLabel21.setText("Tahun");

        fieldBiayaCetakSHPSHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakSHPSHPSSKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakSHPSHPSSKeyTyped(evt);
            }
        });

        buttonSimpanSHPSHPSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSimpanSHPSHPSS.setText("Simpan");
        buttonSimpanSHPSHPSS.setIconTextGap(8);
        buttonSimpanSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanSHPSHPSSActionPerformed(evt);
            }
        });

        buttonUbahSHPSHPSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahSHPSHPSS.setText("Ubah");
        buttonUbahSHPSHPSS.setIconTextGap(8);
        buttonUbahSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahSHPSHPSSActionPerformed(evt);
            }
        });

        buttonHapusSHPSHPSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusSHPSHPSS.setText("Hapus");
        buttonHapusSHPSHPSS.setIconTextGap(8);
        buttonHapusSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusSHPSHPSSActionPerformed(evt);
            }
        });

        ComboJenisSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SHP", "SHPSS" }));
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

        buttonResetSHPSHPSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetSHPSHPSS.setText("Reset");
        buttonResetSHPSHPSS.setIconTextGap(8);
        buttonResetSHPSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetSHPSHPSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboJenisSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(buttonSimpanSHPSHPSS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbahSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapusSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonResetSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(fieldNamaProdukSHPSHPSS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldNominalProdukSHPSHPSS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldBiayaCetakSHPSHPSS, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldTahunProdukSHPSHPSS)))))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboJenisSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(fieldNamaProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(fieldNominalProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fieldBiayaCetakSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(fieldTahunProdukSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanSHPSHPSS)
                    .addComponent(buttonUbahSHPSHPSS)
                    .addComponent(buttonHapusSHPSHPSS)
                    .addComponent(buttonResetSHPSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tableSHPSHPSS.getTableHeader().setReorderingAllowed(false);
        tableSHPSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSHPSHPSSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSHPSHPSS);

        buttonCariSHP_SHPSS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariSHP_SHPSS.setText("Cari");
        buttonCariSHP_SHPSS.setIconTextGap(8);
        buttonCariSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariSHP_SHPSSActionPerformed(evt);
            }
        });

        fieldCariSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariSHP_SHPSSActionPerformed(evt);
            }
        });
        fieldCariSHP_SHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariSHP_SHPSSKeyReleased(evt);
            }
        });

        comboSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh2.setText("Refresh");
        buttonRefresh2.setIconTextGap(8);
        buttonRefresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh2PrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(buttonRefresh2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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

        Kemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KemasanMouseClicked(evt);
            }
        });

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukKemasanKeyTyped(evt);
            }
        });

        jLabel25.setText("Biaya Cetak  ");

        fieldTahunProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukKemasanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukKemasanKeyTyped(evt);
            }
        });

        jLabel26.setText("Tahun");

        fieldBiayaCetakProdukKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukKemasanKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukKemasanKeyTyped(evt);
            }
        });

        buttonSImpanKemasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSImpanKemasan.setText("Simpan");
        buttonSImpanKemasan.setIconTextGap(8);
        buttonSImpanKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSImpanKemasanActionPerformed(evt);
            }
        });

        buttonUbahKemasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahKemasan.setText("Ubah");
        buttonUbahKemasan.setIconTextGap(8);
        buttonUbahKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahKemasanActionPerformed(evt);
            }
        });

        buttonHapusKemasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusKemasan.setText("Hapus");
        buttonHapusKemasan.setIconTextGap(8);
        buttonHapusKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusKemasanActionPerformed(evt);
            }
        });

        buttonResetKemasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetKemasan.setText("Reset");
        buttonResetKemasan.setIconTextGap(8);
        buttonResetKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(buttonSImpanKemasan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonUbahKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonHapusKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonResetKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(774, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukKemasan)
                    .addComponent(fieldNominalProdukKemasan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldBiayaCetakProdukKemasan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fieldTahunProdukKemasan)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(fieldNamaProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(fieldNominalProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(fieldBiayaCetakProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(fieldTahunProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSImpanKemasan)
                    .addComponent(buttonUbahKemasan)
                    .addComponent(buttonHapusKemasan)
                    .addComponent(buttonResetKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tableKemasan.getTableHeader().setReorderingAllowed(false);
        tableKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKemasanMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableKemasan);

        buttonCariKemasan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariKemasan.setText("Cari");
        buttonCariKemasan.setIconTextGap(8);
        buttonCariKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariKemasanActionPerformed(evt);
            }
        });

        fieldCariKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariKemasanActionPerformed(evt);
            }
        });
        fieldCariKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariKemasanKeyReleased(evt);
            }
        });

        comboJenisKemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh4.setText("Refresh");
        buttonRefresh4.setIconTextGap(8);

        buttonRefresh7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh7.setText("Refresh");
        buttonRefresh7.setIconTextGap(8);
        buttonRefresh7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(buttonRefresh7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboJenisKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariKemasan))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(buttonRefresh4)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariKemasan)
                    .addComponent(fieldCariKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboJenisKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel21Layout.createSequentialGroup()
                    .addGap(0, 295, Short.MAX_VALUE)
                    .addComponent(buttonRefresh4)
                    .addGap(0, 295, Short.MAX_VALUE)))
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukMerchandiseKeyTyped(evt);
            }
        });

        jLabel30.setText("Biaya Cetak  ");

        fieldTahunProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMerchandiseKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukMerchandiseKeyTyped(evt);
            }
        });

        jLabel31.setText("Tahun");

        fieldBiayaCetakProdukMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukMerchandiseKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukMerchandiseKeyTyped(evt);
            }
        });

        buttonSImpanMerchandise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSImpanMerchandise.setText("Simpan");
        buttonSImpanMerchandise.setIconTextGap(8);
        buttonSImpanMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSImpanMerchandiseActionPerformed(evt);
            }
        });

        buttonUbahMerchandise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahMerchandise.setText("Ubah");
        buttonUbahMerchandise.setIconTextGap(8);
        buttonUbahMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahMerchandiseActionPerformed(evt);
            }
        });

        buttonHapusMerchandise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusMerchandise.setText("Hapus");
        buttonHapusMerchandise.setIconTextGap(8);
        buttonHapusMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusMerchandiseActionPerformed(evt);
            }
        });

        buttonResetMerchandise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetMerchandise.setText("Reset");
        buttonResetMerchandise.setIconTextGap(8);
        buttonResetMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNamaProdukMerchandise)
                    .addComponent(fieldNominalProdukMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(fieldBiayaCetakProdukMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(fieldTahunProdukMerchandise)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(buttonSImpanMerchandise)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbahMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapusMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonResetMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(fieldNamaProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(fieldNominalProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(fieldBiayaCetakProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(fieldTahunProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSImpanMerchandise)
                    .addComponent(buttonUbahMerchandise)
                    .addComponent(buttonHapusMerchandise)
                    .addComponent(buttonResetMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tableMerchandise.getTableHeader().setReorderingAllowed(false);
        tableMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableMerchandise);

        buttonCariMerchandise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariMerchandise.setText("Cari");
        buttonCariMerchandise.setIconTextGap(8);
        buttonCariMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariMerchandiseActionPerformed(evt);
            }
        });

        fieldCariMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariMerchandiseActionPerformed(evt);
            }
        });
        fieldCariMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariMerchandiseKeyReleased(evt);
            }
        });

        comboMerchandise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh3.setText("Refresh");
        buttonRefresh3.setIconTextGap(8);
        buttonRefresh3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(buttonRefresh3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukPrismaKeyTyped(evt);
            }
        });

        jLabel35.setText("Biaya Cetak  ");

        fieldTahunProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukPrismaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukPrismaKeyTyped(evt);
            }
        });

        jLabel36.setText("Tahun");

        fieldBiayaCetakProdukPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukPrismaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakProdukPrismaKeyTyped(evt);
            }
        });

        buttonSimpanPrisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSimpanPrisma.setText("Simpan");
        buttonSimpanPrisma.setIconTextGap(8);
        buttonSimpanPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPrismaActionPerformed(evt);
            }
        });

        buttonUbahPrisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahPrisma.setText("Ubah");
        buttonUbahPrisma.setIconTextGap(8);
        buttonUbahPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahPrismaActionPerformed(evt);
            }
        });

        buttonHapusPrisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusPrisma.setText("Hapus");
        buttonHapusPrisma.setIconTextGap(8);
        buttonHapusPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusPrismaActionPerformed(evt);
            }
        });

        buttonResetPrisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetPrisma.setText("Reset");
        buttonResetPrisma.setIconTextGap(8);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldNominalProdukPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(fieldNamaProdukPrisma)
                    .addComponent(fieldBiayaCetakProdukPrisma)
                    .addComponent(fieldTahunProdukPrisma)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addComponent(buttonSimpanPrisma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonUbahPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonHapusPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonResetPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(fieldNamaProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(fieldNominalProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(fieldBiayaCetakProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(fieldTahunProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanPrisma)
                    .addComponent(buttonUbahPrisma)
                    .addComponent(buttonHapusPrisma)
                    .addComponent(buttonResetPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tablePrisma.getTableHeader().setReorderingAllowed(false);
        tablePrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrismaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablePrisma);

        buttonCariPrisma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariPrisma.setText("Cari");
        buttonCariPrisma.setIconTextGap(8);
        buttonCariPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrismaActionPerformed(evt);
            }
        });

        fieldCariPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariPrismaActionPerformed(evt);
            }
        });
        fieldCariPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariPrismaKeyReleased(evt);
            }
        });

        comboPrisma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh5.setText("Refresh");
        buttonRefresh5.setIconTextGap(8);
        buttonRefresh5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(buttonRefresh5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalProdukDokumenFilateliKeyTyped(evt);
            }
        });

        jLabel40.setText("Biaya Cetak  ");

        fieldTahunProdukDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunProdukDokumenFilateliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldTahunProdukDokumenFilateliKeyTyped(evt);
            }
        });

        jLabel41.setText("Tahun");

        fieldBiayaCetakDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakDokumenFilateliKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakDokumenFilateliKeyTyped(evt);
            }
        });

        buttonSimpanDokumenFIlateli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        buttonSimpanDokumenFIlateli.setText("Simpan");
        buttonSimpanDokumenFIlateli.setIconTextGap(8);
        buttonSimpanDokumenFIlateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanDokumenFIlateliActionPerformed(evt);
            }
        });

        buttonUbahDokumenFilateli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Edit.png"))); // NOI18N
        buttonUbahDokumenFilateli.setText("Ubah");
        buttonUbahDokumenFilateli.setIconTextGap(8);
        buttonUbahDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahDokumenFilateliActionPerformed(evt);
            }
        });

        buttonHapusDokumenFilateli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        buttonHapusDokumenFilateli.setText("Hapus");
        buttonHapusDokumenFilateli.setIconTextGap(8);
        buttonHapusDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusDokumenFilateliActionPerformed(evt);
            }
        });

        buttonResetDokumenFIlateli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        buttonResetDokumenFIlateli.setText("Reset");
        buttonResetDokumenFIlateli.setIconTextGap(8);

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(buttonSimpanDokumenFIlateli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonUbahDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonHapusDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonResetDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(774, Short.MAX_VALUE))
                    .addComponent(fieldNamaProdukDokumenFilateli)
                    .addComponent(fieldNominalProdukDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(fieldBiayaCetakDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
                    .addComponent(fieldTahunProdukDokumenFilateli)))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(fieldNamaProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(fieldNominalProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(fieldBiayaCetakDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(fieldTahunProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanDokumenFIlateli)
                    .addComponent(buttonUbahDokumenFilateli)
                    .addComponent(buttonHapusDokumenFilateli)
                    .addComponent(buttonResetDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        tableDokumenFilateli.getTableHeader().setReorderingAllowed(false);
        tableDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tableDokumenFilateli);

        buttonCariDokumenFilateli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Search.png"))); // NOI18N
        buttonCariDokumenFilateli.setText("Cari");
        buttonCariDokumenFilateli.setIconTextGap(8);
        buttonCariDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariDokumenFilateliActionPerformed(evt);
            }
        });

        fieldCariDokumenFIlateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariDokumenFIlateliActionPerformed(evt);
            }
        });
        fieldCariDokumenFIlateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariDokumenFIlateliKeyReleased(evt);
            }
        });

        comboDokumenFIlateli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        buttonRefresh6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Refresh.png"))); // NOI18N
        buttonRefresh6.setText("Refresh");
        buttonRefresh6.setIconTextGap(8);
        buttonRefresh6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRefresh6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addComponent(buttonRefresh6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(comboDokumenFIlateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRefresh6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );

        jPanel3.add(tabKelolaProduk, "card2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTransaksiActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        CardLayout cardLayout = (CardLayout) jPanel3.getLayout();
        PanelPemesanan panelPemesanan = new PanelPemesanan();
        jPanel3.add("Panel Pemesanan", panelPemesanan);
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

    private void buttonSimpanPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanPrangkoActionPerformed
        // TODO add your handling code here:
        String idProduk = fieldKodeProdukPrangko.getText();
        String namaProduk = fieldNamaProdukPrangko.getText();
        String nominal = fieldNominalPrangko.getText();
        String biayaCetak = fieldBiayaCetakPrangko.getText();
        String tahun = fieldTahunPrangko.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukPrangko.requestFocus();
            fieldKodeProdukPrangko.setEditable(true);
            getDataPrangko();
        } else if (fieldNamaProdukPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukPrangko.requestFocus();
            fieldNamaProdukPrangko.setEditable(true);
            getDataPrangko();
        } else if ((fieldNominalPrangko.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalPrangko.requestFocus();
            fieldNominalPrangko.setEditable(true);
            getDataPrangko();
        } else if (fieldBiayaCetakPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakPrangko.requestFocus();
            fieldBiayaCetakPrangko.setEditable(true);
            getDataPrangko();
        } else if (fieldTahunPrangko.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunPrangko.requestFocus();
            fieldTahunPrangko.setEditable(true);
            getDataPrangko();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            String jenisProduk = "PR";

            //insert produk
            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.tambahProduk(produk, jenisProduk);

            //cek sukses atau tidak
            if (sukses) {
                getDataPrangko();
                autoincrementPrangko();
                resetField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataPrangko();
                autoincrementPrangko();
            }
        }
        getDataPrangko();
        autoincrementPrangko();
    }//GEN-LAST:event_buttonSimpanPrangkoActionPerformed

    private void buttonHapusPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusPrangkoActionPerformed
        // TODO add your handling code here:
        int baris = tablePrangko.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tablePrangko.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                resetField();
                getDataPrangko();
                autoincrementPrangko();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            getDataPrangko();
            autoincrementPrangko();
        }
        resetField();
        getDataPrangko();
        autoincrementPrangko();
    }//GEN-LAST:event_buttonHapusPrangkoActionPerformed

    private void buttonUbahPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahPrangkoActionPerformed
        // TODO add your handling code here:
        int baris = tablePrangko.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tablePrangko.getValueAt(baris, 0).toString();
            String NamaProduk = tablePrangko.getValueAt(baris, 1).toString();
            String nominal = tablePrangko.getValueAt(baris, 2).toString();
            String biayaCetak = tablePrangko.getValueAt(baris, 3).toString();
            String tahun = tablePrangko.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukPrangko.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukPrangko.requestFocus();
                    fieldNamaProdukPrangko.setEditable(true);
                    getDataPrangko();
                    fieldNamaProdukPrangko.setText(NamaProduk);
                    fieldKodeProdukPrangko.setText(kodeProduk);
                } else if ((fieldNominalPrangko.getText().equals(""))) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalPrangko.requestFocus();
                    fieldNominalPrangko.setEditable(true);
                    getDataPrangko();
                    fieldNominalPrangko.setText(nominal);
                    fieldKodeProdukPrangko.setText(kodeProduk);
                } else if (fieldBiayaCetakPrangko.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakPrangko.requestFocus();
                    fieldBiayaCetakPrangko.setEditable(true);
                    getDataPrangko();
                    fieldBiayaCetakPrangko.setText(biayaCetak);
                    fieldKodeProdukPrangko.setText(kodeProduk);
                } else if (fieldTahunPrangko.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunPrangko.requestFocus();
                    fieldTahunPrangko.setEditable(true);
                    getDataPrangko();
                    fieldTahunPrangko.setText(tahun);
                    fieldKodeProdukPrangko.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukPrangko.getText());
                    produk.setNamaProduk(fieldNamaProdukPrangko.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalPrangko.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakPrangko.getText()));
                    produk.setTahun(fieldTahunPrangko.getText());

                    //insert produk
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        resetField();
                        getDataPrangko();
                        autoincrementPrangko();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataPrangko();
                        autoincrementPrangko();
                    }
                }
            } else if (ok == 1) {
                resetField();
                getDataPrangko();
                autoincrementPrangko();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            getDataPrangko();
            autoincrementPrangko();
        }
        getDataPrangko();
        tablePrangko.setRowSelectionInterval(baris, baris);
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
        String nominal = fieldNominalProdukMSSS.getText();
        String biayaCetak = fieldBiayaCetakProdukMSSS.getText();
        String tahun = fieldTahunProdukMSSS.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukMS_SS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukMS_SS.requestFocus();
            fieldKodeProdukMS_SS.setEditable(true);
            getDataMS_SS();
        } else if (fieldNamaProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukMSSS.requestFocus();
            fieldNamaProdukMSSS.setEditable(true);
            getDataMS_SS();
        } else if (fieldNominalProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukMSSS.requestFocus();
            fieldNominalProdukMSSS.setEditable(true);
            getDataMS_SS();
        } else if (fieldBiayaCetakProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakProdukMSSS.requestFocus();
            fieldBiayaCetakProdukMSSS.setEditable(true);
            getDataMS_SS();
        } else if (fieldTahunProdukMSSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukMSSS.requestFocus();
            fieldTahunProdukMSSS.setEditable(true);
            getDataMS_SS();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
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
                getDataMS_SS();
                autoincrementMS_SS();
                resetField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataMS_SS();
                autoincrementMS_SS();
            }
        }
        getDataMS_SS();
        autoincrementMS_SS();
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
        if (baris >= 0) {
            String kodeProduk = tableMSSS.getValueAt(baris, 0).toString();
            String namaProduk = tableMSSS.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                resetField();
                getDataMS_SS();
                autoincrementMS_SS();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataMS_SS();
            autoincrementMS_SS();
        }
        resetField();
        getDataMS_SS();
        autoincrementMS_SS();
    }//GEN-LAST:event_buttonHapusMSSSActionPerformed

    private void buttonUbahMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahMSSSActionPerformed
        // TODO add your handling code here:
        int baris = tableMSSS.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableMSSS.getValueAt(baris, 0).toString();
            String NamaProduk = tableMSSS.getValueAt(baris, 1).toString();
            String nominal = tableMSSS.getValueAt(baris, 2).toString();
            String biayaCetak = tableMSSS.getValueAt(baris, 3).toString();
            String tahun = tableMSSS.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukMSSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukMSSS.requestFocus();
                    fieldNamaProdukMSSS.setEditable(true);
                    getDataMS_SS();
                    fieldNamaProdukMSSS.setText(NamaProduk);
                    fieldKodeProdukMS_SS.setText(kodeProduk);
                } else if (fieldNominalProdukMSSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukMSSS.requestFocus();
                    fieldNominalProdukMSSS.setEditable(true);
                    getDataMS_SS();
                    fieldNominalProdukMSSS.setText(nominal);
                    fieldKodeProdukMS_SS.setText(kodeProduk);
                } else if (fieldBiayaCetakProdukMSSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakProdukMSSS.requestFocus();
                    fieldBiayaCetakProdukMSSS.setEditable(true);
                    getDataMS_SS();
                    fieldBiayaCetakProdukMSSS.setText(biayaCetak);
                    fieldKodeProdukMS_SS.setText(kodeProduk);
                } else if (fieldTahunProdukMSSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukMSSS.requestFocus();
                    fieldTahunProdukMSSS.setEditable(true);
                    getDataMS_SS();
                    fieldTahunProdukMSSS.setText(tahun);
                    fieldKodeProdukMS_SS.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukMS_SS.getText());
                    produk.setNamaProduk(fieldNamaProdukMSSS.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukMSSS.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakProdukMSSS.getText()));
                    produk.setTahun(fieldTahunProdukMSSS.getText());

                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        getDataMS_SS();
                        resetField();
                        autoincrementMS_SS();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataMS_SS();
                        autoincrementMS_SS();
                    }
                }
            } else if (ok == 1) {
                resetField();
                getDataMS_SS();
                autoincrementMS_SS();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            resetField();
            getDataMS_SS();
            autoincrementMS_SS();
        }
        getDataMS_SS();
        tableMSSS.setRowSelectionInterval(baris, baris);
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
        String nominal = fieldNominalProdukSHPSHPSS.getText();
        String biayaCetak = fieldBiayaCetakSHPSHPSS.getText();
        String tahun = fieldTahunProdukSHPSHPSS.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukSHP_SHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukSHP_SHPSS.requestFocus();
            fieldKodeProdukSHP_SHPSS.setEditable(true);
            getDataSHP_SHPSS();
        } else if (fieldNamaProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukSHPSHPSS.requestFocus();
            fieldNamaProdukSHPSHPSS.setEditable(true);
            getDataSHP_SHPSS();
        } else if (fieldNominalProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukSHPSHPSS.requestFocus();
            fieldNominalProdukSHPSHPSS.setEditable(true);
            getDataSHP_SHPSS();
        } else if (fieldBiayaCetakSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakSHPSHPSS.requestFocus();
            fieldBiayaCetakSHPSHPSS.setEditable(true);
            getDataSHP_SHPSS();
        } else if (fieldTahunProdukSHPSHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukSHPSHPSS.requestFocus();
            fieldTahunProdukSHPSHPSS.setEditable(true);
            getDataSHP_SHPSS();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            Object jenisSHP_SHPSS = ComboJenisSHP_SHPSS.getSelectedItem();
            String kosong = null;
            String jenisProduk = null;

            //insert produk
            dao = new ProdukDAOImpl();
            if (jenisSHP_SHPSS == "SHP") {
                jenisProduk = "SHP";

            } else if (jenisSHP_SHPSS == "SHPSS") {
                jenisProduk = "SHPSS";
            }

            boolean sukses = dao.tambahProduk(produk, jenisProduk);
            //cek sukses atau tidak
            if (sukses) {
                getDataSHP_SHPSS();
                autoincrementSHP_SHPSS();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataSHP_SHPSS();
                autoincrementSHP_SHPSS();
                resetField();
            }
            getDataSHP_SHPSS();
            autoincrementSHP_SHPSS();
        }
    }//GEN-LAST:event_buttonSimpanSHPSHPSSActionPerformed

    private void buttonUbahSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahSHPSHPSSActionPerformed
        // TODO add your handling code here:
        int baris = tableSHPSHPSS.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableSHPSHPSS.getValueAt(baris, 0).toString();
            String NamaProduk = tableSHPSHPSS.getValueAt(baris, 1).toString();
            String nominal = tableSHPSHPSS.getValueAt(baris, 2).toString();
            String biayaCetak = tableSHPSHPSS.getValueAt(baris, 3).toString();
            String tahun = tableSHPSHPSS.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukSHPSHPSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukSHPSHPSS.requestFocus();
                    fieldNamaProdukSHPSHPSS.setEditable(true);
                    getDataSHP_SHPSS();
                    fieldNamaProdukSHPSHPSS.setText(NamaProduk);
                    fieldKodeProdukSHP_SHPSS.setText(kodeProduk);
                } else if (fieldNominalProdukSHPSHPSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukSHPSHPSS.requestFocus();
                    fieldNominalProdukSHPSHPSS.setEditable(true);
                    getDataSHP_SHPSS();
                    fieldNominalProdukSHPSHPSS.setText(nominal);
                    fieldKodeProdukSHP_SHPSS.setText(kodeProduk);
                } else if (fieldBiayaCetakSHPSHPSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakSHPSHPSS.requestFocus();
                    fieldBiayaCetakSHPSHPSS.setEditable(true);
                    getDataSHP_SHPSS();
                    fieldBiayaCetakSHPSHPSS.setText(biayaCetak);
                    fieldKodeProdukSHP_SHPSS.setText(kodeProduk);
                } else if (fieldTahunProdukSHPSHPSS.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukSHPSHPSS.requestFocus();
                    fieldTahunProdukSHPSHPSS.setEditable(true);
                    getDataSHP_SHPSS();
                    fieldTahunProdukSHPSHPSS.setText(tahun);
                    fieldKodeProdukSHP_SHPSS.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukSHP_SHPSS.getText());
                    produk.setNamaProduk(fieldNamaProdukSHPSHPSS.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukSHPSHPSS.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakSHPSHPSS.getText()));
                    produk.setTahun(fieldTahunProdukSHPSHPSS.getText());
                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        getDataSHP_SHPSS();
                        resetField();
                        autoincrementSHP_SHPSS();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataSHP_SHPSS();
                        autoincrementSHP_SHPSS();
                    }
                }
            } else if (ok == 1) {
                resetField();
                getDataSHP_SHPSS();
                autoincrementSHP_SHPSS();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            getDataSHP_SHPSS();
            autoincrementSHP_SHPSS();
        }
        getDataSHP_SHPSS();
        tableSHPSHPSS.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_buttonUbahSHPSHPSSActionPerformed

    private void buttonHapusSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusSHPSHPSSActionPerformed
        // TODO add your handling code here:
        int baris = tableSHPSHPSS.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableSHPSHPSS.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                resetField();
                getDataSHP_SHPSS();
                autoincrementSHP_SHPSS();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataSHP_SHPSS();
            autoincrementSHP_SHPSS();
        }
        resetField();
        getDataSHP_SHPSS();
        autoincrementSHP_SHPSS();
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
        String nominal = fieldNominalProdukKemasan.getText();
        String biayaCetak = fieldBiayaCetakProdukKemasan.getText();
        String tahun = fieldTahunProdukKemasan.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukKemasan.requestFocus();
            fieldKodeProdukKemasan.setEditable(true);
            getDataKemasan();
        } else if (fieldNamaProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukKemasan.requestFocus();
            fieldNamaProdukKemasan.setEditable(true);
            getDataKemasan();
        } else if (fieldNominalProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukKemasan.requestFocus();
            fieldNominalProdukKemasan.setEditable(true);
            getDataKemasan();
        } else if (fieldBiayaCetakProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakProdukKemasan.requestFocus();
            fieldBiayaCetakProdukKemasan.setEditable(true);
            getDataKemasan();
        } else if (fieldTahunProdukKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukKemasan.requestFocus();
            fieldTahunProdukKemasan.setEditable(true);
            getDataKemasan();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            String jenisProduk = "KM";

            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.tambahProduk(produk, jenisProduk);

            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                getDataKemasan();
                autoincrementKemasan();
                resetField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataKemasan();
                autoincrementKemasan();
            }
            getDataKemasan();
            autoincrementKemasan();
        }
    }//GEN-LAST:event_buttonSImpanKemasanActionPerformed

    private void buttonUbahKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahKemasanActionPerformed
        // TODO add your handling code here:
        int baris = tableKemasan.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableKemasan.getValueAt(baris, 0).toString();
            String NamaProduk = tableKemasan.getValueAt(baris, 1).toString();
            String nominal = tableKemasan.getValueAt(baris, 2).toString();
            String biayaCetak = tableKemasan.getValueAt(baris, 3).toString();
            String tahun = tableKemasan.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukKemasan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukKemasan.requestFocus();
                    fieldNamaProdukKemasan.setEditable(true);
                    getDataKemasan();
                    fieldNamaProdukKemasan.setText(NamaProduk);
                    fieldKodeProdukKemasan.setText(kodeProduk);
                } else if (fieldNominalProdukKemasan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukKemasan.requestFocus();
                    fieldNominalProdukKemasan.setEditable(true);
                    getDataKemasan();
                    fieldNominalProdukKemasan.setText(nominal);
                    fieldKodeProdukKemasan.setText(kodeProduk);
                } else if (fieldBiayaCetakProdukKemasan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakProdukKemasan.requestFocus();
                    fieldBiayaCetakProdukKemasan.setEditable(true);
                    getDataKemasan();
                    fieldBiayaCetakProdukKemasan.setText(biayaCetak);
                    fieldKodeProdukKemasan.setText(kodeProduk);
                } else if (fieldTahunProdukKemasan.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukKemasan.requestFocus();
                    fieldTahunProdukKemasan.setEditable(true);
                    getDataKemasan();
                    fieldTahunProdukKemasan.setText(tahun);
                    fieldKodeProdukKemasan.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukKemasan.getText());
                    produk.setNamaProduk(fieldNamaProdukKemasan.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukKemasan.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakProdukKemasan.getText()));
                    produk.setTahun(fieldTahunProdukKemasan.getText());

                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        getDataKemasan();
                        resetField();
                        autoincrementKemasan();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataKemasan();
                        autoincrementKemasan();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            getDataKemasan();
            resetField();
            autoincrementKemasan();
        }
        getDataKemasan();
        tableKemasan.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_buttonUbahKemasanActionPerformed

    private void buttonHapusKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusKemasanActionPerformed
        // TODO add your handling code here:
        int baris = tableKemasan.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableKemasan.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (ok == 0) {
                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                resetField();
                getDataKemasan();
                autoincrementKemasan();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataKemasan();
            autoincrementKemasan();
        }
        resetField();
        getDataKemasan();
        autoincrementKemasan();
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
        String nominal = fieldNominalProdukMerchandise.getText();
        String biayaCetak = fieldBiayaCetakProdukMerchandise.getText();
        String tahun = fieldTahunProdukMerchandise.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukMerchandise.requestFocus();
            fieldKodeProdukMerchandise.setEditable(true);
            getDataMerchandise();
        } else if (fieldNamaProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukMerchandise.requestFocus();
            fieldNamaProdukMerchandise.setEditable(true);
            getDataMerchandise();
        } else if (fieldNominalProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukMerchandise.requestFocus();
            fieldNominalProdukMerchandise.setEditable(true);
            getDataMerchandise();
        } else if (fieldBiayaCetakProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakProdukMerchandise.requestFocus();
            fieldBiayaCetakProdukMerchandise.setEditable(true);
            getDataMerchandise();
        } else if (fieldTahunProdukMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukMerchandise.requestFocus();
            fieldTahunProdukMerchandise.setEditable(true);
            getDataMerchandise();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            String jenisProduk = "MC";

            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.tambahProduk(produk, jenisProduk);

            //cek sukses atau tidak
            if (sukses) {
                resetField();
                getDataMerchandise();
                autoincrementMerchandise();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataMerchandise();
                autoincrementMerchandise();
            }
            getDataMerchandise();
            autoincrementMerchandise();
        }
    }//GEN-LAST:event_buttonSImpanMerchandiseActionPerformed

    private void buttonUbahMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahMerchandiseActionPerformed
        // TODO add your handling code here:
        int baris = tableMerchandise.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableMerchandise.getValueAt(baris, 0).toString();
            String NamaProduk = tableMerchandise.getValueAt(baris, 1).toString();
            String nominal = tableMerchandise.getValueAt(baris, 2).toString();
            String biayaCetak = tableMerchandise.getValueAt(baris, 3).toString();
            String tahun = tableMerchandise.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukMerchandise.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukMerchandise.requestFocus();
                    fieldNamaProdukMerchandise.setEditable(true);
                    getDataMerchandise();
                    fieldNamaProdukMerchandise.setText(NamaProduk);
                    fieldKodeProdukMerchandise.setText(kodeProduk);
                } else if (fieldNominalProdukMerchandise.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukMerchandise.requestFocus();
                    fieldNominalProdukMerchandise.setEditable(true);
                    getDataMerchandise();
                    fieldNominalProdukMerchandise.setText(nominal);
                    fieldKodeProdukMerchandise.setText(kodeProduk);
                } else if (fieldBiayaCetakProdukMerchandise.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakProdukMerchandise.requestFocus();
                    fieldBiayaCetakProdukMerchandise.setEditable(true);
                    getDataMerchandise();
                    fieldBiayaCetakProdukMerchandise.setText(biayaCetak);
                    fieldKodeProdukMerchandise.setText(kodeProduk);
                } else if (fieldTahunProdukMerchandise.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukMerchandise.requestFocus();
                    fieldTahunProdukMerchandise.setEditable(true);
                    getDataMerchandise();
                    fieldTahunProdukMerchandise.setText(tahun);
                    fieldKodeProdukMerchandise.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukMerchandise.getText());
                    produk.setNamaProduk(fieldNamaProdukMerchandise.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukMerchandise.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakProdukMerchandise.getText()));
                    produk.setTahun(fieldTahunProdukMerchandise.getText());

                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        getDataMerchandise();
                        resetField();
                        autoincrementMerchandise();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataMerchandise();
                        autoincrementMerchandise();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            getDataMerchandise();
            autoincrementMerchandise();
        }
        getDataMerchandise();
        tableMerchandise.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_buttonUbahMerchandiseActionPerformed

    private void buttonHapusMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusMerchandiseActionPerformed
        // TODO add your handling code here:
        int baris = tableMerchandise.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableMerchandise.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {

                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                //panggil method koneksi
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                resetField();
                getDataMerchandise();
                autoincrementMerchandise();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataMerchandise();
            autoincrementMerchandise();
        }
        resetField();
        getDataMerchandise();
        autoincrementMerchandise();
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
        String nominal = fieldNominalProdukPrisma.getText();
        String biayaCetak = fieldBiayaCetakProdukPrisma.getText();
        String tahun = fieldTahunProdukPrisma.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukPrisma.requestFocus();
            fieldKodeProdukPrisma.setEditable(true);
            getDataPrisma();
        } else if (fieldNamaProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukPrisma.requestFocus();
            fieldNamaProdukPrisma.setEditable(true);
            getDataPrisma();
        } else if (fieldNominalProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukPrisma.requestFocus();
            fieldNominalProdukPrisma.setEditable(true);
            getDataPrisma();
        } else if (fieldBiayaCetakProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakProdukPrisma.requestFocus();
            fieldBiayaCetakProdukPrisma.setEditable(true);
            getDataPrisma();
        } else if (fieldTahunProdukPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukPrisma.requestFocus();
            fieldTahunProdukPrisma.setEditable(true);
            getDataPrisma();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            String jenisProduk = "PS";

            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.tambahProduk(produk, jenisProduk);

            //cek sukses atau tidak
            if (sukses) {
                resetField();
                getDataPrisma();
                autoincrementPrisma();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataPrisma();
                autoincrementPrisma();
            }
            getDataPrisma();
            autoincrementPrisma();
        }
    }//GEN-LAST:event_buttonSimpanPrismaActionPerformed

    private void buttonUbahPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahPrismaActionPerformed
        // TODO add your handling code here:
        int baris = tablePrisma.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tablePrisma.getValueAt(baris, 0).toString();
            String NamaProduk = tablePrisma.getValueAt(baris, 1).toString();
            String nominal = tablePrisma.getValueAt(baris, 2).toString();
            String biayaCetak = tablePrisma.getValueAt(baris, 3).toString();
            String tahun = tablePrisma.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukPrisma.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukPrisma.requestFocus();
                    fieldNamaProdukPrisma.setEditable(true);
                    getDataPrisma();
                    fieldNamaProdukPrisma.setText(NamaProduk);
                    fieldKodeProdukPrisma.setText(kodeProduk);
                } else if (fieldNominalProdukPrisma.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukPrisma.requestFocus();
                    fieldNominalProdukPrisma.setEditable(true);
                    getDataPrisma();
                    fieldNominalProdukPrisma.setText(nominal);
                    fieldKodeProdukPrisma.setText(kodeProduk);
                } else if (fieldBiayaCetakProdukPrisma.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakProdukPrisma.requestFocus();
                    fieldBiayaCetakProdukPrisma.setEditable(true);
                    getDataPrisma();
                    fieldBiayaCetakProdukPrisma.setText(biayaCetak);
                    fieldKodeProdukPrisma.setText(kodeProduk);
                } else if (fieldTahunProdukPrisma.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukPrisma.requestFocus();
                    fieldTahunProdukPrisma.setEditable(true);
                    getDataPrisma();
                    fieldTahunProdukPrisma.setText(tahun);
                    fieldKodeProdukPrisma.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukPrisma.getText());
                    produk.setNamaProduk(fieldNamaProdukPrisma.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukPrisma.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakProdukPrisma.getText()));
                    produk.setTahun(fieldTahunProdukPrisma.getText());

                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        resetField();
                        getDataPrisma();
                        autoincrementPrisma();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataPrisma();
                        autoincrementPrisma();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            resetField();
            getDataPrisma();
            autoincrementPrisma();
        }
        getDataPrisma();
        tablePrisma.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_buttonUbahPrismaActionPerformed

    private void buttonHapusPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusPrismaActionPerformed
        // TODO add your handling code here:
        int baris = tablePrisma.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tablePrisma.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {

                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                //panggil method koneksi
                JOptionPane.showMessageDialog(null, "Data Berhasil di hapus");
                resetField();
                getDataPrisma();
                autoincrementPrisma();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataPrisma();
            autoincrementPrisma();
        }
        resetField();
        getDataPrisma();
        autoincrementPrisma();
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
        String nominal = fieldNominalProdukDokumenFilateli.getText();
        String biayaCetak = fieldBiayaCetakDokumenFilateli.getText();
        String tahun = fieldTahunProdukDokumenFilateli.getText();

        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldKodeProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Produk tidak boleh Kosong");
            fieldKodeProdukDokumenFilateli.requestFocus();
            fieldKodeProdukDokumenFilateli.setEditable(true);
            getDataDokumenFilateli();
        } else if (fieldNamaProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukDokumenFilateli.requestFocus();
            fieldNamaProdukDokumenFilateli.setEditable(true);
            getDataDokumenFilateli();
        } else if (fieldNominalProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalProdukDokumenFilateli.requestFocus();
            fieldNominalProdukDokumenFilateli.setEditable(true);
            getDataDokumenFilateli();
        } else if (fieldBiayaCetakDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakDokumenFilateli.requestFocus();
            fieldBiayaCetakDokumenFilateli.setEditable(true);
            getDataDokumenFilateli();
        } else if (fieldTahunProdukDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunProdukDokumenFilateli.requestFocus();
            fieldTahunProdukDokumenFilateli.setEditable(true);
            getDataDokumenFilateli();
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Produk produk = new Produk();
            produk.setIdProduk(idProduk);
            produk.setNamaProduk(namaProduk);
            produk.setNominal(Integer.parseInt(nominal));
            produk.setBiayaCetak(Float.parseFloat(biayaCetak));
            produk.setTahun(tahun);

            //inisialisasi
            String jenisProduk = "DF";

            ProdukDAO dao = new ProdukDAOImpl();
            boolean sukses = dao.tambahProduk(produk, jenisProduk);

            //cek sukses atau tidak
            if (sukses) {
                resetField();
                getDataDokumenFilateli();
                autoincrementDokumenFilateli();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                getDataDokumenFilateli();
                autoincrementDokumenFilateli();
            }
            getDataDokumenFilateli();
            autoincrementDokumenFilateli();
        }
    }//GEN-LAST:event_buttonSimpanDokumenFIlateliActionPerformed

    private void buttonUbahDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahDokumenFilateliActionPerformed
        // TODO add your handling code here:
        int baris = tableDokumenFilateli.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableDokumenFilateli.getValueAt(baris, 0).toString();
            String NamaProduk = tableDokumenFilateli.getValueAt(baris, 1).toString();
            String nominal = tableDokumenFilateli.getValueAt(baris, 2).toString();
            String biayaCetak = tableDokumenFilateli.getValueAt(baris, 3).toString();
            String tahun = tableDokumenFilateli.getValueAt(baris, 5).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "Mengubah Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + NamaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (ok == 0) {
                //validasi apakah filed 
                //sudah diisi atau belum
                if (fieldNamaProdukDokumenFilateli.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
                    fieldNamaProdukDokumenFilateli.requestFocus();
                    fieldNamaProdukDokumenFilateli.setEditable(true);
                    getDataDokumenFilateli();
                    fieldNamaProdukDokumenFilateli.setText(NamaProduk);
                    fieldKodeProdukDokumenFilateli.setText(kodeProduk);
                } else if (fieldNominalProdukDokumenFilateli.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
                    fieldNominalProdukDokumenFilateli.requestFocus();
                    fieldNominalProdukDokumenFilateli.setEditable(true);
                    getDataDokumenFilateli();
                    fieldNominalProdukDokumenFilateli.setText(nominal);
                    fieldKodeProdukDokumenFilateli.setText(kodeProduk);
                } else if (fieldBiayaCetakDokumenFilateli.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
                    fieldBiayaCetakDokumenFilateli.requestFocus();
                    fieldBiayaCetakDokumenFilateli.setEditable(true);
                    getDataDokumenFilateli();
                    fieldBiayaCetakDokumenFilateli.setText(biayaCetak);
                    fieldKodeProdukDokumenFilateli.setText(kodeProduk);
                } else if (fieldTahunProdukDokumenFilateli.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
                    fieldTahunProdukDokumenFilateli.requestFocus();
                    fieldTahunProdukDokumenFilateli.setEditable(true);
                    getDataDokumenFilateli();
                    fieldTahunProdukDokumenFilateli.setText(tahun);
                    fieldKodeProdukDokumenFilateli.setText(kodeProduk);
                } else {
                    Produk produk = new Produk();
                    produk.setIdProduk(fieldKodeProdukDokumenFilateli.getText());
                    produk.setNamaProduk(fieldNamaProdukDokumenFilateli.getText());
                    produk.setNominal(Integer.parseInt(fieldNominalProdukDokumenFilateli.getText()));
                    produk.setBiayaCetak(Float.parseFloat(fieldBiayaCetakDokumenFilateli.getText()));
                    produk.setTahun(fieldTahunProdukDokumenFilateli.getText());

                    //insert produk
                    ProdukDAO dao = new ProdukDAOImpl();
                    boolean sukses = dao.ubahProduk(produk);

                    //cek sukses atau tidak
                    if (sukses) {
                        JOptionPane.showMessageDialog(this, "Data berhasil diubah");
                        resetField();
                        getDataDokumenFilateli();
                        autoincrementDokumenFilateli();
                    } else {
                        JOptionPane.showMessageDialog(this, "Data gagal diubah");
                        getDataDokumenFilateli();
                        autoincrementDokumenFilateli();
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan diubah !");
            resetField();
            getDataDokumenFilateli();
            autoincrementDokumenFilateli();
        }
        getDataDokumenFilateli();
        tableDokumenFilateli.setRowSelectionInterval(baris, baris);
    }//GEN-LAST:event_buttonUbahDokumenFilateliActionPerformed

    private void buttonHapusDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusDokumenFilateliActionPerformed
        // TODO add your handling code here:
        int baris = tableDokumenFilateli.getSelectedRow();
        if (baris >= 0) {
            String kodeProduk = tableDokumenFilateli.getValueAt(baris, 0).toString();
            String namaProduk = tablePrangko.getValueAt(baris, 1).toString();

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Produk dengan kode : " + kodeProduk
                    + " dengan Nama Produk " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (ok == 0) {
                dao = new ProdukDAOImpl();
                dao.hapusProduk(kodeProduk);
                resetField();
                getDataDokumenFilateli();
                autoincrementDokumenFilateli();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk "
                    + "yang akan dihapus !");
            resetField();
            getDataDokumenFilateli();
            autoincrementDokumenFilateli();
        }

        resetField();
        getDataDokumenFilateli();
        autoincrementDokumenFilateli();
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

    private void buttonCariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangkoActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPrangko.getText();
        String status = "prangko";
        String tabCari = cariPilihan(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tablePrangko.setRowSorter(sorter);

        tablePrangko.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariPrangkoActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        resetField();
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
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel13MouseClicked

    private void MS_SSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SSMouseClicked

    private void SHP_SHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSSMouseClicked

    private void KemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_KemasanMouseClicked

    private void PrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PrangkoMouseClicked

    private void fieldCariPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangkoMouseClicked

    private void buttonCariKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariKemasanActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariKemasan.getText();
        String tab = "kemasan";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableKemasan.setRowSorter(sorter);

        tableKemasan.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariKemasanActionPerformed

    private void buttonCariMS_SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMS_SSActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariMS_SS.getText();
        String tab = "ss";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableMSSS.setRowSorter(sorter);

        tableMSSS.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariMS_SSActionPerformed

    private void buttonCariSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariSHP_SHPSSActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariSHP_SHPSS.getText();
        String tab = "shp";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableSHPSHPSS.setRowSorter(sorter);

        tableSHPSHPSS.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariSHP_SHPSSActionPerformed

    private void buttonCariMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariMerchandiseActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariMerchandise.getText();
        String tab = "merchandise";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableMerchandise.setRowSorter(sorter);

        tableMerchandise.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariMerchandiseActionPerformed

    private void buttonCariPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrismaActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPrisma.getText();
        String tab = "prisma";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tablePrisma.setRowSorter(sorter);

        tablePrisma.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariPrismaActionPerformed

    private void buttonCariDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariDokumenFilateliActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariDokumenFIlateli.getText();
        String tab = "df";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableDokumenFilateli.setRowSorter(sorter);

        tableDokumenFilateli.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariDokumenFilateliActionPerformed

    private void fieldNominalPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalPrangkoKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalPrangkoKeyTyped

    private void fieldBiayaCetakPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakPrangkoKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakPrangkoKeyTyped

    private void fieldNominalProdukMSSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukMSSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukMSSSKeyTyped

    private void fieldBiayaCetakProdukMSSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukMSSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukMSSSKeyTyped

    private void fieldNominalProdukSHPSHPSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukSHPSHPSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukSHPSHPSSKeyTyped

    private void fieldBiayaCetakSHPSHPSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakSHPSHPSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakSHPSHPSSKeyTyped

    private void fieldNominalProdukKemasanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukKemasanKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukKemasanKeyTyped

    private void fieldBiayaCetakProdukKemasanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukKemasanKeyTyped
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukKemasanKeyTyped

    private void fieldNominalProdukMerchandiseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukMerchandiseKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukMerchandiseKeyTyped

    private void fieldBiayaCetakProdukMerchandiseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukMerchandiseKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukMerchandiseKeyTyped

    private void fieldNominalProdukPrismaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukPrismaKeyTyped
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukPrismaKeyTyped

    private void fieldBiayaCetakProdukPrismaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakProdukPrismaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakProdukPrismaKeyTyped

    private void fieldNominalProdukDokumenFilateliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalProdukDokumenFilateliKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldNominalProdukDokumenFilateliKeyTyped

    private void fieldBiayaCetakDokumenFilateliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakDokumenFilateliKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldBiayaCetakDokumenFilateliKeyTyped

    private void fieldTahunPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunPrangkoKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunPrangkoKeyTyped

    private void fieldTahunProdukMSSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukMSSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukMSSSKeyTyped

    private void fieldTahunProdukSHPSHPSSKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukSHPSHPSSKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukSHPSHPSSKeyTyped

    private void fieldTahunProdukKemasanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukKemasanKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukKemasanKeyTyped

    private void fieldTahunProdukMerchandiseKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukMerchandiseKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukMerchandiseKeyTyped

    private void fieldTahunProdukPrismaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukPrismaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukPrismaKeyTyped

    private void fieldTahunProdukDokumenFilateliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunProdukDokumenFilateliKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldTahunProdukDokumenFilateliKeyTyped

    private void fieldTahunPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTahunPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunPrangkoActionPerformed

    private void buttonResetPrangkoPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetPrangkoPrangkoActionPerformed
        // TODO add your handling code here
        resetField();
        autoincrementPrangko();
        getDataPrangko();
    }//GEN-LAST:event_buttonResetPrangkoPrangkoActionPerformed

    private void fieldCariPrangkoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariPrangkoKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariPrangko.getText();
        String status = "prangko";
        String tabCari = cariPilihan(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tablePrangko.setRowSorter(sorter);

        tablePrangko.setModel(produkTableModel);
    }//GEN-LAST:event_fieldCariPrangkoKeyReleased

    private void fieldCariPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariPrangkoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_fieldCariPrangkoKeyTyped

    private void fieldCariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariPrangkoActionPerformed
        // TODO add your handling code here:
        buttonCariPrangko.requestFocus();
    }//GEN-LAST:event_fieldCariPrangkoActionPerformed

    private void fieldCariMS_SSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariMS_SSKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariMS_SS.getText();
        String tab = "ss";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableMSSS.setRowSorter(sorter);

        tableMSSS.setModel(produkTableModel);

    }//GEN-LAST:event_fieldCariMS_SSKeyReleased

    private void buttonCariMS_SSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buttonCariMS_SSKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariMS_SS.getText();
        String tab = "ss";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableMSSS.setRowSorter(sorter);

        tableMSSS.setModel(produkTableModel);
    }//GEN-LAST:event_buttonCariMS_SSKeyReleased

    private void fieldCariMS_SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariMS_SSActionPerformed
        // TODO add your handling code here:
        buttonCariMS_SS.requestFocus();
    }//GEN-LAST:event_fieldCariMS_SSActionPerformed

    private void fieldCariSHP_SHPSSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariSHP_SHPSSKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariSHP_SHPSS.getText();
        String tab = "shp";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableSHPSHPSS.setRowSorter(sorter);

        tableSHPSHPSS.setModel(produkTableModel);
    }//GEN-LAST:event_fieldCariSHP_SHPSSKeyReleased

    private void fieldCariSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariSHP_SHPSSActionPerformed
        // TODO add your handling code here:
        buttonCariSHP_SHPSS.requestFocus();
    }//GEN-LAST:event_fieldCariSHP_SHPSSActionPerformed

    private void fieldCariKemasanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariKemasanKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariKemasan.getText();
        String tab = "kemasan";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableKemasan.setRowSorter(sorter);

        tableKemasan.setModel(produkTableModel);
    }//GEN-LAST:event_fieldCariKemasanKeyReleased

    private void fieldCariKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariKemasanActionPerformed
        // TODO add your handling code here:
        buttonCariKemasan.requestFocus();
    }//GEN-LAST:event_fieldCariKemasanActionPerformed

    private void fieldCariMerchandiseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariMerchandiseKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariMerchandise.getText();
        String tab = "merchandise";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableMerchandise.setRowSorter(sorter);

        tableMerchandise.setModel(produkTableModel);

    }//GEN-LAST:event_fieldCariMerchandiseKeyReleased

    private void fieldCariMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariMerchandiseActionPerformed
        // TODO add your handling code here:
        buttonCariMerchandise.requestFocus();
    }//GEN-LAST:event_fieldCariMerchandiseActionPerformed

    private void fieldCariPrismaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariPrismaKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariPrisma.getText();
        String tab = "prisma";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tablePrisma.setRowSorter(sorter);

        tablePrisma.setModel(produkTableModel);
    }//GEN-LAST:event_fieldCariPrismaKeyReleased

    private void fieldCariPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariPrismaActionPerformed
        // TODO add your handling code here:
        buttonCariPrisma.requestFocus();
    }//GEN-LAST:event_fieldCariPrismaActionPerformed

    private void fieldCariDokumenFIlateliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariDokumenFIlateliKeyReleased
        // TODO add your handling code here:
        String keyword = fieldCariDokumenFIlateli.getText();
        String tab = "df";
        String jenisCari = cariData(tab);
        String idJenis = cariJenis(tab);

        // lakukan proses pencarian
        dao = new ProdukDAOImpl();
        arrayProduk = dao.cariProduk(keyword, jenisCari, idJenis);

        ProdukTM produkTableModel = new ProdukTM();
        produkTableModel.setDataProduk(arrayProduk);
        sorter = new TableRowSorter(produkTableModel);
        tableDokumenFilateli.setRowSorter(sorter);

        tableDokumenFilateli.setModel(produkTableModel);    }//GEN-LAST:event_fieldCariDokumenFIlateliKeyReleased

    private void fieldCariDokumenFIlateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariDokumenFIlateliActionPerformed
        // TODO add your handling code here:
        buttonCariDokumenFilateli.requestFocus();
    }//GEN-LAST:event_fieldCariDokumenFIlateliActionPerformed

    private void buttonResetMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetMSSSActionPerformed

    private void buttonResetSHPSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetSHPSHPSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetSHPSHPSSActionPerformed

    private void buttonResetKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetKemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetKemasanActionPerformed

    private void buttonResetMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetMerchandiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonResetMerchandiseActionPerformed

    private void itemRecycleBinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRecycleBinActionPerformed
        // TODO add your handling code here:
        DialogRecycleBin drb = new DialogRecycleBin(this, true);
        drb.setLocationRelativeTo(null);
        drb.setVisible(true);
    }//GEN-LAST:event_itemRecycleBinActionPerformed

    private void itemHistoryUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoryUpdateActionPerformed
        // TODO add your handling code here:
        DialogHistoryUpdate drb = new DialogHistoryUpdate(this, true);
        drb.setLocationRelativeTo(null);
        drb.setVisible(true);
    }//GEN-LAST:event_itemHistoryUpdateActionPerformed

    private void itemHistoryDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemHistoryDeleteActionPerformed
        // TODO add your handling code here:
        DialogHistoryDelete drd = new DialogHistoryDelete(this, true);
        drd.setLocationRelativeTo(null);
        drd.setVisible(true);
    }//GEN-LAST:event_itemHistoryDeleteActionPerformed

    private void buttonRefreshPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefreshPrangkoActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefreshPrangkoActionPerformed

    private void buttonRefresh1PrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh1PrangkoActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh1PrangkoActionPerformed

    private void buttonRefresh2PrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh2PrangkoActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh2PrangkoActionPerformed

    private void buttonRefresh6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh6ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh6ActionPerformed

    private void buttonRefresh5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh5ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh5ActionPerformed

    private void buttonRefresh3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh3ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh3ActionPerformed

    private void buttonRefresh7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRefresh7ActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_buttonRefresh7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        CardLayout cardLayout = (CardLayout) jPanel3.getLayout();
        PanelPenerimaan panelPenerimaan = new PanelPenerimaan();
        jPanel3.add("Panel Penerimaan", panelPenerimaan);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        CardLayout cardLayout = (CardLayout) jPanel3.getLayout();
        PanelPengiriman panelPengiriman = new PanelPengiriman();
        jPanel3.add("Panel Pengiriman", panelPengiriman);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jPanel3.removeAll();
        jPanel3.repaint();
        jPanel3.revalidate();
        CardLayout cardLayout = (CardLayout) jPanel3.getLayout();
        PanelPengembalian panelPengembalian = new PanelPengembalian();
        jPanel3.add("Panel Pengembalian", panelPengembalian);
        jPanel3.repaint();
        jPanel3.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
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
    private javax.swing.JButton buttonRefresh;
    private javax.swing.JButton buttonRefresh1;
    private javax.swing.JButton buttonRefresh2;
    private javax.swing.JButton buttonRefresh3;
    private javax.swing.JButton buttonRefresh4;
    private javax.swing.JButton buttonRefresh5;
    private javax.swing.JButton buttonRefresh6;
    private javax.swing.JButton buttonRefresh7;
    private javax.swing.JButton buttonResetDokumenFIlateli;
    private javax.swing.JButton buttonResetKemasan;
    private javax.swing.JButton buttonResetMSSS;
    private javax.swing.JButton buttonResetMerchandise;
    private javax.swing.JButton buttonResetPrangko;
    private javax.swing.JButton buttonResetPrisma;
    private javax.swing.JButton buttonResetSHPSHPSS;
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
    private javax.swing.JMenuItem itemHistoryDelete;
    private javax.swing.JMenuItem itemHistoryUpdate;
    private javax.swing.JMenuItem itemRecycleBin;
    private javax.swing.JMenu itemRegional;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
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
