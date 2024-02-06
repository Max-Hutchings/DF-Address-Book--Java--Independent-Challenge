package com.addressbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {

    public static Connection connect(){
        String databaseUrl = "jdbc:sqlite:src/main/resources/database";
//        if (test) databaseUrl = "jdbc:h2:mem:test;MODE=SQLite;DB_CLOSE_DELAY=-1";

        Connection conn  = null;
        try{
            conn = DriverManager.getConnection(databaseUrl);
        } catch (SQLException e){
            System.out.println("Failed to connect to database");
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void resetSQL(){
        String[] sqlStatements = {
                "DELETE FROM User",
                "DELETE FROM AddressBook",
                "DELETE FROM Contact"
        };

        try (Connection conn = connect()) {
            for (String sql : sqlStatements) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
