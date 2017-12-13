/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl.admin;

import id.ac.pos.gudang.dao.admin.MitraDAO;
import id.ac.pos.gudang.entity.Mitra;
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
public class MitraDAOImpl implements MitraDAO {

    private Connection conn;

    public MitraDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<Mitra> getMitra() {
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT * FROM tb_suplier";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    Mitra mitra = new Mitra();
                    mitra.setId_supplier(result.getString(1));
                    mitra.setNama_suplier(result.getString(2));
                    mitra.setAlamat(result.getString(3));
                    mitra.setNo_telp(result.getString(4));

                    //menambahkan data ke array
                    arrayMitra.add(mitra);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayMitra;
    }

    @Override
    public ArrayList<Mitra> cariMira(String keyword) {
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT * FROM tb_suplier "
                + "WHERE nama_suplier LIKE ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, keyword + "%");

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                // selama result memiliki data 
                // return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    Mitra regional = new Mitra();
                    regional.setId_supplier(result.getString(1));
                    regional.setNama_suplier(result.getString(2));
                    regional.setAlamat(result.getString(3));
                    regional.setNo_telp(result.getString(4));

                    //menambahkan data ke array
                    arrayMitra.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayMitra;
    }

    @Override
    public boolean tambahMitra(Mitra mitra) {
        String INSERT = "INSERT INTO tb_suplier (id_suplier, nama_suplier, "
                + "alamat, no_telp) VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, mitra.getId_supplier());
            state.setString(2, mitra.getNama_suplier());
            state.setString(3, mitra.getAlamat());
            state.setString(4, mitra.getNo_telp());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean hapusMitra(String idSuplie) {
        String DELETE = "DELETE FROM tb_suplier WHERE id_suplier = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idSuplie);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahMitra(Mitra mitra) {
        String UPDATE = "UPDATE tb_suplier "
                + "SET nama_suplier = ?, alamat = ?, no_telp = ? "
                + "WHERE id_suplier = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, mitra.getNama_suplier());
            state.setString(1, mitra.getAlamat());
            state.setString(1, mitra.getNo_telp());
            state.setString(2, mitra.getId_supplier());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
