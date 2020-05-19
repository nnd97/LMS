/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Object.Member;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Gaara
 */
public class MemberControl {

    public static PreparedStatement ps;
    public static ResultSet rs;

    

     
    public boolean Update(Member mb) {
        try {
            ps = ConnectDB.getConnect().prepareStatement("UPDATE member SET name = ?,"
                    + "address = ?, phone_number = ?");


            ps.setString(1, mb.person.getName());
            ps.setString(2, mb.person.getAddress());
            ps.setString(3, mb.person.getPhoneNumber());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    

}
