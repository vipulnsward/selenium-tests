package ecommercetest;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addToCart {

	WebDriver driver;
	
	@Test(priority=1)
	public void launchurl()
	{
		driver=Setup.webdriversetup();
		Setup.launchurl(driver);
	}
	
	@Test(priority=2)
	public void logincustomer()
	{
		 driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		 driver.findElement(By.id("email")).sendKeys("supri2007@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("shilpa009");
		 driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@Test(priority=3)
	public void addtocart() throws Exception
	{
		Actions act=new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		WebElement women=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
		act.moveToElement(women).build().perform();
		act.moveToElement(women).click().perform();
		js.executeScript("window.scrollBy(0,1000)");
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Faded Short Sleeve T-shirts']"))).build().perform();
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Add to cart']"))).click().perform();
	
}
	@AfterClass
	 public void driverquit() {
		  driver.close();
		   driver.quit();
}
	
}
