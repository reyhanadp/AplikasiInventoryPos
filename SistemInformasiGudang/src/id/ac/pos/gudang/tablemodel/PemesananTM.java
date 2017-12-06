/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

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
public class PemesananTM extends AbstractTableModel{
 
    private ArrayList<Pemesanan> arrayPemesanan;
    Vector vector_nama_produk,vector_nama_suplier,vector_nominal,vector_tahun;

    public void setDataPemesanan(ArrayList<Pemesanan> arrayPemesanan,  Vector vector_nama_produk, Vector vector_nama_suplier, Vector vector_nominal, Vector vector_tahun) {
        this.arrayPemesanan = arrayPemesanan;
        this.vector_nama_produk = vector_nama_produk;
        this.vector_nama_suplier = vector_nama_suplier;
        this.vector_nominal = vector_nominal;
        this.vector_tahun = vector_tahun;
    }

    @Override
    public int getRowCount() {
        return arrayPemesanan.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPemesanan.get(rowIndex).getNoPemesanan();

            case 1:
                return arrayPemesanan.get(rowIndex).getTglPemesanan();

            case 2:
                return arrayPemesanan.get(rowIndex).getKodeProduk();

            case 3:
                return vector_nama_produk.get(rowIndex);
                                
            case 4:
                return vector_nominal.get(rowIndex);

            case 5:
                return vector_tahun.get(rowIndex);
                              
            case 6:
                return arrayPemesanan.get(rowIndex).getIdSuplier();

            case 7:
                return vector_nama_suplier.get(rowIndex);
                
            case 8:
                return arrayPemesanan.get(rowIndex).getJumlahPemesanan();
   
            case 9:
                return arrayPemesanan.get(rowIndex).getStatus();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Pemesanan";

            case 1:
                return "Tanggal";

            case 2:
                return "Kode Produk";

            case 3:
                return "Nama Produk";
                
            case 4:
                return "Nominal";

            case 5:
                return "Tahun";
                
            case 6:
                return "Id Suplier";

            case 7:
                return "Nama Suplier";
                
            case 8:
                return "Jumlah Pemesanan";

            case 9:
                return "Status";
        }
        return null;
    }
}
