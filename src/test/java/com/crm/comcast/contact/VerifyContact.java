package com.crm.comcast.contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyContact {

	public static void main(String[] args) throws Throwable {
		WebDriverUtility wlib = new WebDriverUtility();
		FileUTility flib = new FileUTility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		
        WebDriverManager.chromedriver().setup();
       
		//To get the java representation object of the physical file
        
        String URL = flib.getPropertyKeyValue("url");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		
	    int randomnum = jlib.getRandomNumber();
		
		//Random ran = new Random();
		//int randomnum = ran.nextInt(100);
		//System.out.println(randomnum);
		
		//Read the value using getproperty("key")
		
	    String contacts = elib.getDataFromExcel("Contact", 1, 0)+randomnum;
	    
		/*FileInputStream fis1 = new FileInputStream("./data/Book3.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis1);
		Sheet sheet = wb1.getSheet("Contact");
		Row row = sheet.getRow(1);
		String contacts = row.getCell(0).getStringCellValue()+randomnum;*/
		
		WebDriver driver = null ;
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(contacts);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		String actvalue = driver.findElement(By.className("dvHeaderText")).getText();
		if(actvalue.contains(contacts))
		{
			System.out.println("pass:contact is created");
		}
		else
		{
			System.out.println("fail:contact is not created");
		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.name("search_text")).sendKeys(contacts);
		
		 WebElement ele = driver.findElement(By.name("search_field"));
		 wlib.select(ele,"lastname");
		//Select s = new Select(ele);
		//ele.click();
		
		//s.selectByValue("lastname");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.name("selected_id")).click();
		driver.findElement(By.xpath("//input[@value='Delete']")).click();
		
		wlib.acceptAlert(driver);
	}
	

}
