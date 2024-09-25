package com.food.model;
import java.util.Date;

public class Order {
	private int orderId;
	private int userId;
	private int restaurantId;
	private Date orderDate;
	private double totalAmount;
	private String status;
	private String PaymentMethod;
	

	
	public Order() {
		
	}



	public Order(int orderId, double totalAmount, String status,
			String PaymentMethod) {
		super();
		this.orderId = orderId;
//		this.userId = userId;
//		this.restaurantId = restaurantId;
//		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.status = status;
		this.PaymentMethod = PaymentMethod;
	}



	public int getOrderId() {
		return orderId;
	}



	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getRestaurantId() {
		return restaurantId;
	}



	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}



	public Date getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getPaymentMethod() {
		return PaymentMethod;
	}



	public void setPaymentMethod(String PaymentMethod) {
		this.PaymentMethod = PaymentMethod;
	}



	@Override
	public String toString() {
		return  orderId + ", " + userId + ", " + restaurantId + ","+ orderDate + ", " + totalAmount + ","+ status + ","+ PaymentMethod ;
				
				
	}
	
  
}
