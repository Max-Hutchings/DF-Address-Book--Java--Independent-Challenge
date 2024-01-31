package com.addressbook.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AddressBookTest {

    @Test
    public void testAddContactToAddressBook(){
//        Arrange
        Contact mockContact = MockEntities.getMockContactPreBuilt();

//        Act
        AddressBook addressBook = new AddressBook("Favourite Address Book");
        addressBook.addContact(mockContact);
        int NumberOfAddressBookContacts = addressBook.getContacts().size();

//        Assert
        assertEquals(NumberOfAddressBookContacts, 1);

    }
}
