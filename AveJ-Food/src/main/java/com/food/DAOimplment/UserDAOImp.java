package com.food.DAOimplment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.UserDAO;
import com.food.model.User;

public class UserDAOImp implements UserDAO {
    Connection connection;

    public UserDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_food", "root", "Imjeeva@888");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /*------------------------------------ADD USER----------------------------------------------*/
    @Override
    public int addUser(User user) {
        String query = "INSERT INTO `user`(`UserName`, `Password`, `Email`, `Address`, `Role`) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getRole());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            closeResources(ps, null, null);
        }
    }

    /*------------------------------------GET USER----------------------------------------------*/
    @Override
    public User getUser(String email) {
        String query = "SELECT * FROM user WHERE email=?";
        User user = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            res = ps.executeQuery();
            if (res.next()) {
                user = print(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, res, null);
        }
        return user;
    }

    /*------------------------------------UPDATE USER----------------------------------------------*/
    @Override
    public void updateUser(User user) {
        String query = "UPDATE `user` SET UserName=?, Password=?, Email=?, Address=?, Role=? WHERE UserID=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setString(5, user.getRole());
            ps.setInt(6, user.getUserID());
            int x = ps.executeUpdate();
            System.out.println(x + " row(s) updated.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, null, null);
        }
    }

    /*------------------------------------DELETE USER----------------------------------------------*/
    @Override
    public void deleteUser(int userID) {
        String query = "DELETE FROM user WHERE userID=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            int n = ps.executeUpdate();
            System.out.println(n + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, null, null);
        }
    }

    /*------------------------------------GET ALL USERS----------------------------------------------*/
    @Override
    public List<User> getAllUser() {
        String query = "SELECT * FROM USER";
        ArrayList<User> ll = new ArrayList<>();
        Statement stm = null;
        ResultSet res = null;
        try {
            stm = connection.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                ll.add(print(res));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, res, stm);
        }
        return ll;
    }

    /*------------------------------------CALL THE METHOD-----------------------------------------------*/
    private User print(ResultSet res) throws Exception {
        User user = new User();
        user.setUserID(res.getInt("UserID"));
        user.setUserName(res.getString("UserName"));
        user.setPassword(res.getString("Password"));
        user.setEmail(res.getString("Email"));
        user.setAddress(res.getString("Address"));
        user.setRole(res.getString("Role"));
        return user;
    }

    // Method to close all database resources
    private void closeResources(PreparedStatement ps, ResultSet rs, Statement stm) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stm != null) {
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
