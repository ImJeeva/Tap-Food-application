package com.food.model;

public class Menu {
	private int menuId;
	private int restaurantId;
	private String itemName;
	private String description;
	private double price;
	private boolean isAvailable;
	private String  imagePath;
	
	public Menu() {
		
	}

	public Menu(int menuId, String itemName, String description, double price, boolean isAvailable) {
		super();
		this.menuId = menuId;
		this.itemName = itemName;
		this.description = description;
		this.price = price;
		this.isAvailable = isAvailable;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String  getImagePath() {
		return imagePath;
	}


	
	
  public String toString() {
	  return menuId+" "+restaurantId+","+itemName+" ,"+description+","+price+","+isAvailable+" "+imagePath;
  }
	

}
