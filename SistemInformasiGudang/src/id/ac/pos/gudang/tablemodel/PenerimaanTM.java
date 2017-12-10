/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Penerimaan;
import id.ac.pos.gudang.entity.Pemesanan;
import id.ac.pos.gudang.entity.Produk;
import id.ac.pos.gudang.entity.Suplier;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author muhamad solahudin
 */
public class PenerimaanTM extends AbstractTableModel{
    private ArrayList<Penerimaan> arrayPenerimaan;
      Vector vector_nama_produk,vector_nama_suplier,vector_nominal,vector_tahun;

    
    public void setDataPenerimaan(ArrayList<Penerimaan> arrayPenerimaan,Vector vector_nama_produk, Vector vector_nama_suplier, Vector vector_nominal, Vector vector_tahun) {
        this.arrayPenerimaan = arrayPenerimaan;
        this.vector_nama_produk = vector_nama_produk;
        this.vector_nama_suplier = vector_nama_suplier;
        this.vector_nominal = vector_nominal;
        this.vector_tahun = vector_tahun;
    }

    @Override
    public int getRowCount() {
        return arrayPenerimaan.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 14;  //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return arrayPenerimaan.get(rowIndex).getNoOrder();

            case 1:
                return arrayPenerimaan.get(rowIndex).getTglPenerimaan();

            case 2:
                return arrayPenerimaan.get(rowIndex).getJmlTerima();

            case 3:
                return arrayPenerimaan.get(rowIndex).getNoPemesanan();

            case 4:
                return arrayPenerimaan.get(rowIndex).getIdProduk();    
            
            case 5:
                return vector_nama_produk.get(rowIndex);    
                                
            case 6:
                return vector_nominal.get(rowIndex);

            case 7:
                return vector_tahun.get(rowIndex);
                              
            case 8:
                return vector_nama_suplier.get(rowIndex);
                
            case 9:
                return arrayPenerimaan.get(rowIndex).getStokAwal();

            case 10:
                return arrayPenerimaan.get(rowIndex).getStokAkhir();

            case 11:
                return arrayPenerimaan.get(rowIndex).getSubTotalTerima();

            case 12:
                return arrayPenerimaan.get(rowIndex).getSisaBelumDikirim();

            case 13:
                return arrayPenerimaan.get(rowIndex).getKeterangan();    
        }
        return null;
    }  
        @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Order";
                
            case 1:
                return "Tanggal Penerimaan";
                
            case 2:
                return "Jumlah Terima";
                
            case 3:
                return "No. Pemesanan";
                
            case 4:
                return "Kode_Produk";
            
            case 5:
                return "Nama Produk";
                
            case 6:
                return "Nominal";

            case 7:
                return "Tahun";    
                
            case 8:
                return "Nama Suplier";
                  
            case 9:
                return "Stok Awal";
                
            case 10:
                return "Stok Akhir";
                
            case 11:
                return "Subtotal Terima";
                
            case 12:
                return "Sisa Belum dikirim";
                
            case 13:
                return "keterangan";
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

}
