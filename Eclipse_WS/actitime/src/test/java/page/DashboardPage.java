package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "logoutLink")
	WebElement logoutLink;

	public void logout() {
		System.out.println("-----------Logging out of the application-----------");
		logoutLink.click();
		
	}	
	public void validateDashboardTitle(String actualTitle) {
		Assert.assertEquals("actiTIME - Enter Time-Track", actualTitle);
	}
	
}
