/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author muhamad solahudin
 */
public class PemesananDAOImpl implements PemesananDAO{
    
    private Connection conn;
    
      
    public PemesananDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    public boolean tambahPemesanan(Pemesanan pemesanan, String jenisProduk) {
       String INSERT = "INSERT INTO tb_pemesanan (no_pemesanan,id_produk, nama_produk, nominal, "
                + "biaya_cetak, tahun, id_jenis_produk, tgl_pesan,jumlah_pesan,id_suplier"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pemesanan.getNoPemesanan());
            state.setString(2, pemesanan.getKodeProduk());
            state.setString(3, pemesanan.getNamaProduk());
            state.setInt(4,pemesanan.getNominal());
            state.setFloat(5, pemesanan.getBiayaCetak());
            state.setString(6, pemesanan.getTahun());
            state.setString(7, jenisProduk);
            state.setString(8, pemesanan.getTglPemesanan());
            state.setInt(9, pemesanan.getJumlahPemesanan());
            state.setString(10, pemesanan.getIdSuplier());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; 
    }
    
    public String getNoPemesanan() {
        String no_pemesanan = null;
        String SELECT = "SELECT no_pemesanan FROM tb_pemesanan ORDER BY no_pemesanan";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    no_pemesanan = result.getString("no_pemesanan");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return no_pemesanan;
    }
    
    
    public ArrayList<Pemesanan> getDataPemesananPrangko() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='PR'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }

    public ArrayList<Pemesanan> getDataPemesananMS_SS() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='MS' "
                + "|| id_jenis_produk = 'SS'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
    public ArrayList<Pemesanan> getDataPemesananKemasan() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='KM'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
    public ArrayList<Pemesanan> getDataPemesananMerchandise() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='MC'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
    public ArrayList<Pemesanan> getDataPemesananPrisma() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='PS'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
    public ArrayList<Pemesanan> getDataPemesananDokumenFilateli() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='DF'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
    public ArrayList<Pemesanan> getDataPemesananSHP_SHPSS() {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT * FROM tb_pemesanan WHERE id_jenis_produk='SHP' "
                + "|| id_jenis_produk='SHPSS'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setNamaProduk(result.getString("nama_produk"));
                    pemesanan.setNominal(result.getInt("nominal"));
                    pemesanan.setTahun(result.getString(6));
                    

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPemesanan;
    }
    
}
