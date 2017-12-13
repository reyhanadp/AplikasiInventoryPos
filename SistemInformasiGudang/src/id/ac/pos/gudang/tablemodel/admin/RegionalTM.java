/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel.admin;

import id.ac.pos.gudang.entity.Regional;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oyoy
 */
public class RegionalTM extends AbstractTableModel {

    private ArrayList<Regional> arrayRegional;

    public void setDataRegional(ArrayList<Regional> arrayRegional) {
        this.arrayRegional = arrayRegional;
    }

    @Override
    public int getRowCount() {
        return arrayRegional.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayRegional.get(rowIndex).getIdRegional();
            case 1:
                return arrayRegional.get(rowIndex).getNamaRegional();
            case 2:
                return arrayRegional.get(rowIndex).getKodePos();
            case 3:
                return arrayRegional.get(rowIndex).getNoTelp();
            case 4:
                return arrayRegional.get(rowIndex).getAlamat();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id Regional";
            case 1:
                return "Regional";
            case 2:
                return "Kode Pos";
            case 3:
                return "No. Telepon";
            case 4:
                return "Alamat";
        }
        return null;
    }

}
