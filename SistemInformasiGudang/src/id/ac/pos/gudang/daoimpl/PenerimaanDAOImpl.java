/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.daoimpl;

import id.ac.pos.gudang.dao.PemesananDAO;
import id.ac.pos.gudang.dao.PenerimaanDAO;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
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
public class PenerimaanDAOImpl implements PenerimaanDAO {
    
    private Connection conn;
    
    public PenerimaanDAOImpl() {
         conn = DatabaseConnectivity.getConnection();
    }
    
    public boolean tambahPenerimaan(Penerimaan penerimaan){
        String INSERT = "INSERT INTO tb_trans_penerimaan (no_order,tgl_penerimaan, jml_terima, no_pemesanan,"
                + "id_produk, id_suplier, stok_awal, stok_akhir, subtotal_terima,sisa_belum_dikirim, keterangan"
                + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
        PreparedStatement state = null;
        
        try {
            state = conn.prepareStatement(INSERT);
            state.setString(1, penerimaan.getNoOrder());
            state.setString(2, penerimaan.getTglPenerimaan());
            state.setInt(3, penerimaan.getJmlTerima());
            state.setString(4,penerimaan.getNoPemesanan());
            state.setString(5, penerimaan.getIdProduk());
            state.setString(6, penerimaan.getIdSuplier());
            state.setInt(7, penerimaan.getStokAwal());
            state.setInt(8, penerimaan.getStokAkhir());
            state.setInt(9, penerimaan.getSubTotalTerima());
            state.setInt(10, penerimaan.getSisaBelumDikirim());
            state.setString(11, penerimaan.getKeterangan());
            
            int qty = state.executeUpdate();
            return qty > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
    
    public ArrayList<Penerimaan> getDataPenerimaanPrangko() {
        ArrayList<Penerimaan> arrayPenerimaan = null;
        String SELECT = "SELECT * FROM tb_trans_penerimaan";
        PreparedStatement state = null;

        try {
            state = conn.prepareStatement(SELECT);
            
            ResultSet result = state.executeQuery();
            
            if (result != null) {
                arrayPenerimaan = new ArrayList<>();
                
                //selama result memiliki data
                //return lebih dari 1 data
                while (result.next()) {
                    //mengambil 1 data
                    Penerimaan penerimaan = new Penerimaan();
                    penerimaan.setNoOrder(result.getString("no_order"));
                    penerimaan.setTglPenerimaan(result.getString("tgl_penerimaan"));
                    penerimaan.setJmlTerima(result.getInt("jml_terima"));
                    penerimaan.setNoPemesanan(result.getString("no_pemesanan"));
                    penerimaan.setIdProduk(result.getString("id_produk"));
                    penerimaan.setIdSuplier(result.getString("id_suplier"));
                    penerimaan.setStokAwal(result.getInt("stok_awal"));
                    penerimaan.setStokAkhir(result.getInt("stok_akhir"));
                    penerimaan.setSubTotalTerima(result.getInt("subtotal_terima"));
                    penerimaan.setSisaBelumDikirim(result.getInt("sisa_belum_dikirim"));
                    penerimaan.setKeterangan(result.getString("keterangan"));
                    
                    //menambahkan data ke array
                    arrayPenerimaan.add(penerimaan);
                }
            }
        } catch (SQLException ex) {

            Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenerimaanDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arrayPenerimaan;
    }
    
}
