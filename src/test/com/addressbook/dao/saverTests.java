package com.addressbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.addressbook.dao.Dao.connect;

public class saverTests {

    protected void resetSQL(){
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
