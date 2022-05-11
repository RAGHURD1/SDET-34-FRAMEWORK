package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class HomePage {
	
	WebDriver driver;  //global driver variable
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement camapignsLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getCamapignsLink() {
		return camapignsLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	public void logout() {
		Actions act= new Actions(driver);
		act.moveToElement(administratorImg).perform();
		signOutLink.click();
	}
}
