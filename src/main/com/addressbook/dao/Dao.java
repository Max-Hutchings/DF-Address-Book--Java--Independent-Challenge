package com.addressbook.dao;


import com.addressbook.entity.AddressBook;
import com.addressbook.entity.Contact;
import com.addressbook.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {



    private static Connection connect(){
        String databaseUrl = "jdbc:sqlite:src/main/resources/database";
        Connection conn  = null;
        try{
            conn = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e){
            System.out.println("Failed to connect to database");
            System.out.println(e.getMessage());
        }
        return conn;
    }


    public static void saveContact(Contact contact){

    }

    public static void saveAddressBook(AddressBook addressBook){

    }


    public static void saveUser(User user){
        String sql = "INSERT INTO User(fName, lName, phoneNumber, email) VALUES(?, ?, ?, ?)";

//        the () brackets ensure the connection is closed at end of try block
        try (Connection conn = connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFName());
            pstmt.setString(2, user.getLName());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

//    public static User getUser(String userFullName){
//
//        return User;
//    }
//
//    public static AddressBook getAddressBook(){
//
//        return AddressBook;
//    }



}
