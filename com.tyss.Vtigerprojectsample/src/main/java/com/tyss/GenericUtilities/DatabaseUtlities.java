package com.tyss.GenericUtilities;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;


/**
 * 
 * @author Nirmala
 *
 */
public class DatabaseUtlities {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;
	/**
	 * 
	 * @param DBname
	 */
	public void connectToDB(String DBname)
	{
		try
		{
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection(IConstants.Durl+DBname,IConstants.DBUsername,IConstants.DBPassword);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
		public void connectToDatabase()
		{
			System.out.println("database connection is successful");
		}
		/**
		 * Closing DB
		 */
		public void closeDatabase()
		{
			System.out.println("close DB connection");
		}
	


	public void closeDBConnection()
	{
		try
		{
			connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param query
	 * @param colNum
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public boolean executeQuery(String query,int colNum,String expectedData) throws SQLException
	{
		connection.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if(result.getString(colNum).equals(expectedData))
			{
				flag=true;
				break;	
			}


		}
		if(flag)
		{
			System.out.println("Data is Present");
			return flag;
		}
		else
		{
			System.out.println("Data not Present");
			return flag;
		}

	}
	/**
	 * 
	 * @param query
	 * @throws SQLException
	 */

	public void exceuteUpdate(String query) throws SQLException
	{
		int result=connection.createStatement().executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data Updated");
		}
		else
		{
			System.out.println("Data not Updated");
		}
	}

}
