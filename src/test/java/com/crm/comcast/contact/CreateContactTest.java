package com.crm.comcast.contact;

import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseClass;
import com.crm.comcast.pomrepository.ContactsPage;
import com.crm.comcast.pomrepository.Contactsinfo;
import com.crm.comcast.pomrepository.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {


	@Test
	
	public void ContactTest() throws Throwable 
	{
		//WebDriverManager.chromedriver().setup();
		int ranDom = jLib.getRandomNumber();
		String contactname = eLib.getDataFromExcel("Contact", 1, 0)+ranDom;
		 HomePage hp = new HomePage(driver);
		 hp.getContactsLink().click();
		 
		 ContactsPage con = new ContactsPage(driver);
		 con.getContactslink().click();
		 
		 Contactsinfo coninfo = new Contactsinfo();
		 String actualresult = coninfo.getContactinfo().getText();
		 
		 if(actualresult.contains(contactname)) {
					System.out.println(contactname + " is verified and pass");
				}
				else {
					System.out.println(contactname + " is not verified and fail");
	}
		
	}

}
