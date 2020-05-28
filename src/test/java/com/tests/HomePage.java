package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.pages.LogInPage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import resources.DataProviderUser;
import resources.Base;

public class HomePage extends Base {
	public Logger Log = LogManager.getLogger(HomePage.class.getName());
	LogInPage blogin; // pageObject class is declared as global variable
	// once blogin = new LoginPageObject(driver); is initialized all subsequent
	// classes
	// don't require it to be initialized

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver(); // initializeDriver will return driver from base class
		// storing the initializeDriver in Driver to access it in the current class
		Log.info("Driver Initialized");

		driver.get(prop.getProperty("homeURL"));
		
		
		
	}

	//@Parameters({ "homeURL", "1useremail", "1userpassword" })
	
	@Test(dataProvider = "firstUserAndPass", dataProviderClass = DataProviderUser.class)

	public void PageTest(String firstUserEmail, String firstUserPassword)

	{

		SoftAssert sAssert = new SoftAssert();

		sAssert.assertEquals(true, false);

		// comes from properties file
		// creating object of Page Object class and invoking method
		blogin = new LogInPage(driver);

		// LoginPageObject blogin = new LoginPageObject(driver);
		// declared and active within this method

		// passing the knowledge of the browser webdriver
		driver.get(prop.getProperty("homeURL"));
		Log.info("Navigated to HomeURL");

		driver.manage().window().maximize();
		Log.info("window maximized");

		blogin.clickHomeSignIn();
		;
		Log.info("clicked Sign in");
		blogin.clickNextSubmit();
		blogin.sendUserPassword("Password");
		blogin.clickNextSubmit();
		String greeting = blogin.getGreetText();
		Assert.assertEquals("Where to next, Timur?", greeting);
		Log.info("Asserted Greeeting");
		System.out.println(greeting);

		Assert.assertTrue(true, greeting);

		Assert.assertTrue(blogin.nextSubmitIsEnabled());

	}

	@AfterTest
	public void endSession() {

		driver.quit();
		Log.info("Browser Closed");
		// driver = null; // bringing memory to Null

	}

}
