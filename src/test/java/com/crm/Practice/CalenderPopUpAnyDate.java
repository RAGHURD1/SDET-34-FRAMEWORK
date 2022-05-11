package com.crm.Practice;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopUpAnyDate {
	@Test

	public void calenderpopuptest() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.makemytrip.com/");
		
		 Actions a = new Actions(driver);
		 a.moveByOffset(10, 10).click().perform();
		 
	    WebElement src = driver.findElement(By.xpath("//input[@id='fromCity']"));
		WebElement dst = driver.findElement(By.xpath("//input[@id='toCity']"));
		
		src.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
		
		driver.findElement(By.xpath("//span[@Class='langCardClose']")).click();
		
	
		Thread.sleep(2000);
		
		dst.sendKeys("chennai");
		driver.findElement(By.xpath("//p[text()='Chennai, India']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		
		for(;;)
			try {
				
				driver.findElement(By.xpath("//div[@aria-label='Wed Jun 01 2022']")).click();
				
			}
			catch (Exception e) {
				
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				
			}
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	


