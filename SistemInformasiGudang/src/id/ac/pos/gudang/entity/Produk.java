/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.entity;

/**
 *
 * @author Oyoy
 */
public class Produk {
    String idProduk;
    String namaProduk;
    int nominal;
    float biayaCetak;
    int stok;
    String tahun;
    String idJenisProduk;

    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public float getBiayaCetak() {
        return biayaCetak;
    }

    public void setBiayaCetak(float biayaCetak) {
        this.biayaCetak = biayaCetak;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getIdJenisProduk() {
        return idJenisProduk;
    }

    public void setIdJenisProduk(String idJenisProduk) {
        this.idJenisProduk = idJenisProduk;
    }
    
    
}