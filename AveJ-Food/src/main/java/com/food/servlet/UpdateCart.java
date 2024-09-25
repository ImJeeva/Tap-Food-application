package com.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.CartDAO;
import com.food.DAOimplment.CartDAOImp;

/**
 * Servlet implementation class UpdatePost
 */
@WebServlet("/UpdateCart")
public class UpdateCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDAO cartDAO;
	@Override
		public void init() throws ServletException {
		cartDAO = new CartDAOImp();
		}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId =Integer.parseInt(request.getParameter("cartId"));
		int  quantity = Integer.parseInt(request.getParameter("quantity"));
		cartDAO.updateCart(cartId, quantity);
		response.sendRedirect("ViewCart");
		
		

	}


}
