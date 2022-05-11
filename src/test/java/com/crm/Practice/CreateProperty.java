package com.crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProperty {
	
	@Test

	public  void PropertyTest() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		
		//To get the java representation object of the physical file
		
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		
		//Create an object to Property class to load all the keys
		
		Properties p = new Properties();
		p.load(fis);
		
		//Read the value using getproperty("key")
		
		String URL = p.getProperty("url");
		String USERNAME  = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		String BROWSER = p.getProperty("browser");
		
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
		
	}

}
