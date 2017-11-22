/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.dao.ProdukDAO;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.daoimpl.ProdukDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.tablemodel.PengembalianTM;
import id.ac.pos.gudang.utility.JComboboxListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableRowSorter;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

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
    ArrayList<Produk> arrayProdukPrangko,arrayProdukMSSS,arrayProdukSHPSS,arrayProdukKemasan,arrayProdukMerchandise,arrayProdukPrisma,arrayProdukDokumenFilateli;
    Vector vectorPrangko = new Vector();
    Vector vectorMSSS = new Vector(); 
    Vector vectorSHPSS = new Vector();
    Vector vectorKemasan = new Vector();
    Vector vectorMerchandise = new Vector();
    Vector vectorPrisma = new Vector();
    Vector vectorDokumenFilateli = new Vector();
    Vector vectorRegional = new Vector();
    TableRowSorter sorter;

    /**
     * Creates new form PanelPengembalian
     */
    public PanelPengembalian() {
        initComponents();
        autocompleteKotaPengirim();
        autocompleteNamaProduk();
        getDataPengembalianPrangko();
        
    }

    public void getDataPengembalianPrangko() {
        dao = new PengembalianDAOImpl();
        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalianPrangko();

        PengembalianTM pengembalianTM = new PengembalianTM();
        pengembalianTM.setDataPengembalian(arrayPengembalian);
        sorter = new TableRowSorter(pengembalianTM);
        TablePengembalianPrangko.setRowSorter(sorter);
        TablePengembalianPrangko.setModel(pengembalianTM);
    }

    private void autocompleteNamaProduk() {
//        NamaProdukPrangko.removeAllItems();
        daoProduk = new ProdukDAOImpl();
        arrayProdukPrangko = daoProduk.getProdukPrangko();
        arrayProdukMSSS = daoProduk.getProdukMS_SS();
        arrayProdukSHPSS = daoProduk.getProdukSHP_SHPSS();
        arrayProdukKemasan = daoProduk.getProdukKemasan();
        arrayProdukMerchandise = daoProduk.getProdukMerchandise();
        arrayProdukPrisma = daoProduk.getProdukPrisma();
        arrayProdukDokumenFilateli = daoProduk.getProdukDokumenFilateli();
        
        vectorPrangko.add("");
        vectorMSSS.add("");
        vectorSHPSS.add("");
        vectorKemasan.add("");
        vectorMerchandise.add("");
        vectorPrisma.add("");
        vectorDokumenFilateli.add("");
        
        for (int i = 0; i < arrayProdukPrangko.size(); i++) {
            vectorPrangko.add(arrayProdukPrangko.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukMSSS.size(); i++) {
            vectorMSSS.add(arrayProdukMSSS.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukSHPSS.size(); i++) {
            vectorSHPSS.add(arrayProdukSHPSS.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukKemasan.size(); i++) {
            vectorKemasan.add(arrayProdukKemasan.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukMerchandise.size(); i++) {
            vectorMerchandise.add(arrayProdukMerchandise.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukPrisma.size(); i++) {
            vectorPrisma.add(arrayProdukPrisma.get(i).getNamaProduk());
        }
        
        for (int i = 0; i < arrayProdukDokumenFilateli.size(); i++) {
            vectorDokumenFilateli.add(arrayProdukDokumenFilateli.get(i).getNamaProduk());
        }

        NamaProdukPrangko.setModel(new DefaultComboBoxModel(vectorPrangko));
        NamaProdukMSSS.setModel(new DefaultComboBoxModel(vectorMSSS));
        NamaProdukSHPSS.setModel(new DefaultComboBoxModel(vectorSHPSS));
        NamaProdukKemasan.setModel(new DefaultComboBoxModel(vectorKemasan));
        NamaProdukMerchandise.setModel(new DefaultComboBoxModel(vectorMerchandise));
        NamaProdukPrisma.setModel(new DefaultComboBoxModel(vectorPrisma));
        NamaProdukDokumenFilateli.setModel(new DefaultComboBoxModel(vectorDokumenFilateli));
        
        NamaProdukPrangko.setSelectedIndex(-1);
        NamaProdukMSSS.setSelectedIndex(-1);
        NamaProdukSHPSS.setSelectedIndex(-1);
        NamaProdukKemasan.setSelectedIndex(-1);
        NamaProdukMerchandise.setSelectedIndex(-1);
        NamaProdukPrisma.setSelectedIndex(-1);
        NamaProdukDokumenFilateli.setSelectedIndex(-1);
        
        AutoCompleteDecorator.decorate(NamaProdukPrangko);
        AutoCompleteDecorator.decorate(NamaProdukMSSS);
        AutoCompleteDecorator.decorate(NamaProdukSHPSS);
        AutoCompleteDecorator.decorate(NamaProdukKemasan);
        AutoCompleteDecorator.decorate(NamaProdukMerchandise);
        AutoCompleteDecorator.decorate(NamaProdukPrisma);
        AutoCompleteDecorator.decorate(NamaProdukDokumenFilateli);
////        
//        JTextField textField = (JTextField) NamaProdukPrangko.getEditor().getEditorComponent();
//        textField.setFocusable(true);
//        textField.setText("");
//        textField.addKeyListener(new JComboboxListener(NamaProdukPrangko, vectorPrangko));
//        
    }

    private void autocompleteKotaPengirim() {
//        KotaPengirimPrangko.removeAllItems();
//        KotaPengirimPrangko.addItem("- - - - - - - - - - - -Pilih Regional- - - - - - - - - - - -");
        dao = new PengembalianDAOImpl();
        arrayRegional = dao.getRegional();

        int banyak = arrayRegional.size();
        int rowindex = 0;
        vectorRegional.add("");
        while (0 < banyak) {
            vectorRegional.add(arrayRegional.get(rowindex).getNamaRegional());
            banyak--;
            rowindex++;
        }
        KotaPengirimPrangko.setModel(new DefaultComboBoxModel(vectorRegional));
        KotaPengirimPrangko.setSelectedIndex(-1);
        AutoCompleteDecorator.decorate(KotaPengirimPrangko);
    }

    private void reset() {
        NamaProdukPrangko.setSelectedIndex(0);
        KotaPengirimPrangko.setSelectedIndex(0);
        KodeProdukPrangko.setText("");
        NominalPrangko.setText("");
        KodePosPrangko.setText("");
        KodeRegionalPrangko.setText("");
        StokGudangPrangko.setText("");
        NomorDusPrangko.setText("");
        TanggalPenerimaanPrangko.setDate(null);
        StokGudangPrangko.setText("");
        JumlahTerimaPrangko.setText("");
        KeteranganPrangko.setText("");

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
        jPanel37 = new javax.swing.JPanel();
        jLabel119 = new javax.swing.JLabel();
        TanggalPenerimaanPrangko = new com.toedter.calendar.JDateChooser();
        jLabel45 = new javax.swing.JLabel();
        StokGudangPrangko = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        JumlahTerimaPrangko = new javax.swing.JTextField();
        SimpanPrangko = new javax.swing.JButton();
        jLabel47 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NomorDusPrangko = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        KotaPengirimPrangko = new javax.swing.JComboBox<>();
        jLabel118 = new javax.swing.JLabel();
        NamaProdukPrangko = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        KodeProdukPrangko = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        NominalPrangko = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        KodeRegionalPrangko = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        KodePosPrangko = new javax.swing.JTextField();
        jScrollPane35 = new javax.swing.JScrollPane();
        KeteranganPrangko = new javax.swing.JTextArea();
        resetPrangko = new javax.swing.JToggleButton();
        jPanel38 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TablePengembalianPrangko = new javax.swing.JTable();
        buttonCariPrangko8 = new javax.swing.JButton();
        fieldCariPrangko8 = new javax.swing.JTextField();
        comboCariPrangko8 = new javax.swing.JComboBox<>();
        MS_SS2 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TablePengembalianMSSS = new javax.swing.JTable();
        buttonCariPrangko15 = new javax.swing.JButton();
        fieldCariPrangko15 = new javax.swing.JTextField();
        comboCariPrangko15 = new javax.swing.JComboBox<>();
        jPanel40 = new javax.swing.JPanel();
        jLabel132 = new javax.swing.JLabel();
        TanggalPenerimaanMSSS = new com.toedter.calendar.JDateChooser();
        jLabel49 = new javax.swing.JLabel();
        StokGudangMSSS = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        JumlahTerimaMSSS = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        NomorDusMSSS = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        KotaPengirimMSSS = new javax.swing.JComboBox<>();
        jLabel133 = new javax.swing.JLabel();
        NamaProdukMSSS = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        KodeProdukMSSS = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        NominalMSSS = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        KodeRegionalMSSS = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        KodePosMSSS = new javax.swing.JTextField();
        jScrollPane36 = new javax.swing.JScrollPane();
        KeteranganMSSS = new javax.swing.JTextArea();
        resetPrangko1 = new javax.swing.JToggleButton();
        SHP_SHPSS2 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TablePengembalianSHPSS = new javax.swing.JTable();
        buttonCariPrangko16 = new javax.swing.JButton();
        fieldCariPrangko16 = new javax.swing.JTextField();
        comboCariPrangko16 = new javax.swing.JComboBox<>();
        jPanel42 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        TanggalPenerimaanSHPSS = new com.toedter.calendar.JDateChooser();
        jLabel52 = new javax.swing.JLabel();
        StokGudangSHPSS = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        JumlahTerimaSHPSS = new javax.swing.JTextField();
        jButton14 = new javax.swing.JButton();
        jLabel59 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        NomorDusSHPSS = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        KotaPengirimSHPSS = new javax.swing.JComboBox<>();
        jLabel135 = new javax.swing.JLabel();
        NamaProdukSHPSS = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        KodeProdukSHPSS = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        NominalSHPSS = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        KodeRegionalSHPSS = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        KodePosSHPSS = new javax.swing.JTextField();
        jScrollPane37 = new javax.swing.JScrollPane();
        KeteranganSHPSS = new javax.swing.JTextArea();
        resetPrangko2 = new javax.swing.JToggleButton();
        Kemasan2 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TablePengembalianKemasan = new javax.swing.JTable();
        buttonCariPrangko17 = new javax.swing.JButton();
        fieldCariPrangko17 = new javax.swing.JTextField();
        comboCariPrangko17 = new javax.swing.JComboBox<>();
        jPanel44 = new javax.swing.JPanel();
        jLabel136 = new javax.swing.JLabel();
        TanggalPenerimaanKemasan = new com.toedter.calendar.JDateChooser();
        jLabel61 = new javax.swing.JLabel();
        StokGudangKemasan = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        JumlahTerimaKemasan = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jLabel63 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        NomorDusKemasan = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        KotaPengirimKemasan = new javax.swing.JComboBox<>();
        jLabel137 = new javax.swing.JLabel();
        NamaProdukKemasan = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        KodeProdukKemasan = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        NominalKemasan = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        KodeRegionalKemasan = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        KodePosKemasan = new javax.swing.JTextField();
        jScrollPane38 = new javax.swing.JScrollPane();
        KeteranganKemasan = new javax.swing.JTextArea();
        resetPrangko3 = new javax.swing.JToggleButton();
        Merchandise2 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tablePrangko18 = new javax.swing.JTable();
        buttonCariPrangko18 = new javax.swing.JButton();
        fieldCariPrangko18 = new javax.swing.JTextField();
        comboCariPrangko18 = new javax.swing.JComboBox<>();
        jPanel46 = new javax.swing.JPanel();
        jLabel138 = new javax.swing.JLabel();
        TanggalPenerimaanMerchandise = new com.toedter.calendar.JDateChooser();
        jLabel65 = new javax.swing.JLabel();
        StokGudangMerchandise = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        JumlahTerimaMerchandise = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel67 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        NomorDusMerchandise = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        KotaPengirimMerchandise = new javax.swing.JComboBox<>();
        jLabel139 = new javax.swing.JLabel();
        NamaProdukMerchandise = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        KodeProdukMerchandise = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        NominalMerchandise = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        KodeRegionalMerchandise = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        KodePosMerchandise = new javax.swing.JTextField();
        jScrollPane39 = new javax.swing.JScrollPane();
        KeteranganMerchandise = new javax.swing.JTextArea();
        resetPrangko4 = new javax.swing.JToggleButton();
        Prisma2 = new javax.swing.JPanel();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tablePrangko19 = new javax.swing.JTable();
        buttonCariPrangko19 = new javax.swing.JButton();
        fieldCariPrangko19 = new javax.swing.JTextField();
        comboCariPrangko19 = new javax.swing.JComboBox<>();
        jPanel48 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        TanggalPenerimaanPrisma = new com.toedter.calendar.JDateChooser();
        jLabel69 = new javax.swing.JLabel();
        StokGudangPrisma = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        JumlahTerimaPrisma = new javax.swing.JTextField();
        jButton17 = new javax.swing.JButton();
        jLabel71 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        NomorDusPrisma = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        KotaPengirimPrisma = new javax.swing.JComboBox<>();
        jLabel141 = new javax.swing.JLabel();
        NamaProdukPrisma = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        KodeProdukPrisma = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        NominalPrisma = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        KodeRegionalPrisma = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        KodePosPrisma = new javax.swing.JTextField();
        jScrollPane40 = new javax.swing.JScrollPane();
        KeteranganPrisma = new javax.swing.JTextArea();
        resetPrangko5 = new javax.swing.JToggleButton();
        DokumenFilateli2 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tablePrangko20 = new javax.swing.JTable();
        buttonCariPrangko20 = new javax.swing.JButton();
        fieldCariPrangko20 = new javax.swing.JTextField();
        comboCariPrangko20 = new javax.swing.JComboBox<>();
        jPanel50 = new javax.swing.JPanel();
        jLabel142 = new javax.swing.JLabel();
        TanggalPenerimaanDokumenFilateli = new com.toedter.calendar.JDateChooser();
        jLabel73 = new javax.swing.JLabel();
        StokGudangDokumenFilateli = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        JumlahTerimaDokumenFilateli = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        NomorDusDokumenFilateli = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        KotaPengirimDokumenFilateli = new javax.swing.JComboBox<>();
        jLabel143 = new javax.swing.JLabel();
        NamaProdukDokumenFilateli = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        KodeProdukDokumenFilateli = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        NominalDokumenFilateli = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        KodeRegionalDokumenFilateli = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        KodePosDokumenFilateli = new javax.swing.JTextField();
        jScrollPane41 = new javax.swing.JScrollPane();
        KeteranganDokumenFilateli = new javax.swing.JTextArea();
        resetPrangko6 = new javax.swing.JToggleButton();

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

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Pengembalian"));
        jPanel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel37MouseClicked(evt);
            }
        });

        jLabel119.setText("Tanggal Penerimaan");

        jLabel45.setText("Stok Gudang");

        StokGudangPrangko.setEditable(false);

        jLabel46.setText("Jumlah Terima");

        JumlahTerimaPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JumlahTerimaPrangkoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JumlahTerimaPrangkoKeyTyped(evt);
            }
        });

        SimpanPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        SimpanPrangko.setText("Simpan");
        SimpanPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanPrangkoActionPerformed(evt);
            }
        });

        jLabel47.setText("Keterangan");

        jLabel1.setText("Nomor Dus");

        NomorDusPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusPrangkoActionPerformed(evt);
            }
        });
        NomorDusPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NomorDusPrangkoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NomorDusPrangkoKeyTyped(evt);
            }
        });

        jLabel43.setText("Regional Pengirim");

        KotaPengirimPrangko.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                KotaPengirimPrangkoItemStateChanged(evt);
            }
        });

        jLabel118.setText("Nama Produk");

        NamaProdukPrangko.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NamaProdukPrangkoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Kode Produk");

        KodeProdukPrangko.setEditable(false);

        jLabel3.setText("Nominal");

        NominalPrangko.setEditable(false);
        NominalPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalPrangkoActionPerformed(evt);
            }
        });

        jLabel4.setText("Kode Regional");

        KodeRegionalPrangko.setEditable(false);

        jLabel5.setText("Kode Pos");

        KodePosPrangko.setEditable(false);

        KeteranganPrangko.setColumns(20);
        KeteranganPrangko.setLineWrap(true);
        KeteranganPrangko.setRows(2);
        KeteranganPrangko.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganPrangkoKeyPressed(evt);
            }
        });
        jScrollPane35.setViewportView(KeteranganPrangko);

        resetPrangko.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko.setText("Reset");
        resetPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel118, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanPrangko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangPrangko)
                            .addComponent(JumlahTerimaPrangko)
                            .addComponent(NomorDusPrangko)
                            .addComponent(KodeRegionalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosPrangko))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                                .addComponent(KodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimPrangko, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukPrangko, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel37Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane35)
                            .addGroup(jPanel37Layout.createSequentialGroup()
                                .addComponent(SimpanPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel118)
                    .addComponent(NamaProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(NominalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(KodePosPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanPrangko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel119, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangPrangko))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(JumlahTerimaPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel47)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(SimpanPrangko)
                    .addComponent(resetPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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

        buttonCariPrangko8.setText("Cari");
        buttonCariPrangko8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPrangko8ActionPerformed(evt);
            }
        });

        fieldCariPrangko8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPrangko8MouseClicked(evt);
            }
        });

        comboCariPrangko8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Id Produk", "Nominal", "Biaya Cetak", "Stok", "Tahun" }));

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboCariPrangko8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko8))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko8)
                    .addComponent(fieldCariPrangko8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prangko2Layout = new javax.swing.GroupLayout(Prangko2);
        Prangko2.setLayout(Prangko2Layout);
        Prangko2Layout.setHorizontalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Prangko2Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Prangko2Layout.setVerticalGroup(
            Prangko2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prangko2Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPengembalian.addTab("Prangko", Prangko2);

        MS_SS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS2MouseClicked(evt);
            }
        });

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

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
        TablePengembalianMSSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianMSSSMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TablePengembalianMSSS);

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

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko15))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko15)
                    .addComponent(fieldCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel40MouseClicked(evt);
            }
        });

        jLabel132.setText("Tanggal Penerimaan");

        jLabel49.setText("Stok Gudang");

        jLabel50.setText("Jumlah Terima");

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton13.setText("Simpan");

        jLabel51.setText("Keterangan");

        jLabel6.setText("Nomor Dus");

        NomorDusMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusMSSSActionPerformed(evt);
            }
        });

        jLabel44.setText("Regional Pengirim");

        jLabel133.setText("Nama Produk");

        NamaProdukMSSS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NamaProdukMSSSItemStateChanged(evt);
            }
        });
        NamaProdukMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukMSSSActionPerformed(evt);
            }
        });

        jLabel7.setText("Kode Produk");

        jLabel14.setText("Nominal");

        NominalMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalMSSSActionPerformed(evt);
            }
        });

        jLabel15.setText("Kode Regional");

        jLabel16.setText("Kode Pos");

        KeteranganMSSS.setColumns(20);
        KeteranganMSSS.setLineWrap(true);
        KeteranganMSSS.setRows(2);
        jScrollPane36.setViewportView(KeteranganMSSS);

        resetPrangko1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko1.setText("Reset");
        resetPrangko1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel133, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanMSSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangMSSS)
                            .addComponent(JumlahTerimaMSSS)
                            .addComponent(NomorDusMSSS)
                            .addComponent(KodeRegionalMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosMSSS))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel40Layout.createSequentialGroup()
                                .addComponent(KodeProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimMSSS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukMSSS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel40Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane36, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel40Layout.createSequentialGroup()
                                .addComponent(jButton13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(NamaProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(NominalMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimMSSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(KodePosMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusMSSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanMSSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel132, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangMSSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(JumlahTerimaMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(resetPrangko1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout MS_SS2Layout = new javax.swing.GroupLayout(MS_SS2);
        MS_SS2.setLayout(MS_SS2Layout);
        MS_SS2Layout.setHorizontalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MS_SS2Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        MS_SS2Layout.setVerticalGroup(
            MS_SS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MS_SS2Layout.createSequentialGroup()
                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPengembalian.addTab("MS & SS", MS_SS2);

        SHP_SHPSS2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS2MouseClicked(evt);
            }
        });

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

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
        TablePengembalianSHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablePengembalianSHPSSMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(TablePengembalianSHPSS);

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

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(comboCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPrangko16))
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addGroup(jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCariPrangko16)
                    .addComponent(fieldCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCariPrangko16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel42.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel42MouseClicked(evt);
            }
        });

        jLabel134.setText("Tanggal Penerimaan");

        jLabel52.setText("Stok Gudang");

        jLabel53.setText("Jumlah Terima");

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton14.setText("Simpan");

        jLabel59.setText("Keterangan");

        jLabel17.setText("Nomor Dus");

        NomorDusSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusSHPSSActionPerformed(evt);
            }
        });

        jLabel60.setText("Regional Pengirim");

        jLabel135.setText("Nama Produk");

        NamaProdukSHPSS.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                NamaProdukSHPSSItemStateChanged(evt);
            }
        });
        NamaProdukSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukSHPSSActionPerformed(evt);
            }
        });

        jLabel18.setText("Kode Produk");

        jLabel19.setText("Nominal");

        NominalSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalSHPSSActionPerformed(evt);
            }
        });

        jLabel20.setText("Kode Regional");

        jLabel21.setText("Kode Pos");

        KeteranganSHPSS.setColumns(20);
        KeteranganSHPSS.setLineWrap(true);
        KeteranganSHPSS.setRows(2);
        jScrollPane37.setViewportView(KeteranganSHPSS);

        resetPrangko2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko2.setText("Reset");
        resetPrangko2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel135, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanSHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangSHPSS)
                            .addComponent(JumlahTerimaSHPSS)
                            .addComponent(NomorDusSHPSS)
                            .addComponent(KodeRegionalSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosSHPSS))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel42Layout.createSequentialGroup()
                                .addComponent(KodeProdukSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimSHPSS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukSHPSS, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel42Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane37, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel42Layout.createSequentialGroup()
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel135)
                    .addComponent(NamaProdukSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19)
                        .addComponent(NominalSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel21)
                        .addComponent(KodePosSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanSHPSS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel134, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangSHPSS))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(JumlahTerimaSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(resetPrangko2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout SHP_SHPSS2Layout = new javax.swing.GroupLayout(SHP_SHPSS2);
        SHP_SHPSS2.setLayout(SHP_SHPSS2Layout);
        SHP_SHPSS2Layout.setHorizontalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SHP_SHPSS2Layout.createSequentialGroup()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        SHP_SHPSS2Layout.setVerticalGroup(
            SHP_SHPSS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SHP_SHPSS2Layout.createSequentialGroup()
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel44.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel44MouseClicked(evt);
            }
        });

        jLabel136.setText("Tanggal Penerimaan");

        jLabel61.setText("Stok Gudang");

        jLabel62.setText("Jumlah Terima");

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton15.setText("Simpan");

        jLabel63.setText("Keterangan");

        jLabel22.setText("Nomor Dus");

        NomorDusKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusKemasanActionPerformed(evt);
            }
        });

        jLabel64.setText("Regional Pengirim");

        jLabel137.setText("Nama Produk");

        NamaProdukKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukKemasanActionPerformed(evt);
            }
        });

        jLabel23.setText("Kode Produk");

        jLabel24.setText("Nominal");

        NominalKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalKemasanActionPerformed(evt);
            }
        });

        jLabel25.setText("Kode Regional");

        jLabel26.setText("Kode Pos");

        KeteranganKemasan.setColumns(20);
        KeteranganKemasan.setLineWrap(true);
        KeteranganKemasan.setRows(2);
        jScrollPane38.setViewportView(KeteranganKemasan);

        resetPrangko3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko3.setText("Reset");
        resetPrangko3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel63, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel137, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanKemasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangKemasan)
                            .addComponent(JumlahTerimaKemasan)
                            .addComponent(NomorDusKemasan)
                            .addComponent(KodeRegionalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosKemasan))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                                .addComponent(KodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimKemasan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukKemasan, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel44Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane38, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel44Layout.createSequentialGroup()
                                .addComponent(jButton15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel137)
                    .addComponent(NamaProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel24)
                        .addComponent(NominalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(KodePosKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanKemasan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel136, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangKemasan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(JumlahTerimaKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel63)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton15)
                    .addComponent(resetPrangko3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Kemasan2Layout = new javax.swing.GroupLayout(Kemasan2);
        Kemasan2.setLayout(Kemasan2Layout);
        Kemasan2Layout.setHorizontalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Kemasan2Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Kemasan2Layout.setVerticalGroup(
            Kemasan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Kemasan2Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPengembalian.addTab("Kemasan", Kemasan2);

        jPanel45.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        tablePrangko18.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePrangko18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrangko18MouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tablePrangko18);

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

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel46.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel46MouseClicked(evt);
            }
        });

        jLabel138.setText("Tanggal Penerimaan");

        jLabel65.setText("Stok Gudang");

        jLabel66.setText("Jumlah Terima");

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton16.setText("Simpan");

        jLabel67.setText("Keterangan");

        jLabel27.setText("Nomor Dus");

        NomorDusMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusMerchandiseActionPerformed(evt);
            }
        });

        jLabel68.setText("Regional Pengirim");

        jLabel139.setText("Nama Produk");

        NamaProdukMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukMerchandiseActionPerformed(evt);
            }
        });

        jLabel28.setText("Kode Produk");

        jLabel29.setText("Nominal");

        NominalMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalMerchandiseActionPerformed(evt);
            }
        });

        jLabel30.setText("Kode Regional");

        jLabel31.setText("Kode Pos");

        KeteranganMerchandise.setColumns(20);
        KeteranganMerchandise.setLineWrap(true);
        KeteranganMerchandise.setRows(2);
        jScrollPane39.setViewportView(KeteranganMerchandise);

        resetPrangko4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko4.setText("Reset");
        resetPrangko4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel46Layout = new javax.swing.GroupLayout(jPanel46);
        jPanel46.setLayout(jPanel46Layout);
        jPanel46Layout.setHorizontalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangMerchandise)
                            .addComponent(JumlahTerimaMerchandise)
                            .addComponent(NomorDusMerchandise)
                            .addComponent(KodeRegionalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosMerchandise))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel46Layout.createSequentialGroup()
                                .addComponent(KodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimMerchandise, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukMerchandise, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel46Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane39, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel46Layout.createSequentialGroup()
                                .addComponent(jButton16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel46Layout.setVerticalGroup(
            jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel46Layout.createSequentialGroup()
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel139)
                    .addComponent(NamaProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel29)
                        .addComponent(NominalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel31)
                        .addComponent(KodePosMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanMerchandise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel138, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangMerchandise))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66)
                    .addComponent(JumlahTerimaMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel46Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16)
                    .addComponent(resetPrangko4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Merchandise2Layout = new javax.swing.GroupLayout(Merchandise2);
        Merchandise2.setLayout(Merchandise2Layout);
        Merchandise2Layout.setHorizontalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Merchandise2Layout.createSequentialGroup()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Merchandise2Layout.setVerticalGroup(
            Merchandise2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Merchandise2Layout.createSequentialGroup()
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPengembalian.addTab("Merchandise", Merchandise2);

        jPanel47.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        tablePrangko19.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePrangko19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrangko19MouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tablePrangko19);

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

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel48.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel48MouseClicked(evt);
            }
        });

        jLabel140.setText("Tanggal Penerimaan");

        jLabel69.setText("Stok Gudang");

        jLabel70.setText("Jumlah Terima");

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton17.setText("Simpan");

        jLabel71.setText("Keterangan");

        jLabel32.setText("Nomor Dus");

        NomorDusPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusPrismaActionPerformed(evt);
            }
        });

        jLabel72.setText("Regional Pengirim");

        jLabel141.setText("Nama Produk");

        NamaProdukPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukPrismaActionPerformed(evt);
            }
        });

        jLabel33.setText("Kode Produk");

        jLabel34.setText("Nominal");

        NominalPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalPrismaActionPerformed(evt);
            }
        });

        jLabel35.setText("Kode Regional");

        jLabel36.setText("Kode Pos");

        KeteranganPrisma.setColumns(20);
        KeteranganPrisma.setLineWrap(true);
        KeteranganPrisma.setRows(2);
        jScrollPane40.setViewportView(KeteranganPrisma);

        resetPrangko5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko5.setText("Reset");
        resetPrangko5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel71, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel141, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangPrisma)
                            .addComponent(JumlahTerimaPrisma)
                            .addComponent(NomorDusPrisma)
                            .addComponent(KodeRegionalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosPrisma))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                                .addComponent(KodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimPrisma, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukPrisma, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane40, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel48Layout.createSequentialGroup()
                                .addComponent(jButton17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel141)
                    .addComponent(NamaProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel34)
                        .addComponent(NominalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(KodePosPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanPrisma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel140, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangPrisma))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(JumlahTerimaPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel71)
                    .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(resetPrangko5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout Prisma2Layout = new javax.swing.GroupLayout(Prisma2);
        Prisma2.setLayout(Prisma2Layout);
        Prisma2Layout.setHorizontalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(Prisma2Layout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Prisma2Layout.setVerticalGroup(
            Prisma2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prisma2Layout.createSequentialGroup()
                .addComponent(jPanel48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPengembalian.addTab("Prisma", Prisma2);

        jPanel49.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pengembalian"));

        tablePrangko20.setModel(new javax.swing.table.DefaultTableModel(
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
        tablePrangko20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePrangko20MouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(tablePrangko20);

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

        javax.swing.GroupLayout jPanel49Layout = new javax.swing.GroupLayout(jPanel49);
        jPanel49.setLayout(jPanel49Layout);
        jPanel49Layout.setHorizontalGroup(
            jPanel49Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 1038, Short.MAX_VALUE)
            .addGroup(jPanel49Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
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
                    .addComponent(comboCariPrangko20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
        );

        jPanel50.setBorder(javax.swing.BorderFactory.createTitledBorder("Form Produk"));
        jPanel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel50MouseClicked(evt);
            }
        });

        jLabel142.setText("Tanggal Penerimaan");

        jLabel73.setText("Stok Gudang");

        jLabel74.setText("Jumlah Terima");

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/save.png"))); // NOI18N
        jButton18.setText("Simpan");

        jLabel75.setText("Keterangan");

        jLabel37.setText("Nomor Dus");

        NomorDusDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NomorDusDokumenFilateliActionPerformed(evt);
            }
        });

        jLabel76.setText("Regional Pengirim");

        jLabel143.setText("Nama Produk");

        NamaProdukDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaProdukDokumenFilateliActionPerformed(evt);
            }
        });

        jLabel38.setText("Kode Produk");

        jLabel39.setText("Nominal");

        NominalDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalDokumenFilateliActionPerformed(evt);
            }
        });

        jLabel40.setText("Kode Regional");

        jLabel41.setText("Kode Pos");

        KeteranganDokumenFilateli.setColumns(20);
        KeteranganDokumenFilateli.setLineWrap(true);
        KeteranganDokumenFilateli.setRows(2);
        jScrollPane41.setViewportView(KeteranganDokumenFilateli);

        resetPrangko6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons/Reset.png"))); // NOI18N
        resetPrangko6.setText("Reset");
        resetPrangko6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPrangko6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel143, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalPenerimaanDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StokGudangDokumenFilateli)
                            .addComponent(JumlahTerimaDokumenFilateli)
                            .addComponent(NomorDusDokumenFilateli)
                            .addComponent(KodeRegionalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KodePosDokumenFilateli))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                                .addComponent(KodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NominalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(KotaPengirimDokumenFilateli, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NamaProdukDokumenFilateli, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel50Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane41, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel50Layout.createSequentialGroup()
                                .addComponent(jButton18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetPrangko6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel143)
                    .addComponent(NamaProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel39)
                        .addComponent(NominalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeProdukDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(KotaPengirimDokumenFilateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel41)
                        .addComponent(KodePosDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(KodeRegionalDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomorDusDokumenFilateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TanggalPenerimaanDokumenFilateli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel142, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel73, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StokGudangDokumenFilateli))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(JumlahTerimaDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel75)
                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18)
                    .addComponent(resetPrangko6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout DokumenFilateli2Layout = new javax.swing.GroupLayout(DokumenFilateli2);
        DokumenFilateli2.setLayout(DokumenFilateli2Layout);
        DokumenFilateli2Layout.setHorizontalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(DokumenFilateli2Layout.createSequentialGroup()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        DokumenFilateli2Layout.setVerticalGroup(
            DokumenFilateli2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DokumenFilateli2Layout.createSequentialGroup()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jPanel37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel37MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel37MouseClicked

    private void TablePengembalianPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianPrangkoMouseClicked

    private void buttonCariPrangko8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko8ActionPerformed

    private void fieldCariPrangko8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko8MouseClicked

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
    }//GEN-LAST:event_TabPengembalianMouseClicked

    private void NominalPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalPrangkoActionPerformed

    private void NomorDusPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusPrangkoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusPrangkoActionPerformed

    private void TablePengembalianMSSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianMSSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianMSSSMouseClicked

    private void buttonCariPrangko15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko15ActionPerformed

    private void fieldCariPrangko15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko15MouseClicked

    private void NomorDusMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusMSSSActionPerformed

    private void NamaProdukMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukMSSSActionPerformed

    private void NominalMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalMSSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalMSSSActionPerformed

    private void jPanel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel40MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel40MouseClicked

    private void TablePengembalianSHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianSHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianSHPSSMouseClicked

    private void buttonCariPrangko16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko16ActionPerformed

    private void fieldCariPrangko16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko16MouseClicked

    private void NomorDusSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusSHPSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusSHPSSActionPerformed

    private void NamaProdukSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukSHPSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukSHPSSActionPerformed

    private void NominalSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalSHPSSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalSHPSSActionPerformed

    private void jPanel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel42MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel42MouseClicked

    private void TablePengembalianKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablePengembalianKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePengembalianKemasanMouseClicked

    private void buttonCariPrangko17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko17ActionPerformed

    private void fieldCariPrangko17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko17MouseClicked

    private void NomorDusKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusKemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusKemasanActionPerformed

    private void NamaProdukKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukKemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukKemasanActionPerformed

    private void NominalKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalKemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalKemasanActionPerformed

    private void jPanel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel44MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel44MouseClicked

    private void tablePrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePrangko18MouseClicked

    private void buttonCariPrangko18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko18ActionPerformed

    private void fieldCariPrangko18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko18MouseClicked

    private void NomorDusMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusMerchandiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusMerchandiseActionPerformed

    private void NamaProdukMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukMerchandiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukMerchandiseActionPerformed

    private void NominalMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalMerchandiseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalMerchandiseActionPerformed

    private void jPanel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel46MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel46MouseClicked

    private void tablePrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePrangko19MouseClicked

    private void buttonCariPrangko19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko19ActionPerformed

    private void fieldCariPrangko19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko19MouseClicked

    private void NomorDusPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusPrismaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusPrismaActionPerformed

    private void NamaProdukPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukPrismaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukPrismaActionPerformed

    private void NominalPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalPrismaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalPrismaActionPerformed

    private void jPanel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel48MouseClicked

    private void tablePrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablePrangko20MouseClicked

    private void buttonCariPrangko20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPrangko20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonCariPrangko20ActionPerformed

    private void fieldCariPrangko20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPrangko20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPrangko20MouseClicked

    private void NomorDusDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NomorDusDokumenFilateliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NomorDusDokumenFilateliActionPerformed

    private void NamaProdukDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaProdukDokumenFilateliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaProdukDokumenFilateliActionPerformed

    private void NominalDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalDokumenFilateliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalDokumenFilateliActionPerformed

    private void jPanel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel50MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel50MouseClicked

    private void KotaPengirimPrangkoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_KotaPengirimPrangkoItemStateChanged
        // TODO add your handling code here:

        KotaPengirimPrangko.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object pilihan = e.getItem();
                if (pilihan != "") {
                    dao = new PengembalianDAOImpl();
                    arrayRegional = dao.getIsiRegional(pilihan);

                    KodeRegionalPrangko.setText(arrayRegional.get(0).getIdRegional());
                    KodePosPrangko.setText(arrayRegional.get(0).getKodePos());
                } else {
                    KodePosPrangko.setText("");
                    KodeRegionalPrangko.setText("");
                }

            }
        });


    }//GEN-LAST:event_KotaPengirimPrangkoItemStateChanged

    private void NamaProdukPrangkoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NamaProdukPrangkoItemStateChanged
        // TODO add your handling code here:

        NamaProdukPrangko.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object pilihan = e.getItem();
                String jenis_produk = "PR";
                if (pilihan != "") {
                    dao = new PengembalianDAOImpl();
//                  
                    arrayProdukPrangko = dao.getProduk(pilihan,jenis_produk);
                    KodeProdukPrangko.setText(arrayProdukPrangko.get(0).getIdProduk());
                    String nominal = Integer.toString(arrayProdukPrangko.get(0).getNominal());
                    NominalPrangko.setText(nominal);
                    String stok = Integer.toString(arrayProdukPrangko.get(0).getStok());
                    StokGudangPrangko.setText(stok);
                } else {
                    KodeProdukPrangko.setText("");
                    NominalPrangko.setText("");
                    StokGudangPrangko.setText("");
                }

            }
        });
    }//GEN-LAST:event_NamaProdukPrangkoItemStateChanged

    private void SimpanPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanPrangkoActionPerformed
        // TODO add your handling code here:
        String kosong = null;
        String kode_produk = KodeProdukPrangko.getText();
        String kode_regional = KodeRegionalPrangko.getText();
        String nomor_dus = NomorDusPrangko.getText();
        java.util.Date tanggal = (java.util.Date) TanggalPenerimaanPrangko.getDate();
        String stok_gudang = StokGudangPrangko.getText();
        String jumlah_terima = JumlahTerimaPrangko.getText();
        String keterangan = KeteranganPrangko.getText();
        dao = new PengembalianDAOImpl();

        //autoincrement id_pengembalian
        String id_pengembalian_string = dao.getIdPengembalian();
        if (id_pengembalian_string == null) {
            id_pengembalian_string = "00000";
        }
        Integer id_pengembalian = Integer.parseInt(id_pengembalian_string);
        id_pengembalian++;
        id_pengembalian_string = Integer.toString(id_pengembalian);
        int panjang = id_pengembalian_string.length();

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

        id_pengembalian_string = kosong + id_pengembalian_string;

        if (kode_produk.compareTo("") != 0) {
            if (kode_regional.compareTo("") != 0) {
                if (tanggal != null) {
                    if (jumlah_terima.compareTo("") != 0) {
                        if(nomor_dus.compareTo("")==0){
                            nomor_dus = null;
                        }
                        
                        if(keterangan.compareTo("")==0){
                            keterangan = null;
                        }
                        
                        pengembalian = new Pengembalian();
                        pengembalian.setId_pengembalian(id_pengembalian_string);
                        pengembalian.setTanggal_pengembalian(tanggal);
                        pengembalian.setJumlah_pengembalian(jumlah_terima);
                        pengembalian.setDus(nomor_dus);
                        pengembalian.setId_regional(kode_regional);
                        pengembalian.setId_produk(kode_produk);
                        pengembalian.setStok_awal(stok_gudang);
                        pengembalian.setKeterangan(keterangan);

                        boolean sukses = dao.tambahPengembalian(pengembalian);

                        //cek sukses atau tidak
                        if (sukses) {
                            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                            getDataPengembalianPrangko();
                            reset();
                        } else {
                            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan");
                            reset();
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Silakan isi jumlah terima terlebih dahulu!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Silakan isi tanggal pengembalian terlebih dahulu!");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Silakan pilih regional terlebih dahulu!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Silakan pilih produk terlebih dahulu!");
        }


    }//GEN-LAST:event_SimpanPrangkoActionPerformed

    private void resetPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangkoActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetPrangkoActionPerformed

    private void NomorDusPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorDusPrangkoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            TanggalPenerimaanPrangko.requestFocus();
        }
    }//GEN-LAST:event_NomorDusPrangkoKeyPressed

    private void JumlahTerimaPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTerimaPrangkoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            KeteranganPrangko.requestFocus();
        }
    }//GEN-LAST:event_JumlahTerimaPrangkoKeyPressed

    private void KeteranganPrangkoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganPrangkoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SimpanPrangko.requestFocus();
        }
    }//GEN-LAST:event_KeteranganPrangkoKeyPressed

    private void NomorDusPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NomorDusPrangkoKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            evt.consume();
        }
    }//GEN-LAST:event_NomorDusPrangkoKeyTyped

    private void JumlahTerimaPrangkoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JumlahTerimaPrangkoKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(((karakter >= '0') && (karakter <= '9')
                || (karakter == KeyEvent.VK_BACK_SPACE)
                || (karakter == KeyEvent.VK_DELETE)
                || (karakter == KeyEvent.VK_ENTER)))) {
            evt.consume();
        }
    }//GEN-LAST:event_JumlahTerimaPrangkoKeyTyped

    private void resetPrangko1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko1ActionPerformed

    private void resetPrangko2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko2ActionPerformed

    private void resetPrangko3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko3ActionPerformed

    private void resetPrangko4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko4ActionPerformed

    private void resetPrangko5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko5ActionPerformed

    private void resetPrangko6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPrangko6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetPrangko6ActionPerformed

    private void NamaProdukMSSSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NamaProdukMSSSItemStateChanged
        // TODO add your handling code here:
        NamaProdukMSSS.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object pilihan = e.getItem();
                String jenis_produk = "MS";
                if (pilihan != "") {
                    dao = new PengembalianDAOImpl();
//
                    arrayProdukMSSS = dao.getProduk(pilihan,jenis_produk);
                    KodeProdukMSSS.setText(arrayProdukMSSS.get(0).getIdProduk());
                    String nominal = Integer.toString(arrayProdukMSSS.get(0).getNominal());
                    NominalMSSS.setText(nominal);
                    String stok = Integer.toString(arrayProdukMSSS.get(0).getStok());
                    StokGudangMSSS.setText(stok);
                } else {
                    KodeProdukPrangko.setText("");
                    NominalPrangko.setText("");
                    StokGudangPrangko.setText("");
                }

            }
        });
    }//GEN-LAST:event_NamaProdukMSSSItemStateChanged

    private void NamaProdukSHPSSItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_NamaProdukSHPSSItemStateChanged
        // TODO add your handling code here:
        NamaProdukSHPSS.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                Object pilihan = e.getItem();
                String jenis_produk = "SHP";
                if (pilihan != "") {
                    dao = new PengembalianDAOImpl();
//
                    arrayProdukSHPSS = dao.getProduk(pilihan,jenis_produk);
                    KodeProdukPrangko.setText(arrayProdukSHPSS.get(0).getIdProduk());
                    String nominal = Integer.toString(arrayProdukSHPSS.get(0).getNominal());
                    NominalPrangko.setText(nominal);
                    String stok = Integer.toString(arrayProdukSHPSS.get(0).getStok());
                    StokGudangPrangko.setText(stok);
                } else {
                    KodeProdukPrangko.setText("");
                    NominalPrangko.setText("");
                    StokGudangPrangko.setText("");
                }

            }
        });
    }//GEN-LAST:event_NamaProdukSHPSSItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DokumenFilateli2;
    private javax.swing.JTextField JumlahTerimaDokumenFilateli;
    private javax.swing.JTextField JumlahTerimaKemasan;
    private javax.swing.JTextField JumlahTerimaMSSS;
    private javax.swing.JTextField JumlahTerimaMerchandise;
    private javax.swing.JTextField JumlahTerimaPrangko;
    private javax.swing.JTextField JumlahTerimaPrisma;
    private javax.swing.JTextField JumlahTerimaSHPSS;
    private javax.swing.JPanel Kemasan2;
    private javax.swing.JTextArea KeteranganDokumenFilateli;
    private javax.swing.JTextArea KeteranganKemasan;
    private javax.swing.JTextArea KeteranganMSSS;
    private javax.swing.JTextArea KeteranganMerchandise;
    private javax.swing.JTextArea KeteranganPrangko;
    private javax.swing.JTextArea KeteranganPrisma;
    private javax.swing.JTextArea KeteranganSHPSS;
    private javax.swing.JTextField KodePosDokumenFilateli;
    private javax.swing.JTextField KodePosKemasan;
    private javax.swing.JTextField KodePosMSSS;
    private javax.swing.JTextField KodePosMerchandise;
    private javax.swing.JTextField KodePosPrangko;
    private javax.swing.JTextField KodePosPrisma;
    private javax.swing.JTextField KodePosSHPSS;
    private javax.swing.JTextField KodeProdukDokumenFilateli;
    private javax.swing.JTextField KodeProdukKemasan;
    private javax.swing.JTextField KodeProdukMSSS;
    private javax.swing.JTextField KodeProdukMerchandise;
    private javax.swing.JTextField KodeProdukPrangko;
    private javax.swing.JTextField KodeProdukPrisma;
    private javax.swing.JTextField KodeProdukSHPSS;
    private javax.swing.JTextField KodeRegionalDokumenFilateli;
    private javax.swing.JTextField KodeRegionalKemasan;
    private javax.swing.JTextField KodeRegionalMSSS;
    private javax.swing.JTextField KodeRegionalMerchandise;
    private javax.swing.JTextField KodeRegionalPrangko;
    private javax.swing.JTextField KodeRegionalPrisma;
    private javax.swing.JTextField KodeRegionalSHPSS;
    private javax.swing.JComboBox<String> KotaPengirimDokumenFilateli;
    private javax.swing.JComboBox<String> KotaPengirimKemasan;
    private javax.swing.JComboBox<String> KotaPengirimMSSS;
    private javax.swing.JComboBox<String> KotaPengirimMerchandise;
    private javax.swing.JComboBox<String> KotaPengirimPrangko;
    private javax.swing.JComboBox<String> KotaPengirimPrisma;
    private javax.swing.JComboBox<String> KotaPengirimSHPSS;
    private javax.swing.JPanel MS_SS2;
    private javax.swing.JPanel Merchandise2;
    private javax.swing.JComboBox<String> NamaProdukDokumenFilateli;
    private javax.swing.JComboBox<String> NamaProdukKemasan;
    private javax.swing.JComboBox<String> NamaProdukMSSS;
    private javax.swing.JComboBox<String> NamaProdukMerchandise;
    private javax.swing.JComboBox<String> NamaProdukPrangko;
    private javax.swing.JComboBox<String> NamaProdukPrisma;
    private javax.swing.JComboBox<String> NamaProdukSHPSS;
    private javax.swing.JTextField NominalDokumenFilateli;
    private javax.swing.JTextField NominalKemasan;
    private javax.swing.JTextField NominalMSSS;
    private javax.swing.JTextField NominalMerchandise;
    private javax.swing.JTextField NominalPrangko;
    private javax.swing.JTextField NominalPrisma;
    private javax.swing.JTextField NominalSHPSS;
    private javax.swing.JTextField NomorDusDokumenFilateli;
    private javax.swing.JTextField NomorDusKemasan;
    private javax.swing.JTextField NomorDusMSSS;
    private javax.swing.JTextField NomorDusMerchandise;
    private javax.swing.JTextField NomorDusPrangko;
    private javax.swing.JTextField NomorDusPrisma;
    private javax.swing.JTextField NomorDusSHPSS;
    private javax.swing.JPanel Prangko2;
    private javax.swing.JPanel Prisma2;
    private javax.swing.JPanel SHP_SHPSS2;
    private javax.swing.JButton SimpanPrangko;
    private javax.swing.JTextField StokGudangDokumenFilateli;
    private javax.swing.JTextField StokGudangKemasan;
    private javax.swing.JTextField StokGudangMSSS;
    private javax.swing.JTextField StokGudangMerchandise;
    private javax.swing.JTextField StokGudangPrangko;
    private javax.swing.JTextField StokGudangPrisma;
    private javax.swing.JTextField StokGudangSHPSS;
    private javax.swing.JTabbedPane TabPengembalian;
    private javax.swing.JTable TablePengembalianKemasan;
    private javax.swing.JTable TablePengembalianMSSS;
    private javax.swing.JTable TablePengembalianPrangko;
    private javax.swing.JTable TablePengembalianSHPSS;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanDokumenFilateli;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanKemasan;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanMSSS;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanMerchandise;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanPrangko;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanPrisma;
    private com.toedter.calendar.JDateChooser TanggalPenerimaanSHPSS;
    private javax.swing.JButton buttonCariPrangko15;
    private javax.swing.JButton buttonCariPrangko16;
    private javax.swing.JButton buttonCariPrangko17;
    private javax.swing.JButton buttonCariPrangko18;
    private javax.swing.JButton buttonCariPrangko19;
    private javax.swing.JButton buttonCariPrangko20;
    private javax.swing.JButton buttonCariPrangko8;
    private javax.swing.JComboBox<String> comboCariPrangko15;
    private javax.swing.JComboBox<String> comboCariPrangko16;
    private javax.swing.JComboBox<String> comboCariPrangko17;
    private javax.swing.JComboBox<String> comboCariPrangko18;
    private javax.swing.JComboBox<String> comboCariPrangko19;
    private javax.swing.JComboBox<String> comboCariPrangko20;
    private javax.swing.JComboBox<String> comboCariPrangko8;
    private javax.swing.JTextField fieldCariPrangko15;
    private javax.swing.JTextField fieldCariPrangko16;
    private javax.swing.JTextField fieldCariPrangko17;
    private javax.swing.JTextField fieldCariPrangko18;
    private javax.swing.JTextField fieldCariPrangko19;
    private javax.swing.JTextField fieldCariPrangko20;
    private javax.swing.JTextField fieldCariPrangko8;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
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
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JToggleButton resetPrangko;
    private javax.swing.JToggleButton resetPrangko1;
    private javax.swing.JToggleButton resetPrangko2;
    private javax.swing.JToggleButton resetPrangko3;
    private javax.swing.JToggleButton resetPrangko4;
    private javax.swing.JToggleButton resetPrangko5;
    private javax.swing.JToggleButton resetPrangko6;
    private javax.swing.JTable tablePrangko18;
    private javax.swing.JTable tablePrangko19;
    private javax.swing.JTable tablePrangko20;
    // End of variables declaration//GEN-END:variables
}
