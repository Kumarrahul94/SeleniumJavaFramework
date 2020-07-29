package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportUsage {

	public static void main(String[] args) {

		WebDriver driver = null;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");

		//initialize ExtentReports and attach the HtmlReporter

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		//create test
		ExtentTest test1 = extent.createTest("Google Serch Test1", "Test to validate google search");

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		System.out.println("Opening Chrome Browser Successfully");
		
		test1.log(Status.INFO, "Starting Test Case");
		System.out.println("Test_001 : Verify Google Search");
		driver.get("https://google.com");
		test1.pass("Navigated to goole.com");
		
		driver.findElement(By.name("q")).sendKeys("Rahul Kumar");		
		test1.pass("Entered text in Searchbox");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		test1.pass("Pressed Enter Key");
		
		//Closing the browser
		driver.close();
		driver.quit();
		test1.pass("Closing the browser");
		System.out.println("Completed Test_001 : Verify Google Serach");
		test1.info("Test Completed Successfully");
		
		// calling flush writes everything to the log file
		extent.flush();

		}

	}
