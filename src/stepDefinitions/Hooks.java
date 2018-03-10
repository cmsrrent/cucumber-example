package stepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setup() {
		//initiate WebDriver
		driver = utilities.DriverFactory.open("Chrome");
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
}
