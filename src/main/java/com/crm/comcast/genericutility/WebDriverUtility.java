package com.crm.comcast.genericutility;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

		
		/**
		 * this method wait for 20 sec for page loading
		 * @param driver
		 */
		public void waitForElementInDOM(WebDriver driver) 
	   {
		   driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITLY_TIMEOUT, TimeUnit.SECONDS);
		   
	   }
	   
		public void waitForPage(WebDriver driver , String partailPageURL) {
			WebDriverWait wait = new WebDriverWait(driver, IConstants.EXPLICITLY_TIMEOUT);
			wait.until(ExpectedConditions.urlContains(partailPageURL));
		}



	   /**
	    * This method wait for the element to be visible
	    * @param driver
	    * @param element
	    * 
	    */
	   
	   public void waitForElementVisibility(WebDriver driver,WebElement element)
	   {
		  WebDriverWait wait = new WebDriverWait(driver, 20);
		  wait.until(ExpectedConditions.visibilityOf(element));
	   }


	   /**
	    * this methods enables user to handle dropdown using visible text
	    * @param element
	    * @param option
	    */
    
	   public void select(WebElement element, String option)
	   {
	   Select select=new Select(element);
	   select.selectByVisibleText(option);
	   
	   }
	

	   /**
	    * this methods enables user to handle dropdown using index
	    * @param element
	    * @param index
	    */
   
	   public void select(WebElement element, int index)
	   {
	   Select select=new Select(element);
	   select.selectByIndex(index);   
	   }



	/**
	 * This method will perform mouse over action
	 * @param driver
	 * @param element
	 */

	public void mouseOver(WebDriver driver,WebElement element)
	{
	   Actions act = new Actions(driver);
	   act.moveToElement(element).perform();
	   
	}

	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
	   }

	   /**
	    * This method helps to switch from one window to another
	    * @param driver
	    * @param partialWinTitle
	    */
	   public void switchToWindow(WebDriver driver, String partialWinTitle)
	   {
		   Set<String> window = driver.getWindowHandles();
		   java.util.Iterator<String> it = window.iterator();
		   while(it.hasNext())
		   {
			   String winId=it.next();
			   String title=driver.switchTo().window(winId).getTitle();
	           if(title.contains(partialWinTitle))
	           {
	        	   break;
	           }
		   }
	   }
			   

		   /**
		    * Accept alert 
		    * @param driver
		    */
		   
		   public void acceptAlert(WebDriver driver)
		   {
		   /**
		    * Cancel Alert
		    * @param driver
		    */
		   }
		   public void cancelAlert(WebDriver driver)
		   {
			   driver.switchTo().alert().dismiss();
		   }
		   
		   
		   /**
		    * This method used for scrolling action in a webpage
		    * @param driver
		    * @param element
		    */
		   public void scrollToWebElement(WebDriver driver, WebElement element) {
			   JavascriptExecutor js=(JavascriptExecutor)driver;
			  int y= element.getLocation().getY();
			   js.executeScript("window.scrollBy(0,"+y+")", element);
		   }
		   
		   
		    public void switchFrame(WebDriver driver,int index) {
		    	driver.switchTo().frame(index);
		    }   
		    
		    public void switchFrame(WebDriver driver,WebElement element) {
		    	driver.switchTo().frame(element);
		    } 
			
		    public void switchFrame(WebDriver driver,String idOrName) {
		    	driver.switchTo().frame(idOrName);
		    }

			public void waitUntilPageLoad(WebDriver driver) {
				// TODO Auto-generated method stub
				
			}

		    
			} 
