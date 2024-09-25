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

import com.food.DAO.MenuDAO;
import com.food.model.Menu;

public class MenuDAOImp implements MenuDAO {
    Scanner scan = new Scanner(System.in);
    String url = "jdbc:mysql://localhost:3306/tap_food";
    String user = "root";
    String pass = "Imjeeva@888";
    Connection connection = null;
    String insertQuery = "INSERT INTO `menu` (`item_name`,`description`,`price`,`isavailable`) VALUES (?,?,?,?)";
    String retreiveQuery = "SELECT * FROM `menu` WHERE `menuid` = ?";
    String updateQuery = "UPDATE `menu` SET `itemname` = ? , `description` = ? , `price` = ? , `is_available` = ? WHERE `menuid` = ?";
    String deleteQuery = "DELETE FROM `menu` WHERE `menuid` = ?";
    String selectQuery = "Select * FROM `menu`";
    String getRestaurant = "SELECT * FROM `menu` WHERE `restaurantid` = ?";
    PreparedStatement statement = null;
    Statement statement2 = null;
    ResultSet res = null;
    
    public MenuDAOImp() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addMenu(Menu menu) {
        try {
            statement = connection.prepareStatement(insertQuery);
            statement.setString(1, menu.getItemName());
            statement.setString(2, menu.getDescription());
            statement.setDouble(3, menu.getPrice());
            statement.setBoolean(4, menu.isAvailable());
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, null);
        }
    }

    @Override
    public Menu getMenu(int menuId) {
        Menu menu = null;
        try {
            statement = connection.prepareStatement(retreiveQuery);
            statement.setInt(1, menuId);
            res = statement.executeQuery();
            
            if (res.next()) {
                menu = extractUserFromResultSet(res);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(res, statement, null);
        }
        
        return menu;
    }

    @Override
    public void updateMenu(Menu menu) {
        try {
            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, menu.getItemName());
            statement.setString(2, menu.getDescription());
            statement.setDouble(3, menu.getPrice());
            statement.setBoolean(4, menu.isAvailable());
            statement.setInt(5, menu.getMenuId());
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, null);
        }
    }

    @Override
    public void deleteMenu(int menu) {
        try {
            statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, menu);
            System.out.println("row affected: " + statement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(null, statement, null);
        }
    }

    @Override
    public List<Menu> getAllMenu(Menu menu) {
        List<Menu> list = new ArrayList<>();
        try {
            statement2 = connection.createStatement();
            res = statement2.executeQuery(selectQuery);
            
            while (res.next()) {
                Menu m = extractUserFromResultSet(res);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(res, null, statement2);
        }
        
        return list;
    }

    @Override
    public List<Menu> getAllMenusByRestaurantId(int restaurantId) {
        List<Menu> list = new ArrayList<>();
        try {
            statement = connection.prepareStatement(getRestaurant);
            statement.setInt(1, restaurantId);
            res = statement.executeQuery();
            
            while (res.next()) {
                Menu m = extractUserFromResultSet(res);
                list.add(m);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources(res, statement, null);
        }
        
        return list;
    }

    private Menu extractUserFromResultSet(ResultSet res) throws SQLException {
        Menu menu = new Menu();
        menu.setMenuId(res.getInt("menuid"));
        menu.setRestaurantId(res.getInt("restaurantid"));
        menu.setItemName(res.getString("itemname"));
        menu.setDescription(res.getString("description"));
        menu.setPrice(res.getDouble("price"));
        menu.setAvailable(res.getBoolean("isavailable"));
        menu.setImagePath(res.getString("imagePath"));
        return menu;
    }

    private void closeResources(ResultSet res, PreparedStatement pstmt, Statement stmt) {
        try {
            if (res != null) res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
