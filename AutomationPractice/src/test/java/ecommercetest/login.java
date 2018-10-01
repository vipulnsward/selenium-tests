package ecommercetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login {
	 public WebDriver driver;
	
	@BeforeClass
	   public void webdriversetup() {
		  System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
		  driver=new ChromeDriver();
		  }
	
	@Test(priority=1)
	public void launchurl()
	{
		driver.get("http://automationpractice.com/index.php");
	    driver.manage().window().maximize();
	}
	@Parameters({"username", "password"})
	@Test(priority=2 )
	public  void logincustomer(String username,String password)
	{
		 
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		 driver.findElement(By.id("email")).sendKeys(username);
		 driver.findElement(By.id("passwd")).sendKeys(password);
		 driver.findElement(By.id("SubmitLogin")).click();
	}
@AfterClass
	  public void driverquit() {
		  driver.close();
		   driver.quit();
}
}
