package stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomer {

	WebDriver driver = null;

	@Given("user is loggedin to the actitime application using {string} and {string}")
	public void user_is_loggedin_to_the_actitime_application(String un, String pwd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());
	}

	@When("user clicks on task tab")
	public void user_clicks_on_task_tab() {
		System.out.println("Click on Tasks Tab");
		driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click();

	}

	@Then("user is navitaged to tasks page")
	public void user_is_navitaged_to_tasks_page() {
		System.out.println("validate user is on Task page");

		Assert.assertEquals("actiTIME - Task List", driver.getTitle());
	}

	@When("user click on Add new customer")
	public void user_click_on_add_new_customer() {
		System.out.println("clicking on Add New and then New Customer ");
		driver.findElement(By.xpath("//div[div[text()='Add New']]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
		
	}

	@Then("customer creation page should be displayed")
	public void customer_creation_page_should_be_displayed() {
		System.out.println("Validating customer creation page is displayed");
		String text_on_customer_creation_page = driver.findElement(By.id("customerLightBox_titlePlaceholder")).getText();
		Assert.assertEquals("Create New Customer", text_on_customer_creation_page);
	
	}

	@When("user enter {string} and {string} and click on create customer")
	public void user_enter_and(String customername, String customerdesc) {
		System.out.println("User entering customer details");
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customername);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customerdesc);
		driver.findElement(By.id("customerLightBox_commitBtn")).click();
		
	}

	@Then("customer {string} should be created successfully")
	public void customer_should_be_created_successfully(String customer) {
		//div[@class='title ellipsis' and text()='customer']
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title ellipsis' and text()='" + customer + "']")).isDisplayed());
	
	}

	@Then("success message should be displayed")
	public void success_message_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement toastMsg = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("Success Message " + toastMsg.getText());
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("toast message is disappeared");
	}

	@When("user enter all detals and click on create customer success msg should be displayed")
	public void user_enter_all_detals_and_click_on_create_customer_success_msg_should_be_displayed(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user logout of application")
	public void user_logout_of_application() {
		driver.findElement(By.id("logoutLink")).click();
	}
}
