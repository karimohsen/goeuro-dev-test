package de.goeuro.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.goeuro.utilites.Constants;

public class ClientTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void emptyStringTest(){
		Client.main(new String[] {""});
		Assert.assertEquals(Constants.NO_CITY, outContent.toString());
	}
	
	@Test
	public void emptyArrayTest(){
		Client.main(new String[] {});
		Assert.assertEquals(Constants.NO_CITY, outContent.toString());
	}
	
	
	@Test
	public void invalidCityNameTest(){
		Client.main(new String[] {"Arf%as@#!"});
		Assert.assertEquals(Constants.INCORRECT_CITY, outContent.toString());
	}
	
}
