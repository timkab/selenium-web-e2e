package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.pages.LogInPage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import resources.Base;

public class BookingLogSteps extends Base {
	
	  public Logger Log =  LogManager.getLogger(BookingLogSteps.class.getName());
	LogInPage loginpage = new LogInPage(driver);
	



	@Before                 // Hook for setting the environment
	public void getURL() {

		driver.get("url");

	}

	@After                 // Hook for tear down the browser and cleanup
	public void tearDoen() {

		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	
	
@Test
	@Given("^Initiate the driver and open browser$")
	public void initiate_the_driver_and_open_browser() throws Throwable {
		throw new PendingException();
		

	}

	@When("^User enters 'userEmail' and 'password'$")
	public void user_enters_useremail_and_password() throws Throwable {
		throw new PendingException();
	}

	@When("^User enters wrong (.+) and (.+)$")
	public void user_enters_wrong_and(String username, String password) throws Throwable {
		throw new PendingException();
	}

	@Then("^Verify User is successfully logged in$")
	public void verify_user_is_successfully_logged_in() throws Throwable {
		throw new PendingException();
	}

	@Then("^catch error message displaying error$")
	public void catch_error_message_displaying_error() throws Throwable {
		throw new PendingException();
	}

	@And("^Navigate to booking.com$")
	public void navigate_to_bookingcom() throws Throwable {
		throw new PendingException();
	}

	@And("^Click \"([^\"]*)\" button on the home page$")
	public void click_something_button_on_the_home_page(String strArg1) throws Throwable {
		throw new PendingException();
	}

	@And("^Maximize window$")
	public void maximazi_window() throws Throwable {
		throw new PendingException();
	}

	@And("^Navigate to mail.ru$")
	public void navigate_to_mailru() throws Throwable {
		throw new PendingException();
	}

}
