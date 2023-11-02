package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {
        FileInputStream fis = new FileInputStream (System.getProperty("user.dir")+"//src//test//resources//global.properties");

        Properties prop = new Properties();
        prop.load(fis);
        String url = prop.getProperty("QAURL");
        String browser_propertiesfile = prop.getProperty("browser");
        String browser_maven=System.getProperty("browser");

        String browser  =browser_maven != null ? browser_maven :browser_propertiesfile ;

        if (driver == null) {
            if(browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            } 
            if(browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            driver.get(url);
        }
        return driver;
    }

    

    
   
}
