package com.HotelDemo.login;

public class LoginService {

	public boolean isUserValid(String username, String password) {

		if (username.equals("KHATRI") && password.equals("khatri@09"))
			return true;

		return false;
	}

}
