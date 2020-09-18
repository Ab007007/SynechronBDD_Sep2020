package stepdefinition;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FormyApp {

	WebDriver driver = null;

	@Given("User is on Formy Application")
	public void user_is_on_formy_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/");
	}

	@When("user is on Form page")
	public void user_is_on_form_page() {
		driver.findElement(By.xpath("//a[text()='Form']")).click();

	}

	@Then("user enter all the details")
	public void user_enter_all_the_details(DataTable dataTable) {

		List<String> user_details = dataTable.asList();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("first-name"))));
		
		driver.findElement(By.id("first-name")).sendKeys(user_details.get(0));
		driver.findElement(By.id("last-name")).sendKeys(user_details.get(1));
		driver.findElement(By.id("job-title")).sendKeys(user_details.get(2));
		switch (user_details.get(3)) {
		case "High School":
			driver.findElement(By.id("radio-button-1")).click();
			break;
		case "College":
			driver.findElement(By.id("radio-button-2")).click();
			break;
		case "Grad School":
			driver.findElement(By.id("radio-button-3")).click();
			break;
		default:
			System.out.println("Given Grade is not valid..  please check the input");
			break;
		}

		switch (user_details.get(4)) {
		case "Male":
			driver.findElement(By.id("checkbox-1")).click();
			break;
		case "Female":
			driver.findElement(By.id("checkbox-3")).click();

			break;
		case "Prefer not to say":
			driver.findElement(By.id("checkbox-3")).click();

			break;

		default:
			System.out.println("Given Type is not valid..  please check the input");
			break;
		}

		Select sel = new Select(driver.findElement(By.id("select-menu")));
		sel.selectByVisibleText(user_details.get(5));

		driver.findElement(By.id("datepicker")).sendKeys(user_details.get(6));

	}

	@Then("click on submit button")
	public void click_on_submit_button() {
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
	}

	@Then("registration success message should be displayed")
	public void registration_success_message_should_be_displayed() {
		String success_message = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println(success_message);
	}

}
