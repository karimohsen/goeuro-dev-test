package de.goeuro.utilites;

public class Utility {

	public static boolean validateCity(String city) {
		return city
				.matches("^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$");
	}

	// append double quotes
	// if text happens to have a comma in it
	public static String appendDQ(String str) {
		if (str == null)
			return null;
		return "\"" + str + "\"";
	}
}
