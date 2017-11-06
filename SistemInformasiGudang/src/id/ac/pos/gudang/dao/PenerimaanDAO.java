/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PenerimaanDAO {
    
    boolean tambahPenerimaan(Penerimaan penerimaan);
    ArrayList<Penerimaan> getDataPenerimaanPrangko();
    
}
