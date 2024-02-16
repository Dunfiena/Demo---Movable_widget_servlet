package com.example.web_assign_1;

import com.example.web_assign_1.Database.task_Database;
import com.example.web_assign_1.Database.user_Database;
import com.example.web_assign_1.Model.Task;
import com.example.web_assign_1.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
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

@WebServlet(name="index_func", value = "/index_func")
public class HelloServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        config.getServletContext();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        task_Database tdb = new task_Database();
//        ArrayList<Task> tasks = null;
//        try {
//            tasks = tdb.selectAll();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if (tasks ==null){
//            Timestamp now = new Timestamp(System.currentTimeMillis());
//            Locale locale = new Locale("fr", "FR");
//
//            Date date = new Date();
//            Task tast = new Task(0, 0, "test", "this is a test", now, (java.sql.Date) date, 10,10);
//            tasks.add(tast);
//        }
//        request.setAttribute("tasks", tasks);
//        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        task_Database tdb = new task_Database();
        ArrayList<Task> tasks = null;

        user_Database udb = new user_Database();
        User user = null;

        try {
            user = udb.select(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user == null) {

        } else {
            try {
                tasks = tdb.selectAll(user.getUser_id());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            String username2 = "Sophie";
//            request.setAttribute("username", username2);
//            request.setAttribute("tasks", tasks)

            HttpSession session = request.getSession();
            session.setAttribute("username", username2);
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/login");
            rd.include(request, response);
//            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
//        String action = request.getParameter("url");
//
//        switch (action){
//            case "/login":
//                login(request,response);
//                break;
//            case "/addtask":
//                addTask();
//                break;
//            case "register":
//                register();
//            break;
//        }
//    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        task_Database tdb = new task_Database();
        ArrayList<Task> tasks = null;

        user_Database udb = new user_Database();
        User user = null;

        try {
            user = udb.select(username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user != null) {

        } else {
//            try {
//                tasks = tdb.selectAll(user.getUser_id());
//            } catch (SQLException e) {
//                throw new RuntimeException(e);
//            }
            String username2 = "Sophie";
//            request.setAttribute("username", username2);
//            request.setAttribute("tasks", tasks)

            HttpSession session = request.getSession();
            session.setAttribute("username", username2);
            ServletContext context = getServletContext();
            RequestDispatcher rd = context.getRequestDispatcher("/index.jsp");
            rd.include(request, response);

        }
    }
}
//
//    public void addTask(){
//
//    }
//
//    public void register(){
//
//    }
//
