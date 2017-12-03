/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Regional;
import java.util.ArrayList;

/**
 *
 * @author Operator
 */
public interface PengembalianDAO {
    
    ArrayList<Produk> getNama(String kode_produk);
    ArrayList<Produk> getKodeProduk(Object nominal,Object tahun, Object nama_produk, String jenis_produk);
    ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk);
    ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk);
    ArrayList<Produk> getNamaProduk(String jenis_produk);
    ArrayList<Regional> getRegional();
    ArrayList<Pengembalian> getPengembalian(String jenis_produk);
    ArrayList<Regional> getIsiRegional(Object pilihan);
    ArrayList<Produk> getProduk(Object pilihan, String jenis_produk);
    boolean tambahPengembalian(Pengembalian pengembalian);
    String getIdPengembalian();
}
