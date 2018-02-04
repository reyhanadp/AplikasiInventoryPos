/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl.admin;

import id.ac.pos.gudang.dao.admin.RegionalDAO;
import id.ac.pos.gudang.entity.Regional;
import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.io.IOException;
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

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    @Override
    public ArrayList<Regional> getRegional() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
                    regional.setIdRegional(result.getString(1));
                    regional.setNamaRegional(result.getString(2));
                    regional.setKodePos(result.getString(3));
                    regional.setNoTelp(result.getString(4));
                    regional.setAlamat(result.getString(5));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }

        return arrayRegional;
    }

    @Override
    public ArrayList<Regional> cariRegional(String keyword) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    regional.setNamaRegional(result.getString(2));
                    regional.setKodePos(result.getString(3));
                    regional.setNoTelp(result.getString(4));
                    regional.setAlamat(result.getString(5));

                    //menambahkan data ke array
                    arrayRegional.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrayRegional;
    }

    @Override
    public boolean tambahRegional(Regional regional) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "INSERT INTO tb_regional (id_regional, regional, "
                + "kode_pos, no_telp, alamat) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, regional.getIdRegional());
            state.setString(2, regional.getNamaRegional());
            state.setString(3, regional.getKodePos());
            state.setString(4, regional.getNoTelp());
            state.setString(5, regional.getAlamat());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return false;
    }

    /*@Override
    public boolean hapusRegional(String idRegional) {
        String DELETE = "DELETE FROM tb_regional WHERE id_regional = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idRegional);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    @Override
    public boolean ubahRegional(Regional regional) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String UPDATE = "UPDATE tb_regional "
                + "SET regional = ?, kode_pos = ?, alamat = ?, no_telp = ? "
                + "WHERE id_regional = ?";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, regional.getNamaRegional());
            state.setString(2, regional.getKodePos());
            state.setString(3, regional.getAlamat());
            state.setString(4, regional.getNoTelp());
            state.setString(5, regional.getIdRegional());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(RegionalDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return false;
    }

}
