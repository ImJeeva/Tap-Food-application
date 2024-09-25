package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.RestaurantDAO;
import com.food.DAOimplment.RestaurantDAOImp;
import com.food.model.Restaurant;



@WebServlet("/restaurant")
public class RestaurantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	   private RestaurantDAO restaurantDao;

	   @Override
	    public void init() {
	        restaurantDao = new RestaurantDAOImp();
	    }

	    @Override
	    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	
	        List<Restaurant> restaurantList =restaurantDao.getAllRestaurants();
	        
	        HttpSession session = req.getSession();
	        session.setAttribute("restaurantList", restaurantList);
	        
	        resp.sendRedirect("restaurant.jsp");
	    }    

}
