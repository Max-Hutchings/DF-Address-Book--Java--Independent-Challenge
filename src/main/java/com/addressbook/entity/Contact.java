package com.addressbook.entity;

// TODO: build test and implement get contacts details

public class Contact {

    private static int nextId = 1;
    private int id;
    private String name;
    private Long phoneNumber;
    private String email;
    private int addressBookId;

    public Contact(String name, Long phoneNumber, String email){
        this.id = Contact.nextId ++;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public Contact(int id, int addressBookId, String name, Long phoneNumber, String email){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressBookId = addressBookId;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressBookId() {
        return addressBookId;
    }

}
