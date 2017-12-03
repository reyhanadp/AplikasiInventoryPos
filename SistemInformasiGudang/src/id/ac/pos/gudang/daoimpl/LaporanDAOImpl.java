/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.LaporanDAO;
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
 * @author Operator
 */
public class LaporanDAOImpl implements LaporanDAO{
    ArrayList<Produk> arrayProduk = null;
    private Connection conn;

    public LaporanDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }
    
    @Override
    public ArrayList<Produk> getProduk(String jenis_produk, String tahun) {
        String SELECT = "SELECT nama_produk,nominal,biaya_cetak FROM tb_produk where tahun='"+tahun+"' and id_jenis_produk='"+jenis_produk+"' order by nama_produk asc";
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
                    produk.setBiayaCetak(Integer.parseInt(result.getString(3)));

                    //menambahkan data ke array
                    arrayProduk.add(produk);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProduk;
    }

    @Override
    public ArrayList<Produk> getTahunTerkecil() {
        String SELECT = "SELECT DISTINCT(tahun) FROM `tb_produk` WHERE id_jenis_produk='PR' order by tahun ASC";
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
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arrayProduk;
    }
    
}
