package de.goeuro.core;

import de.goeuro.utilites.Constants;
import de.goeuro.utilites.Utility;

public class Client {

	public static void main(String[] args) {
		if (args.length == 0 || args[0].equals("")) {
			System.out.print(Constants.NO_CITY);
		} else {
			String cityName = args[0];
			if (!Utility.validateCity(cityName)) {
				System.out.print(Constants.INCORRECT_CITY);
			} else {
				new BusinessClass().writeCSVFile(cityName);
			}
		}
	}
}
