package ecommercetest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Setup {
	public static WebDriver driver;
	
	 public static WebDriver webdriversetup() {
		  System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
		  return (driver=new ChromeDriver());
		  }
	
	
	public static void launchurl(WebDriver driver)
	{
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	}
	 
	 public static WebElement findelementbyxpath(String xpathlocation)
	 {
		 WebElement element =driver.findElement(By.xpath(xpathlocation));
		 return element;
	 }
	  public static void driverquit(WebDriver driver) {
		  driver.close();
		   driver.quit();
	  }
}
