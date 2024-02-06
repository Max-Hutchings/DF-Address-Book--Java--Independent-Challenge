package com.addressbook.validator;

import com.addressbook.dao.CompleteUserBuilder;
import com.addressbook.entity.Contact;
import com.addressbook.entity.User;

import java.util.List;

public class DatabaseValidators {

    public static String phoneNumberDatabaseValidator(String phoneNumber, int addressBookId) throws Exception{
        List<Contact> contacts = CompleteUserBuilder.getAllContacts(addressBookId);
        for (Contact contact: contacts){
            if (contact.getPhoneNumber().equals(phoneNumber)){
                throw new Exception("Phone number already exists in the Address Book.");
            }
        }
        return phoneNumber;
    }

    public static String emailDatabaseValidator(String email, int addressBookId) throws Exception{
        List<Contact> contacts = CompleteUserBuilder.getAllContacts(addressBookId);
        for (Contact contact: contacts){
            if (contact.getEmail().equals(email)){
                throw new Exception("Email already exists in the Address Book.");
            }
        }
        return email;
    }
}
