/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

import java.util.Date;

/**
 *
 * @author Operator
 */
public class Pengembalian {
    private String id_pengembalian;
    private Date tanggal_pengembalian;
    private int jumlah_pengembalian;
    private String dus;
    private String id_regional;
    private String id_produk;
    private int stok_awal;
    private int stok_akhir;
    private String keterangan;
    private String nama_produk;

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getId_pengembalian() {
        return id_pengembalian;
    }



    public void setId_pengembalian(String id_pengembalian) {
        this.id_pengembalian = id_pengembalian;
    }

    public Date getTanggal_pengembalian() {
        return tanggal_pengembalian;
    }

    public void setTanggal_pengembalian(Date tanggal_pengembalian) {
        this.tanggal_pengembalian = tanggal_pengembalian;
    }





    public String getDus() {
        return dus;
    }

    public void setDus(String dus) {
        this.dus = dus;
    }

    public String getId_regional() {
        return id_regional;
    }

    public void setId_regional(String id_regional) {
        this.id_regional = id_regional;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public int getJumlah_pengembalian() {
        return jumlah_pengembalian;
    }

    public void setJumlah_pengembalian(int jumlah_pengembalian) {
        this.jumlah_pengembalian = jumlah_pengembalian;
    }

    public int getStok_awal() {
        return stok_awal;
    }

    public void setStok_awal(int stok_awal) {
        this.stok_awal = stok_awal;
    }

    public int getStok_akhir() {
        this.stok_akhir = this.stok_awal + this.jumlah_pengembalian;
        return this.stok_akhir;
    }

    public void setStok_akhir(int stok_akhir) {
        this.stok_akhir = this.stok_awal + this.jumlah_pengembalian;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
