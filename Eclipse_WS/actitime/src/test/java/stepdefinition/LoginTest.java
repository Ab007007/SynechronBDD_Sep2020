package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.DashboardPage;
import page.LoginPage;

public class LoginTest {

	WebDriver driver = null;
	LoginPage loginPage = null;
	DashboardPage dashboardPage = null;

	@Given("pomuser is on login Page")
	public void pomuser_is_on_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// initialize all page classes
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);

		driver.get("http://localhost/login.do");
	}

	@When("pomuser enter valid username and password")
	public void pomuser_enter_valid_username_and_password() {
		loginPage.enterUserName("admin");
		loginPage.enterPassword("manager");
	}

	@When("pomuser click on login button")
	public void pomuser_click_on_login_button() {
		loginPage.clickonLoginButton();
		dashboardPage.validateDashboardTitle(driver.getTitle());
	}

	@Then("pomuser user is navigated to dashboard page and logout")
	public void pomuser_user_is_navigated_to_dashboard_page_and_logout() {
		dashboardPage.logout();
		driver.close();
		driver = null;
	}

}
