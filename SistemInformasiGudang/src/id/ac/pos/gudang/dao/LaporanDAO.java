/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;

/**
 *
 * @author Operator
 */
public interface LaporanDAO {
    
    ArrayList<Produk> getProduk(String jenis_produk, String tahun);
    Integer getTotalProduk();
    ArrayList<Produk> getTahunTerkecil(String jenis_produk);
    Integer getBulanSekarang();
    Integer getTahunSekarang();
    Integer getJumlahTerima(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan);
    Integer getJumlahPengiriman(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan);
    Integer getJumlahPengembalian(String kode_produk, int bulan, Object tahun , int bulan_sekarang, int tahun_sekarang, String status, int pilihan);
    Integer getStokProduk(String kode_produk);
    String getLokasiSimpan(String nik);
    String getNama(String nik);
    boolean setLokasiSimpan(String nik, String lokasi);
    ArrayList<Produk> getTahunPengiriman();
    ArrayList<Produk> getTahunPenerimaan();
    ArrayList<Produk> getTahunPengembalian();
}
