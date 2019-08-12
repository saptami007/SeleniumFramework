package launchChrome;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC001_Using_Chrome {
	
	
	@Test
	public void setup() throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/subhadeepmondal/Downloads/chromedriver");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		driver.close();
		
	}
	
}
