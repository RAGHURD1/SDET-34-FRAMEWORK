package com.crm.comcast.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	
	static Driver driver;
	static Connection connection;
	static ResultSet result;
    
	/**
	 * This method will perform the mysql database connection
	 * @throws SQLException 
	 */
	public void connectDB() throws SQLException {
		try {
			//driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(IConstants.JDBC_URL_STRING, IConstants.JDBC_URL_USERNAME, IConstants.JDBC_URL_PASSWORD);
		} catch (SQLException e) {
		}
	}
	/**
	 * This method will close the mysql database
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
		  connection.close();
		}catch (Exception e) {
		}


	}
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public ResultSet executeQuery(String query) throws Throwable {	
			result = connection.createStatement().executeQuery(query);
			return result;		
	}
	
	/**
	 * This method will execute the query
	 * @param query
	 * @return
	 * @throws Throwable
	 */
	public int executeUpdate(String query) throws Throwable {
		
			int result = connection.createStatement().executeUpdate(query);
	
		return result;

	}
	/**
	 * This method will execute query based on query and it will verify the data. 
	 * @param querry
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws Throwable
	 */
	public boolean executeQueryAndVerify(String query,int columnIndex,String expectedData) throws Throwable {
		boolean flag=false;
		result=connection.createStatement().executeQuery(query);
		while(result.next()) {
			if(result.getString(columnIndex).equals(expectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expectedData+"==>Data is verified in the database table");
			return flag;
		}else {
			System.out.println(expectedData+"==>data is not verified in the database");
			return flag;
		}
	}
}



