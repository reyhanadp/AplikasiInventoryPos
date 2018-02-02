/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.dao;

import id.ac.pos.gudang.entity.Mitra;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;

/**
 *
 * @author muhamad solahudin
 */
public interface PemesananDAO {

    String getIdPemesanan();

    ArrayList<Pemesanan> cariProdukPemesanan(String keyword, String jenisCari, String idJenis);

    String getNoPemesanan();

    ArrayList<Produk> getProduk(Object pilihan, String jenis_produk);

    ArrayList<Mitra> getIdMitra(Object pilihan);

    ArrayList<Mitra> getMitra();

    boolean tambahPemesanan(Pemesanan pemesanan);

    ArrayList<Pemesanan> getPemesanan();

    ArrayList<Produk> getNamaProduk(String jenis_produk);

    ArrayList<Produk> getKodeProduk(Object nominal, Object tahun, Object nama_produk, String jenis_produk);

    ArrayList<Produk> getTahunProduk(Object nama_produk, String jenis_produk);

    ArrayList<Produk> getNominalProduk(Object nama_produk, Object tahun, String jenis_produk);

    ArrayList<Produk> getNama(String kode_produk);

    ArrayList<Mitra> getNamaMitra(String id_mitra);

}
