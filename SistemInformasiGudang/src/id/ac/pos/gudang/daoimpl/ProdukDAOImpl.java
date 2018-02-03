/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.ProdukDAO;
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
 * @author Oyoy
 */
public class ProdukDAOImpl implements ProdukDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    @Override
    public ArrayList<Produk> cariProduk(String keyword, String jenisCari, String idJenis) {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "";
        if (idJenis.compareTo("SS") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SS'"
                    + " || id_jenis_produk = 'MS')";
        } else if (idJenis.compareTo("SHP") == 0) {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && "
                    + "id_jenis_produk in (SELECT id_jenis_produk FROM"
                    + " tb_produk WHERE id_jenis_produk = 'SHP'"
                    + " || id_jenis_produk = 'SHPSS')";
        } else {
            SELECT = "SELECT * FROM tb_produk "
                    + "WHERE " + jenisCari + " LIKE '%" + keyword + "%' && id_jenis_produk = '" + idJenis + "'";
        }
        state = null;

        try {
            state = conn.prepareStatement(SELECT);
            result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                // selama result memiliki data
                // return lebih dari 1 data
                while (result.next()) {

                    // mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setNamaProduk(result.getString(2));
                    produk.setNominal(result.getInt(3));
                    produk.setBiayaCetak(result.getFloat(4));
                    produk.setStok(result.getInt(5));
                    produk.setTahun(result.getString(6));
                    produk.setIdJenisProduk(result.getString(7));

                    // menambahkan data ke array
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
    public boolean tambahProduk(Produk produk, String jenisProduk) {
        conn = DatabaseConnectivity.getConnection();
        String INSERT = "INSERT INTO tb_produk (id_produk, nama_produk, nominal, "
                + "biaya_cetak, stok, tahun, id_jenis_produk,nik"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, produk.getIdProduk());
            state.setString(2, produk.getNamaProduk());
            state.setInt(3, produk.getNominal());
            state.setFloat(4, produk.getBiayaCetak());
            state.setInt(5, produk.getStok());
            state.setString(6, produk.getTahun());
            state.setString(7, jenisProduk);
            state.setString(8, produk.getNik());

            int qty = state.executeUpdate();
            return qty > 0;
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

        return false;
    }

    @Override
    public boolean hapusProduk(String idProduk) {
        conn = DatabaseConnectivity.getConnection();
        String DELETE = "UPDATE tb_produk SET status=1 "
                + "WHERE id_produk = ?";
        state = null;
        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idProduk);

            int qty = state.executeUpdate();
            return qty > 0;
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
        return false;
    }

    @Override
    public boolean ubahProduk(Produk produk) {
        conn = DatabaseConnectivity.getConnection();
        String UPDATE = "UPDATE tb_produk "
                + "SET nama_produk = ?, nominal = ?, biaya_cetak = ?,"
                + " tahun = ? WHERE id_produk = ?";
        state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, produk.getNamaProduk());
            state.setInt(2, produk.getNominal());
            state.setFloat(3, produk.getBiayaCetak());
            state.setString(4, produk.getTahun());
            state.setString(5, produk.getIdProduk());

            int qty = state.executeUpdate();
            return qty > 0;
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
        return false;
    }

    @Override
    public String getIdProduk(String jenisProduk) {
        conn = DatabaseConnectivity.getConnection();
        String kode_produk = null;
        String SELECT = "(SELECT id_produk FROM tb_produk "
                + "WHERE id_jenis_produk='" + jenisProduk + "')"
                + " ORDER BY id_produk";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    kode_produk = result.getString("id_produk");
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

        return kode_produk;
    }

    @Override
    public ArrayList<Produk> getProduk() {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where status=0 order by id_produk desc";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setNamaProduk(result.getString(2));
                    produk.setNominal(result.getInt(3));
                    produk.setBiayaCetak(result.getFloat(4));
                    produk.setStok(result.getInt(5));
                    produk.setTahun(result.getString(6));
                    produk.setIdJenisProduk(result.getString(7));

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
    public ArrayList<Produk> getProdukDeleted() {
        conn = DatabaseConnectivity.getConnection();
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where status=1";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setIdProduk(result.getString(1));
                    produk.setNamaProduk(result.getString(2));
                    produk.setNominal(result.getInt(3));
                    produk.setBiayaCetak(result.getFloat(4));
                    produk.setStok(result.getInt(5));
                    produk.setTahun(result.getString(6));
                    produk.setIdJenisProduk(result.getString(7));
                    produk.setNik(result.getString(8));

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
    public boolean restoreProduk(Produk produk, String idProduk) {
        conn = DatabaseConnectivity.getConnection();
        String UPDATE = "UPDATE tb_produk SET status=0"
                + " WHERE id_produk=?";
        state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, produk.getIdProduk());

            int qty = state.executeUpdate();
            return qty > 0;
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
        return false;
    }

    @Override
    public Integer getTahunSekarang() {
        conn = DatabaseConnectivity.getConnection();
        int tahun = 0;
        String SELECT = "SELECT YEAR(CURDATE())";
        state = null;

        try {
            state = conn.prepareStatement(SELECT);

            result = state.executeQuery();
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

        return tahun;
    }
}
