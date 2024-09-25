package com.food.servlet;

import java.io.IOException;
import java.util.List;

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


@WebServlet("/ViewCart")
public class ViewCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartDAO cartDAO;
	
	@Override
	public void init() throws ServletException {
		cartDAO = new CartDAOImp();

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		System.out.println("cart da");

		HttpSession session = request.getSession();
		User user =(User) session.getAttribute("loggedInUser");
		int usetId = user.getUserID();
		
		List <CartItem> cartList = cartDAO.getAllCart(usetId);
		session.setAttribute("cartList", cartList);
		

		 response.sendRedirect("cart.jsp"); 
		
		
	}

}


