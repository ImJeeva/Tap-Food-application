package com.food.servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.DAO.OrderHistorysDAO;
import com.food.DAOimplment.OrderHistorysDAOImp;
import com.food.model.OrderHistorys;

/**
 * Servlet implementation class OrderHistoryServlet
 */
@WebServlet("/orderHistory")
public class OrderHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderHistorysDAO orderHistorysDAO;

    @Override
    public void init() {
    	orderHistorysDAO = new OrderHistorysDAOImp();
			

         
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	int cid =  Integer.parseInt( request.getParameter("cid"));
    	int restaueantId =  Integer.parseInt( request.getParameter("restaueantId"));
    	int quantity =  Integer.parseInt( request.getParameter("quantity"));
    	String itemName = request.getParameter("itemName");
    	double totalAmount = Double.parseDouble(request.getParameter("totalAmount"));
    	
    	OrderHistorys orderHistorys = new OrderHistorys(cid, restaueantId, quantity, itemName, totalAmount);
    	
    	orderHistorysDAO.addOrderHistrys(orderHistorys);
    	response.sendRedirect("checkout.jsp");
    	
    }
       
}

