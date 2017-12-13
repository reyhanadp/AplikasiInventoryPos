/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.tablemodel.admin;

import id.ac.pos.gudang.entity.User;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Oyoy
 */
public class UserTM extends AbstractTableModel {

    private ArrayList<User> arrayUser;

    public void setDataUser(ArrayList<User> arrayUser) {
        this.arrayUser = arrayUser;
    }

    @Override
    public int getRowCount() {
        return arrayUser.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return arrayUser.get(rowIndex).getNik();
            case 1:
                return arrayUser.get(rowIndex).getPassword();
            case 2:
                return arrayUser.get(rowIndex).getNamaUser();
            case 3:
                return arrayUser.get(rowIndex).getHakAkses();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "NIK";
            case 1:
                return "Password";
            case 2:
                return "Nama User";
            case 3:
                return "Hak Akses";
        }
        return null;
    }

}
