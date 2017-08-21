/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel;

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
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayRegional.get(rowIndex).getIdRegional();

            case 1:
                return arrayRegional.get(rowIndex).getRegional();
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
        }
        return null;
    }

}
