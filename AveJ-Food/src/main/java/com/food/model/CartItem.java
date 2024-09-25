package com.food.model;

public class CartItem {
	private int cartId;
	private int cid;
	private int itemId;
	private int restaurantId;
	private String itemName;
	private int quantity;
	private double price;
	
	public CartItem() {
		
	}

	public CartItem(int cid, int itemId, int restaurantId, String itemName, int quantity, double price) {
		super();
		this.cid = cid;
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int resturantId) {
		this.restaurantId = resturantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String name) {
		this.itemName = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String toString() {
		return cartId+", "+ itemId+","+restaurantId+", "+itemName+","+quantity+","+price;
	}

}
