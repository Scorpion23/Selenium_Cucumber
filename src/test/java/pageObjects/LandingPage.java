package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	
	
By search = By.xpath("//input[@type='search']");
By productName = By.cssSelector("h4.product-name");
By increment = By.cssSelector("a.increment");
By addtocart = By.cssSelector(".product-action button");

public WebDriver driver;

public LandingPage(WebDriver driver) {

	this.driver = driver;

}

public void searchItem(String shortName) {

	driver.findElement(search).sendKeys(shortName);

}

public String getProductName() {

	return driver.findElement(productName).getText();
}

public void incrementQuantity(int quantity) {

	int i = quantity - 1;
	while (i > 0) {

		driver.findElement(increment).click();
		i--;
	}
}

public void addtocart() {

	driver.findElement(addtocart).click();
}

}
