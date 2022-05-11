package com.crm.comcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crm.comcast.genericutility.DataBaseUtility;
import com.mysql.cj.jdbc.Driver;

public class Jdbc {

	public static void main(String[] args) throws SQLException {
		
	
		Connection conn = null;
		try {
			 Driver driverref = new Driver();
				
		//step:1) Register mysql the database
		DriverManager.registerDriver(driverref);
			 	
			//step 2): connect to database 
			 //database name
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		System.out.println("connection is done");
				
				//step 3): create query statement
		Statement stat = conn.createStatement();
		String query = "select * from students_info";//database name
				
				//step 4): execute the query
		ResultSet resultset = stat.executeQuery(query);
		while(resultset.next())
			{
		System.out.println(resultset.getInt(1) +"\t"+resultset.getString(2)+
				"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			
		}}
	catch (Exception e) {
	}finally {
			//step 5): close the connection
		conn.close();
		System.out.println("close the db connection");
	}	
			
		}
		
	}

