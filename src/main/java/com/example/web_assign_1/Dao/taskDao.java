package com.example.web_assign_1.Dao;
import com.example.web_assign_1.Model.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface taskDao {

    public void insert (int userId, String taskName, String duedate, String description) throws SQLException;
    public void update (int taskId, String taskName, String description, String dueDate) throws SQLException, ClassNotFoundException;
    public void delete (int taskId) throws SQLException, ClassNotFoundException;
    public Task select (int taskId) throws SQLException;
    public ArrayList<Task> selectAll() throws SQLException;
    ArrayList<Task> selectAll(int userId) throws SQLException;

}
