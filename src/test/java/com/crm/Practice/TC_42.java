package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_42 extends BaseClass {
	
	@Test

	public void purchaseTest() throws InterruptedException {
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		
		WebElement ele = (driver.findElement(By.linkText("More")));
		wlib.mouseOver(driver, ele);
		driver.findElement(By.linkText("Purchase Order")).click();
		
		Thread.sleep(5000);
		WebElement ele1 = (driver.findElement(By.xpath("(//td[@valign='top'])[11]")));
		wlib.mouseOver(driver, ele);
		
       WebElement ele2 = (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
       wlib.mouseOver(driver, ele2);
		
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		signout.click();
	}

}
