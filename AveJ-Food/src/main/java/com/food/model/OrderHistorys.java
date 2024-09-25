
package com.food.model;

public class OrderHistorys {
	private int orderHistoryId;
	private int cid;
	private int restaurantId;
	private int quantity;
	private String itemName;
	private double totalAmount;
	
	public OrderHistorys() {
		
	}

	public OrderHistorys( int cid, int restaurantId, int quantity, String itemName, double totalAmount) {
		super();
		this.cid = cid;
		this.restaurantId = restaurantId;
		this.quantity = quantity;
		this.itemName = itemName;
		this.totalAmount = totalAmount;
	}

	
	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String toString(){
		return cid+", "+orderHistoryId+", "+itemName+", "+quantity +", "+totalAmount;
	}
	
	
	

}	