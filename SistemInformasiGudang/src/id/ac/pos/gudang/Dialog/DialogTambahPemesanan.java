/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PemesananDAOImpl;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Mitra;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
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
public class DialogTambahPemesanan extends javax.swing.JDialog {

    PemesananDAO dao;
    ProdukDAO daoProduk;
    Pemesanan pemesanan;
    Mitra mitra;
    ArrayList<Mitra> arrayMitra;
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
    Vector vectorMitra = new Vector();

    /**
     * Creates new form DialogTambahPengembalian
     */
    public DialogTambahPemesanan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        autoIncrementNoPemesanan();
        simpan.setEnabled(false);
        batal.setEnabled(false);
        hapus.setEnabled(false);
        autocompleteNamaMitra();
        setLocationRelativeTo(this);
        tabel_pemesanan.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "No", "Kode Produk", "Nama Produk", "Nominal", "Jumlah Pemesanan"
                }));
    }
    
    private void reset_simpan() {
        DefaultTableModel model = (DefaultTableModel) tabel_pemesanan.getModel();

        int baris = tabel_pemesanan.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }

        TanggalPemesanan.setDate(null);
        TanggalPemesanan.setEnabled(true);
        NamaMitra.setSelectedIndex(0);
        NamaMitra.setEnabled(true);
        JenisProduk.setSelectedIndex(0);
        JumlahPemesanan.setText("");
        simpan.setEnabled(false);
        batal.setEnabled(false);
        dispose();
    }
    
    private void autoIncrementNoPemesanan(){
        String kosong = null;
        PemesananDAOImpl dao = new PemesananDAOImpl();

        String no_pemesanan = dao.getNoPemesanan();
        if (no_pemesanan == null) {
            no_pemesanan = "0000000000";
        }
        int sub_nomor_int = Integer.parseInt(no_pemesanan);
        sub_nomor_int++;
        String nomor_string = String.valueOf(sub_nomor_int);
        int panjang = nomor_string.length();
        
        switch (panjang) {
            case 1:
                kosong = "000000000";
                break;
            case 2:
                kosong = "00000000";
                break;
            case 3:
                kosong = "0000000";
                break;
            case 4:
                kosong = "000000";
                break;
            case 5:
                kosong = "00000";
                break;
            case 6:
                kosong = "0000";
                break;
            case 7:
                kosong = "000";
                break;
            case 8:
                kosong = "00";
                break;
            case 9:
                kosong = "0";
                break;
            case 10:
                kosong = null;
                break;
            default:
                break;
        }
        nomor_string = String.valueOf(sub_nomor_int);
        no_pemesanan =kosong + nomor_string;
        fieldNoPemesanan.setText(no_pemesanan);
     }
    
    private void autocompleteNamaMitra() {
//        KotaPengirimPrangko.removeAllItems();
//        KotaPengirimPrangko.addItem("- - - - - - - - - - - -Pilih Regional- - - - - - - - - - - -");
        dao = new PemesananDAOImpl();
        arrayMitra = dao.getMitra();

        int banyak = arrayMitra.size();
        int rowindex = 0;
        vectorMitra.add("- Pilih Mitra -");
        while (0 < banyak) {
            vectorMitra.add(arrayMitra.get(rowindex).getNama_mitra());
            banyak--;
            rowindex++;
        }
        NamaMitra.setModel(new DefaultComboBoxModel(vectorMitra));
//        KotaPengirimPrangko.setSelectedIndex(-1);
        AutoCompleteDecorator.decorate(NamaMitra);
    }

    private void reset() {
        NamaProduk.setSelectedItem("");
        NamaMitra.setSelectedIndex(0);
        KodeProduk.setText("");
        TanggalPemesanan.setDate(null);
        JumlahPemesanan.setText("");
        fieldIdMitra.setText("");
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
        TanggalPemesanan = new com.toedter.calendar.JDateChooser();
        JumlahPemesanan = new javax.swing.JTextField();
        NamaMitra = new javax.swing.JComboBox<>();
        NamaProduk = new javax.swing.JComboBox<>();
        KodeProduk = new javax.swing.JTextField();
        Tahun = new javax.swing.JComboBox<>();
        Nominal = new javax.swing.JComboBox<>();
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
        fieldNoPemesanan = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        fieldIdMitra = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pemesanan = new javax.swing.JTable();
        reset = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Pemesanan"));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
        });

        JumlahPemesanan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JumlahPemesananActionPerformed(evt);
            }
        });
        JumlahPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahPemesananKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JumlahPemesananKeyTyped(evt);
            }
        });

        NamaMitra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaMitraActionPerformed(evt);
            }
        });

        NamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukActionPerformed(evt);
            }
        });

        KodeProduk.setEditable(false);

        Tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TahunActionPerformed(evt);
            }
        });

        Nominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalActionPerformed(evt);
            }
        });

        jLabel1.setText("Nama Produk");

        jLabel2.setText("Tahun");

        jLabel3.setText("Kode Produk");

        jLabel4.setText("Mitra");

        jLabel9.setText("Tanggal Pemesanan");

        jLabel11.setText("Jumlah Pemesanan");

        jLabel42.setText("Nominal");

        jLabel6.setText("Jenis Produk");

        JenisProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Produk -", "Prangko", "MS & SS", "SHP & SHPSS", "Kemasan", "Merchandise", "Prisma", "Dokumen Filateli" }));
        JenisProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisProdukActionPerformed(evt);
            }
        });

        jLabel112.setText("No. Pemesanan");

        fieldNoPemesanan.setEditable(false);
        fieldNoPemesanan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldNoPemesananKeyPressed(evt);
            }
        });

        jLabel43.setText("Id Mitra");

        fieldIdMitra.setEditable(false);
        fieldIdMitra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fieldIdMitraKeyPressed(evt);
            }
        });

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Tambah.png"))); // NOI18N
        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        tabel_pemesanan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_pemesanan);

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

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel112))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(KodeProduk)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                        .addComponent(TanggalPemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(JumlahPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel37Layout.createSequentialGroup()
                                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel37Layout.createSequentialGroup()
                                                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel42)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                                    .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(NamaProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(JenisProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(fieldNoPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel37Layout.createSequentialGroup()
                                                .addComponent(NamaMitra, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel43)
                                                .addGap(60, 60, 60)
                                                .addComponent(fieldIdMitra, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addGap(139, 139, 139)
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(fieldNoPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaMitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel43)
                    .addComponent(fieldIdMitra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JumlahPemesanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addComponent(TanggalPemesanan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JumlahPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahPemesananKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            simpan.requestFocus();
        }
    }//GEN-LAST:event_JumlahPemesananKeyPressed

    private void JumlahPemesananKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahPemesananKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Angka!");
            evt.consume();
        }
    }//GEN-LAST:event_JumlahPemesananKeyTyped

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void NamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukActionPerformed
        // TODO add your handling code here:
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nama_produk != "- Pilih Nama Produk -") {
            Tahun.removeAllItems();
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
            arrayProdukPrangko = dao.getTahunProduk(nama_produk, (String) jenis_produk);
            if (arrayProdukPrangko.size() > 1) {
                vectorTahun.add("- Pilih Tahun Produk -");
                for (int i = 0; i < arrayProdukPrangko.size(); i++) {
                    vectorTahun.add(arrayProdukPrangko.get(i).getTahun());
                }
                Tahun.setModel(new DefaultComboBoxModel(vectorTahun));
            } else if (arrayProdukPrangko.size() == 1) {
                for (int i = 0; i < arrayProdukPrangko.size(); i++) {
                    vectorTahun.add(arrayProdukPrangko.get(i).getTahun());
                }
                Tahun.setModel(new DefaultComboBoxModel(vectorTahun));

                arrayProdukPrangko1 = dao.getNominalProduk(nama_produk, arrayProdukPrangko.get(0).getTahun(), (String) jenis_produk);
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
                    arrayProdukPrangko2 = dao.getKodeProduk(arrayProdukPrangko1.get(0).getNominal(), arrayProdukPrangko.get(0).getTahun(), nama_produk, (String) jenis_produk);
                    KodeProduk.setText(arrayProdukPrangko2.get(0).getIdProduk());
                }
            }
            
            //            NamaProdukPrangko.setSelectedIndex(-1);
        } else {
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
        }
    }//GEN-LAST:event_NamaProdukActionPerformed

    private void fieldNoPemesananKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldNoPemesananKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNoPemesananKeyPressed

    private void fieldIdMitraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldIdMitraKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldIdMitraKeyPressed

    private void JenisProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisProdukActionPerformed
        // TODO add your handling code here:
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (jenis_produk != "- Pilih Jenis Produk -") {
            NamaProduk.removeAllItems();
            dao = new PemesananDAOImpl();
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

            arrayProdukPrangko = dao.getNamaProduk((String) jenis_produk);

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
        }
    }//GEN-LAST:event_JenisProdukActionPerformed

    private void TahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TahunActionPerformed
        // TODO add your handling code here:
        Object tahun = Tahun.getSelectedItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();

        if (tahun != "- Pilih Tahun Produk -") {
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
            arrayProdukPrangko1 = dao.getNominalProduk(nama_produk, tahun, (String) jenis_produk);
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
                arrayProdukPrangko2 = dao.getKodeProduk(arrayProdukPrangko1.get(0).getNominal(), tahun, nama_produk, (String) jenis_produk);
                KodeProduk.setText(arrayProdukPrangko2.get(0).getIdProduk());
            }
        } else {
            Nominal.removeAllItems();
            KodeProduk.setText("");
        }
    }//GEN-LAST:event_TahunActionPerformed

    private void NominalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalActionPerformed
        // TODO add your handling code here:
        Object nominal = Nominal.getSelectedItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object tahun = Tahun.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nominal != "- Pilih Nominal Produk -") {
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
                String kode_produk = arrayProdukPrangko.get(0).getIdProduk();
                KodeProduk.setText(kode_produk);
            }

        } else {
            KodeProduk.setText("");
        }
    }//GEN-LAST:event_NominalActionPerformed

    private void JumlahPemesananActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JumlahPemesananActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JumlahPemesananActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        String kosong = null;
        int no;
        int baris;
        String no_pemesanan = fieldNoPemesanan.getText();
        String kode_produk = KodeProduk.getText();
        String id_mitra = fieldIdMitra.getText();
        java.util.Date tanggal_pemesanan = (java.util.Date) TanggalPemesanan.getDate();
        String jumlah_pemesanan = JumlahPemesanan.getText();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object nominal = Nominal.getSelectedItem();
        
        if (no_pemesanan.compareTo("") != 0) {
            if (tanggal_pemesanan != null) {
                if (id_mitra.compareTo("") != 0) {
                    if (kode_produk.compareTo("") != 0) {
                        if (jumlah_pemesanan.compareTo("") != 0) {
                                TanggalPemesanan.setEnabled(false);
                                fieldIdMitra.setEnabled(false);
                                NamaMitra.setEnabled(false);
                                
                                if (tabel_pemesanan.getRowCount() == 0) {
                                    no = 1;
                                } else {
                                    baris = tabel_pemesanan.getRowCount();
                                    no = baris + 1;
                                }
                                DefaultTableModel dataModel = (DefaultTableModel) tabel_pemesanan.getModel();
                                List list = new ArrayList<>();
                                tabel_pemesanan.setAutoCreateColumnsFromModel(true);
                                list.add(no);
                                list.add(kode_produk);
                                list.add(nama_produk);
                                list.add(nominal);
                                list.add(jumlah_pemesanan);
                                dataModel.addRow(list.toArray());
                                
                                NamaProduk.setSelectedItem("");
                                JenisProduk.setSelectedIndex(0);
                                JumlahPemesanan.setText("");
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
                    JOptionPane.showMessageDialog(null, "Silakan pilih Mitra terlebih dahulu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Silakan isi Tanggal Pemesanan terlebih dahulu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi Nomor Pemesanan terlebih dahulu!");
        }

    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        int baris = tabel_pemesanan.getRowCount();
        if (baris > 0) {
            JenisProduk.setSelectedIndex(0);
            JumlahPemesanan.setText("");
        } else {
            reset();
        }
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String nama_produk, kode_produk, nominal, jumlah_pesan;
        int baris_pilih = tabel_pemesanan.getSelectedRow();
        if (baris_pilih >= 0) {
            DefaultTableModel model = (DefaultTableModel) tabel_pemesanan.getModel();
            model.removeRow(baris_pilih);

            int baris = tabel_pemesanan.getRowCount();
            for (int i = 0; i < baris; i++) {
                kode_produk = tabel_pemesanan.getValueAt(0, 1).toString();
                nama_produk = tabel_pemesanan.getValueAt(0, 2).toString();
                nominal = tabel_pemesanan.getValueAt(0, 3).toString();
                jumlah_pesan = tabel_pemesanan.getValueAt(0, 4).toString();
                

                List list = new ArrayList<>();
                tabel_pemesanan.setAutoCreateColumnsFromModel(true);
                list.add(i+1);
                list.add(kode_produk);
                list.add(nama_produk);
                list.add(nominal);
                list.add(jumlah_pesan);
                model.addRow(list.toArray());

                model.removeRow(0);
            }

            baris = tabel_pemesanan.getRowCount();
            if(baris==0){
                fieldNoPemesanan.setEditable(true);
                TanggalPemesanan.setEnabled(true);
                NamaMitra.setEnabled(true);
                fieldIdMitra.setEnabled(true);
                hapus.setEnabled(true);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk yang akan dihapus!");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        boolean sukses = false;
        String kosong = null;
        int i;
        
        int banyak_baris = tabel_pemesanan.getRowCount();
        dao = new PemesananDAOImpl();

        //autoincrement no_pemesanan
        java.util.Date tanggal_pemesanan = (java.util.Date) TanggalPemesanan.getDate();
        String id_mitra = fieldIdMitra.getText();
        String no_pemesanan = fieldNoPemesanan.getText();
        
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menyimpan data dengan nomor pemesanan : " + no_pemesanan
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
                    for (i = 0; i < banyak_baris; i++) {
                        String kode_produk = tabel_pemesanan.getValueAt(i, 1).toString();
                        String jumlah_pesan = tabel_pemesanan.getValueAt(i, 4).toString();

                    String id_pemesanan_string = dao.getIdPemesanan();
                    if (id_pemesanan_string == null) {
                        id_pemesanan_string = "0";
                    }
                    Integer id_pemesanan = Integer.parseInt(id_pemesanan_string);
                    id_pemesanan++;
                    id_pemesanan_string = Integer.toString(id_pemesanan);
                    int panjang = id_pemesanan_string.length();

                    switch (panjang) {
                            case 1:
                                kosong = "000000000";
                                break;
                            case 2:
                                kosong = "00000000";
                                break;
                            case 3:
                                kosong = "0000000";
                                break;
                            case 4:
                                kosong = "000000";
                                break;
                            case 5:
                                kosong = "00000";
                                break;
                            case 6:
                                kosong = "0000";
                                break;
                            case 7:
                                kosong = "000";
                                break;
                            case 8:
                                kosong = "00";
                                break;
                            case 9:
                                kosong = "0";
                                break;
                            case 10:
                                kosong = null;
                                break;
                            default:
                                break;
                    }

                    id_pemesanan_string = kosong + id_pemesanan_string;

                    pemesanan = new Pemesanan();
                    pemesanan.setIdPemesanan(id_pemesanan_string);
                    pemesanan.setNoPemesanan(no_pemesanan);
                    pemesanan.setKodeProduk(kode_produk);
                    pemesanan.setJumlahPemesanan(jumlah_pesan);
                    pemesanan.setTglPemesanan(tanggal_pemesanan);
                    pemesanan.setIdMitra(id_mitra);

                    sukses = dao.tambahPemesanan(pemesanan);

                    }
                                    //cek sukses atau tidak
                        if (sukses) {
                              JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                              autoIncrementNoPemesanan();
                              reset_simpan();
                        } else {
                              JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                              reset_simpan();
                        }
                   
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        reset_simpan();
    }//GEN-LAST:event_batalActionPerformed

    private void NamaMitraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaMitraActionPerformed
        // TODO add your handling code here:
        Object pilihan = NamaMitra.getSelectedItem();
                if (pilihan != "- Pilih Mitra -") {
                    dao = new PemesananDAOImpl();
                    arrayMitra = dao.getIdMitra(pilihan);

                    fieldIdMitra.setText(arrayMitra.get(0).getId_mitra());
                } else {
                    fieldIdMitra.setText("");
                }
    }//GEN-LAST:event_NamaMitraActionPerformed

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
    private javax.swing.JComboBox<String> JenisProduk;
    private javax.swing.JTextField JumlahPemesanan;
    private javax.swing.JTextField KodeProduk;
    private javax.swing.JComboBox<String> NamaMitra;
    private javax.swing.JComboBox<String> NamaProduk;
    private javax.swing.JComboBox<String> Nominal;
    private javax.swing.JComboBox<String> Tahun;
    private com.toedter.calendar.JDateChooser TanggalPemesanan;
    private javax.swing.JButton batal;
    private javax.swing.JTextField fieldIdMitra;
    private javax.swing.JTextField fieldNoPemesanan;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_pemesanan;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
