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
import java.awt.event.KeyEvent;
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
        setLocationRelativeTo(this);

    }
    
    public void resetField(){
        comboJenisPesan.setSelectedItem("- Pilih Jenis -");
        comboKodeProduk.setSelectedItem("- Pilih Kode -");
        comboNamaSuplier.setSelectedItem("- Pilih Suplier -");
        fieldBiayaCetakPemesanan.setText("");
        fieldJumlahPemesanan.setText("");
        fieldNamaProdukPemesanan.setText("");
        fieldNominalPemesanan.setText("");
        fieldTahunPemesanan.setText("");
        fieldTglPemesanan.setDateFormatString("");
    }
    
    public boolean validasiTanggal(){
        java.sql.Date date=java.sql.Date.valueOf("1990-11-12");
            if(fieldTglPemesanan.getDate() == null){
                date = (java.sql.Date) fieldTglPemesanan.getDate();
            }
       
        if (date == null) 
        {           
            return false;
        }else{
        return true;
        }
    }
    
    public void autofillfield(String kode){
        PreparedStatement state = null;
        try {
            String query = "SELECT * FROM tb_produk WHERE id_produk='"+kode+"'";
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query); 
            while (result.next()) {   
                fieldBiayaCetakPemesanan.setText(result.getString("biaya_cetak"));
                fieldNamaProdukPemesanan.setText(result.getString("nama_produk"));
                fieldNominalPemesanan.setText(result.getString("nominal"));
                fieldTahunPemesanan.setText(result.getString("tahun"));
            }         
        } catch (SQLException e) {
        }
    }
    
    public void setModelNamaSuplier(){
        try {
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
    
    public void setKosongCombo(){
        setModelKosongProdukDokumenFilateli();
        setModelKosongProdukKemasan();
        setModelKosongProdukMS();
        setModelKosongProdukMerchandise();
        setModelKosongProdukPrangko();
        setModelKosongProdukPrisma();
        setModelKosongProdukSHP();
        setModelKosongProdukSHPSS();
        setModelKosongProdukSS();
    }
    
    public void setModelKosongProdukPrangko(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='PR' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukMS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='MS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukSS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukSHP(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SHP' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukSHPSS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SHPSS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukKemasan(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='KM' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukMerchandise(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='MC' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukPrisma(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='PS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKosongProdukDokumenFilateli(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='DF' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
     
                comboKodeProduk.removeItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukPrangko(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='PR' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukMS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='MS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukSS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukSHP(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SHP' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukSHPSS(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='SHPSS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukKemasan(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='KM' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukMerchandise(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='MC' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukPrisma(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='PS' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
                
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    public void setModelKodeProdukDokumenFilateli(){
        try {
            String query = "SELECT id_produk FROM tb_produk WHERE id_jenis_produk ='DF' ORDER BY id_produk";
            PreparedStatement state = null;
            state = conn.prepareStatement(query);
            ResultSet result = state.executeQuery(query);
             
            while (result.next()) {   
     
                comboKodeProduk.addItem(result.getString("id_produk"));
            }
           
        } catch (SQLException e) {
        }
    }
    
    DialogTambahPemesanan() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if(nomor_string.substring(panjang-1).equals("9")){
            panjang=panjang+1;
        }
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

        radioPrangko = new javax.swing.ButtonGroup();
        buttonSimpanPesanPemesanan = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        fieldTglPemesanan = new com.toedter.calendar.JDateChooser();
        fieldTahunPemesanan = new javax.swing.JTextField();
        fieldBiayaCetakPemesanan = new javax.swing.JTextField();
        fieldNominalPemesanan = new javax.swing.JTextField();
        fieldNamaProdukPemesanan = new javax.swing.JTextField();
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
        comboKodeProduk = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonSimpanPesanPemesanan.setText("Simpan");
        buttonSimpanPesanPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSimpanPesanPemesananActionPerformed(evt);
            }
        });

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        fieldTahunPemesanan.setEditable(false);
        fieldTahunPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldTahunPemesananKeyPressed(evt);
            }
        });

        fieldBiayaCetakPemesanan.setEditable(false);
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

        fieldNominalPemesanan.setEditable(false);
        fieldNominalPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNominalPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNominalPemesananKeyTyped(evt);
            }
        });

        fieldNamaProdukPemesanan.setEditable(false);
        fieldNamaProdukPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNamaProdukPemesananKeyTyped(evt);
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

        fieldJumlahPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldJumlahPemesananKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("TAMBAH DATA PEMESANAN");

        jLabel120.setText("Jenis Produk");

        comboJenisPesan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis -", "Prangko", "MS", "SS", "SHP", "SHPSS", "Kemasan", "Prisma", "Merchandise", "Dokumen Filateli" }));
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

        comboKodeProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Kode -" }));
        comboKodeProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKodeProdukActionPerformed(evt);
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
                            .addComponent(jLabel117)
                            .addComponent(jLabel115)
                            .addComponent(jLabel116)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel119)
                                .addGap(18, 18, 18)
                                .addComponent(buttonSimpanPesanPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel112)
                                    .addComponent(jLabel113)
                                    .addComponent(jLabel114)
                                    .addComponent(jLabel118))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldNominalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldBiayaCetakPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTahunPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldJumlahPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTglPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNamaProdukPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(comboKodeProduk, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboNamaSuplier, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboJenisPesan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fieldNoPemesanan, javax.swing.GroupLayout.Alignment.LEADING))))
                            .addComponent(jLabel121))))
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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel113)
                    .addComponent(comboKodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(buttonReset))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSimpanPesanPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSimpanPesanPemesananActionPerformed
        // TODO add your handling code here:
        String tanggalPemesanan="";
        
        String noPemesanan = fieldNoPemesanan.getText();
        String kodeProduk = comboKodeProduk.getSelectedItem().toString();
        String namaProduk = fieldNamaProdukPemesanan.getText();
        String nominal = fieldNominalPemesanan.getText();
        String biayaCetak = fieldBiayaCetakPemesanan.getText();
        String tahun = fieldTahunPemesanan.getText();
        String jumlahPemesanan = fieldJumlahPemesanan.getText();
        
        if(validasiTanggal()==true){
            SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
            tanggalPemesanan = dt.format(fieldTglPemesanan.getDate());            
        }else {    
            JOptionPane.showMessageDialog(null, "Tanggal tidak boleh kosong !");
        }String namaSuplier = comboNamaSuplier.getSelectedItem().toString();
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
        System.out.println(comboJenisPesan.getSelectedItem());
        if (comboJenisPesan.getSelectedItem()== "- Pilih Jenis -") {
            JOptionPane.showMessageDialog(null, "Jenis produk belum dipilih!");
            comboJenisPesan.requestFocus();
        }else if (comboKodeProduk.getSelectedItem()== "- Pilih Kode -") {
            JOptionPane.showMessageDialog(null, "Kode produk belum dipilih!");
            comboKodeProduk.requestFocus();
        } else if (comboNamaSuplier.getSelectedItem()== "- Pilih Suplier -") {
            JOptionPane.showMessageDialog(null, "Suplier belum dipilih!");
            comboNamaSuplier.requestFocus();
        }else if (jumlahPemesanan.equals("")||jumlahPemesanan.equals("0")) {
            JOptionPane.showMessageDialog(null, "Jumlah pemesanan tidak boleh kosong atau 0!");
            fieldJumlahPemesanan.requestFocus();
        }else {
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

    private void fieldNoPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoPemesananKeyPressed

    private void comboJenisPesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboJenisPesanActionPerformed
        // TODO add your handling code here:
        String Jenis = comboJenisPesan.getSelectedItem().toString();
        
        if (Jenis.equals("Dokumen Filateli")){
            setKosongCombo();
            setModelKodeProdukDokumenFilateli();
        }else if (Jenis.equals("Prangko")){
            setKosongCombo();
            setModelKodeProdukPrangko();
        }else if (Jenis.equals("MS")){
            setKosongCombo();
            setModelKodeProdukMS();
        }else if (Jenis.equals("SS")){
            setKosongCombo();
            setModelKodeProdukSS();
        }else if (Jenis.equals("SHP")){
            setKosongCombo();
            setModelKodeProdukSHP();
        }else if (Jenis.equals("SHPSS")){
            setKosongCombo();
            setModelKodeProdukSHPSS();
        }else if (Jenis.equals("Prisma")){
            setKosongCombo();
            setModelKodeProdukPrisma();
        }else if (Jenis.equals("Kemasan")){
            setKosongCombo();
            setModelKodeProdukKemasan();
        }else if (Jenis.equals("Merchandise")){
            setKosongCombo();
            setModelKodeProdukMerchandise();
        }
    }//GEN-LAST:event_comboJenisPesanActionPerformed

    private void comboNamaSuplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNamaSuplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboNamaSuplierActionPerformed

    private void comboKodeProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKodeProdukActionPerformed
        // TODO add your handling code here:
        String kode = comboKodeProduk.getSelectedItem().toString(); 
        autofillfield(kode);
    }//GEN-LAST:event_comboKodeProdukActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        resetField();
    }//GEN-LAST:event_buttonResetActionPerformed

    private void fieldJumlahPemesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldJumlahPemesananKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_fieldJumlahPemesananKeyTyped

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonSimpanPesanPemesanan;
    private javax.swing.JComboBox<String> comboJenisPesan;
    private javax.swing.JComboBox<String> comboKodeProduk;
    private javax.swing.JComboBox<String> comboNamaSuplier;
    private javax.swing.JTextField fieldBiayaCetakPemesanan;
    private javax.swing.JTextField fieldJumlahPemesanan;
    private javax.swing.JTextField fieldNamaProdukPemesanan;
    private javax.swing.JTextField fieldNoPemesanan;
    private javax.swing.JTextField fieldNominalPemesanan;
    private javax.swing.JTextField fieldTahunPemesanan;
    private com.toedter.calendar.JDateChooser fieldTglPemesanan;
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
    private javax.swing.ButtonGroup radioPrangko;
    // End of variables declaration//GEN-END:variables
}
