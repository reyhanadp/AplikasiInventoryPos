/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.Panel;

import id.ac.pos.gudang.dao.LaporanDAO;
import id.ac.pos.gudang.dao.PengembalianDAO;
import id.ac.pos.gudang.daoimpl.LaporanDAOImpl;
import id.ac.pos.gudang.daoimpl.PengembalianDAOImpl;
import id.ac.pos.gudang.entity.Pengembalian;
import id.ac.pos.gudang.entity.Produk;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.NumberFormatter;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

/**
 *
 * @author Operator
 */
public class PanelLaporan extends javax.swing.JPanel {

    LaporanDAO dao_laporan = new LaporanDAOImpl();
    Calendar cal = Calendar.getInstance();
    ArrayList<Produk> arrayProdukTahun, arrayProduk;

    /**
     * Creates new form PanelLaporan
     *
     * @throws java.io.IOException
     * @throws jxl.write.WriteException
     */
    public PanelLaporan() throws IOException, WriteException {
        initComponents();

    }

    public void LaporanProduk() throws IOException, WriteException {
        arrayProdukTahun = dao_laporan.getTahunTerkecil();

        String tahun_kecil_str = arrayProdukTahun.get(0).getTahun();
        int tahun_kecil = Integer.parseInt(tahun_kecil_str);

        int tahun_besar_integer = cal.get(Calendar.YEAR);
        String tahun_besar = Integer.toString(tahun_besar_integer);

        int bulan = cal.get(Calendar.MONTH);
        String bulan_str = null;
        if(bulan == 1){
            bulan_str = "Januari";
        }else if(bulan == 2){
            bulan_str = "Februari";
        }else if(bulan == 3){
            bulan_str = "Maret";
        }else if(bulan == 4){
            bulan_str = "April";
        }else if(bulan == 5){
            bulan_str = "Mei";
        }else if(bulan == 6){
            bulan_str = "Juni";
        }else if(bulan == 7){
            bulan_str = "Juli";
        }else if(bulan == 8){
            bulan_str = "Agustus";
        }else if(bulan == 9){
            bulan_str = "September";
        }else if(bulan == 10){
            bulan_str = "Oktober";
        }else if(bulan == 11){
            bulan_str = "November";
        }else if(bulan == 12){
            bulan_str = "Desember";
        }

        String path = new File(".").getCanonicalPath();

        WritableWorkbook workbook = Workbook.createWorkbook(new File(path + "/excel/laporan_" + bulan_str + "_" + tahun_besar + ".xls"));
        WritableSheet sheet = workbook.createSheet("A. Prangko", 0);
        WritableSheet sheet1 = workbook.createSheet("B.MS & SS", 1);

        WritableCellFormat judul_tabel = new WritableCellFormat();
        judul_tabel.setWrap(true);
        judul_tabel.setAlignment(Alignment.CENTRE);
        judul_tabel.setVerticalAlignment(VerticalAlignment.CENTRE);
        judul_tabel.setBorder(Border.ALL, BorderLineStyle.MEDIUM);

        WritableCellFormat isi_sub_tabel = new WritableCellFormat();
        isi_sub_tabel.setBorder(Border.BOTTOM, BorderLineStyle.DOTTED);
        isi_sub_tabel.setBorder(Border.RIGHT, BorderLineStyle.THIN);
        isi_sub_tabel.setBorder(Border.LEFT, BorderLineStyle.THIN);
        isi_sub_tabel.setBorder(Border.TOP, BorderLineStyle.DOTTED);
        
        WritableCellFormat isi_no = new WritableCellFormat();
        isi_no.setBorder(Border.BOTTOM, BorderLineStyle.DOTTED);
        isi_no.setBorder(Border.RIGHT, BorderLineStyle.THIN);
        isi_no.setBorder(Border.LEFT, BorderLineStyle.THIN);
        isi_no.setBorder(Border.TOP, BorderLineStyle.DOTTED);
        isi_no.setAlignment(Alignment.CENTRE);
        
        WritableCellFormat isi_jumlah_tahun = new WritableCellFormat();
        isi_jumlah_tahun.setBorder(Border.BOTTOM, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.RIGHT, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.LEFT, BorderLineStyle.MEDIUM);
        isi_jumlah_tahun.setBorder(Border.TOP, BorderLineStyle.MEDIUM);

        WritableCellFormat numberCellFormat = new WritableCellFormat(NumberFormats.INTEGER);
        numberCellFormat.setWrap(true);
        numberCellFormat.setAlignment(Alignment.CENTRE);
        numberCellFormat.setVerticalAlignment(VerticalAlignment.CENTRE);
        numberCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

        WritableCellFormat priceCellFormat = new WritableCellFormat(NumberFormats.FLOAT);
        priceCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);

        WritableCellFormat times;
        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
        // Define the cell format
        times = new WritableCellFormat(times10pt);
        // Lets automatically wrap the cells
        times.setWrap(true);
        
        int banyak_produk = 0;
        String jenis_produk = "PR";
        for (int i = 0; i < arrayProdukTahun.size(); i++) {
            
            arrayProduk = dao_laporan.getProduk(jenis_produk, arrayProdukTahun.get(i).getTahun());
            //kolom,baris,kolom,baris

            if (i == 0) {
                sheet.setColumnView(1, 30);
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
                
                sheet.addCell(new jxl.write.Label(0, 1, "A.PRANGKO"));
                sheet.addCell(new jxl.write.Label(6, 1, bulan_str+" "+tahun_besar));
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
                sheet.addCell(new jxl.write.Label(1, 4, "1", judul_tabel));
                sheet.addCell(new jxl.write.Label(2, 4, "2", judul_tabel));
                sheet.addCell(new jxl.write.Label(3, 4, "3", judul_tabel));
                sheet.addCell(new jxl.write.Label(4, 4, "4", judul_tabel));
                sheet.addCell(new jxl.write.Label(5, 4, "5", judul_tabel));
                sheet.addCell(new jxl.write.Label(6, 4, "6=(4+5)", judul_tabel));
                sheet.addCell(new jxl.write.Label(7, 4, "7", judul_tabel));
                sheet.addCell(new jxl.write.Label(8, 4, "8=(6-7)", judul_tabel));
                sheet.addCell(new jxl.write.Label(9, 4, "9=(2x8)", judul_tabel));
                sheet.addCell(new jxl.write.Label(10, 4, "10=(3x8)", judul_tabel));
                sheet.addCell(new jxl.write.Label(1, 5, "PRANGKO TAHUN " + arrayProdukTahun.get(i).getTahun(), isi_sub_tabel));
                
                sheet.addCell(new jxl.write.Label(0, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(2, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(3, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(4, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(5, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(6, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(7, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(8, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(9, 5, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(10, 5, "", isi_sub_tabel));
                
                for(int j = 0 ; j < arrayProduk.size() ; j++){
                    sheet.addCell(new jxl.write.Label(0, 6+j, Integer.toString(j+1), isi_no));
                    sheet.addCell(new jxl.write.Label(1, 6+j, arrayProduk.get(j).getNamaProduk(), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(2, 6+j, Integer.toString(arrayProduk.get(j).getNominal()), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(3, 6+j, Float.toString(arrayProduk.get(j).getBiayaCetak()), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(4, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(5, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(6, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(7, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(8, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(9, 6+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(10, 6+j, "", isi_sub_tabel));
                }
                
                sheet.addCell(new jxl.write.Label(0, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(1, 6+arrayProduk.size(), "Jumlah Tahun "+arrayProdukTahun.get(i).getTahun(), isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(2, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(3, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(4, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(5, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(6, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(7, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(8, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(9, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(10, 6+arrayProduk.size(), "", isi_jumlah_tahun));
                
                
                banyak_produk = 8+arrayProduk.size();
            }else if(i != 0){
                
                arrayProduk = dao_laporan.getProduk(jenis_produk, arrayProdukTahun.get(i).getTahun());
                
                sheet.mergeCells(0, banyak_produk, 0, banyak_produk+2);
                sheet.mergeCells(1, banyak_produk, 1, banyak_produk+1);
                sheet.mergeCells(2, banyak_produk, 2, banyak_produk+1);
                sheet.mergeCells(3, banyak_produk, 3, banyak_produk+1);
                sheet.mergeCells(4, banyak_produk, 8, banyak_produk);
                sheet.mergeCells(9, banyak_produk, 9, banyak_produk+1);
                sheet.mergeCells(10, banyak_produk, 10, banyak_produk+1);
                
                sheet.addCell(new jxl.write.Label(0, banyak_produk, "No", judul_tabel));
                sheet.addCell(new jxl.write.Label(1, banyak_produk, "Uraian", judul_tabel));
                sheet.addCell(new jxl.write.Label(2, banyak_produk, "Nominal", judul_tabel));
                sheet.addCell(new jxl.write.Label(3, banyak_produk, "Biaya Cetak", judul_tabel));
                sheet.addCell(new jxl.write.Label(4, banyak_produk, "STOK AKHIR", judul_tabel));
                sheet.addCell(new jxl.write.Label(9, banyak_produk, "BSU", judul_tabel));
                sheet.addCell(new jxl.write.Label(10, banyak_produk, "Nilai Instrinsik", judul_tabel));
                sheet.addCell(new jxl.write.Label(4, banyak_produk+1, "Gudang Pusat", judul_tabel));
                sheet.addCell(new jxl.write.Label(5, banyak_produk+1, "Penerimaan", judul_tabel));
                sheet.addCell(new jxl.write.Label(6, banyak_produk+1, "Jumlah", judul_tabel));
                sheet.addCell(new jxl.write.Label(7, banyak_produk+1, "Pengeluaran", judul_tabel));
                sheet.addCell(new jxl.write.Label(8, banyak_produk+1, "Jumlah", judul_tabel));
                sheet.addCell(new jxl.write.Label(1, banyak_produk+2, "1", judul_tabel));
                sheet.addCell(new jxl.write.Label(2, banyak_produk+2, "2", judul_tabel));
                sheet.addCell(new jxl.write.Label(3, banyak_produk+2, "3", judul_tabel));
                sheet.addCell(new jxl.write.Label(4, banyak_produk+2, "4", judul_tabel));
                sheet.addCell(new jxl.write.Label(5, banyak_produk+2, "5", judul_tabel));
                sheet.addCell(new jxl.write.Label(6, banyak_produk+2, "6=(4+5)", judul_tabel));
                sheet.addCell(new jxl.write.Label(7, banyak_produk+2, "7", judul_tabel));
                sheet.addCell(new jxl.write.Label(8, banyak_produk+2, "8=(6-7)", judul_tabel));
                sheet.addCell(new jxl.write.Label(9, banyak_produk+2, "9=(2x8)", judul_tabel));
                sheet.addCell(new jxl.write.Label(10, banyak_produk+2, "10=(3x8)", judul_tabel));
                sheet.addCell(new jxl.write.Label(1, banyak_produk+3, "PRANGKO TAHUN " + arrayProdukTahun.get(i).getTahun(), isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(0, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(2, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(3, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(4, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(5, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(6, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(7, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(8, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(9, banyak_produk+3, "", isi_sub_tabel));
                sheet.addCell(new jxl.write.Label(10, banyak_produk+3, "", isi_sub_tabel));
                
                for(int j = 0 ; j < arrayProduk.size() ; j++){
                    sheet.addCell(new jxl.write.Label(0, banyak_produk+4+j, Integer.toString(j+1), isi_no));
                    sheet.addCell(new jxl.write.Label(1, banyak_produk+4+j, arrayProduk.get(j).getNamaProduk(), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(2, banyak_produk+4+j, Integer.toString(arrayProduk.get(j).getNominal()), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(3, banyak_produk+4+j, Float.toString(arrayProduk.get(j).getBiayaCetak()), isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(4, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(5, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(6, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(7, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(8, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(9, banyak_produk+4+j, "", isi_sub_tabel));
                    sheet.addCell(new jxl.write.Label(10, banyak_produk+4+j, "", isi_sub_tabel));
                }
                
                sheet.addCell(new jxl.write.Label(0, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(1, banyak_produk+4+arrayProduk.size(), "Jumlah Tahun "+arrayProdukTahun.get(i).getTahun(), isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(2, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(3, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(4, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(5, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(6, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(7, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(8, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(9, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                sheet.addCell(new jxl.write.Label(10, banyak_produk+4+arrayProduk.size(), "", isi_jumlah_tahun));
                
                banyak_produk = banyak_produk+6+arrayProduk.size();
                
            }

        }

//        int number=1;
//        int cellRow=3;
//        int banyak = arrayPengembalian.size();
//        int rowindex = 0;
//        while (0 < banyak) {
//            
//            sheet.mergeCells(1, cellRow, 3, cellRow);
//            sheet.mergeCells(5, cellRow, 14, cellRow);
//            
//            jxl.write.Number number1;
//            number1 = new jxl.write.Number(0, cellRow, number, cellFormat);
//            
//            jxl.write.Label label1;
//            label1 = new jxl.write.Label(4, cellRow, arrayPengembalian.get(rowindex).getId_produk(),cellFormat);
//            
//            jxl.write.Label label;
//            label = new jxl.write.Label(1, cellRow, arrayPengembalian.get(rowindex).getId_pengembalian(),cellFormat);
//            
//            jxl.write.Label label2;
//            label2 = new jxl.write.Label(5, cellRow, arrayPengembalian.get(rowindex).getId_regional(),cellFormat);
//            
//            sheet.addCell(number1);
//            sheet.addCell(label);
//            sheet.addCell(label1);
//            sheet.addCell(label2);
//            number++;
//            cellRow++;
//            
//            
//            banyak--;
//            rowindex++;
//        }
        workbook.write();
        workbook.close();

    }

//    public void tambah() throws IOException,WriteException {
//        PengembalianDAO dao = new PengembalianDAOImpl();
//        
//        ArrayList<Pengembalian> arrayPengembalian = dao.getPengembalianPrangko();
//        
//        String path=new File(".").getCanonicalPath();
//        
//        WritableWorkbook workbook=Workbook.createWorkbook(new File(path+"/excel/report.xls"));
//        WritableSheet sheet=workbook.createSheet("Sheet 1", 0);
//        
//        WritableCellFormat cellFormat=new WritableCellFormat();
//        cellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//        
//        WritableCellFormat numberCellFormat=new WritableCellFormat(NumberFormats.INTEGER);
//        numberCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//        
//        WritableCellFormat priceCellFormat=new WritableCellFormat(NumberFormats.FLOAT);
//        priceCellFormat.setBorder(Border.ALL, BorderLineStyle.THIN);
//        
//        sheet.mergeCells(2, 1, 5, 1);
//        sheet.mergeCells(1, 2, 3, 2);
//        sheet.mergeCells(5, 2, 14, 2);
//        
//        jxl.write.Label lblHeader=new jxl.write.Label(2, 1, "Product Report");
//        sheet.addCell(lblHeader);
//        
//        jxl.write.Label lblNo=new jxl.write.Label(0, 2, "No",cellFormat);
//        sheet.addCell(lblNo);
//        
//        jxl.write.Label lblName=new jxl.write.Label(1, 2, "Name",cellFormat);
//        sheet.addCell(lblName);
//        
//        jxl.write.Label lblPrice=new jxl.write.Label(4, 2, "Price",cellFormat);
//        sheet.addCell(lblPrice);
//        
//        jxl.write.Label lblDescription=new jxl.write.Label(5, 2, "Description",cellFormat);
//        sheet.addCell(lblDescription);
//        
//        WritableCellFormat times;
//        WritableFont times10pt = new WritableFont(WritableFont.TIMES, 10);
//        // Define the cell format
//        times = new WritableCellFormat(times10pt);
//        // Lets automatically wrap the cells
//        times.setWrap(true);
//          
//        int number=1;
//        int cellRow=3;
//        int banyak = arrayPengembalian.size();
//        int rowindex = 0;
//        while (0 < banyak) {
//            
//            sheet.mergeCells(1, cellRow, 3, cellRow);
//            sheet.mergeCells(5, cellRow, 14, cellRow);
//            
//            jxl.write.Number number1;
//            number1 = new jxl.write.Number(0, cellRow, number, cellFormat);
//            
//            jxl.write.Label label1;
//            label1 = new jxl.write.Label(4, cellRow, arrayPengembalian.get(rowindex).getId_produk(),cellFormat);
//            
//            jxl.write.Label label;
//            label = new jxl.write.Label(1, cellRow, arrayPengembalian.get(rowindex).getId_pengembalian(),cellFormat);
//            
//            jxl.write.Label label2;
//            label2 = new jxl.write.Label(5, cellRow, arrayPengembalian.get(rowindex).getId_regional(),cellFormat);
//            
//            sheet.addCell(number1);
//            sheet.addCell(label);
//            sheet.addCell(label1);
//            sheet.addCell(label2);
//            number++;
//            cellRow++;
//            
//            
//            banyak--;
//            rowindex++;
//        }
//        workbook.write();
//        workbook.close();
//    
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton1)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jButton1)
                .addContainerGap(202, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            LaporanProduk();
        } catch (IOException | WriteException ex) {
            Logger.getLogger(PanelLaporan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
