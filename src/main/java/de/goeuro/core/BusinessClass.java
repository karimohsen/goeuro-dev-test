package de.goeuro.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.goeuro.entity.City;
import de.goeuro.utilites.Constants;

public class BusinessClass {

	private HttpURLConnection connectToService(String cityName) {
		try {
			URL url = new URL(Constants.SERVICE_URL + cityName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException(Constants.UNNABLE_TO_CONNECT + conn.getResponseCode());
			}
			return conn;
		} catch (MalformedURLException e) {
			System.out.println(Constants.SERVICE_ERROR);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public void writeCSVFile(String cityName) {

		HttpURLConnection conn = new BusinessClass().connectToService(cityName);
		URL url = conn.getURL();
		File file = null;
		PrintWriter printWriter = null;
		try {

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			City[] cityData = objectMapper.readValue(url, City[].class);

			if (cityData.length == 0) {
				System.out.print(Constants.NO_DATA);
			} else {
				String home = System.getProperty("user.home");
				file = new File(home + "/" + cityName + ".csv");
				printWriter = new PrintWriter(file, "ISO-8859-1");
				printWriter.print("_id" + Constants.SEPARATOR);
				printWriter.print("name" + Constants.SEPARATOR);
				printWriter.print("type" + Constants.SEPARATOR);
				printWriter.print("latitude" + Constants.SEPARATOR);
				printWriter.println("longitude" + Constants.SEPARATOR);

				for (City city : cityData) {
					printWriter.print(city);
					printWriter.println();
				}
				printWriter.close();
				conn.disconnect();
			}
		} catch (FileNotFoundException e) {
			System.out.println(Constants.FILE_OPEN_ERROR);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
