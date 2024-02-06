package com.addressbook.entity;



import com.addressbook.validator.DatabaseValidators;
import com.addressbook.validator.Validators;

import java.util.HashMap;
import java.util.Map;

public class Contact {

    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private int addressBookId;

    // Constructor for creating a new contact
    public Contact(String name, String phoneNumber, String email, AddressBook addressBook) throws Exception {

        this.name = Validators.validateName(name);
        this.phoneNumber = DatabaseValidators.phoneNumberDatabaseValidator(Validators.validatePhoneNumber(phoneNumber), addressBook.getId());
        this.email = DatabaseValidators.emailDatabaseValidator(Validators.validateEmail(email).toString(), addressBook.getId());
        this.addressBookId = addressBook.getId();
    }
//    Constructor for fetching a contact from the database
    public Contact(int id, int addressBookId, String name, String phoneNumber, String email){
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

    public void setName(String name){
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws Exception {
        this.phoneNumber = Validators.validatePhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        this.email = Validators.validateEmail(email).toString();
    }

    public int getAddressBookId() {
        return addressBookId;
    }

    public Map<String, String> getContactDetails(){
        Map<String, String> contactDetails = new HashMap<>();
        contactDetails.put("id", Integer.toString(this.id));
        contactDetails.put("name", this.name);
        contactDetails.put("phoneNumber", this.phoneNumber);
        contactDetails.put("email", this.email);
        return contactDetails;
    }

}
