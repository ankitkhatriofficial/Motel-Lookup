package com.HotelDemo.signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/signup")
public class SignupServlet extends HttpServlet {

	SignupValidationService signupServiceObj = new SignupValidationService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("token") != null)
			response.sendRedirect("/dashboard");
		else
			request.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		String confirm_password = request.getParameter("pwd2");

		String validationError = signupServiceObj.validateDetails(firstName, lastName, email, password,
				confirm_password);

		if (validationError == null) {
			request.getSession().setAttribute("token", "valid");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Congratulation.! Your temporary account is created.!');");
			out.println("location='/dashboard'");
			out.println("</script>");
			
		} else {
			request.setAttribute("errorMsg", validationError);
			request.getRequestDispatcher("WEB-INF/views/signup.jsp").forward(request, response);
		}
	}
}
