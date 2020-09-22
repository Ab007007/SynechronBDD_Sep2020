package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

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
	@Given("user is on Google page")
	public void user_is_on_google_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
	}

	@When("user enters {}") // {} represents any data type
	public void user_enters(String string) {
		driver.findElement(By.name("q")).sendKeys(string);
	}

	@When("he click on search button")
	public void he_click_on_search_button() {
		driver.findElement(By.name("btnK")).click();
	}

	@Then("user prints all the search results from first page")
	public void user_prints_all_the_search_results_from_first_page() {

		List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));
		List<WebElement> ad_link = driver.findElements(By.xpath("//a[@target='_blank']"));

		System.out.println("Total Advertise Links on the Page is - " + ad_link.size());
		System.out.println("Total Search Results on the Page is - " + searchResults.size());

		for (WebElement result : searchResults) {
			System.out.println(result.getText());
		}

		driver.close();
		driver = null;

	}

	@Then("application displayes auto suggestion")
	public void application_displayes_auto_suggestion() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//li[@class='sbct']//div[contains(@class,'sbl1')]"));
		System.out.println("total suggestions displayed is " + suggestions.size());
		Assert.assertTrue(suggestions.size() > 1);
		driver.close();
		driver = null;
	}

	@Then("user prints all the suggestions displayed")
	public void user_prints_all_the_suggestions_displayed() {
		List<WebElement> suggestions = driver
				.findElements(By.xpath("//li[@class='sbct']//div[contains(@class,'sbl1')]"));
		for (WebElement suggestion : suggestions) {
			System.out.println(suggestion.getText());
		}
	}

	@Then("search result will have {int} result(s)")
	public void search_result_will_have_results(Integer int1) {
		List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));
		System.out.println("Search result has " + searchResults.size() + " search results");
	}
	@Then("search result(s) will have hyperlinks/serachdetails")
	public void search_result_will_have_serachdetails() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));
		System.out.println("Search result has " + searchResults.size() + " search results");
		for (WebElement result : searchResults) 
		{
			System.out.println(result.getText());
		}
	}
	
	@Then("search results will have \\(hyperlinks)")
	public void search_results_will_have() {
		List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));
		System.out.println("Search result has " + searchResults.size() + " search results");
	}

}
