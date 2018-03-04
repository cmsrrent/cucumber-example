package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginSteps {

	// Use cucumber to bing the feature file steps to Java code
	// Glue code - step definitions - step implementation
	
	
	@Given("the user is on the login page")
	public void user_on_login_page() {
		System.out.println("Step 1 - user is on login page");
	}
	
	@When("the user enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("Step 2 - user enters valie credentials");
	}
	
	@Then("the user should be able to view their account balance")
	public void user_should_See_account_balance() {
		System.out.println("Step 3 - user sees account balance");
	}
	
	
}
