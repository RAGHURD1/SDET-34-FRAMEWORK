package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


	//RULE:1) Create a seperate java class for every page in a application

	public class LoginPage {       
	
	//RULE 3): Execute all the elements and initiliaze all the elements PageFactory.initElements(driver,this);
		
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//RULE 2): Identify all the elements
	
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({ @FindBy(id = "submitButton") , @FindBy(xpath = "//input[@id = 'submitButton']")})
	private WebElement loginBtn;
	
	//RULE 4): Declare all the elements as private and provide getters method, businessmethod for utilization

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPasswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToApp (String username, String password) {
		
		/*step 1):login*/
		
		userNameEdt.sendKeys(username);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
		
		}
	}
	