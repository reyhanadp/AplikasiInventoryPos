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
public class Penerimaan {
    private String idPenerimaan;
    private String noOrder;
    private Date tglPenerimaan;
    private int jmlTerima;
    private String idPemesanan;
    private String idProduk;
    private String idMitra;
    private int stokAwal;
    private int stokAkhir;
    private int subTotalTerima;
    private int sisaBelumDikirim;
    private String keterangan;
    private String noPemesanan;
    private String namaProduk;
    private int nominal;
    private String tahun;
    private String namaMitra;

    public String getNamaMitra() {
        return namaMitra;
    }

    public void setNamaMitra(String namaMitra) {
        this.namaMitra = namaMitra;
    }

    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
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

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }
    
    public String getIdPenerimaan() {
        return idPenerimaan;
    }

    public void setIdPenerimaan(String idPenerimaan) {
        this.idPenerimaan = idPenerimaan;
    }

    public Date getTglPenerimaan() {
        return tglPenerimaan;
    }

    public void setTglPenerimaan(Date tglPenerimaan) {
        this.tglPenerimaan = tglPenerimaan;
    }

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public int getJmlTerima() {
        return jmlTerima;
    }

    public void setJmlTerima(int jmlTerima) {
        this.jmlTerima = jmlTerima;
    }

    public String getIdPemesanan() {
        return idPemesanan;
    }

    public void setIdPemesanan(String noPemesanan) {
        this.idPemesanan = noPemesanan;
    }

    public String getIdMitra() {
        return idMitra;
    }

    public void setIdMitra(String idMitra) {
        this.idMitra = idMitra;
    }

    
    public int getStokAwal() {
        return stokAwal;
    }

    public void setStokAwal(int stokAwal) {
        this.stokAwal = stokAwal;
    }

    public int getStokAkhir() {
        return stokAkhir;
    }

    public void setStokAkhir(int stokAkhir) {
        this.stokAkhir = stokAkhir;
    }

    public int getSubTotalTerima() {
        return subTotalTerima;
    }

    public void setSubTotalTerima(int sunTotalTerima) {
        this.subTotalTerima = sunTotalTerima;
    }

    public int getSisaBelumDikirim() {
        return sisaBelumDikirim;
    }

    public void setSisaBelumDikirim(int sisaBelumDikirim) {
        this.sisaBelumDikirim = sisaBelumDikirim;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public String getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(String idProduk) {
        this.idProduk = idProduk;
    }
    
}
