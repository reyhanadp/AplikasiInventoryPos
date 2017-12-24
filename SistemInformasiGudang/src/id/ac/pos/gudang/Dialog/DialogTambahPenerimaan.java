/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.dao.PenerimaanDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PemesananDAOImpl;
import id.ac.pos.gudang.daoimpl.PenerimaanDAOImpl;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Suplier;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


/**
 *
 * @author reyha
 */
public class DialogTambahPenerimaan extends javax.swing.JDialog {

    PemesananDAO dao;
    PenerimaanDAO daoPenerimaan;
    ProdukDAO daoProduk;
    Pemesanan pemesanan;
    Penerimaan penerimaan;
    Suplier suplier;
    ArrayList<Penerimaan> arrayPenerimaan;
    ArrayList<Pemesanan> arrayPemesanan;
    ArrayList<Suplier> arraySuplier;
    ArrayList<Produk> arrayProdukPrangko, arrayProdukPrangko1, arrayProdukPrangko2, arrayProdukMSSS, arrayProdukSHPSS, arrayProdukKemasan, arrayProdukMerchandise, arrayProdukPrisma, arrayProdukDokumenFilateli;
    Vector vectorTahun = new Vector();
    Vector vectorNominal = new Vector();
    Vector vectorPrangko = new Vector();
    Vector vectorMSSS = new Vector();
    Vector vectorSHPSS = new Vector();
    Vector vectorKemasan = new Vector();
    Vector vectorMerchandise = new Vector();
    Vector vectorPrisma = new Vector();
    Vector vectorDokumenFilateli = new Vector();
    Vector vectorSuplier = new Vector();
    Vector vectorNoPemesanan= new Vector();

    /**
     * Creates new form DialogTambahPengembalian
     */
    public DialogTambahPenerimaan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        simpan.setEnabled(false);
        batal.setEnabled(false);
        hapus.setEnabled(false);
        setLocationRelativeTo(this);
        tabel_penerimaan.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "No", "Kode Produk", "Nama Produk", "Nominal","Stok Awal",
                    "Subtotal Terima","Sisa Belum Dikirim","Jumlah Pemesanan",
                    "Id Pemesanan", "Id Suplier", "Keterangan"
                }));
    }

    private void isiField(String kode_produk) {
        
        System.out.println(kode_produk);
                
                    daoPenerimaan = new PenerimaanDAOImpl();
                   // arrayPemesanan = daoPenerimaan.getIdPemesanan(kode_produk);
                    //fieldIdPemesanan.setText(arrayPemesanan.get(0).getIdPemesanan());
                    //fieldIdSuplier.setText(arrayPemesanan.get(0).getIdSuplier());
                    
                    //arrayProdukPrangko = daoPenerimaan.getStok(kode_produk);
                    //fieldStokAwal.setText(String.valueOf(arrayProdukPrangko.get(0).getStok()));
                    
                    if (fieldIdSuplier.getText()!=""){
                    //arraySuplier = daoPenerimaan.getNamaSuplier(fieldIdSuplier.getText());
                    //fieldNamaSuplier.setText(arraySuplier.get(0).getNama_suplier());
                }
               /* if (fieldIdPemesanan.getText()!=""){
                    arrayPemesanan = daoPenerimaan.getTotalPesan(fieldIdPemesanan.getText());
                    fieldTotalPemesanan.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    
                    
                    arrayPenerimaan = daoPenerimaan.IsiPemesanan(fieldIdPemesanan.getText());
                    if (arrayPenerimaan.size()>=1){
                        fieldSubtotalTerima.setText(String.valueOf(arrayPenerimaan.get(0).getSubTotalTerima()));
                        fieldSisaBelumDikirim.setText(String.valueOf(arrayPenerimaan.get(0).getSisaBelumDikirim()));
                    }else{
                        fieldSubtotalTerima.setText("0");
                        fieldSisaBelumDikirim.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    }
                }*/
                
                
    }
    
    private void reset_simpan() {
        DefaultTableModel model = (DefaultTableModel) tabel_penerimaan.getModel();

        int baris = tabel_penerimaan.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }
        
        fieldNoOrder.setText("");
        fieldNoOrder1.setText("");
        fieldNoOrder2.setText("");
        fieldNoOrder3.setText("");
        fieldNoOrder.setEnabled(true);
        fieldNoOrder1.setEnabled(true);
        fieldNoOrder2.setEnabled(true);
        fieldNoOrder3.setEnabled(true);
        fieldTglPenerimaan.setDate(null);
        fieldTglPenerimaan.setEnabled(true);
        JenisProduk.setSelectedIndex(0);
        fieldJmlTerima.setText("");
        simpan.setEnabled(false);
        batal.setEnabled(false);
    }
        
    private void reset() {
        Nominal.setSelectedItem("");
        Tahun.setSelectedItem("");
        fieldIdPemesanan.setText("");
        KodeProduk.setText("");
        fieldTglPenerimaan.setDate(null);
        fieldJmlTerima.setText("");
        fieldIdSuplier.setText("");
        fieldNamaSuplier.setText("");
        fieldTotalPemesanan.setText("");
        fieldSubtotalTerima.setText("");
        fieldSisaBelumDikirim.setText("");
        fieldKeterangan.setText("");
        NamaProduk.setSelectedItem("- Pilih Nama Produk -");
        JenisProduk.setSelectedItem("- Pilih Jenis produk -");
        fieldNoOrder.setText("");
        fieldNoOrder1.setText("");
        fieldNoOrder2.setText("");
        fieldNoOrder3.setText("");
        fieldStokAwal.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel37 = new javax.swing.JPanel();
        fieldTglPenerimaan = new com.toedter.calendar.JDateChooser();
        fieldJmlTerima = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        KodeProduk = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JenisProduk = new javax.swing.JComboBox<>();
        jLabel112 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        fieldIdSuplier = new javax.swing.JTextField();
        fieldNamaSuplier = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldSisaBelumDikirim = new javax.swing.JTextField();
        fieldSubtotalTerima = new javax.swing.JTextField();
        fieldStokAwal = new javax.swing.JTextField();
        fieldTotalPemesanan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fieldKeterangan = new javax.swing.JTextArea();
        fieldNoOrder = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        NamaProduk = new javax.swing.JComboBox<>();
        Tahun = new javax.swing.JComboBox<>();
        Nominal = new javax.swing.JComboBox<>();
        fieldIdPemesanan = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_penerimaan = new javax.swing.JTable();
        batal = new javax.swing.JButton();
        fieldNoOrder1 = new javax.swing.JTextField();
        fieldNoOrder2 = new javax.swing.JTextField();
        fieldNoOrder3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Pemesanan"));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
        });

        fieldJmlTerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldJmlTerimaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldJmlTerimaKeyTyped(evt);
            }
        });

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        KodeProduk.setEditable(false);

        jLabel1.setText("Nama Produk");

        jLabel2.setText("Tahun");

        jLabel3.setText("Kode Produk");

        jLabel4.setText("Suplier");

        jLabel9.setText("Tanggal Penerimaan");

        jLabel11.setText("Jumlah Terima");

        jLabel42.setText("Nominal");

        jLabel6.setText("Jenis Produk");

        JenisProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Produk -", "Prangko", "MS & SS", "SHP & SHPSS", "Kemasan", "Merchandise", "Prisma", "Dokumen Filateli" }));
        JenisProduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JenisProdukItemStateChanged(evt);
            }
        });
        JenisProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisProdukActionPerformed(evt);
            }
        });
        JenisProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JenisProdukKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JenisProdukKeyReleased(evt);
            }
        });

        jLabel112.setText("No. Order");

        jLabel43.setText("Id Suplier");

        fieldIdSuplier.setEditable(false);
        fieldIdSuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldIdSuplierKeyPressed(evt);
            }
        });

        fieldNamaSuplier.setEditable(false);
        fieldNamaSuplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNamaSuplierKeyPressed(evt);
            }
        });

        jLabel8.setText("Sisa Belum Dikirim");

        jLabel7.setText("Subtotal Terima");

        fieldSisaBelumDikirim.setEditable(false);

        fieldSubtotalTerima.setEditable(false);

        fieldStokAwal.setEditable(false);

        fieldTotalPemesanan.setEditable(false);

        jLabel5.setText("Stok Awal");

        jLabel10.setText("Total Pemesanan");

        jLabel12.setText("Keterangan");

        fieldKeterangan.setColumns(20);
        fieldKeterangan.setRows(3);
        jScrollPane1.setViewportView(fieldKeterangan);

        fieldNoOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoOrderActionPerformed(evt);
            }
        });
        fieldNoOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNoOrderKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNoOrderKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNoOrderKeyTyped(evt);
            }
        });

        jLabel44.setText("Id Pemesanan");

        NamaProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NamaProdukMouseClicked(evt);
            }
        });
        NamaProduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NamaProdukItemStateChanged(evt);
            }
        });
        NamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukActionPerformed(evt);
            }
        });
        NamaProduk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NamaProdukKeyReleased(evt);
            }
        });

        Tahun.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TahunItemStateChanged(evt);
            }
        });
        Tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TahunActionPerformed(evt);
            }
        });
        Tahun.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TahunKeyReleased(evt);
            }
        });

        Nominal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NominalItemStateChanged(evt);
            }
        });
        Nominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalActionPerformed(evt);
            }
        });
        Nominal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NominalKeyReleased(evt);
            }
        });

        fieldIdPemesanan.setEditable(false);
        fieldIdPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldIdPemesananKeyPressed(evt);
            }
        });

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Tambah.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Empty_Trash.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tabel_penerimaan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabel_penerimaan);

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        fieldNoOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoOrder1ActionPerformed(evt);
            }
        });
        fieldNoOrder1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNoOrder1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNoOrder1KeyTyped(evt);
            }
        });

        fieldNoOrder2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoOrder2ActionPerformed(evt);
            }
        });
        fieldNoOrder2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNoOrder2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNoOrder2KeyTyped(evt);
            }
        });

        fieldNoOrder3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldNoOrder3ActionPerformed(evt);
            }
        });
        fieldNoOrder3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldNoOrder3KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNoOrder3KeyTyped(evt);
            }
        });

        jLabel13.setText("-");

        jLabel14.setText("-");

        jLabel15.setText("-");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel112))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel37Layout.createSequentialGroup()
                                        .addComponent(fieldNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldNoOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addGap(8, 8, 8)
                                        .addComponent(fieldNoOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fieldNoOrder3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTotalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldTglPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldNamaSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(168, 168, 168)))
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel37Layout.createSequentialGroup()
                                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43)
                                            .addComponent(jLabel42))
                                        .addGap(59, 59, 59)
                                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fieldSisaBelumDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldJmlTerima)
                                            .addComponent(fieldSubtotalTerima, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldIdSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(fieldIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(NamaProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(fieldNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNoOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNoOrder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNoOrder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel42)
                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel44)
                    .addComponent(fieldIdPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel43)
                    .addComponent(fieldIdSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNamaSuplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldStokAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldTotalPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fieldTglPenerimaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fieldSubtotalTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldSisaBelumDikirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(fieldJmlTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldJmlTerimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldJmlTerimaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            simpan.requestFocus();
        }
    }//GEN-LAST:event_fieldJmlTerimaKeyPressed

    private void fieldJmlTerimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldJmlTerimaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Angka!");
            evt.consume();
        }
    }//GEN-LAST:event_fieldJmlTerimaKeyTyped

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        boolean sukses = false;
        String kosong = null;
        int i;
        int banyak_baris = tabel_penerimaan.getRowCount();
        String no_order1 = fieldNoOrder.getText();
        String no_order2 = fieldNoOrder1.getText();
        String no_order3 = fieldNoOrder2.getText();
        String no_order4 = fieldNoOrder3.getText();
        String no_order = no_order1+"-"+no_order2+"-"+no_order3+"-"+no_order4;
        java.util.Date tanggal = (java.util.Date) fieldTglPenerimaan.getDate();
        
        
        daoPenerimaan = new PenerimaanDAOImpl();
        
        for (i = 0; i < banyak_baris; i++) {
            String kode_produk = tabel_penerimaan.getValueAt(i, 1).toString();
            String stok_awal = tabel_penerimaan.getValueAt(i, 4).toString();
            String subtotal_terima = tabel_penerimaan.getValueAt(i, 5).toString();
            String sisa = tabel_penerimaan.getValueAt(i, 6).toString();
            String jumlah_penerimaan = tabel_penerimaan.getValueAt(i, 7).toString();
            String id_pemesanan = tabel_penerimaan.getValueAt(i, 8).toString();
            String id_suplier = tabel_penerimaan.getValueAt(i, 9).toString();
            String keterangan = tabel_penerimaan.getValueAt(i, 10).toString();
            
        String id_penerimaan_string = daoPenerimaan.getIdPenerimaan();
        if (id_penerimaan_string == null) {
            id_penerimaan_string = "00000";
        }
        Integer id_penerimaan = Integer.parseInt(id_penerimaan_string);
        id_penerimaan++;
        id_penerimaan_string = Integer.toString(id_penerimaan);
        int panjang = id_penerimaan_string.length();

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

        id_penerimaan_string = kosong + id_penerimaan_string;

                        penerimaan = new Penerimaan();
                        penerimaan.setIdPenerimaan(id_penerimaan_string);
                        penerimaan.setNoOrder(no_order);
                        penerimaan.setTglPenerimaan(tanggal);
                        penerimaan.setJmlTerima(Integer.parseInt(jumlah_penerimaan));
                        penerimaan.setIdPemesanan(id_pemesanan);
                        penerimaan.setIdProduk(kode_produk);
                        penerimaan.setIdSuplier(id_suplier);
                        penerimaan.setStokAwal(Integer.parseInt(stok_awal));
                        int stok_akhir = Integer.parseInt(stok_awal) + Integer.parseInt(jumlah_penerimaan);
                        int sub_total_terima = Integer.parseInt(subtotal_terima) + Integer.parseInt(jumlah_penerimaan);
                        int sisa_belum_dikirim = Integer.parseInt(sisa)-Integer.parseInt(jumlah_penerimaan);
                        penerimaan.setStokAkhir(stok_akhir);
                        penerimaan.setSubTotalTerima(sub_total_terima);
                        penerimaan.setSisaBelumDikirim(sisa_belum_dikirim);
                        penerimaan.setKeterangan(keterangan);
                        sukses = daoPenerimaan.tambahPenerimaan(penerimaan);
        }
                        //cek sukses atau tidak
                        if (sukses) {
                            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                            
                            
                            reset_simpan();
                        } else {
                            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                            reset_simpan();
                        }
                    

    }//GEN-LAST:event_simpanActionPerformed

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void JenisProdukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JenisProdukItemStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_JenisProdukItemStateChanged

    private void fieldIdSuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldIdSuplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdSuplierKeyPressed

    private void fieldNamaSuplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNamaSuplierKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaSuplierKeyPressed

    private void JenisProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisProdukActionPerformed
        // TODO add your handling code here:
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (jenis_produk != "- Pilih Jenis Produk -") {
            NamaProduk.removeAllItems();
            
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
            
            daoPenerimaan = new PenerimaanDAOImpl();
            if (jenis_produk == "Prangko") {
                jenis_produk = "PR";
            } else if (jenis_produk == "MS & SS") {
                jenis_produk = "MS";
            } else if (jenis_produk == "SHP & SHPSS") {
                jenis_produk = "SHP";
            } else if (jenis_produk == "Kemasan") {
                jenis_produk = "KM";
            } else if (jenis_produk == "Merchandise") {
                jenis_produk = "MC";
            } else if (jenis_produk == "Prisma") {
                jenis_produk = "PS";
            } else if (jenis_produk == "Dokumen Filateli") {
                jenis_produk = "DF";
            }

            arrayProdukPrangko = daoPenerimaan.getNamaProduk((String) jenis_produk);

            vectorPrangko.add("- Pilih Nama Produk -");

            for (int i = 0; i < arrayProdukPrangko.size(); i++) {
                vectorPrangko.add(arrayProdukPrangko.get(i).getNamaProduk());
            }

            NamaProduk.setModel(new DefaultComboBoxModel(vectorPrangko));
            AutoCompleteDecorator.decorate(NamaProduk);
        } else {
            NamaProduk.removeAllItems();
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
        }
        
        
    }//GEN-LAST:event_JenisProdukActionPerformed

    private void NamaProdukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NamaProdukItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NamaProdukItemStateChanged

    private void NamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukActionPerformed
        // TODO add your handling code here:
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nama_produk != "- Pilih Nama Produk -" && nama_produk !=null) {
            
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
            Tahun.removeAllItems();
            Nominal.removeAllItems();
                        
            if (jenis_produk == "Prangko") {
                jenis_produk = "PR";
            } else if (jenis_produk == "MS & SS") {
                jenis_produk = "MS";
            } else if (jenis_produk == "SHP & SHPSS") {
                jenis_produk = "SHP";
            } else if (jenis_produk == "Kemasan") {
                jenis_produk = "KM";
            } else if (jenis_produk == "Merchandise") {
                jenis_produk = "MC";
            } else if (jenis_produk == "Prisma") {
                jenis_produk = "PS";
            } else if (jenis_produk == "Dokumen Filateli") {
                jenis_produk = "DF";
            }
            
            daoPenerimaan = new PenerimaanDAOImpl();
            arrayProdukPrangko = daoPenerimaan.getTahunProduk(nama_produk, (String) jenis_produk);
            if (arrayProdukPrangko.size() > 1) {
                vectorTahun.add("- Pilih Tahun Produk -");
                    KodeProduk.setText("");
                    fieldIdPemesanan.setText("");
                    fieldNamaSuplier.setText("");
                    fieldIdSuplier.setText("");
                    fieldStokAwal.setText("");
                    fieldSubtotalTerima.setText("");
                    fieldTotalPemesanan.setText("");
                    fieldSisaBelumDikirim.setText("");
                    fieldJmlTerima.setText("");
                for (int i = 0; i < arrayProdukPrangko.size(); i++) {
                    vectorTahun.add(arrayProdukPrangko.get(i).getTahun());
                }
                Tahun.setModel(new DefaultComboBoxModel(vectorTahun));
            } else if (arrayProdukPrangko.size() == 1) {
                for (int i = 0; i < arrayProdukPrangko.size(); i++) {
                    vectorTahun.add(arrayProdukPrangko.get(i).getTahun());
                }
                Tahun.setModel(new DefaultComboBoxModel(vectorTahun));
                                
                arrayProdukPrangko1 = daoPenerimaan.getNominalProduk(nama_produk, arrayProdukPrangko.get(0).getTahun(), (String) jenis_produk);
                if (arrayProdukPrangko1.size() > 1) {
                    vectorNominal.add("- Pilih Nominal Produk -");
                    for (int i = 0; i < arrayProdukPrangko1.size(); i++) {
                        vectorNominal.add(arrayProdukPrangko1.get(i).getNominal());
                    }
                    Nominal.setModel(new DefaultComboBoxModel(vectorNominal));

                } else if (arrayProdukPrangko1.size() == 1) {
                    for (int i = 0; i < arrayProdukPrangko1.size(); i++) {
                        vectorNominal.add(arrayProdukPrangko1.get(i).getNominal());
                    }
                    Nominal.setModel(new DefaultComboBoxModel(vectorNominal));
                    arrayProdukPrangko2 = daoPenerimaan.getKodeProduk(arrayProdukPrangko1.get(0).getNominal(), arrayProdukPrangko.get(0).getTahun(), nama_produk, (String) jenis_produk);
                    KodeProduk.setText(arrayProdukPrangko2.get(0).getIdProduk());
                    
                    //isi field
                    if(KodeProduk.getText()!=""){
                    daoPenerimaan = new PenerimaanDAOImpl();
                    arrayPemesanan = daoPenerimaan.getIdPemesanan(KodeProduk.getText());
                    fieldIdPemesanan.setText(arrayPemesanan.get(0).getIdPemesanan());
                    fieldIdSuplier.setText(arrayPemesanan.get(0).getIdSuplier());
                    
                    arrayProdukPrangko = daoPenerimaan.getStok(KodeProduk.getText());
                    fieldStokAwal.setText(String.valueOf(arrayProdukPrangko.get(0).getStok()));
                }
                if (fieldIdSuplier.getText()!=""){
                    arraySuplier = daoPenerimaan.getNamaSuplier(fieldIdSuplier.getText());
                    fieldNamaSuplier.setText(arraySuplier.get(0).getNama_suplier());
                }
                if (fieldIdPemesanan.getText()!=""){
                    arrayPemesanan = daoPenerimaan.getTotalPesan(fieldIdPemesanan.getText());
                    fieldTotalPemesanan.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    
                    
                    arrayPenerimaan = daoPenerimaan.IsiPemesanan(fieldIdPemesanan.getText());
                    System.out.println(arrayPenerimaan.size());
                    if (arrayPenerimaan.size()>=1){
                        fieldSubtotalTerima.setText(String.valueOf(arrayPenerimaan.get(0).getSubTotalTerima()));
                        fieldSisaBelumDikirim.setText(String.valueOf(arrayPenerimaan.get(0).getSisaBelumDikirim()));
                    }else{
                        fieldSubtotalTerima.setText("0");
                        fieldSisaBelumDikirim.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    }
                }
                }
                
            }

        } else {
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
            Tahun.removeAllItems();
            Nominal.removeAllItems();
        }
        
    }//GEN-LAST:event_NamaProdukActionPerformed

    private void TahunItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TahunItemStateChanged
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_TahunItemStateChanged

    private void NominalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NominalItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NominalItemStateChanged

    private void fieldIdPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldIdPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdPemesananKeyPressed

    private void TahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TahunActionPerformed
        // TODO add your handling code here:
        Object tahun = Tahun.getSelectedItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (tahun != "- Pilih Tahun Produk -" && tahun != null) {
            Nominal.removeAllItems();
            KodeProduk.setText("");

            if (jenis_produk == "Prangko") {
                jenis_produk = "PR";
            } else if (jenis_produk == "MS & SS") {
                jenis_produk = "MS";
            } else if (jenis_produk == "SHP & SHPSS") {
                jenis_produk = "SHP";
            } else if (jenis_produk == "Kemasan") {
                jenis_produk = "KM";
            } else if (jenis_produk == "Merchandise") {
                jenis_produk = "MC";
            } else if (jenis_produk == "Prisma") {
                jenis_produk = "PS";
            } else if (jenis_produk == "Dokumen Filateli") {
                jenis_produk = "DF";
            }
            dao = new PemesananDAOImpl();
            arrayProdukPrangko1 = daoPenerimaan.getNominalProduk(nama_produk, tahun, (String) jenis_produk);
            if (arrayProdukPrangko1.size() > 1) {
                vectorNominal.add("- Pilih Nominal Produk -");
                for (int i = 0; i < arrayProdukPrangko1.size(); i++) {
                    vectorNominal.add(arrayProdukPrangko1.get(i).getNominal());
                }
                Nominal.setModel(new DefaultComboBoxModel(vectorNominal));

            } else if (arrayProdukPrangko1.size() == 1) {
                for (int i = 0; i < arrayProdukPrangko1.size(); i++) {
                    vectorNominal.add(arrayProdukPrangko1.get(i).getNominal());
                }
                Nominal.setModel(new DefaultComboBoxModel(vectorNominal));
                arrayProdukPrangko2 = daoPenerimaan.getKodeProduk(arrayProdukPrangko1.get(0).getNominal(), tahun, nama_produk, (String) jenis_produk);
                KodeProduk.setText(arrayProdukPrangko2.get(0).getIdProduk());
            }
            if(KodeProduk.getText()!=""){
                    daoPenerimaan = new PenerimaanDAOImpl();
                    arrayPemesanan = daoPenerimaan.getIdPemesanan(KodeProduk.getText());
                    fieldIdPemesanan.setText(arrayPemesanan.get(0).getIdPemesanan());
                    fieldIdSuplier.setText(arrayPemesanan.get(0).getIdSuplier());
                    
                    arrayProdukPrangko = daoPenerimaan.getStok(KodeProduk.getText());
                    fieldStokAwal.setText(String.valueOf(arrayProdukPrangko.get(0).getStok()));
                }
                if (fieldIdSuplier.getText()!=""){
                    arraySuplier = daoPenerimaan.getNamaSuplier(fieldIdSuplier.getText());
                    fieldNamaSuplier.setText(arraySuplier.get(0).getNama_suplier());
                }
                if (fieldIdPemesanan.getText()!=""){
                    arrayPemesanan = daoPenerimaan.getTotalPesan(fieldIdPemesanan.getText());
                    fieldTotalPemesanan.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    
                    
                    arrayPenerimaan = daoPenerimaan.IsiPemesanan(fieldIdPemesanan.getText());
                    if (arrayPenerimaan.size()>=1){
                        fieldSubtotalTerima.setText(String.valueOf(arrayPenerimaan.get(0).getSubTotalTerima()));
                        fieldSisaBelumDikirim.setText(String.valueOf(arrayPenerimaan.get(0).getSisaBelumDikirim()));
                    }else{
                        fieldSubtotalTerima.setText("0");
                        fieldSisaBelumDikirim.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    }
                }
        } else {
            Nominal.removeAllItems();
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
        }
        
    }//GEN-LAST:event_TahunActionPerformed

    private void NominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalActionPerformed
        // TODO add your handling code here:
        Object nominal = Nominal.getSelectedItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object tahun = Tahun.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        String kode_produk = KodeProduk.getText();
        
        if (nominal != "- Pilih Nominal Produk -" && nominal != null) {
            KodeProduk.setText("");
            if (jenis_produk == "Prangko") {
                jenis_produk = "PR";
            } else if (jenis_produk == "MS & SS") {
                jenis_produk = "MS";
            } else if (jenis_produk == "SHP & SHPSS") {
                jenis_produk = "SHP";
            } else if (jenis_produk == "Kemasan") {
                jenis_produk = "KM";
            } else if (jenis_produk == "Merchandise") {
                jenis_produk = "MC";
            } else if (jenis_produk == "Prisma") {
                jenis_produk = "PS";
            } else if (jenis_produk == "Dokumen Filateli") {
                jenis_produk = "DF";
            }
            dao = new PemesananDAOImpl();
            arrayProdukPrangko = dao.getKodeProduk(nominal, tahun, nama_produk, (String) jenis_produk);
            if (arrayProdukPrangko.size() == 1) {
                kode_produk = arrayProdukPrangko.get(0).getIdProduk();
                KodeProduk.setText(kode_produk);
            }
            if(KodeProduk.getText()!=""){
                    daoPenerimaan = new PenerimaanDAOImpl();
                    arrayPemesanan = daoPenerimaan.getIdPemesanan(KodeProduk.getText());
                    fieldIdPemesanan.setText(arrayPemesanan.get(0).getIdPemesanan());
                    fieldIdSuplier.setText(arrayPemesanan.get(0).getIdSuplier());
                    
                    arrayProdukPrangko = daoPenerimaan.getStok(KodeProduk.getText());
                    fieldStokAwal.setText(String.valueOf(arrayProdukPrangko.get(0).getStok()));
                }
                if (fieldIdSuplier.getText()!=""){
                    arraySuplier = daoPenerimaan.getNamaSuplier(fieldIdSuplier.getText());
                    fieldNamaSuplier.setText(arraySuplier.get(0).getNama_suplier());
                }
                if (fieldIdPemesanan.getText()!=""){
                    arrayPemesanan = daoPenerimaan.getTotalPesan(fieldIdPemesanan.getText());
                    fieldTotalPemesanan.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    
                    
                    arrayPenerimaan = daoPenerimaan.IsiPemesanan(fieldIdPemesanan.getText());
                    if (arrayPenerimaan.size()>=1){
                        fieldSubtotalTerima.setText(String.valueOf(arrayPenerimaan.get(0).getSubTotalTerima()));
                        fieldSisaBelumDikirim.setText(String.valueOf(arrayPenerimaan.get(0).getSisaBelumDikirim()));
                    }else{
                        fieldSubtotalTerima.setText("0");
                        fieldSisaBelumDikirim.setText(arrayPemesanan.get(0).getJumlahPemesanan());
                    }
                }
        } else {
            KodeProduk.setText("");
            fieldIdPemesanan.setText("");
            fieldNamaSuplier.setText("");
            fieldIdSuplier.setText("");
            fieldStokAwal.setText("");
            fieldSubtotalTerima.setText("");
            fieldTotalPemesanan.setText("");
            fieldSisaBelumDikirim.setText("");
            fieldJmlTerima.setText("");
        }
        
    }//GEN-LAST:event_NominalActionPerformed

    private void fieldNoOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoOrderActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fieldNoOrderActionPerformed

    private void JenisProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JenisProdukKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JenisProdukKeyReleased

    private void JenisProdukKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JenisProdukKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JenisProdukKeyPressed

    private void NamaProdukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaProdukKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NamaProdukKeyReleased

    private void TahunKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TahunKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TahunKeyReleased

    private void NominalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NominalKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_NominalKeyReleased

    private void fieldNoOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrderKeyReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_fieldNoOrderKeyReleased

    private void NamaProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NamaProdukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukMouseClicked

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        String kosong = null;
        int no;
        int baris;
        String no_order = fieldNoOrder.getText();
        String no_order1 = fieldNoOrder1.getText();
        String no_order2 = fieldNoOrder2.getText();
        String no_order3 = fieldNoOrder3.getText();
        String id_pemesanan = fieldIdPemesanan.getText();
        String kode_produk = KodeProduk.getText();
        String id_suplier = fieldIdSuplier.getText();
        java.util.Date tanggal_penerimaan = (java.util.Date) fieldTglPenerimaan.getDate();
        String jumlah_penerimaan = fieldJmlTerima.getText();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object nominal = Nominal.getSelectedItem();
        String stok_awal = fieldStokAwal.getText();
        String subtotal_terima = fieldSubtotalTerima.getText();
        String sisa_blm_dikirim = fieldSisaBelumDikirim.getText();
        String keterangan = fieldKeterangan.getText();
        
        if (no_order.compareTo("") != 0 && no_order1.compareTo("") != 0 && no_order2.compareTo("") != 0 && no_order3.compareTo("") != 0 ){
        if (id_pemesanan.compareTo("") != 0) {
            if (tanggal_penerimaan != null) {
                if (id_suplier.compareTo("") != 0) {
                    if (kode_produk.compareTo("") != 0) {
                        if (jumlah_penerimaan.compareTo("") != 0) {
                            fieldTglPenerimaan.setEnabled(false);
                            fieldNoOrder.setEnabled(false);
                            fieldNoOrder1.setEnabled(false);
                            fieldNoOrder2.setEnabled(false);
                            fieldNoOrder3.setEnabled(false);
                            fieldKeterangan.setText("");
                            
                            if (tabel_penerimaan.getRowCount() == 0) {
                                no = 1;
                            } else {
                                baris = tabel_penerimaan.getRowCount();
                                no = baris + 1;
                            }
                            DefaultTableModel dataModel = (DefaultTableModel) tabel_penerimaan.getModel();
                            List list = new ArrayList<>();
                            tabel_penerimaan.setAutoCreateColumnsFromModel(true);
                            list.add(no);
                            list.add(kode_produk);
                            list.add(nama_produk);
                            list.add(nominal);
                            list.add(stok_awal);
                            list.add(subtotal_terima);
                            list.add(sisa_blm_dikirim);
                            list.add(jumlah_penerimaan);
                            list.add(id_pemesanan);
                            list.add(id_suplier);
                            list.add(keterangan);
                            dataModel.addRow(list.toArray());

                            NamaProduk.setSelectedItem("");
                            JenisProduk.setSelectedIndex(0);
                            fieldJmlTerima.setText("");
                            simpan.setEnabled(true);
                            batal.setEnabled(true);
                            hapus.setEnabled(true);

                        } else {
                            JOptionPane.showMessageDialog(null, "Silakan isi Jumlah pesan terlebih dahulu!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Silakan pilih Produk terlebih dahulu!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Silakan pilih Suplier terlebih dahulu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Silakan isi Tanggal Pemesanan terlebih dahulu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi Id Pemesanan terlebih dahulu!");
        }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi Nomor Order terlebih dahulu!");
        
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        int baris = tabel_penerimaan.getRowCount();
        if (baris > 0) {
            JenisProduk.setSelectedIndex(0);
            reset_simpan();
        } else {
            reset();
        }
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String nama_produk, kode_produk, nominal, jumlah_pesan;
        int baris_pilih = tabel_penerimaan.getSelectedRow();
        if (baris_pilih >= 0) {
            DefaultTableModel model = (DefaultTableModel) tabel_penerimaan.getModel();
            model.removeRow(baris_pilih);

            int baris = tabel_penerimaan.getRowCount();
            for (int i = 0; i < baris; i++) {
                kode_produk = tabel_penerimaan.getValueAt(0, 1).toString();
                nama_produk = tabel_penerimaan.getValueAt(0, 2).toString();
                nominal = tabel_penerimaan.getValueAt(0, 3).toString();
                jumlah_pesan = tabel_penerimaan.getValueAt(0, 4).toString();

                List list = new ArrayList<>();
                tabel_penerimaan.setAutoCreateColumnsFromModel(true);
                list.add(i+1);
                list.add(kode_produk);
                list.add(nama_produk);
                list.add(nominal);
                list.add(jumlah_pesan);
                model.addRow(list.toArray());

                model.removeRow(0);
            }

            baris = tabel_penerimaan.getRowCount();
            if(baris==0){
                hapus.setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk yang akan dihapus!");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        reset_simpan();
    }//GEN-LAST:event_batalActionPerformed

    private void fieldNoOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoOrder1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder1ActionPerformed

    private void fieldNoOrder1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder1KeyReleased

    private void fieldNoOrder2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoOrder2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder2ActionPerformed

    private void fieldNoOrder2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder2KeyReleased

    private void fieldNoOrder3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldNoOrder3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder3ActionPerformed

    private void fieldNoOrder3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder3KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoOrder3KeyReleased

    private void fieldNoOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrderKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_fieldNoOrderKeyPressed

    private void fieldNoOrderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrderKeyTyped
        // TODO add your handling code here:
        fieldNoOrder1.requestFocus();
    }//GEN-LAST:event_fieldNoOrderKeyTyped

    private void fieldNoOrder1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder1KeyTyped
        // TODO add your handling code here:
        String no_order = fieldNoOrder1.getText();
        int panjang = no_order.length();
        if(panjang>2){
            fieldNoOrder2.requestFocus();
        }
    }//GEN-LAST:event_fieldNoOrder1KeyTyped

    private void fieldNoOrder2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder2KeyTyped
        // TODO add your handling code here:
        String no_order = fieldNoOrder2.getText();
        int panjang = no_order.length();
        if(panjang>0){
            fieldNoOrder3.requestFocus();
        }
    }//GEN-LAST:event_fieldNoOrder2KeyTyped

    private void fieldNoOrder3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoOrder3KeyTyped
        // TODO add your handling code here:
        String no_order = fieldNoOrder3.getText();
        int panjang = no_order.length();
        if(panjang>2){
            JenisProduk.requestFocus();
        }
    }//GEN-LAST:event_fieldNoOrder3KeyTyped

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
            java.util.logging.Logger.getLogger(DialogTambahPenerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPenerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPenerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPenerimaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                DialogTambahPenerimaan dialog = new DialogTambahPenerimaan(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> JenisProduk;
    private javax.swing.JTextField KodeProduk;
    private javax.swing.JComboBox<String> NamaProduk;
    private javax.swing.JComboBox<String> Nominal;
    private javax.swing.JComboBox<String> Tahun;
    private javax.swing.JButton batal;
    private javax.swing.JTextField fieldIdPemesanan;
    private javax.swing.JTextField fieldIdSuplier;
    private javax.swing.JTextField fieldJmlTerima;
    private javax.swing.JTextArea fieldKeterangan;
    private javax.swing.JTextField fieldNamaSuplier;
    private javax.swing.JTextField fieldNoOrder;
    private javax.swing.JTextField fieldNoOrder1;
    private javax.swing.JTextField fieldNoOrder2;
    private javax.swing.JTextField fieldNoOrder3;
    private javax.swing.JTextField fieldSisaBelumDikirim;
    private javax.swing.JTextField fieldStokAwal;
    private javax.swing.JTextField fieldSubtotalTerima;
    private com.toedter.calendar.JDateChooser fieldTglPenerimaan;
    private javax.swing.JTextField fieldTotalPemesanan;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_penerimaan;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}