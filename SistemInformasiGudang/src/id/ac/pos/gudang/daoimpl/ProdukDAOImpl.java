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

    private Connection conn;

    public ProdukDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Produk> cariProduk(String keyword, String jenisCari, String idJenis) {
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
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
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
        }

        return arrayProduk;
    }

    @Override
    public boolean tambahProduk(Produk produk, String jenisProduk) {
        String INSERT = "INSERT INTO tb_produk (id_produk, nama_produk, nominal, "
                + "biaya_cetak, stok, tahun, id_jenis_produk"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, produk.getIdProduk());
            state.setString(2, produk.getNamaProduk());
            state.setInt(3, produk.getNominal());
            state.setFloat(4, produk.getBiayaCetak());
            state.setInt(5, produk.getStok());
            state.setString(6, produk.getTahun());
            state.setString(7, jenisProduk);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusProduk(String idProduk) {
        String DELETE = "DELETE FROM tb_produk "
                + "WHERE id_produk = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idProduk);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahProduk(Produk produk) {
        String UPDATE = "UPDATE tb_produk "
                + "SET nama_produk = ?, nominal = ?, biaya_cetak = ?,"
                + " tahun = ? WHERE id_produk = ?";
        PreparedStatement state = null;

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
        }
        return false;
    }

    @Override
    public String getIdProduk(String jenisProduk) {
        String kode_produk = null;
        String SELECT = "(SELECT id_produk FROM tb_produk "
                + "WHERE id_jenis_produk='" + jenisProduk + "')"
                + " UNION "
                + "(SELECT id_produk FROM tb_hapus_produk "
                + "WHERE id_jenis_produk='" + jenisProduk + "')"
                + " ORDER BY id_produk";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }

        return kode_produk;
    }

    @Override
    public ArrayList<Produk> getProdukPrangko() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'PR%'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukMS_SS() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'SS%' ||"
                + " id_produk like 'MS%' ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukSHP_SHPSS() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'SH%' ||"
                + " id_produk like 'SP%' ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukKemasan() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'KM%'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukMerchandise() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk WHERE id_produk like 'MC%' ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukPrisma() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'PS%'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukDokumenFilateli() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'DF%'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukPrangkoDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_jenis_produk = 'PR'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukMSSSDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_produk like 'SS%' ||"
                + " id_produk like 'MS%' ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukSHPSHPSSDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_produk like 'SHP%' ||"
                + " id_produk like 'SHPSS%' ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukMerchandiseDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_jenis_produk = 'MC'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukKemasanDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_jenis_produk = 'KM'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukPrismaDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_jenis_produk = 'PS'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getProdukDokumenFilateliDeleted() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk where id_jenis_produk = 'DF'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayProduk;
    }

    @Override
    public boolean restoreProduk(Produk produk, String jenisProduk) {
        String INSERT = "INSERT INTO tb_produk (id_produk, nama_produk, nominal, "
                + "biaya_cetak, stok, tahun, id_jenis_produk"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, produk.getIdProduk());
            state.setString(2, produk.getNamaProduk());
            state.setInt(3, produk.getNominal());
            state.setFloat(4, produk.getBiayaCetak());
            state.setInt(5, produk.getStok());
            state.setString(6, produk.getTahun());
            state.setString(7, produk.getIdJenisProduk());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public boolean hapusPermanent(String idProduk) {
        String DELETE = "DELETE FROM tb_hapus_produk "
                + "WHERE id_produk = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idProduk);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Produk> getHistoryUpdate() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_update_produk";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayProduk = new ArrayList<>();

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    Produk produk = new Produk();
                    produk.setNo(result.getInt(1));
                    produk.setIdProduk(result.getString(2));
                    produk.setNamaProduk(result.getString(3));
                    produk.setNominal(result.getInt(4));
                    produk.setBiayaCetak(result.getFloat(5));
                    produk.setStok(result.getInt(6));
                    produk.setTahun(result.getString(7));
                    produk.setTglUbah(result.getDate(9));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getHistoryDelete() {
        ArrayList<Produk> arrayProduk = null;
        String SELECT = "SELECT * FROM tb_hapus_produk";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
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
                    produk.setTglHapus(result.getDate(8));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayProduk;
    }

    @Override
    public boolean hapusHistoryUpdate() {
        String DELETE = "DELETE FROM tb_update_produk ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean hapusHistoryDelete() {
        String DELETE = "DELETE FROM tb_hapus_produk ";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
