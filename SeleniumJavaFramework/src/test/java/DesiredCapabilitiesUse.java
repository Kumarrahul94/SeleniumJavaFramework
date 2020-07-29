import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesUse {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("ignoreProtectModeSettings", true);
		
		
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/drivers/chromedriver/"); 
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://google.com");
		
		driver.findElement(By.name("q")).sendKeys("Rahul Kumar");		
		driver.findElement(By.name("btnK")).sendKeys(Keys.ENTER);
		driver.close();
		driver.quit();
		
	}

}
