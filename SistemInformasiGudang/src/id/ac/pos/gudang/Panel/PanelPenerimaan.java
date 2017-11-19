package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.dao.PenerimaanDAO;
import id.ac.pos.gudang.daoimpl.PenerimaanDAOImpl;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
import id.ac.pos.gudang.tablemodel.PenerimaanTM;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableRowSorter;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author reyha
 */
public class PanelPenerimaan extends javax.swing.JPanel {

    /**
     * Creates new form PanelPenerimaan
     */
    
    private Connection conn;
 
    private Penerimaan penerimaan;
    private PenerimaanDAO dao;
    ArrayList<Penerimaan> arrayPenerimaan;
    TableRowSorter sorter;
    
    public PanelPenerimaan() {
        initComponents();
        conn = DatabaseConnectivity.getConnection();
        setModelNoPemesananPrangko();
        setModelNoPemesananMS_SS();
        setModelNoPemesananSHP_SHPSS();
        setModelNoPemesananKemasan();
        setModelNoPemesananMerchandise();
        setModelNoPemesananPrisma();
        setModelNoPemesananDokumenFilateli();
        getDataPrangko();
        getDataMS_SS();
        getDataSHP_SHPSS();
        getDataKemasan();
        getDataMerchandise();
        getDataPrisma();
        getDataDokumenFilateli();
    }
    
    public void autoFieldTrue(String noPemesanan){
        String id_suplier=null;
        try {
            String query = "SELECT tb_pemesanan.id_suplier,tb_produk.id_produk,tb_trans_penerimaan.sisa_belum_dikirim,"
                    + "tb_produk.nama_produk,tb_trans_penerimaan.subtotal_terima,jumlah_pesan,stok "
                    + "FROM tb_pemesanan,tb_produk,tb_trans_penerimaan "
                    + "WHERE tb_pemesanan.no_pemesanan = '"+noPemesanan+"' AND tb_pemesanan.id_produk=tb_produk.id_produk"
                    + " AND tb_trans_penerimaan.no_pemesanan=tb_pemesanan.no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
            if (result.next()) {
                fieldIdSuplier.setText(result.getString("tb_pemesanan.id_suplier"));
                fieldTotalPemesanan.setText(result.getString("jumlah_pesan"));
                fieldStokAwal.setText(result.getString("stok"));
                fieldNamaProduk.setText(result.getString("tb_produk.nama_produk"));
                fieldKodeProduk.setText(result.getString("tb_produk.id_produk"));
                if(result.getString("subtotal_terima")==null){
                    fieldSubtotalTerima.setText("0");
                }else{
                fieldSubtotalTerima.setText(result.getString("subtotal_terima"));
                }
                System.out.println(result.getString("subtotal_terima"));
                if(result.getString("sisa_belum_dikirim")==""){
                    fieldSisaBelumDikirim.setText("0");
                }else{
                fieldSisaBelumDikirim.setText(result.getString("sisa_belum_dikirim"));
                }
                
            }else {
                autoFieldfalse(noPemesanan);
            }
        } catch (SQLException e) {
        }
    }
    
    public void autoFieldfalse(String noPemesanan){
        String id_suplier=null;
        try {
            String query = "SELECT id_suplier,jumlah_pesan,id_produk FROM tb_pemesanan WHERE no_pemesanan='"+noPemesanan+"'";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
            while (result.next()) {
                fieldIdSuplier.setText(result.getString("id_suplier"));
                fieldTotalPemesanan.setText(result.getString("jumlah_pesan"));
                fieldStokAwal.setText("0");
                fieldKodeProduk.setText(result.getString("id_produk"));
                fieldSubtotalTerima.setText("0");
                fieldSisaBelumDikirim.setText(result.getString("jumlah_pesan"));
            }
        } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananPrangko(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk='PR' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesanan.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananMS_SS(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && (id_jenis_produk='MS' || id_jenis_produk='SS') ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananMS_SS.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananSHP_SHPSS(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk LIKE 'SHP%' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananSHP_SHPSS.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananKemasan(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk='KM' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananKemasan.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananMerchandise(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk='MC' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananMerchandise.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananPrisma(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk='PS' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananPrisma.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
        }
    }
    
    public void setModelNoPemesananDokumenFilateli(){
        try {
            String query = "SELECT no_pemesanan FROM tb_pemesanan WHERE status='belum selesai' && id_jenis_produk='DF' ORDER BY no_pemesanan";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                ComboNoPemesananDokumenFilateli.addItem(result.getString("no_pemesanan"));
            }
          } catch (SQLException e) {
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

        jTabbedPane5 = new javax.swing.JTabbedPane();
        Prangko3 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        fieldTglPenerimaan = new com.toedter.calendar.JDateChooser();
        jLabel61 = new javax.swing.JLabel();
        fieldJmlTerima = new javax.swing.JTextField();
        jButtonSimpanPenerimaan = new javax.swing.JButton();
        fieldNoOrder = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ComboNoPemesanan = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldStokAwal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldTotalPemesanan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldKeterangan = new javax.swing.JTextArea();
        fieldIdSuplier = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldKodeProduk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldSubtotalTerima = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fieldSisaBelumDikirim = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldNamaProduk = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tablePenerimaanPrangko = new javax.swing.JTable();
        buttonCariPrangko15 = new javax.swing.JButton();
        fieldCariPrangko15 = new javax.swing.JTextField();
        comboCariPrangko15 = new javax.swing.JComboBox<>();
        jDesktopPane15 = new javax.swing.JDesktopPane();
        MS_SS3 = new javax.swing.JPanel();
        jPanel73 = new javax.swing.JPanel();
        jLabel182 = new javax.swing.JLabel();
        fieldNoOrderMS_SS = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        fieldTglPenerimaanMS_SS = new com.toedter.calendar.JDateChooser();
        jLabel62 = new javax.swing.JLabel();
        fieldJmlTerimaMS_SS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboNoPemesananMS_SS = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        fieldNamaProdukMS_SS = new javax.swing.JTextField();
        fieldKodeProdukMS_SS = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        fieldIdSuplierMS_SS = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        fieldStokAwalMS_SS = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        fieldTotalPemesananMS_SS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fieldSisaBelumDikirimMS_SS = new javax.swing.JTextField();
        fieldSubtotalTerimaMS_SS = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldKeteranganMS_SS = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanMS_SS = new javax.swing.JButton();
        jDesktopPane16 = new javax.swing.JDesktopPane();
        jPanel74 = new javax.swing.JPanel();
        jScrollPane42 = new javax.swing.JScrollPane();
        tablePenerimaanMS_SS = new javax.swing.JTable();
        buttonCariPrangko16 = new javax.swing.JButton();
        fieldCariPrangko16 = new javax.swing.JTextField();
        comboCariPrangko16 = new javax.swing.JComboBox<>();
        SHP_SHPSS3 = new javax.swing.JPanel();
        jPanel75 = new javax.swing.JPanel();
        jLabel152 = new javax.swing.JLabel();
        fieldNoOrderSHP_SHPSS = new javax.swing.JTextField();
        jLabel153 = new javax.swing.JLabel();
        fieldTglPenerimaanSHP_SHPSS = new com.toedter.calendar.JDateChooser();
        jLabel63 = new javax.swing.JLabel();
        fieldJmlTerimaSHP_SHPSS = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        ComboNoPemesananSHP_SHPSS = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        fieldNamaProdukSHP_SHPSS = new javax.swing.JTextField();
        fieldKodeProdukSHP_SHPSS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        fieldIdSuplierSHP_SHPSS = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        fieldStokAwalSHP_SHPSS = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        fieldSubtotalTerimaSHP_SHPSS = new javax.swing.JTextField();
        fieldSisaBelumDikirimSHP_SHPSS = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        fieldTotalPemesananSHP_SHPSS = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        fieldKeteranganSHP_SHPSS = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanSHP_SHPSS = new javax.swing.JButton();
        jDesktopPane17 = new javax.swing.JDesktopPane();
        jPanel76 = new javax.swing.JPanel();
        jScrollPane44 = new javax.swing.JScrollPane();
        tablePenerimaanSHP_SHPSS = new javax.swing.JTable();
        buttonCariPrangko17 = new javax.swing.JButton();
        fieldCariPrangko17 = new javax.swing.JTextField();
        comboCariPrangko17 = new javax.swing.JComboBox<>();
        Kemasan3 = new javax.swing.JPanel();
        jPanel77 = new javax.swing.JPanel();
        jLabel184 = new javax.swing.JLabel();
        fieldNoOrderKemasan = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        fieldTglPenerimaanKemasan = new com.toedter.calendar.JDateChooser();
        jLabel64 = new javax.swing.JLabel();
        fieldJmlTerimaKemasan = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        ComboNoPemesananKemasan = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        fieldNamaProdukKemasan = new javax.swing.JTextField();
        fieldKodeProdukKemasan = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        fieldIdSuplierKemasan = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        fieldStokAwalKemasan = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        fieldSubtotalTerimaKemasan = new javax.swing.JTextField();
        fieldSisaBelumDikirimKemasan = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        fieldTotalPemesananKemasan = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        fieldKeteranganKemasan = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanKemasan = new javax.swing.JButton();
        jDesktopPane18 = new javax.swing.JDesktopPane();
        jPanel78 = new javax.swing.JPanel();
        jScrollPane46 = new javax.swing.JScrollPane();
        tablePenerimaanKemasan = new javax.swing.JTable();
        buttonCariPrangko18 = new javax.swing.JButton();
        fieldCariPrangko18 = new javax.swing.JTextField();
        comboCariPrangko18 = new javax.swing.JComboBox<>();
        Merchandise3 = new javax.swing.JPanel();
        jPanel79 = new javax.swing.JPanel();
        jLabel186 = new javax.swing.JLabel();
        fieldNoOrderMerchandise = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        fieldTglPenerimaanMerchandise = new com.toedter.calendar.JDateChooser();
        jLabel65 = new javax.swing.JLabel();
        fieldJmlTerimaMerchandise = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        ComboNoPemesananMerchandise = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        fieldNamaProdukMerchandise = new javax.swing.JTextField();
        fieldKodeProdukMerchandise = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        fieldIdSuplierMerchandise = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        fieldStokAwalMerchandise = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        fieldSubtotalTerimaMerchandise = new javax.swing.JTextField();
        fieldSisaBelumDikirimMerchandise = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        fieldTotalPemesananMerchandise = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        fieldKeteranganMerchandise = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanMerchandise = new javax.swing.JButton();
        jDesktopPane19 = new javax.swing.JDesktopPane();
        jPanel80 = new javax.swing.JPanel();
        jScrollPane48 = new javax.swing.JScrollPane();
        tablePenerimaanMerchandise = new javax.swing.JTable();
        buttonCariPrangko19 = new javax.swing.JButton();
        fieldCariPrangko19 = new javax.swing.JTextField();
        comboCariPrangko19 = new javax.swing.JComboBox<>();
        Prisma3 = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jLabel188 = new javax.swing.JLabel();
        fieldNoOrderPrisma = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        fieldTglPenerimaanPrisma = new com.toedter.calendar.JDateChooser();
        jLabel66 = new javax.swing.JLabel();
        fieldJmlTerimaPrisma = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        ComboNoPemesananPrisma = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        fieldNamaProdukPrisma = new javax.swing.JTextField();
        fieldKodeProdukPrisma = new javax.swing.JTextField();
        jLabel48 = new javax.swing.JLabel();
        fieldIdSuplierPrisma = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        fieldStokAwalPrisma = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        fieldSubtotalTerimaPrisma = new javax.swing.JTextField();
        fieldSisaBelumDikirimPrisma = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        fieldTotalPemesananPrisma = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        fieldKeteranganPrisma = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanPrisma = new javax.swing.JButton();
        jDesktopPane20 = new javax.swing.JDesktopPane();
        jPanel82 = new javax.swing.JPanel();
        jScrollPane50 = new javax.swing.JScrollPane();
        tablePenerimaanPrisma = new javax.swing.JTable();
        buttonCariPrangko20 = new javax.swing.JButton();
        fieldCariPrangko20 = new javax.swing.JTextField();
        comboCariPrangko20 = new javax.swing.JComboBox<>();
        DokumenFilateli3 = new javax.swing.JPanel();
        jPanel83 = new javax.swing.JPanel();
        jLabel190 = new javax.swing.JLabel();
        fieldNoOrderDokumenFilateli = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        fieldTglPenerimaanDokumenFilateli = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        fieldJmlTerimaDokumenFilateli = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        ComboNoPemesananDokumenFilateli = new javax.swing.JComboBox<>();
        jLabel56 = new javax.swing.JLabel();
        fieldNamaProdukDokumenFilateli = new javax.swing.JTextField();
        fieldKodeProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        fieldIdSuplierDokumenFilateli = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        fieldStokAwalDokumenFilateli = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        fieldSubtotalTerimaDokumenFilateli = new javax.swing.JTextField();
        fieldSisaBelumDikirimDokumenFilateli = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        fieldTotalPemesananDokumenFilateli = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        fieldKeteranganDokumenFilateli = new javax.swing.JTextArea();
        jButtonSimpanPenerimaanDokumenFilateli = new javax.swing.JButton();
        jDesktopPane21 = new javax.swing.JDesktopPane();
        jPanel84 = new javax.swing.JPanel();
        jScrollPane52 = new javax.swing.JScrollPane();
        tablePenerimaanDokumenFilateli = new javax.swing.JTable();
        buttonCariPrangko21 = new javax.swing.JButton();
        fieldCariPrangko21 = new javax.swing.JTextField();
        comboCariPrangko21 = new javax.swing.JComboBox<>();

        jTabbedPane5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane5MouseClicked(evt);
            }
        });

        Prangko3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prangko3MouseClicked(evt);
            }
        });

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel39MouseClicked(evt);
            }
        });

        jLabel150.setText("No Order");

        jLabel151.setText("Tanggal Penerimaan");

        jLabel61.setText("Jumlah Terima");

        jButtonSimpanPenerimaan.setText("Simpan");
        jButtonSimpanPenerimaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanActionPerformed(evt);
            }
        });

        jLabel1.setText("No Pemesanan");

        ComboNoPemesanan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananActionPerformed(evt);
            }
        });
        ComboNoPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananKeyReleased(evt);
            }
        });

        jLabel2.setText("Id Suplier");

        jLabel3.setText("Stok Awal");

        fieldStokAwal.setEditable(false);

        jLabel4.setText("Total Pemesanan");

        fieldTotalPemesanan.setEditable(false);

        jLabel5.setText("Keterangan");

        fieldKeterangan.setColumns(20);
        fieldKeterangan.setRows(5);
        jScrollPane1.setViewportView(fieldKeterangan);

        fieldIdSuplier.setEditable(false);

        jLabel6.setText("Kode Produk");

        fieldKodeProduk.setEditable(false);

        jLabel7.setText("Subtotal Terima");

        fieldSubtotalTerima.setEditable(false);

        jLabel8.setText("Sisa Belum Dikirim");

        fieldSisaBelumDikirim.setEditable(false);

        jLabel9.setText("Nama Produk");

        fieldNamaProduk.setEditable(false);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel151)
                            .addComponent(jLabel150)
                            .addComponent(jLabel61)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel39Layout.createSequentialGroup()
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel39Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel39Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel39Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel39Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldTglPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaan))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel150)
                    .addComponent(fieldNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel151, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboNoPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61)
                    .addComponent(fieldJmlTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(fieldKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(fieldIdSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(fieldSubtotalTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(fieldStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(fieldTotalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaan))
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanPrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanPrangkoMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tablePenerimaanPrangko);

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

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko15))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko15)
                    .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        jDesktopPane15.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane15Layout = new javax.swing.GroupLayout(jDesktopPane15);
        jDesktopPane15.setLayout(jDesktopPane15Layout);
        jDesktopPane15Layout.setHorizontalGroup(
            jDesktopPane15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 503, Short.MAX_VALUE)
        );
        jDesktopPane15Layout.setVerticalGroup(
            jDesktopPane15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Prangko3Layout = new javax.swing.GroupLayout(Prangko3);
        Prangko3.setLayout(Prangko3Layout);
        Prangko3Layout.setHorizontalGroup(
            Prangko3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Prangko3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDesktopPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Prangko3Layout.setVerticalGroup(
            Prangko3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prangko3Layout.createSequentialGroup()
                .addGroup(Prangko3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jDesktopPane15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Prangko", Prangko3);

        MS_SS3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS3MouseClicked(evt);
            }
        });

        jPanel73.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel73MouseClicked(evt);
            }
        });

        jLabel182.setText("No Order");

        jLabel183.setText("Tanggal Penerimaan");

        jLabel62.setText("Jumlah Terima");

        jLabel10.setText("No Pemesanan");

        ComboNoPemesananMS_SS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananMS_SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananMS_SSActionPerformed(evt);
            }
        });
        ComboNoPemesananMS_SS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananMS_SSKeyReleased(evt);
            }
        });

        jLabel11.setText("Nama Produk");

        fieldNamaProdukMS_SS.setEditable(false);

        fieldKodeProdukMS_SS.setEditable(false);

        jLabel12.setText("Kode Produk");

        fieldIdSuplierMS_SS.setEditable(false);

        jLabel13.setText("Id Suplier");

        jLabel14.setText("Stok Awal");

        fieldStokAwalMS_SS.setEditable(false);

        jLabel15.setText("Total Pemesanan");

        fieldTotalPemesananMS_SS.setEditable(false);

        jLabel16.setText("Keterangan");

        fieldSisaBelumDikirimMS_SS.setEditable(false);

        fieldSubtotalTerimaMS_SS.setEditable(false);

        jLabel17.setText("Subtotal Terima");

        jLabel18.setText("Sisa Belum Dikirim");

        fieldKeteranganMS_SS.setColumns(20);
        fieldKeteranganMS_SS.setRows(5);
        jScrollPane2.setViewportView(fieldKeteranganMS_SS);

        jButtonSimpanPenerimaanMS_SS.setText("Simpan");
        jButtonSimpanPenerimaanMS_SS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanMS_SSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel73Layout = new javax.swing.GroupLayout(jPanel73);
        jPanel73.setLayout(jPanel73Layout);
        jPanel73Layout.setHorizontalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel183)
                            .addComponent(jLabel182)
                            .addComponent(jLabel62)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNoOrderMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel73Layout.createSequentialGroup()
                                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel73Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel73Layout.createSequentialGroup()
                                            .addComponent(jLabel18)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel73Layout.createSequentialGroup()
                                            .addComponent(jLabel17)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel73Layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldTglPenerimaanMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanMS_SS))
                    .addGroup(jPanel73Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel73Layout.setVerticalGroup(
            jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel73Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel182)
                    .addComponent(fieldNoOrderMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanMS_SS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel183, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(ComboNoPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fieldNamaProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel62)
                    .addComponent(fieldJmlTerimaMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(fieldKodeProdukMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(fieldIdSuplierMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(fieldSubtotalTerimaMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(fieldStokAwalMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(fieldTotalPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel73Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanMS_SS))
        );

        jDesktopPane16.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane16Layout = new javax.swing.GroupLayout(jDesktopPane16);
        jDesktopPane16.setLayout(jDesktopPane16Layout);
        jDesktopPane16Layout.setHorizontalGroup(
            jDesktopPane16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane16Layout.setVerticalGroup(
            jDesktopPane16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel74.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanMS_SS.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanMS_SS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanMS_SSMouseClicked(evt);
            }
        });
        jScrollPane42.setViewportView(tablePenerimaanMS_SS);

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

        javax.swing.GroupLayout jPanel74Layout = new javax.swing.GroupLayout(jPanel74);
        jPanel74.setLayout(jPanel74Layout);
        jPanel74Layout.setHorizontalGroup(
            jPanel74Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel74Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane42, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SS3Layout = new javax.swing.GroupLayout(MS_SS3);
        MS_SS3.setLayout(MS_SS3Layout);
        MS_SS3Layout.setHorizontalGroup(
            MS_SS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MS_SS3Layout.createSequentialGroup()
                .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane16))
        );
        MS_SS3Layout.setVerticalGroup(
            MS_SS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MS_SS3Layout.createSequentialGroup()
                .addGroup(MS_SS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel73, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("MS & SS", MS_SS3);

        SHP_SHPSS3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS3MouseClicked(evt);
            }
        });

        jPanel75.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel75MouseClicked(evt);
            }
        });

        jLabel152.setText("No Order");

        jLabel153.setText("Tanggal Penerimaan");

        jLabel63.setText("Jumlah Terima");

        jLabel19.setText("No Pemesanan");

        ComboNoPemesananSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananSHP_SHPSSActionPerformed(evt);
            }
        });
        ComboNoPemesananSHP_SHPSS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananSHP_SHPSSKeyReleased(evt);
            }
        });

        jLabel20.setText("Nama Produk");

        fieldNamaProdukSHP_SHPSS.setEditable(false);

        fieldKodeProdukSHP_SHPSS.setEditable(false);

        jLabel21.setText("Kode Produk");

        fieldIdSuplierSHP_SHPSS.setEditable(false);

        jLabel22.setText("Id Suplier");

        jLabel23.setText("Stok Awal");

        fieldStokAwalSHP_SHPSS.setEditable(false);

        jLabel24.setText("Subtotal Terima");

        fieldSubtotalTerimaSHP_SHPSS.setEditable(false);

        fieldSisaBelumDikirimSHP_SHPSS.setEditable(false);

        jLabel25.setText("Sisa Belum Dikirim");

        fieldTotalPemesananSHP_SHPSS.setEditable(false);

        jLabel26.setText("Total Pemesanan");

        jLabel27.setText("Keterangan");

        fieldKeteranganSHP_SHPSS.setColumns(20);
        fieldKeteranganSHP_SHPSS.setRows(5);
        jScrollPane3.setViewportView(fieldKeteranganSHP_SHPSS);

        jButtonSimpanPenerimaanSHP_SHPSS.setText("Simpan");
        jButtonSimpanPenerimaanSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanSHP_SHPSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel75Layout = new javax.swing.GroupLayout(jPanel75);
        jPanel75.setLayout(jPanel75Layout);
        jPanel75Layout.setHorizontalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel153)
                            .addComponent(jLabel152)
                            .addComponent(jLabel63)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel75Layout.createSequentialGroup()
                                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel75Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel75Layout.createSequentialGroup()
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel75Layout.createSequentialGroup()
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel75Layout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldNoOrderSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldTglPenerimaanSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanSHP_SHPSS))
                    .addGroup(jPanel75Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel19)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel75Layout.setVerticalGroup(
            jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel75Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel152)
                    .addComponent(fieldNoOrderSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanSHP_SHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel153, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(ComboNoPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(fieldNamaProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel63)
                    .addComponent(fieldJmlTerimaSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(fieldKodeProdukSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(fieldIdSuplierSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(fieldSubtotalTerimaSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(fieldStokAwalSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel25))
                    .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(fieldTotalPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel75Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanSHP_SHPSS))
        );

        jDesktopPane17.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane17Layout = new javax.swing.GroupLayout(jDesktopPane17);
        jDesktopPane17.setLayout(jDesktopPane17Layout);
        jDesktopPane17Layout.setHorizontalGroup(
            jDesktopPane17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane17Layout.setVerticalGroup(
            jDesktopPane17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel76.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanSHP_SHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanSHP_SHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanSHP_SHPSSMouseClicked(evt);
            }
        });
        jScrollPane44.setViewportView(tablePenerimaanSHP_SHPSS);

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

        javax.swing.GroupLayout jPanel76Layout = new javax.swing.GroupLayout(jPanel76);
        jPanel76.setLayout(jPanel76Layout);
        jPanel76Layout.setHorizontalGroup(
            jPanel76Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane44, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel76Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane44, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSS3Layout = new javax.swing.GroupLayout(SHP_SHPSS3);
        SHP_SHPSS3.setLayout(SHP_SHPSS3Layout);
        SHP_SHPSS3Layout.setHorizontalGroup(
            SHP_SHPSS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SHP_SHPSS3Layout.createSequentialGroup()
                .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane17))
        );
        SHP_SHPSS3Layout.setVerticalGroup(
            SHP_SHPSS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SHP_SHPSS3Layout.createSequentialGroup()
                .addGroup(SHP_SHPSS3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel75, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("SHP & SHPSS", SHP_SHPSS3);

        Kemasan3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kemasan3MouseClicked(evt);
            }
        });

        jPanel77.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel77MouseClicked(evt);
            }
        });

        jLabel184.setText("No Order");

        jLabel185.setText("Tanggal Penerimaan");

        jLabel64.setText("Jumlah Terima");

        jLabel28.setText("No Pemesanan");

        ComboNoPemesananKemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananKemasanActionPerformed(evt);
            }
        });
        ComboNoPemesananKemasan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananKemasanKeyReleased(evt);
            }
        });

        jLabel29.setText("Nama Produk");

        fieldNamaProdukKemasan.setEditable(false);

        fieldKodeProdukKemasan.setEditable(false);

        jLabel30.setText("Kode Produk");

        fieldIdSuplierKemasan.setEditable(false);

        jLabel31.setText("Id Suplier");

        jLabel32.setText("Stok Awal");

        fieldStokAwalKemasan.setEditable(false);

        jLabel33.setText("Subtotal Terima");

        fieldSubtotalTerimaKemasan.setEditable(false);

        fieldSisaBelumDikirimKemasan.setEditable(false);

        jLabel34.setText("Sisa Belum Dikirim");

        fieldTotalPemesananKemasan.setEditable(false);

        jLabel35.setText("Total Pemesanan");

        jLabel36.setText("Keterangan");

        fieldKeteranganKemasan.setColumns(20);
        fieldKeteranganKemasan.setRows(5);
        jScrollPane4.setViewportView(fieldKeteranganKemasan);

        jButtonSimpanPenerimaanKemasan.setText("Simpan");
        jButtonSimpanPenerimaanKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel77Layout = new javax.swing.GroupLayout(jPanel77);
        jPanel77.setLayout(jPanel77Layout);
        jPanel77Layout.setHorizontalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel185)
                            .addComponent(jLabel184)
                            .addComponent(jLabel64)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel77Layout.createSequentialGroup()
                                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel77Layout.createSequentialGroup()
                                        .addComponent(jLabel29)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel77Layout.createSequentialGroup()
                                            .addComponent(jLabel34)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel77Layout.createSequentialGroup()
                                            .addComponent(jLabel33)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel77Layout.createSequentialGroup()
                                            .addComponent(jLabel30)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldNoOrderKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldTglPenerimaanKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanKemasan))
                    .addGroup(jPanel77Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel28)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel77Layout.setVerticalGroup(
            jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel77Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel184)
                    .addComponent(fieldNoOrderKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanKemasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel185, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(ComboNoPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(fieldNamaProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64)
                    .addComponent(fieldJmlTerimaKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(fieldKodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(fieldIdSuplierKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(fieldSubtotalTerimaKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel32)
                        .addComponent(fieldStokAwalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel34))
                    .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel35)
                        .addComponent(fieldTotalPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel77Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanKemasan))
        );

        jDesktopPane18.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane18Layout = new javax.swing.GroupLayout(jDesktopPane18);
        jDesktopPane18.setLayout(jDesktopPane18Layout);
        jDesktopPane18Layout.setHorizontalGroup(
            jDesktopPane18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane18Layout.setVerticalGroup(
            jDesktopPane18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel78.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanKemasanMouseClicked(evt);
            }
        });
        jScrollPane46.setViewportView(tablePenerimaanKemasan);

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

        javax.swing.GroupLayout jPanel78Layout = new javax.swing.GroupLayout(jPanel78);
        jPanel78.setLayout(jPanel78Layout);
        jPanel78Layout.setHorizontalGroup(
            jPanel78Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel78Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane46, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Kemasan3Layout = new javax.swing.GroupLayout(Kemasan3);
        Kemasan3.setLayout(Kemasan3Layout);
        Kemasan3Layout.setHorizontalGroup(
            Kemasan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Kemasan3Layout.createSequentialGroup()
                .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane18))
        );
        Kemasan3Layout.setVerticalGroup(
            Kemasan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Kemasan3Layout.createSequentialGroup()
                .addGroup(Kemasan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel77, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Kemasan", Kemasan3);

        jPanel79.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel79MouseClicked(evt);
            }
        });

        jLabel186.setText("No Order");

        jLabel187.setText("Tanggal Penerimaan");

        jLabel65.setText("Jumlah Terima");

        jLabel37.setText("No Pemesanan");

        ComboNoPemesananMerchandise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananMerchandiseActionPerformed(evt);
            }
        });
        ComboNoPemesananMerchandise.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananMerchandiseKeyReleased(evt);
            }
        });

        jLabel38.setText("Nama Produk");

        fieldNamaProdukMerchandise.setEditable(false);

        fieldKodeProdukMerchandise.setEditable(false);

        jLabel39.setText("Kode Produk");

        fieldIdSuplierMerchandise.setEditable(false);

        jLabel40.setText("Id Suplier");

        jLabel41.setText("Stok Awal");

        fieldStokAwalMerchandise.setEditable(false);

        jLabel42.setText("Subtotal Terima");

        fieldSubtotalTerimaMerchandise.setEditable(false);

        fieldSisaBelumDikirimMerchandise.setEditable(false);

        jLabel43.setText("Sisa Belum Dikirim");

        fieldTotalPemesananMerchandise.setEditable(false);

        jLabel44.setText("Total Pemesanan");

        jLabel45.setText("Keterangan");

        fieldKeteranganMerchandise.setColumns(20);
        fieldKeteranganMerchandise.setRows(5);
        jScrollPane5.setViewportView(fieldKeteranganMerchandise);

        jButtonSimpanPenerimaanMerchandise.setText("Simpan");
        jButtonSimpanPenerimaanMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel79Layout = new javax.swing.GroupLayout(jPanel79);
        jPanel79.setLayout(jPanel79Layout);
        jPanel79Layout.setHorizontalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanMerchandise))
                    .addGroup(jPanel79Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel187)
                            .addComponent(jLabel186)
                            .addComponent(jLabel65)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel37))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboNoPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNoOrderMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldTglPenerimaanMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel79Layout.createSequentialGroup()
                                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel79Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel79Layout.createSequentialGroup()
                                            .addComponent(jLabel43)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel79Layout.createSequentialGroup()
                                            .addComponent(jLabel42)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel79Layout.createSequentialGroup()
                                            .addComponent(jLabel39)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel79Layout.setVerticalGroup(
            jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel79Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel186)
                    .addComponent(fieldNoOrderMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel187, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(ComboNoPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(fieldNamaProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel65)
                    .addComponent(fieldJmlTerimaMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(fieldKodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(fieldIdSuplierMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel42)
                        .addComponent(fieldSubtotalTerimaMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(fieldStokAwalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel43))
                    .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel44)
                        .addComponent(fieldTotalPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel79Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanMerchandise))
        );

        jDesktopPane19.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane19Layout = new javax.swing.GroupLayout(jDesktopPane19);
        jDesktopPane19.setLayout(jDesktopPane19Layout);
        jDesktopPane19Layout.setHorizontalGroup(
            jDesktopPane19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane19Layout.setVerticalGroup(
            jDesktopPane19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel80.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane48.setViewportView(tablePenerimaanMerchandise);

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

        javax.swing.GroupLayout jPanel80Layout = new javax.swing.GroupLayout(jPanel80);
        jPanel80.setLayout(jPanel80Layout);
        jPanel80Layout.setHorizontalGroup(
            jPanel80Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel80Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane48, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Merchandise3Layout = new javax.swing.GroupLayout(Merchandise3);
        Merchandise3.setLayout(Merchandise3Layout);
        Merchandise3Layout.setHorizontalGroup(
            Merchandise3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Merchandise3Layout.createSequentialGroup()
                .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane19))
        );
        Merchandise3Layout.setVerticalGroup(
            Merchandise3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Merchandise3Layout.createSequentialGroup()
                .addGroup(Merchandise3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel79, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel80, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Merchandise", Merchandise3);

        jPanel81.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel81.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel81MouseClicked(evt);
            }
        });

        jLabel188.setText("No Order");

        jLabel189.setText("Tanggal Penerimaan");

        jLabel66.setText("Jumlah Terima");

        jLabel46.setText("No Pemesanan");

        ComboNoPemesananPrisma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananPrismaActionPerformed(evt);
            }
        });
        ComboNoPemesananPrisma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananPrismaKeyReleased(evt);
            }
        });

        jLabel47.setText("Nama Produk");

        fieldNamaProdukPrisma.setEditable(false);

        fieldKodeProdukPrisma.setEditable(false);

        jLabel48.setText("Kode Produk");

        fieldIdSuplierPrisma.setEditable(false);

        jLabel49.setText("Id Suplier");

        jLabel50.setText("Stok Awal");

        fieldStokAwalPrisma.setEditable(false);

        jLabel51.setText("Subtotal Terima");

        fieldSubtotalTerimaPrisma.setEditable(false);

        fieldSisaBelumDikirimPrisma.setEditable(false);

        jLabel52.setText("Sisa Belum Dikirim");

        fieldTotalPemesananPrisma.setEditable(false);

        jLabel53.setText("Total Pemesanan");

        jLabel54.setText("Keterangan");

        fieldKeteranganPrisma.setColumns(20);
        fieldKeteranganPrisma.setRows(5);
        jScrollPane6.setViewportView(fieldKeteranganPrisma);

        jButtonSimpanPenerimaanPrisma.setText("Simpan");
        jButtonSimpanPenerimaanPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanPrismaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel189)
                            .addComponent(jLabel188)
                            .addComponent(jLabel66)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel53)
                            .addComponent(jLabel54))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNoOrderPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel81Layout.createSequentialGroup()
                                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel81Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel81Layout.createSequentialGroup()
                                            .addComponent(jLabel52)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel81Layout.createSequentialGroup()
                                            .addComponent(jLabel51)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel81Layout.createSequentialGroup()
                                            .addComponent(jLabel48)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldTglPenerimaanPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanPrisma))
                    .addGroup(jPanel81Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel46)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel81Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel188)
                    .addComponent(fieldNoOrderPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel189, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(ComboNoPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(fieldNamaProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel66)
                    .addComponent(fieldJmlTerimaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel48)
                        .addComponent(fieldKodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel49)
                        .addComponent(fieldIdSuplierPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel51)
                        .addComponent(fieldSubtotalTerimaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel50)
                        .addComponent(fieldStokAwalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52))
                    .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel53)
                        .addComponent(fieldTotalPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanPrisma))
        );

        jDesktopPane20.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane20Layout = new javax.swing.GroupLayout(jDesktopPane20);
        jDesktopPane20.setLayout(jDesktopPane20Layout);
        jDesktopPane20Layout.setHorizontalGroup(
            jDesktopPane20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane20Layout.setVerticalGroup(
            jDesktopPane20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel82.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanPrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanPrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanPrismaMouseClicked(evt);
            }
        });
        jScrollPane50.setViewportView(tablePenerimaanPrisma);

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

        javax.swing.GroupLayout jPanel82Layout = new javax.swing.GroupLayout(jPanel82);
        jPanel82.setLayout(jPanel82Layout);
        jPanel82Layout.setHorizontalGroup(
            jPanel82Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel82Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane50, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prisma3Layout = new javax.swing.GroupLayout(Prisma3);
        Prisma3.setLayout(Prisma3Layout);
        Prisma3Layout.setHorizontalGroup(
            Prisma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Prisma3Layout.createSequentialGroup()
                .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane20))
        );
        Prisma3Layout.setVerticalGroup(
            Prisma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prisma3Layout.createSequentialGroup()
                .addGroup(Prisma3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel82, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Prisma", Prisma3);

        jPanel83.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel83.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel83MouseClicked(evt);
            }
        });

        jLabel190.setText("No Order");

        jLabel191.setText("Tanggal Penerimaan");

        jLabel69.setText("Jumlah Terima");

        jLabel55.setText("No Pemesanan");

        ComboNoPemesananDokumenFilateli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Pemesanan -" }));
        ComboNoPemesananDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboNoPemesananDokumenFilateliActionPerformed(evt);
            }
        });
        ComboNoPemesananDokumenFilateli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboNoPemesananDokumenFilateliKeyReleased(evt);
            }
        });

        jLabel56.setText("Nama Produk");

        fieldNamaProdukDokumenFilateli.setEditable(false);

        fieldKodeProdukDokumenFilateli.setEditable(false);

        jLabel57.setText("Kode Produk");

        fieldIdSuplierDokumenFilateli.setEditable(false);

        jLabel58.setText("Id Suplier");

        jLabel59.setText("Stok Awal");

        fieldStokAwalDokumenFilateli.setEditable(false);

        jLabel60.setText("Subtotal Terima");

        fieldSubtotalTerimaDokumenFilateli.setEditable(false);

        fieldSisaBelumDikirimDokumenFilateli.setEditable(false);

        jLabel70.setText("Sisa Belum Dikirim");

        fieldTotalPemesananDokumenFilateli.setEditable(false);

        jLabel71.setText("Total Pemesanan");

        jLabel72.setText("Keterangan");

        fieldKeteranganDokumenFilateli.setColumns(20);
        fieldKeteranganDokumenFilateli.setRows(5);
        jScrollPane7.setViewportView(fieldKeteranganDokumenFilateli);

        jButtonSimpanPenerimaanDokumenFilateli.setText("Simpan");
        jButtonSimpanPenerimaanDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimpanPenerimaanDokumenFilateliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel191)
                            .addComponent(jLabel190)
                            .addComponent(jLabel69)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldNoOrderDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel83Layout.createSequentialGroup()
                                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldTotalPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldIdSuplierDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldStokAwalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJmlTerimaDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(98, 98, 98)
                                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel83Layout.createSequentialGroup()
                                        .addComponent(jLabel56)
                                        .addGap(53, 53, 53)
                                        .addComponent(fieldNamaProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel83Layout.createSequentialGroup()
                                            .addComponent(jLabel70)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSisaBelumDikirimDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel83Layout.createSequentialGroup()
                                            .addComponent(jLabel60)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldSubtotalTerimaDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel83Layout.createSequentialGroup()
                                            .addComponent(jLabel57)
                                            .addGap(56, 56, 56)
                                            .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(fieldTglPenerimaanDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboNoPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButtonSimpanPenerimaanDokumenFilateli))
                    .addGroup(jPanel83Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel55)))
                .addContainerGap(133, Short.MAX_VALUE))
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel83Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel190)
                    .addComponent(fieldNoOrderDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPenerimaanDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel191, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55)
                    .addComponent(ComboNoPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(fieldNamaProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69)
                    .addComponent(fieldJmlTerimaDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel57)
                        .addComponent(fieldKodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel58)
                        .addComponent(fieldIdSuplierDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel60)
                        .addComponent(fieldSubtotalTerimaDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel59)
                        .addComponent(fieldStokAwalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldSisaBelumDikirimDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel70))
                    .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel71)
                        .addComponent(fieldTotalPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel72)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButtonSimpanPenerimaanDokumenFilateli))
        );

        jDesktopPane21.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jDesktopPane21Layout = new javax.swing.GroupLayout(jDesktopPane21);
        jDesktopPane21.setLayout(jDesktopPane21Layout);
        jDesktopPane21Layout.setHorizontalGroup(
            jDesktopPane21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane21Layout.setVerticalGroup(
            jDesktopPane21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel84.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Produk"));

        tablePenerimaanDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePenerimaanDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePenerimaanDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane52.setViewportView(tablePenerimaanDokumenFilateli);

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

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane52, javax.swing.GroupLayout.DEFAULT_SIZE, 1185, Short.MAX_VALUE)
            .addGroup(jPanel84Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane52, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateli3Layout = new javax.swing.GroupLayout(DokumenFilateli3);
        DokumenFilateli3.setLayout(DokumenFilateli3Layout);
        DokumenFilateli3Layout.setHorizontalGroup(
            DokumenFilateli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DokumenFilateli3Layout.createSequentialGroup()
                .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane21))
        );
        DokumenFilateli3Layout.setVerticalGroup(
            DokumenFilateli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DokumenFilateli3Layout.createSequentialGroup()
                .addGroup(DokumenFilateli3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDesktopPane21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Dokumen Filateli", DokumenFilateli3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel39MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel39MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel39MouseClicked

    private void tablePenerimaanPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanPrangkoMouseClicked

    private void buttonCariPrangko15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko15ActionPerformed

    private void fieldCariPrangko15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko15MouseClicked

    private void Prangko3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prangko3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Prangko3MouseClicked

    private void jPanel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel73MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel73MouseClicked

    private void tablePenerimaanMS_SSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanMS_SSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanMS_SSMouseClicked

    private void buttonCariPrangko16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko16ActionPerformed

    private void fieldCariPrangko16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko16MouseClicked

    private void MS_SS3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SS3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SS3MouseClicked

    private void jPanel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel75MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel75MouseClicked

    private void tablePenerimaanSHP_SHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanSHP_SHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanSHP_SHPSSMouseClicked

    private void buttonCariPrangko17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko17ActionPerformed

    private void fieldCariPrangko17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko17MouseClicked

    private void SHP_SHPSS3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSS3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSS3MouseClicked

    private void jPanel77MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel77MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel77MouseClicked

    private void tablePenerimaanKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanKemasanMouseClicked

    private void buttonCariPrangko18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko18ActionPerformed

    private void fieldCariPrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko18MouseClicked

    private void Kemasan3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kemasan3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Kemasan3MouseClicked

    private void jPanel79MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel79MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel79MouseClicked

    private void tablePenerimaanMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanMerchandiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanMerchandiseMouseClicked

    private void buttonCariPrangko19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko19ActionPerformed

    private void fieldCariPrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko19MouseClicked

    private void jPanel81MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel81MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel81MouseClicked

    private void tablePenerimaanPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanPrismaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanPrismaMouseClicked

    private void buttonCariPrangko20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko20ActionPerformed

    private void fieldCariPrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko20MouseClicked

    private void jPanel83MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel83MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel83MouseClicked

    private void tablePenerimaanDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePenerimaanDokumenFilateliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePenerimaanDokumenFilateliMouseClicked

    private void buttonCariPrangko21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko21ActionPerformed

    private void fieldCariPrangko21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko21MouseClicked

    private void jTabbedPane5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane5MouseClicked

    private void jButtonSimpanPenerimaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrder.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaan.getDate());
        String jumlahTerima = fieldJmlTerima.getText();
        String noPemesanan = ComboNoPemesanan.getSelectedItem().toString();
        String stokAwal = fieldStokAwal.getText();
        String keterangan = fieldKeterangan.getText();
        String totalPemesanan = fieldTotalPemesanan.getText();
        String idSuplier = fieldIdSuplier.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerima.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirim.getText();
        String kodeProduk = fieldKodeProduk.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrder.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrder.requestFocus();
            fieldNoOrder.setEditable(true);
        } else if (fieldTglPenerimaan.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaan.requestFocus();
        } else if (fieldJmlTerima.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerima.requestFocus();
            fieldJmlTerima.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
        
    }//GEN-LAST:event_jButtonSimpanPenerimaanActionPerformed

    private void getDataPrangko(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanPrangko();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanPrangko.setRowSorter(sorter);
        tablePenerimaanPrangko.setModel(penerimaanTableModel);
    }
    
    private void getDataMS_SS(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanMS_SS();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanMS_SS.setRowSorter(sorter);
        tablePenerimaanMS_SS.setModel(penerimaanTableModel);
    }
    
    private void getDataSHP_SHPSS(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanSHP_SHPSS();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanSHP_SHPSS.setRowSorter(sorter);
        tablePenerimaanSHP_SHPSS.setModel(penerimaanTableModel);
    }
    
    private void getDataKemasan(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanKemasan();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanKemasan.setRowSorter(sorter);
        tablePenerimaanKemasan.setModel(penerimaanTableModel);
    }
    
    private void getDataMerchandise(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanMerchandise();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanMerchandise.setRowSorter(sorter);
        tablePenerimaanMerchandise.setModel(penerimaanTableModel);
    }
    
    private void getDataPrisma(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanPrisma();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanPrisma.setRowSorter(sorter);
        tablePenerimaanPrisma.setModel(penerimaanTableModel);
    }
    
    private void getDataDokumenFilateli(){
        dao = new PenerimaanDAOImpl();
        arrayPenerimaan = dao.getDataPenerimaanDokumenFilateli();

        PenerimaanTM penerimaanTableModel = new PenerimaanTM();
        penerimaanTableModel.setDataPenerimaan(arrayPenerimaan);
        sorter = new TableRowSorter(penerimaanTableModel);
        tablePenerimaanDokumenFilateli.setRowSorter(sorter);
        tablePenerimaanDokumenFilateli.setModel(penerimaanTableModel);
    }
    
    private void ComboNoPemesananKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananKeyReleased

    }//GEN-LAST:event_ComboNoPemesananKeyReleased

    private void ComboNoPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesanan.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananActionPerformed

    private void ComboNoPemesananMS_SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananMS_SSActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananMS_SS.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananMS_SSActionPerformed

    private void ComboNoPemesananMS_SSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananMS_SSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananMS_SSKeyReleased

    private void jButtonSimpanPenerimaanMS_SSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanMS_SSActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderMS_SS.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanMS_SS.getDate());
        String jumlahTerima = fieldJmlTerimaMS_SS.getText();
        String noPemesanan = ComboNoPemesananMS_SS.getSelectedItem().toString();
        String stokAwal = fieldStokAwalMS_SS.getText();
        String keterangan = fieldKeteranganMS_SS.getText();
        String totalPemesanan = fieldTotalPemesananMS_SS.getText();
        String idSuplier = fieldIdSuplierMS_SS.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaMS_SS.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimMS_SS.getText();
        String kodeProduk = fieldKodeProdukMS_SS.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderMS_SS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderMS_SS.requestFocus();
            fieldNoOrderMS_SS.setEditable(true);
        } else if (fieldTglPenerimaanMS_SS.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanMS_SS.requestFocus();
        } else if (fieldJmlTerimaMS_SS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaMS_SS.requestFocus();
            fieldJmlTerimaMS_SS.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_jButtonSimpanPenerimaanMS_SSActionPerformed

    private void ComboNoPemesananSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananSHP_SHPSSActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananSHP_SHPSS.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananSHP_SHPSSActionPerformed

    private void ComboNoPemesananSHP_SHPSSKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananSHP_SHPSSKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananSHP_SHPSSKeyReleased

    private void jButtonSimpanPenerimaanSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanSHP_SHPSSActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderSHP_SHPSS.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanSHP_SHPSS.getDate());
        String jumlahTerima = fieldJmlTerimaSHP_SHPSS.getText();
        String noPemesanan = ComboNoPemesananSHP_SHPSS.getSelectedItem().toString();
        String stokAwal = fieldStokAwalSHP_SHPSS.getText();
        String keterangan = fieldKeteranganSHP_SHPSS.getText();
        String totalPemesanan = fieldTotalPemesananSHP_SHPSS.getText();
        String idSuplier = fieldIdSuplierSHP_SHPSS.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaSHP_SHPSS.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimSHP_SHPSS.getText();
        String kodeProduk = fieldKodeProdukSHP_SHPSS.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderSHP_SHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderSHP_SHPSS.requestFocus();
            fieldNoOrderSHP_SHPSS.setEditable(true);
        } else if (fieldTglPenerimaanSHP_SHPSS.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanSHP_SHPSS.requestFocus();
        } else if (fieldJmlTerimaSHP_SHPSS.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaSHP_SHPSS.requestFocus();
            fieldJmlTerimaSHP_SHPSS.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
        
    }//GEN-LAST:event_jButtonSimpanPenerimaanSHP_SHPSSActionPerformed

    private void ComboNoPemesananKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananKemasanActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananKemasan.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananKemasanActionPerformed

    private void ComboNoPemesananKemasanKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananKemasanKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananKemasanKeyReleased

    private void jButtonSimpanPenerimaanKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanKemasanActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderKemasan.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanKemasan.getDate());
        String jumlahTerima = fieldJmlTerimaKemasan.getText();
        String noPemesanan = ComboNoPemesananKemasan.getSelectedItem().toString();
        String stokAwal = fieldStokAwalKemasan.getText();
        String keterangan = fieldKeteranganKemasan.getText();
        String totalPemesanan = fieldTotalPemesananKemasan.getText();
        String idSuplier = fieldIdSuplierKemasan.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaKemasan.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimKemasan.getText();
        String kodeProduk = fieldKodeProdukKemasan.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderKemasan.requestFocus();
            fieldNoOrderKemasan.setEditable(true);
        } else if (fieldTglPenerimaanKemasan.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanKemasan.requestFocus();
        } else if (fieldJmlTerimaKemasan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaKemasan.requestFocus();
            fieldJmlTerimaKemasan.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_jButtonSimpanPenerimaanKemasanActionPerformed

    private void ComboNoPemesananMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananMerchandiseActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananMerchandise.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananMerchandiseActionPerformed

    private void ComboNoPemesananMerchandiseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananMerchandiseKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananMerchandiseKeyReleased

    private void jButtonSimpanPenerimaanMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanMerchandiseActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderMerchandise.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanMerchandise.getDate());
        String jumlahTerima = fieldJmlTerimaMerchandise.getText();
        String noPemesanan = ComboNoPemesananMerchandise.getSelectedItem().toString();
        String stokAwal = fieldStokAwalMerchandise.getText();
        String keterangan = fieldKeteranganMerchandise.getText();
        String totalPemesanan = fieldTotalPemesananMerchandise.getText();
        String idSuplier = fieldIdSuplierMerchandise.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaMerchandise.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimMerchandise.getText();
        String kodeProduk = fieldKodeProdukMerchandise.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderMerchandise.requestFocus();
            fieldNoOrderMerchandise.setEditable(true);
        } else if (fieldTglPenerimaanMerchandise.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanMerchandise.requestFocus();
        } else if (fieldJmlTerimaMerchandise.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaMerchandise.requestFocus();
            fieldJmlTerimaMerchandise.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_jButtonSimpanPenerimaanMerchandiseActionPerformed

    private void ComboNoPemesananPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananPrismaActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananPrisma.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananPrismaActionPerformed

    private void ComboNoPemesananPrismaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananPrismaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananPrismaKeyReleased

    private void jButtonSimpanPenerimaanPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanPrismaActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderPrisma.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanPrisma.getDate());
        String jumlahTerima = fieldJmlTerimaPrisma.getText();
        String noPemesanan = ComboNoPemesananPrisma.getSelectedItem().toString();
        String stokAwal = fieldStokAwalPrisma.getText();
        String keterangan = fieldKeteranganPrisma.getText();
        String totalPemesanan = fieldTotalPemesananPrisma.getText();
        String idSuplier = fieldIdSuplierPrisma.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaPrisma.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimPrisma.getText();
        String kodeProduk = fieldKodeProdukPrisma.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderPrisma.requestFocus();
            fieldNoOrderPrisma.setEditable(true);
        } else if (fieldTglPenerimaanPrisma.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanPrisma.requestFocus();
        } else if (fieldJmlTerimaPrisma.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaPrisma.requestFocus();
            fieldJmlTerimaPrisma.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_jButtonSimpanPenerimaanPrismaActionPerformed

    private void ComboNoPemesananDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboNoPemesananDokumenFilateliActionPerformed
        // TODO add your handling code here:
        String pilihPemesanan = null;
        
        pilihPemesanan = ComboNoPemesananDokumenFilateli.getSelectedItem().toString();
        autoFieldTrue(pilihPemesanan);
    }//GEN-LAST:event_ComboNoPemesananDokumenFilateliActionPerformed

    private void ComboNoPemesananDokumenFilateliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboNoPemesananDokumenFilateliKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboNoPemesananDokumenFilateliKeyReleased

    private void jButtonSimpanPenerimaanDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimpanPenerimaanDokumenFilateliActionPerformed
        // TODO add your handling code here:
        String noOrder = fieldNoOrderDokumenFilateli.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPenerimaan = dt.format(fieldTglPenerimaanDokumenFilateli.getDate());
        String jumlahTerima = fieldJmlTerimaDokumenFilateli.getText();
        String noPemesanan = ComboNoPemesananDokumenFilateli.getSelectedItem().toString();
        String stokAwal = fieldStokAwalDokumenFilateli.getText();
        String keterangan = fieldKeteranganDokumenFilateli.getText();
        String totalPemesanan = fieldTotalPemesananDokumenFilateli.getText();
        String idSuplier = fieldIdSuplierDokumenFilateli.getText();
        int subTotalTerima = Integer.parseInt(fieldSubtotalTerimaDokumenFilateli.getText());
        String sisaBelumDikirimm = fieldSisaBelumDikirimDokumenFilateli.getText();
        String kodeProduk = fieldKodeProdukDokumenFilateli.getText();
        
        
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNoOrderDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nomor Order tidak boleh Kosong");
            fieldNoOrderDokumenFilateli.requestFocus();
            fieldNoOrderDokumenFilateli.setEditable(true);
        } else if (fieldTglPenerimaanDokumenFilateli.getDate().equals("")) {
            JOptionPane.showMessageDialog(null, "Tangga Penerimaan tidak boleh Kosong");
            fieldTglPenerimaanDokumenFilateli.requestFocus();
        } else if (fieldJmlTerimaDokumenFilateli.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Jumlah terima tidak boleh Kosong");
            fieldJmlTerimaDokumenFilateli.requestFocus();
            fieldJmlTerimaDokumenFilateli.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan pesanan dengan no order " + noOrder
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Penerimaan penerimaan = new Penerimaan();
            penerimaan.setNoOrder(noOrder);
            penerimaan.setTglPenerimaan(tanggalPenerimaan);
            penerimaan.setJmlTerima(Integer.parseInt(jumlahTerima));
            penerimaan.setNoPemesanan(noPemesanan);
            penerimaan.setIdSuplier(idSuplier);
            penerimaan.setStokAwal(Integer.parseInt(stokAwal));
            int stokAkhir = Integer.parseInt(stokAwal) + Integer.parseInt(jumlahTerima);
            penerimaan.setStokAkhir(stokAkhir);
            
            subTotalTerima = subTotalTerima + Integer.parseInt(jumlahTerima);
            
            penerimaan.setSubTotalTerima(subTotalTerima);
            
            int sisaBelumDikirim = Integer.parseInt(totalPemesanan)-subTotalTerima;
            
            penerimaan.setSisaBelumDikirim(sisaBelumDikirim);
            penerimaan.setKeterangan(keterangan);
            penerimaan.setIdProduk(kodeProduk);
            
            //inisialisasi
            PenerimaanDAO dao = new PenerimaanDAOImpl();
            boolean sukses = dao.tambahPenerimaan(penerimaan);
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_jButtonSimpanPenerimaanDokumenFilateliActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboNoPemesanan;
    private javax.swing.JComboBox<String> ComboNoPemesananDokumenFilateli;
    private javax.swing.JComboBox<String> ComboNoPemesananKemasan;
    private javax.swing.JComboBox<String> ComboNoPemesananMS_SS;
    private javax.swing.JComboBox<String> ComboNoPemesananMerchandise;
    private javax.swing.JComboBox<String> ComboNoPemesananPrisma;
    private javax.swing.JComboBox<String> ComboNoPemesananSHP_SHPSS;
    private javax.swing.JPanel DokumenFilateli3;
    private javax.swing.JPanel Kemasan3;
    private javax.swing.JPanel MS_SS3;
    private javax.swing.JPanel Merchandise3;
    private javax.swing.JPanel Prangko3;
    private javax.swing.JPanel Prisma3;
    private javax.swing.JPanel SHP_SHPSS3;
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
    private javax.swing.JTextField fieldIdSuplier;
    private javax.swing.JTextField fieldIdSuplierDokumenFilateli;
    private javax.swing.JTextField fieldIdSuplierKemasan;
    private javax.swing.JTextField fieldIdSuplierMS_SS;
    private javax.swing.JTextField fieldIdSuplierMerchandise;
    private javax.swing.JTextField fieldIdSuplierPrisma;
    private javax.swing.JTextField fieldIdSuplierSHP_SHPSS;
    private javax.swing.JTextField fieldJmlTerima;
    private javax.swing.JTextField fieldJmlTerimaDokumenFilateli;
    private javax.swing.JTextField fieldJmlTerimaKemasan;
    private javax.swing.JTextField fieldJmlTerimaMS_SS;
    private javax.swing.JTextField fieldJmlTerimaMerchandise;
    private javax.swing.JTextField fieldJmlTerimaPrisma;
    private javax.swing.JTextField fieldJmlTerimaSHP_SHPSS;
    private javax.swing.JTextArea fieldKeterangan;
    private javax.swing.JTextArea fieldKeteranganDokumenFilateli;
    private javax.swing.JTextArea fieldKeteranganKemasan;
    private javax.swing.JTextArea fieldKeteranganMS_SS;
    private javax.swing.JTextArea fieldKeteranganMerchandise;
    private javax.swing.JTextArea fieldKeteranganPrisma;
    private javax.swing.JTextArea fieldKeteranganSHP_SHPSS;
    private javax.swing.JTextField fieldKodeProduk;
    private javax.swing.JTextField fieldKodeProdukDokumenFilateli;
    private javax.swing.JTextField fieldKodeProdukKemasan;
    private javax.swing.JTextField fieldKodeProdukMS_SS;
    private javax.swing.JTextField fieldKodeProdukMerchandise;
    private javax.swing.JTextField fieldKodeProdukPrisma;
    private javax.swing.JTextField fieldKodeProdukSHP_SHPSS;
    private javax.swing.JTextField fieldNamaProduk;
    private javax.swing.JTextField fieldNamaProdukDokumenFilateli;
    private javax.swing.JTextField fieldNamaProdukKemasan;
    private javax.swing.JTextField fieldNamaProdukMS_SS;
    private javax.swing.JTextField fieldNamaProdukMerchandise;
    private javax.swing.JTextField fieldNamaProdukPrisma;
    private javax.swing.JTextField fieldNamaProdukSHP_SHPSS;
    private javax.swing.JTextField fieldNoOrder;
    private javax.swing.JTextField fieldNoOrderDokumenFilateli;
    private javax.swing.JTextField fieldNoOrderKemasan;
    private javax.swing.JTextField fieldNoOrderMS_SS;
    private javax.swing.JTextField fieldNoOrderMerchandise;
    private javax.swing.JTextField fieldNoOrderPrisma;
    private javax.swing.JTextField fieldNoOrderSHP_SHPSS;
    private javax.swing.JTextField fieldSisaBelumDikirim;
    private javax.swing.JTextField fieldSisaBelumDikirimDokumenFilateli;
    private javax.swing.JTextField fieldSisaBelumDikirimKemasan;
    private javax.swing.JTextField fieldSisaBelumDikirimMS_SS;
    private javax.swing.JTextField fieldSisaBelumDikirimMerchandise;
    private javax.swing.JTextField fieldSisaBelumDikirimPrisma;
    private javax.swing.JTextField fieldSisaBelumDikirimSHP_SHPSS;
    private javax.swing.JTextField fieldStokAwal;
    private javax.swing.JTextField fieldStokAwalDokumenFilateli;
    private javax.swing.JTextField fieldStokAwalKemasan;
    private javax.swing.JTextField fieldStokAwalMS_SS;
    private javax.swing.JTextField fieldStokAwalMerchandise;
    private javax.swing.JTextField fieldStokAwalPrisma;
    private javax.swing.JTextField fieldStokAwalSHP_SHPSS;
    private javax.swing.JTextField fieldSubtotalTerima;
    private javax.swing.JTextField fieldSubtotalTerimaDokumenFilateli;
    private javax.swing.JTextField fieldSubtotalTerimaKemasan;
    private javax.swing.JTextField fieldSubtotalTerimaMS_SS;
    private javax.swing.JTextField fieldSubtotalTerimaMerchandise;
    private javax.swing.JTextField fieldSubtotalTerimaPrisma;
    private javax.swing.JTextField fieldSubtotalTerimaSHP_SHPSS;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaan;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanDokumenFilateli;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanKemasan;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanMS_SS;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanMerchandise;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanPrisma;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaanSHP_SHPSS;
    private javax.swing.JTextField fieldTotalPemesanan;
    private javax.swing.JTextField fieldTotalPemesananDokumenFilateli;
    private javax.swing.JTextField fieldTotalPemesananKemasan;
    private javax.swing.JTextField fieldTotalPemesananMS_SS;
    private javax.swing.JTextField fieldTotalPemesananMerchandise;
    private javax.swing.JTextField fieldTotalPemesananPrisma;
    private javax.swing.JTextField fieldTotalPemesananSHP_SHPSS;
    private javax.swing.JButton jButtonSimpanPenerimaan;
    private javax.swing.JButton jButtonSimpanPenerimaanDokumenFilateli;
    private javax.swing.JButton jButtonSimpanPenerimaanKemasan;
    private javax.swing.JButton jButtonSimpanPenerimaanMS_SS;
    private javax.swing.JButton jButtonSimpanPenerimaanMerchandise;
    private javax.swing.JButton jButtonSimpanPenerimaanPrisma;
    private javax.swing.JButton jButtonSimpanPenerimaanSHP_SHPSS;
    private javax.swing.JDesktopPane jDesktopPane15;
    private javax.swing.JDesktopPane jDesktopPane16;
    private javax.swing.JDesktopPane jDesktopPane17;
    private javax.swing.JDesktopPane jDesktopPane18;
    private javax.swing.JDesktopPane jDesktopPane19;
    private javax.swing.JDesktopPane jDesktopPane20;
    private javax.swing.JDesktopPane jDesktopPane21;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel73;
    private javax.swing.JPanel jPanel74;
    private javax.swing.JPanel jPanel75;
    private javax.swing.JPanel jPanel76;
    private javax.swing.JPanel jPanel77;
    private javax.swing.JPanel jPanel78;
    private javax.swing.JPanel jPanel79;
    private javax.swing.JPanel jPanel80;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel82;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable tablePenerimaanDokumenFilateli;
    private javax.swing.JTable tablePenerimaanKemasan;
    private javax.swing.JTable tablePenerimaanMS_SS;
    private javax.swing.JTable tablePenerimaanMerchandise;
    private javax.swing.JTable tablePenerimaanPrangko;
    private javax.swing.JTable tablePenerimaanPrisma;
    private javax.swing.JTable tablePenerimaanSHP_SHPSS;
    // End of variables declaration//GEN-END:variables
}
