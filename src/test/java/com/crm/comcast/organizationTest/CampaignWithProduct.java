package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CampaignWithProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriverUtility wlib = new WebDriverUtility();
		FileUTility flib = new FileUTility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		
		//Create an object of property file
		
		 String URL = flib.getPropertyKeyValue("url");
		 String USERNAME = flib.getPropertyKeyValue("username");
		 String PASSWORD = flib.getPropertyKeyValue("password");
		 String BROWSER = flib.getPropertyKeyValue("browser");
		 
		 int randomnum = jlib.getRandomNumber();
		 
	   // Random r = new Random();
		//int randomnum = r.nextInt(1000);
		//System.out.println(randomnum);
		 
		 //Read the data from the excel
		String campaign = elib.getDataFromExcel("campaignwithproduct", 1, 1)+randomnum;
		String product = elib.getDataFromExcel("campaignwithproduct", 2, 1)+randomnum;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		
		wlib.waitForElementInDOM(driver);
		
			
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		
		wlib.waitForPage(driver, URL);
		
		//WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.titleContains(title));
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	//	String wh = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[.='Products']")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(product);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		WebElement ele = driver.findElement(By.linkText("More"));
		wlib.mouseOver(driver,ele);
		
		
		
		driver.findElement(By.linkText("Campaigns")).click();
	    driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
	    driver.findElement(By.name("campaignname")).sendKeys(campaign);
	    driver.findElement(By.xpath("//img[@alt='Select']")).click();
	    
	    wlib.switchToWindow( driver , "Products&action") ;
	   
	    /*
	   Set<String> wh1 = driver.getWindowHandles();
	   Iterator<String> it1 = wh1.iterator();
	
	   while(it1.hasNext())
	   {
		   String CID = it1.next();
		   driver.switchTo().window(CID);
		   String title1 = driver.getTitle();
		   if(title1.contains("Products&action"))
		   {
			   break;
		   }   
	   }
	 */  
	   driver.findElement(By.id("search_txt")).sendKeys(product);
	   driver.findElement(By.name("search")).click();
	   driver.findElement(By.xpath("//a[.='"+product+"']")).click();
	   
	   wlib.switchToWindow( driver , "Campaign&action") ;
	   
	   /*
	   Set<String> wh2 = driver.getWindowHandles();
	   Iterator<String> it2 = wh2.iterator();
	   
	   while(it2.hasNext())
	   {
		   String CID2 = it2.next();
		   driver.switchTo().window(CID2);
		   String title2 = driver.getTitle();
		   if(title2.contains("Campaign&action"))
		   {
			   break;
		   }  
		   */
	   
		   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		   String actval = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if (actval.contains(campaign))
		   {
			   System.out.println("TC IS PASS");
		   }
		   else
		   {
			   System.out.println("TC IS FAIL");
		   }
		   WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		   wlib.mouseOver(driver,ele1);
		
		   driver.findElement(By.linkText("Sign Out")).click();
		    
		    driver.close();
			
		   }
		   
		   
	   }

