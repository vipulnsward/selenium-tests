package ecommercetest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class navigation {
	public WebDriver driver;
	
	
	public WebDriver getdriver()
	{
		if(driver==null)
		{
			driver=Setup.webdriversetup();
			  Setup.launchurl(driver);
			  driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
			  driver.manage().window().maximize();
			return driver;
		}
		else
		{
			return driver;
		}
			
	}
	@Parameters({"category","subcategory","item"})
	@Test(priority=2)
	public void navigatetoproduct(String category,String subcategory,String item) throws Exception
	{	
		
			Actions act=new Actions(driver);
			if(category.contains("Women"))
			{
			
				Thread.sleep(2000L);
				WebElement women=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/a"));
				act.moveToElement(women).build().perform();
				if(subcategory.contains("Tops"))
				{
					WebElement top=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/a"));
					Thread.sleep(2000L);
					act.moveToElement(top).build().perform();
					if(item.contains("T-shirts"))
					{
						WebElement tshirt=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[1]/a"));
						Thread.sleep(2000L);
						act.moveToElement(tshirt).build().perform();
						act.moveToElement(tshirt).click().perform();
					}
					else
					{
						WebElement blouse=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul/li[2]/a"));
						act.moveToElement(blouse).build().perform();
						act.moveToElement(blouse).click().perform();
					}
				}
					else if(subcategory.contains("Dresses"))
					{
						WebElement dress=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/a"));
						Thread.sleep(2000L);
						act.moveToElement(dress).build().perform();
						if(item.contains("Casual Dresses"))
						{
							WebElement casual=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[1]/a"));
							act.moveToElement(casual).build().perform();
							act.moveToElement(casual).click().perform();
						}
						else if(item.contains("Evening Dresses"))
						{
							WebElement evening=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a"));
							act.moveToElement(evening).build().perform();
							act.moveToElement(evening).click().perform();
						}
						else
						{
							WebElement summer=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[3]/a"));
							act.moveToElement(summer).build().perform();
							act.moveToElement(summer).click().perform();
						}
					}
				}
			else if(category.contains("Dresses"))
			{
				WebElement women=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
				act.moveToElement(women).build().perform();
				if(subcategory.contains("Casual Dresses"))
				{
					WebElement casualdress=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[1]/a"));
					act.moveToElement(casualdress).build().perform();
					act.moveToElement(casualdress).click().perform();
				}
				else if(subcategory.contains("Evening Dresses"))
				{
					WebElement eveningdress=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[2]/a"));
					act.moveToElement(eveningdress).build().perform();
					act.moveToElement(eveningdress).click().perform();
				}
				else 
				{
					WebElement summerdress=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/ul/li[3]/a"));
					act.moveToElement(summerdress).build().perform();
					act.moveToElement(summerdress).click().perform();
				}
			}
			else
			{
				WebElement Tshirtmain=driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
				act.moveToElement(Tshirtmain).build().perform();
				act.moveToElement(Tshirtmain).click().perform();
			}
			  //driver.close();
			   //driver.quit();
	}
	
	  
}
