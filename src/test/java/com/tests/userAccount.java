package com.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class userAccount extends Base {
	public Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initializeStart() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("secndURL"));
	}
	
	
	
	@Test
	public void userTest() throws IOException {

		

		Log.info("Opened 2nd Test Case");
		driver.manage().window().maximize();

		driver.findElement(By.id("mailbox:login")).sendKeys("KaroPrievt");
		Select domen = new Select(driver.findElement(By.id("mailbox:domain")));

		domen.selectByVisibleText("@list.ru");

		driver.findElement(By.id("mailbox:submit")).click();

		String errMesg = driver.findElement(By.xpath("//div[@id='mailbox:error']")).getText();
		System.out.println(errMesg);

		Assert.assertEquals(errMesg, "Неверное имя ящика");

		System.out.println("Doesn't match. / Testing is continued");
	}

	@AfterTest

	public void endSession() {

		driver.quit();
		//driver = null;

	}
}
