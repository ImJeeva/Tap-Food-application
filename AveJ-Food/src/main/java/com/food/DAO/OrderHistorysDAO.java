package com.food.DAO;

import java.util.List;

import com.food.model.OrderHistorys;

public interface OrderHistorysDAO {
	public void addOrderHistrys(OrderHistorys orderHistry);
	
	public List<OrderHistorys> getOrderHistrys(int userid);
	
	
	

}
