/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

import java.util.Date;

/**
 *
 * @author reyha
 */
public class Pengiriman {
    String id_pengiriman;
    String no_order_pengiriman;
    Date tgl_pengiriman;
    int jumlah_pengiriman;
    String bsu;
    String id_regional;
    String id_produk;
    int stok_awal;
    int stok_akhir;

    public void setStok_akhir(int stok_akhir) {
        this.stok_akhir = stok_akhir;
    }
    
    public String getId_pengiriman() {
        return id_pengiriman;
    }

    public void setId_pengiriman(String id_pengiriman) {
        this.id_pengiriman = id_pengiriman;
    }

    public String getNo_order_pengiriman() {
        return no_order_pengiriman;
    }

    public void setNo_order_pengiriman(String no_order_pengiriman) {
        this.no_order_pengiriman = no_order_pengiriman;
    }

    public Date getTgl_pengiriman() {
        return tgl_pengiriman;
    }

    public void setTgl_pengiriman(Date tgl_pengiriman) {
        this.tgl_pengiriman = tgl_pengiriman;
    }

    public int getJumlah_pengiriman() {
        return jumlah_pengiriman;
    }

    public void setJumlah_pengiriman(int jumlah_pengiriman) {
        this.jumlah_pengiriman = jumlah_pengiriman;
    }

    public String getBsu() {
        return bsu;
    }

    public void setBsu(String bsu) {
        this.bsu = bsu;
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

    public int getStok_awal() {
        return stok_awal;
    }

    public void setStok_awal(int stok_awal) {
        this.stok_awal = stok_awal;
    }

    public int getStok_akhir() {
        this.stok_akhir = this.stok_awal - this.jumlah_pengiriman;
        return stok_akhir;
    }
    
    
}
