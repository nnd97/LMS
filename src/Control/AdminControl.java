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
import Object.EnumAndConstant.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gaara
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
        String sql_librarian = "insert into librarian values(?,?,?)";
        String sql_account = "insert into account values(?,?,?)";
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_librarian);

            ps.setString(1, lib.person.getName());
            ps.setString(2, lib.person.getAddress());
            ps.setString(3, lib.person.getPhoneNumber());
            ps.execute();
        } catch (HeadlessException | SQLException e) {
            return false;
        }

        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_account);

            ps.setString(1, lib.getId());
            ps.setString(2, lib.getPassword());
            ps.setString(3, lib.getRole());
            ps.execute();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
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
