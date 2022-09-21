package com.tyss.GenericUtilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;


public class BaseAPIClass {
	/*
	 * 
	 */
	public DatabaseUtlities dLib = new DatabaseUtlities();
	public JavaUtilities jLib = new JavaUtilities();
	public RestAssuredUtilities rLib= new RestAssuredUtilities();

	@BeforeSuite
	public void bsConfig()
	{
		dLib.connectToDB("projects");
		baseURI="http://localhost";
		port=8084;
	}

	@AfterSuite
	public void asConfig()
	{
		dLib.closeDatabase();
		System.out.println("Data base closed");
	}
}


