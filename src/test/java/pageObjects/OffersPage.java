package pageObjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;
	By TopDeals = By.linkText("Top Deals");
	By searchbox = By.xpath("//input[@type='search']");
	By productname = By.cssSelector("tr td:nth-child(1)");
	
	

	public OffersPage(WebDriver driver) {

		this.driver = driver;

	}

	public void clickondeals() {

		driver.findElement(TopDeals).click();

	}
	


	public void searchItem(String shortName) {

		driver.findElement(searchbox).sendKeys(shortName);

	}

	public String getProductName() {

		return driver.findElement(productname).getText();

	}

}
