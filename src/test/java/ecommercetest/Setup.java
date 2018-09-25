package ecommercetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Setup {
	WebDriver driver;
	@BeforeSuite
	 public void webdriversetup() {
		  System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
		  driver=new ChromeDriver();
		  }
	
	@Test()
	public void launchurl()
	{
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	}
	 
	 @AfterSuite
	  public void driverquit() {
		  driver.close();
		   driver.quit();
	  }
}
