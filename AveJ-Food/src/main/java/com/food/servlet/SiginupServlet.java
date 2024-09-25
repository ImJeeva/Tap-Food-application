package com.food.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.DAO.UserDAO;
import com.food.DAOimplment.UserDAOImp;
import com.food.model.User;

/**
 * Servlet implementation class SiginupServlet
 */
@WebServlet("/signup")
public class SiginupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserDAO userDAOImp;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		userDAOImp = new UserDAOImp();

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String confirmPassword = req.getParameter("confirmPassword");
		String password = req.getParameter("password");
		String address = req.getParameter("address");
		String role = req.getParameter("role");

		if (password.equals(confirmPassword)) {
			User user = new User(username, password, email, address, role);	
			int x = userDAOImp.addUser(user);
			if (x != 0) {
				resp.sendRedirect("login.jsp");
			}
//
		} else {
			resp.sendRedirect("PasswordError.jsp");
		}

	}

}
