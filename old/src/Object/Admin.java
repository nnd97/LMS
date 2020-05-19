/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Control.AdminControl;
import Object.Person;
import javax.swing.JOptionPane;

/**
 *
 * @author DAT
 */
public class Admin extends Account {

    private String id;
    public Person person;

    public Admin() {
    }

    public Admin(Person person, String account, String password, String role) {
        super(account, password, role);
        this.person = person;
    }


    public String getId() {
        return id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    

    public void addLibrarian(Librarian lib) {
        if (AdminControl.addLibrarian(lib)) {
            JOptionPane.showMessageDialog(null, "Đã thêm thủ thư thành công!", "Thông báo", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa thêm thành công!", "Thông báo", 1);
        }
    }
    
    public void deleteLibrarian(Librarian lib) {
        if (AdminControl.deleteLibrarian(lib)) {
            JOptionPane.showMessageDialog(null, "Đã xóa thủ thư thành công!", "Thông báo", 1);
        } else {
            JOptionPane.showMessageDialog(null, "Chưa xóa thành công!", "Thông báo", 1);
        }
    }
}
