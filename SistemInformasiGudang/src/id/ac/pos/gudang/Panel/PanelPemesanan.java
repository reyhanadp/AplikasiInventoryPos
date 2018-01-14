/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.Dialog.DialogTambahPemesanan;
import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.daoimpl.PemesananDAOImpl;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.tablemodel.PemesananTM;
import java.util.ArrayList;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author reyha
 */
public class PanelPemesanan extends javax.swing.JPanel {

    /**
     * Creates new form PanelPemesanan
     */
    
    private Pemesanan pemesanan;
    private PemesananDAO dao;
    ArrayList<Pemesanan> arrayPemesanan;
    TableRowSorter sorter;
    
    public PanelPemesanan() {
        initComponents();
        getDataPemesanan();
    }

    public String cariData(String tabCari) {
        Object pilihanCari = "";
        if (tabCari.compareTo("PR") == 0) {
            pilihanCari = comboCariPemesananPrangko.getSelectedItem();
        } else if (tabCari.compareTo("KM") == 0) {
            pilihanCari = comboCariPemesananKemasan.getSelectedItem();
        } else if (tabCari.compareTo("SHP") == 0) {
            pilihanCari = comboCariPemesananSHP_SHPSS.getSelectedItem();
        } else if (tabCari.compareTo("SS") == 0) {
            pilihanCari = comboCariPemesananMS_SS.getSelectedItem();
        } else if (tabCari.compareTo("MC") == 0) {
            pilihanCari = comboCariPemesananMerchandise.getSelectedItem();
        } else if (tabCari.compareTo("PS") == 0) {
            pilihanCari = comboCariPemesananPrisma.getSelectedItem();
        } else if (tabCari.compareTo("DF") == 0) {
            pilihanCari = comboCariPemesananDokumenFilateli.getSelectedItem();
        }
              
        String jenisCari = null;

        if (pilihanCari == "Kode Produk") {
            jenisCari = "pm.id_produk";
        } else if (pilihanCari == "Nama Produk") {
            jenisCari = "nama_produk";
        } else if (pilihanCari == "Nama Mitra") {
            jenisCari = "nama_mitra";
        } else if (pilihanCari == "Nomor Pemesanan") {
            jenisCari = "no_pemesanan";
        } else if (pilihanCari == "Nominal") {
            jenisCari = "nominal";
        } else if (pilihanCari == "Tahun") {
            jenisCari = "tahun";
        } else if (pilihanCari == "Status") {
            jenisCari = "status";
        }

        return jenisCari;

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
    
    private void getDataPemesanan(){
        dao = new PemesananDAOImpl();
        ArrayList<Pemesanan> arrayPemesananPrangko = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananMSSS = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananSHPSS = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananKemasan = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananMerchandise = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananPrisma = new ArrayList<>();
        ArrayList<Pemesanan> arrayPemesananDokumenFilateli = new ArrayList<>();
       
        arrayPemesanan = dao.getPemesanan();
        for (int i = 0; i < arrayPemesanan.size(); i++){     
            String kode_produk = arrayPemesanan.get(i).getKodeProduk();
            String jenis_produk = kode_produk.substring(0,2);
            
            if(jenis_produk.compareTo("PR")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananPrangko.add(pm);
        } else if (jenis_produk.compareTo("MS")==0 || jenis_produk.compareTo("SS")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananMSSS.add(pm);
        } else if (jenis_produk.compareTo("PS")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananPrisma.add(pm);
        }else if (jenis_produk.compareTo("SH")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananSHPSS.add(pm);
        }else if (jenis_produk.compareTo("KM")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananKemasan.add(pm);
        }else if (jenis_produk.compareTo("MC")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananMerchandise.add(pm);
        }else if (jenis_produk.compareTo("DF")==0){
            Pemesanan pm = new Pemesanan();
            pm.setIdPemesanan(arrayPemesanan.get(i).getIdPemesanan());
            pm.setNoPemesanan(arrayPemesanan.get(i).getNoPemesanan());
            pm.setKodeProduk(arrayPemesanan.get(i).getKodeProduk());
            pm.setNamaProduk(arrayPemesanan.get(i).getNamaProduk());
            pm.setNominal(arrayPemesanan.get(i).getNominal());
            pm.setTahun(arrayPemesanan.get(i).getTahun());
            pm.setJumlahPemesanan(arrayPemesanan.get(i).getJumlahPemesanan());
            pm.setTglPemesanan(arrayPemesanan.get(i).getTglPemesanan());
            pm.setNamaMitra(arrayPemesanan.get(i).getNamaMitra());
            pm.setStatus(arrayPemesanan.get(i).getStatus());
            
            arrayPemesananDokumenFilateli.add(pm);
        }
            
        }
        
        PemesananTM pemesananTM = new PemesananTM();
        pemesananTM.setDataPemesanan(arrayPemesananPrangko);
        sorter = new TableRowSorter(pemesananTM);
        tablePemesananPrangko.setRowSorter(sorter);
        tablePemesananPrangko.setModel(pemesananTM);
        
        PemesananTM pemesananTM1 = new PemesananTM();
        pemesananTM1.setDataPemesanan(arrayPemesananMSSS);
        sorter = new TableRowSorter(pemesananTM1);
        tablePemesananMS_SS.setRowSorter(sorter);
        tablePemesananMS_SS.setModel(pemesananTM1);
        
        PemesananTM pemesananTM2 = new PemesananTM();
        pemesananTM2.setDataPemesanan(arrayPemesananSHPSS);
        sorter = new TableRowSorter(pemesananTM2);
        tablePemesananSHP_SHPSS.setRowSorter(sorter);
        tablePemesananSHP_SHPSS.setModel(pemesananTM2);
        
        PemesananTM pemesananTM3 = new PemesananTM();
        pemesananTM3.setDataPemesanan(arrayPemesananKemasan);
        sorter = new TableRowSorter(pemesananTM3);
        tablePemesananKemasan.setRowSorter(sorter);
        tablePemesananKemasan.setModel(pemesananTM3);
        
        PemesananTM pemesananTM4 = new PemesananTM();
        pemesananTM4.setDataPemesanan(arrayPemesananMerchandise);
        sorter = new TableRowSorter(pemesananTM4);
        tablePemesananMerchandise.setRowSorter(sorter);
        tablePemesananMerchandise.setModel(pemesananTM4);
        
        PemesananTM pemesananTM5 = new PemesananTM();
        pemesananTM5.setDataPemesanan(arrayPemesananPrisma);
        sorter = new TableRowSorter(pemesananTM5);
        tablePemesananPrisma.setRowSorter(sorter);
        tablePemesananPrisma.setModel(pemesananTM5);
        
        PemesananTM pemesananTM6 = new PemesananTM();
        pemesananTM6.setDataPemesanan(arrayPemesananDokumenFilateli);
        sorter = new TableRowSorter(pemesananTM6);
        tablePemesananDokumenFilateli.setRowSorter(sorter);
        tablePemesananDokumenFilateli.setModel(pemesananTM6);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanneProduk = new javax.swing.JTabbedPane();
        Prangko4 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        tablePemesananPrangko = new javax.swing.JTable();
        buttonCariPemesananPrangko = new javax.swing.JButton();
        fieldCariPemesananPrangko = new javax.swing.JTextField();
        comboCariPemesananPrangko = new javax.swing.JComboBox<>();
        ButtonTambahPemesananPrangko = new javax.swing.JButton();
        MS_SS4 = new javax.swing.JPanel();
        jPanel54 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        tablePemesananMS_SS = new javax.swing.JTable();
        ButtonTambahPemesananMSSS = new javax.swing.JButton();
        comboCariPemesananMS_SS = new javax.swing.JComboBox<>();
        fieldCariPemesananMS_SS = new javax.swing.JTextField();
        buttonCariPemesananMSSS = new javax.swing.JButton();
        SHP_SHPSS4 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jScrollPane23 = new javax.swing.JScrollPane();
        tablePemesananSHP_SHPSS = new javax.swing.JTable();
        ButtonTambahPemesananSHPSS = new javax.swing.JButton();
        comboCariPemesananSHP_SHPSS = new javax.swing.JComboBox<>();
        fieldCariPemesananSHP_SHPSS = new javax.swing.JTextField();
        buttonCariPemesananSHP_SHPSS = new javax.swing.JButton();
        Kemasan4 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jScrollPane19 = new javax.swing.JScrollPane();
        tablePemesananKemasan = new javax.swing.JTable();
        ButtonTambahPemesananKemasan = new javax.swing.JButton();
        comboCariPemesananKemasan = new javax.swing.JComboBox<>();
        fieldCariPemesananKemasan = new javax.swing.JTextField();
        buttonCariPemesananKemasan = new javax.swing.JButton();
        Merchandise4 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jScrollPane20 = new javax.swing.JScrollPane();
        tablePemesananMerchandise = new javax.swing.JTable();
        ButtonTambahPemesananMerchandise = new javax.swing.JButton();
        comboCariPemesananMerchandise = new javax.swing.JComboBox<>();
        fieldCariPemesananMerchandise = new javax.swing.JTextField();
        buttonCariPemesananMerchandise = new javax.swing.JButton();
        Prisma4 = new javax.swing.JPanel();
        jPanel57 = new javax.swing.JPanel();
        jScrollPane21 = new javax.swing.JScrollPane();
        tablePemesananPrisma = new javax.swing.JTable();
        ButtonTambahPemesananPrisma = new javax.swing.JButton();
        comboCariPemesananPrisma = new javax.swing.JComboBox<>();
        fieldCariPemesananPrisma = new javax.swing.JTextField();
        buttonCariPemesananPrisma = new javax.swing.JButton();
        DokumenFilateli4 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tablePemesananDokumenFilateli = new javax.swing.JTable();
        ButtonTambahPemesananDokumenFilateli = new javax.swing.JButton();
        comboCariPemesananDokumenFilateli = new javax.swing.JComboBox<>();
        fieldCariPemesananDokumenFilateli = new javax.swing.JTextField();
        buttonCariPemesananDokumenFilateli = new javax.swing.JButton();

        tabPanneProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanneProdukMouseClicked(evt);
            }
        });

        Prangko4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Prangko4MouseClicked(evt);
            }
        });

        jPanel52.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananPrangko.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(tablePemesananPrangko);

        buttonCariPemesananPrangko.setText("Cari");
        buttonCariPemesananPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananPrangkoActionPerformed(evt);
            }
        });

        fieldCariPemesananPrangko.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananPrangkoMouseClicked(evt);
            }
        });

        comboCariPemesananPrangko.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        ButtonTambahPemesananPrangko.setText("Tambah Pemesanan");
        ButtonTambahPemesananPrangko.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananPrangkoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananPrangko)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananPrangko))
            .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonTambahPemesananPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananPrangko)
                        .addComponent(fieldCariPemesananPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananPrangko, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prangko4Layout = new javax.swing.GroupLayout(Prangko4);
        Prangko4.setLayout(Prangko4Layout);
        Prangko4Layout.setHorizontalGroup(
            Prangko4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prangko4Layout.setVerticalGroup(
            Prangko4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("Prangko", Prangko4);

        MS_SS4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MS_SS4MouseClicked(evt);
            }
        });

        jPanel54.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananMS_SS.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(tablePemesananMS_SS);

        ButtonTambahPemesananMSSS.setText("Tambah Pemesanan");
        ButtonTambahPemesananMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananMSSSActionPerformed(evt);
            }
        });

        comboCariPemesananMS_SS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananMS_SS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananMS_SSMouseClicked(evt);
            }
        });

        buttonCariPemesananMSSS.setText("Cari");
        buttonCariPemesananMSSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananMSSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananMSSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananMSSS))
            .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananMSSS)
                        .addComponent(fieldCariPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananMS_SS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananMSSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MS_SS4Layout = new javax.swing.GroupLayout(MS_SS4);
        MS_SS4.setLayout(MS_SS4Layout);
        MS_SS4Layout.setHorizontalGroup(
            MS_SS4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MS_SS4Layout.setVerticalGroup(
            MS_SS4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel54, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("MS & SS", MS_SS4);

        SHP_SHPSS4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SHP_SHPSS4MouseClicked(evt);
            }
        });

        jPanel59.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananSHP_SHPSS.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane23.setViewportView(tablePemesananSHP_SHPSS);

        ButtonTambahPemesananSHPSS.setText("Tambah Pemesanan");
        ButtonTambahPemesananSHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananSHPSSActionPerformed(evt);
            }
        });

        comboCariPemesananSHP_SHPSS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananSHP_SHPSS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananSHP_SHPSSMouseClicked(evt);
            }
        });

        buttonCariPemesananSHP_SHPSS.setText("Cari");
        buttonCariPemesananSHP_SHPSS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananSHP_SHPSSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel59Layout = new javax.swing.GroupLayout(jPanel59);
        jPanel59.setLayout(jPanel59Layout);
        jPanel59Layout.setHorizontalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel59Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananSHPSS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananSHP_SHPSS))
            .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel59Layout.setVerticalGroup(
            jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel59Layout.createSequentialGroup()
                .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel59Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananSHP_SHPSS)
                        .addComponent(fieldCariPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananSHP_SHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananSHPSS, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane23, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout SHP_SHPSS4Layout = new javax.swing.GroupLayout(SHP_SHPSS4);
        SHP_SHPSS4.setLayout(SHP_SHPSS4Layout);
        SHP_SHPSS4Layout.setHorizontalGroup(
            SHP_SHPSS4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel59, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        SHP_SHPSS4Layout.setVerticalGroup(
            SHP_SHPSS4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel59, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("SHP & SHPSS", SHP_SHPSS4);

        Kemasan4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Kemasan4MouseClicked(evt);
            }
        });

        jPanel55.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananKemasan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane19.setViewportView(tablePemesananKemasan);

        ButtonTambahPemesananKemasan.setText("Tambah Pemesanan");
        ButtonTambahPemesananKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananKemasanActionPerformed(evt);
            }
        });

        comboCariPemesananKemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananKemasan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananKemasanMouseClicked(evt);
            }
        });

        buttonCariPemesananKemasan.setText("Cari");
        buttonCariPemesananKemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananKemasanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananKemasan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananKemasan))
            .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananKemasan)
                        .addComponent(fieldCariPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananKemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane19, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Kemasan4Layout = new javax.swing.GroupLayout(Kemasan4);
        Kemasan4.setLayout(Kemasan4Layout);
        Kemasan4Layout.setHorizontalGroup(
            Kemasan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Kemasan4Layout.setVerticalGroup(
            Kemasan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("Kemasan", Kemasan4);

        jPanel56.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananMerchandise.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane20.setViewportView(tablePemesananMerchandise);

        ButtonTambahPemesananMerchandise.setText("Tambah Pemesanan");
        ButtonTambahPemesananMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananMerchandiseActionPerformed(evt);
            }
        });

        comboCariPemesananMerchandise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananMerchandise.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananMerchandiseMouseClicked(evt);
            }
        });

        buttonCariPemesananMerchandise.setText("Cari");
        buttonCariPemesananMerchandise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananMerchandiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel56Layout = new javax.swing.GroupLayout(jPanel56);
        jPanel56.setLayout(jPanel56Layout);
        jPanel56Layout.setHorizontalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel56Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananMerchandise)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananMerchandise))
            .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel56Layout.setVerticalGroup(
            jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel56Layout.createSequentialGroup()
                .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel56Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananMerchandise)
                        .addComponent(fieldCariPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananMerchandise, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane20, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Merchandise4Layout = new javax.swing.GroupLayout(Merchandise4);
        Merchandise4.setLayout(Merchandise4Layout);
        Merchandise4Layout.setHorizontalGroup(
            Merchandise4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel56, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Merchandise4Layout.setVerticalGroup(
            Merchandise4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel56, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("Merchandise", Merchandise4);

        jPanel57.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananPrisma.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane21.setViewportView(tablePemesananPrisma);

        ButtonTambahPemesananPrisma.setText("Tambah Pemesanan");
        ButtonTambahPemesananPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananPrismaActionPerformed(evt);
            }
        });

        comboCariPemesananPrisma.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananPrisma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananPrismaMouseClicked(evt);
            }
        });

        buttonCariPemesananPrisma.setText("Cari");
        buttonCariPemesananPrisma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananPrismaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel57Layout = new javax.swing.GroupLayout(jPanel57);
        jPanel57.setLayout(jPanel57Layout);
        jPanel57Layout.setHorizontalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel57Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananPrisma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananPrisma))
            .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel57Layout.setVerticalGroup(
            jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel57Layout.createSequentialGroup()
                .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel57Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananPrisma)
                        .addComponent(fieldCariPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananPrisma, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane21, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Prisma4Layout = new javax.swing.GroupLayout(Prisma4);
        Prisma4.setLayout(Prisma4Layout);
        Prisma4Layout.setHorizontalGroup(
            Prisma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Prisma4Layout.setVerticalGroup(
            Prisma4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("Prisma", Prisma4);

        jPanel58.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Data Pemesanan"));

        tablePemesananDokumenFilateli.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane22.setViewportView(tablePemesananDokumenFilateli);

        ButtonTambahPemesananDokumenFilateli.setText("Tambah Pemesanan");
        ButtonTambahPemesananDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTambahPemesananDokumenFilateliActionPerformed(evt);
            }
        });

        comboCariPemesananDokumenFilateli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nama Produk", "Nama Mitra", "Nomor Pemesanan", "Kode Produk", "Nominal", "Tahun", "Status" }));

        fieldCariPemesananDokumenFilateli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldCariPemesananDokumenFilateliMouseClicked(evt);
            }
        });

        buttonCariPemesananDokumenFilateli.setText("Cari");
        buttonCariPemesananDokumenFilateli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCariPemesananDokumenFilateliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel58Layout = new javax.swing.GroupLayout(jPanel58);
        jPanel58.setLayout(jPanel58Layout);
        jPanel58Layout.setHorizontalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel58Layout.createSequentialGroup()
                .addComponent(ButtonTambahPemesananDokumenFilateli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comboCariPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCariPemesananDokumenFilateli))
            .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 975, Short.MAX_VALUE)
        );
        jPanel58Layout.setVerticalGroup(
            jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel58Layout.createSequentialGroup()
                .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel58Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonCariPemesananDokumenFilateli)
                        .addComponent(fieldCariPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCariPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ButtonTambahPemesananDokumenFilateli, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane22, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DokumenFilateli4Layout = new javax.swing.GroupLayout(DokumenFilateli4);
        DokumenFilateli4.setLayout(DokumenFilateli4Layout);
        DokumenFilateli4Layout.setHorizontalGroup(
            DokumenFilateli4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel58, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        DokumenFilateli4Layout.setVerticalGroup(
            DokumenFilateli4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel58, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabPanneProduk.addTab("Dokumen Filateli", DokumenFilateli4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanneProduk)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanneProduk)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Prangko4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Prangko4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Prangko4MouseClicked

    private void MS_SS4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MS_SS4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_MS_SS4MouseClicked

    private void Kemasan4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Kemasan4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_Kemasan4MouseClicked

    private void SHP_SHPSS4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SHP_SHPSS4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SHP_SHPSS4MouseClicked

    private void tabPanneProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanneProdukMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPanneProdukMouseClicked

    private void buttonCariPemesananPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananPrangkoActionPerformed
        // TODO add your handling code here:
        String keyword = fieldCariPemesananPrangko.getText();
        String status = "prangko";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
                
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananPrangko.setRowSorter(sorter);

        tablePemesananPrangko.setModel(pemesananTableModel);
        
    }//GEN-LAST:event_buttonCariPemesananPrangkoActionPerformed

    private void fieldCariPemesananPrangkoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananPrangkoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananPrangkoMouseClicked

    private void ButtonTambahPemesananPrangkoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananPrangkoActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = true;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
        getDataPemesanan();
    }//GEN-LAST:event_ButtonTambahPemesananPrangkoActionPerformed

    private void ButtonTambahPemesananMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananMSSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananMSSSActionPerformed

    private void ButtonTambahPemesananKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananKemasanActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananKemasanActionPerformed

    private void ButtonTambahPemesananMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananMerchandiseActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananMerchandiseActionPerformed

    private void ButtonTambahPemesananPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananPrismaActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananPrismaActionPerformed

    private void ButtonTambahPemesananDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananDokumenFilateliActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananDokumenFilateliActionPerformed

    private void ButtonTambahPemesananSHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTambahPemesananSHPSSActionPerformed
        // TODO add your handling code here:
        FormHome formHome = new FormHome();
        boolean rootPaneCheckingEnabled = false;
        new DialogTambahPemesanan(formHome, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_ButtonTambahPemesananSHPSSActionPerformed

    private void fieldCariPemesananMS_SSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananMS_SSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananMS_SSMouseClicked

    private void buttonCariPemesananMSSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananMSSSActionPerformed
        String keyword = fieldCariPemesananMS_SS.getText();
        String status = "ss";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
                
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananMS_SS.setRowSorter(sorter);

        tablePemesananMS_SS.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananMSSSActionPerformed

    private void fieldCariPemesananKemasanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananKemasanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananKemasanMouseClicked

    private void buttonCariPemesananKemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananKemasanActionPerformed
        String keyword = fieldCariPemesananKemasan.getText();
        String status = "kemasan";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
                
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananKemasan.setRowSorter(sorter);

        tablePemesananKemasan.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananKemasanActionPerformed

    private void fieldCariPemesananMerchandiseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananMerchandiseMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananMerchandiseMouseClicked

    private void buttonCariPemesananMerchandiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananMerchandiseActionPerformed
        String keyword = fieldCariPemesananMerchandise.getText();
        String status = "merchandise";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
        
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananMerchandise.setRowSorter(sorter);

        tablePemesananMerchandise.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananMerchandiseActionPerformed

    private void fieldCariPemesananPrismaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananPrismaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananPrismaMouseClicked

    private void buttonCariPemesananPrismaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananPrismaActionPerformed
        String keyword = fieldCariPemesananPrisma.getText();
        String status = "prisma";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
        
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananPrisma.setRowSorter(sorter);

        tablePemesananPrisma.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananPrismaActionPerformed

    private void fieldCariPemesananDokumenFilateliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananDokumenFilateliMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananDokumenFilateliMouseClicked

    private void buttonCariPemesananDokumenFilateliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananDokumenFilateliActionPerformed
        String keyword = fieldCariPemesananDokumenFilateli.getText();
        String status = "df";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
        
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananDokumenFilateli.setRowSorter(sorter);

        tablePemesananDokumenFilateli.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananDokumenFilateliActionPerformed

    private void fieldCariPemesananSHP_SHPSSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldCariPemesananSHP_SHPSSMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariPemesananSHP_SHPSSMouseClicked

    private void buttonCariPemesananSHP_SHPSSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCariPemesananSHP_SHPSSActionPerformed
        String keyword = fieldCariPemesananSHP_SHPSS.getText();
        String status = "shp";
        String tabCari = cariJenis(status);
        String jenisCari = cariData(tabCari);
        String idJenis = cariJenis(status);

        // lakukan proses pencarian
        dao = new PemesananDAOImpl();
        arrayPemesanan = dao.cariProdukPemesanan(keyword, jenisCari, idJenis);
        
        PemesananTM pemesananTableModel = new PemesananTM();
        pemesananTableModel.setDataPemesanan(arrayPemesanan);
        sorter = new TableRowSorter(pemesananTableModel);
        tablePemesananSHP_SHPSS.setRowSorter(sorter);

        tablePemesananSHP_SHPSS.setModel(pemesananTableModel);
    }//GEN-LAST:event_buttonCariPemesananSHP_SHPSSActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonTambahPemesananDokumenFilateli;
    private javax.swing.JButton ButtonTambahPemesananKemasan;
    private javax.swing.JButton ButtonTambahPemesananMSSS;
    private javax.swing.JButton ButtonTambahPemesananMerchandise;
    private javax.swing.JButton ButtonTambahPemesananPrangko;
    private javax.swing.JButton ButtonTambahPemesananPrisma;
    private javax.swing.JButton ButtonTambahPemesananSHPSS;
    private javax.swing.JPanel DokumenFilateli4;
    private javax.swing.JPanel Kemasan4;
    private javax.swing.JPanel MS_SS4;
    private javax.swing.JPanel Merchandise4;
    private javax.swing.JPanel Prangko4;
    private javax.swing.JPanel Prisma4;
    private javax.swing.JPanel SHP_SHPSS4;
    private javax.swing.JButton buttonCariPemesananDokumenFilateli;
    private javax.swing.JButton buttonCariPemesananKemasan;
    private javax.swing.JButton buttonCariPemesananMSSS;
    private javax.swing.JButton buttonCariPemesananMerchandise;
    private javax.swing.JButton buttonCariPemesananPrangko;
    private javax.swing.JButton buttonCariPemesananPrisma;
    private javax.swing.JButton buttonCariPemesananSHP_SHPSS;
    private javax.swing.JComboBox<String> comboCariPemesananDokumenFilateli;
    private javax.swing.JComboBox<String> comboCariPemesananKemasan;
    private javax.swing.JComboBox<String> comboCariPemesananMS_SS;
    private javax.swing.JComboBox<String> comboCariPemesananMerchandise;
    private javax.swing.JComboBox<String> comboCariPemesananPrangko;
    private javax.swing.JComboBox<String> comboCariPemesananPrisma;
    private javax.swing.JComboBox<String> comboCariPemesananSHP_SHPSS;
    private javax.swing.JTextField fieldCariPemesananDokumenFilateli;
    private javax.swing.JTextField fieldCariPemesananKemasan;
    private javax.swing.JTextField fieldCariPemesananMS_SS;
    private javax.swing.JTextField fieldCariPemesananMerchandise;
    private javax.swing.JTextField fieldCariPemesananPrangko;
    private javax.swing.JTextField fieldCariPemesananPrisma;
    private javax.swing.JTextField fieldCariPemesananSHP_SHPSS;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JTabbedPane tabPanneProduk;
    private javax.swing.JTable tablePemesananDokumenFilateli;
    private javax.swing.JTable tablePemesananKemasan;
    private javax.swing.JTable tablePemesananMS_SS;
    private javax.swing.JTable tablePemesananMerchandise;
    private javax.swing.JTable tablePemesananPrangko;
    private javax.swing.JTable tablePemesananPrisma;
    private javax.swing.JTable tablePemesananSHP_SHPSS;
    // End of variables declaration//GEN-END:variables
}
