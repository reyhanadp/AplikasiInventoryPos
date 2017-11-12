/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
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
 * @author Operator
 */
public class PengembalianDAOImpl implements PengembalianDAO{

    private Connection conn;

    public PengembalianDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public String getIdPengembalian() {
        String id_pengembalian = null;
        String SELECT = "select * from tb_trans_pengembalian";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {

                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    id_pengembalian = result.getString("id_pengembalian");
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id_pengembalian;
    }

    @Override
    public ArrayList<Produk> getProdukPrangko(Object pilihan) {
        ArrayList<Produk> arrayProdukPrangko = null;
        String SELECT = "SELECT * FROM tb_produk where nama_produk='"+pilihan+"'";
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProdukPrangko;
    }

    @Override
    public ArrayList<Regional> getIsiRegional(Object pilihan) {
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional where regional='"+pilihan+"'";
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
                    regional.setRegional(result.getString(2));

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
    public boolean tambahPengembalian(Pengembalian pengembalian) {
        String INSERT = "INSERT INTO tb_trans_pengembalian VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, pengembalian.getId_pengembalian());
            state.setDate(2, new java.sql.Date(pengembalian.getTanggal_pengembalian().getTime()));
            state.setString(3, pengembalian.getJumlah_pengembalian());
            state.setString(4, pengembalian.getDus());
            state.setString(5, pengembalian.getId_regional());
            state.setString(6, pengembalian.getId_produk());
            state.setString(7, pengembalian.getStok_awal());
            state.setString(8, pengembalian.getStok_akhir());
            state.setString(9, pengembalian.getKeterangan());
            

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProdukDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public ArrayList<Pengembalian> getPengembalianPrangko() {
        ArrayList<Pengembalian> arrayPengembalian = null;
        String SELECT = "SELECT * FROM tb_trans_pengembalian where id_produk like 'PR%'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayPengembalian = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Pengembalian pengembalian = new Pengembalian();
                    pengembalian.setId_pengembalian(result.getString(1));
                    pengembalian.setTanggal_pengembalian(result.getDate(2));
                    pengembalian.setJumlah_pengembalian(result.getString(3));
                    pengembalian.setDus(result.getString(4));
                    pengembalian.setId_regional(result.getString(5));
                    pengembalian.setId_produk(result.getString(6));
                    pengembalian.setStok_awal(result.getString(7));
                    pengembalian.setStok_akhir(result.getString(8));
                    pengembalian.setKeterangan(result.getString(9));
                    
                    //menambahkan data ke array
                    arrayPengembalian.add(pengembalian);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayPengembalian;
    }

    
}
