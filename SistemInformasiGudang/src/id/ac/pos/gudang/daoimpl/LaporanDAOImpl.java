/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.LaporanDAO;
import id.ac.pos.gudang.daoimpl.admin.RegionalDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
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
    ResultSet result;
    private Connection conn;
    PreparedStatement state;
    
    @Override
    public ArrayList<Produk> getProduk(String jenis_produk, String tahun) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM"
                    + " tb_produk where tahun='"+tahun+"' and status='0' and id_jenis_produk"
                    + " in (SELECT id_jenis_produk FROM tb_produk WHERE"
                    + " id_jenis_produk = 'SS' || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM"
                    + " tb_produk where tahun='"+tahun+"' and status='0' and"
                    + " id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP' || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT id_produk,nama_produk,nominal,biaya_cetak FROM"
                    + " tb_produk where tahun='"+tahun+"' and status='0' and"
                    + " id_jenis_produk='"+jenis_produk+"' order by nama_produk asc";
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
                    produk.setBiayaCetak(Float.parseFloat(result.getString(4)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getTahunTerkecil(String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE"
                    + " status='0' and id_jenis_produk in (SELECT"
                    + " id_jenis_produk FROM tb_produk WHERE"
                    + " id_jenis_produk = 'SS' || id_jenis_produk"
                    + " = 'MS') order by tahun ASC";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE"
                    + " status='0' and id_jenis_produk in (SELECT"
                    + " id_jenis_produk FROM tb_produk WHERE"
                    + " id_jenis_produk = 'SHP' || id_jenis_produk"
                    + " = 'SHPSS') order by tahun ASC";
        } else {
            SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE"
                    + " id_jenis_produk='"+jenis_produk+"' order by tahun ASC";
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return arrayProduk;
    }

    @Override
    public Integer getJumlahTerima(String kode_produk, int bulan, Object tahun, int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int jumlah_terima = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan`"
                    + " WHERE id_produk='"+kode_produk+"'"
                    + " and tgl_penerimaan between '"+tahun+"-"+bulan+"-01'"
                    + " and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan`"
                            + " WHERE id_produk='"+kode_produk+"'"
                            + " and tgl_penerimaan between '"+tahun+"-"+bulan+"-01'"
                            + " and '"+tahun+"-"+bulan2+"-31'";
            }else if(pilihan==1){
                SELECT = "SELECT jml_terima FROM `tb_trans_penerimaan`"
                        + " WHERE id_produk='"+kode_produk+"'"
                        + " and tgl_penerimaan between '"+tahun+"-"+bulan+"-01'"
                        + " and '"+tahun+"-"+bulan+"-31'";
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return jumlah_terima;
    }

    @Override
    public Integer getJumlahPengiriman(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int jumlah_pengeluaran = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_pengiriman FROM `tb_trans_pengiriman`"
                    + " WHERE id_produk='"+kode_produk+"'"
                    + " and tgl_pengiriman between '"+tahun+"-"+bulan+"-01'"
                    + " and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_pengiriman FROM `tb_trans_pengiriman`"
                            + " WHERE id_produk='"+kode_produk+"'"
                            + " and tgl_pengiriman between '"+tahun+"-"+bulan+"-01'"
                            + " and '"+tahun+"-"+bulan2+"-31'";
            }else if(pilihan==1){
                SELECT = "SELECT jml_pengiriman FROM `tb_trans_pengiriman`"
                        + " WHERE id_produk='"+kode_produk+"'"
                        + " and tgl_pengiriman between '"+tahun+"-"+bulan+"-01'"
                        + " and '"+tahun+"-"+bulan+"-31'";
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return jumlah_pengeluaran;
    }

    @Override
    public Integer getJumlahPengembalian(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int jumlah_pengembalian = 0;
        String SELECT = "";
        
        if(status == "sekarang"){
            SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian`"
                    + " WHERE id_produk='"+kode_produk+"'"
                    + " and tgl_pengembalian between '"+tahun+"-"+bulan+"-01'"
                    + " and '"+tahun_sekarang+"-"+bulan_sekarang+"-31'";
        }else if(status == "tidak sekarang"){
            if(pilihan == 3){
                    int bulan2 = bulan + 2;
                    SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian`"
                            + " WHERE id_produk='"+kode_produk+"'"
                            + " and tgl_pengembalian between '"+tahun+"-"+bulan+"-01'"
                            + " and '"+tahun+"-"+bulan2+"-31'";
            }else if(pilihan==1){
                SELECT = "SELECT jml_pengembalian FROM `tb_trans_pengembalian`"
                        + " WHERE id_produk='"+kode_produk+"'"
                        + " and tgl_pengembalian between '"+tahun+"-"+bulan+"-01'"
                        + " and '"+tahun+"-"+bulan+"-31'";
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return jumlah_pengembalian;
    }

    @Override
    public Integer getStokProduk(String kode_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return stok;
    }

    @Override
    public Integer getBulanSekarang() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return bulan;
    }

    @Override
    public Integer getTahunSekarang() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return tahun;
    }

    @Override
    public String getLokasiSimpan(String nik) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String lokasi = "";
        String SELECT = "SELECT penyimpanan from tb_user where nik='"+nik+"'";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    lokasi = result.getString(1);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return lokasi;
    }

    @Override
    public boolean setLokasiSimpan(String nik, String lokasi) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(LaporanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String UPDATE = "UPDATE tb_user "
                + "SET penyimpanan = ? WHERE nik = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, lokasi);
            state.setString(2, nik);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return false;
    }
    
}
