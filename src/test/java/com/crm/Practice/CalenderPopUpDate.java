package com.crm.Practice;

import java.util.Date;

public class CalenderPopUpDate {

	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		String[] d = date.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date1 = d[2];
		String time = d[3];
		String year = d[4];
		String traveldate = day+" "+month+" "+date1+" " +time+" "+year+" " ;
		System.out.println(traveldate);
		
	}

}
