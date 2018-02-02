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
public class ProdukTM extends AbstractTableModel {

    private ArrayList<Produk> arrayProduk;

    public void setDataProduk(ArrayList<Produk> arrayProduk) {
        this.arrayProduk = arrayProduk;
    }
    
    private String hilangkan_titik(String text_titik) {
        String[] temp = text_titik.split("\\.");
        String text_string = "";
        for (int i = 0; i < temp.length; i++) {
            text_string = text_string + temp[i];
        }
        return text_string;
    }
    
    private String ambil_angka_depan(String text_string){
        String[] temp = text_string.split("\\,");
        return temp[0];
    }
    
    private String ambil_angka_belakang(String text_string){
        String[] temp = text_string.split("\\,");
        return temp[1];
    }
    
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

    @Override
    public int getRowCount() {
        return arrayProduk.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayProduk.get(rowIndex).getIdProduk();

            case 1:
                return arrayProduk.get(rowIndex).getNamaProduk();

            case 2:
                return format_titik(Integer.toString(arrayProduk.get(rowIndex).getNominal()));

            case 3:
                String biaya_cetak = Float.toString(arrayProduk.get(rowIndex).getBiayaCetak()).replace(".", ",");
                String biaya_cetak_depan = ambil_angka_depan(biaya_cetak);
                String biaya_cetak_belakang = ambil_angka_belakang(biaya_cetak);
                String biaya_cetak_titik = format_titik(biaya_cetak_depan);
                return biaya_cetak_titik+","+biaya_cetak_belakang;

            case 4:
                return format_titik(Integer.toString(arrayProduk.get(rowIndex).getStok()));

            case 5:
                return arrayProduk.get(rowIndex).getTahun();


        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Produk";
                
            case 1:
                return "Nama Produk";
                
            case 2:
                return "Nominal";
                
            case 3:
                return "Biaya Cetak";
                
            case 4:
                return "Stok";
                
            case 5:
                return "Tahun";
        }
        return null;
    }

}
