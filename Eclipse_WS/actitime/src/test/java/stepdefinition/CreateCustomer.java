package stepdefinition;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCustomer {

	WebDriver driver = null;

	@Before("@actitime or @end2end and not (@google or @formy)")
	public void login_and_goto_task_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals("actiTIME - Enter Time-Track", driver.getTitle());
		driver.findElement(By.xpath("//div[text()='TASKS']/parent::a")).click();
		System.out.println("validate user is on Task page");
		Assert.assertEquals("actiTIME - Task List", driver.getTitle());
	}

	@After("@actitime or @end2end")
	public void log_out() {
		driver.findElement(By.id("logoutLink")).click();
	}

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
		String text_on_customer_creation_page = driver.findElement(By.id("customerLightBox_titlePlaceholder"))
				.getText();
		Assert.assertEquals("Create New Customer", text_on_customer_creation_page);

	}

	@When("user enter {} and {} and click on create customer")
	public void user_enter_and(String customername, String customerdesc) {
		System.out.println("User entering customer details");
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customername);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customerdesc);
		driver.findElement(By.id("customerLightBox_commitBtn")).click();

	}

	@Then("customer {} should be created successfully")
	public void customer_should_be_created_successfully(String customer) {
		// div[@class='title ellipsis' and text()='customer']
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='title ellipsis' and text()='" + customer + "']"))
				.isDisplayed());

	}

	@Then("success message should be displayed")
	public void success_message_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement toastMsg = wait
				.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("Success Message " + toastMsg.getText());

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("toast message is disappeared");
	}

	@When("user enter all detals and click on create customer and success msg should be displayed")
	public void user_enter_all_detals_and_click_on_create_customer_success_msg_should_be_displayed(
			DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		for (int j = 0; j < data.size(); j++) {
			List<String> list = data.get(j);
			String customername = data.get(j).get(0);
			String customerdesc = data.get(j).get(1);
			System.out.println("Inner List " + list.size());
			driver.findElement(By.xpath("//div[div[text()='Add New']]")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customername);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customerdesc);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement toastMsg = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("Success Message " + toastMsg.getText());

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("toast message is disappeared");

		}

	}

	@When("user enter all detals from map and click on create customer and success msg should be displayed")
	public void user_enter_all_detals_from_map_and_click_on_create_customer_success_msg_should_be_displayed(
			DataTable dataTable) {

		List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

		for (int i = 0; i < data.size(); i++) {

			String customername = data.get(i).get("customerName");
			String customerdesc = data.get(i).get("customerDesc");
			driver.findElement(By.xpath("//div[div[text()='Add New']]")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customername);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customerdesc);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement toastMsg = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("Success Message " + toastMsg.getText());

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("toast message is disappeared");

		}

	}

	@When("user enter all detals from single map and click on create customer and success msg should be displayed")
	public void user_enter_all_detals_from_single_map_and_click_on_create_customer_success_msg_should_be_displayed(
			DataTable dataTable) {

		Map<String, String> data = dataTable.asMap(String.class, String.class);

		String customername_with_delimiter = data.get("customerName");
		String customerdesc_with_delimiter = data.get("customerDesc");
		String[] customer_name_array = customername_with_delimiter.split(",");
		String[] customer_desc_array = customerdesc_with_delimiter.split(",");
		for (int i = 0; i < customer_name_array.length; i++) {
			driver.findElement(By.xpath("//div[div[text()='Add New']]")).click();
			driver.findElement(By.xpath("//div[contains(text(),'New Customer')]")).click();
			driver.findElement(By.id("customerLightBox_nameField")).sendKeys(customer_name_array[i]);
			driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(customer_desc_array[i]);
			driver.findElement(By.id("customerLightBox_commitBtn")).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement toastMsg = wait
					.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("Success Message " + toastMsg.getText());

			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
			System.out.println("toast message is disappeared");

		}

	}

	@Then("user logout of application")
	public void user_logout_of_application() {
		driver.findElement(By.id("logoutLink")).click();
		driver.close();
		driver = null;
	}

	// ---------------- delete customer step definitions ---------------------------
	@When("user search for a customer {}")
	public void user_search_for_a_customer(String string) {
		driver.findElement(
				By.xpath("//div[@class='customersProjectsPanel']//input[@placeholder='Start typing name ...']"))
				.sendKeys(string);
	}

	@When("user moves the cursor to setting icon displayed next to {} and click on it")
	public void user_moves_the_cursor_to_setting_icon_displayed_next_to_customer_and_click_on_it(String customerName) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(
				"//div[@class='itemsContainer']//div[@class='title' and contains(text(),'" + customerName + "')]")))
				.perform();
		act.click(driver.findElement(By.xpath("//div[@class='itemsContainer']//div[@class='title' and contains(text(),'"
				+ customerName + "')]/following-sibling::div"))).perform();
	}

	@Then("customer action page should be displayed")
	public void customer_action_page_should_be_displayed() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(
				driver.findElement(By.xpath("//div[input[@placeholder='Enter Customer Name']]/preceding-sibling::div"))
						.isDisplayed());
	}

	@Then("click on Action and delete permanently")
	public void click_on_action_and_delete_permanently() {
		driver.findElement(By.xpath("//div[@class='customerNamePlaceHolder']/following-sibling::div")).click();
		driver.findElement(By.xpath(
				"//div[div[@class='customerNamePlaceHolder']]/following-sibling::div[@class='dropdownContainer actionsMenu']//div[text()='Delete']"))
				.click();
		driver.findElement(By.id("customerPanel_deleteConfirm_submitTitle")).click();

	}

	@Then("customer deletion success message should be displayed")
	public void customer_deletion_success_message_should_be_displayed() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
		System.out.println("Success Message " + ele.getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='toast']"))));
	}

	
}
