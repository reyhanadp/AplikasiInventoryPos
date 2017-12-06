/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Suplier;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PemesananDAO {
    
    ArrayList<Produk> getProduk(Object pilihan, String jenis_produk);
    ArrayList<Suplier> getIsiSuplier(Object pilihan);
    ArrayList<Suplier> getSuplier();
    ArrayList<Pemesanan> getPemesanan(String jenis_produk);
    ArrayList<Produk> getNamaProduk(String jenis_produk);
    ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk);
    ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk);
    ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk);
    ArrayList<Produk> getNama(String kode_produk);
    ArrayList<Suplier> getNamaSuplier(String id_suplier);
    boolean tambahPemesanan(Pemesanan pemesanan);
    String getNoPemesanan();
    ArrayList<Pemesanan> cariProdukPemesanan(String keyword, String jenisCari, String idJenis);
}
