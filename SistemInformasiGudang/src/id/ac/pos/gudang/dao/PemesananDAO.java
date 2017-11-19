/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pemesanan;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PemesananDAO {
    
    String getNoPemesanan();
    
    ArrayList<Pemesanan> cariProdukPemesanan(String keyword, String jenisCari, String idJenis);
    
    boolean tambahPemesanan(Pemesanan pemesanan, String jenisProduk);
    
    ArrayList<Pemesanan> getDataPemesananPrangko();
    
    ArrayList<Pemesanan> getDataPemesananMS_SS();
    
    ArrayList<Pemesanan> getDataPemesananKemasan();
    
    ArrayList<Pemesanan> getDataPemesananMerchandise();
    
    ArrayList<Pemesanan> getDataPemesananPrisma();
    
    ArrayList<Pemesanan> getDataPemesananDokumenFilateli();
    
    ArrayList<Pemesanan> getDataPemesananSHP_SHPSS();
}
