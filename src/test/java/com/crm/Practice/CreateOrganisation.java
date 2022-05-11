package com.crm.Practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class CreateOrganisation extends BaseClass {
	
	@Test

	public void OrganizationTest() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("zy");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(5000);
		
		WebElement ele = (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		wLib.mouseOver(driver, ele);
		
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		signout.click();
		
	}

}
