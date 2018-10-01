package ecommercetest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class productPageVerification
{
	WebDriver driver;
	@BeforeClass
	 public void setdriver()
	{
		  driver=Setup.webdriversetup();
		  Setup.launchurl(driver);
		  driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}
	@Parameters({"username","password"})
	@Test(priority=2)
	 public void logincust(String username,String password)
	 {
	
		 driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		 driver.findElement(By.id("email")).sendKeys(username);
		 driver.findElement(By.id("passwd")).sendKeys(password);
		 driver.findElement(By.id("SubmitLogin")).click();
		 
	 }
	 @Test(priority=3)
	public void verifyquicklink()
	{
		 Actions act=new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 act.moveToElement(driver.findElement(By.xpath("//a[@title='Women'][@class='sf-with-ul']"))).build().perform();
		  act.moveToElement(driver.findElement(By.xpath("//a[@title='Women'][@class='sf-with-ul']"))).click().perform();
		  js.executeScript("window.scrollBy(0,1000)");
		 act.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]"))).build().perform();
		  act.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]"))).build().perform();
		 act.moveToElement(driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[2]"))).click().perform();
		driver.findElement(By.xpath("//*[@id='category']/div[2]/div/div/a")).click();
	}
	 
	 public void socialshare(String share){
		 
		switch(share)
			{
			case "twitter":
				driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/p[7]/button[0]")).click();
				break;
			case "google":
				driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/p[7]/button[2]")).click();
				break;
			case "facebook":
				driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/p[7]/button[1]")).click();
				break;
			case "pininterest":
				driver.findElement(By.xpath("//*[@id='center_column']/div/div/div[3]/p[7]/button[3]")).click();
				break;
				}
	 }
	 
	@Parameters({"quantity","size","color"})
	@Test(priority=4)
	public void verifyproduct(int quantity, String size , String color) throws Exception
	{
			Actions act=new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement ele=driver.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[1]/div/a[1]"));
		act.moveToElement(ele).build().perform();
		act.moveToElement(ele).click().perform();
		while(quantity>1)
		 {
			 driver.findElement(By.xpath("//*[@id='quantity_wanted_p']/a[2]")).click();
			 quantity--;
		 }
		 Select sizetype=new Select(driver.findElement(By.id("group_1")));
		 switch(size)
		 {
			 case "M" :
				 sizetype.selectByVisibleText(size);
				 break;
			 case "L":
				 sizetype.selectByVisibleText(size);
				 break;
			 case "S":
				 break;
		 }
		 if(color.contains("blue"))
		 {
			 driver.findElement(By.id("color_14")).click();
		 }
		Thread.sleep(2000L);
		 driver.findElement(By.xpath(".//*[@id='add_to_cart']/button")).click();
		 Thread.sleep(2000L);
		 driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span")).click();
			driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]/span")).click();
			driver.findElement(By.xpath("//*[@id='center_column']/form/p/button/span")).click();
			driver.findElement(By.id("uniform-cgv")).click();
			driver.findElement(By.xpath("//*[@id='form']/p/button/span")).click();
			driver.findElement(By.xpath("//a[@title='Pay by bank wire']")).click();
			driver.findElement(By.xpath("//*[@id='cart_navigation']/button/span")).click();
	      
	}
@AfterClass
	  public void driverquit() {
		  driver.close();
		   driver.quit();
	}
}
	

