package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations { 
	
		public Organizations(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
		private WebElement createOrgImg;
		
		public WebElement getCreateOrgImg() {
			return createOrgImg;		
		}

		public WebElement getSuccussfullMsg() {
			// TODO Auto-generated method stub
			return null;
		}

		
}
	