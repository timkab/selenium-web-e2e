package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

public class ReRunner {

	
	
		// Rerunning from failed_rerun.txt
	@CucumberOptions(features = "@target/cucumber-reports/failed_rerun.txt", glue = "stepDefinition", // def package name


			plugin = {"json:target/cucumber-report.json",    //report plug-ins
				                "pretty",
				                "html:target/cucumber-reports/cucumber-pretty",
				                "json:target/cucumber-reports/CucumberTestReport.json",
				                }
	)

	public class TestRunner extends AbstractTestNGCucumberTests {

	}

}
