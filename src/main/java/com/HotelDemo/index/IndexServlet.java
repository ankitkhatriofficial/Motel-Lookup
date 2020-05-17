package com.HotelDemo.index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HotelDemo.rooms.RoomService;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	private RoomService roomServiceObj = new RoomService();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("rooms", roomServiceObj.getRooms());
		request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
	}
}
