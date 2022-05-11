/*package com.crm.comcast.contact;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.ExcelUtility;
import com.crm.comcast.genericutility.FileUTility;
import com.crm.comcast.genericutility.JavaUtility;
import com.crm.comcast.genericutility.WebDriverUtility;
import com.crm.comcast.pomrepository.ContactsPage;
import com.crm.comcast.pomrepository.HomePage;
import com.crm.comcast.pomrepository.LoginPage;

public class DeleteContactTest {
		@Test
			public void deleteContactTest() throws Throwable {
				WebDriverUtility wlib=new WebDriverUtility();
				FileUTility flib=new FileUTility();
				JavaUtility jlib=new JavaUtility();
				ExcelUtility elib=new ExcelUtility();
				String url = flib.getPropertyKeyValue("url");
				String browser = flib.getPropertyKeyValue("browser");
		       
		        
				 int randomnum = jlib.getRandomNumber();
				
				 String lastname = elib.getDataFromExcel("sheet1", 1, 3)+randomnum;
				 WebDriver driver=null ;
					if(browser.equals("chrome"))
					{
						driver=new ChromeDriver();
					}
					else  {
						driver=new FirefoxDriver();
					}
					
					driver.get(url);
				 HomePage hp=new HomePage(driver);
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(lastname, lastname);
			   
			    hp.getContactsLink().click();
				ContactsPage cp=new ContactsPage(driver);
				cp.getcreatecontactsImg().click();
				wlib.waitForPage(driver, "Contacts&action");
				CreateNewContact cnp=new CreateNewContact(driver);
				cnp.createcontact(lastname);
				ContactsPage cip=new ContactsPage(driver);
				String actsuccmsg = cip.getsuccessfullmsg().getText();
				
				 if(actsuccmsg.contains(lastname)) {
					 System.out.println("contact is verified and pass");
				 }
				 else {
					 System.out.println(" contact is not verified and fail");
				 }
				 hp.getContactsLink().click();
				cnp.deletecontact(lastname);
				wlib.acceptAlert(driver);
				String delmsg = cip.getdeletedmsg().getText();
				System.out.println(delmsg);
				if(delmsg.equals("No Contact Found !")) {
					System.out.println("contact  deleted successfully");
				}
				else {
					System.out.println("contact not deleted successfully");
					
				}
				hp.logout();
			}
		}*/

