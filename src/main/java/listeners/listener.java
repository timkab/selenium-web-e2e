package listeners;

import java.io.File;
import java.io.FileNotFoundException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import resources.ExtentManager;
import resources.ExtentTestManager;
import resources.Base;

public class listener implements ITestListener {

	public Logger Log = LogManager.getLogger(listener.class.getName());

	// WebDriver driver = null;

	// base bs = new base();

	@Override
	public void onStart(ITestContext context) {
	
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	@Override
	public void onFinish(ITestContext context) {

		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// WebDriver driver = (WebDriver) result.getAttribute("driver");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");

		// WebDriver driver = (WebDriver)
		// result.getTestContext().getAttribute("driver");

		Object currentClass = result.getInstance();

		WebDriver driver = (WebDriver) ((Base) currentClass).driver;

		String errorDate = new SimpleDateFormat("(MM.dd.YYYY HH-mm-ss)").format(new Date());
		String fileLocation = System.getProperty("user.dir") + "//TestReport//screenshots//";
		String screenShotFile = System.getProperty("user.dir") + "//TestReport//screenshots//" + result.getName()
				+ "Error" + errorDate + ".png";

		try {

			File file = new File(fileLocation);

			if (!file.exists()) {
				if (file.mkdirs()) {
					Log.info("Directory: " + file.getAbsolutePath() + " is created!");
				} else {
					Log.error("Failed to create directory: " + file.getAbsolutePath());
				}
			}

			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(src, new File(screenShotFile));
			ExtentTestManager.getTest().addScreenCaptureFromPath(screenShotFile);

		} catch (FileNotFoundException e) {
			Log.error("File not found exception occurred while taking screenshot " + e.getMessage());
		} catch (Exception e) {
			Log.error("An exception occurred while taking screenshot " + e.getCause());
		}
		finally  {
			
		}

	}

	// screenshot on Error

	/*
	 * try {
	 * 
	 * bs.errorScreenShot(result.getName(), driver); // result.getName gets Method
	 * name
	 * 
	 * 
	 * } catch (IOException e) {
	 * 
	 * e.printStackTrace(); }
	 */

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

}
