package java.com.addressbook.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import main.java.com.addressbook.entity.Contact;


public class ContactTest {

    @Test
    public void returnContactDetailsTest(){
        // ARRANGE
         Contact tempContact = new Contact("Max Hutchings", 077123453l, "maxraxlax@gmail.com");

        // ACT
        String contactDetails = tempContact.getContactDetails();

        // ASSERT
        assertEquals("Max Hutchings, 077123453, maxraxlax@gmail.com", contactDetails);
    }
}

