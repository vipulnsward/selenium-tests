package ecommercetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ContactUs {
	public static WebDriver driver;
	@BeforeClass
	 public void setdriver()
	{
		  driver=Setup.webdriversetup();
		  Setup.launchurl(driver);
		  driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}
	@Parameters({"username", "password"})
	@Test(priority=1 )
	public  void logincustomer(String username,String password)
	{
		 
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		 driver.findElement(By.id("email")).sendKeys(username);
		 driver.findElement(By.id("passwd")).sendKeys(password);
		 driver.findElement(By.id("SubmitLogin")).click();
	}
	@Test(priority=2)
	public static void contact()
	{
		  driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		  Select heading=new Select(driver.findElement(By.id("id_contact")));
		  heading.selectByIndex(2);
		  driver.findElement(By.id("message")).sendKeys("my product was not delivered");
		  driver.findElement(By.id("submitMessage")).click();
		  
	}
	@AfterClass
	  public void driverquit() {
		  driver.close();
		   driver.quit();
	}
}
