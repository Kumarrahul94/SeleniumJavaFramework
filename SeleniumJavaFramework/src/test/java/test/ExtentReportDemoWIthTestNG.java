package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWIthTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;
	
	@BeforeSuite

	public void setUp() {
		
		htmlReporter = new ExtentHtmlReporter("extentTestNGReport.html");

		//initialize ExtentReports and attach the HtmlReporter

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@BeforeTest
	
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		System.out.println("Opening Chrome Browser Successfully");
	}

	@Test
	public void test1() throws Exception {
		ExtentTest test = extent.createTest("MyFirstTest", "Sample Description");
        
		driver.get("https://google.com");
		test.pass("Navigated to goole.com");
		test.pass("Navigated to goole.com");

		driver.findElement(By.name("q")).sendKeys("Rahul Kumar");		
		test.pass("Entered text in Searchbox");
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test.pass("Pressed Enter Key");
		
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        test.addScreenCaptureFromPath("screenshot.png");
	}


	@AfterSuite
	public void tearDown() {
		
		//Closing the browser
		driver.close();
		driver.quit();
        // calling flush writes everything to the log file
        extent.flush();
	}



}
