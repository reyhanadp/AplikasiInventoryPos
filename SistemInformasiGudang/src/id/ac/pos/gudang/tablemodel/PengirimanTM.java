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
    int j = 0, i, n;
    int k = 2, l = 3, m = 4;

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
                return arrayPengiriman.get(rowIndex).getTgl_pengiriman();

            case 3:
                String jumlah_kirim_string = Integer.toString(arrayPengiriman.get(rowIndex).getJumlah_pengiriman());
                //format bsu
                String jumlah_kirim_hasil = "";
                k = 2;
                l = 3;
                m = 4;
                int panjang_jumlah_kirim = jumlah_kirim_string.length();
                String[] jumlah_kirim_pisah = jumlah_kirim_string.split("(?<=\\G.{1})");
                j = 0;
                while (j == 0) {
                    if (panjang_jumlah_kirim == k) {
                        n = k;
                        for (i = 0; i < k; i++) {
                            if (n % 3 == 0) {
                                jumlah_kirim_hasil = jumlah_kirim_hasil + "." + jumlah_kirim_pisah[i];
                            } else {
                                jumlah_kirim_hasil = jumlah_kirim_hasil + jumlah_kirim_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_jumlah_kirim == l) {
                        n = l;
                        for (i = 0; i < l; i++) {
                            if (n % 3 == 0) {
                                if (n == l) {
                                    jumlah_kirim_hasil = jumlah_kirim_hasil + jumlah_kirim_pisah[i];
                                } else {
                                    jumlah_kirim_hasil = jumlah_kirim_hasil + "." + jumlah_kirim_pisah[i];
                                }
                            } else {
                                jumlah_kirim_hasil = jumlah_kirim_hasil + jumlah_kirim_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_jumlah_kirim == m) {
                        n = m;
                        for (i = 0; i < m; i++) {
                            if (n % 3 == 0) {
                                jumlah_kirim_hasil = jumlah_kirim_hasil + "." + jumlah_kirim_pisah[i];
                            } else {
                                jumlah_kirim_hasil = jumlah_kirim_hasil + jumlah_kirim_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_jumlah_kirim == 1) {
                        jumlah_kirim_hasil = jumlah_kirim_pisah[0];
                        j = 1;
                    }
                    k = k + 3;
                    l = l + 3;
                    m = m + 3;
                }
                return jumlah_kirim_hasil;

            case 4:
                String bsu_string = arrayPengiriman.get(rowIndex).getBsu();
                //format bsu
                String bsu_hasil = "";
                k = 2;
                l = 3;
                m = 4;
                int panjang_bsu = bsu_string.length();
                String[] bsu_pisah = bsu_string.split("(?<=\\G.{1})");
                j = 0;
                while (j == 0) {
                    if (panjang_bsu == k) {
                        n = k;
                        for (i = 0; i < k; i++) {
                            if (n % 3 == 0) {
                                bsu_hasil = bsu_hasil + "." + bsu_pisah[i];
                            } else {
                                bsu_hasil = bsu_hasil + bsu_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_bsu == l) {
                        n = l;
                        for (i = 0; i < l; i++) {
                            if (n % 3 == 0) {
                                if (n == l) {
                                    bsu_hasil = bsu_hasil + bsu_pisah[i];
                                } else {
                                    bsu_hasil = bsu_hasil + "." + bsu_pisah[i];
                                }
                            } else {
                                bsu_hasil = bsu_hasil + bsu_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_bsu == m) {
                        n = m;
                        for (i = 0; i < m; i++) {
                            if (n % 3 == 0) {
                                bsu_hasil = bsu_hasil + "." + bsu_pisah[i];
                            } else {
                                bsu_hasil = bsu_hasil + bsu_pisah[i];
                            }
                            n--;
                        }
                        j = 1;
                    } else if (panjang_bsu == 1) {
                        bsu_hasil = bsu_pisah[0];
                        j = 1;
                    }
                    k = k + 3;
                    l = l + 3;
                    m = m + 3;
                }
                return bsu_hasil;

            case 5:
                return arrayPengiriman.get(rowIndex).getId_regional();

            case 6:
                return arrayPengiriman.get(rowIndex).getId_produk();

            case 7:
                return arrayPengiriman.get(rowIndex).getNama_produk();

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
