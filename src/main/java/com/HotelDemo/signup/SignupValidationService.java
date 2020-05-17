package com.HotelDemo.signup;

import com.HotelDemo.shared.Service;

public class SignupValidationService {

	private Service serviceObj = new Service();

	public String validateDetails(String firstName, String lastName, String email, String password,
			String confirm_password) {

		if (firstName.isBlank() || serviceObj.isStringOnlyAlphabet(firstName) == false)
			return "First Name is Invalid.!";
		else if (lastName.isBlank() || serviceObj.isStringOnlyAlphabet(lastName) == false)
			return "Last Name is Invalid.!";
		else if (email.isBlank() || !email.contains("@") || !email.contains("."))
			return "Invalid Email ID.!";
		else if (password.length() < 8)
			return "Password is too Weak.!";
		else if (!(password.equals(confirm_password)))
			return "Password must match.!";
		else
			return null;
	}

}
