package com.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.CartDAO;
import com.food.DAOimplment.CartDAOImp;


@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDAO cartDAO;
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAOImp();
		

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId = Integer.parseInt(request.getParameter("cartId"));
		
		cartDAO.deleteCart(cartId);
		response.sendRedirect("ViewCart");

	}


}
