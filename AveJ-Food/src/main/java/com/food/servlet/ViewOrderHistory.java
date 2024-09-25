package com.food.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.OrderHistorysDAO;
import com.food.DAOimplment.OrderHistorysDAOImp;
import com.food.model.OrderHistorys;
import com.food.model.User;

/**
 * Servlet implementation class ViewOrderHistory
 */
@WebServlet("/ViewOrderHistory")
public class ViewOrderHistory extends HttpServlet {
	OrderHistorysDAO orderHistorysDAO;
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		orderHistorysDAO = new OrderHistorysDAOImp();

	}
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user =(User)session.getAttribute("loggedInUser");
		
		List<OrderHistorys> orderHistory = orderHistorysDAO.getOrderHistrys(user.getUserID());
		session.setAttribute("orderHistory", orderHistory);
		System.out.println("orderhistory view");
		response.sendRedirect("orderhistory.jsp");
	}


}
