/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.LaporanDAO;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Operator
 */
public class LaporanDAOImpl implements LaporanDAO{
    ArrayList<Produk> arrayProduk = null;
    private Connection conn;

    public LaporanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public ArrayList<Produk> getProduk(String jenis_produk, String tahun) {
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM tb_produk where tahun='"+tahun+"' and id_jenis_produk in (SELECT id_jenis_produk FROM tb_produk WHERE id_jenis_produk = 'SS' || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM tb_produk where tahun='"+tahun+"' and id_jenis_produk in (SELECT id_jenis_produk FROM tb_produk WHERE id_jenis_produk = 'SHP' || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM tb_produk where tahun='"+tahun+"' and id_jenis_produk='"+jenis_produk+"' order by nama_produk asc";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setNamaProduk(result.getString(2));
                    produk.setNominal(Integer.parseInt(result.getString(3)));
                    produk.setBiayaCetak(Integer.parseInt(result.getString(4)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getTahunTerkecil(String jenis_produk) {
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE id_jenis_produk='MS' or id_jenis_produk='SS' order by tahun ASC";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE id_jenis_produk='SHP' or id_jenis_produk='SHPSS' order by tahun ASC";
        } else {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE id_jenis_produk='"+jenis_produk+"' order by tahun ASC";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setTahun(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProduk;
    }

    @Override
    public Integer getJumlahTerima(String kode_produk, int bulan, Object tahun, int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        int jumlah_terima = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan` WHERE id_produk='"+kode_produk+"' and tgl_penerimaan between '"+tahun+"-"+bulan+"-01' and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                if(bulan==11){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 1;
                    SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan` WHERE id_produk='"+kode_produk+"' and tgl_penerimaan between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else if(bulan==12){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 2;
                    SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan` WHERE id_produk='"+kode_produk+"' and tgl_penerimaan between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else{
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan` WHERE id_produk='"+kode_produk+"' and tgl_penerimaan between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan2+"-31'";
                }
            }else if(pilihan==1){
                SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan` WHERE id_produk='"+kode_produk+"' and tgl_penerimaan between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan+"-31'";
            }
            
        }
        
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    jumlah_terima = Integer.parseInt(result.getString(1)) + jumlah_terima;
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jumlah_terima;
    }

    @Override
    public Integer getJumlahPengiriman(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        int jumlah_pengeluaran = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_pengeluaran FROM `tb_trans_pengeluaran` WHERE id_produk='"+kode_produk+"' and tgl_pengeluaran between '"+tahun+"-"+bulan+"-01' and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                if(bulan==11){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 1;
                    SELECT = "SELECT jml_pengeluaran FROM `tb_trans_pengeluaran` WHERE id_produk='"+kode_produk+"' and tgl_pengeluaran between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else if(bulan==12){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 2;
                    SELECT = "SELECT jml_pengeluaran FROM `tb_trans_pengeluaran` WHERE id_produk='"+kode_produk+"' and tgl_pengeluaran between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else{
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_pengeluaran FROM `tb_trans_pengeluaran` WHERE id_produk='"+kode_produk+"' and tgl_pengeluaran between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan2+"-31'";
                }
            }else if(pilihan==1){
                SELECT = "SELECT jml_pengeluaran FROM `tb_trans_pengeluaran` WHERE id_produk='"+kode_produk+"' and tgl_pengeluaran between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan+"-31'";
            }
        }
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    jumlah_pengeluaran = Integer.parseInt(result.getString(1)) + jumlah_pengeluaran;
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jumlah_pengeluaran;
    }

    @Override
    public Integer getJumlahPengembalian(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        int jumlah_pengembalian = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian` WHERE id_produk='"+kode_produk+"' and tgl_pengembalian between '"+tahun+"-"+bulan+"-01' and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                if(bulan==11){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 1;
                    SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian` WHERE id_produk='"+kode_produk+"' and tgl_pengembalian between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else if(bulan==12){
                    int tahun_int = Integer.parseInt((String) tahun);
                    tahun_int = tahun_int + 1;
                    int bulan2 = 2;
                    SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian` WHERE id_produk='"+kode_produk+"' and tgl_pengembalian between '"+tahun+"-"+bulan+"-01' and '"+tahun_int+"-"+bulan2+"-31'";
                }else{
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian` WHERE id_produk='"+kode_produk+"' and tgl_pengembalian between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan2+"-31'";
                }
            }else if(pilihan==1){
                SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian` WHERE id_produk='"+kode_produk+"' and tgl_pengembalian between '"+tahun+"-"+bulan+"-01' and '"+tahun+"-"+bulan+"-31'";
            }
        }
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    jumlah_pengembalian = Integer.parseInt(result.getString("jml_pengembalian"))+jumlah_pengembalian;
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jumlah_pengembalian;
    }

    @Override
    public Integer getStokProduk(String kode_produk) {
        int stok = 0;
        String SELECT = "SELECT stok FROM `tb_produk` WHERE id_produk='"+kode_produk+"'";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    stok = Integer.parseInt(result.getString(1));
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return stok;
    }

    @Override
    public Integer getBulanSekarang() {
        int bulan = 0;
        String SELECT = "SELECT MONTH(CURDATE())";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    bulan = Integer.parseInt(result.getString(1));
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return bulan;
    }

    @Override
    public Integer getTahunSekarang() {
        int tahun = 0;
        String SELECT = "SELECT YEAR(CURDATE())";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    tahun = Integer.parseInt(result.getString(1));
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tahun;
    }
    
}
