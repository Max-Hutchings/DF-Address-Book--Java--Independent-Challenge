package com.addressbook.dao;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.MockEntities;
import com.addressbook.entity.User;
import org.junit.jupiter.api.Test;

import static com.addressbook.dao.Dao.connect;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class saverAddressBookTest extends saverTests {

    @Test
    public void testSaveAndGetAddressBook(){
        User mockUser = MockEntities.getMockUserWithId("Max", "Hutchings", "07710308733", "max@gmail.com", 1);
        try {
            AddressBook mockAddressBook = MockEntities.getMockAddressBookNoId("My new address book", mockUser.getId());
            AddressBook addressBook = AddressBookSaver.saveAddressBook(mockAddressBook);

            assert addressBook != null;
            assertEquals("My new address book", addressBook.getAddressBookName());

        }catch(Exception e){
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }

    @Test
    public void testDeleteAddressBook() {
        User mockUser = MockEntities.getMockUserWithId("Max", "Hutchings", "07710308733", "max@gmail.com", 1);
        AddressBook mockAddressBook = MockEntities.getMockAddressBookInputDetails(1, "My new address book", mockUser.getId());
        try {
            AddressBook addressBook = AddressBookSaver.saveAddressBook(mockAddressBook);
            Boolean result = AddressBookSaver.deleteAddressBook(addressBook);
            assert result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }
}
