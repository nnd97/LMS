/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Control.LibrarianControl;
import Object.Person;
import javax.swing.JOptionPane;

/**
 *
 * @author DAT
 */
public class Librarian extends Account {
    private String id;
    public Person person;

    public Librarian() {
    }

    public Librarian(Person person, String account, String password, String role) {
        super(account, password, role);
        this.person = person;
    }

    public String getId() {
        return id;
    } 
    
   public void addLibrarian(Member mb) {
        if (LibrarianControl.addMember(mb)) {
            JOptionPane.showMessageDialog(null, "Đã thêm thủ thư thành công!", "Thông báo", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa thêm thành công!", "Thông báo", 1);
        }
    }
    
    public void deleteMember(Member mb) {
        if (LibrarianControl.deleteMember(mb)) {
            JOptionPane.showMessageDialog(null, "Đã xóa thủ thư thành công!", "Thông báo", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa xóa thành công!", "Thông báo", 1);
        }
    }
}
