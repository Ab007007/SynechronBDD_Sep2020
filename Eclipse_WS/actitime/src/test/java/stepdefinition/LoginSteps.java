package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	WebDriver driver = null;

	@Given("^user is on login Page$")
	public void user_is_on_login_page() {
		System.out.println(" User is on Login Page");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost/login.do");

	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		System.out.println(" Entering valid username and password ");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");

	}

	@And("click on login button")
	public void click_on_login_button() {
		System.out.println("Clicking on Login button ***************");
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("user is navigated to dashboard page")
	public void user_is_navigated_to_dashboard_page() {
		System.out.println(" User is on dashboard page *********");
		Assert.assertEquals("actiTIME - Enter Time-Track13213", driver.getTitle());

	}

}
