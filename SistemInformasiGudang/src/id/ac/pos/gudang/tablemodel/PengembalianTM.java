/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Pengembalian;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Operator
 */
public class PengembalianTM extends AbstractTableModel {

    private ArrayList<Pengembalian> arrayPengembalian;

    public void setDataPengembalian(ArrayList<Pengembalian> arrayPengembalian) {
        this.arrayPengembalian = arrayPengembalian;
    }

    @Override
    public int getRowCount() {
        return arrayPengembalian.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPengembalian.get(rowIndex).getId_pengembalian();

            case 1:
                return arrayPengembalian.get(rowIndex).getTanggal_pengembalian();

            case 2:
                return arrayPengembalian.get(rowIndex).getJumlah_pengembalian();

            case 3:
                return arrayPengembalian.get(rowIndex).getDus();

            case 4:
                return arrayPengembalian.get(rowIndex).getId_regional();

            case 5:
                return arrayPengembalian.get(rowIndex).getId_produk();

            case 6:
                return arrayPengembalian.get(rowIndex).getStok_awal();

            case 7:
                return arrayPengembalian.get(rowIndex).getStok_akhir();

            case 8:
                return arrayPengembalian.get(rowIndex).getKeterangan();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Pengembalian";

            case 1:
                return "Tanggal";

            case 2:
                return "Jumlah Pengembalian";

            case 3:
                return "Nomor Dus";

            case 4:
                return "Kode Regional";

            case 5:
                return "Kode Produk";

            case 6:
                return "Stok Awal";

            case 7:
                return "Stok Akhir";

            case 8:
                return "Keterangan";
        }
        return null;
    }
}
