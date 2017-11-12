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
    String id_pengembalian;
    Date tanggal_pengembalian;
    String jumlah_pengembalian;
    String dus;
    String id_regional;
    String id_produk;
    String stok_awal;
    String stok_akhir;
    String keterangan;

    public String getId_pengembalian() {
        return id_pengembalian;
    }

    public void setStok_akhir(String stok_akhir) {
        this.stok_akhir = stok_akhir;
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

    public String getJumlah_pengembalian() {
        return jumlah_pengembalian;
    }

    public void setJumlah_pengembalian(String jumlah_pengembalian) {
        this.jumlah_pengembalian = jumlah_pengembalian;
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

    public String getStok_awal() {
        return stok_awal;
    }

    public void setStok_awal(String stok_awal) {
        this.stok_awal = stok_awal;
    }

    public String getStok_akhir() {
        Integer stok_awal_integer = Integer.parseInt(this.stok_awal);
        Integer jumlah_pengembalian_integer = Integer.parseInt(this.jumlah_pengembalian);
        Integer stok_akhir_integer = stok_awal_integer + jumlah_pengembalian_integer;
        this.stok_akhir = Integer.toString(stok_akhir_integer);
        return stok_akhir;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    
}
