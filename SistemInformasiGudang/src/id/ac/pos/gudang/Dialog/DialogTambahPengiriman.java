/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.Panel.PanelPengiriman;
import id.ac.pos.gudang.dao.PengirimanDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengirimanDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Pengiriman;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author reyha
 */
public class DialogTambahPengiriman extends javax.swing.JDialog {

    PengirimanDAO dao;
    ProdukDAO daoProduk;
    Regional regional;
    ArrayList<Regional> arrayRegional;
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
    Vector vectorRegional = new Vector();
    private long limit;

    /**
     * Creates new form DialogTambahPengiriman
     */
    public DialogTambahPengiriman(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        simpan.setEnabled(false);
        batal.setEnabled(false);
        hapus.setEnabled(false);
        setLocationRelativeTo(this);
        autocomplete_regional();
        tabel_pengiriman.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "No", "Kode Produk", "Nama Produk", "Nominal", "Jumlah Kirim", "BSU"
                }));
        AutoCompleteDecorator.decorate(NamaProduk);

        Date ys = new Date();
        TanggalPengiriman.setDate(ys);
        TanggalPengiriman.setMaxSelectableDate(ys);

        TableColumnModel columnModel = tabel_pengiriman.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        ((DefaultTableCellRenderer) tabel_pengiriman.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment((int) CENTER_ALIGNMENT);
    }

    private String hilangkan_titik(String text_titik) {
        String[] temp = text_titik.split("\\.");
        String text_string = "";
        for (int i = 0; i < temp.length; i++) {
            text_string = text_string + temp[i];
        }
        return text_string;
    }

    private String format_titik(String text_string) {
        int j = 0, i, n;
        String text_hasil = "";
        int k = 2, l = 3, m = 4;
        int panjang_text = text_string.length();
        String[] text_pisah = text_string.split("(?<=\\G.{1})");

        while (j == 0) {
            if (panjang_text == k) {
                n = k;
                for (i = 0; i < k; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == l) {
                n = l;
                for (i = 0; i < l; i++) {
                    if (n % 3 == 0) {
                        if (n == l) {
                            text_hasil = text_hasil + text_pisah[i];
                        } else {
                            text_hasil = text_hasil + "." + text_pisah[i];
                        }
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == m) {
                n = m;
                for (i = 0; i < m; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == 1) {
                text_hasil = text_pisah[0];
                j = 1;
            } else if (panjang_text == 0) {
                text_hasil = "";
                j = 1;
            }
            k = k + 3;
            l = l + 3;
            m = m + 3;
        }
        return text_hasil;

    }

    private void autocomplete_regional() {
//        KotaPengirimPrangko.removeAllItems();
//        KotaPengirimPrangko.addItem("- - - - - - - - - - - -Pilih Regional- - - - - - - - - - - -");
        dao = new PengirimanDAOImpl();
        arrayRegional = dao.getRegional();

        int banyak = arrayRegional.size();
        int rowindex = 0;
        vectorRegional.add("- Pilih Regional -");
        while (0 < banyak) {
            vectorRegional.add(arrayRegional.get(rowindex).getNamaRegional());
            banyak--;
            rowindex++;
        }
        Regional.setModel(new DefaultComboBoxModel(vectorRegional));
//        KotaPengirimPrangko.setSelectedIndex(-1);
        AutoCompleteDecorator.decorate(Regional);
    }

    private void reset_simpan() {
        DefaultTableModel model = (DefaultTableModel) tabel_pengiriman.getModel();

        int baris = tabel_pengiriman.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }

        NoOrder.setText("");
        NoOrder.setEditable(true);
        TanggalPengiriman.setDate(null);
        TanggalPengiriman.setEnabled(true);
        Regional.setSelectedIndex(0);
        Regional.setEnabled(true);
        JenisProduk.setSelectedIndex(0);
        JumlahKirim.setText("");
        simpan.setEnabled(false);
        batal.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        NoOrder = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TanggalPengiriman = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        NamaProduk = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Tahun = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Nominal = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        KodeProduk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Regional = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        KodeRegional = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        KodePos = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        JumlahKirim = new javax.swing.JTextField();
        tambah = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pengiriman = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JenisProduk = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        Stok = new javax.swing.JTextField();
        hapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Tambah Data Pengiriman"));

        jLabel2.setText("No Order");

        NoOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoOrderKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NoOrderKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NoOrderKeyTyped(evt);
            }
        });

        jLabel3.setText("Tanggal");

        jLabel4.setText("Nama Produk");

        NamaProduk.setToolTipText("");
        NamaProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukActionPerformed(evt);
            }
        });

        jLabel5.setText("Tahun");

        Tahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TahunActionPerformed(evt);
            }
        });

        jLabel6.setText("Nominal");

        Nominal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode Produk");

        KodeProduk.setEditable(false);
        KodeProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KodeProdukActionPerformed(evt);
            }
        });

        jLabel8.setText("Regional");

        Regional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegionalActionPerformed(evt);
            }
        });

        jLabel9.setText("Kode Regional");

        KodeRegional.setEditable(false);

        jLabel10.setText("Kode Pos");

        KodePos.setEditable(false);

        jLabel11.setText("Jumlah Dikirim");

        JumlahKirim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahKirimKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JumlahKirimKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JumlahKirimKeyTyped(evt);
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

        tabel_pengiriman.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_pengiriman);

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

        jLabel1.setText("Jenis Produk");

        JenisProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Produk -", "Prangko", "MS & SS", "SHP & SHPSS", "Kemasan", "Merchandise", "Prisma", "Dokumen Filateli" }));
        JenisProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JenisProdukActionPerformed(evt);
            }
        });

        jLabel12.setText("Stok");

        Stok.setEditable(false);

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Empty_Trash.png"))); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NamaProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JumlahKirim)
                            .addComponent(Regional, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JenisProduk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(NoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TanggalPengiriman, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(KodeRegional, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(KodePos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(KodeProduk, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Tahun, javax.swing.GroupLayout.Alignment.LEADING, 0, 170, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Nominal, 0, 170, Short.MAX_VALUE)
                                            .addComponent(Stok))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(NoOrder)
                        .addComponent(jLabel3))
                    .addComponent(TanggalPengiriman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Regional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(KodeRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(KodePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(NamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(Stok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JumlahKirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(batal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KodeProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KodeProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KodeProdukActionPerformed

    private void JenisProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JenisProdukActionPerformed
        // TODO add your handling code here:
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (jenis_produk != "- Pilih Jenis Produk -") {
            NamaProduk.removeAllItems();
            dao = new PengirimanDAOImpl();
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

        } else {
            NamaProduk.setSelectedItem("");
            NamaProduk.removeAllItems();
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            Stok.setText("");
        }
    }//GEN-LAST:event_JenisProdukActionPerformed

    private void NamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukActionPerformed
        // TODO add your handling code here:
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nama_produk != "- Pilih Nama Produk -") {
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            Stok.setText("");

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

            dao = new PengirimanDAOImpl();
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
                    Stok.setText(Integer.toString(arrayProdukPrangko2.get(0).getStok()));
                }
            }

            //            NamaProdukPrangko.setSelectedIndex(-1);
        } else {
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
        }
    }//GEN-LAST:event_NamaProdukActionPerformed

    private void TahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TahunActionPerformed
        // TODO add your handling code here:
        Object tahun = Tahun.getSelectedItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();

        if (tahun != "- Pilih Tahun Produk -") {
            Nominal.removeAllItems();
            KodeProduk.setText("");
            Stok.setText("");

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
            dao = new PengirimanDAOImpl();
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
                Stok.setText(Integer.toString(arrayProdukPrangko2.get(0).getStok()));
            }
        } else {
            Nominal.removeAllItems();
            KodeProduk.setText("");
            Stok.setText("");
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
            Stok.setText("");
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
            dao = new PengirimanDAOImpl();
            arrayProdukPrangko = dao.getKodeProduk(nominal, tahun, nama_produk, (String) jenis_produk);
            if (arrayProdukPrangko.size() == 1) {
                String kode_produk = arrayProdukPrangko.get(0).getIdProduk();
                KodeProduk.setText(kode_produk);
                Stok.setText(Integer.toString(arrayProdukPrangko.get(0).getStok()));

            }

        } else {
            KodeProduk.setText("");
            Stok.setText("");
        }
    }//GEN-LAST:event_NominalActionPerformed

    private void RegionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegionalActionPerformed
        // TODO add your handling code here:

        Object nama_regional = Regional.getSelectedItem();
        if (nama_regional != "- Pilih Regional -") {
            dao = new PengirimanDAOImpl();
            arrayRegional = dao.getIsiRegional(nama_regional);

            KodeRegional.setText(arrayRegional.get(0).getIdRegional());
            KodePos.setText(arrayRegional.get(0).getKodePos());
        } else {
            KodePos.setText("");
            KodeRegional.setText("");
        }

    }//GEN-LAST:event_RegionalActionPerformed

    private void JumlahKirimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahKirimKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_JumlahKirimKeyTyped

    private void NoOrderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoOrderKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();

        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            NoOrder.requestFocus();
            evt.consume();
        }
    }//GEN-LAST:event_NoOrderKeyTyped

    private void NoOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoOrderKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TanggalPengiriman.requestFocus();
        }
    }//GEN-LAST:event_NoOrderKeyPressed

    private void JumlahKirimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahKirimKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            tambah.requestFocus();
        }
    }//GEN-LAST:event_JumlahKirimKeyPressed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        String kosong = null;
        int no;
        int baris = tabel_pengiriman.getRowCount();
        String no_order = NoOrder.getText();
        Date tanggal_pengiriman = TanggalPengiriman.getDate();
        String kode_regional = KodeRegional.getText();
        String kode_produk = KodeProduk.getText();
        Object nominal = Nominal.getSelectedItem();
        //ubah nominal menjadi titik
        String nom_str = String.valueOf(nominal);
        String hasil_nominal = format_titik(nom_str);

        Object nama_produk = NamaProduk.getSelectedItem();
        int indeks = 0;

        String jumlah_kirim_string = hilangkan_titik(JumlahKirim.getText());

        if (no_order.compareTo("") != 0) {
            if (tanggal_pengiriman != null) {
                if (kode_regional.compareTo("") != 0) {
                    if (kode_produk.compareTo("") != 0) {
                        if (JumlahKirim.getText().compareTo("") != 0) {
                            int stok = Integer.parseInt(Stok.getText());
                            if (stok == 0) {
                                JOptionPane.showMessageDialog(null, "Stok produk kosong!");
                            } else if (stok < Integer.parseInt(jumlah_kirim_string)) {
                                JOptionPane.showMessageDialog(null, "Stok produk kurang!");
                            } else {

                                if (baris > 0) {
                                    for (int i = 0; i < baris; i++) {
                                        Object kode = tabel_pengiriman.getValueAt(i, 1);
                                        if (kode_produk.compareTo((String) kode) == 0) {
                                            indeks = 1;
                                        }
                                    }
                                }

                                if (indeks == 0) {
                                    int nominal_string = (int) nominal;
                                    long jumlah_dikirim = Long.parseLong(jumlah_kirim_string);
                                    NoOrder.setEditable(false);
                                    TanggalPengiriman.setEnabled(false);
                                    Regional.setEnabled(false);
                                    long bsu = jumlah_dikirim * nominal_string;
                                    String bsu_string = Long.toString(bsu);

                                    //format bsu
                                    String bsu_hasil = format_titik(bsu_string);

                                    if (tabel_pengiriman.getRowCount() == 0) {
                                        no = 1;
                                    } else {
                                        no = baris + 1;
                                    }
                                    DefaultTableModel dataModel = (DefaultTableModel) tabel_pengiriman.getModel();
                                    List list = new ArrayList<>();
                                    tabel_pengiriman.setAutoCreateColumnsFromModel(true);
                                    list.add(no);
                                    list.add(kode_produk);
                                    list.add(nama_produk);
                                    list.add(hasil_nominal);
                                    list.add(JumlahKirim.getText());
                                    list.add(bsu_hasil);
                                    dataModel.addRow(list.toArray());

                                    JenisProduk.setSelectedIndex(0);
                                    JumlahKirim.setText("");
                                    simpan.setEnabled(true);
                                    batal.setEnabled(true);
                                    hapus.setEnabled(true);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Produk sudah terdaftar!");
                                }

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Silakan isi Jumlah Kirim terlebih dahulu!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Silakan pilih Produk terlebih dahulu!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Silakan pilih Regional terlebih dahulu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Silakan isi Tanggal Pengiriman terlebih dahulu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi Nomor Order terlebih dahulu!");
        }


    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan?",
                "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            boolean sukses = false;
            String kosong = null;
            int stok_produk;
            int i;
            int banyak_baris = tabel_pengiriman.getRowCount();

            dao = new PengirimanDAOImpl();

            java.util.Date tanggal_pengiriman = (java.util.Date) TanggalPengiriman.getDate();
            String no_order = NoOrder.getText();
            String kode_regional = KodeRegional.getText();

            for (i = 0; i < banyak_baris; i++) {
                String kode_produk = tabel_pengiriman.getValueAt(i, 1).toString();
                String jumlah_kirim = tabel_pengiriman.getValueAt(i, 4).toString();
                String bsu = tabel_pengiriman.getValueAt(i, 5).toString();

                //hilangkan titik
                String jumlah_kirim_hasil = hilangkan_titik(jumlah_kirim);
                String bsu_hasil = hilangkan_titik(bsu);

                //autoincrement id_pengembalian
                String id_pengiriman_string = dao.getIdPengiriman();
                if (id_pengiriman_string == null) {
                    id_pengiriman_string = "0";
                }
                Integer id_pengiriman = Integer.parseInt(id_pengiriman_string);
                id_pengiriman++;
                id_pengiriman_string = Integer.toString(id_pengiriman);
                int panjang = id_pengiriman_string.length();

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

                id_pengiriman_string = kosong + id_pengiriman_string;

                Pengiriman pengiriman = new Pengiriman();
                pengiriman.setId_pengiriman(id_pengiriman_string);
                pengiriman.setNo_order_pengiriman(no_order);
                pengiriman.setTgl_pengiriman(tanggal_pengiriman);
                pengiriman.setId_produk(kode_produk);
                pengiriman.setId_regional(kode_regional);
                pengiriman.setBsu(bsu_hasil);
                pengiriman.setJumlah_pengiriman(Integer.parseInt(jumlah_kirim_hasil));
                stok_produk = dao.getStok(kode_produk);
                pengiriman.setStok_awal(stok_produk);
                sukses = dao.tambahPengiriman(pengiriman);

            }

            if (sukses) {
                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                reset_simpan();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                reset_simpan();
            }

            pilih = JOptionPane.showConfirmDialog(null, "Apakah anda akan menambahkan data lagi?",
                    "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (pilih == JOptionPane.NO_OPTION) {
                this.dispose();
            }

        }
    }//GEN-LAST:event_simpanActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        int baris = tabel_pengiriman.getRowCount();
        if (baris > 0) {
            JenisProduk.setSelectedIndex(0);
            JumlahKirim.setText("");
        } else {
            NoOrder.setText("");
            Date ys = new Date();
            TanggalPengiriman.setDate(ys);
            Regional.setSelectedIndex(0);
            JenisProduk.setSelectedIndex(0);
            JumlahKirim.setText("");
        }
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String nama_produk, kode_produk, nominal, jumlah_kirim, bsu;
        int baris_pilih = tabel_pengiriman.getSelectedRow();
        if (baris_pilih >= 0) {

            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin akan "
                    + "menghapus Produk : " + tabel_pengiriman.getValueAt(baris_pilih, 2).toString()
                    + " ,dengan Jumlah Kirim : " + tabel_pengiriman.getValueAt(baris_pilih, 4).toString()
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                DefaultTableModel model = (DefaultTableModel) tabel_pengiriman.getModel();
                model.removeRow(baris_pilih);

                int baris = tabel_pengiriman.getRowCount();
                for (int i = 0; i < baris; i++) {
                    kode_produk = tabel_pengiriman.getValueAt(0, 1).toString();
                    nama_produk = tabel_pengiriman.getValueAt(0, 2).toString();
                    nominal = tabel_pengiriman.getValueAt(0, 3).toString();
                    jumlah_kirim = tabel_pengiriman.getValueAt(0, 4).toString();
                    bsu = tabel_pengiriman.getValueAt(0, 5).toString();

                    List list = new ArrayList<>();
                    tabel_pengiriman.setAutoCreateColumnsFromModel(true);
                    list.add(i + 1);
                    list.add(kode_produk);
                    list.add(nama_produk);
                    list.add(nominal);
                    list.add(jumlah_kirim);
                    list.add(bsu);
                    model.addRow(list.toArray());

                    model.removeRow(0);
                }

                baris = tabel_pengiriman.getRowCount();
                if (baris == 0) {
                    NoOrder.setEditable(true);
                    TanggalPengiriman.setEnabled(true);
                    Regional.setEnabled(true);
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk yang akan dihapus!");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        reset_simpan();
    }//GEN-LAST:event_batalActionPerformed

    private void NoOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoOrderKeyReleased
        // TODO add your handling code here:
        if (NoOrder.getText().length() == 12) {
            TanggalPengiriman.requestFocus();
            this.limit = Long.parseLong(NoOrder.getText());
        } else if (NoOrder.getText().length() > 12) {
            NoOrder.setText(Long.toString(this.limit));
        }
    }//GEN-LAST:event_NoOrderKeyReleased

    private void JumlahKirimKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahKirimKeyReleased
        // TODO add your handling code here:

        char karakter = evt.getKeyChar();
        if ((((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {

            String jumlah_kirim_string = hilangkan_titik(JumlahKirim.getText());
            String jumlah_kirim_hasil = format_titik(jumlah_kirim_string);
            JumlahKirim.setText(jumlah_kirim_hasil);
            evt.consume();
        }


    }//GEN-LAST:event_JumlahKirimKeyReleased

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
            java.util.logging.Logger.getLogger(DialogTambahPengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengiriman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTambahPengiriman dialog = new DialogTambahPengiriman(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField JumlahKirim;
    private javax.swing.JTextField KodePos;
    private javax.swing.JTextField KodeProduk;
    private javax.swing.JTextField KodeRegional;
    private javax.swing.JComboBox<String> NamaProduk;
    private javax.swing.JTextField NoOrder;
    private javax.swing.JComboBox<String> Nominal;
    private javax.swing.JComboBox<String> Regional;
    private javax.swing.JTextField Stok;
    private javax.swing.JComboBox<String> Tahun;
    private com.toedter.calendar.JDateChooser TanggalPengiriman;
    private javax.swing.JButton batal;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_pengiriman;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
