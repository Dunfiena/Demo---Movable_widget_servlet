package com.example.web_assign_1;

import com.example.web_assign_1.Database.task_Database;
import com.example.web_assign_1.Database.user_Database;
import com.example.web_assign_1.Model.Task;
import com.example.web_assign_1.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class taskServlet extends HttpServlet {

    public void init() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String url = request.getServletPath();
        log(url);
        switch (url){
            case "/addTask":
                try {
                    addTask(request, response);
                } catch (ServletException | SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/deleteTask":
                try {
                    deleteTask(request,response);
                } catch (SQLException | ServletException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/updateTask":
                try {
                    updateTask(request,response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {

        String url = request.getServletPath();
        log(url);
        switch (url){
            case "/addTask":
                try {
                    addTask(request, response);
                } catch (ServletException | SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/deleteTask":
                try {
                    deleteTask(request,response);
                } catch (SQLException | ServletException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "/updateTask":
                try {
                    updateTask(request,response);
                } catch (SQLException | ServletException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    protected void addTask(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String taskname = request.getParameter("taskname");
        String dueDate = request.getParameter("dueDate");
        String description = request.getParameter("description");
        int userId = Integer.parseInt(request.getParameter("userID"));

        task_Database tdb = new task_Database();
        tdb.insert(userId, taskname, dueDate, description);

        user_Database udb = new user_Database();
        User user = udb.select(userId);

        ArrayList<Task> tasks = new ArrayList<>();
        tasks = tdb.selectAll(user.getUser_id());

        request.setAttribute("tasks", tasks);
        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("login.jsp");
    }

    protected void deleteTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ClassNotFoundException {
        int taskId = Integer.parseInt(request.getParameter("taskID"));
        int userId = Integer.parseInt(request.getParameter("userID"));

        task_Database tdb = new task_Database();
        tdb.delete(taskId);

        user_Database udb = new user_Database();
        User user = udb.select(userId);

        ArrayList<Task> tasks = new ArrayList<>();
        tasks = tdb.selectAll(user.getUser_id());

        request.setAttribute("tasks", tasks);
        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("login.jsp");    }

    protected void updateTask(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int taskId = Integer.parseInt(request.getParameter("taskID"));
        String taskname = request.getParameter("E_taskName");
        String dueDate = request.getParameter("E_dueDate");
        String description = request.getParameter("E_description");
        int userId = Integer.parseInt(request.getParameter("userID"));

        task_Database tdb = new task_Database();
        try {
            tdb.update(taskId, taskname, description, dueDate);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        user_Database udb = new user_Database();
        User user = udb.select(userId);

        ArrayList<Task> tasks = new ArrayList<>();
        tasks = tdb.selectAll(user.getUser_id());

        request.setAttribute("tasks", tasks);
        request.setAttribute("user", user);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
        rd.include(request,response);
        rd.forward(request,response);
        response.sendRedirect("login.jsp");
    }}
