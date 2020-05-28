package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userPage {

	protected WebDriver driver;

	public userPage(WebDriver driver) {
		this.driver = driver;
	}

	By greetText = By.xpath("//span[@class='sb-searchbox__title-text']");
	By viewBooking = By.xpath("//div[@id='dashboard_container']/div/div/div[1]/div[2]/div[2]/div[2]/a");

	By currentAccDropDown = By.xpath("//li[@id='current_account']");

	public WebElement currentAccDropDown() {

		return driver.findElement(currentAccDropDown);
	}

	public WebElement greetText() {
		return driver.findElement(greetText);

	}

	public WebElement viewBooking() {
		return driver.findElement(viewBooking);
	}

}
