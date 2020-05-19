/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Object.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAT
 */
public class AccountControl {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public static Account login(String account, String password, String role) {
        Account acc = null;

        try {
            ps = ConnectDB.getConnect().prepareStatement("SELECT * FROM account where id = ? and password = ? and role = ?");
            ps.setString(1, account);
            ps.setString(2, password);
            ps.setString(3, role);
            rs = ps.executeQuery();
            while (rs.next()) {
                acc = new Account();
                acc.setAccount(rs.getString("id"));
                acc.setPassword(rs.getString("password"));
                acc.setRole(rs.getString("role"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return acc;
    }
}
