package ecommercetest;

import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

	public class NewUser {
	 WebDriver driver;
	@Parameters({"email","password","firstname","lastname"})
	@Test
	public void signup(String email,String password,String firstname,String lastname) {
	   
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
	   driver.findElement(By.id("email_create")).sendKeys(email);
	   driver.findElement(By.id("SubmitCreate")).click();
	   driver.findElement(By.id("id_gender2")).click();	
	   driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
	   driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
	   driver.findElement(By.id("passwd")).sendKeys(password);
	   Select days=new Select(driver.findElement(By.id("days")));
	   days.selectByIndex(31);
	   Select month=new Select(driver.findElement(By.id("months")));
	   month.selectByIndex(5);
	   Select year=new Select(driver.findElement(By.id("years")));
	   year.selectByValue("1988");
	   driver.findElement(By.id("newsletter")).click();
	   driver.findElement(By.id("optin")).click();
	   driver.findElement(By.id("address1")).sendKeys("kalina");
	   driver.findElement(By.id("city")).sendKeys("random");
	   Select state=new Select(driver.findElement(By.id("id_state")));
	   state.selectByVisibleText("Washington");
	   driver.findElement(By.id("postcode")).sendKeys("00000");
	   Select country=new Select(driver.findElement(By.id("id_country")));
	   country.selectByVisibleText("United States");
	   driver.findElement(By.id("phone_mobile")).sendKeys("+917708782609");
	   driver.findElement(By.id("alias")).sendKeys("home");
	   driver.findElement(By.id("submitAccount")).click();
	   
 }
  @BeforeClass
   public void webdriversetup() {
	  System.setProperty("webdriver.chrome.driver", "/Users/supriya/Downloads/chromedriver_mac64/chromedriver" );
	  driver=new ChromeDriver();
	  }
  
  
  public void exceldata() throws Exception
  {
	  try {
		FileInputStream fi=new FileInputStream("");
		HSSFWorkbook excelfile=new HSSFWorkbook(fi);
		HSSFSheet excelsheet=excelfile.getSheet("Sheet1");
		int lastrow=excelsheet.getLastRowNum();
		HSSFRow row;
		HSSFCell cell;
		for (int i=1;i<=lastrow;i++)
		{
			cell=excelsheet.getRow(i).getCell(0);
			System.out.println(cell.toString());
		}
		excelfile.close();
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
  }
  @AfterClass
  public void driverquit() {
	  driver.close();
	   driver.quit();
  }

}
