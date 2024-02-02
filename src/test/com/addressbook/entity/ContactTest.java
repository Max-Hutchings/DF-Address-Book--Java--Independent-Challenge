package com.addressbook.entity;



//import java.com.addressbook.terminal.Saver;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ContactTest {



    @Test
    public void returnContactDetailsTest(){
        try {
            // ARRANGE
            Contact tempContact = new Contact("Max Hutchings", "077123453", "maxraxlax@gmail.com");
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
        }
    }
}

