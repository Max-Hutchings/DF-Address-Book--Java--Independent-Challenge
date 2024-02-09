package com.addressbook.gui;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;

import java.util.ArrayList;

public class Printer {

    public static String printAddressBook(String addressBookName, ArrayList<Contact> contacts){
        StringBuilder message = new StringBuilder();
        message.append(addressBookName);
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

public static String printAddressBooksList(String userName, String userFName, ArrayList<AddressBook> addressBooks){
    StringBuilder addressBookList = new StringBuilder();
    addressBookList.append(userName).append("'s address books");
    addressBookList.append("\n------------------------");
    if (addressBooks.isEmpty()){
        addressBookList.append("\nNo address books yet for ").append(userFName);
        System.out.println(addressBookList);
        return addressBookList.toString();
    }else {
        for (AddressBook addressBook : addressBooks) {
            addressBookList.append("\n");
            addressBookList.append(addressBook.getAddressBookName());
        }


        System.out.println(addressBookList);
        return addressBookList.toString();
    }
}
}
