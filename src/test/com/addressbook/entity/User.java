package com.addressbook.entity;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class User {

    @Test
    public void testAddAddressBook(){
        AddressBook mockAddressBook = MockEntities.getMockAddressBookInputDetails(1, "My Address Book", 1);

        User user = new User();
        user.addAddressBook(mockAddressBook);

        int itemsInAddressBook = user.getAddressBooks().size();

        assertEquals(1, itemsInAddressBook);
    }
}
