package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppBackGround {

	WebDriver driver = null;
	@Given("user is on app page")
	public void user_is_on_app_page(DataTable dataTable) {
	
		List<List<String>> urls = dataTable.asLists();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		for(int i=0; i < urls.size() ; i ++) {
			String url = urls.get(i).get(0);
			driver.get(url);
			
		}
	}
}
