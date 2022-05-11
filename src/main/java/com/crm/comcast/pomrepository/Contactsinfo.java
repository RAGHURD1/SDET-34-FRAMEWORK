package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contactsinfo {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement Contactinfo;

	public WebElement getContactinfo() {
		return Contactinfo;
	}

}
