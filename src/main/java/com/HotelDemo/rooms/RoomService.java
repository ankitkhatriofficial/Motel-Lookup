package com.HotelDemo.rooms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoomService {

	private static List<Room> rooms = new ArrayList<Room>();
	private List<Room> stateRooms = new ArrayList<Room>();

	static {

		rooms.add(new Room("Own Home", "New Delhi", "13-05-2020", "4500", "img1.jpg"));
		rooms.add(new Room("Mayur Palace", "Haryana", "11-03-2020", "5500", "img2.jpg"));
		rooms.add(new Room("khatri's Hotel", "Maharastra", "03-06-2020", "6500", "img3.jpg"));

		rooms.add(new Room("Mayur Palace", "Maharastra", "23-04-2020", "8500", "img4.jpg"));
		rooms.add(new Room("khatri's Hotel", "Haryana", "13-03-2020", "6500", "img5.jpg"));
		rooms.add(new Room("Hotel Number One", "Rajasthan", "09-08-2020", "10999", "img6.jpg"));

		rooms.add(new Room("Hotel Number Two", "New Delhi", "01-06-2020", "6500", "img7.jpg"));
		rooms.add(new Room("Mayur Palace", "Maharastra", "08-03-2020", "7000", "img8.jpg"));
		rooms.add(new Room("Something Special", "Maharastra", "14-11-2020", "7500", "img9.jpg"));

		rooms.add(new Room("khatri's Hotel", "Uttar Pradesh", "17-08-2020", "9999", "img10.jpg"));
		rooms.add(new Room("New Hotel", "New Delhi", "26-05-2020", "8900", "img11.jpg"));
		rooms.add(new Room("It's your Room", "Haryana", "29-10-2020", "7600", "bgimage.jpg"));
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public List<Room> getRooms(String state) {
		int index = 0;
		Iterator<Room> itr = rooms.iterator();
		while (itr.hasNext()) {
			String location = itr.next().getLocation();
			if (state.equals("all"))
				stateRooms.add(rooms.get(index));
			else if (location.equals(state)) {
				stateRooms.add(rooms.get(index));
			}
			++index;
		}
		return stateRooms;

	}
}
