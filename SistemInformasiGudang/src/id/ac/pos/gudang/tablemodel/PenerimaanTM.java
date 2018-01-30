/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

import id.ac.pos.gudang.entity.Penerimaan;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author muhamad solahudin
 */
public class PenerimaanTM extends AbstractTableModel{
    private ArrayList<Penerimaan> arrayPenerimaan;     
    
    public void setDataPenerimaan(ArrayList<Penerimaan> arrayPenerimaan) {
        this.arrayPenerimaan = arrayPenerimaan;
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
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getJmlTerima()));
   
            case 3:
                return arrayPenerimaan.get(rowIndex).getNoPemesanan();
                
            case 4:
                return arrayPenerimaan.get(rowIndex).getIdProduk();
            
            case 5:
                return arrayPenerimaan.get(rowIndex).getNamaProduk();    
                                
            case 6:
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getNominal()));

            case 7:
                return arrayPenerimaan.get(rowIndex).getTahun();
                 
            case 8:
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getStokAwal()));
                
            case 9:
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getStokAkhir()));
                
            case 10:
                return arrayPenerimaan.get(rowIndex).getNamaMitra();
            
            case 11:
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getSubTotalTerima()));

            case 12:
                return format_titik(Integer.toString(arrayPenerimaan.get(rowIndex).getSisaBelumDikirim()));

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
                return "No Pemesanan";
            
            case 4:
                return "Kode Produk";
            
            case 5:
                return "Nama Produk";
                
            case 6:
                return "Nominal";

            case 7:
                return "Tahun";    
                
            case 8:
                return "Stok Awal";    
                
            case 9:
                return "Stok Akhir";    
                
            case 10:
                return "Nama Mitra";
   
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
