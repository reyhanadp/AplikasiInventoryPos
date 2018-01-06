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
    private String idMitra;
    private String status;
    private String NamaProduk;
    private int nominal;
    private String tahun;
    private String namaMitra;

    public String getIdMitra() {
        return idMitra;
    }

    public void setIdMitra(String idMitra) {
        this.idMitra = idMitra;
    }

    public String getNamaMitra() {
        return namaMitra;
    }

    public void setNamaMitra(String namaMitra) {
        this.namaMitra = namaMitra;
    }

    public String getNamaProduk() {
        return NamaProduk;
    }

    public void setNamaProduk(String NamaProduk) {
        this.NamaProduk = NamaProduk;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
