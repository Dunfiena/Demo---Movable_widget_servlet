package com.example.web_assign_1;

import com.example.web_assign_1.Database.task_Database;
import com.example.web_assign_1.Database.user_Database;
import com.example.web_assign_1.Model.Task;
import com.example.web_assign_1.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class registerServlet extends HttpServlet {
    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            register(request, response);
        } catch (ServletException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
        try {
            register(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void register(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        user_Database udb = new user_Database();
        udb.insert(username, email, password);

        User user = udb.select(username, password);

        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("login.jsp");
    }
}
