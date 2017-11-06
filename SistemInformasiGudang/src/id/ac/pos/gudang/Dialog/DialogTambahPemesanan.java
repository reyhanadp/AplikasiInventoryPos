/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PemesananDAOImpl;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Operator
 */
public class DialogTambahPemesanan extends javax.swing.JDialog {

    /**
     * Creates new form DialogTambahPemesanan
     */
    private Connection conn;
    
    public DialogTambahPemesanan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        conn = DatabaseConnectivity.getConnection();
        setModelNamaSuplier();
        autoIncrementNoPemesanan();
        autoincrementPrangko();
        setLocationRelativeTo(this);
    }
    
    public void setModelNamaSuplier(){
        try {
            System.out.println("1");
            String query = "SELECT nama_suplier FROM tb_suplier ORDER BY nama_suplier";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboNamaSuplier.addItem(result.getString("nama_suplier"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    DialogTambahPemesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void resetField(){
        fieldBiayaCetakPemesanan.setText("");
        fieldJumlahPemesanan.setText("");
        fieldNamaProdukPemesanan.setText("");
        fieldNominalPemesanan.setText("");
        fieldTahunPemesanan.setText("");
        fieldTglPemesanan.setDateFormatString("");
        autoincrementDokumenFilateli();
        autoincrementKemasan();
        autoincrementMerchandise();
        autoincrementPrangko();
        autoincrementPrisma();
    }
    
    public String CariJenis(){ 
    String Jenis = comboJenisPesan.getSelectedItem().toString();
        if (Jenis.equals("Dokumen Filateli")){
            Jenis = "DF";
        }else if (Jenis.equals("Prangko")){
            Jenis = "PR";
        }else if (Jenis.equals("MS")){
            Jenis = "MS";
        }else if (Jenis.equals("SS")){
            Jenis = "SS";
        }else if (Jenis.equals("SHP")){
            Jenis = "SHP";
        }else if (Jenis.equals("SHPSS")){
            Jenis = "SHPSS";
        }else if (Jenis.equals("Prisma")){
            Jenis = "PS";
        }else if (Jenis.equals("Kemasan")){
            Jenis = "KM";
        }else if (Jenis.equals("Merchandise")){
            Jenis = "MC";
        }
        
        return Jenis;
    }
    
    private void autoincrementDokumenFilateli() {
        String kosong = null;
        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kode_dokumen_filateli);
    }
    
    private void autoincrementKemasan() {
        String kosong = null;
        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kode_prangko);
    }
    
     private void autoincrementMS_SS(String jenisMS_SS) {
        String kosong = null;
        String jenisProduk = null;

        ProdukDAOImpl dao = new ProdukDAOImpl();
        if (jenisMS_SS.equals("MS")) {
            jenisProduk = "MS";
            //Tambahkan pilihan item untuk buah

        } else if (jenisMS_SS.equals("SS")) {
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
        fieldKodeProdukPemesanan.setText(kodeMS_SS);
    }
     
     private void autoincrementMerchandise() {
        String kosong = null;
        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kode_merchandise);
    }
     
     private void autoincrementPrangko() {
        String kosong = null;
        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kode_prangko);
    }
     
     private void autoincrementPrisma() {
        String kosong = null;
        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kode_prisma);
    }
     
     private void autoincrementSHP_SHPSS(String jenisSHP_SHPSS) {
        String kosong = null;
        String jenisProduk = null;
        String sub_nomor_string = null;

        ProdukDAOImpl dao = new ProdukDAOImpl();
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
        fieldKodeProdukPemesanan.setText(kodeSHP_SHPSS);
    }
     
     private void autoIncrementNoPemesanan(){
        String kosong = null;
        PemesananDAOImpl dao = new PemesananDAOImpl();

        String no_pemesanan = dao.getNoPemesanan();
        if (no_pemesanan == null) {
            no_pemesanan = "00000";
        }
        int sub_nomor_int = Integer.parseInt(no_pemesanan);
        String nomor_string = String.valueOf(sub_nomor_int);
        int panjang = nomor_string.length();
        switch (panjang) {
            case 1:
                kosong = "0000";
                break;
            case 2:
                kosong = "000";
                break;
            case 3:
                kosong = "00";
                break;
            case 4:
                kosong = "0";
                break;
            case 5:
                kosong = null;
                break;
            default:
                break;
        }
        sub_nomor_int = sub_nomor_int + 1;
        nomor_string = String.valueOf(sub_nomor_int);
        no_pemesanan =kosong + nomor_string;
        fieldNoPemesanan.setText(no_pemesanan);
     }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSimpanPesanPemesanan = new javax.swing.JButton();
        jButton70 = new javax.swing.JButton();
        fieldTglPemesanan = new com.toedter.calendar.JDateChooser();
        fieldTahunPemesanan = new javax.swing.JTextField();
        fieldBiayaCetakPemesanan = new javax.swing.JTextField();
        fieldNominalPemesanan = new javax.swing.JTextField();
        fieldNamaProdukPemesanan = new javax.swing.JTextField();
        fieldKodeProdukPemesanan = new javax.swing.JTextField();
        fieldNoPemesanan = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        fieldJumlahPemesanan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel120 = new javax.swing.JLabel();
        comboJenisPesan = new javax.swing.JComboBox<>();
        jLabel121 = new javax.swing.JLabel();
        comboNamaSuplier = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonSimpanPesanPemesanan.setText("Simpan");
        buttonSimpanPesanPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPesanPemesananActionPerformed(evt);
            }
        });

        jButton70.setText("Reset");

        fieldTahunPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunPemesananKeyPressed(evt);
            }
        });

        fieldBiayaCetakPemesanan.setToolTipText("");
        fieldBiayaCetakPemesanan.setAutoscrolls(false);
        fieldBiayaCetakPemesanan.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        fieldBiayaCetakPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBiayaCetakPemesananActionPerformed(evt);
            }
        });
        fieldBiayaCetakPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldBiayaCetakPemesananKeyTyped(evt);
            }
        });

        fieldNominalPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalPemesananKeyTyped(evt);
            }
        });

        fieldNamaProdukPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPemesananKeyTyped(evt);
            }
        });

        fieldKodeProdukPemesanan.setEditable(false);
        fieldKodeProdukPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldKodeProdukPemesananActionPerformed(evt);
            }
        });

        fieldNoPemesanan.setEditable(false);
        fieldNoPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNoPemesananKeyPressed(evt);
            }
        });

        jLabel112.setText("No. Pemesanan");

        jLabel113.setText("Kode Produk");

        jLabel114.setText("Nama Produk");

        jLabel115.setText("Nominal");

        jLabel116.setText("Biaya Cetak  ");

        jLabel117.setText("Tahun");

        jLabel118.setText("Jumlah Pesan");

        jLabel119.setText("Tanggal Pesan");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TAMBAH DATA PEMESANAN");

        jLabel120.setText("Jenis Produk");

        comboJenisPesan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prangko", "MS", "SS", "SHP", "SHPSS", "Kemasan", "Prisma", "Merchandise", "Dokumen Filateli" }));
        comboJenisPesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboJenisPesanActionPerformed(evt);
            }
        });

        jLabel121.setText("Nama Suplier");

        comboNamaSuplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Suplier -" }));
        comboNamaSuplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNamaSuplierActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel120)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel117)
                                .addComponent(jLabel115)
                                .addComponent(jLabel116)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel119)
                                    .addGap(18, 18, 18)
                                    .addComponent(buttonSimpanPesanPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton70, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel112)
                                        .addComponent(jLabel113)
                                        .addComponent(jLabel114)
                                        .addComponent(jLabel118))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldNominalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldKodeProdukPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldBiayaCetakPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldTahunPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldJumlahPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldTglPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboNamaSuplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboJenisPesan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(fieldNoPemesanan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(fieldNamaProdukPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel121)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel120, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboJenisPesan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(fieldNoPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(fieldKodeProdukPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(comboNamaSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel114)
                    .addComponent(fieldNamaProdukPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(fieldNominalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel116)
                    .addComponent(fieldBiayaCetakPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(fieldTahunPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(fieldJumlahPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTglPemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSimpanPesanPemesanan)
                    .addComponent(jButton70))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanPesanPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanPesanPemesananActionPerformed
        // TODO add your handling code here:
        String noPemesanan = fieldNoPemesanan.getText();
        String kodeProduk = fieldKodeProdukPemesanan.getText();
        String namaProduk = fieldNamaProdukPemesanan.getText();
        String nominal = fieldNominalPemesanan.getText();
        String biayaCetak = fieldBiayaCetakPemesanan.getText();
        String tahun = fieldTahunPemesanan.getText();
        String jumlahPemesanan = fieldJumlahPemesanan.getText();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        
        String tanggalPemesanan = dt.format(fieldTglPemesanan.getDate());
        String namaSuplier = comboNamaSuplier.getSelectedItem().toString();
        String idSuplier = null;
        
        try {
            String query = "SELECT id_suplier FROM tb_suplier where nama_suplier = '"+namaSuplier+"'";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {                      
                idSuplier = result.getString("id_suplier");
            }
           
        } catch (SQLException e) {
        }
        //validasi apakah filed 
        //sudah diisi atau belum
        if (fieldNamaProdukPemesanan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nama Produk tidak boleh Kosong");
            fieldNamaProdukPemesanan.requestFocus();
            fieldNamaProdukPemesanan.setEditable(true);
        } else if (fieldNominalPemesanan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nominal tidak boleh Kosong");
            fieldNominalPemesanan.requestFocus();
            fieldNominalPemesanan.setEditable(true);
        } else if (fieldBiayaCetakPemesanan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Biaya Cetak tidak boleh Kosong");
            fieldBiayaCetakPemesanan.requestFocus();
            fieldBiayaCetakPemesanan.setEditable(true);
            
        } else if (fieldTahunPemesanan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Tahun tidak boleh Kosong");
            fieldTahunPemesanan.requestFocus();
            fieldTahunPemesanan.setEditable(true);
            
        } else {
            JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan " + namaProduk
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            //buat objek pegawai
            Pemesanan pemesanan = new Pemesanan();
            pemesanan.setNoPemesanan(noPemesanan);
            pemesanan.setKodeProduk(kodeProduk);
            pemesanan.setNamaProduk(namaProduk);
            pemesanan.setNominal(Integer.parseInt(nominal));
            pemesanan.setBiayaCetak(Float.parseFloat(biayaCetak));
            pemesanan.setTahun(tahun);
            pemesanan.setJumlahPemesanan(Integer.parseInt(jumlahPemesanan));
            pemesanan.setTglPemesanan(tanggalPemesanan);
            pemesanan.setIdSuplier(idSuplier);

            //inisialisasi
            PemesananDAO dao = new PemesananDAOImpl();
            boolean sukses = dao.tambahPemesanan(pemesanan, CariJenis());
            //cek sukses atau tidak
            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                autoIncrementNoPemesanan();
                resetField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
            }
        }
    }//GEN-LAST:event_buttonSimpanPesanPemesananActionPerformed

    private void fieldTahunPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTahunPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTahunPemesananKeyPressed

    private void fieldBiayaCetakPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBiayaCetakPemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBiayaCetakPemesananActionPerformed

    private void fieldBiayaCetakPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBiayaCetakPemesananKeyPressed

    private void fieldBiayaCetakPemesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldBiayaCetakPemesananKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBiayaCetakPemesananKeyTyped

    private void fieldNominalPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNominalPemesananKeyPressed

    private void fieldNominalPemesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNominalPemesananKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNominalPemesananKeyTyped

    private void fieldNamaProdukPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaProdukPemesananKeyPressed

    private void fieldNamaProdukPemesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaProdukPemesananKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaProdukPemesananKeyTyped

    private void fieldKodeProdukPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldKodeProdukPemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKodeProdukPemesananActionPerformed

    private void fieldNoPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoPemesananKeyPressed

    private void comboJenisPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisPesanActionPerformed
        // TODO add your handling code here:
        String Jenis = comboJenisPesan.getSelectedItem().toString();
        if (Jenis.equals("Dokumen Filateli")){
            autoincrementDokumenFilateli();
        }else if (Jenis.equals("Prangko")){
            autoincrementPrangko();
        }else if (Jenis.equals("MS")){
            autoincrementMS_SS("MS");
        }else if (Jenis.equals("SS")){
            autoincrementMS_SS("SS");
        }else if (Jenis.equals("SHP")){
            autoincrementSHP_SHPSS("SHP");
        }else if (Jenis.equals("SHPSS")){
            autoincrementSHP_SHPSS("SHPSS");
        }else if (Jenis.equals("Prisma")){
            autoincrementPrisma();
        }else if (Jenis.equals("Kemasan")){
            autoincrementKemasan();
        }else if (Jenis.equals("Merchandise")){
            autoincrementMerchandise();
        }
    }//GEN-LAST:event_comboJenisPesanActionPerformed

    private void comboNamaSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNamaSuplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNamaSuplierActionPerformed

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
            java.util.logging.Logger.getLogger(DialogTambahPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPemesanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTambahPemesanan dialog = new DialogTambahPemesanan(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonSimpanPesanPemesanan;
    private javax.swing.JComboBox<String> comboJenisPesan;
    private javax.swing.JComboBox<String> comboNamaSuplier;
    private javax.swing.JTextField fieldBiayaCetakPemesanan;
    private javax.swing.JTextField fieldJumlahPemesanan;
    private javax.swing.JTextField fieldKodeProdukPemesanan;
    private javax.swing.JTextField fieldNamaProdukPemesanan;
    private javax.swing.JTextField fieldNoPemesanan;
    private javax.swing.JTextField fieldNominalPemesanan;
    private javax.swing.JTextField fieldTahunPemesanan;
    private com.toedter.calendar.JDateChooser fieldTglPemesanan;
    private javax.swing.JButton jButton70;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
