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
        User mockUser = MockEntities.getMockUserWithId("Max", "Hutchings", "07710308733", "max@gmail.com", 1);

//        Act
        AddressBook addressBook = new AddressBook("Favourite Address Book", mockUser);
        addressBook.addContact(mockContact);
        int NumberOfAddressBookContacts = addressBook.getContacts().size();

//        Assert
        assertEquals(NumberOfAddressBookContacts, 1);

    }

    @Test
    public void testPrintAddressBook(){
//        Arrange
        User mockUser = MockEntities.getMockUserWithId("Max", "Hutchings", "07710308733", "max@gmail.com", 1);
        Contact mockContact1 = MockEntities.getMockContactInputDetails("John Williams", "07710308744", "thephantommenace@gmail.com", 1);
        Contact mockContact2 = MockEntities.getMockContactInputDetails("Katy Perry", "0771345744", "babythefirework@gmail.com", 2);
        AddressBook addressBook = new AddressBook("My favourite Address Book", mockUser);
        addressBook.addContact(mockContact1);
        addressBook.addContact(mockContact2);

        String expectedValue = """
                My favourite Address Book
                -----------------------------------------------------------------
                Contacts
                -----------------------------------------------------------------
                John Williams | 07710308744 | thephantommenace@gmail.com
                Katy Perry | 0771345744 | babythefirework@gmail.com
                """;

//        Act
        String result = addressBook.printAddressBook();

//        Assert
        assertEquals(expectedValue, result);
    }
}
