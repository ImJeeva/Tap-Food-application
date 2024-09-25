package com.food.DAOimplment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.CartDAO;
import com.food.model.CartItem;

public class CartDAOImp implements CartDAO {

    private String url = "jdbc:mysql://localhost:3306/tap_food";
    private String userName = "root";
    private String password = "Imjeeva@888";
    private Connection connection;
    private PreparedStatement pStatement;
    private ResultSet resultSet;

    public CartDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addCart(CartItem cartItem) {
        String query = "INSERT INTO cart_item (cid, itemId, restaurantId, itemName, quantity, price) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, cartItem.getCid());
            pStatement.setInt(2, cartItem.getItemId());
            pStatement.setInt(3, cartItem.getRestaurantId());
            pStatement.setString(4, cartItem.getItemName());
            pStatement.setInt(5, cartItem.getQuantity());
            pStatement.setDouble(6, cartItem.getPrice());
            
            int x = pStatement.executeUpdate();
            System.out.println(x + " cart data stored in database.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, pStatement, null);
        }
    }

    @Override
    public List<CartItem> getAllCart(int userId) {
        List<CartItem> cartItems = new ArrayList<>();
        String query = "SELECT * FROM cart_item WHERE cid = ?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, userId);
            resultSet = pStatement.executeQuery();
            
            while (resultSet.next()) {
                CartItem cartItem = extractCartItemFromResultSet(resultSet);
                cartItems.add(cartItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(resultSet, pStatement, null);
        }
        return cartItems;
    }

    @Override
    public void updateCart(int cartId, int quantity) {
        String query = "UPDATE cart_item SET quantity = ? WHERE cartId = ?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, quantity);
            pStatement.setInt(2, cartId);
            
            int x = pStatement.executeUpdate();
            System.out.println(x + " cart updated");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, pStatement, null);
        }
    }

    
    @Override
    public void deleteCart(int cartId) {
        String query = "DELETE FROM cart_item WHERE cartId = ?";
        try {
            pStatement = connection.prepareStatement(query);
            pStatement.setInt(1, cartId);
            
            int x = pStatement.executeUpdate();
            System.out.println(x + " row deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, pStatement, null);
        }
    }

    private CartItem extractCartItemFromResultSet(ResultSet res) throws SQLException {
        CartItem cartItem = new CartItem();
        cartItem.setCartId(res.getInt("cartId"));
        cartItem.setItemId(res.getInt("itemId"));
        cartItem.setRestaurantId(res.getInt("restaurantId"));
        cartItem.setItemName(res.getString("itemName"));
        cartItem.setQuantity(res.getInt("quantity"));
        cartItem.setPrice(res.getDouble("price"));
        return cartItem;
    }

    private void closeResources(ResultSet rs, PreparedStatement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close(); // Close the ResultSet
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (ps != null) {
                ps.close(); // Close the PreparedStatement
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close(); // Close the Connection
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace if there is an SQL exception
        }
    }
}
