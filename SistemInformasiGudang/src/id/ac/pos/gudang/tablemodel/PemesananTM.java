/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Pemesanan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author muhamad solahudin
 */
public class PemesananTM extends AbstractTableModel{
 
    private ArrayList<Pemesanan> arrayPemesanan;

    public void setDataPemesanan(ArrayList<Pemesanan> arrayPemesanan) {
        this.arrayPemesanan = arrayPemesanan;
        
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
                return arrayPemesanan.get(rowIndex).getIdPemesanan();
                
            case 1:
                return arrayPemesanan.get(rowIndex).getNoPemesanan();

            case 2:
                return arrayPemesanan.get(rowIndex).getTglPemesanan();

            case 3:
                return arrayPemesanan.get(rowIndex).getKodeProduk();

            case 4:
                return arrayPemesanan.get(rowIndex).getNamaProduk();
                                
            case 5:
                return arrayPemesanan.get(rowIndex).getNominal();

            case 6:
                return arrayPemesanan.get(rowIndex).getTahun();
                              
            case 7:
                return arrayPemesanan.get(rowIndex).getNamaMitra();
                
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
                return "Id Pemesanan";
                
            case 1:
                return "No Pemesanan";

            case 2:
                return "Tanggal";

            case 3:
                return "Kode Produk";

            case 4:
                return "Nama Produk";
                
            case 5:
                return "Nominal";

            case 6:
                return "Tahun";

            case 7:
                return "Nama Mitra";
                
            case 8:
                return "Jumlah Pemesanan";

            case 9:
                return "Status";
        }
        return null;
    }
}
