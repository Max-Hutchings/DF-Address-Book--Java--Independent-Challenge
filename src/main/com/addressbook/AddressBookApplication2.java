package com.addressbook;

import com.addressbook.dao.CompleteUserBuilder;
import com.addressbook.dao.ContactSaver;
import com.addressbook.dao.Dao;
import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.User;

public class AddressBookApplication2 {

    public static void main(String[] args) throws Exception {


        User user = CompleteUserBuilder.getUserWithContent("Ed", "Wright");

        AddressBook myAddressBook = user.getAddressBookArrayList().get(0);
        myAddressBook.printAddressBook();
        user.getAddressBookArrayList().get(1).printAddressBook();

        Contact toDeleteContact = new Contact("Ethan Hunt", "07710308733", "mitf@gmail.com", myAddressBook);
        Contact toDeleteContactSaved = ContactSaver.saveContact(toDeleteContact);
        myAddressBook.addContact(toDeleteContactSaved);

        System.out.println("\n--------------Searching for Ethan Hunt----------------\n");

//        Remove a contact
        Contact contact = myAddressBook.findContact("Ethan Hunt");
        System.out.println(contact.getName());

        System.out.println("\n--------------Deleting Ethan Hunt----------------\n");

        myAddressBook.removeContact(toDeleteContactSaved);

        System.out.println("\n--------------Editing Contacts details----------------\n");
        Contact toEditContact = myAddressBook.findContact("Alice Smith");
        toEditContact.setName("Alice Jones");
        toEditContact.setPhoneNumber("07710308733");
        toEditContact.setEmail("aliceedownthehole@gmail.com");
        System.out.println(toEditContact.getContactDetails());
        Contact savedAndUpdatedContact = ContactSaver.updateContact(toEditContact);
        System.out.println(savedAndUpdatedContact.getContactDetails());





        System.out.println("\n--------------Search by phone or email----------------\n");

        Contact byPhone = myAddressBook.findContactByPhone("07710308733");
        Contact byEmail = myAddressBook.findContactByEmail("aliceedownthehole@gmail.com");



        Dao.resetSQL();
    }
}
