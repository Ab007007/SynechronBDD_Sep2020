package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	
	@Before(order = 1)
	public void setup() {
		System.out.println("----------------Test case is started with the execution------------");
	}
	
	@Before(order = 2)
	public void setup2() {
		System.out.println("----------------Test case is started with the execution------------");
	}
	
	@After
	public void teardown() {
		System.out.println(" ***************Test case is ended *************************");
	}
	
//	@BeforeStep
	
//	@AfterStep

}
