package com.addressbook.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testAddAddressBook(){
        AddressBook mockAddressBook = MockEntities.getMockAddressBookInputDetails(1, "My Address Book", 1);

        User user = new User("Ed", "Wright", "07710307623", "ed@digitalfutures.com");
        user.addAddressBook(mockAddressBook);

        int itemsInAddressBook = user.getAddressBookArrayList().size();

        assertEquals(1, itemsInAddressBook);
    }

    @Test
    public void testPrintAddressBooks(){
//        Arrange
        AddressBook mockAddressBook1 = MockEntities.getMockAddressBookInputDetails(1, "My Address Book", 1);
        AddressBook mockAddressBook2 = MockEntities.getMockAddressBookInputDetails(2, "My second", 1);

        User user = new User("Ed", "Wright", "07710307623", "ed@digitalfutures.com");

        user.addAddressBook(mockAddressBook1);
        user.addAddressBook(mockAddressBook2);

//        Expected return
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ed Wright").append("'s address books");
        stringBuilder.append("\n------------------------");
        stringBuilder.append("\n");
        stringBuilder.append("My Address Book");
        stringBuilder.append("\n");
        stringBuilder.append("My second");

        String expectedValue = stringBuilder.toString();

//        Act
        String printStatement = user.printAddressBooks();

//        Assert
        assertEquals(expectedValue, printStatement);
    }
}
