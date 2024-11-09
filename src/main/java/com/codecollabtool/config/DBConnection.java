package main.java.com.codecollabtool.config;

package com.codecollabtool.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/CodeCollabDB";
    private static final String USER = "pragya";
    private static final String PASSWORD = "pragya";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
