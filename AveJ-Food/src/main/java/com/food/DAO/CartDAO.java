package com.food.DAO;

import java.util.List;

import com.food.model.CartItem;

public interface CartDAO {
	public void addCart(CartItem cartItem);
	
	public List<CartItem> getAllCart(int usetId);
	
	public void updateCart(int cartId, int quantity);
	
	public void deleteCart(int cartId);
	

}
