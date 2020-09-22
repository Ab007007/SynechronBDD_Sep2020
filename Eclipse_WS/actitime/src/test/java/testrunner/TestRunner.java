package testrunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/deleteCustomer.feature",
		glue = {"stepdefinition"},  //  OR src/test/java/stepdefinition
		monochrome = true,
		dryRun = false,
		tags = "@deletecustomer",
		plugin = {"pretty","html:target/html-report/cucumber-html-reports.html", "junit:target/JunitReports/report.xml",
				 "json:target/JsonReports/report.json"})
public class TestRunner {

}
