package com.crm.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC005 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys("vk");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		
		 Thread.sleep(5000);
		 
		 Actions a = new Actions(driver);
		 a.moveToElement(driver.findElement(By.linkText("More"))).perform();
		 
		 driver.findElement(By.linkText("Purchase Order")).click();
		 driver.findElement(By.xpath("//img[@alt='Create Purchase Order...']")).click();
		 driver.findElement(By.name("subject")).sendKeys("RD");
		 //driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		 driver.findElement(By.id("searchIcon1")).click();
		 //driver.findElement(By.linkText("popup_product_17")).click();
		  
	}

}
