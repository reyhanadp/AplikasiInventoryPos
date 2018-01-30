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
                String nominal = format_titik(Integer.toString(arrayPemesanan.get(rowIndex).getNominal()));
                return nominal;

            case 6:
                return arrayPemesanan.get(rowIndex).getTahun();
                              
            case 7:
                return arrayPemesanan.get(rowIndex).getNamaMitra();
                
            case 8:
                String jumlah_pemesanan = format_titik(arrayPemesanan.get(rowIndex).getJumlahPemesanan());
                return jumlah_pemesanan;
   
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
