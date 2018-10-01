package ecommercetest;

import java.util.List;
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

public class Wishlist {
	WebDriver driver;
	
	@Test(priority=1)
	
	public void logincustomer()
	{
		 driver=Setup.webdriversetup();
		 Setup.launchurl(driver);
		 driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
		 driver.findElement(By.id("email")).sendKeys("supri2007@gmail.com");
		 driver.findElement(By.id("passwd")).sendKeys("shilpa009");
		 driver.findElement(By.id("SubmitLogin")).click();
	}

	@Test(priority=2)
	public void addwishlist() throws Exception
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@title='Women'][@class='sf-with-ul']"))).build().perform();
		List<WebElement>categorieslist=driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li/a"));
		for(int i=0;i<categorieslist.size();i++)
			{
				String category=categorieslist.get(i).getAttribute("title").toString();
				if(category.contains("Dresses"))
				{
						List<WebElement> dresslist=driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li/a"));
						for(int j=0;j<dresslist.size();j++) 
						{
							String dresstype=dresslist.get(j).getAttribute("title").toString();
							if(dresstype.contains("Summer Dresses"))
							{
								driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a")).click();;
								js.executeScript("window.scrollBy(0,300)");
								driver.findElement(By.xpath("//a[@title='List']")).click();
								driver.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div/div[3]/div/div[3]/div[1]/a")).click();
								driver.findElement(By.xpath("//a[@title='Close']")).click();
								
								
							}
						}
				}
			}
		
		

      
}
	@AfterClass
	 public void driverquit() {
		  driver.close();
		   driver.quit();
}
}
