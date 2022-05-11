package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {

	@FindBy(name = "lastname")
	private WebElement lastnamefld;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]'")
	private WebElement savefld;
	
	public CreateContactPage (WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastnamefld() {
		return lastnamefld;
	}

	public WebElement getSavefld() {
		return savefld;
	}
	
	public void createContact(String usernametf) {
		lastnamefld.sendKeys("kk");
		
	}
	
}
