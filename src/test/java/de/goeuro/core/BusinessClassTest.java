package de.goeuro.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.goeuro.utilites.Constants;

public class BusinessClassTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final String home = System.getProperty("user.home");
	
	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}
	
	@Test
	public void noDataReturnedTest(){
		Client.main(new String[] {"abcdses"});
		Assert.assertEquals(Constants.NO_DATA, outContent.toString());
	}
	
	@Test
	public void csvFileCreatedTest(){
		Client.main(new String[] {"berlin"});
		File tempFile = new File(home + "/berlin.csv");
		boolean exists = tempFile.exists();
		Assert.assertTrue(exists);
	}
}
