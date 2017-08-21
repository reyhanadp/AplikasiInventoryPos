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
    public ArrayList<Produk> cariProduk(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean tambahProduk(Produk produk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hapusProduk(int idProduk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ubahProduk(Produk produk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        String SELECT = "SELECT * FROM tb_produk where id_produk like 'MC%' ";
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

}