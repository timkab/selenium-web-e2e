package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogInPage {



 private WebDriver driver;

	// creating Constructor
	// constructors with argument and it's expecting
	// an argument from the object class
	public LogInPage (WebDriver driver) {

		this.driver = driver;
	}
	private By homeSignIn = By.xpath("//div[@id='user_form']/ul/li[5]/a/div");
	private By userEmail = By.xpath("//input[@id='username']");
	private By nextSubmit = By.xpath("//button[@type='submit']");
	private	By userPassword = By.xpath("//input[@id='password']");
	private By greetText = By.xpath("//*[@id=\"b2indexPage\"]/div[3]/div/div/h2");

	public String getGreetText() {
		 return driver.findElement(greetText).getText();
	}

	public void sendUserPassword(String UserPassword) {

		 driver.findElement(userPassword).sendKeys(UserPassword);

	}

	public void clickNextSubmit()

	{
		 driver.findElement(nextSubmit).click();
		 
	}
		 
		 public boolean nextSubmitIsEnabled() {
			 
			 return driver.findElement(nextSubmit).isEnabled();
		
		 
		
	}

	public void sendUserEmail(String UserEmail)

	{
		 driver.findElement(userEmail).sendKeys(UserEmail);

	}

	public void clickHomeSignIn() {

		 driver.findElement(homeSignIn).click();

	}
	


}
