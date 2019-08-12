package launchChrome;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC002_Advanced_Selenium {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/subhadeepmondal/Downloads/chromedriver");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
	}
	@Test
	public void loginFaceBook() throws Exception {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter Your UserName");
		String username=input.nextLine();
		System.out.println("Enter Your Password");
		String password=input.nextLine();
		Thread.sleep(6000);
		String titleFaceBook=driver.getTitle();
		System.out.println("The Title is: "+titleFaceBook);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id=\"pass\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@aria-label=\"Log In\"]")).click();
		String afterLoginTitle=driver.getTitle();
		Assert.assertEquals(afterLoginTitle, "Facebook");
	}
	
	@AfterMethod
	public void closeUp() throws Exception {
		Thread.sleep(5000);
		driver.close();
	}

}
