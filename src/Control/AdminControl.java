/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Object.Admin;
import Object.Librarian;
import Object.Member;
import java.awt.HeadlessException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author DAT
 */
public class AdminControl {

    public static PreparedStatement ps;
    public static ResultSet rs;

   

    public boolean updateAdmin(Admin ad) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("UPDATE admin SET id = ? where password = ?");
            ps.setString(1, ad.getId());
            ps.setString(2, ad.getPassword());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteAdmin(String id) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM admin WHERE id = ?");
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean addLibrarian(Librarian lib) {
        String sql_account = "insert into account values(?,?,?)";
        String sql_librarian = "insert into librarian (name, phone_number, address,account_id) values(?,?,?,?)";
        
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_account);

            ps.setString(1, lib.getAccount());
            ps.setString(2, lib.getPassword());
            ps.setString(3, lib.getRole());
            ps.execute();
            System.out.println("insert account success");
        } catch (HeadlessException | SQLException e) {
            System.out.println("insert account fail");
            return false;
        }

        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_librarian);

            
            ps.setString(1, lib.person.getName());
            ps.setString(3, lib.person.getAddress());
            ps.setString(2, lib.person.getPhoneNumber());
            ps.setString(4, lib.getAccount());
            ps.execute();
            System.out.println("insert lib success");
            return true;
            
        } catch (HeadlessException | SQLException e) {
            System.out.println("insert lib fail");
            return false;
        }

    }

    public static void listLibrarian(JTable jtb){
        try {
            
            ps = ConnectDB.getConnect().prepareStatement("SELECT * FROM librarian");
            ResultSet rs = ps.executeQuery();
            jtb.setModel((TableModel) rs);
        } catch (SQLException ex) {
            Logger.getLogger(AdminControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static boolean deleteLibrarian(Librarian lib) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM librarian WHERE id = ?");
            ps.setString(1, lib.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean deleteMember(Member mb) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM member WHERE id = ?");
            ps.setString(1, mb.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
