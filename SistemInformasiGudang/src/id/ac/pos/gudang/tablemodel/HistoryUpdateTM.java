/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oyoy
 */
public class HistoryUpdateTM extends AbstractTableModel {

    private ArrayList<Produk> arrayProduk;

    public void setDataProduk(ArrayList<Produk> arrayProduk) {
        this.arrayProduk = arrayProduk;
    }

    @Override
    public int getRowCount() {
        return arrayProduk.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return arrayProduk.get(rowIndex).getNo();
                
            case 1:
                return arrayProduk.get(rowIndex).getIdProduk();

            case 2:
                return arrayProduk.get(rowIndex).getNamaProduk();

            case 3:
                return arrayProduk.get(rowIndex).getNominal();

            case 4:
                return arrayProduk.get(rowIndex).getBiayaCetak();

            case 5:
                return arrayProduk.get(rowIndex).getStok();

            case 6:
                return arrayProduk.get(rowIndex).getTahun();

            case 7:
                return arrayProduk.get(rowIndex).getTglUbah();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No.";
            
            case 1:
                return "Id Produk";

            case 2:
                return "Nama Produk";

            case 3:
                return "Nominal";

            case 4:
                return "Biaya Cetak";

            case 5:
                return "Stok";

            case 6:
                return "Tahun";

            case 7:
                return "Tanggal Pengubahan";
        }
        return null;
    }
}
