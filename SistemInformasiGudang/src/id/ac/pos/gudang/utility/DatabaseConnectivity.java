/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.ac.pos.gudang.utility;

import com.mysql.jdbc.Driver;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dea
 */
public class DatabaseConnectivity {
    
    private static Connection conn;
    private static Process runtimeProcess;
    private final static String url = "jdbc:mysql://localhost:3306/db_inventory_pos";
    private final static String user  = "root";
    private final static String password = "";
        
    public static Connection getConnection() throws IOException, InterruptedException {
        try {
            DriverManager.registerDriver(new Driver());
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            String error = ex.getMessage();
            if("Unknown database 'db_inventory_pos'".equals(error)){
                String database = "db_inventory_pos";
                String path = new File(".").getCanonicalPath();
                runtimeProcess = Runtime.getRuntime().exec("C:\\xampp\\mysql\\bin\\mysql -u root -e \"create database db_inventory_pos\"");
                
                String[] kata = new String[]{"C:\\xampp\\mysql\\bin\\mysql", database, "-uroot", "-e", " source "+path+"\\db_inventory_pos.sql"};
                runtimeProcess = Runtime.getRuntime().exec(kata);
                int prosesSukses=runtimeProcess.waitFor();
                if(prosesSukses==0){
                    JOptionPane.showMessageDialog(null, "Restore database Sukses");
                } else {
                    JOptionPane.showMessageDialog(null, "Restore database gagal");
                }
            }
            
            System.out.println("pesan error koneksi : "+error);
            System.out.println("Koneksi database gagal dengan pesan : " + ex.getMessage());
        }
        return conn;
    }
}
