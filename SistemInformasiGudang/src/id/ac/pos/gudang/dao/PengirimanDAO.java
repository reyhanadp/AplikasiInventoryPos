/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pengiriman;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author reyha
 */
public interface PengirimanDAO {
    Vector getViewDetailPengiriman(String id_pengiriman);
    ArrayList<Produk> getNamaProduk(String jenis_produk);
    ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk);
    ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk);
    ArrayList<Produk> getKodeProduk(Object nominal,Object tahun, Object nama_produk, String jenis_produk);
    ArrayList<Regional> getIsiRegional(Object nama_regional);
    ArrayList<Regional> getRegional();
    String getIdPengiriman();
    int getStok(String kode_produk);
    boolean tambahPengiriman(Pengiriman pengiriman);
    ArrayList<Pengiriman> getPengiriman(String jenis_produk);
    ArrayList<Pengiriman> cariProdukPengiriman(String keyword, String jenisCari, String idJenis);
    
}
