/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
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
public class DialogTambahPengembalian extends javax.swing.JDialog {

    PengembalianDAO dao;
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

    /**
     * Creates new form DialogTambahPengembalian
     */
    public DialogTambahPengembalian(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        autocompleteKotaPengirim();
        setLocationRelativeTo(this);
        AutoCompleteDecorator.decorate(NamaProduk);
        AutoCompleteDecorator.decorate(Regional);
        tabel_pengembalian.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{},
                new String[]{
                    "No", "Kode Regional", "Regional", "Nomor Dus", "Jumlah Terima", "Keterangan"
                }));
        hapus.setEnabled(false);
        simpan.setEnabled(false);
        batal.setEnabled(false);

        Date ys = new Date();
        TanggalPengembalian.setDate(ys);
        TanggalPengembalian.setMaxSelectableDate(ys);
        
        TableColumnModel columnModel = tabel_pengembalian.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        ((DefaultTableCellRenderer)tabel_pengembalian.getTableHeader().getDefaultRenderer())
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

    private void reset_simpan() {
        DefaultTableModel model = (DefaultTableModel) tabel_pengembalian.getModel();

        int baris = tabel_pengembalian.getRowCount();
        for (int i = 0; i < baris; i++) {
            model.removeRow(0);
        }

        NamaProduk.setEnabled(true);
        Tahun.setEnabled(true);
        Nominal.setEnabled(true);
        JenisProduk.setSelectedIndex(0);
        JenisProduk.setEnabled(true);
        TanggalPengembalian.setDate(null);
        TanggalPengembalian.setEnabled(true);
        Regional.setSelectedIndex(0);
        Regional.setEnabled(true);
        NomorDus.setText("");
        JumlahTerima.setText("");
        Keterangan.setText("");
        simpan.setEnabled(false);
        batal.setEnabled(false);
    }

    private void autocompleteKotaPengirim() {
        dao = new PengembalianDAOImpl();
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
        TanggalPengembalian = new com.toedter.calendar.JDateChooser();
        StokGudang = new javax.swing.JTextField();
        JumlahTerima = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        NomorDus = new javax.swing.JTextField();
        Regional = new javax.swing.JComboBox<>();
        NamaProduk = new javax.swing.JComboBox<>();
        KodeProduk = new javax.swing.JTextField();
        KodeRegional = new javax.swing.JTextField();
        KodePos = new javax.swing.JTextField();
        jScrollPane35 = new javax.swing.JScrollPane();
        Keterangan = new javax.swing.JTextArea();
        batal = new javax.swing.JToggleButton();
        Tahun = new javax.swing.JComboBox<>();
        Nominal = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JenisProduk = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_pengembalian = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Pengembalian"));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
        });

        StokGudang.setEditable(false);

        JumlahTerima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahTerimaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JumlahTerimaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JumlahTerimaKeyTyped(evt);
            }
        });

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        NomorDus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusActionPerformed(evt);
            }
        });
        NomorDus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomorDusKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NomorDusKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NomorDusKeyTyped(evt);
            }
        });

        Regional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RegionalItemStateChanged(evt);
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

        KodeProduk.setEditable(false);

        KodeRegional.setEditable(false);

        KodePos.setEditable(false);

        Keterangan.setColumns(20);
        Keterangan.setLineWrap(true);
        Keterangan.setRows(2);
        Keterangan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganKeyPressed(evt);
            }
        });
        jScrollPane35.setViewportView(Keterangan);

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Delete.png"))); // NOI18N
        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        Tahun.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TahunItemStateChanged(evt);
            }
        });

        Nominal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NominalItemStateChanged(evt);
            }
        });

        jLabel1.setText("Nama Produk");

        jLabel2.setText("Tahun");

        jLabel3.setText("Kode Produk");

        jLabel4.setText("Regional");

        jLabel5.setText("Kode Regional");

        jLabel8.setText("Nomor Dus");

        jLabel9.setText("Tanggal Pengembalian");

        jLabel10.setText("Keterangan");

        jLabel13.setText("Kode Pos");

        jLabel42.setText("Stok");

        jLabel6.setText("Jenis Produk");

        JenisProduk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih Jenis Produk -", "Prangko", "MS & SS", "SHP & SHPSS", "Kemasan", "Merchandise", "Prisma", "Dokumen Filateli" }));
        JenisProduk.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                JenisProdukItemStateChanged(evt);
            }
        });

        tabel_pengembalian.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabel_pengembalian);

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

        jLabel7.setText("Nominal");

        jLabel43.setText("Jumlah Terima");

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(NamaProduk, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(NomorDus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(KodeRegional, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JumlahTerima)
                                    .addComponent(KodePos)))
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel37Layout.createSequentialGroup()
                                        .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel37Layout.createSequentialGroup()
                                        .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(StokGudang)
                                    .addComponent(Nominal, 0, 170, Short.MAX_VALUE)))
                            .addComponent(jScrollPane35)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(TanggalPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Regional, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TanggalPengembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JenisProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NamaProduk)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Tahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nominal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(KodeProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudang)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Regional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(KodeRegional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(KodePos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(NomorDus)
                    .addComponent(JumlahTerima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(batal, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 583, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JumlahTerimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTerimaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Keterangan.requestFocus();
        }
    }//GEN-LAST:event_JumlahTerimaKeyPressed

    private void JumlahTerimaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTerimaKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_JumlahTerimaKeyTyped

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        boolean sukses = false;
        String kosong = null;
        int stok_produk = Integer.parseInt(StokGudang.getText());
        int i;
        int banyak_baris = tabel_pengembalian.getRowCount();

        dao = new PengembalianDAOImpl();
        String kode_regional, regional_field, nomor_dus, jumlah_terima, keterangan;
        java.util.Date tanggal_pengembalian = (java.util.Date) TanggalPengembalian.getDate();
        String kode_produk = KodeProduk.getText();
        String id_pengembalian_string = dao.getIdPengembalian();

        int pilih = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                + "menyimpan data pengembalian "
                + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (pilih == JOptionPane.YES_OPTION) {
            for (i = 0; i < banyak_baris; i++) {
                kode_regional = tabel_pengembalian.getValueAt(i, 1).toString();
                regional_field = tabel_pengembalian.getValueAt(i, 2).toString();
                nomor_dus = tabel_pengembalian.getValueAt(i, 3).toString();
                jumlah_terima = tabel_pengembalian.getValueAt(i, 4).toString();
                keterangan = tabel_pengembalian.getValueAt(i, 5).toString();

                if (nomor_dus.compareTo("") == 0) {
                    nomor_dus = null;
                }else{
                    nomor_dus = hilangkan_titik(nomor_dus);
                }

                if (keterangan.compareTo("") == 0) {
                    keterangan = null;
                }
                
                jumlah_terima = hilangkan_titik(jumlah_terima);

                //autoincrement id_pengembalian
                if (id_pengembalian_string == null) {
                    id_pengembalian_string = "0";
                }
                Integer id_pengembalian = Integer.parseInt(id_pengembalian_string);
                id_pengembalian++;
                id_pengembalian_string = Integer.toString(id_pengembalian);
                int panjang = id_pengembalian_string.length();

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

                id_pengembalian_string = kosong + id_pengembalian_string;

                Pengembalian pengembalian = new Pengembalian();
                pengembalian.setTanggal_pengembalian(tanggal_pengembalian);
                pengembalian.setDus(nomor_dus);
                pengembalian.setId_pengembalian(id_pengembalian_string);
                pengembalian.setId_produk(kode_produk);
                pengembalian.setId_regional(kode_regional);
                pengembalian.setJumlah_pengembalian(Integer.parseInt(jumlah_terima));
                pengembalian.setKeterangan(keterangan);
                pengembalian.setStok_awal(stok_produk);
                stok_produk = stok_produk + Integer.parseInt(jumlah_terima);
                sukses = dao.tambahPengembalian(pengembalian);

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
            if(pilih == JOptionPane.NO_OPTION){
                this.dispose();
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void NomorDusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusActionPerformed

    private void NomorDusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorDusKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TanggalPengembalian.requestFocus();
        }
    }//GEN-LAST:event_NomorDusKeyPressed

    private void NomorDusKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorDusKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            JOptionPane.showMessageDialog(null, "Hanya Boleh Angka !");
            evt.consume();
        }
    }//GEN-LAST:event_NomorDusKeyTyped

    private void RegionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_RegionalItemStateChanged
        // TODO add your handling code here:

        Regional.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object pilihan = e.getItem();
                if (pilihan != "- Pilih Regional -") {
                    dao = new PengembalianDAOImpl();
                    arrayRegional = dao.getIsiRegional(pilihan);

                    KodeRegional.setText(arrayRegional.get(0).getIdRegional());
                    KodePos.setText(arrayRegional.get(0).getKodePos());
                } else {
                    KodePos.setText("");
                    KodeRegional.setText("");
                }

            }
        });

    }//GEN-LAST:event_RegionalItemStateChanged

    private void NamaProdukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NamaProdukItemStateChanged
        // TODO add your handling code here:
        Object nama_produk = evt.getItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nama_produk != "- Pilih Nama Produk -") {
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            StokGudang.setText("");

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

            dao = new PengembalianDAOImpl();
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
                    StokGudang.setText(Integer.toString(arrayProdukPrangko2.get(0).getStok()));
                }
            }

            //            NamaProdukPrangko.setSelectedIndex(-1);
        } else {
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            StokGudang.setText("");
        }
    }//GEN-LAST:event_NamaProdukItemStateChanged

    private void KeteranganKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            simpan.requestFocus();
        }
    }//GEN-LAST:event_KeteranganKeyPressed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        reset_simpan();
    }//GEN-LAST:event_batalActionPerformed

    private void TahunItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_TahunItemStateChanged
        // TODO add your handling code here:
        Object tahun = evt.getItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();

        if (tahun != "- Pilih Tahun Produk -") {
            Nominal.removeAllItems();
            KodeProduk.setText("");
            StokGudang.setText("");

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
            dao = new PengembalianDAOImpl();
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
                StokGudang.setText(Integer.toString(arrayProdukPrangko2.get(0).getStok()));
            }
        } else {
            Nominal.removeAllItems();
            KodeProduk.setText("");
            StokGudang.setText("");
        }
    }//GEN-LAST:event_TahunItemStateChanged

    private void NominalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NominalItemStateChanged
        // TODO add your handling code here:
        Object nominal = evt.getItem();
        Object nama_produk = NamaProduk.getSelectedItem();
        Object tahun = Tahun.getSelectedItem();
        Object jenis_produk = JenisProduk.getSelectedItem();
        if (nominal != "- Pilih Nominal Produk -") {
            KodeProduk.setText("");
            StokGudang.setText("");
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
            dao = new PengembalianDAOImpl();
            arrayProdukPrangko = dao.getKodeProduk(nominal, tahun, nama_produk, (String) jenis_produk);
            if (arrayProdukPrangko.size() == 1) {
                String kode_produk = arrayProdukPrangko.get(0).getIdProduk();
                KodeProduk.setText(kode_produk);
                StokGudang.setText(Integer.toString(arrayProdukPrangko.get(0).getStok()));
            }

        } else {
            KodeProduk.setText("");
            StokGudang.setText("");
        }
    }//GEN-LAST:event_NominalItemStateChanged

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void JenisProdukItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_JenisProdukItemStateChanged
        // TODO add your handling code here:
        Object jenis_produk = evt.getItem();
        if (jenis_produk != "- Pilih Jenis Produk -") {
            NamaProduk.removeAllItems();
            dao = new PengembalianDAOImpl();
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
            NamaProduk.removeAllItems();
            Tahun.removeAllItems();
            Nominal.removeAllItems();
            KodeProduk.setText("");
            StokGudang.setText("");
        }
    }//GEN-LAST:event_JenisProdukItemStateChanged

    private void NamaProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        String kosong = null;
        int no;
        int baris = tabel_pengembalian.getRowCount();
        Date tanggal_pengembalian = TanggalPengembalian.getDate();
        String kode_regional = KodeRegional.getText();
        String regional_field = (String) Regional.getSelectedItem();
        String kode_produk = KodeProduk.getText();
        String nomor_dus = NomorDus.getText();
        String jumlah_terima = JumlahTerima.getText();
        String keterangan = Keterangan.getText();
        int indeks = 0;

        if (tanggal_pengembalian != null) {
            if (kode_produk.compareTo("") != 0) {
                if (kode_regional.compareTo("") != 0) {
//                    if (nomor_dus.compareTo("") != 0) {
                    if (jumlah_terima.compareTo("") != 0) {

                        TanggalPengembalian.setEnabled(false);
                        JenisProduk.setEnabled(false);
                        NamaProduk.setEnabled(false);
                        Tahun.setEnabled(false);
                        Nominal.setEnabled(false);

                        no = baris + 1;

                        DefaultTableModel dataModel = (DefaultTableModel) tabel_pengembalian.getModel();
                        List list = new ArrayList<>();
                        tabel_pengembalian.setAutoCreateColumnsFromModel(true);
                        list.add(no);
                        list.add(kode_regional);
                        list.add(regional_field);
                        list.add(nomor_dus);
                        list.add(jumlah_terima);
                        list.add(keterangan);
                        dataModel.addRow(list.toArray());

                        Regional.setSelectedIndex(0);
                        JumlahTerima.setText("");
                        NomorDus.setText("");
                        Keterangan.setText("");
                        simpan.setEnabled(true);
                        batal.setEnabled(true);
                        hapus.setEnabled(true);

                    } else {
                        JOptionPane.showMessageDialog(null, "Silakan isi Jumlah Terima terlebih dahulu!");
                    }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Silakan isi Nomor Dus terlebih dahulu!");
//                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Silakan pilih Regional terlebih dahulu!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Silakan pilih Produk terlebih dahulu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan isi Tanggal Pengiriman terlebih dahulu!");
        }


    }//GEN-LAST:event_tambahActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        int baris = tabel_pengembalian.getRowCount();
        if (baris > 0) {
            Regional.setSelectedIndex(0);
            NomorDus.setText("");
            JumlahTerima.setText("");
            Keterangan.setText("");
        } else {
            JenisProduk.setSelectedIndex(0);
            Date ys = new Date();
            TanggalPengembalian.setDate(ys);
            Regional.setSelectedIndex(0);
            NomorDus.setText("");
            JumlahTerima.setText("");
            Keterangan.setText("");
        }
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        String kode_regional, regional_field, nomor_dus, jumlah_terima, keterangan;
        int baris_pilih = tabel_pengembalian.getSelectedRow();
        if (baris_pilih >= 0) {
            int ok = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin "
                    + "menghapus Regional dengan kode : " + tabel_pengembalian.getValueAt(baris_pilih, 1).toString()
                    + " ,dengan Nomor Dus " + tabel_pengembalian.getValueAt(baris_pilih, 3).toString()
                    + "?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                DefaultTableModel model = (DefaultTableModel) tabel_pengembalian.getModel();
                model.removeRow(baris_pilih);

                int baris = tabel_pengembalian.getRowCount();
                for (int i = 0; i < baris; i++) {
                    kode_regional = tabel_pengembalian.getValueAt(0, 1).toString();
                    regional_field = tabel_pengembalian.getValueAt(0, 2).toString();
                    nomor_dus = tabel_pengembalian.getValueAt(0, 3).toString();
                    jumlah_terima = tabel_pengembalian.getValueAt(0, 4).toString();
                    keterangan = tabel_pengembalian.getValueAt(0, 5).toString();

                    List list = new ArrayList<>();
                    tabel_pengembalian.setAutoCreateColumnsFromModel(true);
                    list.add(i + 1);
                    list.add(kode_regional);
                    list.add(regional_field);
                    list.add(nomor_dus);
                    list.add(jumlah_terima);
                    list.add(keterangan);
                    model.addRow(list.toArray());

                    model.removeRow(0);
                }

                baris = tabel_pengembalian.getRowCount();
                if (baris == 0) {
                    TanggalPengembalian.setEnabled(true);
                    JenisProduk.setEnabled(true);
                    NamaProduk.setEnabled(true);
                    Tahun.setEnabled(true);
                    Nominal.setEnabled(true);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Anda harus memilih dahulu produk yang akan dihapus!");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void NomorDusKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorDusKeyReleased
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {

            String nomor_dus_string = hilangkan_titik(NomorDus.getText());
            String nomor_dus_hasil = format_titik(nomor_dus_string);
            NomorDus.setText(nomor_dus_hasil);
            evt.consume();
        }
    }//GEN-LAST:event_NomorDusKeyReleased

    private void JumlahTerimaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTerimaKeyReleased
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if ((((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {

            String jumlah_terima_string = hilangkan_titik(JumlahTerima.getText());
            String jumlah_terima_hasil = format_titik(jumlah_terima_string);
            JumlahTerima.setText(jumlah_terima_hasil);
            evt.consume();
        }
    }//GEN-LAST:event_JumlahTerimaKeyReleased

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
            java.util.logging.Logger.getLogger(DialogTambahPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogTambahPengembalian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogTambahPengembalian dialog = new DialogTambahPengembalian(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField JumlahTerima;
    private javax.swing.JTextArea Keterangan;
    private javax.swing.JTextField KodePos;
    private javax.swing.JTextField KodeProduk;
    private javax.swing.JTextField KodeRegional;
    private javax.swing.JComboBox<String> NamaProduk;
    private javax.swing.JComboBox<String> Nominal;
    private javax.swing.JTextField NomorDus;
    private javax.swing.JComboBox<String> Regional;
    private javax.swing.JTextField StokGudang;
    private javax.swing.JComboBox<String> Tahun;
    private com.toedter.calendar.JDateChooser TanggalPengembalian;
    private javax.swing.JToggleButton batal;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_pengembalian;
    private javax.swing.JButton tambah;
    // End of variables declaration//GEN-END:variables
}
