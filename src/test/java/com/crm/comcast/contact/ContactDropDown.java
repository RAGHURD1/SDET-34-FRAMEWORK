package com.crm.comcast.contact;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.genericutility.IConstants;
import com.crm.comcast.genericutility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverUtility wlib = new WebDriverUtility();
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wlib.waitForElementInDOM(driver);
		//driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("kohli");
		driver.findElement(By.xpath("//input[@type='radio'][2]")).click();
		
		Thread.sleep(5000);
		
		WebElement dd = driver.findElement(By.name("assigned_group_id"));
		wlib.select(dd, "4");
		//Select s = new Select(dd);
		//s.selectByValue("4");
		
		
		WebElement ele = (driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		wlib.mouseOver(driver,ele);
		
		WebElement signout = driver.findElement(By.linkText("Sign Out"));
		signout.click();
	}

}
