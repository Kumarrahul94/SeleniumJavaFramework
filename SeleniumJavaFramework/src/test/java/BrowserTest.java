import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BrowserTest {
	
		private static WebDriver driver = null;
		
		@BeforeTest
		public static void setUpTest() {
	
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath: " + projectPath);
		 System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/chromedriver.exe"); 
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		 System.out.println("Opening Chrome Browser Successfully");
		}
		
		@Test
		
		public static void testExecute() {
		
		System.out.println("Test_001 : Verify Google Search");
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Rahul Kumar");		
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		}
		
		@AfterTest
		
		public static void endUpTest() {
		driver.close();
		driver.quit();
		System.out.println("Completed Test_001 : Verify Google Serach");
	}

}
