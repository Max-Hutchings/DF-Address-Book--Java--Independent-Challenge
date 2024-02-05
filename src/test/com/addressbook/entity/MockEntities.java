package com.addressbook.entity;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockEntities {

    public static Contact getMockContactInputDetails(String name, String phoneNumber, String email, int id){
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn(name);
        when(mockContact.getPhoneNumber()).thenReturn(phoneNumber);
        when(mockContact.getEmail()).thenReturn(email);
        when(mockContact.getId()).thenReturn(id);

        Map<String, String> contactDetails = new HashMap<>();
        contactDetails.put("id", Integer.toString(id));
        contactDetails.put("name", name);
        contactDetails.put("phoneNumber", phoneNumber);
        contactDetails.put("email", email);

        when(mockContact.getContactDetails()).thenReturn(contactDetails);

        return mockContact;
    }

    public static Contact getMockContactNoId(String name, String phoneNumber, String email, int addressBookId){
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn(name);
        when(mockContact.getPhoneNumber()).thenReturn(phoneNumber);
        when(mockContact.getEmail()).thenReturn(email);
        when(mockContact.getAddressBookId()).thenReturn(addressBookId);

        return mockContact;
    }



    public static Contact getMockContactPreBuilt(){
        Contact mockContact = mock(Contact.class);
        when(mockContact.getName()).thenReturn("Joe Doe");
        when(mockContact.getPhoneNumber()).thenReturn("07710306521");
        when(mockContact.getEmail()).thenReturn("joelovespizze@gmail.com");
        when(mockContact.getId()).thenReturn(1);

        Map<String, String> contactDetails = new HashMap<>();
        contactDetails.put("id", Integer.toString(1));
        contactDetails.put("name", "Joe Doe");
        contactDetails.put("phoneNumber", "07710306521");
        contactDetails.put("email", "joelovespizze@gmail.com");

        when(mockContact.getContactDetails()).thenReturn(contactDetails);

        return mockContact;
    }

    public static AddressBook getMockAddressBookNoId(String name, User user){
        AddressBook mockAddressBook = mock(AddressBook.class);
        when(mockAddressBook.getAddressBookName()).thenReturn(name);
        when(mockAddressBook.getUserId()).thenReturn(user.getId());

        return mockAddressBook;

    }

    public static AddressBook getMockAddressBookInputDetails(int id, String name, int userId){
        AddressBook mockAddressBook = mock(AddressBook.class);

        when(mockAddressBook.getAddressBookName()).thenReturn(name);
        when(mockAddressBook.getId()).thenReturn(id);
        when(mockAddressBook.getUserId()).thenReturn(userId);

        return mockAddressBook;

    }

    public static User getMockUser(String fName, String lName, String phoneNumber, String email){
        User mockUser = mock(User.class);
        when(mockUser.getFName()).thenReturn(fName);
        when(mockUser.getLName()).thenReturn(lName);
        when(mockUser.getPhoneNumber()).thenReturn(phoneNumber);
        when(mockUser.getEmail()).thenReturn(email);
        when(mockUser.getFullName()).thenReturn(fName + " " + lName);

        return mockUser;
    }

    public static User getMockUserWithId(String fName, String lName, String phoneNumber, String email, int id){
        User mockUser = mock(User.class);
        when(mockUser.getFName()).thenReturn(fName);
        when(mockUser.getLName()).thenReturn(lName);
        when(mockUser.getPhoneNumber()).thenReturn(phoneNumber);
        when(mockUser.getEmail()).thenReturn(email);
        when(mockUser.getFullName()).thenReturn(fName + " " + lName);
        when(mockUser.getId()).thenReturn(id);

        return mockUser;
    }
}
