package com.example.web_assign_1.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database_connection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/tskapp";
        String uname = "root";
        String pass = "";
        return DriverManager.getConnection(url, uname, pass);
    }
}