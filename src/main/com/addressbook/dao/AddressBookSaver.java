package com.addressbook.dao;

import com.addressbook.entity.AddressBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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


        AddressBook fetchedAddressBook = null;
        try(Connection connection = connect()){
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, addressBookName);
            pstmt.setInt(2, userId);
            ResultSet rs = pstmt.executeQuery();

            if(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("addressBookName");
                int user = rs.getInt("userId");

                fetchedAddressBook = new AddressBook(id, name, user);
            }
        } catch (SQLException e){
            System.out.println("Casuing error");
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
