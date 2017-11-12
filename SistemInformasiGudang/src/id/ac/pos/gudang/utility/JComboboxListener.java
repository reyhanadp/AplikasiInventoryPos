/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.utility;

import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author reyha
 */
public class JComboboxListener extends KeyAdapter {
    JComboBox comboBox;
    Vector list;
     
    public JComboboxListener(JComboBox comboBox, Vector list){
        this.comboBox = comboBox;
        this.list = list;
    }
     
    @Override
    public void keyTyped(final KeyEvent e){
        
        
        EventQueue.invokeLater(new Runnable(){
             
            @SuppressWarnings("unchecked")
            @Override
            public void run(){
                String text = ((JTextField)e.getSource()).getText();
                comboBox.setModel(new DefaultComboBoxModel(getFilteredList(text)));
                comboBox.setSelectedIndex(-1);
                ((JTextField) comboBox.getEditor().getEditorComponent()).setText(text);
                comboBox.showPopup();
            }
        });
    }
     
    public Vector getFilteredList(String text){
        Vector listResult = new Vector();
        for(int i=0; i < list.size(); i++){
            if(list.get(i).toString().startsWith(text)){
                listResult.add(list.get(i).toString());
            }
        }
        return listResult;
    }
}
