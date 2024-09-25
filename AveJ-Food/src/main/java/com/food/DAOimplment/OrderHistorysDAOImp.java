package com.food.DAOimplment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.food.DAO.OrderHistorysDAO;
import com.food.model.OrderHistorys;

public class OrderHistorysDAOImp implements OrderHistorysDAO {

	Scanner scan = new Scanner(System.in);
	String url = "jdbc:mysql://localhost:3306/tap_food";
	String user = "root";
	String pass = "Imjeeva@888";
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet res = null;

	public OrderHistorysDAOImp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrderHistrys(OrderHistorys orderHistorys) {
		String query = "INSERT INTO order_history(cid, restaurantId, quantity, itemName, totalAmount) VALUES(?, ?, ?, ?, ?)";
		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, orderHistorys.getCid());
			pStatement.setInt(2, orderHistorys.getRestaurantId());
			pStatement.setInt(3, orderHistorys.getQuantity());
			pStatement.setString(4, orderHistorys.getItemName());
			pStatement.setDouble(5, orderHistorys.getTotalAmount());

			pStatement.executeUpdate();
			System.out.println("Order history stored");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
	}

	@Override
	public List<OrderHistorys> getOrderHistrys(int userid) {
		ArrayList<OrderHistorys> al = new ArrayList<>();
		String query = "SELECT * FROM order_history WHERE cid = ?";

		try {
			pStatement = connection.prepareStatement(query);
			pStatement.setInt(1, userid);
			res = pStatement.executeQuery();

			while (res.next()) {
				OrderHistorys order = extractUserFromResultSet(res);
				al.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return al;
	}

	private OrderHistorys extractUserFromResultSet(ResultSet res) throws SQLException {
		OrderHistorys order = new OrderHistorys();
		order.setOrderHistoryId(res.getInt("orderhistoryId"));
		order.setCid(res.getInt("cid"));
		order.setItemName(res.getString("itemName"));
		order.setQuantity(res.getInt("quantity"));
		order.setTotalAmount(res.getDouble("totalAmount"));

		return order;
	}

	// Method to close all database resources
	public void closeResources() {
		try {
			if (res != null && !res.isClosed()) {
				res.close(); // Close the result set
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}

		try {
			if (pStatement != null && !pStatement.isClosed()) {
				pStatement.close(); // Close the prepared statement
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}

		try {
			if (connection != null && !connection.isClosed()) {
				connection.close(); // Close the connection
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle SQL exceptions
		}
	}
}
