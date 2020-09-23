package page;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage 
{
	WebDriver driver =null;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	
	}
	
	@FindBy(id = "username")
	WebElement usernameTextbox;
	
	@FindBy(name = "pwd")
	WebElement passwordTextbox;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	public void validateLoginPageisLaunch() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(usernameTextbox));
		
	}
	
	public void enterUserName(String un) {
		System.out.println("--------------Entering UserName---------");
		usernameTextbox.sendKeys(un);
	}
	
	public void enterPassword(String pwd) {
		System.out.println("--------------Entering Password---------");
		passwordTextbox.sendKeys(pwd);
		
	}
	
	public void clickonLoginButton() {
		System.out.println("--------------Clicking on login Button---------");
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void login(String un,String pwd) {
		enterUserName(un);
		enterPassword(pwd);
		clickonLoginButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void validateLoginTitle(String actualTitle) {
		Assert.assertEquals("actiTIME - Login", actualTitle);
	}
	
	
	
	
	
	
	
	
}
