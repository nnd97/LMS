/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author DAT
 */
public class ConnectDB {

    private static Connection conn;

    public static Connection getConnect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/db_lms", "root", "root");
            System.out.println("Kết nối thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Kết nối không thành công!");
        }

        return conn;
    }

    public static String testConnect() {
        try {
            conn = ConnectDB.getConnect();
            return "Kết nối thành công";
        } catch (Exception e) {
            return "Kết nối thất bại";
        }
    }
}
