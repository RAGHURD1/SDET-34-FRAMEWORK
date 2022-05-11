package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetRandomData {

	public static void main(String[] args) throws IOException, InterruptedException, Throwable, InvalidFormatException {
		WebDriverUtility wlib = new WebDriverUtility();
		FileUTility fil = new FileUTility();
		ExcelUtility exl = new ExcelUtility();
		JavaUtility juil = new JavaUtility();
		
		 int randomnum = juil.getRandomNumber();
		
		//Random random = new Random();
		 //int Rannum = random.nextInt(1000);
		
		WebDriverManager.chromedriver().setup();
		
		 String URL=fil.getPropertyKeyValue("url");
		 String USERNAME= fil.getPropertyKeyValue("username");
		 String PASSWORD= fil.getPropertyKeyValue("password");
		 String BROWSER= fil.getPropertyKeyValue("browser");
		
		 String orgName = exl.getDataFromExcel("Sheet1", 1, 2);
		 
		 
		WebDriver driver = null;
		if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();}
			else if (BROWSER.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
		wlib.waitForElementInDOM(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(URL);
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				Thread.sleep(5000);
				
				driver.findElement(By.linkText("Organizations")).click();
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				Thread.sleep(5000);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				String ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(ele.equals(orgName))
				{
					System.out.println("pass");
				}
				else
				{
					System.out.println("fail");
				}
				
				Thread.sleep(5000);
				
				WebElement ele1 = (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
				wlib.mouseOver(driver, ele1);
				
				WebElement signout = driver.findElement(By.linkText("Sign Out"));
				signout.click();
			}
				
	}

