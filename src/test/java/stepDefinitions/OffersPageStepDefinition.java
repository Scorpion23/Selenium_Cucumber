package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TextContextSetup;

public class OffersPageStepDefinition {
	public 	TextContextSetup textcontextsetup;
	public String OfferPageProductName;
	public PageObjectManager pageobjectmanager;
	public OffersPage offerspage;
	String url ="https://rahulshettyacademy.com/seleniumPractise/#/offers";
	
	public OffersPageStepDefinition(TextContextSetup textcontextsetup) {

		this.textcontextsetup = textcontextsetup;
		
	}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exists(String shortName)
			throws InterruptedException {

		//OffersPage offerspage = new OffersPage(textcontextsetup.driver);
		pageobjectmanager = new PageObjectManager(textcontextsetup.driver);
		offerspage =pageobjectmanager.getOfferPage();
		
		offerspage.clickondeals();
		textcontextsetup.utils.switchWindows(url);
		offerspage.searchItem(shortName);
		Thread.sleep(1000);
		 OfferPageProductName = offerspage.getProductName().split("-")[0].trim();

	}

	@Then("validate productname in home page mathches product name in offer page")
	public void verifyproductsmatches() {

		Assert.assertEquals(textcontextsetup.productName, OfferPageProductName);

	}

}
