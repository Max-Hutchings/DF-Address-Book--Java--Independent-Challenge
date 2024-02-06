package com.addressbook.entity;



//import java.com.addressbook.terminal.Saver;

import com.addressbook.dao.AddressBookSaver;
import com.addressbook.dao.ContactSaver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.addressbook.dao.SaverTests;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {



    @Test
    public void returnContactDetailsTest(){
        try {
            // ARRANGE
            AddressBook mockAddressBookInputDetails = MockEntities.getMockAddressBookInputDetails(1, "My new address book", 1);
            Contact tempContact = new Contact(1, 1, "Max Hutchings", "077123453", "maxraxlax@gmail.com");
            Map<String, String> expectedValue = new HashMap<>();
            expectedValue.put("id", "1");
            expectedValue.put("name", "Max Hutchings");
            expectedValue.put("phoneNumber", "077123453");
            expectedValue.put("email", "maxraxlax@gmail.com");

            // ACT
            Map<String, String> contactDetails = tempContact.getContactDetails();

            // ASSERT

            assertEquals(expectedValue, contactDetails);
        } catch(Exception e){
            fail("No exception should arise");
            System.out.println(e.getMessage());
            SaverTests.resetSQL();
        }
    }

    @Test
    public void addingTwoOfSamePhoneTest() throws Exception {
        SaverTests.resetSQL();
            // ARRANGE
        AddressBook mockAddressBookInputDetails = MockEntities.getMockAddressBookNoId("My new address book", 1);
        AddressBook savedMockAddressBook = AddressBookSaver.saveAddressBook(mockAddressBookInputDetails);

        Contact tempContact = new Contact("Max Hutchings", "07712345333", "max@gmail.com", savedMockAddressBook);
        ContactSaver.saveContact(tempContact);
        assertThrows(Exception.class, () -> new Contact("Rax Hutchings", "07712345333", "ta@gmail.com", savedMockAddressBook));

        SaverTests.resetSQL();
    }

    @Test
    public void addingTwoOfSameEmailTest() throws Exception {
        SaverTests.resetSQL();
        // ARRANGE
        AddressBook mockAddressBookInputDetails = MockEntities.getMockAddressBookNoId("My new address book", 1);
        AddressBook savedMockAddressBook = AddressBookSaver.saveAddressBook(mockAddressBookInputDetails);

        Contact tempContact = new Contact("Max Hutchings", "07712345333", "max@gmail.com", savedMockAddressBook);
        ContactSaver.saveContact(tempContact);
        assertThrows(Exception.class, () -> new Contact("Rax Hutchings", "07712345346", "max@gmail.com", savedMockAddressBook));

        SaverTests.resetSQL();
    }
}

