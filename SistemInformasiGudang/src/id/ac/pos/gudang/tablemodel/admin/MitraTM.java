/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.tablemodel.admin;

import id.ac.pos.gudang.entity.Mitra;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oyoy
 */
public class MitraTM extends AbstractTableModel{

    private ArrayList<Mitra> arrayMitra;
    
    public void setDataMitra(ArrayList<Mitra> arrayMitra) {
        this. arrayMitra = arrayMitra;
    }
    
    @Override
    public int getRowCount() {
        return arrayMitra.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayMitra.get(rowIndex).getId_supplier();
            case 1:
                return arrayMitra.get(rowIndex).getNama_suplier();
            case 2:
                return arrayMitra.get(rowIndex).getAlamat();
            case 3:
                return arrayMitra.get(rowIndex).getNo_telp();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
         switch (column) {
            case 0:
                return "ID Mitra";
            case 1:
                return "Nama Mitra";
            case 2:
                return "Alamat";
            case 3:
                return "No. Telp";
        }
        return null;
    }
}
