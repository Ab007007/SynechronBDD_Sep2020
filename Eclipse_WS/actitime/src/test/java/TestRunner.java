import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/",
		glue = {"stepdefinition"},  //  OR src/test/java/stepdefinition
		monochrome = true,
//		dryRun = true,
		plugin = {"pretty","junit:target/JunitReports/report.xml",
				"html:target/HTMLReports.html", "json:target/JsonReports/report.json"})
public class TestRunner {

}
