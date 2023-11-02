package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public LandingPage landingpage;
	public OffersPage offerspage;
	public CheckoutPage checkoutpage;
	
	WebDriver driver;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public LandingPage getLandingPage() {
		landingpage = new LandingPage(driver);

		return landingpage;

	}

	public OffersPage getOfferPage() {

		offerspage = new OffersPage(driver);

		return offerspage;

	}
	
	public CheckoutPage getcheckoutPage() {

		checkoutpage = new CheckoutPage(driver);

		return checkoutpage;

	}
	

}
