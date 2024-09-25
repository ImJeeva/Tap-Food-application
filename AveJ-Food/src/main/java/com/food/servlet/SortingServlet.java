package com.food.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/sorting")
public class SortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantDAO restaurantDao;

	@Override
	public void init() {
		restaurantDao = new RestaurantDAOImp();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the selected option from the request
		String selectedOption = request.getParameter("option");
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		out.print(name);

		// Process the selected option
		// fetch the details based on the selected option
		String result;
		switch (selectedOption) {
		case "rating":
			result = "rating";
			break;
		case "time":
			result = "time";
			break;
		
//		  case "cuisine type":
//			  result = "cuisine type";
//			  break;
		 
		default:
			result = "Invalid selection";
			break;
		}
		if(result == "rating") {
		List<Restaurant> restaurantRating = restaurantDao.getRestaurantByRating();

		HttpSession session = request.getSession();
		session.setAttribute("restaurantRating", restaurantRating);
		response.sendRedirect("rating.jsp");
		}
		
		else if(result == "time") {
		List<Restaurant> restaurantTiming = restaurantDao.getRestaurantByTiming();

		HttpSession session = request.getSession();
		session.setAttribute("restaurantTiming", restaurantTiming);
		response.sendRedirect("deliveryTiming.jsp");
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
