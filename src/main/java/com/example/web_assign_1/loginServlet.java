package com.example.web_assign_1;

import com.example.web_assign_1.Database.task_Database;
import com.example.web_assign_1.Database.user_Database;
import com.example.web_assign_1.Model.Task;
import com.example.web_assign_1.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class loginServlet extends HttpServlet {

    public void init() {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        try {
            authenticate(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
        try {
            authenticate(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String username = request.getParameter("userName");
        String password = request.getParameter("hashpass");

        task_Database tdb = new task_Database();
        ArrayList<Task> tasks = null;

        user_Database udb = new user_Database();
        User user = udb.select(username, password);

//        try {
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if (user == null) {
//
//        } else {
//            try {
//                tasks = tdb.selectAll(user.getUser_id());
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
//            request.setAttribute("tasks", tasks)

            request.setAttribute("user", user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.include(request,response);
            rd.forward(request,response);
            response.sendRedirect("login.jsp");
//            RequestDispatcher rd = context.getRequestDispatcher("/login");
//            rd.include(request, response);
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
