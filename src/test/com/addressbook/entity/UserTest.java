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
}
