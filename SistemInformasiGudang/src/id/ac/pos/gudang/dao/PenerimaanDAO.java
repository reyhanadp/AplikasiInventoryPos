/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Penerimaan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Suplier;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PenerimaanDAO {
    
    boolean tambahPenerimaan(Penerimaan penerimaan);
    ArrayList<Penerimaan> cariProdukPenerimaan(String keyword, String jenisCari, String idJenis);
    ArrayList<Penerimaan> getDataPenerimaan(String jenis_produk);
    ArrayList<Penerimaan> IsiPemesanan(String noPemesanan);
    ArrayList<Produk> getNama(String kode_produk);
    ArrayList<Suplier> getNamaSuplier(String id_suplier);
    ArrayList<Produk> getDetailProduk(Object noPemesanan);
    ArrayList<Pemesanan> getTotalPesan(Object noPemesanan);
    ArrayList<Produk> getNamaProduk(String jenis_produk);
    ArrayList<Pemesanan> getNoPemesanan(String kodeProduk);
    ArrayList<Produk> getStok(String kode_produk);
}
