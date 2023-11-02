package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TextContextSetup {
	
	public WebDriver driver;
	public	String productName;
	public PageObjectManager pageobjectmanager;
	public Utils utils;
	public Hooks hooks;
	
	public BaseTest basetest;
	
	public TextContextSetup() throws IOException {
		
		basetest = new BaseTest();
		driver = basetest.WebDriverManager();
		pageobjectmanager = new PageObjectManager(basetest.WebDriverManager());
		utils = new Utils(basetest.WebDriverManager());
		
		
	}
}
