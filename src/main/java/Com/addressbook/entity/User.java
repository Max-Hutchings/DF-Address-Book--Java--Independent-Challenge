package main.java.com.addressbook.entity;

// TODO: add address book test and method
// TODO: Build test for and implement print address books


import main.java.com.addressbook.entity.AddressBook;

import java.util.ArrayList;

public class User {
    private static int nextId = 1;
    private int id;
    private String fName;
    private String lName;
    private Long phoneNumber;
    private String email;
    private ArrayList<AddressBook> addressBooks;

    User(String fName, String lName, Long phoneNumber, String email){
        this.id = User.nextId ++;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    User(int id, String fName, String lName, Long phoneNumber, String email){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId(){
        return id;
    }

    public String getFName(){
        return fName;
    }

    public String getLName(){
        return lName;
    }

    public String getFullName(){
        return fName + " " + lName;
    }

    public Long getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<AddressBook> getAddressBooks(){
        return addressBooks;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public void setPhoneNumber(Long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

