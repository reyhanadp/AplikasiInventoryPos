/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPengembalian;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengembalianTM;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author reyha
 */
public final class PanelPengembalian extends javax.swing.JPanel {

    PengembalianDAO dao;
    ProdukDAO daoProduk;
    Pengembalian pengembalian;
    Regional regional;
    ArrayList<Regional> arrayRegional;
    ArrayList<Produk> arrayProduk;
    TableRowSorter sorter;

    /**
     * Creates new form PanelPengembalian
     */
    public PanelPengembalian() {
        initComponents();
        getDataPengembalianPrangko();
        getDataPengembalianMSSS();
        getDataPengembalianSHP();
        getDataPengembalianKemasan();
        getDataPengembalianMerchandise();
        getDataPengembalianPrisma();
        getDataPengembalianDokumenFilateli();
    }

    public void getDataPengembalianPrangko() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "PR";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianPrangko.setRowSorter(sorter);
        TablePengembalianPrangko.setModel(pengembalianTM);
    }

    public void getDataPengembalianMSSS() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "MS";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianMSSS.setRowSorter(sorter);
        TablePengembalianMSSS.setModel(pengembalianTM);
    }

    public void getDataPengembalianSHP() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "SHP";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianSHPSS.setRowSorter(sorter);
        TablePengembalianSHPSS.setModel(pengembalianTM);
    }

    public void getDataPengembalianKemasan() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "KM";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianKemasan.setRowSorter(sorter);
        TablePengembalianKemasan.setModel(pengembalianTM);
    }

    public void getDataPengembalianMerchandise() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "MC";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianMerchandise.setRowSorter(sorter);
        TablePengembalianMerchandise.setModel(pengembalianTM);
    }

    public void getDataPengembalianPrisma() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "PS";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianPrisma.setRowSorter(sorter);
        TablePengembalianPrisma.setModel(pengembalianTM);
    }

    public void getDataPengembalianDokumenFilateli() {
        Vector vector_produk = new Vector();
        dao = new PengembalianDAOImpl();
        String jenis_produk = "DF";
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalian(jenis_produk);
        for (int i = 0; i < arrayPengembalian.size(); i++) {
            arrayProduk = dao.getNama(arrayPengembalian.get(i).getId_produk());
            vector_produk.add(arrayProduk.get(0).getNamaProduk());
        }

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian, vector_produk);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianDokumenFilateli.setRowSorter(sorter);
        TablePengembalianDokumenFilateli.setModel(pengembalianTM);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPengembalian = new javax.swing.JTabbedPane();
        Prangko2 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablePengembalianPrangko = new javax.swing.JTable();
        CariPrangko = new javax.swing.JButton();
        FieldCariPrangko = new javax.swing.JTextField();
        ComboboxCariPrangko = new javax.swing.JComboBox<>();
        TambahPengembalian = new javax.swing.JButton();
        MS_SS2 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        TablePengembalianMSSS = new javax.swing.JTable();
        CariMSSS = new javax.swing.JButton();
        FieldCariMSSS = new javax.swing.JTextField();
        ComboboxCariMSSS = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        SHP_SHPSS2 = new javax.swing.JPanel();
        jPanel53 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        TablePengembalianSHPSS = new javax.swing.JTable();
        CariMSSS1 = new javax.swing.JButton();
        FieldCariMSSS1 = new javax.swing.JTextField();
        ComboboxCariMSSS1 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        Kemasan2 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TablePengembalianKemasan = new javax.swing.JTable();
        buttonCariPrangko17 = new javax.swing.JButton();
        fieldCariPrangko17 = new javax.swing.JTextField();
        comboCariPrangko17 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        Merchandise2 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TablePengembalianMerchandise = new javax.swing.JTable();
        buttonCariPrangko18 = new javax.swing.JButton();
        fieldCariPrangko18 = new javax.swing.JTextField();
        comboCariPrangko18 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        Prisma2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TablePengembalianPrisma = new javax.swing.JTable();
        buttonCariPrangko19 = new javax.swing.JButton();
        fieldCariPrangko19 = new javax.swing.JTextField();
        comboCariPrangko19 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        DokumenFilateli2 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TablePengembalianDokumenFilateli = new javax.swing.JTable();
        buttonCariPrangko20 = new javax.swing.JButton();
        fieldCariPrangko20 = new javax.swing.JTextField();
        comboCariPrangko20 = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();

        TabPengembalian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabPengembalianMouseClicked(evt);
            }
        });

        Prangko2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prangko2MouseClicked(evt);
            }
        });

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianPrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianPrangko.getTableHeader().setReorderingAllowed(false);
        TablePengembalianPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianPrangkoMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(TablePengembalianPrangko);

        CariPrangko.setText("Cari");
        CariPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariPrangkoActionPerformed(evt);
            }
        });

        FieldCariPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariPrangkoMouseClicked(evt);
            }
        });

        ComboboxCariPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        TambahPengembalian.setText("Tambah Pengembalian");
        TambahPengembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahPengembalianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TambahPengembalian)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariPrangko))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariPrangko)
                    .addComponent(FieldCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TambahPengembalian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prangko2Layout = new javax.swing.GroupLayout(Prangko2);
        Prangko2.setLayout(Prangko2Layout);
        Prangko2Layout.setHorizontalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prangko2Layout.setVerticalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Prangko", Prangko2);

        MS_SS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS2MouseClicked(evt);
            }
        });

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianMSSS.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianMSSS.getTableHeader().setReorderingAllowed(false);
        TablePengembalianMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianMSSSMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(TablePengembalianMSSS);

        CariMSSS.setText("Cari");
        CariMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariMSSSActionPerformed(evt);
            }
        });

        FieldCariMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariMSSSMouseClicked(evt);
            }
        });

        ComboboxCariMSSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));
        ComboboxCariMSSS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxCariMSSSItemStateChanged(evt);
            }
        });

        jButton1.setText("Tambah Pengembalian");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariMSSS))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariMSSS)
                    .addComponent(FieldCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SS2Layout = new javax.swing.GroupLayout(MS_SS2);
        MS_SS2.setLayout(MS_SS2Layout);
        MS_SS2Layout.setHorizontalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MS_SS2Layout.setVerticalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("MS & SS", MS_SS2);

        SHP_SHPSS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS2MouseClicked(evt);
            }
        });

        jPanel53.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianSHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianSHPSS.getTableHeader().setReorderingAllowed(false);
        TablePengembalianSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianSHPSSMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(TablePengembalianSHPSS);

        CariMSSS1.setText("Cari");
        CariMSSS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CariMSSS1ActionPerformed(evt);
            }
        });

        FieldCariMSSS1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FieldCariMSSS1MouseClicked(evt);
            }
        });

        ComboboxCariMSSS1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));
        ComboboxCariMSSS1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboboxCariMSSS1ItemStateChanged(evt);
            }
        });

        jButton3.setText("Tambah Pengembalian");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ComboboxCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FieldCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CariMSSS1))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addGroup(jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CariMSSS1)
                    .addComponent(FieldCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxCariMSSS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSS2Layout = new javax.swing.GroupLayout(SHP_SHPSS2);
        SHP_SHPSS2.setLayout(SHP_SHPSS2Layout);
        SHP_SHPSS2Layout.setHorizontalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SHP_SHPSS2Layout.setVerticalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("SHP & SHPSS", SHP_SHPSS2);

        Kemasan2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kemasan2MouseClicked(evt);
            }
        });

        jPanel43.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianKemasanMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(TablePengembalianKemasan);

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

        jButton4.setText("Tambah Pengembalian");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko17))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko17)
                    .addComponent(fieldCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Kemasan2Layout = new javax.swing.GroupLayout(Kemasan2);
        Kemasan2.setLayout(Kemasan2Layout);
        Kemasan2Layout.setHorizontalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Kemasan2Layout.setVerticalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Kemasan", Kemasan2);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianMerchandiseMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(TablePengembalianMerchandise);

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

        jButton5.setText("Tambah Pengembalian");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko18))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel45Layout.createSequentialGroup()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko18)
                    .addComponent(fieldCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Merchandise2Layout = new javax.swing.GroupLayout(Merchandise2);
        Merchandise2.setLayout(Merchandise2Layout);
        Merchandise2Layout.setHorizontalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Merchandise2Layout.setVerticalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Merchandise", Merchandise2);

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianPrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianPrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianPrismaMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(TablePengembalianPrisma);

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

        jButton6.setText("Tambah Pengembalian");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko19))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko19)
                    .addComponent(fieldCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prisma2Layout = new javax.swing.GroupLayout(Prisma2);
        Prisma2.setLayout(Prisma2Layout);
        Prisma2Layout.setHorizontalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prisma2Layout.setVerticalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Prisma", Prisma2);

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        TablePengembalianDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        TablePengembalianDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianDokumenFilateliMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(TablePengembalianDokumenFilateli);

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

        jButton7.setText("Tambah Pengembalian");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko20))
        );
        jPanel49Layout.setVerticalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel49Layout.createSequentialGroup()
                .addGroup(jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko20)
                    .addComponent(fieldCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateli2Layout = new javax.swing.GroupLayout(DokumenFilateli2);
        DokumenFilateli2.setLayout(DokumenFilateli2Layout);
        DokumenFilateli2Layout.setHorizontalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DokumenFilateli2Layout.setVerticalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        TabPengembalian.addTab("Dokumen Filateli", DokumenFilateli2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPengembalian)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPengembalian)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TablePengembalianPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianPrangkoMouseClicked

    private void CariPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariPrangkoActionPerformed

    private void FieldCariPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariPrangkoMouseClicked

    private void Prangko2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prangko2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Prangko2MouseClicked

    private void MS_SS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SS2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SS2MouseClicked

    private void SHP_SHPSS2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSS2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSS2MouseClicked

    private void Kemasan2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kemasan2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Kemasan2MouseClicked

    private void TabPengembalianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabPengembalianMouseClicked
        // TODO add your handling code here:
        getDataPengembalianPrangko();
        getDataPengembalianMSSS();
        getDataPengembalianSHP();
        getDataPengembalianKemasan();
        getDataPengembalianMerchandise();
        getDataPengembalianPrisma();
        getDataPengembalianDokumenFilateli();
    }//GEN-LAST:event_TabPengembalianMouseClicked

    private void TablePengembalianKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianKemasanMouseClicked

    private void buttonCariPrangko17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko17ActionPerformed

    private void fieldCariPrangko17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko17MouseClicked

    private void TablePengembalianMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMerchandiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianMerchandiseMouseClicked

    private void buttonCariPrangko18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko18ActionPerformed

    private void fieldCariPrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko18MouseClicked

    private void TablePengembalianPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrismaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianPrismaMouseClicked

    private void buttonCariPrangko19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko19ActionPerformed

    private void fieldCariPrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko19MouseClicked

    private void TablePengembalianDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianDokumenFilateliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianDokumenFilateliMouseClicked

    private void buttonCariPrangko20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko20ActionPerformed

    private void fieldCariPrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko20MouseClicked

    private void TablePengembalianMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianMSSSMouseClicked

    private void CariMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariMSSSActionPerformed

    private void FieldCariMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariMSSSMouseClicked

    private void ComboboxCariMSSSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxCariMSSSItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxCariMSSSItemStateChanged

    private void TablePengembalianSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianSHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianSHPSSMouseClicked

    private void CariMSSS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CariMSSS1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CariMSSS1ActionPerformed

    private void FieldCariMSSS1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FieldCariMSSS1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_FieldCariMSSS1MouseClicked

    private void ComboboxCariMSSS1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboboxCariMSSS1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboboxCariMSSS1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TambahPengembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahPengembalianActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_TambahPengembalianActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPengembalian(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CariMSSS;
    private javax.swing.JButton CariMSSS1;
    private javax.swing.JButton CariPrangko;
    private javax.swing.JComboBox<String> ComboboxCariMSSS;
    private javax.swing.JComboBox<String> ComboboxCariMSSS1;
    private javax.swing.JComboBox<String> ComboboxCariPrangko;
    private javax.swing.JPanel DokumenFilateli2;
    private javax.swing.JTextField FieldCariMSSS;
    private javax.swing.JTextField FieldCariMSSS1;
    private javax.swing.JTextField FieldCariPrangko;
    private javax.swing.JPanel Kemasan2;
    private javax.swing.JPanel MS_SS2;
    private javax.swing.JPanel Merchandise2;
    private javax.swing.JPanel Prangko2;
    private javax.swing.JPanel Prisma2;
    private javax.swing.JPanel SHP_SHPSS2;
    private javax.swing.JTabbedPane TabPengembalian;
    private javax.swing.JTable TablePengembalianDokumenFilateli;
    private javax.swing.JTable TablePengembalianKemasan;
    private javax.swing.JTable TablePengembalianMSSS;
    private javax.swing.JTable TablePengembalianMerchandise;
    private javax.swing.JTable TablePengembalianPrangko;
    private javax.swing.JTable TablePengembalianPrisma;
    private javax.swing.JTable TablePengembalianSHPSS;
    private javax.swing.JButton TambahPengembalian;
    private javax.swing.JButton buttonCariPrangko17;
    private javax.swing.JButton buttonCariPrangko18;
    private javax.swing.JButton buttonCariPrangko19;
    private javax.swing.JButton buttonCariPrangko20;
    private javax.swing.JComboBox<String> comboCariPrangko17;
    private javax.swing.JComboBox<String> comboCariPrangko18;
    private javax.swing.JComboBox<String> comboCariPrangko19;
    private javax.swing.JComboBox<String> comboCariPrangko20;
    private javax.swing.JTextField fieldCariPrangko17;
    private javax.swing.JTextField fieldCariPrangko18;
    private javax.swing.JTextField fieldCariPrangko19;
    private javax.swing.JTextField fieldCariPrangko20;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    // End of variables declaration//GEN-END:variables
}
