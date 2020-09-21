package stepdefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitDemo {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///D:/AravindData/Synechron_BDD/12_09_2020/Eclipse_WS/html/tiimeout.html");
		driver.findElement(By.tagName("button")).click();
		//step-1
		FluentWait<WebElement> wait = new FluentWait<WebElement>(
				driver.findElement(By.id("demo")))
				.pollingEvery(Duration.ofMillis(500))
				.withTimeout(Duration.ofSeconds(50))
				.ignoring(NoSuchElementException.class)
				.ignoring(Exception.class);
		//step-2
		Function<WebElement, Boolean> fun = new Function<WebElement, Boolean>() 
		{
			@Override
			public Boolean apply(WebElement ele) {
				Boolean flag = false;
				if(ele.isDisplayed())
				{
					System.out.println("Element is displayed " + ele.getText());
					flag = true;
				}
				else
				{
					System.out.println("Waiting!!!!!");
					flag = false;
				}
				return flag;
			}
		};
		//90-95 >> WebDriverWait 5>>
		//step-3
		wait.until(fun);
		System.out.println(driver.findElement(By.id("demo2")).getText());
		
	}
}
