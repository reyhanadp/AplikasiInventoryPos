/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.entity;

/**
 *
 * @author muhamad solahudin
 */
public class Penerimaan {
    String noOrder;
    String tglPenerimaan;
    int jmlTerima;
    String noPemesanan;
    String idProduk;
    String idSuplier;
    int stokAwal;
    int stokAkhir;
    int subTotalTerima;
    int sisaBelumDikirim;
    String keterangan;

    public String getNoOrder() {
        return noOrder;
    }

    public void setNoOrder(String noOrder) {
        this.noOrder = noOrder;
    }

    public String getTglPenerimaan() {
        return tglPenerimaan;
    }

    public void setTglPenerimaan(String tglPenerimaan) {
        this.tglPenerimaan = tglPenerimaan;
    }

    public int getJmlTerima() {
        return jmlTerima;
    }

    public void setJmlTerima(int jmlTerima) {
        this.jmlTerima = jmlTerima;
    }

    public String getNoPemesanan() {
        return noPemesanan;
    }

    public void setNoPemesanan(String noPemesanan) {
        this.noPemesanan = noPemesanan;
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
