package com.crm.Practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crm.comcast.genericutility.DataBaseUtility;

public class Practice {
	

	public static void main(String[] args) throws Throwable {
		
		//Create an databaseutilityobject
		DataBaseUtility dlib  = new DataBaseUtility();
		//establish the connection 
		dlib.connectDB();
		//execute the query
		ResultSet resultset = dlib.executeQuery("select * from students_info");
		
		while(resultset.next()) {
			System.out.println(resultset.getString(1));
		}
		
		dlib.closeDB();
	}
}
