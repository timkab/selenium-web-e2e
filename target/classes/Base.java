package resources;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	protected Logger Log = LogManager.getLogger(Base.class.getName());

	protected Properties prop;

	// public static WebDriver driver; // Static to run in sequence to make driver
	// instance of the base class
	// non static driver for parallel execution

	public WebDriver driver;
	// Global level variable for WebDriver driver object
	// global level declaration to extend data from prop. file to other classes

	public WebDriver initializeDriver() throws IOException

	{

		Log.info("initializing Driver");

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
		System.getProperty("user.dir") + "\\src\\main\\java\\resources\\baseData.properties");

		prop.load(fis);

		// getting values from data.properties file and saving it into the String
		// Variable
		String browserName = prop.getProperty("browser");

		// <<<<< SET TO System.getProperty if running from Jenkins >>>>>

		// getting browser name from CD line when running test in CL mvn test
		// -Dbrowser=$"browser"
		// String browserName = System.getProperty("browser");


		// execute in chrome
		if (browserName.equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver78.exe");

			driver = new ChromeDriver();

		}

		else if (browserName.equalsIgnoreCase("headless Chrome")) {

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\chromedriver78.exe");
			// execute in Chrome Headless mode
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200",
					"--ignore-certificate-errors");

			driver = new ChromeDriver(options);
		}
		// execute in firefox
		else if (browserName.contains("Firefox")) {
			

			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\main\\java\\resources\\geckodriver26.exe");
			driver = new FirefoxDriver();

		}
		// execute in edge
		else if (browserName.contains("EdgeHTML")) {
			

			driver = new EdgeDriver();

		}
		// execute in safari
		else if (browserName.equals("Safari")) {

		
		}

		else {

			System.out.println("Browser not found");

		}

		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		// timeout will be applied to each browser and test case

		return driver;

	}

}
