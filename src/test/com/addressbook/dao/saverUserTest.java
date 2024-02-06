package com.addressbook.dao;

import com.addressbook.entity.MockEntities;
import com.addressbook.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class saverUserTest extends SaverTests {



    @Test
    public void testSaveAndGetUser(){
//        Save
        User startUser = MockEntities.getMockUser("Max", "Hutchings", "07710308733", "max@gmail.com");
        try{
            User savedUser = UserSaver.saveUser(startUser);
            assert savedUser != null;
            assertEquals(startUser.getFullName(), savedUser.getFullName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }

    @Test
    public void testDeleteUser(){
//        Save
        try {
            User startUser = MockEntities.getMockUser("Max", "Hutchings", "07710308733", "max@gmail.com");
            User savedUser = UserSaver.saveUser(startUser);

            Boolean result = UserSaver.deleteUser(savedUser);
            assert result;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally {
            resetSQL();
        }
    }

    @Test
    public void updateUser() {
        try {
            User startUser = MockEntities.getMockUser("Max", "Hutchings", "07710308733", "max@gmail.com");
            User savedUser = UserSaver.saveUser(startUser);

            savedUser.setFName("Maximilian");
            User updatedUser = UserSaver.updateUser(savedUser);
            assertEquals("Maximilian", updatedUser.getFName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            resetSQL();
        }
    }


}
