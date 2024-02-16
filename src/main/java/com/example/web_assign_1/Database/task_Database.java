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
    private static final String SQL_INSERT = "INSERT INTO task(taskId, userId, taskName, description, dateAdded, dueDate, PositionX, PositionY) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE task SET userId=?, taskName=?, description=?, dateAdded=?, dueDate?, PositionX=?, PositionY=? WHERE taskId = ?";
    private static final String SQL_DELETE = "DELETE FROM task WHERE taskId = ?";
    @Override
    public int insert(Task task) throws SQLException {
        return 0;
    }

    @Override
    public int update(Task task) throws SQLException {
        return 0;
    }

    @Override
    public int delete(Task taskId) throws SQLException {
        return 0;
    }

    @Override
    public Task select(int taskId) throws SQLException {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ONE);
            Task task = null;
            while (rs.next()) {
                task = (new Task(
                        rs.getInt(0),
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4),
                        rs.getString(5))
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
            stmt.setString(1, String.valueOf(userId));
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Task t = new Task(
                        rs.getInt(0),
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4),
                        rs.getString(5));
                tasks.add(t);
            }
            return tasks;
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return tasks;
    }

    @Override
    public List<Task> insert() throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        List<Task> tasks = new ArrayList<>();

        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT);
            rs = pStatement.executeQuery();

            while (rs.next()){

                tasks.add(new Task(
                        rs.getInt("taskId"),
                        rs.getInt("userId"),
                        rs.getString("taskName"),
                        rs.getString("description"),
                        rs.getTimestamp("dateAdded"),
                        rs.getString("dueDate"))
                );
                System.out.println(tasks.get(0));
            }

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
        return null;
    }
}
