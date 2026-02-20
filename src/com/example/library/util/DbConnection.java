package com.example.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    // a static method to get the connection


    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/advanced_db";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
}
