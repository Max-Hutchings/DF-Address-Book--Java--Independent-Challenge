package com.addressbook.entity;

import java.util.ArrayList;



public class AddressBook {

    private int id;
    private String addressBookName;
    private int userId;
    private ArrayList<Contact> contacts = new ArrayList<>();
    private String createdDate;


    public AddressBook(String addressBookName, User user){
        this.addressBookName = addressBookName;
        this.userId = user.getId();

    }

    public AddressBook(int id, String addressBookName, int userId){
        this.id = id;
        this.addressBookName = addressBookName;
        this.userId = userId;
        this.createdDate = "17-03-2001";
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

    public Contact findContact(String name){
        for (Contact contact: contacts){
            if (contact.getName().equals(name)){
                System.out.println(contact.getContactDetails());
                return contact;
            }
        }
        System.out.println("Failed to find user");
        return null;
    }


    public void removeContact(Contact contact){
        contacts.remove(contact);
        System.out.println("Removed " + contact.getName() + " from contacts.");
    }

    public String printAddressBook(){
        StringBuilder message = new StringBuilder();
        message.append(this.addressBookName);
        message.append("\n-----------------------------------------------------------------");
        message.append("\nContacts");
        message.append("\n-----------------------------------------------------------------\n");

        if (contacts.isEmpty()){
            message.append(" - Add a contact :) \n");
        }else{
            for (Contact contact: contacts){
                message.append(contact.getName());
                message.append(" | ");
                message.append(contact.getPhoneNumber());
                message.append(" | ");
                message.append(contact.getEmail());
                message.append("\n");
            }
        }
        System.out.println(message);
        return message.toString();

    }
}
