package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class LandingPageStepDefinition {

	TextContextSetup textcontextsetup;
	public WebDriver driver;
	public String productName;
	public PageObjectManager pageobjectmanager;
	public LandingPage landingpage;
	
	public LandingPageStepDefinition(TextContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		
		
	}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		/*
		 * WebDriverManager.chromedriver().setup(); textcontextsetup.driver = new
		 * ChromeDriver(); textcontextsetup.driver.get(
		 * "https://rahulshettyacademy.com/seleniumPractise/#/");
		 */
		// code moved to BaseTest.  LandingPageStepDefinition constructor  TextContextSetup  BaseTest  inside base driver initiation and landing page are set
		
	}

	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		//LandingPage landingpage = new LandingPage(textcontextsetup.driver);
		pageobjectmanager = new PageObjectManager(textcontextsetup.driver);
		landingpage =	pageobjectmanager.getLandingPage();
		landingpage.searchItem(shortName);
		Thread.sleep(1000);
		textcontextsetup.productName = landingpage.getProductName().split("-")[0].trim();
		System.out.println(productName + " is extracted fromt the homepage");
	}
	
	@When("Added {string} items of the selected product to cart")

	public void Addeditemproducts(String quantity) {
		landingpage.incrementQuantity(Integer.parseInt(quantity));  // scenario string, page object int, step definition string to int
		landingpage.addtocart();
	}
}
