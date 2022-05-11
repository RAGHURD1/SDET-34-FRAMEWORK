package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	public CreateOrganization(WebDriver driver) {
		
		  PageFactory.initElements(driver, this);
		}
		@FindBy(name="accountname")
		private WebElement orgNameEdt;
		
		@FindBy(name="industry")
		private WebElement industypeEdt;
		
		@FindBy(xpath="//input[@title= 'Save [Alt+S]']")
		private WebElement saveBtn;
		
		public void createOrg(String orgName)
		{
		orgNameEdt.sendKeys(orgName);	
		saveBtn.click();
		}
		
		public void createindustry(String indName)
		{
		industypeEdt.sendKeys(indName);	
		saveBtn.click();
		}
		
		public void Createorginfo (String orgName)
		{
			orgNameEdt.sendKeys(orgName);
		}

		public WebElement getOrgNameEdt() {
			return orgNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}

		public WebElement getIndustype() {
			return industypeEdt;
		}

	}


