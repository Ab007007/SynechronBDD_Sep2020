package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {


@Given("^user is on login Page$")
public void user_is_on_login_page() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("User is on Login Page ****************");
}

@When("user enters valid username and password")
public void user_enters_valid_username_and_password() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("User Entering valid creadentials *************");
}

@And("click on login button")
public void click_on_login_button() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println("Clicking on Login button ***************");
}

@Then("user is navigated to dashboard page")
public void user_is_navigated_to_dashboard_page() {
    // Write code here that turns the phrase above into concrete actions
	System.out.println(" User is on dashboard page *********");

}

}
