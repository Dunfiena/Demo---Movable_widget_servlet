package com.example.web_assign_1;

import com.example.web_assign_1.Database.task_Database;
import com.example.web_assign_1.Database.user_Database;
import com.example.web_assign_1.Model.Task;
import com.example.web_assign_1.Model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.sql.*;

public class registerServlet extends HttpServlet {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/tskapp";
        String uname = "root";
        String pass = "";

        String query = "select * from user";

        Class.forName("com.mysql.cj.jdbc.Drive");

        try {
            Connection con = DriverManager.getConnection(url, uname, pass);
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("Firstname");

            System.out.println(name);
            st.close();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public User sign_in(String userName,String password) throws SQLException {
        user_Database udb = new user_Database();
        User user = udb.select(userName, password);

        if (user != null){
            return user;
        }else
            return null;
    }

    public User register(String userName, String fname, String lname, String email, String password) throws SQLException {
        user_Database udb = new user_Database();
        User user = udb.insert(userName, fname, lname, email, password);

        if (user != null){
            return user;
        }else
            return null;
    }

    public Task add_task(){
        Task task = new Task();
        task_Database tbd = new task_Database();
        return task;
    }
}
