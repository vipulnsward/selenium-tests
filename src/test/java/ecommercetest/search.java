package ecommercetest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class search {
	private WebDriver driver;
	@BeforeClass
	   public void webdriversetup() {
		  System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
		  driver=new ChromeDriver();
		  }
	
	@Test(priority=1)
	public void launchurl()
	{
		driver.get("http://automationpractice.com/index.php");
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}
	@Test(priority=2) 
	public void searchresults()
	{
		
		driver.findElement(By.id("search_query_top")).sendKeys("Summer Dresses");
		driver.findElement(By.id("search_query_top")).sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Select sortoption=new Select(driver.findElement(By.id("selectProductSort")));
		sortoption.selectByVisibleText("In stock");
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@title='List']")).click();
		}
	
	  @AfterClass
	  public void driverquit() {
		  driver.close();
		   driver.quit();
}
}

