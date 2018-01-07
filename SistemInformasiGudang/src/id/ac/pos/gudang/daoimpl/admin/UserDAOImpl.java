/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl.admin;

import id.ac.pos.gudang.dao.admin.UserDAO;
import id.ac.pos.gudang.entity.User;
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
public class UserDAOImpl implements UserDAO {

    private Connection conn;

    public UserDAOImpl() {
        conn = DatabaseConnectivity.getConnection();
    }

    @Override
    public ArrayList<User> getUser() {
        ArrayList<User> arrayUser = null;
        String SELECT = "SELECT * FROM tb_user";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);

            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayUser = new ArrayList<>();

                //selama result memiliki data 
                // return lebih dari 1 data 
                while (result.next()) {

                    //mengambil 1 data
                    User user = new User();
                    user.setNik(result.getString(1));
                    user.setPassword(result.getString(2));
                    user.setNamaUser(result.getString(3));
                    user.setHakAkses(result.getString(4));
                    user.setStatus(result.getString(5));

                    //menambahkan data ke array
                    arrayUser.add(user);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayUser;
    }

    @Override
    public boolean tambahUser(User user) {
        String INSERT = "INSERT INTO tb_user (nik, password, "
                + "nama_user, hak_akses) VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, user.getNik());
            state.setString(2, user.getPassword());
            state.setString(3, user.getNamaUser());
            state.setString(4, user.getHakAkses());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /*@Override
    public boolean hapusUser(String nik) {
        String DELETE = "DELETE FROM tb_user WHERE nik = ?";
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, nik);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    @Override
    public boolean ubahUser(User user) {
        String UPDATE = "UPDATE tb_user "
                + "SET password = ?, nama_user = ?, "
                + "hak_akses = ? , status = ? "
                + "WHERE nik = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, user.getPassword());
            state.setString(2, user.getNamaUser());
            state.setString(3, user.getHakAkses());
            state.setString(4, user.getStatus());
            state.setString(5, user.getNik());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
