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


/**
 *
 * @author DAT
 */
public class LibrarianControl {

    public static PreparedStatement ps;
    public static ResultSet rs;

    public static boolean addMember(Member mb) {
        String sql_member = "insert into member values(?,?,?)";
        String sql_account = "insert into account values(?,?,?)";
        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_member);

            ps.setString(1, mb.person.getName());
            ps.setString(2, mb.person.getAddress());
            ps.setString(3, mb.person.getPhoneNumber());
            ps.execute();
        } catch (HeadlessException | SQLException e) {
            return false;
        }

        try {
            ps = ConnectDB.getConnect().prepareStatement(sql_account);

            ps.setString(1, mb.getId());
            ps.setString(2, mb.getPassword());
            ps.setString(3, mb.getRole());
            ps.execute();
            return true;
        } catch (HeadlessException | SQLException e) {
            return false;
        }
    }

    public static boolean deleteMember(Member mb) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("DELETE FROM member WHERE id = ?");
            ps.setString(1, mb.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }
}
