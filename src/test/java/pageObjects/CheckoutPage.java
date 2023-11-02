package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.github.dockerjava.api.model.Driver;

public class CheckoutPage {

	By cartbag = By.cssSelector("img[alt='Cart']");
	By checkoututton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promobtn = By.cssSelector(".promoBtn");
	By placeorder = By.xpath("//button[contains(text(),'Place Order')]");
	


	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
	}

	public void CheckOutItems() {
		driver.findElement(cartbag).click();
		driver.findElement(checkoututton).click();

	}

	public boolean verifyPromoBtn() {

		return driver.findElement(promobtn).isDisplayed();

	}

	public boolean verifyPlanOrder() {

		return driver.findElement(placeorder).isDisplayed();

	}

}
