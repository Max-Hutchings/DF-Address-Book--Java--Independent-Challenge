package com.addressbook.entity;

import com.addressbook.validator.Validators;

import java.util.ArrayList;

public class User {

    private int id;
    private String fName;
    private String lName;
    private String phoneNumber;
    private String email;
    private ArrayList<AddressBook> addressBooks = new ArrayList<>();

    public User(String fName, String lName, String phoneNumber, String email) throws Exception {

        this.fName = Validators.validateName(fName);
        this.lName = Validators.validateName(lName);
        this.phoneNumber = Validators.validatePhoneNumber(phoneNumber);
        this.email = Validators.validateEmail(email).toString();
    }

    public User(int id, String fName, String lName, String phoneNumber, String email){
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

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }

    public ArrayList<AddressBook> getAddressBookArrayList(){
        return addressBooks;
    }

//    Adds the address book and links the user id to the address book.
    public void addAddressBook(AddressBook addressBook){
        this.addressBooks.add(addressBook);
        addressBook.setUserId(this.id);
        System.out.println("Added to " + this.fName + "'s address books");
    }

    public void setFName(String fName) throws Exception {
        this.fName = Validators.validateName(fName);
    }

    public void setLName(String lName) throws Exception {
        this.lName = Validators.validateName(lName);
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        this.phoneNumber = Validators.validatePhoneNumber(phoneNumber);
    }

    public void setEmail(String email) throws Exception {
        this.email = Validators.validateEmail(email).toString();
    }

    public String printAddressBooks(){
        StringBuilder addressBookList = new StringBuilder();
        addressBookList.append(this.getFullName()).append("'s address books");
        addressBookList.append("\n------------------------");
        if (this.addressBooks.isEmpty()){
            addressBookList.append("\nNo address books yet for ").append(this.getFName());
            System.out.println(addressBookList);
            return addressBookList.toString();
        }else {
            for (AddressBook addressBook : this.addressBooks) {
                addressBookList.append("\n");
                addressBookList.append(addressBook.getAddressBookName());
            }
            System.out.println(addressBookList);
            return addressBookList.toString();
        }
    }


}

