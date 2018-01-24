package org.heastie.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
        String user = "hbstudent";
        String pass = "hbstudent";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection was successful! " + connection);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}