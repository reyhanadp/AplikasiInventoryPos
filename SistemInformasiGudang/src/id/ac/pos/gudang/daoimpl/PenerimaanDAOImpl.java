/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.dao.PenerimaanDAO;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
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
public class PenerimaanDAOImpl implements PenerimaanDAO {
    
    private Connection conn;
    
    public PenerimaanDAOImpl() {
         conn = DatabaseConnectivity.getConnection();
    }
    
    
    
    public ArrayList<Pemesanan> getNoPemesanan(String kodeProduk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        SELECT = "SELECT no_pemesanan,id_suplier FROM tb_pemesanan "
                    + "where id_produk='"+kodeProduk+"' AND status='belum selesai'";
       
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
                    pemesanan.setNoPemesanan(result.getString(1));
                    pemesanan.setIdSuplier(result.getString(2));
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPemesanan;
    }
    
    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
    
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` pr JOIN tb_pemesanan pm "
               + "ON pr.id_produk=pm.id_produk"
               + " where id_jenis_produk='" + jenis_produk + "' AND status='belum selesai' ORDER BY nama_produk ASC";
        
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
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProduk;
    }
    
    @Override
    public ArrayList<Penerimaan> IsiPemesanan(String noPemesanan){
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        SELECT = "SELECT tb_pemesanan.id_suplier,tb_produk.id_produk,tb_trans_penerimaan.sisa_belum_dikirim,"
                    + "tb_produk.nama_produk,tb_trans_penerimaan.subtotal_terima,jumlah_pesan,stok "
                    + "FROM tb_pemesanan,tb_produk,tb_trans_penerimaan "
                    + "WHERE tb_pemesanan.no_pemesanan = '"+noPemesanan+"' AND tb_pemesanan.id_produk=tb_produk.id_produk"
                    + " AND tb_trans_penerimaan.no_pemesanan=tb_pemesanan.no_pemesanan";
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPenerimaan = new ArrayList<>();
                
                while (result.next()) {
                    Penerimaan penerimaan = new Penerimaan();
                    penerimaan.setIdSuplier(result.getString(1));
                    penerimaan.setIdProduk(result.getString(2));
                    penerimaan.setSisaBelumDikirim(result.getInt(3));
                    penerimaan.setSubTotalTerima(result.getInt(5));
                    penerimaan.setJmlTerima(result.getInt(6));
                    penerimaan.setStokAwal(result.getInt(7));
                    
                    arrayPenerimaan.add(penerimaan);
                }
            }
            state.close();
          } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
        return arrayPenerimaan;
     }
    
    @Override
    public ArrayList<Produk> getDetailProduk(Object noPemesanan) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        SELECT = "SELECT tb_pemesanan.id_suplier,tb_produk.id_produk,tb_produk.stok,"
                    + "tb_produk.nama_produk,nominal,tahun "
                    + "FROM tb_pemesanan,tb_produk "
                    + "WHERE no_pemesanan = '"+noPemesanan+"' AND tb_pemesanan.id_produk=tb_produk.id_produk";

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
                    produk.setIdProduk(result.getString("id_produk"));
                    produk.setNamaProduk(result.getString("nama_produk"));
                    produk.setNominal(Integer.parseInt(result.getString("nominal")));
                    produk.setTahun(result.getString("tahun"));
                    produk.setStok(Integer.parseInt(result.getString("stok")));
                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return arrayProduk;
    }
    
    @Override
    public ArrayList<Pemesanan> getTotalPesan(Object noPemesanan) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        SELECT = "SELECT jumlah_pesan "
                    + "FROM tb_pemesanan "
                    + "WHERE no_pemesanan = '"+noPemesanan+"'";

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
                    pemesanan.setJumlahPemesanan(result.getString(1));
                    
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
                }
            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 

        return arrayPemesanan;
    }
       
    @Override
    public ArrayList<Penerimaan> cariProdukPenerimaan(String keyword, String jenisCari, String idJenis) {
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_suplier sp "
                    + "ON sp.id_suplier=pn.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "substring(pr.id_produk,1,2) in (SELECT substring(id_produk,1,2) FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_suplier sp "
                    + "ON sp.id_suplier=pn.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "substring(pr.id_produk,1,2) in (SELECT substring(id_produk,1,2) FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
                SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_suplier sp "
                    + "ON sp.id_suplier=pn.id_suplier "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && substring(pr.id_produk,1,2) = '" + idJenis + "'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPenerimaan = new ArrayList<>();

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {
                    Penerimaan penerimaan = new Penerimaan();
                    penerimaan.setNoOrder(result.getString("no_order_penerimaan"));
                    penerimaan.setTglPenerimaan(result.getDate("tgl_penerimaan"));
                    penerimaan.setJmlTerima(result.getInt("jml_terima"));
                    penerimaan.setNoPemesanan(result.getString("no_pemesanan"));
                    penerimaan.setIdProduk(result.getString("id_produk"));
                    penerimaan.setIdSuplier(result.getString("id_suplier"));
                    penerimaan.setStokAwal(result.getInt("stok_awal"));
                    penerimaan.setStokAkhir(result.getInt("stok_akhir"));
                    penerimaan.setSubTotalTerima(result.getInt("subtotal_terima"));
                    penerimaan.setSisaBelumDikirim(result.getInt("sisa_belum_dikirim"));
                    penerimaan.setKeterangan(result.getString("keterangan"));
                    
                    //menambahkan data ke array
                    arrayPenerimaan.add(penerimaan);
                }
            }
            state.close();
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return arrayPenerimaan;
    }
        
    public boolean tambahPenerimaan(Penerimaan penerimaan){
        String INSERT = "INSERT INTO tb_trans_penerimaan (no_order_penerimaan,tgl_penerimaan, jml_terima, no_pemesanan,"
                + "id_produk, id_suplier, stok_awal, stok_akhir, subtotal_terima,sisa_belum_dikirim, keterangan"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, penerimaan.getNoOrder());
            state.setDate(2, new java.sql.Date (penerimaan.getTglPenerimaan().getTime()));
            state.setInt(3, penerimaan.getJmlTerima());
            state.setString(4,penerimaan.getNoPemesanan());
            state.setString(5, penerimaan.getIdProduk());
            state.setString(6, penerimaan.getIdSuplier());
            state.setInt(7, penerimaan.getStokAwal());
            state.setInt(8, penerimaan.getStokAkhir());
            state.setInt(9, penerimaan.getSubTotalTerima());
            state.setInt(10, penerimaan.getSisaBelumDikirim());
            state.setString(11, penerimaan.getKeterangan());
            
            int qty = state.executeUpdate();
            state.close();
            return qty > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    @Override
    public ArrayList<Penerimaan> getDataPenerimaan(String jenis_produk) {
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan where id_produk like 'MS%' OR id_produk like 'SS%'";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan where id_produk like 'SHP%' OR id_produk like 'SHPSS%'";
        }else{
            SELECT = "SELECT * FROM tb_trans_penerimaan where id_produk like '"+jenis_produk+"%'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            
            ResultSet result = state.executeQuery();
            
            if (result != null) {
                arrayPenerimaan = new ArrayList<>();
                
                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Penerimaan penerimaan = new Penerimaan();
                    penerimaan.setNoOrder(result.getString("no_order_penerimaan"));
                    penerimaan.setTglPenerimaan(result.getDate("tgl_penerimaan"));
                    penerimaan.setJmlTerima(result.getInt("jml_terima"));
                    penerimaan.setNoPemesanan(result.getString("no_pemesanan"));
                    penerimaan.setIdProduk(result.getString("id_produk"));
                    penerimaan.setIdSuplier(result.getString("id_suplier"));
                    penerimaan.setStokAwal(result.getInt("stok_awal"));
                    penerimaan.setStokAkhir(result.getInt("stok_akhir"));
                    penerimaan.setSubTotalTerima(result.getInt("subtotal_terima"));
                    penerimaan.setSisaBelumDikirim(result.getInt("sisa_belum_dikirim"));
                    penerimaan.setKeterangan(result.getString("keterangan"));
                    
                    //menambahkan data ke array
                    arrayPenerimaan.add(penerimaan);
                }
            }
            state.close();
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return arrayPenerimaan;
    }
    
    @Override
    public ArrayList<Produk> getStok(String kode_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT stok FROM `tb_produk` where id_produk='"+kode_produk+"'";


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
                    produk.setStok(Integer.valueOf(result.getString(1)));
                    
                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
            state.close();
        } catch (SQLException ex) {
            Logger.getLogger(SuplierDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arraySuplier;
    }
    
}
