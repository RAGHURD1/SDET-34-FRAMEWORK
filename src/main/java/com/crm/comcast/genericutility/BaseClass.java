package com.crm.comcast.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
	public JavaUtility jLib = new JavaUtility();
	public FileUTility fLib = new FileUTility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public ExcelUtility eLib = new ExcelUtility();
	
	
	@BeforeSuite
	
	public void configBS()
	{
		System.out.println("============connect to DB=============");
	}
	
	@BeforeClass
	
	public void configBC() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = null ;
		String BROWSER = fLib.getPropertyKeyValue("browser");
		if(BROWSER.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		wLib.waitUntilPageLoad(driver);
		driver.manage().window().maximize();
		System.out.println("============launch the browser successfully=============");
	}
	
	@BeforeMethod
	
	public void configBM(String username, String password) throws Throwable
	{
		//COMMON DATA//
		String BROWSER = fLib.getPropertyKeyValue("browser");
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		//Navigate to app
		driver.get(URL);
		//wLib.waitUntilPageLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("==========logged in successfully===========");
		
	}
	
	@AfterMethod
	
	public void configAM()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
		System.out.println("============logged out successfully=============");
	}
	
	
	@AfterClass
	
	public void configAC()
	{
		driver.quit();
		System.out.println("========browser closed succcessfully==========");
	}


	@AfterSuite
	public void configAS() {
	System.out.println("========================close DB========================");
	}
}

