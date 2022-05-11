package com.crm.Practice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.pomrepository.CreateOrganization;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.Organizations;

public class BaseClassWithOrg extends BaseClass {
	
	@Test
	
	public void CreateOrganizationTest() throws Throwable {
		
		//get random data
		
		int randomnum = jLib.getRandomNumber();
		
		//read test date from excel file
		String orgname = eLib.getDataFromExcel("Sheet1", 1, 0)+randomnum;
		
		//STEP 1: navigate to organization page
		  
		 HomePage hp = new HomePage(driver);
		 hp.getOrganizationLink().click();
		 
		 //Step 2: navigate to create organization page
		 
		 Organizations org = new Organizations(driver);
		 org.getCreateOrgImg().click();
		 
		 //Step 3: create new org
		 
		 CreateOrganization co = new CreateOrganization(driver);
		 co.createOrg(orgname);

	}
	
	

}
