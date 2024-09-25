package com.food.DAOimplment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import com.food.DAO.OrderDAO;
import com.food.model.Order;

public class OrderDAOImp implements OrderDAO {

    Scanner scan = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/tap_food";
    String user = "root";
    String pass = "Imjeeva@888";
    Connection connection = null;
    String insertQuery = "INSERT INTO `ordertable` (`orderdate`,`totalamount`,`status`,`paymentmethod`) VALUES (?,?,?,?)";
    String retreiveQuery = "SELECT * FROM `ordertable` WHERE `orderid` = ?";
    String updateQuery = "UPDATE `ordertable` SET `orderdate` = ? , `totalamount` = ? , `status` = ? , `paymentmethod` = ? WHERE `orderid` = ?";
    String deleteQuery = "DELETE FROM `ordertable` WHERE `orderid` = ?";
    String selectQuery = "SELECT * FROM `ordertable`";
    
    PreparedStatement statement = null;
    Statement statement2 = null;
    ResultSet res = null;
    
    public OrderDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url , user , pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void addOrder(Order order) {
        try {
            statement = connection.prepareStatement(insertQuery);
            statement.setDate(1, new Date(order.getOrderDate().getTime()));
            statement.setDouble(2, order.getTotalAmount());
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getPaymentMethod());
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    private Order extractUserFromResultSet(ResultSet res) throws SQLException {
        Order order = new Order();
        order.setOrderId(res.getInt("order_id"));
        order.setUserId(res.getInt("user_id"));
        order.setRestaurantId(res.getInt("restaurant_id"));
        order.setOrderDate(res.getDate("order_date"));
        order.setTotalAmount(res.getDouble("total_amount"));
        order.setStatus(res.getString("status"));
        order.setPaymentMethod(res.getString("payment_method"));
        return order;
    }
    
    @Override
    public Order getOrder(int orderID) {
        Order order = null;
        try {
            statement = connection.prepareStatement(retreiveQuery);
            statement.setInt(1, orderID);
            res = statement.executeQuery();
            
            if (res.next()) {
                order = extractUserFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return order;
    }
    
    @Override
    public void updateOrder(Order order) {
        try {
            statement = connection.prepareStatement(updateQuery);
            statement.setDate(1, new Date(order.getOrderDate().getTime()));
            statement.setDouble(2, order.getTotalAmount());
            statement.setString(3, order.getStatus());
            statement.setString(4, order.getPaymentMethod());
            statement.setInt(5, order.getOrderId());
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    @Override
    public void deleteOrder(int orderId) {
        try {
            statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, orderId);
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
    }
    
    @Override
    public List<Order> getAllOrder(Order order) {
        List<Order> list = new ArrayList<>();
        try {
            statement2 = connection.createStatement();
            res = statement2.executeQuery(selectQuery);
            while (res.next()) {
                Order o = extractUserFromResultSet(res);
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }
    
    @Override
    public List<Order> getAllOrdersByUser(int userId) {
        String getUser = "SELECT * FROM `ordertable` WHERE `userID` = ?";
        List<Order> list = new ArrayList<>();
        
        try {
            statement = connection.prepareStatement(getUser);
            statement.setInt(1, userId);
            res = statement.executeQuery();
            
            while (res.next()) {
                Order o = extractUserFromResultSet(res);
                list.add(o);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return list;
    }
    
    // Method to close all database resources
    private void closeResources() {
        // Close ResultSet
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Close PreparedStatement
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Close Statement
        if (statement2 != null) {
            try {
                statement2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        // Close Connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
