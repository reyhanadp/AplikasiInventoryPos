/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Mitra;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PenerimaanDAO {
    String getIdPenerimaan();
    ArrayList<Pemesanan> getNoPemesanan(String idPemesanan);
    ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk);
    ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk);
    ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk);
    ArrayList<Pemesanan> getIdPemesanan(String kodeProduk);
    ArrayList<Produk> getNamaProduk(String jenis_produk);
    ArrayList<Penerimaan> IsiPemesanan(String idPemesanan);
    ArrayList<Produk> getDetailProduk(Object noPemesanan);
    ArrayList<Pemesanan> getTotalPesan(Object noPemesanan);
    ArrayList<Penerimaan> cariProdukPenerimaan(String keyword, String jenisCari, String idJenis);
    boolean tambahPenerimaan(Penerimaan penerimaan);
    ArrayList<Penerimaan> getDataPenerimaan();
    ArrayList<Produk> getStok(String kode_produk);
    ArrayList<Produk> getNama(String kode_produk);
    ArrayList<Mitra> getNamaMitra(String id_mitra);
}
