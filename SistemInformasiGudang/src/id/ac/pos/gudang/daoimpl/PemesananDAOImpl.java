/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Suplier;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author muhamad solahudin
 */
public class PemesananDAOImpl implements PemesananDAO{
    
    private Connection conn;
    
      
    public PemesananDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public String getIdPemesanan() {
        String id_pemesanan = null;
        String SELECT = "select * from tb_trans_pemesanan";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }

        return id_pemesanan;
    }
    
    @Override
    public ArrayList<Pemesanan> cariProdukPemesanan(String keyword, String jenisCari, String idJenis) {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT * FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_suplier sp ON pm.id_suplier=sp.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_suplier sp ON pm.id_suplier=sp.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT * FROM tb_trans_pemesanan pm JOIN tb_produk pr ON pm.id_produk=pr.id_produk "
                    + "JOIN tb_suplier sp ON pm.id_suplier=sp.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && id_jenis_produk = '" + idJenis + "'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPemesanan = new ArrayList<>();

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {

                    // mengambil 1 data
                    Pemesanan pemesanan = new Pemesanan();
                    pemesanan.setNoPemesanan(result.getString("no_pemesanan"));
                    pemesanan.setKodeProduk(result.getString("id_produk"));
                    pemesanan.setJumlahPemesanan(result.getString("jumlah_pesan"));
                    pemesanan.setTglPemesanan(result.getDate("tgl_pesan"));
                    pemesanan.setIdSuplier(result.getString("id_suplier"));
                    pemesanan.setStatus(result.getString("status"));

                    // menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPemesanan;
    }
    
    
    @Override
    public String getNoPemesanan() {
        String no_pemesanan = null;
        String SELECT = "SELECT no_pemesanan FROM tb_trans_pemesanan ORDER BY no_pemesanan";
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
     
    @Override
    public ArrayList<Produk> getProduk(Object pilihan, String jenis_produk) {
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
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }

        return arrayProdukPrangko;
    }
    
    @Override
    public ArrayList<Suplier> getIsiSuplier(Object pilihan) {
        ArrayList<Suplier> arraySuplier = null;
        String SELECT = "SELECT * FROM tb_suplier";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arraySuplier = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Suplier suplier = new Suplier();
                    suplier.setIdSuplier(result.getString(1));
                    suplier.setNama_suplier(result.getString(2));

                    //menambahkan data ke array
                    arraySuplier.add(suplier);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arraySuplier;
    }
    
    @Override
    public ArrayList<Suplier> getSuplier() {
        ArrayList<Suplier> arraySuplier = null;
        String SELECT = "SELECT * FROM tb_suplier";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arraySuplier = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Suplier suplier = new Suplier();
                    suplier.setNama_suplier(result.getString(2));

                    //menambahkan data ke array
                    arraySuplier.add(suplier);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arraySuplier;
    }
    
    @Override
    public boolean tambahPemesanan(Pemesanan pemesanan) {
       String INSERT = "INSERT INTO tb_trans_pemesanan (id_pemesanan,no_pemesanan,id_produk,"
                + "jumlah_pesan,tgl_pesan,id_suplier,status"
                + ") VALUES (?, ?, ?, ?, ?, ?, 'belum selesai')";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pemesanan.getIdPemesanan());
            state.setString(2, pemesanan.getNoPemesanan());
            state.setString(3, pemesanan.getKodeProduk());
            state.setString(4, pemesanan.getJumlahPemesanan());
            state.setDate(5, new java.sql.Date(pemesanan.getTglPemesanan().getTime()));
            state.setString(6, pemesanan.getIdSuplier());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false; 
    }
    
    @Override
    public ArrayList<Pemesanan> getPemesanan(String jenis_produk) {
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_trans_pemesanan where id_produk like 'MS%' OR id_produk like 'SS%'";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_pemesanan where id_produk like 'SHP%' OR id_produk like 'SHPSS%'";
        }else{
            SELECT = "SELECT * FROM tb_trans_pemesanan where id_produk like '"+jenis_produk+"%'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    pemesanan.setJumlahPemesanan(result.getString(4));
                    pemesanan.setTglPemesanan(result.getDate(5));
                    pemesanan.setIdSuplier(result.getString(6));
                    pemesanan.setStatus(result.getString(7));
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
    
    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='MS' OR id_jenis_produk='SS' ORDER BY nama_produk ASC";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='SHP' OR id_jenis_produk='SHPSS' ORDER BY nama_produk ASC";
        } else {
            SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
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
                    produk.setNamaProduk(result.getString(1));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT id_produk,stok FROM tb_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk='" + jenis_produk + "'";
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
                    produk.setStok(Integer.parseInt(result.getString(2)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
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
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
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
                    produk.setNominal(Integer.parseInt(result.getString(1)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Produk> getNama(String kode_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT nama_produk,nominal,tahun FROM `tb_produk` where id_produk='"+kode_produk+"'";


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
                    produk.setNamaProduk(result.getString(1));
                    produk.setNominal(Integer.parseInt(result.getString(2)));
                    produk.setTahun(result.getString(3));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Suplier> getNamaSuplier(String id_suplier) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Suplier> arraySuplier = null;
        String SELECT = "SELECT nama_suplier FROM `tb_suplier` where id_suplier='"+id_suplier+"'";


        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arraySuplier = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Suplier suplier = new Suplier();
                    suplier.setNama_suplier(result.getString(1));

                    //menambahkan data ke array
                    arraySuplier.add(suplier);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                state.close();
            } catch (SQLException ex) {
                Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return arraySuplier;
    }
      
}
