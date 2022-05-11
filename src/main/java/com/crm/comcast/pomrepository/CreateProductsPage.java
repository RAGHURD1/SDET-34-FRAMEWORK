package com.crm.comcast.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductsPage {
	
	@FindBy(name= "Productname")
	private WebElement productnamefld;
	
	@FindBy(xpath = "//input=[title='Save [Alt+S]']")
	private WebElement savebtn;
	
	public WebElement getProductnamefld() {
		return productnamefld;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public void ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ProductsPage(String usernamefld ) {
	productnamefld.sendKeys("");
	}
}
