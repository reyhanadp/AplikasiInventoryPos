/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Dialog;

import id.ac.pos.gudang.Form.FormHome;
import id.ac.pos.gudang.dao.LaporanDAO;
import id.ac.pos.gudang.daoimpl.LaporanDAOImpl;
import id.ac.pos.gudang.entity.Produk;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author Operator
 */
public class DialogLaporan extends javax.swing.JDialog {

    LaporanDAO dao_laporan = new LaporanDAOImpl();
    Calendar cal = Calendar.getInstance();
    ArrayList<Produk> arrayProdukTahun, arrayProduk;
    Vector vectorTahun = new Vector();
    Vector vectorBulan = new Vector();
    private String nik;

    /**
     * Creates new form DialogLaporan
     */
    public DialogLaporan(java.awt.Frame parent, boolean modal) {

    }

    public DialogLaporan(FormHome aThis, boolean b, String text) throws IOException {
        super(aThis, b);
        initComponents();
        setLocationRelativeTo(this);
        isiTahun();

        this.nik = text;
        String lokasi_simpan = dao_laporan.getLokasiSimpan(this.nik);
        if (lokasi_simpan != null) {
            File file = new File(lokasi_simpan);
            Desktop desktop = Desktop.getDesktop();
            if (file.exists()) {
                lokasi_pilih.setText(lokasi_simpan);
            }
        }

        if (satu_bulan.isSelected()) {
            vectorBulan.add("Januari");
            vectorBulan.add("Februari");
            vectorBulan.add("Maret");
            vectorBulan.add("April");
            vectorBulan.add("Mei");
            vectorBulan.add("Juni");
            vectorBulan.add("Juli");
            vectorBulan.add("Agustus");
            vectorBulan.add("September");
            vectorBulan.add("Oktober");
            vectorBulan.add("November");
            vectorBulan.add("Desember");

            combo_box_bulan.setModel(new DefaultComboBoxModel(vectorBulan));
        }
    }

    public void isiTahun() {
        vectorTahun.add("2018");
        combo_box_tahun.setModel(new DefaultComboBoxModel(vectorTahun));
    }

    public void LaporanProduk() throws IOException, WriteException {

        Object tahun = combo_box_tahun.getSelectedItem();
        Object bulan = combo_box_bulan.getSelectedItem();

//        String path = new File(".").getCanonicalPath();
        String path = lokasi_pilih.getText();
        WritableWorkbook workbook = Workbook.createWorkbook(new File(path + "/laporan_" + bulan + "_" + tahun + ".xls"));
        WritableSheet sheet1 = workbook.createSheet("Rekapitulasi", 7);
        tahun = combo_box_tahun.getSelectedItem();
        bulan = combo_box_bulan.getSelectedItem();
        WritableCellFormat judul_tabel = new WritableCellFormat();
        judul_tabel.setWrap(true);
        judul_tabel.setAlignment(Alignment.CENTRE);
        judul_tabel.setVerticalAlignment(VerticalAlignment.CENTRE);
        judul_tabel.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

        WritableCellFormat isi_sub_tabel_angka = new WritableCellFormat(NumberFormats.FORMAT1);
        isi_sub_tabel_angka.setBorder(Border.BOTTOM, BorderLineStyle.DOTTED);
        isi_sub_tabel_angka.setBorder(Border.RIGHT, BorderLineStyle.THIN);
        isi_sub_tabel_angka.setBorder(Border.LEFT, BorderLineStyle.THIN);
        isi_sub_tabel_angka.setBorder(Border.TOP, BorderLineStyle.DOTTED);

        WritableCellFormat isi_sub_tabel_huruf = new WritableCellFormat();
        isi_sub_tabel_huruf.setBorder(Border.BOTTOM, BorderLineStyle.DOTTED);
        isi_sub_tabel_huruf.setBorder(Border.RIGHT, BorderLineStyle.THIN);
        isi_sub_tabel_huruf.setBorder(Border.LEFT, BorderLineStyle.THIN);
        isi_sub_tabel_huruf.setBorder(Border.TOP, BorderLineStyle.DOTTED);

        WritableCellFormat isi_no = new WritableCellFormat();
        isi_no.setBorder(Border.BOTTOM, BorderLineStyle.DOTTED);
        isi_no.setBorder(Border.RIGHT, BorderLineStyle.THIN);
        isi_no.setBorder(Border.LEFT, BorderLineStyle.THIN);
        isi_no.setBorder(Border.TOP, BorderLineStyle.DOTTED);
        isi_no.setAlignment(Alignment.CENTRE);

        WritableCellFormat isi_jumlah_tahun = new WritableCellFormat(NumberFormats.FORMAT1);
        isi_jumlah_tahun.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.TOP, BorderLineStyle.MEDIUM);

        WritableCellFormat isi_tabel_rekapitulasi1 = new WritableCellFormat(NumberFormats.FORMAT1);
        isi_tabel_rekapitulasi1.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

        WritableCellFormat times;
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);
        int bulan_integer = 0;

        if (bulan == "Januari" || bulan == "Januari,Februari,Maret") {
            bulan_integer = 1;
        } else if (bulan == "Februari") {
            bulan_integer = 2;
        } else if (bulan == "Maret") {
            bulan_integer = 3;
        } else if (bulan == "April" || bulan == "April,Mei,Juni") {
            bulan_integer = 4;
        } else if (bulan == "Mei") {
            bulan_integer = 5;
        } else if (bulan == "Juni") {
            bulan_integer = 6;
        } else if (bulan == "Juli" || bulan == "Juli,Agustus,September") {
            bulan_integer = 7;
        } else if (bulan == "Agustus") {
            bulan_integer = 8;
        } else if (bulan == "September") {
            bulan_integer = 9;
        } else if (bulan == "Oktober" || bulan == "Oktober,November,Desember") {
            bulan_integer = 10;
        } else if (bulan == "November") {
            bulan_integer = 11;
        } else if (bulan == "Desember") {
            bulan_integer = 12;
        }

        int pilihan = 0;

        if (satu_bulan.isSelected()) {
            pilihan = 1;
        } else if (tiga_bulan.isSelected()) {
            pilihan = 3;
        }

        int banyak_produk;
        int total_jumlah_4;
        int total_jumlah_5;
        int total_jumlah_6;
        int total_jumlah_7;
        int total_jumlah_8;
        int total_jumlah_9;
        int total_jumlah_10;
        int total_jumlah_4_rekapitulasi = 0;
        int total_jumlah_5_rekapitulasi = 0;
        int total_jumlah_6_rekapitulasi = 0;
        int total_jumlah_7_rekapitulasi = 0;
        int total_jumlah_8_rekapitulasi = 0;
        int total_jumlah_9_rekapitulasi = 0;
        int total_jumlah_10_rekapitulasi = 0;
        String nama_produk = null;
        String jenis_produk = null;
        String tahun_terkecil;
        String tahun_terbesar;
        int tahun_sekarang = dao_laporan.getTahunSekarang();
        int bulan_sekarang = dao_laporan.getBulanSekarang();
        String tahun_kecil_str;
        int tahun_kecil;
        for (int z = 0; z < 7; z++) {
            switch (z) {
                case 0:
                    jenis_produk = "PR";
                    nama_produk = "A.Prangko";
                    break;
                case 1:
                    jenis_produk = "MS";
                    nama_produk = "B.MS & SS";
                    break;
                case 2:
                    jenis_produk = "SHP";
                    nama_produk = "C.SHP & SHPSS";
                    break;
                case 3:
                    jenis_produk = "KM";
                    nama_produk = "D.Kemasan";
                    break;
                case 4:
                    jenis_produk = "MC";
                    nama_produk = "E.Merchandise";
                    break;
                case 5:
                    jenis_produk = "PS";
                    nama_produk = "F.Prisma";
                    break;
                case 6:
                    jenis_produk = "DF";
                    nama_produk = "G.Dokumen Filateli";
                    break;
                default:
                    break;
            }

            WritableSheet sheet = workbook.createSheet(nama_produk, z);

            arrayProdukTahun = dao_laporan.getTahunTerkecil(jenis_produk);
            tahun_terkecil = null;
            tahun_terbesar = null;
            tahun_kecil_str = arrayProdukTahun.get(0).getTahun();
            tahun_kecil = Integer.parseInt(tahun_kecil_str);

            banyak_produk = 0;
            total_jumlah_4 = 0;
            total_jumlah_5 = 0;
            total_jumlah_6 = 0;
            total_jumlah_7 = 0;
            total_jumlah_8 = 0;
            total_jumlah_9 = 0;
            total_jumlah_10 = 0;

            for (int i = 0; i < arrayProdukTahun.size(); i++) {
                int jumlah_stok = 0;
                int total_jumlah_terima_stok = 0;
                int total_jumlah_terima = 0;
                int total_jumlah_pengeluaran_stok = 0;
                int total_jumlah_pengeluaran = 0;
                int total_jumlah_bsu = 0;
                int total_jumlah_nilai_intrinsik = 0;

                tahun_terkecil = arrayProdukTahun.get(0).getTahun();

                if (i == arrayProdukTahun.size() - 1) {
                    tahun_terbesar = arrayProdukTahun.get(i).getTahun();
                }

//            String status = "sekarang";
                arrayProduk = dao_laporan.getProduk(jenis_produk, arrayProdukTahun.get(i).getTahun());
                //kolom,baris,kolom,baris

                if (i == 0) {
                    sheet.setColumnView(1, 36);
                    sheet.setColumnView(4, 13);
                    sheet.setColumnView(5, 13);
                    sheet.setColumnView(7, 13);
                    sheet.setColumnView(9, 15);
                    sheet.setColumnView(10, 15);
                    sheet.mergeCells(0, 1, 1, 1);
                    sheet.mergeCells(0, 2, 0, 4);
                    sheet.mergeCells(1, 2, 1, 3);
                    sheet.mergeCells(2, 2, 2, 3);
                    sheet.mergeCells(3, 2, 3, 3);
                    sheet.mergeCells(4, 2, 8, 2);
                    sheet.mergeCells(9, 2, 9, 3);
                    sheet.mergeCells(10, 2, 10, 3);

                    //kolom,baris
                    sheet.addCell(new jxl.write.Label(0, 1, nama_produk));
                    if (bulan == "November,Desember,Januari" || bulan == "Desember,Januari,Februari") {
                        int tahun_tambah = Integer.parseInt((String) tahun);
                        tahun_tambah = tahun_tambah + 1;
                        tahun = tahun + "," + Integer.toString(tahun_tambah);
                    }
                    sheet.addCell(new jxl.write.Label(6, 1, bulan + " " + tahun));
                    tahun = combo_box_tahun.getSelectedItem();
                    sheet.addCell(new jxl.write.Label(0, 2, "No", judul_tabel));
                    sheet.addCell(new jxl.write.Label(1, 2, "Uraian", judul_tabel));
                    sheet.addCell(new jxl.write.Label(2, 2, "Nominal", judul_tabel));
                    sheet.addCell(new jxl.write.Label(3, 2, "Biaya Cetak", judul_tabel));
                    sheet.addCell(new jxl.write.Label(4, 2, "STOK AKHIR", judul_tabel));
                    sheet.addCell(new jxl.write.Label(9, 2, "BSU", judul_tabel));
                    sheet.addCell(new jxl.write.Label(10, 2, "Nilai Instrinsik", judul_tabel));
                    sheet.addCell(new jxl.write.Label(4, 3, "Gudang Pusat", judul_tabel));
                    sheet.addCell(new jxl.write.Label(5, 3, "Penerimaan", judul_tabel));
                    sheet.addCell(new jxl.write.Label(6, 3, "Jumlah", judul_tabel));
                    sheet.addCell(new jxl.write.Label(7, 3, "Pengeluaran", judul_tabel));
                    sheet.addCell(new jxl.write.Label(8, 3, "Jumlah", judul_tabel));
                    sheet.addCell(new jxl.write.Number(1, 4, 1, judul_tabel));
                    sheet.addCell(new jxl.write.Number(2, 4, 2, judul_tabel));
                    sheet.addCell(new jxl.write.Number(3, 4, 3, judul_tabel));
                    sheet.addCell(new jxl.write.Number(4, 4, 4, judul_tabel));
                    sheet.addCell(new jxl.write.Number(5, 4, 5, judul_tabel));
                    sheet.addCell(new jxl.write.Label(6, 4, "6=(4+5)", judul_tabel));
                    sheet.addCell(new jxl.write.Number(7, 4, 7, judul_tabel));
                    sheet.addCell(new jxl.write.Label(8, 4, "8=(6-7)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(9, 4, "9=(2x8)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(10, 4, "10=(3x8)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(1, 5, "TAHUN " + arrayProdukTahun.get(i).getTahun(), isi_sub_tabel_huruf));

                    sheet.addCell(new jxl.write.Label(0, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(2, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(3, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(4, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(5, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(6, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(7, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(8, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(9, 5, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(10, 5, "", isi_sub_tabel_angka));

                    for (int j = 0; j < arrayProduk.size(); j++) {
                        int jumlah_terima = 0;
                        int jumlah_pengeluaran = 0;
                        int jumlah_pengembalian = 0;
                        int stok = 0;
                        int jumlah_terima_dipilih = 0;
                        int jumlah_pengeluaran_dipilih = 0;
                        int jumlah_pengembalian_dipilih = 0;
                        int bsu = 0;
                        int nilai_intrinsik = 0;

                        sheet.addCell(new jxl.write.Number(0, 6 + j, j + 1, isi_no));
                        sheet.addCell(new jxl.write.Label(1, 6 + j, arrayProduk.get(j).getNamaProduk(), isi_sub_tabel_huruf));
                        sheet.addCell(new jxl.write.Number(2, 6 + j, arrayProduk.get(j).getNominal(), isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(3, 6 + j, arrayProduk.get(j).getBiayaCetak(), isi_sub_tabel_angka));

                        jumlah_terima_dipilih = dao_laporan.getJumlahTerima(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_terima = dao_laporan.getJumlahTerima(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        jumlah_pengeluaran_dipilih = dao_laporan.getJumlahPengiriman(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_pengeluaran = dao_laporan.getJumlahPengiriman(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        jumlah_pengembalian_dipilih = dao_laporan.getJumlahPengembalian(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_pengembalian = dao_laporan.getJumlahPengembalian(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        stok = dao_laporan.getStokProduk(arrayProduk.get(j).getIdProduk());

                        stok = stok - (jumlah_terima + jumlah_pengembalian) + jumlah_pengeluaran;
                        total_jumlah_terima = total_jumlah_terima + jumlah_terima_dipilih + jumlah_pengembalian_dipilih;
                        total_jumlah_terima_stok = total_jumlah_terima_stok + jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok;
                        total_jumlah_pengeluaran = total_jumlah_pengeluaran + jumlah_pengeluaran_dipilih;
                        total_jumlah_pengeluaran_stok = total_jumlah_pengeluaran_stok + jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih;
                        jumlah_stok = jumlah_stok + stok;
                        bsu = arrayProduk.get(j).getNominal() * (jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih);
                        total_jumlah_bsu = total_jumlah_bsu + bsu;
                        nilai_intrinsik = (int) (arrayProduk.get(j).getBiayaCetak() * (jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih));
                        total_jumlah_nilai_intrinsik = total_jumlah_nilai_intrinsik + nilai_intrinsik;

                        sheet.addCell(new jxl.write.Number(4, 6 + j, stok, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(5, 6 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(6, 6 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(7, 6 + j, jumlah_pengeluaran_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(8, 6 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(9, 6 + j, bsu, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(10, 6 + j, nilai_intrinsik, isi_sub_tabel_angka));

                    }
                    total_jumlah_4 = total_jumlah_4 + jumlah_stok;
                    total_jumlah_5 = total_jumlah_5 + total_jumlah_terima;
                    total_jumlah_6 = total_jumlah_6 + total_jumlah_terima_stok;
                    total_jumlah_7 = total_jumlah_7 + total_jumlah_pengeluaran;
                    total_jumlah_8 = total_jumlah_8 + total_jumlah_pengeluaran_stok;
                    total_jumlah_9 = total_jumlah_9 + total_jumlah_bsu;
                    total_jumlah_10 = total_jumlah_10 + total_jumlah_nilai_intrinsik;

                    sheet.addCell(new jxl.write.Label(0, 6 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(1, 6 + arrayProduk.size(), "Jumlah Tahun " + arrayProdukTahun.get(i).getTahun(), isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(2, 6 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(3, 6 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(4, 6 + arrayProduk.size(), jumlah_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(5, 6 + arrayProduk.size(), total_jumlah_terima, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(6, 6 + arrayProduk.size(), total_jumlah_terima_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(7, 6 + arrayProduk.size(), total_jumlah_pengeluaran, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(8, 6 + arrayProduk.size(), total_jumlah_pengeluaran_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(9, 6 + arrayProduk.size(), total_jumlah_bsu, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(10, 6 + arrayProduk.size(), total_jumlah_nilai_intrinsik, isi_jumlah_tahun));

                    banyak_produk = 8 + arrayProduk.size();
                } else if (i != 0) {

                    arrayProduk = dao_laporan.getProduk(jenis_produk, arrayProdukTahun.get(i).getTahun());

                    sheet.mergeCells(0, banyak_produk, 0, banyak_produk + 2);
                    sheet.mergeCells(1, banyak_produk, 1, banyak_produk + 1);
                    sheet.mergeCells(2, banyak_produk, 2, banyak_produk + 1);
                    sheet.mergeCells(3, banyak_produk, 3, banyak_produk + 1);
                    sheet.mergeCells(4, banyak_produk, 8, banyak_produk);
                    sheet.mergeCells(9, banyak_produk, 9, banyak_produk + 1);
                    sheet.mergeCells(10, banyak_produk, 10, banyak_produk + 1);

                    sheet.addCell(new jxl.write.Label(0, banyak_produk, "No", judul_tabel));
                    sheet.addCell(new jxl.write.Label(1, banyak_produk, "Uraian", judul_tabel));
                    sheet.addCell(new jxl.write.Label(2, banyak_produk, "Nominal", judul_tabel));
                    sheet.addCell(new jxl.write.Label(3, banyak_produk, "Biaya Cetak", judul_tabel));
                    sheet.addCell(new jxl.write.Label(4, banyak_produk, "STOK AKHIR", judul_tabel));
                    sheet.addCell(new jxl.write.Label(9, banyak_produk, "BSU", judul_tabel));
                    sheet.addCell(new jxl.write.Label(10, banyak_produk, "Nilai Instrinsik", judul_tabel));
                    sheet.addCell(new jxl.write.Label(4, banyak_produk + 1, "Gudang Pusat", judul_tabel));
                    sheet.addCell(new jxl.write.Label(5, banyak_produk + 1, "Penerimaan", judul_tabel));
                    sheet.addCell(new jxl.write.Label(6, banyak_produk + 1, "Jumlah", judul_tabel));
                    sheet.addCell(new jxl.write.Label(7, banyak_produk + 1, "Pengeluaran", judul_tabel));
                    sheet.addCell(new jxl.write.Label(8, banyak_produk + 1, "Jumlah", judul_tabel));
                    sheet.addCell(new jxl.write.Number(1, banyak_produk + 2, 1, judul_tabel));
                    sheet.addCell(new jxl.write.Number(2, banyak_produk + 2, 2, judul_tabel));
                    sheet.addCell(new jxl.write.Number(3, banyak_produk + 2, 3, judul_tabel));
                    sheet.addCell(new jxl.write.Number(4, banyak_produk + 2, 4, judul_tabel));
                    sheet.addCell(new jxl.write.Number(5, banyak_produk + 2, 5, judul_tabel));
                    sheet.addCell(new jxl.write.Label(6, banyak_produk + 2, "6=(4+5)", judul_tabel));
                    sheet.addCell(new jxl.write.Number(7, banyak_produk + 2, 7, judul_tabel));
                    sheet.addCell(new jxl.write.Label(8, banyak_produk + 2, "8=(6-7)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(9, banyak_produk + 2, "9=(2x8)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(10, banyak_produk + 2, "10=(3x8)", judul_tabel));
                    sheet.addCell(new jxl.write.Label(1, banyak_produk + 3, "TAHUN " + arrayProdukTahun.get(i).getTahun(), isi_sub_tabel_huruf));
                    sheet.addCell(new jxl.write.Label(0, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(2, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(3, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(4, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(5, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(6, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(7, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(8, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(9, banyak_produk + 3, "", isi_sub_tabel_angka));
                    sheet.addCell(new jxl.write.Label(10, banyak_produk + 3, "", isi_sub_tabel_angka));

                    for (int j = 0; j < arrayProduk.size(); j++) {
                        int jumlah_terima = 0;
                        int jumlah_pengeluaran = 0;
                        int jumlah_pengembalian = 0;
                        int stok = 0;
                        int jumlah_terima_dipilih = 0;
                        int jumlah_pengeluaran_dipilih = 0;
                        int jumlah_pengembalian_dipilih = 0;
                        int bsu = 0;
                        int nilai_intrinsik = 0;

                        sheet.addCell(new jxl.write.Number(0, banyak_produk + 4 + j, j + 1, isi_no));
                        sheet.addCell(new jxl.write.Label(1, banyak_produk + 4 + j, arrayProduk.get(j).getNamaProduk(), isi_sub_tabel_huruf));
                        sheet.addCell(new jxl.write.Number(2, banyak_produk + 4 + j, arrayProduk.get(j).getNominal(), isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(3, banyak_produk + 4 + j, arrayProduk.get(j).getBiayaCetak(), isi_sub_tabel_angka));

                        jumlah_terima_dipilih = dao_laporan.getJumlahTerima(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_terima = dao_laporan.getJumlahTerima(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        jumlah_pengeluaran_dipilih = dao_laporan.getJumlahPengiriman(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_pengeluaran = dao_laporan.getJumlahPengiriman(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        jumlah_pengembalian_dipilih = dao_laporan.getJumlahPengembalian(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "tidak sekarang", pilihan);
                        jumlah_pengembalian = dao_laporan.getJumlahPengembalian(arrayProduk.get(j).getIdProduk(), bulan_integer, tahun, bulan_sekarang, tahun_sekarang, "sekarang", pilihan);
                        stok = dao_laporan.getStokProduk(arrayProduk.get(j).getIdProduk());

                        stok = stok - (jumlah_terima + jumlah_pengembalian) + jumlah_pengeluaran;
                        total_jumlah_terima = total_jumlah_terima + jumlah_terima_dipilih + jumlah_pengembalian_dipilih;
                        total_jumlah_terima_stok = total_jumlah_terima_stok + jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok;
                        total_jumlah_pengeluaran = total_jumlah_pengeluaran + jumlah_pengeluaran_dipilih;
                        total_jumlah_pengeluaran_stok = total_jumlah_pengeluaran_stok + jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih;
                        jumlah_stok = jumlah_stok + stok;
                        bsu = arrayProduk.get(j).getNominal() * (jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih);
                        total_jumlah_bsu = total_jumlah_bsu + bsu;
                        nilai_intrinsik = (int) (arrayProduk.get(j).getBiayaCetak() * (jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih));
                        total_jumlah_nilai_intrinsik = total_jumlah_nilai_intrinsik + nilai_intrinsik;

                        sheet.addCell(new jxl.write.Number(4, banyak_produk + 4 + j, stok, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(5, banyak_produk + 4 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(6, banyak_produk + 4 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(7, banyak_produk + 4 + j, jumlah_pengeluaran_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(8, banyak_produk + 4 + j, jumlah_terima_dipilih + jumlah_pengembalian_dipilih + stok - jumlah_pengeluaran_dipilih, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(9, banyak_produk + 4 + j, bsu, isi_sub_tabel_angka));
                        sheet.addCell(new jxl.write.Number(10, banyak_produk + 4 + j, nilai_intrinsik, isi_sub_tabel_angka));
                    }

                    total_jumlah_4 = total_jumlah_4 + jumlah_stok;
                    total_jumlah_5 = total_jumlah_5 + total_jumlah_terima;
                    total_jumlah_6 = total_jumlah_6 + total_jumlah_terima_stok;
                    total_jumlah_7 = total_jumlah_7 + total_jumlah_pengeluaran;
                    total_jumlah_8 = total_jumlah_8 + total_jumlah_pengeluaran_stok;
                    total_jumlah_9 = total_jumlah_9 + total_jumlah_bsu;
                    total_jumlah_10 = total_jumlah_10 + total_jumlah_nilai_intrinsik;

                    sheet.addCell(new jxl.write.Label(0, banyak_produk + 4 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(1, banyak_produk + 4 + arrayProduk.size(), "Jumlah Tahun " + arrayProdukTahun.get(i).getTahun(), isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(2, banyak_produk + 4 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Label(3, banyak_produk + 4 + arrayProduk.size(), "", isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(4, banyak_produk + 4 + arrayProduk.size(), jumlah_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(5, banyak_produk + 4 + arrayProduk.size(), total_jumlah_terima, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(6, banyak_produk + 4 + arrayProduk.size(), total_jumlah_terima_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(7, banyak_produk + 4 + arrayProduk.size(), total_jumlah_pengeluaran, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(8, banyak_produk + 4 + arrayProduk.size(), total_jumlah_pengeluaran_stok, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(9, banyak_produk + 4 + arrayProduk.size(), total_jumlah_bsu, isi_jumlah_tahun));
                    sheet.addCell(new jxl.write.Number(10, banyak_produk + 4 + arrayProduk.size(), total_jumlah_nilai_intrinsik, isi_jumlah_tahun));

                    banyak_produk = banyak_produk + 6 + arrayProduk.size();

                }

            }

            sheet.mergeCells(0, banyak_produk, 1, banyak_produk);
            sheet.addCell(new jxl.write.Label(0, banyak_produk, nama_produk));
            sheet.addCell(new jxl.write.Label(0, banyak_produk + 1, "", isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Label(1, banyak_produk + 1, "JUMLAH Th. " + tahun_terkecil + " S.D. " + tahun_terbesar, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Label(2, banyak_produk + 1, "", isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Label(3, banyak_produk + 1, "", isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(4, banyak_produk + 1, total_jumlah_4, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(5, banyak_produk + 1, total_jumlah_5, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(6, banyak_produk + 1, total_jumlah_6, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(7, banyak_produk + 1, total_jumlah_7, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(8, banyak_produk + 1, total_jumlah_8, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(9, banyak_produk + 1, total_jumlah_9, isi_jumlah_tahun));
            sheet.addCell(new jxl.write.Number(10, banyak_produk + 1, total_jumlah_10, isi_jumlah_tahun));

            sheet1.addCell(new jxl.write.Label(0, 7 + z, nama_produk, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(1, 7 + z, total_jumlah_4, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(2, 7 + z, total_jumlah_5, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(3, 7 + z, total_jumlah_6, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(4, 7 + z, total_jumlah_7, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(5, 7 + z, total_jumlah_8, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(6, 7 + z, total_jumlah_9, isi_tabel_rekapitulasi1));
            sheet1.addCell(new jxl.write.Number(7, 7 + z, total_jumlah_10, isi_tabel_rekapitulasi1));

            total_jumlah_4_rekapitulasi = total_jumlah_4_rekapitulasi + total_jumlah_4;
            total_jumlah_5_rekapitulasi = total_jumlah_5_rekapitulasi + total_jumlah_5;
            total_jumlah_6_rekapitulasi = total_jumlah_6_rekapitulasi + total_jumlah_6;
            total_jumlah_7_rekapitulasi = total_jumlah_7_rekapitulasi + total_jumlah_7;
            total_jumlah_8_rekapitulasi = total_jumlah_8_rekapitulasi + total_jumlah_8;
            total_jumlah_9_rekapitulasi = total_jumlah_9_rekapitulasi + total_jumlah_9;
            total_jumlah_10_rekapitulasi = total_jumlah_10_rekapitulasi + total_jumlah_10;
        }

        WritableFont font_judul = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD);
        WritableFont font_sub_judul = new WritableFont(WritableFont.ARIAL, 11, WritableFont.BOLD);
        WritableFont font_judul_tabel = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);

        WritableCellFormat judul_rekapitulasi = new WritableCellFormat(font_judul);
        judul_rekapitulasi.setAlignment(Alignment.CENTRE);

        WritableCellFormat judul_sub_rekapitulasi = new WritableCellFormat(font_sub_judul);
        judul_sub_rekapitulasi.setAlignment(Alignment.CENTRE);

        WritableCellFormat judul_tabel_rekapitulasi = new WritableCellFormat(font_judul_tabel);
        judul_tabel_rekapitulasi.setAlignment(Alignment.CENTRE);
        judul_tabel_rekapitulasi.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
        judul_tabel_rekapitulasi.setBackground(Colour.LIGHT_GREEN);
        judul_tabel_rekapitulasi.setVerticalAlignment(VerticalAlignment.CENTRE);

        WritableCellFormat isi_tabel_rekapitulasi = new WritableCellFormat(font_judul_tabel);
        isi_tabel_rekapitulasi.setBackground(Colour.GREY_25_PERCENT);
        isi_tabel_rekapitulasi.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

        WritableCellFormat jumlah = new WritableCellFormat(font_judul_tabel);
        jumlah.setBorder(Border.ALL, BorderLineStyle.MEDIUM);
        jumlah.setAlignment(Alignment.CENTRE);

        sheet1.setColumnView(0, 22);
        sheet1.setColumnView(1, 15);
        sheet1.setColumnView(2, 15);
        sheet1.setColumnView(3, 15);
        sheet1.setColumnView(4, 15);
        sheet1.setColumnView(5, 15);
        sheet1.setColumnView(6, 15);
        sheet1.setColumnView(7, 15);
        sheet1.setRowView(5, 750);
        sheet1.mergeCells(0, 2, 5, 2);
        sheet1.mergeCells(0, 3, 5, 3);
        sheet1.addCell(new jxl.write.Label(0, 2, "REKAP STOK AKHIR BENDA FILATELI GUDANG PUSAT", judul_rekapitulasi));
        if (bulan == "November,Desember,Januari" || bulan == "Desember,Januari,Februari") {
            int tahun_tambah = Integer.parseInt((String) tahun);
            tahun_tambah = tahun_tambah + 1;
            tahun = tahun + "," + Integer.toString(tahun_tambah);
        }
        sheet1.addCell(new jxl.write.Label(0, 3, bulan + " " + tahun, judul_sub_rekapitulasi));
        tahun = combo_box_tahun.getSelectedItem();
        sheet1.addCell(new jxl.write.Label(0, 5, "Jenis Benda Filateli", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(1, 5, "Gudang Pusat", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(2, 5, "Penerimaan", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(3, 5, "Jumlah", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(4, 5, "Pengeluaran", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(5, 5, "Jumlah", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(6, 5, "BSU", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(7, 5, "Nilai Instrinsik", judul_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(0, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(1, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(2, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(3, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(4, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(5, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(6, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(7, 6, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(0, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(1, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(2, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(3, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(4, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(5, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(6, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(7, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(7, 14, "", isi_tabel_rekapitulasi));
        sheet1.addCell(new jxl.write.Label(0, 15, "Jumlah", jumlah));
        sheet1.addCell(new jxl.write.Number(1, 15, total_jumlah_4_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(2, 15, total_jumlah_5_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(3, 15, total_jumlah_6_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(4, 15, total_jumlah_7_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(5, 15, total_jumlah_8_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(6, 15, total_jumlah_9_rekapitulasi, isi_tabel_rekapitulasi1));
        sheet1.addCell(new jxl.write.Number(7, 15, total_jumlah_10_rekapitulasi, isi_tabel_rekapitulasi1));

        workbook.write();
        workbook.close();
        if (bulan == "November,Desember,Januari" || bulan == "Desember,Januari,Februari") {
            int tahun_tambah = Integer.parseInt((String) tahun);
            tahun_tambah = tahun_tambah + 1;
            tahun = tahun + "," + Integer.toString(tahun_tambah);
        }

        File file = new File(path + "/laporan_" + bulan + "_" + tahun + ".xls");
        tahun = combo_box_tahun.getSelectedItem();
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
            boolean sukses = dao_laporan.setLokasiSimpan(this.nik, lokasi_pilih.getText());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupLaporan = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        combo_box_bulan = new javax.swing.JComboBox<>();
        combo_box_tahun = new javax.swing.JComboBox<>();
        export = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        satu_bulan = new javax.swing.JRadioButton();
        tiga_bulan = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lokasi_pilih = new javax.swing.JTextField();
        pilih_file = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eksport Laporan"));

        export.setText("Export");
        export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportActionPerformed(evt);
            }
        });

        jLabel1.setText("Jenis Laporan");

        buttonGroupLaporan.add(satu_bulan);
        satu_bulan.setSelected(true);
        satu_bulan.setText("1 Bulan");
        satu_bulan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                satu_bulanItemStateChanged(evt);
            }
        });
        satu_bulan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                satu_bulanMouseReleased(evt);
            }
        });

        buttonGroupLaporan.add(tiga_bulan);
        tiga_bulan.setText("3 Bulan");
        tiga_bulan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tiga_bulanMouseReleased(evt);
            }
        });

        jLabel2.setText("Bulan");

        jLabel3.setText("Tahun");

        lokasi_pilih.setEditable(false);

        pilih_file.setText("Pilih");
        pilih_file.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilih_fileActionPerformed(evt);
            }
        });

        jLabel4.setText("Lokasi Simpan");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(satu_bulan)
                                .addGap(18, 18, 18)
                                .addComponent(tiga_bulan))
                            .addComponent(combo_box_bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_box_tahun, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lokasi_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pilih_file, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(export, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tiga_bulan)
                        .addComponent(satu_bulan)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_box_bulan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_box_tahun))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pilih_file, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lokasi_pilih, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(export)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportActionPerformed

        try {
            // TODO add your handling code here:
            if (lokasi_pilih.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Pilih Lokasi Simpan File Terlebih Dahulu!");
            } else {
                LaporanProduk();
            }
        } catch (IOException ex) {
            Logger.getLogger(DialogLaporan.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WriteException ex) {
            Logger.getLogger(DialogLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_exportActionPerformed

    private void pilih_fileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilih_fileActionPerformed
        // TODO add your handling code here:
        String path;

        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("choosertitle");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            lokasi_pilih.setText(chooser.getSelectedFile().getPath());
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_pilih_fileActionPerformed

    private void satu_bulanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_satu_bulanItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_satu_bulanItemStateChanged

    private void satu_bulanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_satu_bulanMouseReleased
        // TODO add your handling code here:
        combo_box_bulan.removeAllItems();
        if (satu_bulan.isSelected()) {
            vectorBulan.add("Januari");
            vectorBulan.add("Februari");
            vectorBulan.add("Maret");
            vectorBulan.add("April");
            vectorBulan.add("Mei");
            vectorBulan.add("Juni");
            vectorBulan.add("Juli");
            vectorBulan.add("Agustus");
            vectorBulan.add("September");
            vectorBulan.add("Oktober");
            vectorBulan.add("November");
            vectorBulan.add("Desember");

            combo_box_bulan.setModel(new DefaultComboBoxModel(vectorBulan));
        }
    }//GEN-LAST:event_satu_bulanMouseReleased

    private void tiga_bulanMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tiga_bulanMouseReleased
        // TODO add your handling code here:
        combo_box_bulan.removeAllItems();
        if (tiga_bulan.isSelected()) {
            vectorBulan.add("Januari,Februari,Maret");
            vectorBulan.add("April,Mei,Juni");
            vectorBulan.add("Juli,Agustus,September");
            vectorBulan.add("Oktober,November,Desember");

            combo_box_bulan.setModel(new DefaultComboBoxModel(vectorBulan));
        }
    }//GEN-LAST:event_tiga_bulanMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogLaporan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogLaporan dialog = new DialogLaporan(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupLaporan;
    private javax.swing.JComboBox<String> combo_box_bulan;
    private javax.swing.JComboBox<String> combo_box_tahun;
    private javax.swing.JButton export;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lokasi_pilih;
    private javax.swing.JButton pilih_file;
    private javax.swing.JRadioButton satu_bulan;
    private javax.swing.JRadioButton tiga_bulan;
    // End of variables declaration//GEN-END:variables
}
