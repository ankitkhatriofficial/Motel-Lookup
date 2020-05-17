package com.HotelDemo.rooms;

public class Room {

	private String location;
	private String hotelName;
	private String aDate;
	private String price;
	private String url;

	public Room(String hotelName, String location, String aDate, String price, String url) {
		this.location = location;
		this.hotelName = hotelName;
		this.aDate = aDate;
		this.price = price;
		this.url = url;
	}

	public String getLocation() {
		return location;
	}

	public String getHotelName() {
		return hotelName;
	}

	public String getaDate() {
		return aDate;
	}

	public String getPrice() {
		return price;
	}

	public String getUrl() {
		return url;
	}

}
