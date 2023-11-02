package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Utils {
	public WebDriver driver;
	
	
	public Utils(WebDriver driver) {
		
		this.driver= driver;
	}
	
	public void switchWindows(String url) {
		
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> li = s1.iterator();

		while (li.hasNext()) {
			String childWindow = li.next();
			driver.switchTo().window(childWindow);

			if (driver.getCurrentUrl().equals("url")) {

				break;
			}
		}
		
	}

}
