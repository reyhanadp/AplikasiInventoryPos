/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.RegionalDAO;
import id.ac.pos.gudang.entity.Regional;
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
public class RegionalDAOImpl implements RegionalDAO {

    private Connection conn;

    public RegionalDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
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
                    regional.setIdRegional(result.getString(1));
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
    public ArrayList<Regional> cariRegional(String keyword) {
        ArrayList<Regional> arrayRegional = null;
        String SELECT = "SELECT * FROM tb_regional "
                + "WHERE regional LIKE ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            state.setString(1, keyword + "%");

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayRegional = new ArrayList<>();

                // selama result memiliki data 
                // return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    Regional regional = new Regional();
                    regional.setIdRegional(result.getString(1));
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
    public boolean tambahRegional(Regional regional) {
        String INSERT = "INSERT INTO tb_regional (id_regional, regional) VALUES (?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, regional.getIdRegional());
            state.setString(2, regional.getRegional());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean hapusRegional(int idRegional) {
        String DELETE = "DELETE FROM tb_regional WHERE id_regional = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setInt(1, idRegional);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean ubahRegional(Regional regional) {
        String UPDATE = "UPDATE tb_regional "
                + "SET regional = ? "
                + "WHERE id_regional = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, regional.getRegional());
            state.setString(2, regional.getIdRegional());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
