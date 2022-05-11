package com.crm.comcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class NonSelect {

	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		int result=0;
		try {
	//step1: create object for driver class
	Driver driver=new Driver();
	
	//step2: Register the Driver with JDBC
	DriverManager.registerDriver(driver);
	
	//step3: establish the database connection
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
			

	//step4: create statement
	Statement statement = connection.createStatement();
	
	//step5: execute query
     result=statement.executeUpdate("insert into project values('TY_PROJ_002','RD','28/01/2022','project_104','On Going',2)");
    
		}catch(Exception e) {
		}finally {
			if(result==1) {
				System.out.println("Project inserted");
			}else {
				System.out.println("Project not inserted");
			}
			
			//step6: close the connection
			connection.close();
			}
		}
	
			 
	}


