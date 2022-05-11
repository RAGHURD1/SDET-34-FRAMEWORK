package com.crm.comcast.organizationTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.pomrepository.CreateOrganization;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.OrganizationInfo;
import com.crm.comcast.pomrepository.Organizations;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrgTest extends BaseClass{

		// @Test(dataProvider = "data")
		@Test
		 public void createOrganizationTest(String OrgName) throws Throwable
		 {
			 
			int ranDom = jLib.getRandomNumber();
		    WebDriverManager.chromedriver().setup();
		    //TestScript Data
		    String orgName = eLib.getDataFromExcel("ORG", 1, 0) + ranDom;

		    //Navigate to organization
			
		    HomePage hp = new HomePage(driver);
		    hp.getOrganizationLink().click();
		    
		    /*Navigate to Create new Organization by clicking on + button*/
		    Organizations org=new Organizations(driver);
		    org.getCreateOrgImg().click();
		    
		    
		    //Create Organization  
		    CreateOrganization cnorg = new CreateOrganization(driver);
		    cnorg.createOrg(orgName);
		    
		    
		    /*verification*/
		    OrganizationInfo info = new OrganizationInfo(driver);
			//wLib.waitForElement(driver, info.getSuccessfullmsg());
		    String actual_Msg= info.getSuccessfullmsg().getText();
		    if(actual_Msg.contains(orgName))
		    {
		     System.out.println("Organization created --------> TC PASS");
		    }
		    else
		    {
		     System.out.println("Organization not created --------> TC FAIL");
		    }
		    
		 }
		 
		// Create data using Dataprovider
		 
		/*@DataProvider(name= "Test1.xlsx")
		 public Object[][] getdata() throws Throwable
		 {
			ExcelUtility eLib = new ExcelUtility();
			 Object[][] data = eLib.readDataForDataProvider("Sheet1");
			 return data;
		 }*/

}
