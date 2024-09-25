package com.food.DAO;

import java.util.List;

import com.food.model.Order;

public interface OrderDAO {
	void addOrder(Order order);
	
	Order getOrder(int orderId);
	
	void updateOrder(Order Order);
	
	void deleteOrder(int orderId);
	
	List<Order> getAllOrder(Order order);
	
	List<Order> getAllOrdersByUser(int userId);

}
