package com.HotelDemo.shared;

public class Service {

	/* This method will return false if found any number inside String */
	public boolean isStringOnlyAlphabet(String string) {
		return ((string != null) && (!string.equals("")) & (string.matches("^[a-zA-Z]*$")));
	}

	/* This method will return true if the String contains all numbers */
	public boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Long d = Long.parseLong(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
