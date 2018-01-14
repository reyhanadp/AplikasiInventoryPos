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
 * @author Oyoy
 */
public interface ProdukDAO {

    Integer getTahunSekarang();

    ArrayList<Produk> getProduk();

    ArrayList<Produk> getProdukDeleted();

    boolean restoreProduk(Produk produk, String idProduk);

    ArrayList<Produk> cariProduk(String keyword, String jenisCari, String idJenis);

    String getIdProduk(String jenisProduk);

    boolean tambahProduk(Produk produk, String jenisProduk);

    boolean hapusProduk(String idProduk);

    boolean ubahProduk(Produk produk);

}
