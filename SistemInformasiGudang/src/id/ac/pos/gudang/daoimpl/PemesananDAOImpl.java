/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Mitra;
import id.ac.pos.gudang.daoimpl.admin.MitraDAOImpl;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muhamad solahudin
 */
public class PemesananDAOImpl implements PemesananDAO{
    
    ResultSet result;
    private Connection conn;
    PreparedStatement state;
    
     
    
    @Override
    public String getIdPemesanan() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id_pemesanan = null;
        String SELECT = "select * from tb_trans_pemesanan";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_pemesanan = result.getString("id_pemesanan");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return id_pemesanan;
    }
    
    @Override
    public ArrayList<Pemesanan> cariProdukPemesanan(String keyword, String jenisCari, String idJenis) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT id_pemesanan,no_pemesanan,pr.id_produk,nama_produk,nominal,tahun,jumlah_pesan,tgl_pesan,nama_mitra,pm.status"
                    + " FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_mitra sp ON pm.id_mitra=sp.id_mitra "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') && pr.status=0";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT id_pemesanan,no_pemesanan,pr.id_produk,nama_produk,nominal,tahun,jumlah_pesan,tgl_pesan,nama_mitra,pm.status"
                    + " FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_mitra sp ON pm.id_mitra=sp.id_mitra "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') && pr.status=0";
        } else {
            SELECT = "SELECT id_pemesanan,no_pemesanan,pr.id_produk,nama_produk,nominal,tahun,jumlah_pesan,tgl_pesan,nama_mitra,pm.status"
                    + " FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_mitra sp ON pm.id_mitra=sp.id_mitra "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && id_jenis_produk = '" + idJenis + "' && pr.status=0";
        }
         state = null;

        try {
            state = conn.prepareStatement(SELECT);
             result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {

                    // mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setIdPemesanan(result.getString(1));
                    pemesanan.setNoPemesanan(result.getString(2));
                    pemesanan.setKodeProduk(result.getString(3));
                    pemesanan.setNamaProduk(result.getString(4));
                    pemesanan.setNominal(Integer.valueOf(result.getString(5)));
                    pemesanan.setTahun(result.getString(6));
                    pemesanan.setJumlahPemesanan(result.getString(7));
                    pemesanan.setTglPemesanan(result.getDate(8));
                    pemesanan.setNamaMitra(result.getString(9));
                    pemesanan.setStatus(result.getString(10));

                    // menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return arrayPemesanan;
    }
    
    
    @Override
    public String getNoPemesanan() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String no_pemesanan = null;
        String SELECT = "SELECT no_pemesanan FROM tb_trans_pemesanan ORDER BY no_pemesanan";
         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
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

        return no_pemesanan;
    }
     
    @Override
    public ArrayList<Produk> getProduk(Object pilihan, String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProdukPrangko = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE nama_produk='" + pilihan + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE nama_produk='" + pilihan + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT * FROM tb_produk where nama_produk='" + pilihan + "' and id_jenis_produk='" + jenis_produk + "'";
        }
         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayProdukPrangko = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    int nominal = Integer.parseInt(result.getString(3));
                    produk.setNominal(nominal);
                    int stok = Integer.parseInt(result.getString(5));
                    produk.setStok(stok);

                    //menambahkan data ke array
                    arrayProdukPrangko.add(produk);
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

        return arrayProdukPrangko;
    }
    
    @Override
    public ArrayList<Mitra> getIdMitra(Object pilihan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT id_mitra FROM tb_mitra Where nama_mitra = '"+pilihan+"'";
         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Mitra mitra = new Mitra();
                    mitra.setId_mitra(result.getString(1));

                    //menambahkan data ke array
                    arrayMitra.add(mitra);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return arrayMitra;
    }
    
    @Override
    public ArrayList<Mitra> getMitra() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT * FROM tb_mitra";
         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Mitra mitra = new Mitra();
                    mitra.setNama_mitra(result.getString(2));

                    //menambahkan data ke array
                    arrayMitra.add(mitra);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return arrayMitra;
    }
    
    @Override
    public boolean tambahPemesanan(Pemesanan pemesanan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "INSERT INTO tb_trans_pemesanan (id_pemesanan,no_pemesanan,id_produk,"
                + "jumlah_pesan,tgl_pesan,id_mitra,status"
                + ") VALUES (?, ?, ?, ?, ?, ?, 'belum selesai')";
         state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pemesanan.getIdPemesanan());
            state.setString(2, pemesanan.getNoPemesanan());
            state.setString(3, pemesanan.getKodeProduk());
            state.setString(4, pemesanan.getJumlahPemesanan());
            state.setDate(5, new java.sql.Date(pemesanan.getTglPemesanan().getTime()));
            state.setString(6, pemesanan.getIdMitra());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    
    @Override
    public ArrayList<Pemesanan> getPemesanan() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
            SELECT = "SELECT id_pemesanan,no_pemesanan,pr.id_produk,nama_produk,nominal,tahun,jumlah_pesan,tgl_pesan,nama_mitra,pm.status "
                    + "FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pr.id_produk=pm.id_produk "
                    + "JOIN tb_mitra sp ON pm.id_mitra=sp.id_mitra "
                    + "WHERE pr.status=0";
         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setIdPemesanan(result.getString(1));
                    pemesanan.setNoPemesanan(result.getString(2));
                    pemesanan.setKodeProduk(result.getString(3));
                    pemesanan.setNamaProduk(result.getString(4));
                    pemesanan.setNominal(Integer.valueOf(result.getString(5)));
                    pemesanan.setTahun(result.getString(6));
                    pemesanan.setJumlahPemesanan(result.getString(7));
                    pemesanan.setTglPemesanan(result.getDate(8));
                    pemesanan.setNamaMitra(result.getString(9));
                    pemesanan.setStatus(result.getString(10));
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return arrayPemesanan;
    }
    
    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='MS' OR id_jenis_produk='SS' AND status=0 ORDER BY nama_produk ASC";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='SHP' OR id_jenis_produk='SHPSS' AND status=0 ORDER BY nama_produk ASC";
        } else {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='" + jenis_produk + "' AND status=0 ORDER BY nama_produk ASC";
        }

         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNamaProduk(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
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

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND status=0 ";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND status=0 ";
        } else {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk='" + jenis_produk + "' AND status=0 ";
        }

         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setStok(Integer.parseInt(result.getString(2)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
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

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND status=0 ORDER BY tahun";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND status=0 ORDER BY tahun";
        } else {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' "
                    + "AND id_jenis_produk='" + jenis_produk + "' AND status=0 ORDER BY tahun";
        }

         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
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

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND status=0 ORDER BY nominal";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND status=0 ORDER BY nominal";
        } else {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' "
                    + "AND tahun='" + tahun + "' AND id_jenis_produk='" + jenis_produk + "' AND status=0 "
                    + "ORDER BY nominal";
        }

         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNominal(Integer.parseInt(result.getString(1)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
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

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getNama(String kode_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT nama_produk,nominal,tahun FROM `tb_produk` where id_produk='"+kode_produk+"'";


         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNamaProduk(result.getString(1));
                    produk.setNominal(Integer.parseInt(result.getString(2)));
                    produk.setTahun(result.getString(3));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
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

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Mitra> getNamaMitra(String id_mitra) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT nama_mitra FROM `tb_mitra` where id_mitra='"+id_mitra+"'";


         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Mitra mitra = new Mitra();
                    mitra.setNama_mitra(result.getString(1));

                    //menambahkan data ke array
                    arrayMitra.add(mitra);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return arrayMitra;
    }

    /**
     *
     * @param id_pemesanan
     * @return
     */
    @Override
    public Vector getViewDetailPemesanan(String id_pemesanan) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vector vectorViewDetailPemesanan = new Vector();
        String SELECT = "SELECT * FROM `tb_trans_pemesanan` "
                + "JOIN tb_produk ON tb_trans_pemesanan.id_produk=tb_produk.id_produk "
                + "JOIN tb_mitra ON tb_trans_pemesanan.id_mitra=tb_mitra.id_mitra "
                + "WHERE tb_trans_pemesanan.id_pemesanan='"+id_pemesanan+"'";


         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    vectorViewDetailPemesanan.add(result.getString(2));
                    vectorViewDetailPemesanan.add(result.getDate(5));
                    vectorViewDetailPemesanan.add(result.getString(4));
                    vectorViewDetailPemesanan.add(result.getString(7));
                    vectorViewDetailPemesanan.add(result.getString(3));
                    vectorViewDetailPemesanan.add(result.getString(9));
                    vectorViewDetailPemesanan.add(result.getString(10));
                    vectorViewDetailPemesanan.add(result.getString(11));
                    vectorViewDetailPemesanan.add(result.getString(12));
                    vectorViewDetailPemesanan.add(result.getString(13));
                    vectorViewDetailPemesanan.add(result.getString(17));
                    vectorViewDetailPemesanan.add(result.getString(18));
                    vectorViewDetailPemesanan.add(result.getString(19));
                    vectorViewDetailPemesanan.add(result.getString(20));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return vectorViewDetailPemesanan;
    }
      
}
