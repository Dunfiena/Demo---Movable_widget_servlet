package com.example.web_assign_1.Dao;
import com.example.web_assign_1.Model.Task;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface taskDao {

    public int insert (Task task) throws SQLException;
    public int update (Task task) throws SQLException;
    public int delete (Task taskId) throws SQLException;
    public Task select (int taskId) throws SQLException;

    public ArrayList<Task> selectAll() throws SQLException;

    ArrayList<Task> selectAll(int userId) throws SQLException;

    public List<Task> insert () throws SQLException;


}
