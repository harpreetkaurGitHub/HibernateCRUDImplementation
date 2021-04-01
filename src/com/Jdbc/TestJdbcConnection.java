package com.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbcConnection {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/studentTracker?useSSL=false";
        String username = "sammy";
        String password = "password";
        try {

            System.out.println("Connecting to database :: " + jdbcUrl);

            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);

            System.out.println("Connection successful");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}