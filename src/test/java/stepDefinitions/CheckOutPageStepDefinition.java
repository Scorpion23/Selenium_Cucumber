package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class CheckOutPageStepDefinition {

	TextContextSetup textcontextsetup;
	public WebDriver driver;
	public String productName;
	public PageObjectManager pageobjectmanager;
	public CheckoutPage checkoutpage;
	
	public CheckOutPageStepDefinition(TextContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		this.checkoutpage=	textcontextsetup.pageobjectmanager.getcheckoutPage();
	}
	
	
	
	@Then("^user proceeds to checkout ad validate the (.+) of items int he checkout page$")
	
	public void proceed_to_checkout(String name) throws InterruptedException {
		
		checkoutpage.CheckOutItems();
		Thread.sleep(1000);
		
	}

@Then("verify user has the ability to enter the promocode and place the order")

public void verifypromocodeability() {
	
	checkoutpage=	textcontextsetup.pageobjectmanager.getcheckoutPage();
	
	Assert.assertTrue(checkoutpage.verifyPromoBtn());
	Assert.assertTrue(checkoutpage.verifyPlanOrder());
}



}
