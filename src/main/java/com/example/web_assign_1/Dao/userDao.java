package com.example.web_assign_1.Dao;
import com.example.web_assign_1.Model.User;

import java.sql.SQLException;
import java.util.List;

public interface userDao {

    public int insert (User user) throws SQLException;
    public int update (User user) throws SQLException;
    public int delete (User userId) throws SQLException;
    public User select (String userName, String Password) throws SQLException;
    public User insert (String userName, String fname, String lname, String email, String password) throws SQLException;


}
