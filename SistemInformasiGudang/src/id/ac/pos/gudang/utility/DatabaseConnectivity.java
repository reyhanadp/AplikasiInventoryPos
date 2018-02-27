/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pos.gudang.utility;

import com.mysql.jdbc.Driver;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

    public static Connection getConnection() throws IOException, InterruptedException {
        String path = new File(".").getCanonicalPath();
        FileReader fr = new FileReader(path + "\\alamat_ip.txt");
        BufferedReader br = new BufferedReader(fr);
        String alamat_ip = br.readLine();
        try {
            if (alamat_ip.compareTo("localhost") == 0) {
                String url = "jdbc:mysql://"+alamat_ip+":3306/db_inventory_pos";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(url, user, password);
            }else{
                String url = "jdbc:mysql://"+alamat_ip+":3306/db_inventory_pos";
                String user = "radp";
                String password = "123";
                DriverManager.registerDriver(new Driver());
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException ex) {
            String error = ex.getMessage();
            if ("Unknown database 'db_inventory_pos'".equals(error)) {
                String database = "db_inventory_pos";

                runtimeProcess = Runtime.getRuntime().exec("C:\\mysql\\bin\\mysql -u root -e \"create database db_inventory_pos\"");

                String[] kata = new String[]{"C:\\mysql\\bin\\mysql", database, "-uroot", "-e", " source " + path + "\\db_inventory_pos.sql"};
                runtimeProcess = Runtime.getRuntime().exec(kata);
            }

            System.out.println("Koneksi database gagal dengan pesan : " + ex.getMessage());
        }
        return conn;
    }
}
