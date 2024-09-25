package com.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.CartDAO;
import com.food.DAOimplment.CartDAOImp;
import com.food.model.CartItem;
import com.food.model.User;

/**
 * Servlet implementation class ccart
 */
@WebServlet("/cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDAO cartDAO;

	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAOImp();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("itemId"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		int restId = Integer.parseInt(request.getParameter("restId"));
		String itemName = request.getParameter("itemName");
		String priceString = request.getParameter("itemPrice");
		double price = 0.0;
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		try {
			price = Double.parseDouble(priceString);
		} catch (NumberFormatException e) {
			// Handle the exception in case the string is not a valid number
			System.out.println("Invalid price format");
		}

		CartItem cartItem = new CartItem(cid, id, restId, itemName, quantity, price);
		cartDAO.addCart(cartItem);
		HttpSession session = request.getSession();

		session.setAttribute("cid", cid);
		session.setAttribute("restaurantId", restId);

		response.sendRedirect("ViewCart");

	}

}
