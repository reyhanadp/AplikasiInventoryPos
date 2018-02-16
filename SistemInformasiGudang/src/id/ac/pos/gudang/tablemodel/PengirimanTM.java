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

    private String format_titik(String text_string) {
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

    public void setDataPengiriman(ArrayList<Pengiriman> arrayPengiriman) {
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
                return arrayPengiriman.get(rowIndex).getId_produk();

            case 3:
                return arrayPengiriman.get(rowIndex).getNama_produk();

            case 4:
                return arrayPengiriman.get(rowIndex).getId_regional();

            case 5:
                return arrayPengiriman.get(rowIndex).getTgl_pengiriman();

            case 6:
                String jumlah_kirim_hasil = format_titik(Integer.toString(arrayPengiriman.get(rowIndex).getJumlah_pengiriman()));
                return jumlah_kirim_hasil;

            case 7:
                String bsu_hasil = format_titik(arrayPengiriman.get(rowIndex).getBsu());
                return bsu_hasil;

            case 8:
                String stok_awal_hasil = format_titik(Integer.toString(arrayPengiriman.get(rowIndex).getStok_awal()));
                return stok_awal_hasil;

            case 9:
                String stok_akhir_hasil = format_titik(Integer.toString(arrayPengiriman.get(rowIndex).getStok_akhir()));
                return stok_akhir_hasil;

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
                return "Kode Produk";

            case 3:
                return "Nama Produk";

            case 4:
                return "Kode Regional";

            case 5:
                return "Tanggal";

            case 6:
                return "Jumlah Pengiriman";

            case 7:
                return "BSU";

            case 8:
                return "Stok Awal";

            case 9:
                return "Stok Akhir";
        }
        return null;
    }
}
