/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

import java.util.Date;

/**
 *
 * @author muhamad solahudin
 */
public class Pemesanan {
    String noPemesanan;
    String kodeProduk;
    String namaProduk;
    int nominal;
    float biayaCetak;
    int stok;
    String tahun;
    String idJenisProduk;
    String TglPemesanan;
    int jumlahPemesanan;
    String idSuplier;

    public String getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(String idSuplier) {
        this.idSuplier = idSuplier;
    }

    public String getTglPemesanan() {
        return TglPemesanan;
    }

    public void setTglPemesanan(String TglPemesanan) {
        this.TglPemesanan = TglPemesanan;
    }

    public int getJumlahPemesanan() {
        return jumlahPemesanan;
    }

    public void setJumlahPemesanan(int jumlahPemesanan) {
        this.jumlahPemesanan = jumlahPemesanan;
    }

    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
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

    public void getNoPemesananarray(String noPemesanan) {
        this.noPemesanan=noPemesanan; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
