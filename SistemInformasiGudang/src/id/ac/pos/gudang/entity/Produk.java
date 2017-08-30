/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.entity;

import java.util.Date;

/**
 *
 * @author Oyoy
 */
public class Produk {
    
    int no;
    String idProduk;
    String namaProduk;
    int nominal;
    float biayaCetak;
    int stok;
    String tahun;
    String idJenisProduk;
    Date tglHapus;
    Date tglUbah;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Date getTglUbah() {
        return tglUbah;
    }

    public void setTglUbah(Date tglUbah) {
        this.tglUbah = tglUbah;
    }
    
    public Date getTglHapus() {
        return tglHapus;
    }

    public void setTglHapus(Date tglHapus) {
        this.tglHapus = tglHapus;
    }

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
