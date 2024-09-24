/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Murach.business;

import java.io.Serializable;


/**
 *
 * @author Admin
 */

public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String birthDay;
    private String social;
    private String selectOption;
    private String contact;
    
    public User() {
        firstName = "";
        lastName = "";
        email = "";
        birthDay="";
        social="";
        selectOption="";
        contact="";
    }
    
    public User(String firstName, String lastName, String email,String birthDay,String social, String selectOption,String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDay=birthDay;
        this.social= social;
        this.selectOption=selectOption;
        this.contact= contact;
        
    }
    public String getContact()
    {
        return contact;
    }
    public String getSocial()
    {
        return social;
    }
    public String getSelectOption()
    {
        return selectOption;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setBirthday(String birthDay)
    {
        this.birthDay= birthDay;
    }
    public String getbirthDay()
    {
        return birthDay;
    }
}