package com.addressbook.dao;

import com.addressbook.entity.AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressBookSaver extends Dao {

    public static AddressBook saveAddressBook(AddressBook addressBook){
        String sql = "INSERT INTO AddressBook (addressBookName, userId) VALUES(?, ?)";

        try(Connection connection = connect()){
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, addressBook.getAddressBookName());
            pstmt.setInt(2, addressBook.getUserId());
            pstmt.executeUpdate();
            System.out.println("Address book saved successfully");
            return AddressBookSaver.getAddressBook(addressBook.getAddressBookName(), addressBook.getUserId());
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static AddressBook getAddressBook(String addressBookName, int userId){
        String sql = "SELECT * FROM AddressBook WHERE addressBookName = ? AND userId = ?";
        AddressBook addressBook = null;

        AddressBook fetchedAddressBook = null;
        try(Connection connection = connect()){
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, addressBookName);
            pstmt.setInt(2, userId);

            if(pstmt.executeQuery().next()){
                int id = pstmt.getResultSet().getInt("id");
                String name = pstmt.getResultSet().getString("addressBookName");
                int user = pstmt.getResultSet().getInt("userId");

                fetchedAddressBook = new AddressBook(id, name, user);
            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return fetchedAddressBook;
    }

    public static boolean deleteAddressBook(AddressBook addressBook){
        String sql = "DELETE FROM AddressBook WHERE id = ?";
        try(Connection connection = connect()){
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, addressBook.getId());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
