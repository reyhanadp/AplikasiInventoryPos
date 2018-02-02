/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PenerimaanDAO;
import id.ac.pos.gudang.daoimpl.admin.MitraDAOImpl;
import id.ac.pos.gudang.entity.Mitra;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
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
 * @author muhamad solahudin
 */
public class PenerimaanDAOImpl implements PenerimaanDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    public PenerimaanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public String getIdPenerimaan() {
        conn = DatabaseConnectivity.getConnection();
        String id_penerimaan = null;
        String SELECT = "select * from tb_trans_penerimaan";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_penerimaan = result.getString("id_penerimaan");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return id_penerimaan;
    }

    public ArrayList<Pemesanan> getNoPemesanan(String idPemesanan) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        SELECT = "SELECT no_pemesanan FROM tb_trans_pemesanan "
                + "where id_pemesanan='" + idPemesanan + "'";

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
                    pemesanan.setNoPemesanan(result.getString(1));
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
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

        return arrayPemesanan;
    }

    @Override
    public ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT pr.id_produk,stok FROM tb_produk pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND pm.status='belum selesai' AND pr.status=0";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT pr.id_produk,stok FROM tb_produk pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND pm.status='belum selesai' AND pr.status=0";
        } else {
            SELECT = "SELECT pr.id_produk,stok FROM tb_produk pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && "
                    + "id_jenis_produk='" + jenis_produk + "' AND pm.status='belum selesai' AND pr.status=0";
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
    public ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(nominal) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND pr.status=0 AND pm.status='belum selesai' "
                    + "ORDER BY nominal";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(nominal) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND pr.status=0 AND pm.status='belum selesai'"
                    + " ORDER BY nominal";
        } else {
            SELECT = "SELECT distinct(nominal) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' "
                    + "AND id_jenis_produk='" + jenis_produk + "' AND pr.status=0 AND pm.status='belum selesai' ORDER BY nominal";
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
    public ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND pr.status=0 "
                    + "AND pm.status='belum selesai' ORDER BY tahun";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND pr.status=0 "
                    + "AND pm.status='belum selesai' ORDER BY tahun";
        } else {
            SELECT = "SELECT distinct(tahun) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                    + "ON pr.id_produk=pm.id_produk "
                    + "where nama_produk='" + nama_produk + "' AND id_jenis_produk='" + jenis_produk + "' "
                    + "AND pr.status=0 AND pm.status='belum selesai' ORDER BY tahun";
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

    public ArrayList<Pemesanan> getIdPemesanan(String kodeProduk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "";
        SELECT = "SELECT id_pemesanan,id_mitra FROM tb_trans_pemesanan "
                + "where id_produk='" + kodeProduk + "' AND status='belum selesai' ";

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
                    pemesanan.setIdMitra(result.getString(2));
                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
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

        return arrayPemesanan;
    }

    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` pr JOIN tb_trans_pemesanan pm "
                + "ON pr.id_produk=pm.id_produk"
                + " where id_jenis_produk='" + jenis_produk + "' AND pm.status='belum selesai'"
                + " AND pr.status=0 ORDER BY nama_produk ASC";

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
    public ArrayList<Penerimaan> IsiPemesanan(String idPemesanan) {
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        SELECT = "SELECT tb_trans_pemesanan.id_mitra,tb_produk.id_produk,tb_trans_penerimaan.sisa_belum_dikirim,"
                + "tb_produk.nama_produk,tb_trans_penerimaan.subtotal_terima,jumlah_pesan,stok "
                + "FROM tb_trans_pemesanan JOIN tb_produk ON tb_trans_pemesanan.id_produk=tb_produk.id_produk "
                + "JOIN tb_trans_penerimaan ON tb_trans_penerimaan.id_pemesanan=tb_trans_pemesanan.id_pemesanan "
                + "WHERE tb_trans_pemesanan.id_pemesanan = '" + idPemesanan + "' AND tb_produk.status=0 "
                + "ORDER BY tb_trans_penerimaan.subtotal_terima DESC";
        state = null;
        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {
                arrayPenerimaan = new ArrayList<>();

                while (result.next()) {
                    Penerimaan penerimaan = new Penerimaan();
                    penerimaan.setIdMitra(result.getString(1));
                    penerimaan.setIdProduk(result.getString(2));
                    penerimaan.setSisaBelumDikirim(result.getInt(3));
                    penerimaan.setSubTotalTerima(result.getInt(5));
                    penerimaan.setJmlTerima(result.getInt(6));
                    penerimaan.setStokAwal(result.getInt(7));

                    arrayPenerimaan.add(penerimaan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

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
        return arrayPenerimaan;
    }

    @Override
    public ArrayList<Produk> getDetailProduk(Object noPemesanan) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        SELECT = "SELECT tb_trans_pemesanan.id_mitra,tb_produk.id_produk,tb_produk.stok,"
                + "tb_produk.nama_produk,nominal,tahun "
                + "FROM tb_trans_pemesanan,tb_produk "
                + "WHERE id_pemesanan = '" + noPemesanan + "' AND tb_trans_pemesanan.id_produk=tb_produk.id_produk";

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
                    produk.setIdProduk(result.getString("id_produk"));
                    produk.setNamaProduk(result.getString("nama_produk"));
                    produk.setNominal(Integer.parseInt(result.getString("nominal")));
                    produk.setTahun(result.getString("tahun"));
                    produk.setStok(Integer.parseInt(result.getString("stok")));
                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Pemesanan> getTotalPesan(Object noPemesanan) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Pemesanan> arrayPemesanan = null;
        String SELECT = "SELECT jumlah_pesan "
                + "FROM tb_trans_pemesanan "
                + "WHERE id_pemesanan = '" + noPemesanan + "'";

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
                    pemesanan.setJumlahPemesanan(result.getString(1));

                    //menambahkan data ke array
                    arrayPemesanan.add(pemesanan);
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

        return arrayPemesanan;
    }

    @Override
    public ArrayList<Penerimaan> cariProdukPenerimaan(String keyword, String jenisCari, String idJenis) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_mitra sp "
                    + "ON sp.id_mitra=pn.id_mitra JOIN tb_trans_pemesanan ps "
                    + "ON ps.id_pemesanan=pn.id_pemesanan "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "substring(pr.id_produk,1,2) in (SELECT substring(id_produk,1,2) FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS') AND pr.status=0 ";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_mitra sp "
                    + "ON sp.id_mitra=pn.id_mitra JOIN tb_trans_pemesanan ps "
                    + "ON ps.id_pemesanan=pn.id_pemesanan "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "substring(pr.id_produk,1,2) in (SELECT substring(id_produk,1,2) FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS') AND pr.status=0";
        } else {
            SELECT = "SELECT * FROM tb_trans_penerimaan pn JOIN tb_produk pr "
                    + "ON pn.id_produk=pr.id_produk JOIN tb_mitra sp "
                    + "ON sp.id_mitra=pn.id_mitra JOIN tb_trans_pemesanan ps "
                    + "ON ps.id_pemesanan=pn.id_pemesanan "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && substring(pr.id_produk,1,2) = '" + idJenis + "' "
                    + "AND pr.status=0";
        }
        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
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
                    penerimaan.setNamaProduk(result.getString("nama_produk"));
                    penerimaan.setNominal(Integer.valueOf(result.getString("nominal")));
                    penerimaan.setTahun(result.getString("tahun"));
                    penerimaan.setStokAwal(result.getInt("stok_awal"));
                    penerimaan.setStokAkhir(result.getInt("stok_akhir"));
                    penerimaan.setNamaMitra(result.getString("nama_mitra"));
                    penerimaan.setSubTotalTerima(result.getInt("subtotal_terima"));
                    penerimaan.setSisaBelumDikirim(result.getInt("sisa_belum_dikirim"));
                    penerimaan.setKeterangan(result.getString("keterangan"));

                    //menambahkan data ke array
                    arrayPenerimaan.add(penerimaan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return arrayPenerimaan;
    }

    @Override
    public boolean tambahPenerimaan(Penerimaan penerimaan) {
        conn = DatabaseConnectivity.getConnection();
        String INSERT = "INSERT INTO tb_trans_penerimaan (id_penerimaan,no_order_penerimaan,tgl_penerimaan, jml_terima, id_pemesanan,"
                + "id_produk, id_mitra, stok_awal, stok_akhir, subtotal_terima,sisa_belum_dikirim, keterangan"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, penerimaan.getIdPenerimaan());
            state.setString(2, penerimaan.getNoOrder());
            state.setDate(3, new java.sql.Date(penerimaan.getTglPenerimaan().getTime()));
            state.setInt(4, penerimaan.getJmlTerima());
            state.setString(5, penerimaan.getIdPemesanan());
            state.setString(6, penerimaan.getIdProduk());
            state.setString(7, penerimaan.getIdMitra());
            state.setInt(8, penerimaan.getStokAwal());
            state.setInt(9, penerimaan.getStokAkhir());
            state.setInt(10, penerimaan.getSubTotalTerima());
            state.setInt(11, penerimaan.getSisaBelumDikirim());
            state.setString(12, penerimaan.getKeterangan());

            int qty = state.executeUpdate();
            return qty > 0;

        } catch (SQLException ex) {
            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return false;

    }

    @Override
    public ArrayList<Penerimaan> getDataPenerimaan() {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "";
        SELECT = "SELECT pn.no_order_penerimaan,pn.tgl_penerimaan,pn.jml_terima,pm.no_pemesanan,pr.id_produk,pr.nama_produk,pr.nominal,"
                + "pr.tahun,pn.stok_awal,pn.stok_akhir,mr.nama_mitra,pn.subtotal_terima,pn.sisa_belum_dikirim,pn.keterangan "
                + "FROM tb_trans_penerimaan pn JOIN tb_trans_pemesanan pm ON pm.id_pemesanan=pn.id_pemesanan "
                + "JOIN tb_produk pr ON pr.id_produk=pm.id_produk "
                + "JOIN tb_mitra mr On mr.id_mitra=pm.id_mitra "
                + "WHERE pr.status=0";

        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();

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
                    penerimaan.setNamaProduk(result.getString("nama_produk"));
                    penerimaan.setNominal(Integer.valueOf(result.getString("nominal")));
                    penerimaan.setTahun(result.getString("tahun"));
                    penerimaan.setStokAwal(Integer.valueOf(result.getString("stok_awal")));
                    penerimaan.setStokAkhir(Integer.valueOf(result.getString("stok_akhir")));
                    penerimaan.setNamaMitra(result.getString("nama_mitra"));
                    penerimaan.setSubTotalTerima(result.getInt("subtotal_terima"));
                    penerimaan.setSisaBelumDikirim(result.getInt("sisa_belum_dikirim"));
                    penerimaan.setKeterangan(result.getString("keterangan"));

                    //menambahkan data ke array
                    arrayPenerimaan.add(penerimaan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return arrayPenerimaan;
    }

    @Override
    public ArrayList<Produk> getStok(String kode_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT stok FROM `tb_produk` where id_produk='" + kode_produk + "'";

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
                    produk.setStok(Integer.valueOf(result.getString(1)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Produk> getNama(String kode_produk) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT nama_produk,nominal,tahun FROM `tb_produk` where id_produk='" + kode_produk + "'";

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
    public ArrayList<Mitra> getNamaMitra(String id_mitra) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT nama_mitra FROM `tb_mitra` where id_mitra='" + id_mitra + "'";

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
        return arrayMitra;
    }

}
