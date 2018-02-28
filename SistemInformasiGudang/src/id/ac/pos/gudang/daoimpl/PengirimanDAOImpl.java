/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PengirimanDAO;
import id.ac.pos.gudang.daoimpl.admin.RegionalDAOImpl;
import id.ac.pos.gudang.entity.Pengiriman;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reyha
 */
public class PengirimanDAOImpl implements PengirimanDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;
    

    @Override
    public ArrayList<Produk> getNamaProduk(String jenis_produk) {
        ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();

            String SELECT = "";
            if (jenis_produk.compareTo("MS") == 0) {
                SELECT = "SELECT distinct(nama_produk) FROM `tb_produk`"
                        + " where status='0' and id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SS'"
                        + " || id_jenis_produk = 'MS') ORDER BY nama_produk ASC";
            } else if (jenis_produk.compareTo("SHP") == 0) {
                SELECT = "SELECT distinct(nama_produk) FROM `tb_produk`"
                        + " where status='0' and id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SHP'"
                        + " || id_jenis_produk = 'SHPSS') ORDER BY nama_produk ASC";
            } else {
                SELECT = "SELECT distinct(nama_produk) FROM `tb_produk` where"
                        + " id_jenis_produk='" + jenis_produk + "' AND status='0'"
                        + " ORDER BY nama_produk ASC";
            }
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();
            String SELECT = "";
            if (jenis_produk.compareTo("MS") == 0) {
                SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND status='0' AND "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SS'"
                        + " || id_jenis_produk = 'MS')";
            } else if (jenis_produk.compareTo("SHP") == 0) {
                SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND status='0' AND "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SHP'"
                        + " || id_jenis_produk = 'SHPSS')";
            } else {
                SELECT = "SELECT distinct(tahun) FROM `tb_produk` where nama_produk='" + nama_produk + "' AND status='0' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
            }
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();
            String SELECT = "";
            if (jenis_produk.compareTo("MS") == 0) {
                SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND status='0' AND "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SS'"
                        + " || id_jenis_produk = 'MS')";
            } else if (jenis_produk.compareTo("SHP") == 0) {
                SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND status='0' AND "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SHP'"
                        + " || id_jenis_produk = 'SHPSS')";
            } else {
                SELECT = "SELECT nominal FROM `tb_produk` where nama_produk='" + nama_produk + "' AND tahun='" + tahun + "' AND status='0' AND id_jenis_produk='" + jenis_produk + "' ORDER BY nama_produk ASC";
            }
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk) {
        ArrayList<Produk> arrayProduk = null;
        try {
            conn = DatabaseConnectivity.getConnection();
            String SELECT = "";
            if (jenis_produk.compareTo("MS") == 0) {
                SELECT = "SELECT id_produk,stok FROM tb_produk "
                        + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && status='0' && "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SS'"
                        + " || id_jenis_produk = 'MS')";
            } else if (jenis_produk.compareTo("SHP") == 0) {
                SELECT = "SELECT id_produk,stok FROM tb_produk "
                        + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && status='0' && "
                        + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                        + " tb_produk WHERE id_jenis_produk = 'SHP'"
                        + " || id_jenis_produk = 'SHPSS')";
            } else {
                SELECT = "SELECT id_produk,stok FROM tb_produk "
                        + "WHERE nama_produk='" + nama_produk + "' && tahun='" + tahun + "' && nominal='" + nominal + "' && status='0' && "
                        + "id_jenis_produk='" + jenis_produk + "'";
            }
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public ArrayList<Regional> getIsiRegional(Object nama_regional) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional where regional='" + nama_regional + "'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRegional = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Regional regional = new Regional();
                    regional.setIdRegional(result.getString(1));
                    regional.setKodePos(result.getString(3));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayRegional;
    }

    @Override
    public ArrayList<Regional> getRegional() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRegional = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Regional regional = new Regional();
                    regional.setNamaRegional(result.getString(2));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayRegional;
    }

    @Override
    public String getIdPengiriman() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String id_pengiriman = null;
        String SELECT = "select * from tb_trans_pengiriman";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_pengiriman = result.getString("id_pengiriman");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_pengiriman;
    }

    @Override
    public int getStok(String kode_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        int stok = 0;
        String SELECT = "select stok from tb_produk where id_produk = '" + kode_produk + "'";
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
    public boolean tambahPengiriman(Pengiriman pengiriman) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "INSERT INTO tb_trans_pengiriman VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pengiriman.getId_pengiriman());
            state.setString(2, pengiriman.getNo_order_pengiriman());
            state.setDate(3, new java.sql.Date(pengiriman.getTgl_pengiriman().getTime()));
            state.setString(4, Integer.toString(pengiriman.getJumlah_pengiriman()));
            state.setString(5, pengiriman.getBsu());
            state.setString(6, pengiriman.getId_regional());
            state.setString(7, pengiriman.getId_produk());
            state.setString(8, Integer.toString(pengiriman.getStok_awal()));
            state.setString(9, Integer.toString(pengiriman.getStok_akhir()));

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Pengiriman> getPengiriman(String jenis_produk) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Pengiriman> arrayPengiriman = null;
        String SELECT = "";
        if (jenis_produk.compareTo("MS") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + " where tb_produk.status='0' and tb_produk.id_jenis_produk in (SELECT tb_produk.id_jenis_produk FROM"
                    + " tb_produk WHERE tb_produk.id_jenis_produk = 'SS'"
                    + " || tb_produk.id_jenis_produk = 'MS')";
        } else if (jenis_produk.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + " where tb_produk.status='0' and tb_produk.id_jenis_produk in (SELECT tb_produk.id_jenis_produk FROM"
                    + " tb_produk WHERE tb_produk.id_jenis_produk = 'SHP'"
                    + " || tb_produk.id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + "where tb_trans_pengiriman.id_produk like '" + jenis_produk + "%' AND tb_produk.status='0'";
        }
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPengiriman = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Pengiriman pengiriman = new Pengiriman();
                    pengiriman.setId_pengiriman(result.getString(1));
                    pengiriman.setNo_order_pengiriman(result.getString(2));
                    pengiriman.setTgl_pengiriman(result.getDate(3));
                    pengiriman.setJumlah_pengiriman(Integer.parseInt(result.getString(4)));
                    pengiriman.setBsu(result.getString(5));
                    pengiriman.setId_regional(result.getString(6));
                    pengiriman.setId_produk(result.getString(7));
                    pengiriman.setStok_awal(Integer.parseInt(result.getString(8)));
                    pengiriman.setStok_akhir(Integer.parseInt(result.getString(9)));
                    pengiriman.setNama_produk(result.getString(11));

                    //menambahkan data ke array
                    arrayPengiriman.add(pengiriman);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PengembalianDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPengiriman;
    }

    @Override
    public ArrayList<Pengiriman> cariProdukPengiriman(String keyword, String jenisCari, String idJenis) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Pengiriman> arrayPengiriman = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + " where " + jenisCari + " LIKE '%" + keyword + "%'"
                    + " and  tb_produk.status='0' and tb_produk.id_jenis_produk"
                    + " in (SELECT tb_produk.id_jenis_produk FROM"
                    + " tb_produk WHERE tb_produk.id_jenis_produk = 'SS'"
                    + " || tb_produk.id_jenis_produk = 'MS')";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + " where " + jenisCari + " LIKE '%" + keyword + "%'"
                    + " and  tb_produk.status='0' and tb_produk.id_jenis_produk"
                    + " in (SELECT tb_produk.id_jenis_produk FROM"
                    + " tb_produk WHERE tb_produk.id_jenis_produk = 'SHP'"
                    + " || tb_produk.id_jenis_produk = 'shpss')";
        } else {
            SELECT = "SELECT * FROM tb_trans_pengiriman inner join tb_produk "
                    + "on tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                    + "where " + jenisCari + " LIKE '%" + keyword + "%' AND"
                    + " tb_trans_pengiriman.id_produk like '" + idJenis + "%' AND tb_produk.status='0'";
        }
         state = null;

        try {
            state = conn.prepareStatement(SELECT);
             result = state.executeQuery();
            if (result != null) {
                arrayPengiriman = new ArrayList<>();

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {

                    // mengambil 1 data
                    Pengiriman pengiriman = new Pengiriman();
                    pengiriman.setId_pengiriman(result.getString(1));
                    pengiriman.setNo_order_pengiriman(result.getString(2));
                    pengiriman.setTgl_pengiriman(result.getDate(3));
                    pengiriman.setJumlah_pengiriman(Integer.parseInt(result.getString(4)));
                    pengiriman.setBsu(result.getString(5));
                    pengiriman.setId_regional(result.getString(6));
                    pengiriman.setId_produk(result.getString(7));
                    pengiriman.setStok_awal(Integer.parseInt(result.getString(8)));
                    pengiriman.setStok_akhir(Integer.parseInt(result.getString(9)));
                    pengiriman.setNama_produk(result.getString(11));

                    // menambahkan data ke array
                    arrayPengiriman.add(pengiriman);
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

        return arrayPengiriman;
    }

    @Override
    public Vector getViewDetailPengiriman(String id_pengiriman) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(PemesananDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Vector vectorViewDetailPengiriman = new Vector();
        String SELECT = "SELECT * FROM `tb_trans_pengiriman` "
                + "JOIN tb_produk ON tb_trans_pengiriman.id_produk=tb_produk.id_produk "
                + "JOIN tb_regional ON tb_trans_pengiriman.id_regional=tb_regional.id_regional "
                + "WHERE tb_trans_pengiriman.id_pengiriman='"+id_pengiriman+"'";


         state = null;

        try {
            state = conn.prepareStatement(SELECT);

             result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    vectorViewDetailPengiriman.add(result.getString(2));
                    vectorViewDetailPengiriman.add(result.getDate(3));
                    vectorViewDetailPengiriman.add(result.getString(4));
                    vectorViewDetailPengiriman.add(result.getString(8));
                    vectorViewDetailPengiriman.add(result.getString(9));
                    vectorViewDetailPengiriman.add(result.getString(5));
                    vectorViewDetailPengiriman.add(result.getString(10));
                    vectorViewDetailPengiriman.add(result.getString(11));
                    vectorViewDetailPengiriman.add(result.getString(12));
                    vectorViewDetailPengiriman.add(result.getString(13));
                    vectorViewDetailPengiriman.add(result.getString(14));
                    vectorViewDetailPengiriman.add(result.getString(15));
                    vectorViewDetailPengiriman.add(result.getString(19));
                    vectorViewDetailPengiriman.add(result.getString(20));
                    vectorViewDetailPengiriman.add(result.getString(21));
                    vectorViewDetailPengiriman.add(result.getString(22));
                    vectorViewDetailPengiriman.add(result.getString(23));
                }
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(PengirimanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

        return vectorViewDetailPengiriman;
    }

}
