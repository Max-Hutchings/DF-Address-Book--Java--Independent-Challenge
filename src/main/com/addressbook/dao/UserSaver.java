package com.addressbook.dao;


import com.addressbook.entity.User;

import java.sql.*;

public class UserSaver extends Dao {


    public static User saveUser(User user) throws SQLException{
        String sql = "INSERT INTO User(firstName, lastName, phoneNumber, email) VALUES(?, ?, ?, ?)";


//        the () brackets ensure the connection is closed at end of try block
        try (Connection conn = connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFName());
            pstmt.setString(2, user.getLName());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getEmail());
            pstmt.executeUpdate();

            System.out.println("User saved successfully");

            return UserSaver.getUser(user.getFName(), user.getLName());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static User getUser(String fName, String lName) {
        String sql = "SELECT * from USER where firstName = ? AND lastName = ?";
        User user = null;

        User fetchedUser = null;
        try (Connection connection = connect()) {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, fName);
            pstmt.setString(2, lName);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");

                fetchedUser = new User(id, firstName, lastName, phoneNumber, email);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return fetchedUser;


    }

    public static Boolean deleteUser(User user){
        String sql = "DELETE FROM User WHERE id = ?";

        try(Connection conn = connect()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            pstmt.executeUpdate();
            System.out.println("User deleted successfully");
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static User updateUser(User user){
        String sql = "UPDATE User SET firstName = ?, lastName = ?, phoneNumber = ?, email = ? WHERE id = ?";

        try(Connection conn = connect()){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getFName());
            pstmt.setString(2, user.getLName());
            pstmt.setString(3, user.getPhoneNumber());
            pstmt.setString(4, user.getEmail());
            pstmt.setInt(5, user.getId());
            pstmt.executeUpdate();
            System.out.println("User updated successfully");
            return getUser(user.getFName(), user.getLName());
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
