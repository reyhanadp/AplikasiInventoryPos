/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang;

import id.ac.pos.gudang.utility.DatabaseConnectivity;
import java.awt.EventQueue;
import java.awt.List;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author muhamad solahudin
 */
public class keyTextField extends KeyAdapter{
    private final Connection conn = DatabaseConnectivity.getConnection();
    private final JTextField jTextField7;
    @SuppressWarnings("rawtypes")
    ArrayList daftar;

    public keyTextField(JTextField txtFieldParam) {
        jTextField7 = txtFieldParam;
        daftar = new ArrayList();
        databaseNama();
    }

    @Override
    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                break;
            case KeyEvent.VK_ENTER:
                jTextField7.setText(jTextField7.getText());
                break;
            default:
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        String kt = jTextField7.getText();
                        autoComplete(kt);

                    }
                });
        }

    }

    public void autoComplete(String kt) {
        String complete = "";
        int start = kt.length();
        int last = kt.length();
        int a;

        for (a = 0; a < daftar.size(); a++) {
            if (daftar.get(a).toString().startsWith(kt)) {
                complete = daftar.get(a).toString();
                last = complete.length();
                break;
            }
        }
        if (last > start) {
            jTextField7.setText(complete);
            jTextField7.setCaretPosition(last);
            jTextField7.moveCaretPosition(start);
        }
    }

    @SuppressWarnings("unchecked")
    private void databaseNama() {
        PreparedStatement state;
        String SELECT = "SELECT nama_produk FROM tb_produk";
        try {
            state = conn.prepareStatement(SELECT);

            try (ResultSet result = state.executeQuery()) {
                while (result.next()) {
                    daftar.add(result.getString("nama_produk"));
                }
            }
            state.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
