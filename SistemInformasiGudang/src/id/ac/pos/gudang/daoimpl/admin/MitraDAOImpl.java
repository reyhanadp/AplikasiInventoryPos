/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl.admin;

import id.ac.pos.gudang.dao.admin.MitraDAO;
import id.ac.pos.gudang.entity.Mitra;
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
 * @author muhamad solahudin
 */
public class MitraDAOImpl implements MitraDAO {

    ResultSet result;
    private Connection conn;
    PreparedStatement state;

    @Override
    public ArrayList<Mitra> getMitra() {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT * FROM tb_mitra";
        state = null;

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
                    mitra.setId_mitra(result.getString(1));
                    mitra.setNama_mitra(result.getString(2));
                    mitra.setAlamat(result.getString(3));
                    mitra.setNo_telp(result.getString(4));

                    //menambahkan data ke array
                    arrayMitra.add(mitra);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrayMitra;
    }

    @Override
    public ArrayList<Mitra> cariMitra(String keyword) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Mitra> arrayMitra = null;
        String SELECT = "SELECT * FROM tb_mitra "
                + "WHERE nama_mitra LIKE '%"+keyword+"%'";
        PreparedStatement state = null;
        try {
            state = conn.prepareStatement(SELECT);
            ResultSet result = state.executeQuery();
            if (result != null) {
                arrayMitra = new ArrayList<>();

                // selama result memiliki data 
                // return lebih dari 1 data
                while (result.next()) {

                    //mengambil 1 data
                    Mitra regional = new Mitra();
                    regional.setId_mitra(result.getString(1));
                    regional.setNama_mitra(result.getString(2));
                    regional.setAlamat(result.getString(3));
                    regional.setNo_telp(result.getString(4));

                    //menambahkan data ke array
                    arrayMitra.add(regional);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return arrayMitra;
    }

    @Override
    public boolean tambahMitra(Mitra mitra) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String INSERT = "INSERT INTO tb_mitra (id_mitra, nama_mitra, "
                + "alamat, no_telp) VALUES (?, ?, ?, ?)";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, mitra.getId_mitra());
            state.setString(2, mitra.getNama_mitra());
            state.setString(3, mitra.getAlamat());
            state.setString(4, mitra.getNo_telp());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return false;
    }

    /*@Override
    public boolean hapusMitra(String idSuplier) {
        String DELETE = "DELETE FROM tb_mitra WHERE id_mitra = '?'";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(DELETE);
            state.setString(1, idSuplier);

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }*/

    @Override
    public boolean ubahMitra(Mitra mitra) {
        try {
            conn = DatabaseConnectivity.getConnection();
        } catch (IOException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        String UPDATE = "UPDATE tb_mitra "
                + "SET nama_mitra = ?, alamat = ?, no_telp = ? "
                + "WHERE id_mitra = ?";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(UPDATE);
            state.setString(1, mitra.getNama_mitra());
            state.setString(2, mitra.getAlamat());
            state.setString(3, mitra.getNo_telp());
            state.setString(4, mitra.getId_mitra());

            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MitraDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        return false;
    }

}
