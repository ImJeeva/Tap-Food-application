package com.food.DAOimplment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.DAO.RestaurantDAO;
import com.food.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO {
    Connection connection = null;

    public RestaurantDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tap_food", "root", "Imjeeva@888");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        String query = "INSERT INTO `restaurant` (`Name`, `CuisineType`, `DeliveryTime`, `Address`, `Rating`, `IsActive`) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getCuisineType());
            ps.setString(3, restaurant.getDeliveryTime());
            ps.setString(4, restaurant.getAddress());
            ps.setDouble(5, restaurant.getRating());
            ps.setBoolean(6, restaurant.getIsActive());
            int a = ps.executeUpdate();
            System.out.println(a + " Yes, the data stored.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, null, null);
        }
    }

    @Override
    public Restaurant getRestaurant(int restaurantId) {
        String query = "SELECT * FROM restaurant WHERE restaurantId = ?";
        Restaurant rest = null;
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, restaurantId);
            res = ps.executeQuery();
            if (res.next()) {
                rest = print(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, res, null);
        }
        return rest;
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        String query = "UPDATE `restaurant` SET `Name` = ?, `CuisineType` = ?, `DeliveryTime` = ?, `Address` = ?, `Rating` = ?, `IsActive` = ? WHERE `RestaurantId` = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, restaurant.getName());
            ps.setString(2, restaurant.getCuisineType());
            ps.setString(3, restaurant.getDeliveryTime());
            ps.setString(4, restaurant.getAddress());
            ps.setDouble(5, restaurant.getRating());
            ps.setBoolean(6, restaurant.getisActive());
            ps.setInt(7, restaurant.getRestaurantId());
            int x = ps.executeUpdate();
            System.out.println(x + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, null, null);
        }
    }

    @Override
    public void deleteRestaurant(int restaurantId) {
        String query = "DELETE FROM `restaurant` WHERE `RestaurantId` = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, restaurantId);
            int n = ps.executeUpdate();
            System.out.println(n + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, null, null);
        }
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        String query = "SELECT * FROM `restaurant`";
        ArrayList<Restaurant> al = new ArrayList<>();
        Statement stm = null;
        ResultSet res = null;
        try {
            stm = connection.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                Restaurant restaurant = print(res);
                al.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, res, stm);
        }
        return al;
    }

    @Override
    public List<Restaurant> getRestaurantByRating() {
        String query = "SELECT * FROM `restaurant` ORDER BY Rating DESC";
        ArrayList<Restaurant> al = new ArrayList<>();
        Statement stm = null;
        ResultSet res = null;
        try {
            stm = connection.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                Restaurant restaurant = print(res);
                al.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, res, stm);
        }
        return al;
    }

    @Override
    public List<Restaurant> getRestaurantByTiming() {
        String query = "SELECT * FROM `restaurant` ORDER BY DeliveryTime ASC";
        ArrayList<Restaurant> al = new ArrayList<>();
        Statement stm = null;
        ResultSet res = null;
        try {
            stm = connection.createStatement();
            res = stm.executeQuery(query);
            while (res.next()) {
                Restaurant restaurant = print(res);
                al.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, res, stm);
        }
        return al;
    }

    @Override
    public List<Restaurant> getRestaurantByCuisineType(String type) {
        String query = "SELECT * FROM `restaurant` WHERE `CuisineType` LIKE ?";
        ArrayList<Restaurant> al = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet res = null;
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, "%" + type + "%"); // Set the wildcard search
            res = ps.executeQuery();
            while (res.next()) {
                Restaurant restaurant = print(res);
                al.add(restaurant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(ps, res, null);
        }
        return al;
    }

    private Restaurant print(ResultSet res) throws SQLException {
        Restaurant rest = new Restaurant();
        rest.setRestaurantId(res.getInt("RestaurantId"));
        rest.setName(res.getString("Name"));
        rest.setCuisineType(res.getString("CuisineType"));
        rest.setDeliveryTime(res.getString("DeliveryTime"));
        rest.setAddress(res.getString("Address"));
        rest.setRating(res.getDouble("Rating"));
        rest.setActive(res.getBoolean("IsActive"));
        rest.setImgPath(res.getString("ImagePath"));
        return rest;
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
