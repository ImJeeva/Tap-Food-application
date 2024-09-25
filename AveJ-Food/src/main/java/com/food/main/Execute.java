package com.food.main;

import java.util.List;

import com.food.DAOimplment.OrderHistorysDAOImp;
import com.food.model.OrderHistorys;

public class Execute {

	public static void main(String[] args) {
		
		
		/*------------------------------------FOR USER---------------------------------------------------*/
//		User u=new User(1, "jeeva", "j@123", "jeeeva@gmail.com", "tamilnadu,trichy", "Customer");
//		UserDAOImp udao=new UserDAOImp();
//		udao.addUser(u);
		
		
		
//		UserDAOImp ud=new UserDAOImp();
//		User user=ud.getUser(1);
//		System.out.println(user);
		
//		User u=new User(1,"JEEVA","3718","jeeva@22","TRICHY-TN","Customer");
//		UserDAOImp ud=new UserDAOImp();
//		ud.updateUser(u);
		
//		UserDAOImp u=new UserDAOImp();
//		u.deleteUser(2);
		
		
//		UserDAOImp u=new UserDAOImp();
//		List<User> l=u.getAllUser();
//		for(User us:l) {
//			System.out.println(us);
//		}
		
		
      /*------------------------------------FOR RESTAURANT--------------------------------------------------- */
		    /*ADD RESTAURANT()*/
//		Restaurant r=new Restaurant(2,"jeevaHotel","North Indian",20,"Trichy",4.8,true);
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.addRestaurant(r);
		
//		RestaurantDAOImp r=new RestaurantDAOImp();
//		Restaurant rr=r.getRestaurant(3);
//		System.out.println(rr);
		
//		Restaurant r=new Restaurant(4, "john", "North Indian", 30, "Thillai Nagara 1st crose",4.2,true);
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.updateRestaurant(r);
		
//		Restaurant r=new Restaurant();
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		rd.deleteRestaurant(4);
		
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		List <Restaurant> al=rd.getAllRestaurants();
//		for(Restaurant r:al) {
//			System.out.println(r);
//		}	
		
//		RestaurantDAOImp rd=new RestaurantDAOImp();
//		List <Restaurant> al=rd.getRestaurantByRating();
//		for(Restaurant r:al) {
//			System.out.println(r);
//		}	
		
			/*
			 * RestaurantDAOImp rd=new RestaurantDAOImp(); List <Restaurant>
			 * al=rd.getRestaurantByCuisineType("indian"); for(Restaurant r:al) {
			 * System.out.println(r); }
			 */
		
		
		
		
		
		
		/*----------------------------------------------FOR MENU--------------------------------------------*/
//		Menu menu=new Menu(1, "Beriyani", "delecious", 249.99, true);
//		MenuDAOImp u=new MenuDAOImp();
//		u.addMenu(menu);
		

//		MenuDAOImp md=new MenuDAOImp();
//		Menu m=md.getMenu(1);
//		System.out.println(m);
		
//		Menu m=new Menu(1,"ChckenBeriyani","un-limit",200,true);
//		MenuDAOImp md=new MenuDAOImp();
//		md.updateMenu(m);
		
//		MenuDAOImp m=new MenuDAOImp();
//		m.deleteMenu(2);
		
//		MenuDAOImp md=new MenuDAOImp();
//		List<Menu> l=md.getAllMenusByRestaurant(3);
//		for(Menu m:l) {
//			System.out.println(m);
//		}
		
		/*----------------------------------------------FOR ORDER--------------------------------------------*/
//		Order o=new Order(1,1000,"Pending","UPI");
//		OrderDAOImp od=new OrderDAOImp();
//		od.addOrder(o);
		
//		OrderDAOImp o=new OrderDAOImp();
//		Order or=o.getOrder(1);
//		System.out.println(or);
		
//		Order order=new Order(1, 1999, "Deliverd", "UPI");
//		OrderDAOImp or=new OrderDAOImp();
//		or.updateOrder(order);
		
//		OrderDAOImp or=new OrderDAOImp();
//		or.deleteOrder(1);
		
//		OrderDAOImp o=new OrderDAOImp();
//		List<Order> l=o.getAllOrdersByUser(1);
//		for(Order oo:l) {
//			System.out.println(oo);
//		}
		
		/*----------------------------------------------FOR ORDER HISTORY--------------------------------------------*/
//		OrderHistory o=new OrderHistory(1, 2999, "Deliverd");
//		OrderHistoryDAOImp oh=new OrderHistoryDAOImp();
//		oh.addOrderHistry(o);
		
//		OrderHistoryDAOImp oh=new OrderHistoryDAOImp();
//		OrderHistory o=oh.getOrderHistry(1);
//		System.out.println(o);
		
//		OrderHistory oh=new OrderHistory(1, 9999, "Deliverd");
//		OrderHistoryDAOImp orh=new OrderHistoryDAOImp();
//		orh.updateOrderHistry(oh);
		
//		OrderHistoryDAOImp oh=new OrderHistoryDAOImp();
//		oh.deleteOrderHistry(2);
		
		
//		OrderHistoryDAOImp oh=new OrderHistoryDAOImp();
//		List<OrderHistory> ll=oh.getAllOrderHistoriesByUser(1);
//		for(OrderHistory o:ll) {
//			System.out.println(o);
//		}
		
		/*----------------------------------------------FOR ORDER ITEMS--------------------------------------------*/
//		OrderItem oi=new OrderItem(1, 5, 10);
//		OrderItemDAOImp ori=new OrderItemDAOImp();
//		ori.addMenu(oi);
		
//		OrderItemDAOImp o=new OrderItemDAOImp();
//		OrderItem oi=o.getMenu(1);
//		System.out.println(oi);
		
//		OrderItem oi=new OrderItem(1, 20, 30);
//		OrderItemDAOImp o=new OrderItemDAOImp();
//		o.updateMenu(oi);
		
//		OrderItemDAOImp o=new OrderItemDAOImp();
//		o.deleteMenu(2);
		
//		OrderItemDAOImp o=new OrderItemDAOImp();
//		List <OrderItem> oi=o.getAllMenuByOrder(1);
//		for(OrderItem ori:oi) {
//			System.out.println(ori);
//		}
		
//		 --------------------------------------------------------------
		
//	   CartDAOImp c = new CartDAOImp();
//	   List l = c.getAllCart(3);
//	   for(CartItem ci :(List<CartItem>) l) {
//		   System.out.println(ci);
//	   }
		
		OrderHistorysDAOImp orderHistorysDAOImp = new OrderHistorysDAOImp();
		
		List<OrderHistorys> l = orderHistorysDAOImp.getOrderHistrys(3);
		for(OrderHistorys oh :l) {
			System.out.println(oh);
			
		}
		
	
		
		
		
		/*----------------------------------------------CONGURATS YOU DID IT--------------------------------------------*/

		

		
		

	}

}
 