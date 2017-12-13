/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Pengiriman;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reyha
 */
public class PengirimanTM extends AbstractTableModel {
    private ArrayList<Pengiriman> arrayPengiriman;
    Vector vector_nama_produk;

    public void setDataPengiriman(ArrayList<Pengiriman> arrayPengiriman,  Vector vector_nama_produk) {
        this.arrayPengiriman = arrayPengiriman;
        this.vector_nama_produk = vector_nama_produk;
    }

    @Override
    public int getRowCount() {
        return arrayPengiriman.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPengiriman.get(rowIndex).getId_pengiriman();

            case 1:
                return arrayPengiriman.get(rowIndex).getNo_order_pengiriman();

            case 2:
                return arrayPengiriman.get(rowIndex).getTgl_pengiriman();

            case 3:
                return arrayPengiriman.get(rowIndex).getJumlah_pengiriman();

            case 4:
                return arrayPengiriman.get(rowIndex).getBsu();

            case 5:
                return arrayPengiriman.get(rowIndex).getId_regional();
            
            case 6:
                return arrayPengiriman.get(rowIndex).getId_produk();
                
            case 7:
                return vector_nama_produk.get(rowIndex);
                
            case 8:
                return arrayPengiriman.get(rowIndex).getStok_awal();

            case 9:
                return arrayPengiriman.get(rowIndex).getStok_akhir();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pengiriman";

            case 1:
                return "No Order";

            case 2:
                return "Tanggal";

            case 3:
                return "Jumlah Pengiriman";

            case 4:
                return "BSU";

            case 5:
                return "Kode Regional";
                
            case 6:
                return "Kode Produk";

            case 7:
                return "Nama Produk";

            case 8:
                return "Stok Awal";

            case 9:
                return "Stok Akhir";
        }
        return null;
    }
}
