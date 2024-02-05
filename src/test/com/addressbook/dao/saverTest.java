package com.addressbook.dao;

import com.addressbook.entity.MockEntities;
import com.addressbook.entity.User;
import com.addressbook.terminal.Saver;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class saverTest {

    @Test
    public void testSaveAndGetUser(){
//        Save
        User startUser = MockEntities.getMockUser("Max", "Hutchings", "07710308733", "max@gmail.com");
        Dao.saveUser(startUser);

//        Get
        User fetchedUser = Dao.getUser("Max", "Hutchings");

        assertEquals(startUser, fetchedUser);



    }



}
