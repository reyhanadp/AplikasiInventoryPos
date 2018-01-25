/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import java.util.ArrayList;
import java.util.Vector;
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

    private String format_titik(String text_string) {
        if(text_string == null){
            text_string = "";
        }
        
        int j = 0, i, n;
        String text_hasil = "";
        int k = 2, l = 3, m = 4;
        int panjang_text = text_string.length();
        String[] text_pisah = text_string.split("(?<=\\G.{1})");

        while (j == 0) {
            if (panjang_text == k) {
                n = k;
                for (i = 0; i < k; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == l) {
                n = l;
                for (i = 0; i < l; i++) {
                    if (n % 3 == 0) {
                        if (n == l) {
                            text_hasil = text_hasil + text_pisah[i];
                        } else {
                            text_hasil = text_hasil + "." + text_pisah[i];
                        }
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == m) {
                n = m;
                for (i = 0; i < m; i++) {
                    if (n % 3 == 0) {
                        text_hasil = text_hasil + "." + text_pisah[i];
                    } else {
                        text_hasil = text_hasil + text_pisah[i];
                    }
                    n--;
                }
                j = 1;
            } else if (panjang_text == 1) {
                text_hasil = text_pisah[0];
                j = 1;
            } else if (panjang_text == 0) {
                text_hasil = "";
                j = 1;
            }
            k = k + 3;
            l = l + 3;
            m = m + 3;
        }
        return text_hasil;

    }
    
    @Override
    public int getRowCount() {
        return arrayPengembalian.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayPengembalian.get(rowIndex).getId_pengembalian();

            case 1:
                return arrayPengembalian.get(rowIndex).getTanggal_pengembalian();

            case 2:
                String jumlah_pengembalian_hasil = format_titik(Integer.toString(arrayPengembalian.get(rowIndex).getJumlah_pengembalian()));
                return jumlah_pengembalian_hasil;

            case 3:
                String dus_hasil = format_titik(arrayPengembalian.get(rowIndex).getDus());
                return dus_hasil;

            case 4:
                return arrayPengembalian.get(rowIndex).getId_regional();

            case 5:
                return arrayPengembalian.get(rowIndex).getId_produk();
            
            case 6:
                return arrayPengembalian.get(rowIndex).getNama_produk();
                
            case 7:
                String stok_awal_hasil = format_titik(Integer.toString(arrayPengembalian.get(rowIndex).getStok_awal()));
                return stok_awal_hasil;

            case 8:
                String stok_akhir_hasil = format_titik(Integer.toString(arrayPengembalian.get(rowIndex).getStok_akhir()));
                return stok_akhir_hasil;

            case 9:
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
                return "Nama Produk";

            case 7:
                return "Stok Awal";

            case 8:
                return "Stok Akhir";

            case 9:
                return "Keterangan";
        }
        return null;
    }
}
