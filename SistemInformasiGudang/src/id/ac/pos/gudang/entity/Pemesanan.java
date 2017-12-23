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
    private String idPemesanan;
    private String noPemesanan;
    private String kodeProduk;
    private Date TglPemesanan;
    private String jumlahPemesanan;
    private String idSuplier;
    private String status;

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(String idPemesanan) {
        this.idPemesanan = idPemesanan;
    }

    public String getKodeProduk() {
        return kodeProduk;
    }

    public void setKodeProduk(String kodeProduk) {
        this.kodeProduk = kodeProduk;
    }

    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
    }

    public Date getTglPemesanan() {
        return TglPemesanan;
    }

    public void setTglPemesanan(Date TglPemesanan) {
        this.TglPemesanan = TglPemesanan;
    }

    public String getJumlahPemesanan() {
        return jumlahPemesanan;
    }

    public void setJumlahPemesanan(String jumlahPemesanan) {
        this.jumlahPemesanan = jumlahPemesanan;
    }

    public String getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(String idSuplier) {
        this.idSuplier = idSuplier;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
