/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Object.Person;

/**
 *
 * @author DAT
 */
public class Member extends Account {

    private String id;
    public Person person;

    public Member() {
    }

    public Member(Person person, String account, String password, String role) {
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
}
