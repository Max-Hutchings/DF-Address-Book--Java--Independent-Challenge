package com.addressbook.dao;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.MockEntities;
import com.addressbook.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompleteUserBuilderTest {

    @Test
    public void getAllAddressBooksTest() {
        int userId = 1;
        AddressBook mockAddressBook1 = MockEntities.getMockAddressBookNoId("My new address book", userId);
        AddressBook mockAddressBook2 = MockEntities.getMockAddressBookNoId("My second address book", userId);
        AddressBookSaver.saveAddressBook(mockAddressBook1);
        AddressBookSaver.saveAddressBook(mockAddressBook2);

        List<AddressBook> addressBooks = CompleteUserBuilder.getAllAddressBooks(userId);

        assertEquals(2, addressBooks.size());
    }

    @Test
    public void getAllContactsTest() throws Exception {
        int addressBookId = 1;
        Contact mockUser1 = MockEntities.getMockContactNoId("Max", "Hutchings", "07710308733", addressBookId);
        Contact mockUser2 = MockEntities.getMockContactNoId("Rax", "Dax", "07710308733", addressBookId);
        ContactSaver.saveContact(mockUser1);
        ContactSaver.saveContact(mockUser2);

        List<Contact> contacts = CompleteUserBuilder.getAllContacts(addressBookId);

        assertEquals(2, contacts.size());

    }

}