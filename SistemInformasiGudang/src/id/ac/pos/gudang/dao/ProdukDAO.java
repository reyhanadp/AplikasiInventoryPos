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

    ArrayList<Produk> getProdukPrangko();

    ArrayList<Produk> getProdukKemasan();

    ArrayList<Produk> getProdukMS_SS();

    ArrayList<Produk> getProdukSHP_SHPSS();

    ArrayList<Produk> getProdukMerchandise();

    ArrayList<Produk> getProdukPrisma();

    ArrayList<Produk> getProdukDokumenFilateli();

    ArrayList<Produk> getProdukPrangkoDeleted();

    ArrayList<Produk> getProdukMSSSDeleted();

    ArrayList<Produk> getProdukSHPSHPSSDeleted();

    ArrayList<Produk> getProdukMerchandiseDeleted();

    ArrayList<Produk> getProdukKemasanDeleted();

    ArrayList<Produk> getProdukPrismaDeleted();

    ArrayList<Produk> getProdukDokumenFilateliDeleted();
    
    ArrayList<Produk> getHistoryUpdate();
    
    ArrayList<Produk> getHistoryDelete();

    boolean restoreProduk(Produk produk, String jenisProduk);
    
    boolean hapusPermanent(String idProduk);

    ArrayList<Produk> cariProduk(String keyword, String jenisCari, String idJenis);

    String getIdProduk(String jenisProduk);

    boolean tambahProduk(Produk produk, String jenisProduk);

    boolean hapusProduk(String idProduk);
    
    boolean hapusHistoryUpdate();
    
    boolean hapusHistoryDelete();
    
    boolean ubahProduk(Produk produk);

}
