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


@WebServlet("/cusisineType")
public class CuisineTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RestaurantDAO resaturant;
	@Override
	public void init() throws ServletException {
		 resaturant = new RestaurantDAOImp();

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search");
		
		List<Restaurant> cuisineType = resaturant.getRestaurantByCuisineType(search);
		
		HttpSession session = request.getSession();
		session.setAttribute("cuisineType", cuisineType);
		response.sendRedirect("cuisineType.jsp");
		
		
		
		
		
	}



}
