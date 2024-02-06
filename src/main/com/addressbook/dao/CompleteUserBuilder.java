package com.addressbook.dao;

import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.addressbook.dao.UserSaver.getUser;

public class CompleteUserBuilder extends Dao {

    public static User getUserWithContent(String fName, String lName) {
        User user = getUser(fName, lName);
        if (user != null) {
            List<AddressBook> addressBooks = getAllAddressBooks(user.getId());
            for (AddressBook addressBook : addressBooks) {

                user.addAddressBook(addressBook);
                List<Contact> contacts = getAllContacts(addressBook.getId());
                for (Contact contact : contacts){
                    addressBook.addContact(contact);
                }
            }

        }
        return user;
    }

    public static List<AddressBook> getAllAddressBooks(int userId) {
        List<AddressBook> addressBooks = new ArrayList<>();
        String sql = "SELECT * FROM AddressBook WHERE userId = ?";

        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                AddressBook addressBook = new AddressBook(rs.getInt("id"), rs.getString("addressBookName"), userId);
                addressBooks.add(addressBook);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBooks;
    }

    public static List<Contact> getAllContacts(int addressBookId) {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM Contact WHERE addressBookId = ?";

        try (Connection conn = connect()) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, addressBookId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                int addressBookId1 = rs.getInt("addressBookId");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                Contact contact = new Contact(id, addressBookId, name, phoneNumber, email);
                contacts.add(contact);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }
}