package cucumberOptions;

import cucumber.api.CucumberOptions;

import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinition", // def package name
		 tags="@tag",
		strict = false, // will check if any steps are not defined
		dryRun = false, // to check is mapping is right between feature and step def files
		plugin = {"json:target/cucumber-report.json",    //report plug-ins
			                "pretty",
			                "html:target/cucumber-reports/cucumber-pretty",
			                "json:target/cucumber-reports/CucumberTestReport.json",
			                "rerun:target/cucumber-reports/failed_rerun.txt"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
