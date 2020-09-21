package stepdefinition;

import io.cucumber.java.en.Given;

public class TagsDemo {

	@Given("This is valid login scenario")
	public void this_is_valid_login_scenario() {
		System.out.println("Login Scenario");
	}

	@Given("This is logout scenario")
	public void this_is_logout_scenario() {
		System.out.println("Logout Scenario");
	}

	@Given("This is customer creation scenario")
	public void this_is_customer_creation_scenario() {
		System.out.println("Create Customer Scenario");
	}

	@Given("This is project creation scenario")
	public void this_is_project_creation_scenario() {
		System.out.println("Create Project Scenario");
	}

	@Given("This is task creation scenario")
	public void this_is_task_creation_scenario() {
		System.out.println("Create Tasks Scenario");
	}

	@Given("This is user creation scenario")
	public void this_is_user_creation_scenario() {
		System.out.println("Create Multiple Users Scenario");
	}
}
