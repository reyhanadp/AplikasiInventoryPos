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
    String idPenerimaan;
    String noOrder;
    Date tglPenerimaan;
    int jmlTerima;
    String idPemesanan;
    String idProduk;
    String idSuplier;
    int stokAwal;
    int stokAkhir;
    int subTotalTerima;
    int sisaBelumDikirim;
    String keterangan;

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

    public String getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(String idSuplier) {
        this.idSuplier = idSuplier;
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
