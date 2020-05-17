package com.HotelDemo.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private LoginService loginServiceObj = new LoginService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("token") != null)
			response.sendRedirect("/dashboard");
		else
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (loginServiceObj.isUserValid(username, password) == true) {
			request.getSession().setAttribute("token", "valid");
			response.sendRedirect("/dashboard");
		} else {
			request.setAttribute("errorMsg", "Invalid Credentials.!");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
			;
		}
	}
}
