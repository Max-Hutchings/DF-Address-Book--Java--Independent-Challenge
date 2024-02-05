package com.addressbook.dao;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.MockEntities;
import com.addressbook.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaverContactTest extends saverTests{

    @Test
    public void testSaveAndGetContact() {
//        User mockUser = MockEntities.getMockUserWithId("Max", "Hutchings", "07710308733", "max@gmail.com", 1);
        AddressBook mockAddressBook = MockEntities.getMockAddressBookInputDetails(1, "My new address book", 1);
        Contact mockContact = MockEntities.getMockContactNoId("Ed Wright", "07710308733", "ed@gmail.com", mockAddressBook.getId());
        try {
            Contact savedContact = ContactSaver.saveContact(mockContact);
            assertEquals("Ed Wright", savedContact.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }

    @Test
    public void testDeleteContact(){
        AddressBook mockAddressBook = MockEntities.getMockAddressBookInputDetails(1, "My new address book", 1);
        Contact mockContact = MockEntities.getMockContactNoId("Ed Wright", "07710308733", "ed@gmail.com", mockAddressBook.getId());
        try {
            Contact savedContact = ContactSaver.saveContact(mockContact);
            Boolean result = ContactSaver.deleteContact(savedContact);
            assert result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }
}
