package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class LoginSteps {
						
	WebDriver driver = Hooks.driver;
	
	@Given("the user is on the login page")
	public void user_on_login_page() {
		System.out.println("Step 1 - user is on login page");	
		//Navigate to login page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	}
	
	@When("the user enters valid credentials")
	public void user_enters_valid_credentials() {
		System.out.println("Step 2 - user enters valid credentials");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("the user should be able to view their account balance")
	public void user_should_See_account_balance() {
		System.out.println("Step 3 - user sees account balance");
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String welcomeMessage = "Logged in successfully";
		Assert.assertTrue(bodyText.contains(welcomeMessage));			
	}
		
	@When("the user enters bad credentials")
	public void user_enteres_bad_credentials() {
		System.out.println("Step 2 - user enters bad credentials");
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("badlogin@testemail.com");
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("badpassword");
		driver.findElement(By.id("MainContent_btnLogin")).click();
	}
	
	@Then("the user should not be able to login")
	public void user_should_not_login() {
		System.out.println("Step 3 - user is not logged in");
		String bodyText = driver.findElement(By.xpath("html/body")).getText();
		String welcomeMessage = "Logged in successfully";
		Assert.assertFalse(bodyText.contains(welcomeMessage));	
	}
	
	@And("the user should get an invalid login message")
	public void user_gets_invalid_message() {
		String errorText = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		String invalidMessage = "Invalid user name, try again!";
		System.out.println("INVALID MESSAGE: " + errorText);
		Assert.assertTrue(errorText.equals(invalidMessage));
	}
	
}
