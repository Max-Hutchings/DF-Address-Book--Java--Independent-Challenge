package com.addressbook.entity;

import java.util.ArrayList;




// TODO: build test for added contact to contacts
// TODO: build test and implement for print address book

public class AddressBook {
    private static int nextId = 1;
    private int id;
    private String addressBookName;
    private int userId;
    private ArrayList<Contact> contacts;


    public AddressBook(String addressBookName){
        this.addressBookName = addressBookName;
    }

    public AddressBook(int id, String addressBookName, int userId){
        this.id = id;
        this.addressBookName = addressBookName;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getAddressBookName() {
        return addressBookName;
    }

    public void setAddressBookName(String addressBookName) {
        this.addressBookName = addressBookName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact){
        contacts.add(contact);
        System.out.println("Added " + contact.getName() + " to contacts.");
    }
}
