package com.food.model;

public class Restaurant {
	private int restaurantId;
	private String name;
	private String cuisineType;
	private String deliveryTime;
	private String address;
	//private int  adminUserId;
	private double rating;
	private boolean isActive;
	private String imagepath;
	
	
	
	public Restaurant() {
		
	}


	public Restaurant(int restaurantId, String name, String cuisineType, String deliveryTime, String address,
			 double rating, boolean isActive) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		//this.adminUserId = adminUserId;
		this.rating = rating;
		this.isActive = isActive;
		
	}


	public int getRestaurantId() {
		return restaurantId;
	}


	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCuisineType() {
		return cuisineType;
	}


	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}


	public String getDeliveryTime() {
		return deliveryTime;
	}


	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImgPath() {
		return imagepath;
	}

	public void setImgPath(String imgPath) {
		this.imagepath = imgPath;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}


	public boolean getisActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	

	@Override
	public String toString() {
		return restaurantId+", "+name+" ,"+cuisineType+" ,"+deliveryTime+", "+address+" ,"+rating+", "+isActive+", "+imagepath;
	}

	
    
	

}










