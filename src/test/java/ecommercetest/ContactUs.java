package ecommercetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ContactUs {
	@Test
	public void contact()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://automationpractice.com/index.php");
		  driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.findElement(By.xpath("//a[@title='Contact Us']")).click();
		  Select heading=new Select(driver.findElement(By.id("id_contact")));
		  heading.selectByIndex(2);
		  driver.findElement(By.id("message")).sendKeys("my product was not delivered");
		  driver.findElement(By.id("submitMessage")).click();
		  
	}

}
