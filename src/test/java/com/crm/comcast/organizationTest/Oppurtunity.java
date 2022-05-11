package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
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
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Oppurtunity {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib = new WebDriverUtility();
		FileUTility fil = new FileUTility();
		ExcelUtility exl = new ExcelUtility();
		WebDriverManager.chromedriver().setup();
				
				 String URL = fil.getPropertyKeyValue("url");
				 String USERNAME = fil.getPropertyKeyValue("username");
				 String PASSWORD = fil.getPropertyKeyValue("password");
				 String BROWSER = fil.getPropertyKeyValue("browser");
				 
				 Random r = new Random();
				int randomnum = r.nextInt(1000);
				System.out.println(randomnum);
				 
				 //Read the data from the excel
				
				String opportunity = exl.getDataFromExcel("oppurtunity", 1, 0);
				String organization = exl.getDataFromExcel("sheet1", 1, 1);
				
				
				
				WebDriver driver = null;
				if(BROWSER.equals("chrome")) {
					driver = new ChromeDriver();
				}
				else if(BROWSER.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				
				driver.get(URL);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				String title = driver.getTitle();
				
				WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
				wait.until(ExpectedConditions.titleContains(title));
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				driver.findElement(By.linkText("Opportunities")).click();
				driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
				driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(opportunity);
				driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
				
				//switch to child window
				
				 wlib.switchToWindow( driver , "Accounts&action") ;
				/*
				Set<String> wh1 = driver.getWindowHandles();
			    Iterator<String> it1 = wh1.iterator();
			    
			    while(it1.hasNext())
			    {
			    	String cid = it1.next();
			    	driver.switchTo().window(cid);
			    	String title1 = driver.getTitle();
			    	if(title1.contains("Accounts&action"))
					   {
						   break;
					   }   
			    }
			    */
			       driver.findElement(By.id("search_txt")).sendKeys(opportunity);
				   driver.findElement(By.name("search")).click();
				   driver.findElement(By.id("1")).click();
				   
				   //switch to main window
				   wlib.switchToWindow( driver , "Potentials&action") ;
				  
					   driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
					   
					   Thread.sleep(2000);
					   
					   //verification
					   
					   String actval = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
					   if (actval.contains(opportunity))
					   {
						   System.out.println("TC IS PASS");
					   }
					   else
					   {
						   System.out.println("TC IS FAIL");
					   }
					   WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
					   wlib.mouseOver(driver, ele1);
					    driver.findElement(By.linkText("Sign Out")).click();
					    
					    driver.close();
				   }		   
			    
	}
