package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TextContextSetup;

public class Hooks {
	
	public TextContextSetup textcontextsetup;
	
	
	public Hooks(TextContextSetup textcontextsetup) {
		
		this.textcontextsetup = textcontextsetup;
		
	}
	
	@After
	public void afterscenario() throws IOException {
		textcontextsetup.basetest.WebDriverManager().quit();
	
	}

	@AfterStep
	
	public void AddScreenshot(Scenario scenario) throws IOException {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("pathToYourReport.html");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("TestName", "Description");

		WebDriver driver =textcontextsetup.basetest.WebDriverManager();
		
		if(scenario.isFailed()) {
		    File sourcepath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    byte[] filecontent = FileUtils.readFileToByteArray(sourcepath);
		    scenario.attach(filecontent, "image/png", "image");
		    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("relativePathToScreenshot").build());
			
		}
	}
}


























