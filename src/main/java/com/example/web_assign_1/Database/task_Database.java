package com.example.web_assign_1.Database;

import com.example.web_assign_1.Dao.taskDao;
import com.example.web_assign_1.Model.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.web_assign_1.Database.database_connection.getConnection;

public class task_Database implements taskDao {

    private static final String SQL_SELECT = "SELECT * FROM task";
    private static final String SQL_SELECT_ONE = "SELECT * FROM task WHERE taskId = ?";
    private static final String SQL_INSERT = "INSERT INTO task(userId, taskName, description, dateAdded, dueDate) VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE task SET taskName=?, description=?, dueDate=? WHERE taskId = ?";
    private static final String SQL_DELETE = "DELETE FROM task WHERE taskId = ?";

    @Override
    public void update(int taskId, String taskName, String description, String dueDate) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("UPDATE task SET taskName=?, description=?, dueDate=? WHERE taskId=?");
        stmt.setString(1, taskName);
        stmt.setString(2, description);
        stmt.setString(3, dueDate);
        stmt.setInt(4, taskId);

        stmt.executeUpdate();
    }

    @Override
    public void delete(int taskId) throws SQLException, ClassNotFoundException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM `task` WHERE `taskId`=?");
        stmt.setInt(1, taskId);
        stmt.execute();
    }

    @Override
    public Task select(int taskId) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ONE);
            Task task = null;
            while (rs.next()) {
                task = (new Task(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getTimestamp(5),
                        rs.getString(6))
                );
            }
            return task;
        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Task> selectAll() throws SQLException {
        return null;
    }

    @Override
    public ArrayList<Task> selectAll(int userId) throws SQLException {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from task where userId=?");
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task t = new Task(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getTimestamp(5),
                        rs.getString(6));
                tasks.add(t);
            }
            return tasks;
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return tasks;
    }

    @Override
    public void insert(int userId, String taskName, String duedate, String description) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        List<Task> tasks = new ArrayList<>();

        try{
            conn = getConnection();
            pStatement = conn.prepareStatement("INSERT INTO task(userId, taskName, description, dueDate) VALUES (?,?,?,?)");
            pStatement.setInt(1, userId);
            pStatement.setString(2,taskName);
            pStatement.setString(3,description);
            pStatement.setString(4,duedate);

            pStatement.executeUpdate();
            } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
