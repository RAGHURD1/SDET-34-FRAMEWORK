package com.crm.comcast.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Tausif
 *
 */
public class JavaUtility {

	
	/**
 * it is used to generate random number
 * @return int data
 */
	public int getRandomNumber()
	{
		Random random=new Random();
		int ranDom = random.nextInt();
		return ranDom;
	}
	
	
	/**
	 * used to get system date and time in IST format
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date=new Date();
		return date.toString();
	}
	
	
	/**
	 * used to get system date in YYYY-MM-DD format
	 * @return YYYY-MM-DD
	 */
	public String getSystemDateWithFormat() {
		Date date=new Date();
		String DateAndTime = date.toString();
		String YYYY = DateAndTime.split(" ")[5];
		String DD = DateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		String FinalFormat=YYYY+"-"+MM+"-"+DD;
		return FinalFormat;
	}
}
