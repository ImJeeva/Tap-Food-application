package com.food.DAO;

import java.util.List;

import com.food.model.Restaurant;

public interface RestaurantDAO {
	void addRestaurant(Restaurant restaurant);
	
	Restaurant getRestaurant(int RestaurantId);
	
	void updateRestaurant(Restaurant restaurant);
	
	void deleteRestaurant(int restaurantId);
	
	List<Restaurant> getAllRestaurants();
	
	public List<Restaurant> getRestaurantByRating();
	
	public List<Restaurant> getRestaurantByTiming();
	
	public List<Restaurant> getRestaurantByCuisineType(String type);
	
	

}
