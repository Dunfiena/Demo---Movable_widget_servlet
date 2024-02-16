package com.example.web_assign_1.Database;

import com.example.web_assign_1.Dao.userDao;
import com.example.web_assign_1.Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.web_assign_1.Database.database_connection.*;

public class user_Database implements userDao {

    private static final String SQL_SELECT = "SELECT * FROM user";
    private static final String SQL_SELECT_ONE = "SELECT * FROM user WHERE userId = ?";
    private static final String SQL_SELECT_login = "SELECT * FROM user WHERE userName = ? AND hashpass = ?";

    private static final String SQL_INSERT = "INSERT INTO user(userId, userName, firstName, lastName, email, hashpass) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE user SET userName=?, firstName=?, lastName=?, email=?, hashpass=? WHERE userId = ?";
    private static final String SQL_DELETE = "DELETE FROM user WHERE userId = ?";

    @Override
    public int insert(User user) throws SQLException {
        return 0;
    }

    @Override
    public int update(User user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(User userId) throws SQLException {
        return 0;
    }

    @Override
    public User select(String userName, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement("SELECT * FROM user WHERE userName = ? AND hashpass = ?");
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                user = new User(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                return user;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }


    @Override
    public User insert(String userName, String fname, String lname, String email, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement pStatement = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try{
            conn = getConnection();
            pStatement = conn.prepareStatement(SQL_SELECT);
            rs = pStatement.executeQuery();

            while (rs.next()){

                users.add(new User(
                        rs.getInt("userId"),
                        rs.getString("userName"),
                        rs.getString("email"),
                        rs.getString("hashpass"))
                );

            }

        }catch (Exception ex){
            System.out.println("Error:" + ex.getMessage());
        }
        return null;
    }
}
