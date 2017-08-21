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

    ArrayList<Produk> cariProduk(String keyword);

    boolean tambahProduk(Produk produk);

    boolean hapusProduk(int idProduk);

    boolean ubahProduk(Produk produk);

}
