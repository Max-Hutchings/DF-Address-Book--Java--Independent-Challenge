package com.addressbook.dao;

import com.addressbook.entity.Contact;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.*;

public class ContactSaver extends Dao{

    public static Contact saveContact(Contact contact) throws Exception {
        String sql = "INSERT INTO Contact (name, phoneNumber, email, addressBookId) VALUES(?,?,?,?)";
        try (Connection conn = connect()) {

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getName());
            pstmt.setString(2, contact.getPhoneNumber());
            pstmt.setString(3, contact.getEmail());
            pstmt.setInt(4, contact.getAddressBookId());
            pstmt.executeUpdate();
            return ContactSaver.getContact(contact);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Contact getContact(Contact contact){
        String sql = "SELECT * FROM Contact WHERE name = ? AND addressBookId = ?";
        Contact fetchedContact = null;

        try(Connection conn = connect()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contact.getName());
            pstmt.setInt(2, contact.getAddressBookId());

            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                int addressBookId = rs.getInt("addressBookId");
                fetchedContact = new Contact(id, addressBookId,  name, phoneNumber, email);
                return fetchedContact;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Boolean deleteContact(Contact contact){
        String sql = "DELETE FROM Contact WHERE id = ?";
        try(Connection conn = connect()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, contact.getId());
            pstmt.executeUpdate();
            return true;
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
