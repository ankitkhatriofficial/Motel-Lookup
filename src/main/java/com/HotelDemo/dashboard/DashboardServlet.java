package com.HotelDemo.dashboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.HotelDemo.rooms.Room;
import com.HotelDemo.rooms.RoomService;

@WebServlet(urlPatterns = "/dashboard")
public class DashboardServlet extends HttpServlet {

	private RoomService roomServiceObj = new RoomService();
	private List<Room> rooms = new ArrayList<Room>();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("token") != null) {
			request.setAttribute("rooms", roomServiceObj.getRooms());
			request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMsg", "You must have Login First.!");
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		if (request.getSession().getAttribute("token") != null) {

			String state = request.getParameter("request");
			rooms = roomServiceObj.getRooms(state);
			if (rooms.isEmpty())
				out.print("<h1>We are not available here...</h1>");

			else {
				Iterator<Room> itr = rooms.iterator();
				Room room = new Room(null, null, null, null, null);

				while (itr.hasNext()) {
					room = itr.next();
					out.print(
							"<div class=\"room-container\"><div class=\"combined-container\"><div class=\"top-room-container\"><div class=\"hotel-info-wrapper\">");
					out.print("<label>" + room.getHotelName() + "</label><br> <span>" + room.getLocation() + "</span>");
					out.print("</div><div class=\"img-container\"><img src=\"assets/imgs/" + room.getUrl()
							+ "\" alt=\"Hotel Img\"></div></div>");
					out.print("<div class=\"mid-room-container\"><label>Available Date</label> <label>Start @ "
							+ room.getPrice() + "/-</label></div></div>");
					out.print(
							"<div class=\"bottom-room-container\"><a href=\"#\">Book Now <i class=\"fa fa-arrow-circle-o-right\"aria-hidden=\"true\"></i></a></div></div>");
				}
				rooms.clear();
			}
		} else {
			out.print("error");
		}
	}
}
