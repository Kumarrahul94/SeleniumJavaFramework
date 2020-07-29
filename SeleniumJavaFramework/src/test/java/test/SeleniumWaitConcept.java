package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaitConcept {
	
	WebDriver driver = null;
	
	public void seleniumWaits() {
		
	
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
		
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Rahul Kumar");
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("abc")));
	

		driver.findElement(By.name("abcd"));
		
		//Closing the browser
		driver.close();
		driver.quit();
		
		
		
		
		
		
		
	}
	
	
	
	
	

}
